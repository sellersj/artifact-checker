/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.util.Map.Entry;

import com.github.sellersj.artifactchecker.model.ArtifactAttributes;

public class DownloadArtifacts {

    public static void main(String[] args) throws Exception {
        // TODO figure out how to call maven command line

        ProcessBuilder builder = new ProcessBuilder("ls", "-la");
        builder.inheritIO();

        Process process = builder.start();
        process.waitFor();
    }

    public static ArtifactAttributes downloadAndReadManifest(ArtifactAttributes gav) {

        // ProcessBuilder builder = new ProcessBuilder("/usr/local/bin/mvn", "help:effective-settings");
        ProcessBuilder builder = new ProcessBuilder("mvn", "help:effective-settings");
        builder.inheritIO();
        String path = "/usr/local/bin/" + File.pathSeparator + builder.environment().get("PATH");
        builder.environment().put("PATH", path);

        for (Entry<String, String> entry : builder.environment().entrySet()) {
            System.out.println(entry);
        }

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
