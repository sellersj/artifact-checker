/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;

/**
 * @author sellersj
 */
public class CheckForTemplatingUse {

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
