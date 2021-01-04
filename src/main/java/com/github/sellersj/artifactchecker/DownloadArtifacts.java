/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sellersj.artifactchecker.model.ArtifactAttributes;
import com.github.sellersj.artifactchecker.model.owasp.Dependency;
import com.github.sellersj.artifactchecker.model.owasp.DependencyCheckReport;
import com.github.sellersj.artifactchecker.model.owasp.SuppressedVulnerability;
import com.github.sellersj.artifactchecker.model.owasp.Vulnerability;

/**
 * If doing this on a computer that hasn't updated the owasp dependency check data, it be can be done by calling the
 * <code>org.owasp:dependency-check-maven:6.0.4:update-only</code>
 *
 * @author sellersj
 *
 */
public class DownloadArtifacts {

    /** The version of owasp dependency check to use. */
    private static final String OWASP_DEP_CHECK_VERSION = "6.0.4";

    /** The version of maven-dependency-plugin to use. */
    private static final String MAVEN_DEP_PLUGIN_VERSION = "3.1.2";

    /**
     * We're dealing with mac giving a limited PATH to eclipse and linking directly to homebrew.
     */
    private String osPrefix;

    /**
     * Ah windows...
     */
    private String osSuffix;

    /** The url where we will point to nexus. */
    private String nexusUrl;

    public static final String WORKING_DIR = "target/cloned-projects/";

    /**
     * The place where we store the files we've generated from the project, the ones we care about.
     */
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

        String toolsHost = Constants.getSysOrEnvVariable(Constants.TOOLS_HOST);
        if (StringUtils.isNotBlank(toolsHost)) {
            nexusUrl = "https://" + toolsHost + "/maven-proxy/service/local/";
            System.out.println(String.format("We are going to use %s to download artifacts", nexusUrl));
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
            gav.setLibraryCheckedWorked(false);
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
            StopWatch watch = new StopWatch();
            watch.start();
            ProcessBuilder gitClone = new ProcessBuilder(osPrefix + "git", "clone", gav.buildGitCloneUrl());
            gitClone.directory(new File(repoWorkingDir));

            if (0 != run(gitClone)) {
                System.err.println("Could not clone project: " + gav);
                return;
            }

            watch.stop();
            System.out.println("Clone for " + gav.getScmProject() + " " + gav.getScmRepo() + " took " + watch);
        }

        // the directory of the actual project
        File projectDir = new File(repoWorkingDir + File.separator + gav.getScmRepo());

        // switch git to the specific hash that we're targeting
        switchToCommit(gav, projectDir);

        // grab the commit date if we can
        populateAuthorDate(gav, projectDir);

        mvnInstallIfSnapshot(gav, projectDir);

        // generate 1 tree file per project rather than 1 per module
        String treeOutputFile = projectDir.getAbsolutePath() + "/tree.txt";
        ProcessBuilder mvnDepTree = new ProcessBuilder(osPrefix + "mvn" + osSuffix, "--batch-mode",
            "org.apache.maven.plugins:maven-dependency-plugin:" + MAVEN_DEP_PLUGIN_VERSION + ":tree",
            "-DoutputFile=" + treeOutputFile, "-DappendOutput=true");
        mvnDepTree.directory(projectDir);
        if (0 != run(mvnDepTree)) {
            gav.setLibraryCheckedWorked(false);
        }

        // run dependency tree
        // TODO figure out how to properly filter for java 8 issues here
        buildJava8Issues(gav, treeOutputFile);

        List<String> command = new ArrayList<>();
        command.addAll(Arrays.asList(osPrefix + "mvn" + osSuffix, "--batch-mode",
            "org.owasp:dependency-check-maven:" + OWASP_DEP_CHECK_VERSION + ":check", //
            "org.owasp:dependency-check-maven:" + OWASP_DEP_CHECK_VERSION + ":aggregate", //
            "-Dformat=ALL", "-DskipProvidedScope=true", //
            "-DautoUpdate=false", //
            "-DnuspecAnalyzerEnabled=false", //
            "-DassemblyAnalyzerEnabled=false", //
            "-DnodeAuditAnalyzerEnabled=false", //
            "-DnodeAnalyzerEnabled=false", //
            "-DrubygemsAnalyzerEnabled=false", //
            "-DbundleAuditAnalyzerEnabled=false", //
            "-Dhttps.protocols=TLSv1,TLSv1.1,TLSv1.2"));

        // if we have a nexus url, use it
        if (StringUtils.isNotBlank(nexusUrl)) {
            command.add("-DnexusUrl=" + nexusUrl);
        }

        // run owasp dependency check
        ProcessBuilder mvnOwaspCheck = new ProcessBuilder(command);
        mvnOwaspCheck.directory(projectDir);
        if (0 != run(mvnOwaspCheck)) {
            gav.setLibraryCheckedWorked(false);
        }

        // gather the info we want from the owasp dependency check
        processDependencyCheckInfo(gav, projectDir);

        // check for the templating here
        CheckForTemplatingUse templatingUse = new CheckForTemplatingUse();
        gav.setEpicTemplatingNames(templatingUse.getEpicTemplateNames(projectDir));
        templatingUse.writeEpicUse(projectDir);

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
     * For improperly deployed apps, the snapshots might not exist in the repo any more. So we're doing a maven install
     * to be able to do the CVE checks.
     *
     * @param gav to use
     * @param projectDir the directory that it's in
     */
    private void mvnInstallIfSnapshot(ArtifactAttributes gav, File projectDir) {
        if (StringUtils.isNotBlank(gav.getVersion()) && gav.getVersion().contains("SNAPSHOT")) {

            System.err.println("*****************");
            System.err.println("Artifact is a snapshot. This is wrong. " + gav);
            System.err.println("Running maven install without tests so the other checks can be done.");
            System.err.println("*****************");

            ProcessBuilder mvnInstall = new ProcessBuilder(osPrefix + "mvn" + osSuffix, "--batch-mode", "install",
                "-DskipTests");
            mvnInstall.directory(projectDir);
            run(mvnInstall);
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
            switchToTag(gav, projectDir);
        }
    }

