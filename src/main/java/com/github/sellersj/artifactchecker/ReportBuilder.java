/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.commons.text.StringEscapeUtils;

import com.github.sellersj.artifactchecker.model.App;
import com.github.sellersj.artifactchecker.model.ArtifactAttributes;
import com.github.sellersj.artifactchecker.model.MailSource;
import com.github.sellersj.artifactchecker.model.MavenGAV;
import com.github.sellersj.artifactchecker.model.ParsedDataSource;
import com.github.sellersj.artifactchecker.model.owasp.KnownExploitedVulnerability;
import com.github.sellersj.artifactchecker.model.owasp.Vulnerability;
import com.github.sellersj.artifactchecker.model.security.ArtifactAttributesComparator;
import com.github.sellersj.artifactchecker.model.security.SecurityVulnerability;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

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

        String toolsHost = Constants.getSysOrEnvVariable(Constants.TOOLS_HOST);
        if (StringUtils.isBlank(toolsHost)) {
            System.err.println("The env variable TOOLS_HOST has to be set. Exiting");
            return;
        }
        String cipoHost = Constants.getSysOrEnvVariable(Constants.WAS_CIPO_HOST);
        if (StringUtils.isBlank(toolsHost)) {
            System.err.println("The env variable WAS_CIPO_HOST has to be set. Exiting");
            return;
        }

        String location = "https://" + toolsHost + "/deployed-to/manifest-combined.txt";
        Set<ArtifactAttributes> apps = ReportBuilder.generateAppInventory(location);
        try {
            apps.addAll(InventoryFileUtil
                .readMergedApplicationListing(URI.create("https://" + cipoHost + "/app_version.txt").toURL()));
        } catch (MalformedURLException e1) {
            throw new RuntimeException("Could not read the ked app file", e1);
        }

        String pomCombined = "https://" + toolsHost + "/deployed-to/pom-info-combined.txt";
        ReportBuilder.repairArtifactList(pomCombined, apps);

        DownloadArtifacts downloadArtifacts = new DownloadArtifacts();

        Set<ArtifactAttributes> filtered = getAppsFilteredByCloneUrlAndHash(apps);

        String skipClone = Constants.getSysOrEnvVariable(Constants.SKIP_CLONE, false);
        if (StringUtils.isBlank(skipClone)) {
            int size = filtered.size();
            System.out.println(String.format("Going to attempt to clone out %s projects", size));
            int count = 1;
            for (ArtifactAttributes gav : filtered) {
                System.out.println(String.format("Clone project %s of %s which is %s %s", count++, size,
                    gav.getScmProject(), gav.getScmRepo()));

                downloadArtifacts.cloneAndCheckProject(gav);
            }
        }

        // populate the artifacts that we've not actually cloned
        updateAppsTrackedByAnotherArtifact(apps);

        // merge the info from what's deployed
        String wasInfoUrl = Constants.getSysOrEnvVariable(Constants.WAS_INFO_HOST, false);
        if (StringUtils.isNotBlank(wasInfoUrl)) {
            AppFileParser parser = new AppFileParser();
            List<App> deployedApp = parser.parseAppFile(wasInfoUrl + "applications");
            mergeInfoFromProd(apps, deployedApp);

            // get the datasource info
            DataSourceFileParser dsParser = new DataSourceFileParser();
            List<ParsedDataSource> parseDataSource = dsParser.parseDataSourceFile(wasInfoUrl + "dataSources");
            mergeDataSourceInfoFromProd(apps, parseDataSource);

            // get the mailSource info
            MailSourceFileParser msParser = new MailSourceFileParser();
            List<MailSource> mailSources = msParser.parseMailSourceFile(wasInfoUrl + "mailSourceData");
            mergMailSourceInfoFromProd(apps, mailSources);

            // write all the data sources
            File allDSTarget = new File(DownloadArtifacts.FILES_GENERATED + "/datasources.csv");
            ReportBuilder.buildCsvReportOfDataSources(parseDataSource, allDSTarget);

            // now let's write the unmapped files
            List<ParsedDataSource> unmapped = dsParser.getUnmappedDataSources(parseDataSource, apps);
            File unmappedDSTarget = new File(DownloadArtifacts.FILES_GENERATED + "/unmapped-datasources.csv");
            ReportBuilder.buildCsvReportOfDataSources(unmapped, unmappedDSTarget);
        } else {
            System.err.println("Url of the application url is not set. Not going to merge deployment info. Set "
                + Constants.WAS_INFO_HOST + " env variable for this to work.");
        }

        InventoryFileUtil.fillInDecomissionedInfo(apps);

        // generate a file that's a vulnerability first view
        File securityReportFile = new File(DownloadArtifacts.FILES_GENERATED + "/security-report.html");
        generateCveFile(apps, securityReportFile);

        // make the output json
        File target = new File(DownloadArtifacts.FILES_GENERATED + "/app-inventory.json");
        ReportBuilder.buildJsonReport(apps, target);
        File csvTarget = new File(DownloadArtifacts.FILES_GENERATED + "/app-inventory.csv");
        ReportBuilder.buildCsvReport(apps, csvTarget);

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

        File destDir = new File(getDestinationPath());
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
     * Get a destination, override it if needed (like for testing).
     *
     * @return the path to write files to.
     */
    private static String getDestinationPath() {
        String destinationDirPath = "/data00/bamboo/projectsites/app-inventory/";
        String overridePath = Constants.getSysOrEnvVariable(Constants.DEST_DIR_OVERRIDE, false);
        if (StringUtils.isNotBlank(overridePath)) {
            System.out.println("Overriding path to " + overridePath);
            destinationDirPath = overridePath;
        }

        return destinationDirPath;
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

        // TODO here's where we'd match an app for the missing ones... how?

        System.out.println("Applications deployed that are not linked to maven application are:");
        for (App app : deployedApp) {
            if (!app.isAppLinked()) {
                System.out.println(app);

                // we are going to keep track of the artifact to
                ArtifactAttributes attribute = null;

                // now go through all the apps that we have, and check for one that matches, then copy all the info
                // over. This is in case of another deployment that matches the info
                for (ArtifactAttributes artifactToCheck : artifacts) {
                    if (app.getPossibleArtifactIds().contains(artifactToCheck.getArtifactId())
                        && app.containsVersion(artifactToCheck.getVersion())) {

                        System.out.println(
                            "Matching Extra app " + artifactToCheck.buildGitCloneUrl() + " with deployment " + app);

                        attribute = new ArtifactAttributes(artifactToCheck);
                        // clear out the deployment info
                        attribute.setDeploymentInfo(null);
                    }
                }

                if (null == attribute) {
                    // if we had not found anything at all, make a placeholder entry with the deployment name as the
                    // title.

                    attribute = new ArtifactAttributes();
                    // fake out the manifest title with the WAS app name
                    String appName = app.getAttributes().get(App.APP_KEY).get(0);
                    attribute.getManifest().put(ArtifactAttributes.IMPLEMENTATION_TITLE, appName);
                    attribute.setLibraryCheckedWorked(false);

                    // set the tech owner for the very old apps where we don't have the other info
                    if (appName.startsWith("CIPO")) {
                        attribute.setTechOwner("CIPO");
                    }
                }

                // now make sure that we add back in the deployment info, because that's actually what's different
                attribute.setDeploymentInfo(app);

                artifacts.add(attribute);
            }
        }
    }

    /**
     * This will try to map the values scraped from the manifests with the values we get out of the env
     *
     * @param artifacts to check
     * @param dataSources with info to see if we can merge it
     */
    private static void mergeDataSourceInfoFromProd(Set<ArtifactAttributes> artifacts,
                                                    List<ParsedDataSource> dataSources) {

        for (ArtifactAttributes attributes : artifacts) {
            for (ParsedDataSource ds : dataSources) {

                // match the data source info with the app
                if (ds.getAppNames().contains(attributes.getDeploymentName())) {
                    attributes.getLinkedDataSources().add(ds);
                }
            }

            // TODO it might be better to swap this out to use a map
            // now check the jndi names we have
            for (String possibleJndiName : attributes.getPossibleJndiNames()) {
                for (ParsedDataSource ds : dataSources) {
                    // match the data source info with the app
                    if (possibleJndiName.equals(ds.getJndiName())) {
                        attributes.getLinkedDataSources().add(ds);
                    }
                }
            }
        }
    }

    /**
     * This will try to map the values scraped from the manifests with the values we get out of the env
     *
     * @param artifacts to check
     * @param mailSources with info to see if we can merge it
     */
    private static void mergMailSourceInfoFromProd(Set<ArtifactAttributes> artifacts, List<MailSource> mailSources) {

        for (ArtifactAttributes attributes : artifacts) {
            for (MailSource mailSource : mailSources) {

                // match the data source info with the app
                if (mailSource.getAppNames().contains(attributes.getDeploymentName())) {
                    attributes.getLinkedMailSources().add(mailSource);
                }
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

                    // if we've found the unfiltered repo and it matches all the scm info, we should
                    // have a match
                    if (!unfiltered.isAlreadyTrackedByAnother() && unfiltered.hasRequiredGitInfo() && //
                        unfiltered.hasSameGitInfo(app)) {

                        // since we've found the artifact that's been checked, copy over the cve and
                        // java 8 stuff
                        app.setVulnerabilities(unfiltered.getVulnerabilities());
                        app.setJava8Ready(unfiltered.isJava8Ready());
                        app.setLibraryCheckedWorked(unfiltered.isLibraryCheckedWorked());
                        app.setTechOwner(unfiltered.getTechOwner());
                        app.setScmTag(unfiltered.getScmTag());
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

                String cloneUrlWithHash = artifactAttributes.getUniqueStringForGitInfoAndVersion();
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

    public static void buildCsvReport(Set<ArtifactAttributes> apps, File outFile) {
        System.out.println("The number of apps is at least " + apps.size());
        // make the file if it doesn't exist
        outFile.getParentFile().mkdirs();
        try (Writer writer = Files.newBufferedWriter(outFile.toPath());) {
            StatefulBeanToCsv<ArtifactAttributes> beanToCsv = new StatefulBeanToCsvBuilder<ArtifactAttributes>(writer)
                .build();
            ArrayList<ArtifactAttributes> appList = new ArrayList<>(apps);
            beanToCsv.write(appList);
        } catch (Exception e) {
            throw new RuntimeException("Could not write the csv file for apps in production ", e);
        }
    }

    /**
     *
     * @param unmapped to write to the file
     * @param outFile the file to write to
     */
    public static void buildCsvReportOfDataSources(List<ParsedDataSource> unmapped, File outFile) {
        System.out.println("The number of datasources is " + unmapped.size());
        // make the file if it doesn't exist
        outFile.getParentFile().mkdirs();
        try (Writer writer = Files.newBufferedWriter(outFile.toPath())) {
            StatefulBeanToCsv<ParsedDataSource> beanToCsv = new StatefulBeanToCsvBuilder<ParsedDataSource>(writer)
                .build();
            beanToCsv.write(unmapped);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Could not write the csv file %s for datasources ", outFile), e);
        }
    }

    public static Set<ArtifactAttributes> generateAppInventory(String location) {
        URL url;
        try {
            url = URI.create(location).toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Couldn't make a url from " + location, e);
        }

        Set<ArtifactAttributes> apps = InventoryFileUtil.readMergedManifests(url);
        return apps;
    }

    public static void repairArtifactList(String pomCombined, Set<ArtifactAttributes> apps) {
        URL url;
        try {
            url = URI.create(pomCombined).toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Couldn't make a url from " + pomCombined, e);
        }

        Set<MavenGAV> gavs = InventoryFileUtil.readMergedPomFiles(url);
        for (ArtifactAttributes artifactAttributes : apps) {
            if (StringUtils.isBlank(artifactAttributes.getGroupId())) {
                System.out.println("Going to repair " + artifactAttributes);

                // match it against the correct artifactId and version
                for (MavenGAV gav : gavs) {
                    if (gav.getArtifactId().equals(artifactAttributes.getCorrectedArtifactId()) && //
                        gav.getVersion().equals(artifactAttributes.getVersion())) {

                        System.out.println("Setting the groupId to " + gav.getGroupId());
                        artifactAttributes.setCorrectedGroupId(gav.getGroupId());
                    }
                }
            }
        }
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
        // for all the maps, make a map using the vulnerabilities and all the apps that have been
        // flagged for that
        SortedMap<SecurityVulnerability, Set<ArtifactAttributes>> map = mapAppsToCve(apps);

        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>\n<html lang='en'><head><meta charset=\"UTF-8\">"
            + "<title>Security View of Applications in production</title>\n");
        // put in style here
        builder.append("<style>\n");
        builder.append("body { font-family: sans-serif; }\n");
        builder.append("tr:nth-child(even) {background-color: #f2f2f2;}\n");
        builder.append("</style>\n");
        builder.append("</head>\n<body>");
        builder.append("<h1>Security issues in production</h1>\n");

        for (Entry<SecurityVulnerability, Set<ArtifactAttributes>> entry : map.entrySet()) {
            String cveName = entry.getKey().getName();

            // header, linking to external site
            if (cveName.startsWith("CVE-")) {
                builder.append(
                    String.format("<a id=\"%s\"></a><h2><a href=\"https://nvd.nist.gov/vuln/detail/%s\">%s</a></h2>\n",
                        cveName, cveName, cveName));
            } else {
                // replace non-alpha numeric chars in the anchor
                String id = cveName.replaceAll("[^A-Za-z0-9]", "-").toLowerCase(Locale.CANADA);
                builder.append(String.format("<a id=\"%s\"></a><h2>%s</h2>\n", id, cveName));
            }

            // write some things about the vul
            builder.append("<p>\n");
            builder.append("Score: " + entry.getKey().getScore() + "<br/>\n");
            builder.append("Severity: " + entry.getKey().getSeverity() + "<br/>\n");
            builder
                .append("Description: " + StringEscapeUtils.escapeHtml4(entry.getKey().getDescription()) + "<br/>\n");
            KnownExploitedVulnerability knownExploitedVulnerability = entry.getKey().getKnownExploitedVulnerability();
            if (null != knownExploitedVulnerability) {
                builder
                    .append("Known Exploited description: " + knownExploitedVulnerability.getDescription() + "<br/>\n");
                builder.append(
                    "Known Exploited required action: " + knownExploitedVulnerability.getRequiredAction() + "<br/>\n");
            }
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
    private static SortedMap<SecurityVulnerability, Set<ArtifactAttributes>> mapAppsToCve(Set<ArtifactAttributes> apps) {
        SortedMap<SecurityVulnerability, Set<ArtifactAttributes>> map = new TreeMap<>();

        // sort the artifacts. Can remove this if switching to ui sorting
        ArtifactAttributesComparator comparator = new ArtifactAttributesComparator();

        for (ArtifactAttributes artifactAttributes : apps) {
            for (Vulnerability vul : artifactAttributes.getVulnerabilities()) {

                // check if the key already exist
                SecurityVulnerability key = new SecurityVulnerability(vul);

                // if the map doesn't contain the key, init the list
                if (!map.containsKey(key)) {
                    map.put(key, new TreeSet<ArtifactAttributes>(comparator));
                }

                // now the key will always exist in the map and we'll add this app to the list
                map.get(key).add(artifactAttributes);
            }
        }

        return map;
    }

}
