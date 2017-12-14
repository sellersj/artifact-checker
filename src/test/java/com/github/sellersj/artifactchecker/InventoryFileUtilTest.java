package com.github.sellersj.artifactchecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.github.sellersj.artifactchecker.model.AppInventory;
import com.github.sellersj.artifactchecker.model.ArtifactAttributes;

public class InventoryFileUtilTest {

    @Test
    public void testWriteRead() throws Exception {
        // this will probably fail if maven repo in different location
        String fileName = "/Users/sellersj/.m2/repository/junit/junit/4.12/junit-4.12.jar";

        ArtifactAttributes attributes = new ArtifactAttributes();
        attributes.setManifest(GetManifest.getMainAttributes(fileName));

        AppInventory appInventory = new AppInventory();
        appInventory.add(attributes);

        File file = File.createTempFile("appInventory", ".json");
        InventoryFileUtil.write(file, appInventory);

        String contents = FileUtils.readFileToString(file, Charset.defaultCharset());
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
        URL url = this.getClass().getResource("/merged-manifests.txt");
        File file = new File(url.toURI());

        AppInventory gavs = InventoryFileUtil.readMergedManifests(file);
        assertEquals(2, gavs.getApps().size());

        for (ArtifactAttributes gav : gavs.getApps()) {
            assertEquals("junit", gav.getGroupId());
            assertEquals("4.12", gav.getVersion());

            assertTrue("junit".equals(gav.getArtifactId()) //
                || "jackson-databind".equals(gav.getArtifactId()));
        }
    }

}
