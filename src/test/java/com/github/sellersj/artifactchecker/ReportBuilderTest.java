package com.github.sellersj.artifactchecker;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import com.github.sellersj.artifactchecker.model.AppInventory;

public class ReportBuilderTest {

    private String toolsHost;

    @Before
    public void checkToolsHostSet() {
        toolsHost = System.getenv("TOOLS_HOST");
        assertTrue("The TOOLS_HOST variable has to be set", StringUtils.isNotBlank(toolsHost));
    }

    @Test
    public void generateAppInventory() {
        String location = "https://" + toolsHost + "/deployed-to/manifest-combined.txt";

        AppInventory inventory = ReportBuilder.generateAppInventory(location);
        assertNotNull("inventory shouldn't be null", inventory);
        assertFalse("inventory should have a bunch of manifest files", inventory.getApps().isEmpty());
    }

    @Test
    public void buildJsonReport() {
        String target = "/data00/bamboo/projectsites/app-inventory.json";
        AppInventory inventory = InventoryFileUtilTest.getTestAppInventory(this);
        ReportBuilder.buildJsonReport(inventory, target);
    }

}
