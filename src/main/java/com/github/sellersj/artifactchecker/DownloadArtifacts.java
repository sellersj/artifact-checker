/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;

import com.github.sellersj.artifactchecker.model.ArtifactAttributes;

public class DownloadArtifacts {

    /**
     * We're dealing with mac giving a limited PATH to eclipse and linking directly to homebrew.
     */
    private String osPrefix;

    private static final String WORKING_DIR = "target/cloned-projects/";

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
        // init the working temp dir
        new File(WORKING_DIR).mkdirs();

        String repoWorkingDir = WORKING_DIR + gav.getScmProject() + File.separator + gav.getScmRepo();

        // check out the project
        ProcessBuilder builder = new ProcessBuilder(osPrefix + "git", "clone", gav.buildGitCloneUrl());
        builder.directory(new File(repoWorkingDir));
        run(builder);

        // run dependency tree
        ProcessBuilder mvnDepTree = new ProcessBuilder(osPrefix + "mvn", "dependency:tree");
        mvnDepTree.directory(new File(repoWorkingDir + File.separator + gav.getScmRepo()));
        run(mvnDepTree);

        return gav;
    }

    private void run(ProcessBuilder builder) {
        if (!builder.directory().exists()) {
            System.out.println("Making directory: " + builder.directory().getAbsolutePath());
            builder.directory().mkdirs();
        }

        builder.inheritIO();
        try {
            Process process = builder.start();
            process.waitFor();
        } catch (Exception e) {
            throw new RuntimeException("Couldn't run process: " + builder, e);
        }
    }
}
