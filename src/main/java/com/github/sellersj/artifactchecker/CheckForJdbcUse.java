/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.lang3.StringUtils;
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
    public Set<String> getJdbcMatchingLines(File startingDir) {
        List<File> files = getFilesFiles(startingDir);
        Set<String> possibleJndiNames = getJndiNames(files);
        List<String> matchingLines = getMatchingLines(startingDir, files);
        writeFileOfLinesFound(startingDir, Constants.JDBC_MATCHING_LINE_FILENAME, matchingLines);

        return possibleJndiNames;
    }

    /**
     * Do our best to figure out the jndi names so we can match it up.
     *
     * @param files to check
     * @return a list of jdni names
     */
    private Set<String> getJndiNames(List<File> files) {
        TreeSet<String> jndiNames = new TreeSet<>();
        for (File file : files) {

            String extension = FilenameUtils.getExtension(file.getName());
            if ("properties".equals(extension)) {

                try (InputStream input = new FileInputStream(file)) {

                    Properties prop = new Properties();
                    prop.load(input);

                    for (Entry<Object, Object> entry : prop.entrySet()) {
                        String value = StringUtils.trim((String) entry.getValue());
                        if (StringUtils.startsWith(value, "comp/env/jdbc/") //
                            || StringUtils.startsWith(value, "jdbc/")) {

                            jndiNames.add(value);
                        }
                    }
                } catch (IOException ex) {
                    LOGGER.error(String.format("Could not read the properties file %s ", file.getAbsolutePath()), ex);
                }

            } else {
                LOGGER.warn(String.format("We do not know how to parse file %s to look for a jndi name",
                    file.getAbsoluteFile()));
            }
        }

        return jndiNames;
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
