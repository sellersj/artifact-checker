package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.Serializable;

import org.apache.commons.io.filefilter.IOFileFilter;

/**
 * This will check that the file / directory checks contains the path. When passing in the path, it should be done with
 * a File.separator between each directory.
 *
 * @author SellersJ
 */
public class NamePathFileFilter implements Serializable, IOFileFilter {

    /**  */
    private static final long serialVersionUID = 1L;

    /** The name to check. */
    private String name;

    public NamePathFileFilter(String name) {
        this.name = name;
    }

    @Override
    public boolean accept(File file) {
        return file.getAbsolutePath().contains(name);
    }

    @Override
    public boolean accept(File dir, String name) {
        return accept(dir);
    }

}