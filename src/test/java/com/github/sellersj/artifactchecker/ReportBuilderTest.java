package com.github.sellersj.artifactchecker;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import com.github.sellersj.artifactchecker.model.AppInventory;
import com.github.sellersj.artifactchecker.model.ArtifactAttributes;
import com.github.sellersj.artifactchecker.model.ScmCorrection;

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

        int appSize = inventory.getApps().size();
        int appFilteredSize = inventory.getAppsFilteredByCloneUrl().size();
        assertTrue("The filtering should have removed some apps. Comparing " + appSize + " to " + appFilteredSize,
            appSize > appFilteredSize);

        System.out.println("Number of apps: " + inventory.getApps().size());

        List<ScmCorrection> titles = new ArrayList<ScmCorrection>();
        for (ArtifactAttributes artifactAttributes : inventory.getApps()) {

            if (!artifactAttributes.hasRequiredGitInfo() && StringUtils.isNotBlank(artifactAttributes.getScmHash())) {
                System.out.println(artifactAttributes);

                ScmCorrection correction = new ScmCorrection();
                correction.setImplementationTitle(artifactAttributes.getManifest().get("Implementation-Title"));
                titles.add(correction);
            }
        }

        System.out.println("Size is apps missing titles: " + titles.size());
        Collections.sort(titles);
        for (ScmCorrection correction : titles) {
            System.out.println(correction.getImplementationTitle());
        }

        File output = new File("target/scm-corrections.json");
        System.out.println("writing file with corrections to: " + output.getAbsolutePath());
        InventoryFileUtil.write(output, titles);
    }

    @Test
    public void buildJsonReport() throws Exception {
        File target = File.createTempFile("app-inventory-", ".json");
        target.deleteOnExit();

        AppInventory inventory = InventoryFileUtilTest.getTestAppInventory();
        ReportBuilder.buildJsonReport(inventory, target);
    }

}
