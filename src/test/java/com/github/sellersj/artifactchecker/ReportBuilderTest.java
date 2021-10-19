package com.github.sellersj.artifactchecker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.sellersj.artifactchecker.model.ArtifactAttributes;
import com.github.sellersj.artifactchecker.model.ScmCorrection;
import com.github.sellersj.artifactchecker.model.owasp.Vulnerability;

public class ReportBuilderTest {

    private String toolsHost;

    @BeforeEach
    public void setToolsHost() {
        ConstantsTest.setTestValues();
        toolsHost = Constants.getSysOrEnvVariable(Constants.TOOLS_HOST);
    }

    @Test
    public void generateAppInventory() {
        String location = "https://" + toolsHost + "/deployed-to/manifest-combined.txt";

        Set<ArtifactAttributes> apps = ReportBuilder.generateAppInventory(location);
        assertFalse(apps.isEmpty(), "inventory should have a bunch of manifest files");

        int appSize = apps.size();
        int appFilteredSize = ReportBuilder.getAppsFilteredByCloneUrlAndHash(apps).size();
        assertTrue(appSize > appFilteredSize,
            "The filtering should have removed some apps. Comparing " + appSize + " to " + appFilteredSize);

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
    public void buildCsvReport() throws Exception {
        File target = File.createTempFile("app-inventory-", ".csv");
        // System.out.println(target.getAbsolutePath());
        target.deleteOnExit();

        Set<ArtifactAttributes> apps = InventoryFileUtilTest.getTestAppInventory();
        ReportBuilder.buildCsvReport(apps, target);
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
        assertEquals(1, filtered.size(), "should have been filtered to 1 but was " + filtered);
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
        assertEquals(apps.size(), filtered.size(), "should have been filtered to but was " + filtered);
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

    @Test
    public void updateAppsTrackedByAnotherArtifact_ScmHashes() {
        Set<ArtifactAttributes> apps = new HashSet<>();

        for (int i = 0; i < 2; i++) {
            ArtifactAttributes app1 = new ArtifactAttributes();
            app1.setCorrectedScmProject("myProject");
            app1.setCorrectedScmRepo("myRepo");
            app1.getManifest().put(ArtifactAttributes.SCM_HASH, "12348");

            if (0 == i) {
                app1.setAlreadyTrackedByAnother(true);
            } else {
                app1.setJava8Ready(true);
                app1.setLibraryCheckedWorked(false);
                List<Vulnerability> vulnerabilities = Arrays.asList(new Vulnerability());
                app1.setVulnerabilities(vulnerabilities);
            }

            apps.add(app1);
        }

        ReportBuilder.updateAppsTrackedByAnotherArtifact(apps);

        // check that all all items are set
        for (ArtifactAttributes artifactAttributes : apps) {
            assertTrue(artifactAttributes.isJava8Ready(), "java 8 not set set properly for " + artifactAttributes);
            assertFalse(artifactAttributes.isLibraryCheckedWorked(),
                "library check not set set properly for " + artifactAttributes);
            assertEquals(1, artifactAttributes.getVulnerabilities().size(), "not right vuls for " + artifactAttributes);
        }
    }

    @Test
    public void updateAppsTrackedByAnotherArtifact_NoScmHashesOnlyVersions() {
        Set<ArtifactAttributes> apps = new HashSet<>();

        for (int i = 0; i < 2; i++) {
            ArtifactAttributes app1 = new ArtifactAttributes();
            app1.setCorrectedScmProject("myProject");
            app1.setCorrectedScmRepo("myRepo");
            app1.getManifest().put(ArtifactAttributes.VERSION, "1.2.3");

            if (0 == i) {
                app1.setAlreadyTrackedByAnother(true);
            } else {
                app1.setJava8Ready(true);
                List<Vulnerability> vulnerabilities = Arrays.asList(new Vulnerability());
                app1.setVulnerabilities(vulnerabilities);
            }

            apps.add(app1);
        }

        ReportBuilder.updateAppsTrackedByAnotherArtifact(apps);

        // check that all all items are set
        for (ArtifactAttributes artifactAttributes : apps) {
            assertTrue(artifactAttributes.isJava8Ready(), "java 8 not set set properly for " + artifactAttributes);
            assertEquals(1, artifactAttributes.getVulnerabilities().size(), "not right vuls for " + artifactAttributes);
        }
    }

}
