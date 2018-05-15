/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;

import com.github.sellersj.artifactchecker.model.App;
import com.github.sellersj.artifactchecker.model.ArtifactAttributes;
import com.github.sellersj.artifactchecker.model.owasp.Vulnerability;
import com.github.sellersj.artifactchecker.model.security.SecurityVulnerability;

/**
 * If you want to run this from maven, then you can (maybe not with quotes)
 * <code>exec:java -Dexec.mainClass="com.github.sellersj.artifactchecker.ReportBuilder"</code>
 *
 * @author sellersj
 *
 */
public class ReportBuilder {

    /**
     * This might not run well on windows since it has a max path size of 260 chars and when the project is run, it
     * checks out git projects. Path lengths can get quite long.
     *
     * If you want to run this WITHOUT doing the clone and checks against the project, set the env variable SKIP_CLONE
     * to a.
     *
     * @param args
     */
    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        watch.start();

        String toolsHost = System.getenv(Constants.TOOLS_HOST);
        if (StringUtils.isBlank(toolsHost)) {
            System.err.println("The env variable TOOLS_HOST has to be set. Exiting");
            return;
        }

        String location = "https://" + toolsHost + "/deployed-to/manifest-combined.txt";
        Set<ArtifactAttributes> apps = ReportBuilder.generateAppInventory(location);

        DownloadArtifacts downloadArtifacts = new DownloadArtifacts();

        Set<ArtifactAttributes> filtered = getAppsFilteredByCloneUrlAndHash(apps);

        String skipClone = System.getenv(Constants.SKIP_CLONE);
        if (StringUtils.isBlank(skipClone)) {

            for (ArtifactAttributes gav : filtered) {
                downloadArtifacts.cloneAndCheckProject(gav);
            }
        }

        // populate the artifacts that we've not actually cloned
        updateAppsTrackedByAnotherArtifact(apps);

        // merge the info from what's deployed
        String applicationsUrl = System.getenv(Constants.APPLICATIONS_URL);
        if (StringUtils.isNotBlank(applicationsUrl)) {
            AppFileParser parser = new AppFileParser();
            List<App> deployedApp = parser.parseAppFile(applicationsUrl);
            mergeInfoFromProd(apps, deployedApp);
        } else {
            System.err.println("Url of the application url is not set. Not going to merge deployment info. Set "
                + Constants.APPLICATIONS_URL + " env variable for this to work.");
        }

        // generate a file that's a vulnerability first view
        File securityReportFile = new File(DownloadArtifacts.FILES_GENERATED + "/security-report.html");
        generateCveFile(apps, securityReportFile);

        // make the output json
        File target = new File(DownloadArtifacts.FILES_GENERATED + "/app-inventory.json");
        ReportBuilder.buildJsonReport(apps, target);

        // copy the html report file
        String htmlFilename = "/app-inventory.html";
        File htmlFile = InventoryFileUtil.getFileOnClasspath(htmlFilename);
        try {
            FileUtils.copyFile(htmlFile, new File(DownloadArtifacts.FILES_GENERATED + htmlFilename));
        } catch (IOException e) {
            throw new RuntimeException(
                "Couldn't copy files from " + htmlFile + " to " + DownloadArtifacts.FILES_GENERATED + htmlFilename, e);
        }

        // move all the files in the output directory into the final place to be picked up by apache
        File srcDir = new File(DownloadArtifacts.FILES_GENERATED);
        File destDir = new File("/data00/bamboo/projectsites/app-inventory/");
        try {
            // delete the target directory to clear out old files
            FileUtils.deleteDirectory(destDir);

            FileUtils.copyDirectory(srcDir, destDir);
            System.out.println("Copied files from " + srcDir + " to " + destDir);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't copy files from " + srcDir + " to " + destDir, e);
        }

