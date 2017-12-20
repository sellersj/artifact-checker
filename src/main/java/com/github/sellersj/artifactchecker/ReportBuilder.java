/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.github.sellersj.artifactchecker.model.AppInventory;
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
        String toolsHost = System.getenv("TOOLS_HOST");
        if (StringUtils.isBlank(toolsHost)) {
            System.err.println("The env variable TOOLS_HOST has to be set. Exiting");
            return;
        }

        String location = "https://" + toolsHost + "/deployed-to/manifest-combined.txt";
        AppInventory inventory = ReportBuilder.generateAppInventory(location);

        DownloadArtifacts downloadArtifacts = new DownloadArtifacts();

        for (ArtifactAttributes gav : inventory.getApps()) {
            downloadArtifacts.cloneAndCheckProject(gav);
        }

        File srcDir = new File(DownloadArtifacts.FILES_GENERATED);
        File destDir = new File("/data00/bamboo/projectsites/");
        try {
            FileUtils.copyDirectory(srcDir, destDir);
            System.out.println("Copied files from " + srcDir + " to " + destDir);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't copy files from " + srcDir + " to " + destDir, e);
        }

        String target = "/data00/bamboo/projectsites/app-inventory.json";
        ReportBuilder.buildJsonReport(inventory, target);
    }

    public static void buildJsonReport(AppInventory gavs, String targetLocation) {
        System.out.println("The number of apps is at least " + gavs.getApps().size());

        File outFile = new File(targetLocation);
        InventoryFileUtil.write(outFile, gavs);
    }

    public static AppInventory generateAppInventory(String location) {
        URL url;
        try {
            url = new URL(location);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Couldn't make a url from " + location, e);
        }

        AppInventory gavs = InventoryFileUtil.readMergedManifests(url);
        return gavs;
    }
}