    /**
     * For whatever tag (hashed or not) we are on, this will try to get the date.
     *
     * Useful:
     * <ul>
     * <li>https://devhints.io/git-log-format</li>
     * <li>https://devhints.io/git-log</li>
     * </ul>
     *
     * @param gav for info about get the date
     * @param projectDir where to clone the project
     */
    public void populateAuthorDate(ArtifactAttributes gav, File projectDir) {
        if (StringUtils.isNotBlank(gav.getScmHash()) || StringUtils.isNotBlank(gav.getScmTag())) {

            // get the last log entry, limiting it to 1, and have it with just the author iso time
            // (ai)
            ProcessBuilder gitLog = new ProcessBuilder(osPrefix + "git", "log", "-n", "1", "--pretty=%ai");
            gitLog.directory(projectDir);

            // since we want the normal output, we have to redirect the system err ourselves
            gitLog.redirectError(Redirect.INHERIT);

            try {
                Process process = gitLog.start();
                String output = StringUtils
                    .trimToEmpty(IOUtils.toString(process.getInputStream(), StandardCharsets.UTF_8));

                // for the process to run
                process.waitFor();
                process.exitValue();

                System.out.println("found the author date of " + output);
                gav.setScmAuthorDate(output);

            } catch (Exception e) {
                throw new RuntimeException("Couldn't run process: " + gitLog, e);
            }
        }
    }

    /**
     * try to get a list of the tags, see if we have 1 unique version that ends with the version, and then try to switch
     * to that.
     *
     * @param gav to switch to
     * @param projectDir where the project is already cloned to
     */
    public void switchToTag(ArtifactAttributes gav, File projectDir) {
        System.out.println("Using the version to checkout for project " + gav);

        ProcessBuilder gitCheckoutVersion = new ProcessBuilder(osPrefix + "git", "tag", "-l", "*-" + gav.getVersion());
        gitCheckoutVersion.directory(projectDir);

        // since we want the normal output, we have to redirect the system err ourselves
        gitCheckoutVersion.redirectError(Redirect.INHERIT);

        try {
            Process process = gitCheckoutVersion.start();
            String output = IOUtils.toString(process.getInputStream(), StandardCharsets.UTF_8);

            process.waitFor();
            process.exitValue();

            List<String> matchingTags = getMatchingTags(output);
            if (1 == matchingTags.size()) {
                String tag = matchingTags.get(0);
                gav.setScmTag(tag);

                // switch to this tag
                ProcessBuilder gitCheckoutTag = new ProcessBuilder(osPrefix + "git", "checkout", "tags/" + tag);
                gitCheckoutTag.directory(projectDir);
                Process tagProcess = gitCheckoutTag.start();

                tagProcess.waitFor();
                tagProcess.exitValue();

                System.out.println("Switched to tag '" + tag + "' for " + gav);

            } else {
                // TODO maybe throw an exception here?
                System.err.println("Found more than 1 tag for the checkout for project " + gav);
            }
        } catch (Exception e) {
            throw new RuntimeException("Couldn't run process: " + gitCheckoutVersion, e);
        }
    }

    /**
     * Parse the output by new lines and put them into a list.
     *
     * @param tags
     * @return
     */
    public List<String> getMatchingTags(String tags) {
        ArrayList<String> matching = new ArrayList<>();
        for (String string : tags.split("\\r?\\n")) {
            if (StringUtils.isNotBlank(string)) {
                matching.add(string);
            }
        }
        return matching;
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

        gav.getVulnerabilities().addAll(parseDependencyCheckReport(file));
    }

    public List<Vulnerability> parseDependencyCheckReport(File file) {
        // gather all the vul's and add them to the artifact
        ObjectMapper mapper = new ObjectMapper();
        List<Vulnerability> vulnerabilities = new ArrayList<>();
        try {
            DependencyCheckReport check = mapper.readValue(file, DependencyCheckReport.class);

            // guard against not having any dependencies
            List<Dependency> dependencies = check.getDependencies();
            if (null != dependencies) {
                for (Dependency dep : dependencies) {
                    List<Vulnerability> depsVuls = dep.getVulnerabilities();

                    if (null != depsVuls) {
                        vulnerabilities.addAll(depsVuls);
                    }

                    // now let's remove any suppressed issues where the name matches
                    if (null != dep.getSuppressedVulnerabilities()) {
                        for (Iterator<Vulnerability> iterator = vulnerabilities.iterator(); iterator.hasNext();) {
                            Vulnerability vul = iterator.next();

                            for (SuppressedVulnerability suppressed : dep.getSuppressedVulnerabilities()) {
                                if (vul.getName().equals(suppressed.getName())) {
                                    iterator.remove();
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Couldn't read owasp file " + file.getAbsolutePath(), e);
        }

        // TODO do we need to sort and filter the vulnerabilities
        return vulnerabilities;
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
                    || Constants.TEMPLATE_MATCHING_LINE_FILENAME.equals(p.getFileName().toString())
                    || Constants.EPIC_MATCHING_LINE_FILENAME.equals(p.getFileName().toString())
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
