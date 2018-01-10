/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

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
     * @param args
     */
    public static void main(String[] args) {
        String toolsHost = System.getenv(Constants.TOOLS_HOST);
        if (StringUtils.isBlank(toolsHost)) {
            System.err.println("The env variable TOOLS_HOST has to be set. Exiting");
            return;
        }

        String location = "https://" + toolsHost + "/deployed-to/manifest-combined.txt";
        Set<ArtifactAttributes> apps = ReportBuilder.generateAppInventory(location);

        DownloadArtifacts downloadArtifacts = new DownloadArtifacts();

        Set<ArtifactAttributes> filtered = getAppsFilteredByCloneUrlAndHash(apps);

        for (ArtifactAttributes gav : filtered) {
            downloadArtifacts.cloneAndCheckProject(gav);
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
