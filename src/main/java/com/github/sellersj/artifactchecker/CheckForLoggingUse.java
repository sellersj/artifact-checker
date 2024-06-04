/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sellersj
 */
public class CheckForLoggingUse {

    /** A logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckForLoggingUse.class);

    /**
     * @param dir starting directory
     * @return
     */
    public Set<String> getLogConfigedToLegacyLocation(File dir) {

        List<File> files = (List<File>) FileUtils.listFiles(dir, //
            // only visit these files
            FileFilterUtils.and(
                // only look in main directories
                new NamePathFileFilter("src" + File.separator + "main"), //

                FileFilterUtils.or( //
                    FileFilterUtils.suffixFileFilter("java"), //
                    FileFilterUtils.suffixFileFilter("md"), //
                    FileFilterUtils.suffixFileFilter("sh"), //
                    FileFilterUtils.suffixFileFilter("sql"), //
                    FileFilterUtils.suffixFileFilter("txt"), //
                    FileFilterUtils.suffixFileFilter("properties"), //
                    FileFilterUtils.suffixFileFilter("xml"), //
                    FileFilterUtils.nameFileFilter("Containerfile"), //
                    FileFilterUtils.nameFileFilter("Dockerfile") //
                )),

            // ignore these directories
            FileFilterUtils.notFileFilter(FileFilterUtils.or( //
                FileFilterUtils.nameFileFilter("target"), //
                FileFilterUtils.nameFileFilter(".git"), //
                FileFilterUtils.nameFileFilter(".settings"), //
                new NamePathFileFilter("src" + File.separator + "main" + File.separator + "application"), //
                new NamePathFileFilter("src" + File.separator + "test"))));

        TreeSet<String> matchingLines = new TreeSet<>();

        for (File file : files) {
            try {
                List<String> lines = FileUtils.readLines(file, StandardCharsets.ISO_8859_1);
                int lineNumber = 1;
                for (String line : lines) {
                    if (line.contains("strategis/docs/private")) {

                        // TODO we need the path, minus the starting directory
                        String absPath = file.getAbsolutePath();
                        String relPath = absPath.replace(dir.getAbsolutePath(), "");

                        String result = relPath + "#" + lineNumber;

                        LOGGER.info("Found log config page on " + result + " for with content");

                        // the matching file with the line number
                        matchingLines.add(result);
                    }
                    lineNumber++;
                }
            } catch (IOException e) {
                throw new RuntimeException("Could not read file " + file, e);
            }
        }

        return matchingLines;
    }

}
