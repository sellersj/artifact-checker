/**
 *
 */
package com.github.sellersj.artifactchecker;

import com.github.sellersj.artifactchecker.model.ArtifactAttributes;

public class DownloadArtifacts {

    /**
     * We're dealing with mac giving a limited PATH to eclipse and linking directly to homebrew.
     */
    private String osPrefix;

    public static void main(String[] args) throws Exception {
        DownloadArtifacts downloadArtifats = new DownloadArtifacts();
        downloadArtifats.downloadAndReadManifest(null);
    }

    public DownloadArtifacts() {
        System.out.println("OS is: " + System.getProperty("os.name"));
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("mac")) {
            osPrefix = "/usr/local/bin/";
        } else {
            osPrefix = "";
        }
    }

    public ArtifactAttributes downloadAndReadManifest(ArtifactAttributes gav) {

        ProcessBuilder builder = new ProcessBuilder(osPrefix + "mvn", "help:effective-settings");
        builder.inheritIO();

        try {
            Process process = builder.start();
            process.waitFor();
        } catch (Exception e) {
            throw new RuntimeException("Couldn't download: " + gav, e);
        }

        // TODO have this populated with something useful
        ArtifactAttributes attributes = new ArtifactAttributes();
        return attributes;
    }
}
