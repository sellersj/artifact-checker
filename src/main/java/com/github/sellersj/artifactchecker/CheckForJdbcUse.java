/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sellersj
 */
public class CheckForJdbcUse {

    /** A logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckForJdbcUse.class);

    /**
     * This will look through for templating attributes in jsp's.
     *
     * @param startingDir where the project is checked out
     * @return the epic template names
     */
    public void getJdbcMatchingLines(File startingDir) {
        List<File> files = getFilesFiles(startingDir);
        List<String> matchingLines = getMatchingLines(startingDir, files);
        writeFileOfLinesFound(startingDir, Constants.JDBC_MATCHING_LINE_FILENAME, matchingLines);
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
    public List<String> getMatchingLines(File startingdir, List<File> files) {
        ArrayList<String> lines = new ArrayList<>();

        for (File file : files) {
            try {
                List<String> fileLines = FileUtils.readLines(file, StandardCharsets.ISO_8859_1);
                int count = 0;
                for (String line : fileLines) {
                    count++;
                    if (line.contains("jdbc/")) {
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
     *
     * Finds all non-standard places where we might be using jndi.
     *
     * @param dir starting directory
     * @return
     */
    public List<File> getFilesFiles(File dir) {

        List<File> files = (List<File>) FileUtils.listFiles(dir, //
            // only visit these files
            FileFilterUtils.and(
                // only look in the main directory
                new NamePathFileFilter("src" + File.separator + "main"), //

                // one of these extensions
                FileFilterUtils.or(//
                    FileFilterUtils.suffixFileFilter("properties") //
                )), //

            // ignore these directories
            FileFilterUtils.notFileFilter(FileFilterUtils.or( //
                FileFilterUtils.nameFileFilter("target"), //
                FileFilterUtils.nameFileFilter(".git"), //
                FileFilterUtils.nameFileFilter(".settings"), //
                new NamePathFileFilter("src" + File.separator + "test"))));

        return files;
    }

}
