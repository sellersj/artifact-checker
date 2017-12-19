/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.github.sellersj.artifactchecker.model.ArtifactAttributes;

public class DownloadArtifacts {

    /**
     * We're dealing with mac giving a limited PATH to eclipse and linking directly to homebrew.
     */
    private String osPrefix;

    private static final String WORKING_DIR = "target/cloned-projects/";

    /** The list of dependencies that have issues with java 8. */
    private List<String> java8Issues = null;

    public DownloadArtifacts() {
        System.out.println("OS is: " + System.getProperty("os.name"));
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("mac")) {
            osPrefix = "/usr/local/bin/";
        } else {
            osPrefix = "";
        }

    }

    private List<String> buildJava8Issues() {
        if (null != java8Issues) {
            return java8Issues;
        }

        try {
            URL url = this.getClass().getResource("/artifacts-java-8-issues.txt");
            File file = new File(url.toURI());

            List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
            java8Issues = lines;

            return java8Issues;
        } catch (Exception e) {
            throw new RuntimeException("Couldn't generate java 8 issues", e);
        }

    }

    public void cloneAndCheckProject(ArtifactAttributes gav) {
        if (!gav.hasRequiredGitInfo()) {
            System.err.println("###########");
            System.err.println("Project doesn't have enough info to clone and check: " + gav);
            System.err.println("###########");
            return;
        }

        // init the working temp dir
        new File(WORKING_DIR).mkdirs();

        String repoWorkingDir = WORKING_DIR + gav.getScmProject();

        // check out the project
        ProcessBuilder gitClone = new ProcessBuilder(osPrefix + "git", "clone", gav.buildGitCloneUrl());
        gitClone.directory(new File(repoWorkingDir));
        run(gitClone);

        // the directory of the actual project
        File projectDir = new File(repoWorkingDir + File.separator + gav.getScmRepo());

        // switch git to the specific hash that we're targeting
        ProcessBuilder gitCheckoutHash = new ProcessBuilder(osPrefix + "git", "checkout", gav.getScmHash());
        gitCheckoutHash.directory(projectDir);
        run(gitCheckoutHash);

        // run dependency tree
        // TODO figure out how to properly filter for java 8 issues here
        buildJava8Issues();

        ProcessBuilder mvnDepTree = new ProcessBuilder(osPrefix + "mvn", "dependency:tree");
        mvnDepTree.directory(projectDir);
        run(mvnDepTree);
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
