/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sellersj.artifactchecker.model.App;
import com.github.sellersj.artifactchecker.model.AppInventory;

public class InventoryFileUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        String fileName = "/Users/sellersj/.m2/repository/org/slf4j/slf4j-simple/1.7.22/slf4j-simple-1.7.22.jar";

        App app = new App();
        app.setGroupId("org.slf4j");
        app.setArtifactId("slf4j-simple");
        app.setVersion("1.7.22");
        app.setManifest(GetManifest.getMainAttributes(fileName));

        AppInventory appInventory = new AppInventory();
        appInventory.add(app);

        File file = File.createTempFile("appInventory", ".json");
        System.out.println(file.getAbsolutePath());
        write(file, appInventory);

    }

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

}
