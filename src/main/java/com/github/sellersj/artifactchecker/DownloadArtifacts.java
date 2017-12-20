/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.github.sellersj.artifactchecker.model.ArtifactAttributes;

/**
 * If doing this on a computer that hasn't updated the owasp dependency check data, it be can be done by calling the
 * <code>org.owasp:dependency-check-maven:3.0.2:update-only</code>
 *
 * @author sellersj
 *
 */
public class DownloadArtifacts {

    /** The version of owasp dependency check to use. */
    private static final String OWASP_DEP_CHECK_VERSION = "3.0.2";

    /**
     * We're dealing with mac giving a limited PATH to eclipse and linking directly to homebrew.
     */
    private String osPrefix;

    /**
     * Ah windows...
     */
    private String osSuffix;

    public static final String WORKING_DIR = "target/cloned-projects/";

    /** The place where we store the files we've generated from the project, the ones we care about. */
    public static final String FILES_GENERATED = "target/files-generated/";

    /** The list of dependencies that have issues with java 8. */
    private List<String> java8Issues = null;

    public DownloadArtifacts() {
        System.out.println("OS is: " + System.getProperty("os.name"));
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("mac")) {
            osPrefix = "/usr/local/bin/";
            osSuffix = "";
        } else if (os.contains("windows")) {
            osPrefix = "";
            osSuffix = ".cmd";
        } else {
            osPrefix = "";
            osSuffix = "";
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

        String repoWorkingDir = WORKING_DIR + gav.getScmProject() + File.separator + gav.getScmRepo() + File.separator
            + gav.getScmHash();

        // check out the project, only if it doesn't exist
        if (new File(repoWorkingDir).exists()) {
            System.out.println("Directory '" + repoWorkingDir + "' already exists. Not going to try to clone again. ");
        } else {
            ProcessBuilder gitClone = new ProcessBuilder(osPrefix + "git", "clone", gav.buildGitCloneUrl());
            gitClone.directory(new File(repoWorkingDir));
            if (0 != run(gitClone)) {
                System.err.println("Could not clone project: " + gav);
                return;
            }
        }

        // the directory of the actual project
        File projectDir = new File(repoWorkingDir + File.separator + gav.getScmRepo());

        // switch git to the specific hash that we're targeting
        ProcessBuilder gitCheckoutHash = new ProcessBuilder(osPrefix + "git", "checkout", gav.getScmHash());
        gitCheckoutHash.directory(projectDir);
        run(gitCheckoutHash);

        // run dependency tree
        // TODO figure out how to properly filter for java 8 issues here
        buildJava8Issues();

        ProcessBuilder mvnDepTree = new ProcessBuilder(osPrefix + "mvn" + osSuffix, "--batch-mode", "dependency:tree",
            "-DoutputFile=tree.txt");
        mvnDepTree.directory(projectDir);
        run(mvnDepTree);

        // run owasp dependency check
        ProcessBuilder mvnOwaspCheck = new ProcessBuilder(osPrefix + "mvn" + osSuffix, "--batch-mode",
            "org.owasp:dependency-check-maven:" + OWASP_DEP_CHECK_VERSION + ":check", //
            "org.owasp:dependency-check-maven:" + OWASP_DEP_CHECK_VERSION + ":aggregate", //
            "-Dformat=ALL", "-DskipProvidedScope=true", //
            "-DautoUpdate=false", //
            "-DnuspecAnalyzerEnabled=false", //
            "-DassemblyAnalyzerEnabled=false", //
            "-DnspAnalyzerEnabled=false"//
        );
        mvnOwaspCheck.directory(projectDir);
        run(mvnOwaspCheck);

        // copy all required files we want to a different location
        copyFiles();

        // delete the repo to save space if it exists
        try {
            System.out.println("Deleting " + repoWorkingDir);
            Files.walk(Paths.get(repoWorkingDir)).sorted(Comparator.reverseOrder()).map(Path::toFile)
                .forEach(File::delete);
        } catch (IOException e) {
            throw new RuntimeException("Couldnm't delete directory for cleanup " + repoWorkingDir, e);
        }

    }

    private int run(ProcessBuilder builder) {
        if (!builder.directory().exists()) {
            System.out.println("Making directory: " + builder.directory().getAbsolutePath());
            builder.directory().mkdirs();
        }

        builder.inheritIO();
        try {
            Process process = builder.start();
            process.waitFor();
            return process.exitValue();
        } catch (Exception e) {
            throw new RuntimeException("Couldn't run process: " + builder, e);
        }
    }

    public void copyFiles() {
        // have a place to copy, create it if it's not there
        File target = new File(FILES_GENERATED);
        if (!target.exists()) {
            target.mkdirs();
        }

        try {
            Path path = Paths.get(WORKING_DIR);
            Files.walk(path)//
                .filter(p -> p.getFileName().toString().startsWith("dependency-check-")
                    || "tree.txt".equals(p.getFileName().toString()))
                // .peek(System.out::println) //
                .forEach(p -> moveUnchecked(p));

        } catch (IOException e) {
            throw new RuntimeException("Could not copy file to new directory", e);
        }
    }

    public static Path moveUnchecked(Path source) {
        Path target = Paths.get(source.toAbsolutePath().toString().replaceAll("cloned-projects", "files-generated"));
        System.out.println("Going to move to: " + target);

        // make the target directory if it doesn't exist
        if (!target.getParent().toFile().exists()) {
            target.getParent().toFile().mkdirs();
        }

        try {
            return Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't move " + source + " to " + target, e);
        }
    }
}
