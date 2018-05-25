package com.github.sellersj.artifactchecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.junit.Before;
import org.junit.Test;

import com.github.sellersj.artifactchecker.model.ArtifactAttributes;
import com.github.sellersj.artifactchecker.model.ScmCorrection;

public class ReportBuilderTest {

    private String toolsHost;

    @Before
    public void checkToolsHostSet() {
        toolsHost = System.getenv(Constants.TOOLS_HOST);
        if (!SystemUtils.IS_OS_MAC_OSX) {
            assertTrue("The TOOLS_HOST variable has to be set", StringUtils.isNotBlank(toolsHost));
        } else {
            System.err.println("The TOOLS_HOST var isn't set so some of these tests will probably fail");
        }
    }

    @Test
    public void generateAppInventory() {
        String location = "https://" + toolsHost + "/deployed-to/manifest-combined.txt";

        Set<ArtifactAttributes> apps = ReportBuilder.generateAppInventory(location);
        assertFalse("inventory should have a bunch of manifest files", apps.isEmpty());

        int appSize = apps.size();
        int appFilteredSize = ReportBuilder.getAppsFilteredByCloneUrlAndHash(apps).size();
        assertTrue("The filtering should have removed some apps. Comparing " + appSize + " to " + appFilteredSize,
            appSize > appFilteredSize);

        System.out.println("Number of apps: " + apps.size());

        List<ScmCorrection> titles = new ArrayList<ScmCorrection>();
        for (ArtifactAttributes artifactAttributes : apps) {

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

        Set<ArtifactAttributes> apps = InventoryFileUtilTest.getTestAppInventory();
        ReportBuilder.buildJsonReport(apps, target);
    }

    @Test
    public void getAppsFilteredByCloneUrlAndHash_SameProjectSameHash() {
        Set<ArtifactAttributes> apps = new HashSet<>();
        String scmProject = "myScmProject";
        String scmRepo = "myScmRepo";
        String scmHash = "3447763c6149c832408ad292ec8f4657ef9c879b";

        for (int i = 0; i < 2; i++) {
            ArtifactAttributes app = new ArtifactAttributes();
            app.getManifest().put(ArtifactAttributes.SCM_PROJECT, scmProject);
            app.getManifest().put(ArtifactAttributes.SCM_REPO, scmRepo);
            app.getManifest().put(ArtifactAttributes.SCM_HASH, scmHash);

            app.getManifest().put(ArtifactAttributes.IMPLEMENTATION_TITLE, "myAppTitle" + i);

            apps.add(app);
        }

        Set<ArtifactAttributes> filtered = ReportBuilder.getAppsFilteredByCloneUrlAndHash(apps);
        assertEquals("should have been filtered to 1 but was " + filtered, 1, filtered.size());
    }

    @Test
    public void getAppsFilteredByCloneUrlAndHash_SameProjectDifferentHash() {
        Set<ArtifactAttributes> apps = new HashSet<>();
        String scmProject = "myScmProject";
        String scmRepo = "myScmRepo";
        String scmHash = "3447763c6149c832408ad292ec8f4657ef9c879b";

        for (int i = 0; i < 2; i++) {
            ArtifactAttributes app = new ArtifactAttributes();
            app.getManifest().put(ArtifactAttributes.SCM_PROJECT, scmProject);
            app.getManifest().put(ArtifactAttributes.SCM_REPO, scmRepo);

            // set a different hash per loop
            app.getManifest().put(ArtifactAttributes.SCM_HASH, scmHash + i);

            app.getManifest().put(ArtifactAttributes.IMPLEMENTATION_TITLE, "myAppTitle" + i);

            apps.add(app);
        }

        Set<ArtifactAttributes> filtered = ReportBuilder.getAppsFilteredByCloneUrlAndHash(apps);
        assertEquals("should have been filtered to but was " + filtered, apps.size(), filtered.size());
    }

    @Test
    public void generateCveFile_PositivePath() throws Exception {
        File target = File.createTempFile("security-report-", ".html");
        // target.deleteOnExit();
        System.out.println("cve file is: " + target.getAbsolutePath());

        Set<ArtifactAttributes> apps = InventoryFileUtilTest.getTestAppInventory();

        // TODO put in a check here to make sure that there are some vulnerabilities

        ReportBuilder.generateCveFile(apps, target);
    }

}
