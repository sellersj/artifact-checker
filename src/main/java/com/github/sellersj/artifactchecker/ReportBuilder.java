/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;

import com.github.sellersj.artifactchecker.model.App;
import com.github.sellersj.artifactchecker.model.ArtifactAttributes;

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

}
