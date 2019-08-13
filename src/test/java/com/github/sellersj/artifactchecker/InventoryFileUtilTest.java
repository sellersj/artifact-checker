package com.github.sellersj.artifactchecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.github.sellersj.artifactchecker.model.ArtifactAttributes;
import com.github.sellersj.artifactchecker.model.owasp.Cvssv2;
import com.github.sellersj.artifactchecker.model.owasp.Cvssv3;
import com.github.sellersj.artifactchecker.model.owasp.Vulnerability;

public class InventoryFileUtilTest {

    private static final Random RANDOM = new Random();

    private static final List<String> SEVERITY_CHOICES = Arrays.asList("CRITICAL", "HIGH", "MEDIUM", "LOW", "0.0");

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
    public void testReadMergedManifests() throws Exception {
        Set<ArtifactAttributes> apps = getTestAppInventory();
        assertEquals(2, apps.size());

        boolean junitFound = false;
        boolean wetFound = false;

        for (ArtifactAttributes art : apps) {

            if ("junit".equals(art.getGroupId())) {
                junitFound = true;
                assertEquals("junit", art.getGroupId());
                assertEquals("junit", art.getArtifactId());
                assertEquals("4.12", art.getVersion());
            }

            if ("ca.canada.ised.wet.cdts".equals(art.getGroupId())) {
                wetFound = true;
                assertEquals("ca.canada.ised.wet.cdts", art.getGroupId());
                assertEquals("wet-cdts-spring-boot-thymeleaf-starter", art.getArtifactId());
                assertEquals("4.0.25.2-SNAPSHOT", art.getVersion());
            }
        }

        assertTrue("should have found junit", junitFound);
        assertTrue("should have found wet", wetFound);
    }

    @Test
    public void testReadMergedManifestsNoEmptyProject() throws Exception {
        Set<ArtifactAttributes> apps = getTestAppInventory();
        assertFalse("should be checking some apps", apps.isEmpty());

        for (ArtifactAttributes artifactAttributes : apps) {

            // the app should have _at least one_ value in the manifest for us to not ignore it
            boolean hasValues = false;
            for (Entry<String, String> entry : artifactAttributes.getManifest().entrySet()) {

                // ignore the manifest declaration
                if (!"Manifest-Version".equals(entry.getKey()) && //
                    StringUtils.isNotBlank(entry.getValue())) {
                    // System.out.println(entry.getValue());
                    hasValues = true;
                }
            }

            assertTrue("should have found at least one entry in the manifest: " + artifactAttributes, hasValues);
        }
    }

    public static Set<ArtifactAttributes> getTestAppInventory() {
        try {
            File file = InventoryFileUtil.getFileOnClasspath("/merged-manifests.txt");
            Set<ArtifactAttributes> apps = InventoryFileUtil.readMergedManifests(file);

            // generate a bunch of vul's

            List<Vulnerability> vuls = new ArrayList<>();
            for (int i = 0; i < 15; i++) {
                vuls.add(generateMockVulnerability());
            }

            for (ArtifactAttributes artifactAttributes : apps) {
                // jria key
                if (StringUtils.isBlank(artifactAttributes.getJiraKey())) {
                    artifactAttributes.getManifest().put(ArtifactAttributes.ISSUE_TRACKING, "FAKE");
                }

                int numberOfVul = RANDOM.nextInt(vuls.size() / 2) + 2;
                for (int i = 0; i < numberOfVul; i++) {
                    artifactAttributes.getVulnerabilities().add(vuls.get(RANDOM.nextInt(vuls.size())));
                }
            }
            return apps;
        } catch (Exception e) {
            throw new RuntimeException("Couldn't load the merged manifest test file", e);
        }
    }

    private static Vulnerability generateMockVulnerability() {
        Vulnerability vul = new Vulnerability();

        // make fake CVE
        vul.setName(String.format("CVE-201%s-010%s", RANDOM.nextInt(3), RANDOM.nextInt(9)));

        vul.setDescription("Fake cve goes " + RandomStringUtils.randomAlphanumeric(0, 100));

        BigDecimal score = new BigDecimal(RANDOM.nextFloat() * 10.0f).setScale(1, BigDecimal.ROUND_HALF_UP);
        Float cvsScore = Float.valueOf(score.floatValue());
        if (RANDOM.nextBoolean()) {
            Cvssv3 cvssv3 = new Cvssv3();
            cvssv3.setBaseScore(cvsScore);
            vul.setCvssv3(cvssv3);
        } else {
            Cvssv2 cvssv2 = new Cvssv2();
            cvssv2.setScore(cvsScore);
            vul.setCvssv2(cvssv2);
        }

        // get a random severity
        vul.setSeverity(SEVERITY_CHOICES.get(RANDOM.nextInt(SEVERITY_CHOICES.size())));

        return vul;
    }

}
