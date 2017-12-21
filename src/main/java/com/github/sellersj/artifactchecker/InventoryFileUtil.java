/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.jar.Manifest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sellersj.artifactchecker.model.AppInventory;
import com.github.sellersj.artifactchecker.model.ArtifactAttributes;
import com.github.sellersj.artifactchecker.model.ScmCorrection;

public class InventoryFileUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void write(File file, Object objectToWrite) {
        try {
            System.out.println("Writing app inventory to : " + file.getAbsolutePath());
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, objectToWrite);
        } catch (IOException e) {
            throw new RuntimeException("Could not write file: " + file, e);
        }
    }

    public static AppInventory readAppInventory(File file) {
        try {
            AppInventory appInventory = mapper.readValue(file, AppInventory.class);
            return appInventory;
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file: " + file, e);
        }
    }

    public static List<ScmCorrection> readScmCorrection(File file) {
        try {
            List<ScmCorrection> corrections = mapper.readValue(file, new TypeReference<List<ScmCorrection>>() {
            });
            return corrections;
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

        // fix any manifests we can find
        fillInMissingScmInfo(inventory);

        return inventory;
    }

    /** Fills in scm info that's missing for a best guess. */
    public static AppInventory fillInMissingScmInfo(AppInventory original) {

        // TODO can the return type be cahnged to void

        Map<String, ScmCorrection> mapOfCorrections = getCorrections();

        for (ArtifactAttributes app : original.getApps()) {
            if (StringUtils.isNotBlank(app.getScmHash()) && !app.hasRequiredGitInfo()) {

                if (mapOfCorrections.containsKey(app.getTitle())) {
                    ScmCorrection correction = mapOfCorrections.get(app.getTitle());

                    System.out.println("Correcting repo and name for " + app.getTitle() + " to "
                        + correction.getScmProject() + " and " + correction.getScmRepo());

                    app.setCorrectedScmProject(correction.getScmProject());
                    app.setCorrectedScmRepo(correction.getScmRepo());
                }
            }
        }

        return original;
    }

    private static Map<String, ScmCorrection> getCorrections() {
        File file = getFileOnClasspath("/scm-corrections.json");
        List<ScmCorrection> correction = readScmCorrection(file);
        Map<String, ScmCorrection> mapOfCorrections = new HashMap<>();
        for (ScmCorrection scmCorrection : correction) {
            mapOfCorrections.put(scmCorrection.getImplementationTitle(), scmCorrection);
        }

        return mapOfCorrections;
    }

    private static Manifest readToManifest(String string) {
        try {
            Manifest manifest = new Manifest(IOUtils.toInputStream(string, StandardCharsets.UTF_8));
            return manifest;
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read manifest chunk: " + string, e);
        }
    }

    /**
     * @param filename should start with leading slash
     * @return the file handle
     */
    public static File getFileOnClasspath(String filename) {
        try {
            URL url = InventoryFileUtil.class.getResource(filename);
            return new File(url.toURI());
        } catch (Exception e) {
            throw new RuntimeException("Couldn't load the file " + filename, e);
        }
    }

}
