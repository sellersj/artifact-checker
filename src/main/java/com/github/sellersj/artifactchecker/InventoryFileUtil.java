/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
            System.out.println("Writing app inventory to : " + file.getAbsolutePath());
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

    public static AppInventory readMergedManifests(URL url) {
        try (InputStream in = url.openStream()) {
            String contents = IOUtils.toString(in, StandardCharsets.UTF_8);
            return readMergedManifests(contents);
        } catch (Exception e) {
            throw new RuntimeException("Could not download file from " + url, e);
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
        try {
            String contents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            return readMergedManifests(contents);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file: " + file, e);
        }

    }

    /**
     * This will read a file of merged pom.properties from maven artifacts.
     *
     * It will return a list of partially filled apps, containing on their GAV info.
     *
     * @param contents to read
     * @return a filled out list.
     */
    public static AppInventory readMergedManifests(String contents) {
        AppInventory inventory = new AppInventory();

        // split the file on a the manifest header, while keeping the header
        String[] chunks = contents.split("(?=Manifest-Version)");

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
