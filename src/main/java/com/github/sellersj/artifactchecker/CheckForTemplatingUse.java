/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sellersj
 */
public class CheckForTemplatingUse {

    /** A logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckForTemplatingUse.class);

    /**
     * This will look through for templating attributes in jsp's.
     *
     * @param startingDir where the project is checked out
     * @return the epic template names
     */
    public Set<String> getEpicTemplateNames(File startingDir) {
        List<File> jspFiles = getJspFiles(startingDir);
        List<String> matchingLines = getLinesOfTemplating(startingDir, jspFiles);
        writeFileOfLinesFound(startingDir, Constants.TEMPLATE_MATCHING_LINE_FILENAME, matchingLines);

        // get the template names so they can be put into the model
        return getTemplateNames(matchingLines);
    }

    /**
     * This will look through files looking for the use of epic.
     *
     * @param startingDir where the project is checked out
     * @return the epic template names
     */
    public void writeEpicUse(File startingDir) {
        List<File> jspFiles = getMainFiles(startingDir);
        List<String> matchingLines = getLinesMatching(startingDir, jspFiles, Arrays.asList("/eic/", "/epic/"));
        writeFileOfLinesFound(startingDir, Constants.EPIC_MATCHING_LINE_FILENAME, matchingLines);
    }

    /**
     * Find all the places with the matching env var use
     *
     * @param startingDir
     */
    public void writeEnvVarUse(File startingDir) {
        List<File> files = getMainFiles(startingDir);
        List<String> matchingLines = getLinesMatching(startingDir, files, getCachedEnvVarsInUse());
        writeFileOfLinesFound(startingDir, Constants.ENV_VAR_MATCHING_LINE_FILENAME, matchingLines);
    }

