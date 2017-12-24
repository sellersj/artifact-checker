package com.github.sellersj.artifactchecker;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.junit.Ignore;
import org.junit.Test;

import com.github.sellersj.artifactchecker.model.ArtifactAttributes;

public class InventoryFileUtilTest {

    @Test
    public void testWriteRead() throws Exception {
        // this will probably fail if maven repo in different location
        String fileName = System.getProperty("user.home") + "/.m2/repository/junit/junit/4.12/junit-4.12.jar";

        ArtifactAttributes attributes = new ArtifactAttributes();
        attributes.setManifest(GetManifest.getMainAttributes(fileName));

        Set<ArtifactAttributes> appInventory = new TreeSet<>();
        appInventory.add(attributes);

        File file = File.createTempFile("appInventory", ".json");
        InventoryFileUtil.write(file, appInventory);

        String contents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        System.out.println(contents);
        // TODO probably should check the contents of the file
    }

    @Test(expected = RuntimeException.class)
    public void testWriteBadFile() throws Exception {
        Path dir = Files.createTempDirectory("testWriteBadFile");
        InventoryFileUtil.write(dir.toFile(), null);
    }

    @Test
    @Ignore("don't think we need to read this file at this point")
    public void testReadMergedManifests() throws Exception {
        Set<ArtifactAttributes> apps = getTestAppInventory();
        assertEquals(2, apps.size());

        Iterator<ArtifactAttributes> iterator = apps.iterator();

        ArtifactAttributes artifact2 = iterator.next();
        assertEquals("ca.canada.ised.wet.cdts", artifact2.getGroupId());
        assertEquals("wet-cdts-spring-boot-thymeleaf-starter", artifact2.getArtifactId());
        assertEquals("4.0.25.2-SNAPSHOT", artifact2.getVersion());

        ArtifactAttributes artifact1 = iterator.next();
        assertEquals("junit", artifact1.getGroupId());
        assertEquals("junit", artifact1.getArtifactId());
        assertEquals("4.12", artifact1.getVersion());
    }

    public static Set<ArtifactAttributes> getTestAppInventory() {
        try {
            File file = InventoryFileUtil.getFileOnClasspath("/merged-manifests.txt");
            Set<ArtifactAttributes> apps = InventoryFileUtil.readMergedManifests(file);
            return apps;
        } catch (Exception e) {
            throw new RuntimeException("Couldn't load the merged manifest test file", e);
        }
    }

}
