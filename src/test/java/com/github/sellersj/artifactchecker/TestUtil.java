package com.github.sellersj.artifactchecker;

import java.io.File;
import java.net.URL;

public class TestUtil {

    /**
     * @param filename should start with leading slash
     * @return the file handle
     */
    public static File getFileOnClasspath(String filename) {
        try {
            URL url = InventoryFileUtilTest.class.getResource(filename);
            return new File(url.toURI());
        } catch (Exception e) {
            throw new RuntimeException("Couldn't load the file " + filename, e);
        }
    }
}
