/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
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

}
