package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class GetManifest {

    public static Map<String, String> getMainAttributes(String fileName) {

        File file = new File(fileName);
        Map<String, String> attributes = new TreeMap<>();

        try {
            try (JarFile jarFile = new JarFile(file)) {
                Manifest manifest = jarFile.getManifest();
                if (null == manifest) {
                    System.out.println("no manifest for file: " + fileName);
                } else {
                    for (Entry<Object, Object> entry : manifest.getMainAttributes().entrySet()) {
                        attributes.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not read file: " + fileName, e);
        }

        return attributes;
    }

}
