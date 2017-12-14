/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sellersj.artifactchecker.model.AppInventory;
import com.github.sellersj.artifactchecker.model.ArtifactAttributes;

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
    public static AppInventory readMergedManifests(File file) {
        AppInventory inventory = new AppInventory();

        try {
            String contents = FileUtils.readFileToString(file, Charset.defaultCharset());
            // split the code, keeping the separator of hash #
            // String[] chunks = contents.split("(?=#)");
            String[] chunks = contents.split("\\n\\n");

            for (String string : chunks) {

                // take the string, toss it into a properties object and ignore the empty objects
                Properties p = new Properties();
                p.load(new StringReader(string));
                if (!p.isEmpty()) {

                    ArtifactAttributes attributes = new ArtifactAttributes();

                    for (final String name : p.stringPropertyNames()) {
                        attributes.getManifest().put(name, p.getProperty(name));
                    }

                    inventory.add(attributes);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file: " + file, e);
        }

        return inventory;
    }

}