    /**
     * Try to download the env var file.
     *
     * @return the contents of the env var file so we can check the files
     */
    private List<String> getCachedEnvVarsInUse() {
        File file = new File("target/env-vars-prod.txt");

        // cache the file if we don't have it
        if (!file.exists()) {
            // we don't have the file yet. Download it
            URL url = null;
            try {
                String toolsHost = Constants.getSysOrEnvVariable(Constants.TOOLS_HOST);
                url = new URL(
                    String.format("https://%s/projectsites/websphere-inventory/env-vars-prod.txt", toolsHost));
                int timeout = 30;
                FileUtils.copyURLToFile(url, file, timeout, timeout);
            } catch (Exception e) {
                throw new RuntimeException("Could not download the env var file " + url, e);
            }
        }

        // read the file from disk
        List<String> envVars;
        try {
            envVars = FileUtils.readLines(file, StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            throw new RuntimeException("Could not read the cached env var file " + file.getAbsolutePath(), e);
        }

        return envVars;
    }

    public Set<String> getTemplateNames(List<String> lines) {
        Set<String> result = new TreeSet<>();

        for (String string : lines) {
            // TODO look into doing this in a much better way with regex
            String subString = StringUtils.substringBetween(string, "templateName=", " ");
            if (null != subString) {
                subString = subString.replaceAll("\"", "");
            }
            if (StringUtils.isNotBlank(subString)) {
                result.add(subString);
            }
        }

        return result;
    }

    public void writeFileOfLinesFound(File directory, String filename, List<String> lines) {
        File file = new File(directory, filename);
        LOGGER.info(String.format("Writing file %s with %s lines", file.getAbsolutePath(), lines.size()));
        try {
            FileUtils.writeLines(file, lines);
        } catch (IOException e) {
            LOGGER.error("Could not write the templating use file " + file.getAbsolutePath(), e);
        }
    }

    /**
     * Search the file looking for something that looks like a template name.
     *
     * @param startingdir to know relatively what path we will need
     * @param files to check
     * @return a list of matching lines
     */
    public List<String> getLinesOfTemplating(File startingdir, List<File> files) {
        ArrayList<String> lines = new ArrayList<>();

        for (File file : files) {
            try {
                List<String> fileLines = FileUtils.readLines(file, StandardCharsets.ISO_8859_1);
                int count = 0;
                for (String line : fileLines) {
                    count++;
                    if (line.contains("templateName=")) {
                        // we don't care where it is on the disk, so we're trying to get the relative path
                        String location = file.getAbsolutePath().substring(startingdir.getAbsolutePath().length() + 1);
                        lines.add(location + ":" + count + ":" + line);
                    }
                }

            } catch (IOException e) {
                LOGGER.error("Could not parse file " + file.getAbsolutePath(), e);
            }
        }

        return lines;
    }

    /**
     * Search the file looking for something that looks like a template name.
     *
     * @param startingdir to know relatively what path we will need
     * @param files to check
     * @param containsAny any matching string
     * @return a list of matching lines
     */
    public List<String> getLinesMatching(File startingdir, List<File> files, List<String> containsAny) {
        ArrayList<String> lines = new ArrayList<>();

        for (File file : files) {
            try {
                List<String> fileLines = FileUtils.readLines(file, StandardCharsets.ISO_8859_1);
                int count = 0;
                for (String line : fileLines) {
                    count++;

                    if (containsAny.stream().anyMatch(line::contains)) {
                        // we don't care where it is on the disk, so we're trying to get the relative path
                        String location = file.getAbsolutePath().substring(startingdir.getAbsolutePath().length() + 1);
                        lines.add(location + ":" + count + ":" + line);
                    }
                }

            } catch (IOException e) {
                LOGGER.error("Could not parse file " + file.getAbsolutePath(), e);
            }
        }

        return lines;
    }

    /**
     * This will search for jsp, jspf, and tag files that are in the standard maven layout structure.
     *
     * @param dir starting directory
     * @return
     */
    public List<File> getJspFiles(File dir) {

        List<File> files = (List<File>) FileUtils.listFiles(dir, //
            // only visit these files
            FileFilterUtils.and(
                // only look in the webapp directory
                new NamePathFileFilter("src" + File.separator + "main" + File.separator + "webapp"), //

                // one of these extensions
                FileFilterUtils.or(//
                    FileFilterUtils.suffixFileFilter("jspf"), //
                    FileFilterUtils.suffixFileFilter("jsp"), //
                    FileFilterUtils.suffixFileFilter("tag") //
                )), //

            // ignore these directories
            FileFilterUtils.notFileFilter(FileFilterUtils.or( //
                FileFilterUtils.nameFileFilter("target"), //
                FileFilterUtils.nameFileFilter(".git"), //
                FileFilterUtils.nameFileFilter(".settings"), //
                new NamePathFileFilter("src" + File.separator + "main" + File.separator + "java"), //
                new NamePathFileFilter("src" + File.separator + "main" + File.separator + "application"), //
                new NamePathFileFilter("src" + File.separator + "main" + File.separator + "resources"), //
                new NamePathFileFilter("src" + File.separator + "test"))));

        return files;
    }

    /**
     * This will search for files files that are in the standard maven layout structure.
     *
     * @param dir starting directory
     * @return
     */
    public List<File> getMainFiles(File dir) {

        List<File> files = (List<File>) FileUtils.listFiles(dir, //
            // one of these extensions
            FileFilterUtils.or(//
                new NamePathFileFilter("src" + File.separator + "main" + File.separator + "webapp"), //
                new NamePathFileFilter("src" + File.separator + "main" + File.separator + "java"), //
                new NamePathFileFilter("src" + File.separator + "main" + File.separator + "resources"), //
                // TODO consider probing the file to determine type
                // https://docs.oracle.com/javase/7/docs/api/java/nio/file/Files.html#probeContentType(java.nio.file.Path)
                FileFilterUtils.suffixFileFilter("jsp"), //
                FileFilterUtils.suffixFileFilter("jspf"), //
                FileFilterUtils.suffixFileFilter("java"), //
                FileFilterUtils.suffixFileFilter("properties"), //
                FileFilterUtils.suffixFileFilter("js", IOCase.INSENSITIVE), //
                FileFilterUtils.suffixFileFilter("css", IOCase.INSENSITIVE), //
                FileFilterUtils.suffixFileFilter("html", IOCase.INSENSITIVE) //
            ), //

            // ignore these directories
            FileFilterUtils.notFileFilter(FileFilterUtils.or( //
                FileFilterUtils.nameFileFilter("target"), //
                FileFilterUtils.nameFileFilter(".git"), //
                FileFilterUtils.nameFileFilter(".settings"), //
                new NamePathFileFilter("src" + File.separator + "main" + File.separator + "application"), //
                new NamePathFileFilter("src" + File.separator + "test"))));

        return files;
    }

}
