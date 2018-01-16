/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.jar.Manifest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public static List<ScmCorrection> readScmCorrection(File file) {
        try {
            List<ScmCorrection> corrections = mapper.readValue(file, new TypeReference<List<ScmCorrection>>() {
            });
            return corrections;
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file: " + file, e);
        }
    }

    public static Set<ArtifactAttributes> readMergedManifests(URL url) {
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
    public static Set<ArtifactAttributes> readMergedManifests(File file) {
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
    public static Set<ArtifactAttributes> readMergedManifests(String contents) {

        Set<ArtifactAttributes> apps = new HashSet<>();

        // split the file on a the manifest header, while keeping the header
        String[] chunks = contents.split("(?=Manifest-Version)");

        for (String string : chunks) {

            // read the chunk into a manifest object so it can deal with the manifest quirks
            Manifest manifest = readToManifest(string);

            if (doesManifestHaveValues(manifest)) {
                // get the object to load
                ArtifactAttributes attributes = new ArtifactAttributes();

                for (Entry<Object, Object> entry : manifest.getMainAttributes().entrySet()) {
                    attributes.getManifest().put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                }

                apps.add(attributes);
            }
        }

        // fix any manifests we can find
        fillInMissingScmInfo(apps);

        return apps;
    }

    /**
     * @param manifest to check
     * @return true if any of the main values have values
     */
    public static boolean doesManifestHaveValues(Manifest manifest) {
        // skip creating an artifact is there none of the manifest entries contain a value
        boolean hasValues = false;

        for (Entry<Object, Object> entry : manifest.getMainAttributes().entrySet()) {
            String key = String.valueOf(entry.getKey());
            String value = String.valueOf(entry.getValue());

            if (!"Manifest-Version".equals(key) && //
                StringUtils.isNotBlank(value)) {
                hasValues = true;
                break;
            }
        }

        if (!hasValues) {
            System.out.println("Ignoring an empty manifest");
        }

        return hasValues;
    }

    /** Fills in scm info that's missing for a best guess. */
    public static void fillInMissingScmInfo(Set<ArtifactAttributes> apps) {

        Map<String, ScmCorrection> mapOfCorrections = getCorrections();

        Collection<String> unneededCorrections = getUnneededCorrections(apps, mapOfCorrections);
        if (!unneededCorrections.isEmpty()) {
            System.err.println("******************************");
            System.err.println("Unneeded corrections in scm-corrections.json include:");
            for (String string : unneededCorrections) {
                System.err.println(string);
            }
            System.err.println("******************************");
        }

        for (ArtifactAttributes app : apps) {
            if (mapOfCorrections.containsKey(app.getTitle())) {
                ScmCorrection correction = mapOfCorrections.get(app.getTitle());

                // correct the git info
                if (!app.hasRequiredGitInfo()) {
                    System.out.println("Correcting repo and name for " + app.getTitle() + " to "
                        + correction.getScmProject() + " and " + correction.getScmRepo());

                    app.setCorrectedScmProject(correction.getScmProject());
                    app.setCorrectedScmRepo(correction.getScmRepo());
                }

                // TODO consider checking this separately with a double check of the version number
                // correct the artifactId if we can
                if (StringUtils.isBlank(app.getArtifactId())) {
                    System.out.println(
                        "Adding corrected artifactId for " + app.getTitle() + " to " + correction.getArtifactId());
                    app.setCorrectedArtifactId(correction.getArtifactId());
                }
            }
        }
    }

    /**
     *
     * @param apps from the scraped sources
     * @param mapOfCorrections the corrections
     * @return all names that are in the corrected list but not in the apps
     */
    public static Collection<String> getUnneededCorrections(Set<ArtifactAttributes> apps,
                                                            Map<String, ScmCorrection> mapOfCorrections) {

        // get all the titles
        HashSet<String> titles = new HashSet<>();
        for (ArtifactAttributes artifactAttributes : apps) {
            titles.add(artifactAttributes.getTitle());
        }

        // get all the corrections
        TreeSet<String> unneeded = new TreeSet<>();
        unneeded.addAll(mapOfCorrections.keySet());
        // remove all the titles that we we care about
        unneeded.removeAll(titles);

        // we should be left with all the values that are in the corrections file but no longer in prod
        return unneeded;
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
