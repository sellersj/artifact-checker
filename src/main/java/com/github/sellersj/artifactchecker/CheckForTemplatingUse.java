/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
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
        writeFileOfLinesFound(startingDir, matchingLines);

        // get the template names so they can be put into the model
        return getTemplateNames(matchingLines);
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

    public void writeFileOfLinesFound(File directory, List<String> lines) {
        File file = new File(directory, Constants.TEMPLATE_MATCHING_LINE_FILENAME);
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

}
