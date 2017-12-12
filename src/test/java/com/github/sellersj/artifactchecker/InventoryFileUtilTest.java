package com.github.sellersj.artifactchecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

import org.junit.Test;

import com.github.sellersj.artifactchecker.model.App;
import com.github.sellersj.artifactchecker.model.AppInventory;

public class InventoryFileUtilTest {

    @Test
    public void testWriteRead() throws Exception {
        // this will probably fail if maven repo in different location
        String fileName = "/Users/sellersj/.m2/repository/junit/junit/4.12/junit-4.12.jar";

        App app = new App();
        app.setGroupId("junit");
        app.setArtifactId("junit");
        app.setVersion("4.12");
        app.setManifest(GetManifest.getMainAttributes(fileName));

        AppInventory appInventory = new AppInventory();
        appInventory.add(app);

        File file = File.createTempFile("appInventory", ".json");
        InventoryFileUtil.write(file, appInventory);

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
    public void testReadMergedPomProperties() throws Exception {
        URL url = this.getClass().getResource("/merged-pom.properties");
        File file = new File(url.toURI());

        Set<App> apps = InventoryFileUtil.readMergedPomProperties(file);
        assertEquals(2, apps.size());

        for (App app : apps) {
            assertEquals("com.fasterxml.jackson.core", app.getGroupId());
            assertEquals("2.9.3", app.getVersion());

            assertTrue("jackson-core".equals(app.getArtifactId()) //
                || "jackson-databind".equals(app.getArtifactId()));
        }
    }

}
