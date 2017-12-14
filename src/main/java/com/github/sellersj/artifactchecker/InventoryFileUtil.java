/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map.Entry;
import java.util.jar.Manifest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

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
            String contents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            // split the file on a double new line
            String[] chunks = contents.split("\\n\\n");

            for (String string : chunks) {

                // read the chunk into a manifest object so it can deal with the manifest quirks
                Manifest manifest = readToManifest(string);

                // get the object to load
                ArtifactAttributes attributes = new ArtifactAttributes();

                for (Entry<Object, Object> entry : manifest.getMainAttributes().entrySet()) {
                    attributes.getManifest().put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                }

                inventory.add(attributes);
            }

        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file: " + file, e);
        }

        return inventory;
    }

    private static Manifest readToManifest(String string) {
        try {
            Manifest manifest = new Manifest(IOUtils.toInputStream(string, StandardCharsets.UTF_8));
            return manifest;
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read manifest chunk: " + string, e);
        }
    }

}
