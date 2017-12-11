package com.github.sellersj.artifactchecker;

import static org.junit.Assert.assertEquals;

import java.io.File;

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
        System.out.println(file.getAbsolutePath());
        InventoryFileUtil.write(file, appInventory);

        AppInventory fromDisk = InventoryFileUtil.read(file);
        assertEquals(1, fromDisk.getApps().size());
    }

}
