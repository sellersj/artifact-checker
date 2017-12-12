/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sellersj.artifactchecker.model.App;
import com.github.sellersj.artifactchecker.model.AppGAVComparator;
import com.github.sellersj.artifactchecker.model.AppInventory;

public class InventoryFileUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void write(File file, AppInventory appInventory) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, appInventory);
        } catch (IOException e) {
            throw new RuntimeException("Could not write file: " + file, e);
        }
    }

    public static AppInventory read(File file) {
        try {
            AppInventory appInventory = mapper.readValue(file, AppInventory.class);
            return appInventory;
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file: " + file, e);
        }
    }

    /**
     * This will read a file of merged pom.properties from maven artifacts.
     * 
     * It will return a list of partially filled apps, containing on their GAV info.
     * 
     * @param file to read
     * @return a filled out list.
     */
    public static Set<App> readMergedPomProperties(File file) {
        TreeSet<App> bob = new TreeSet<>(new AppGAVComparator());

        try {
            String contents = FileUtils.readFileToString(file, Charset.defaultCharset());
            String[] chunks = contents.split("#");
            for (String string : chunks) {
                System.out.println(string);
                System.out.println("===============");
            }
            

        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file: " + file, e);
        }

        return bob;
    }

}
