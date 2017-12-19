package com.github.sellersj.artifactchecker;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.github.sellersj.artifactchecker.model.AppInventory;
import com.github.sellersj.artifactchecker.model.ArtifactAttributes;

public class InventoryFileUtilTest {

    @Test
    public void testWriteRead() throws Exception {
        // this will probably fail if maven repo in different location
        String fileName = System.getProperty("user.home") + "/.m2/repository/junit/junit/4.12/junit-4.12.jar";

        ArtifactAttributes attributes = new ArtifactAttributes();
        attributes.setManifest(GetManifest.getMainAttributes(fileName));

        AppInventory appInventory = new AppInventory();
        appInventory.add(attributes);

        File file = File.createTempFile("appInventory", ".json");
        InventoryFileUtil.write(file, appInventory);

        String contents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        System.out.println(contents);

        AppInventory fromDisk = InventoryFileUtil.read(file);
        assertEquals(1, fromDisk.getApps().size());
    }

    @Test(expected = RuntimeException.class)
    public void testWriteBadFile() throws Exception {
        Path dir = Files.createTempDirectory("testWriteBadFile");
        InventoryFileUtil.write(dir.toFile(), null);
    }

    @Test(expected = RuntimeException.class)
    public void testReadBadFile() throws Exception {
        Path dir = Files.createTempDirectory("testReadBadFile");
        InventoryFileUtil.read(dir.toFile());
    }

    @Test
    public void testReadMergedManifests() throws Exception {
        AppInventory gavs = getTestAppInventory(this);
        assertEquals(2, gavs.getApps().size());

        Iterator<ArtifactAttributes> iterator = gavs.getApps().iterator();
        ArtifactAttributes artifact1 = iterator.next();
        assertEquals("junit", artifact1.getGroupId());
        assertEquals("junit", artifact1.getArtifactId());
        assertEquals("4.12", artifact1.getVersion());

        ArtifactAttributes artifact2 = iterator.next();
        assertEquals("ca.canada.ised.wet.cdts", artifact2.getGroupId());
        assertEquals("ca.canada.ised.wet.cdts", artifact2.getArtifactId());
        assertEquals("4.0.25.2-SNAPSHOT", artifact2.getVersion());
    }

    public static AppInventory getTestAppInventory(Object obj) {
        try {
            URL url = obj.getClass().getResource("/merged-manifests.txt");
            File file = new File(url.toURI());

            AppInventory gavs = InventoryFileUtil.readMergedManifests(file);
            return gavs;
        } catch (Exception e) {
            throw new RuntimeException("Couldn't load the merged manifest test file", e);
        }
    }

}
