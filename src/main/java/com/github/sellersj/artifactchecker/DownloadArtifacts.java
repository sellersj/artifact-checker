/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sellersj.artifactchecker.model.ArtifactAttributes;
import com.github.sellersj.artifactchecker.model.owasp.Dependency;
import com.github.sellersj.artifactchecker.model.owasp.DependencyCheck;
import com.github.sellersj.artifactchecker.model.owasp.Vulnerability;

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

    /** The version of maven-dependency-plugin to use. */
    private static final String MAVEN_DEP_PLUGIN_VERSION = "3.0.2";

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

    private void buildJava8Issues(ArtifactAttributes gav, String treeOutputFile) {
        List<String> issues = FindJava8Issues.checkTreeForJava8Issues(treeOutputFile);
        if (issues.isEmpty()) {
            gav.setJava8Ready(true);
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

        String repoWorkingDir = getRepoWorkingDirectory(gav);

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
        switchToCommit(gav, projectDir);

        // generate 1 tree file per project rather than 1 per module
        String treeOutputFile = projectDir.getAbsolutePath() + "/tree.txt";
        ProcessBuilder mvnDepTree = new ProcessBuilder(osPrefix + "mvn" + osSuffix, "--batch-mode",
            "org.apache.maven.plugins:maven-dependency-plugin:" + MAVEN_DEP_PLUGIN_VERSION + ":tree",
            "-DoutputFile=" + treeOutputFile, "-DappendOutput=true");
        mvnDepTree.directory(projectDir);
        run(mvnDepTree);

        // run dependency tree
        // TODO figure out how to properly filter for java 8 issues here
        buildJava8Issues(gav, treeOutputFile);

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

        // grather the info we want from the owasp dependency check
        processDependencyCheckInfo(gav, projectDir);

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

    /**
     * This will switch to the commit hash, or try to switch to the version tag.
     *
     * @param gav for info about what to switch to
     * @param projectDir where to clone the project
     */
    public void switchToCommit(ArtifactAttributes gav, File projectDir) {
        if (StringUtils.isNotBlank(gav.getScmHash())) {
            ProcessBuilder gitCheckoutHash = new ProcessBuilder(osPrefix + "git", "checkout", gav.getScmHash());
            gitCheckoutHash.directory(projectDir);
            run(gitCheckoutHash);
        } else {
            // TODO try to get a list of the tags, see if we have 1 unique version that ends with the version, and then
            // try to switch to that.
        }
    }

    /** Gets a unique dir, hopefully based on the scm hash. */
    public String getRepoWorkingDirectory(ArtifactAttributes gav) {
        String uniquePart = gav.getScmHash();
        if (StringUtils.isBlank(uniquePart)) {
            uniquePart = gav.getVersion();
        }

        return WORKING_DIR + gav.getScmProject() + File.separator + gav.getScmRepo() + File.separator + uniquePart;
    }

    public void processDependencyCheckInfo(ArtifactAttributes gav, File projectDir) {
        // let's check if the file exists before trying to parse it
        File file = new File(projectDir.getAbsolutePath() + "/target/dependency-check-report.json");
        if (!file.exists()) {
            System.err
                .println("Could not find the owasp file on path " + file.getAbsolutePath() + ". Not gathering info.");
            return;
        }

        // gather all the vul's and add them to the artifact
        ObjectMapper mapper = new ObjectMapper();
        try {
            DependencyCheck check = mapper.readValue(file, DependencyCheck.class);
            List<Vulnerability> vulnerabilities = new ArrayList<>();

            // guard against not having any dependencies
            List<Dependency> dependencies = check.getDependencies();
            if (null != dependencies) {
                for (Dependency dep : dependencies) {
                    List<Vulnerability> depsVuls = dep.getVulnerabilities();
                    if (null != depsVuls) {
                        vulnerabilities.addAll(depsVuls);
                    }
                }
            }

            // TODO do we need to sort and filter the vulnerabilities
            gav.getVulnerabilities().addAll(vulnerabilities);
        } catch (Exception e) {
            throw new RuntimeException("Couldnm't read owas" + "p file " + file.getAbsolutePath(), e);
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
                    || "tree.txt".equals(p.getFileName().toString())
                    || Constants.JAVA8_ISSUES_FILENAME.equals(p.getFileName().toString()))
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