        watch.stop();
        System.out.println("The total build took: " + watch);
    }

    /**
     * This will try to map the values scraped from the manifests with the values we get out of the env
     *
     * @param artifacts to check
     * @param deployedApp with info to see if we can merge it
     */
    private static void mergeInfoFromProd(Set<ArtifactAttributes> artifacts, List<App> deployedApp) {

        for (ArtifactAttributes attributes : artifacts) {

            for (App app : deployedApp) {

                // match on the artifactId and the version
                if (app.getPossibleArtifactIds().contains(attributes.getArtifactId())
                    && app.containsVersion(attributes.getVersion())) {

                    System.out.println("Matching " + attributes.buildGitCloneUrl() + " with deployment " + app);
                    attributes.setDeploymentInfo(app);

                    // track which apps were matched
                    app.setAppLinked(true);
                    break;
                }
            }

            if (null == attributes.getDeploymentInfo()) {
                System.out.println("Couldn't find deployment info for artifactId " + attributes.getArtifactId()
                    + " version " + attributes.getVersion());
            }
        }

        System.out.println("Applications deployed that are not linked to maven application are:");
        for (App app : deployedApp) {
            if (!app.isAppLinked()) {
                System.out.println(app);
            }
        }
    }

    /**
     * This will check the apps that are marked as being covered by another artifact, and then find it and copy their
     * reports (cve, java 8, etc) over.
     *
     * @param apps
     */
    public static void updateAppsTrackedByAnotherArtifact(Set<ArtifactAttributes> apps) {
        for (ArtifactAttributes app : apps) {

            if (app.isAlreadyTrackedByAnother()) {

                for (ArtifactAttributes unfiltered : apps) {

                    // if we've found the unfiltered repo and it matches all the scm info, we should have a match
                    if (!unfiltered.isAlreadyTrackedByAnother() && unfiltered.hasRequiredGitInfo() && //
                        unfiltered.getScmProject().equals(app.getScmProject()) && //
                        unfiltered.getScmRepo().equals(app.getScmRepo()) && //
                        unfiltered.getScmHash().equals(app.getScmHash()) //
                    ) {

                        // since we've found the artifact that's been checked, copy over the cve and java 8 stuff
                        app.setVulnerabilities(unfiltered.getVulnerabilities());
                        app.setJava8Ready(unfiltered.isJava8Ready());
                    }

                }
            }

        }

    }

    /**
     * Some projects have multiple ears deployed to prod, but the same git repository. This will filter based on the
     * clone url and commit hash.
     *
     * @return
     */
    public static Set<ArtifactAttributes> getAppsFilteredByCloneUrlAndHash(Set<ArtifactAttributes> apps) {
        Set<ArtifactAttributes> filtered = new HashSet<>();

        HashSet<String> trackedCloneUrls = new HashSet<>();

        for (ArtifactAttributes artifactAttributes : apps) {
            // only check if it's a duplicate if it's got the git info
            if (artifactAttributes.hasRequiredGitInfo()) {

                String cloneUrlWithHash = artifactAttributes.buildGitCloneUrl() + "+" + artifactAttributes.getScmHash();
                if (trackedCloneUrls.contains(cloneUrlWithHash)) {
                    artifactAttributes.setAlreadyTrackedByAnother(true);
                    System.out.println("Not going to clone already tracking project " + artifactAttributes);
                } else {
                    trackedCloneUrls.add(cloneUrlWithHash);
                    filtered.add(artifactAttributes);
                }

            } else {
                filtered.add(artifactAttributes);
            }
        }

        return filtered;
    }

    public static void buildJsonReport(Set<ArtifactAttributes> apps, File outFile) {
        System.out.println("The number of apps is at least " + apps.size());
        InventoryFileUtil.write(outFile, apps);
    }

    public static Set<ArtifactAttributes> generateAppInventory(String location) {
        URL url;
        try {
            url = new URL(location);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Couldn't make a url from " + location, e);
        }

        Set<ArtifactAttributes> apps = InventoryFileUtil.readMergedManifests(url);
        return apps;
    }

    /**
     * Generates a report that's specific to security issues
     *
     * TODO this would be much better using a template / json output to separate data from view
     *
     * @param apps that are found
     * @param securityReportFile the file to write to
     */
    public static void generateCveFile(Set<ArtifactAttributes> apps, File securityReportFile) {
        // for all the maps, make a map using the vulnerabilities and all the apps that have been flagged for that
        SortedMap<SecurityVulnerability, List<ArtifactAttributes>> map = mapAppsToCve(apps);

        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>\n<html lang='en'><head><meta charset=\"UTF-8\">"
            + "<title>Security View of Applications</title>\n</head>\n<body>");
        builder.append("<h1>Security issues</h1>\n");

        for (Entry<SecurityVulnerability, List<ArtifactAttributes>> entry : map.entrySet()) {
            String cveName = entry.getKey().getName();

            // anchor
            builder.append(String.format("<a id='%s'></a>", cveName));
            // header, linking to external site
            builder.append(
                String.format("<h2><a href=\"https://nvd.nist.gov/vuln/detail/%s\">%s</a></h2>\n", cveName, cveName));

            // write some things about the vul
            builder.append("<p>\n");
            builder.append("Score: " + entry.getKey().getScore() + "<br/>\n");
            builder.append("Severity: " + entry.getKey().getSeverity() + "<br/>\n");
            builder.append("Description: " + entry.getKey().getDescription() + "<br/>\n");
            builder.append("</p>\n");

            // what apps have the issue
            builder.append("<table style=\"width:100%\">\n");

            // TODO put in table headings
            builder.append("<tr>");
            builder.append("<th>Sever</th>");
            builder.append("<th>Jira</th>");
            builder.append("<th>Artifact</th>");
            builder.append("<th>CVE Security Report</th>");
            builder.append("</tr>\n<tbody>");

            for (ArtifactAttributes artifactAttributes : entry.getValue()) {
                builder.append("<tr>");

                // if public
                td(builder, true);
                if (artifactAttributes.isPublic()) {
                    builder.append("<strong>PUBLIC</strong>");
                } else {
                    builder.append("internal");
                }
                td(builder, false);

                // jira key if we have it
                td(builder, true);
                if (StringUtils.isNotEmpty(artifactAttributes.getJiraKey())) {
                    builder.append(String.format(" <a href='%s'>%s</a> ", artifactAttributes.getJiraUrl(),
                        artifactAttributes.getJiraKey()));
                } else {
                    builder.append("&nbsp;");
                }
                td(builder, false);

                // link to nexus with the app name
                td(builder, true);
                builder.append(String.format(" <a href='%s'>%s</a> ", artifactAttributes.getNexusUrl(),
                    artifactAttributes.getTitle()));
                td(builder, false);

                // link to nexus with the app name
                td(builder, true);
                builder.append(
                    String.format(" <a href='%s'>report</a> ", artifactAttributes.getOwaspDependencyCheckUrl()));
                td(builder, false);

            }
            builder.append("</tr>\n</tbody>\n</table>\n");
        }

        builder.append("\n</body></html>\n");
        try {
            FileUtils.writeStringToFile(securityReportFile, builder.toString(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Could not write the file " + securityReportFile, e);
        }
    }

    private static void td(StringBuilder builder, boolean start) {
        if (start) {
            builder.append("<td>\n");
        } else {
            builder.append("</td>\n");
        }
    }

    /**
     * This will map the apps to the cve so we can have a different view on the code.
     *
     * @param apps to map
     */
    private static SortedMap<SecurityVulnerability, List<ArtifactAttributes>> mapAppsToCve(Set<ArtifactAttributes> apps) {
        SortedMap<SecurityVulnerability, List<ArtifactAttributes>> map = new TreeMap<>();

        for (ArtifactAttributes artifactAttributes : apps) {
            for (Vulnerability vul : artifactAttributes.getVulnerabilities()) {

                // check if the key already exist
                SecurityVulnerability key = new SecurityVulnerability(vul);

                // if the map doesn't contain the key, init the list
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<ArtifactAttributes>());
                }

                // now the key will always exist in the map and we'll add this app to the list
                map.get(key).add(artifactAttributes);
            }
        }

        return map;
    }

}
