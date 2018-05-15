package com.github.sellersj.artifactchecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
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
import com.github.sellersj.artifactchecker.model.owasp.Vulnerability;

public class InventoryFileUtilTest {

    private static final Random RANDOM = new Random();

    private static final List<String> SEVERITY_CHOICES = Arrays.asList("High", "Medium", "Low");

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

            for (ArtifactAttributes artifactAttributes : apps) {
                // jria key
                if (StringUtils.isBlank(artifactAttributes.getJiraKey())) {
                    artifactAttributes.getManifest().put(ArtifactAttributes.ISSUE_TRACKING, "FAKE");
                }

                // generate some vulnerabilities
                int numberOfVul = RANDOM.nextInt(5) + 2;
                for (int i = 0; i < numberOfVul; i++) {
                    artifactAttributes.getVulnerabilities().add(generateMockVulnerability());
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
        vul.setName(String.format("CVE-201%s-010%s", RANDOM.nextInt(10), twoDigitInt()));

        vul.setDescription("Fake cve goes " + RandomStringUtils.randomAlphanumeric(0, 100));

        BigDecimal cvsScore = BigDecimal.valueOf(RANDOM.nextDouble() * 10.0).setScale(1, BigDecimal.ROUND_HALF_UP);
        vul.setCvssScore(cvsScore.toPlainString());

        // get a random severity
        vul.setSeverity(SEVERITY_CHOICES.get(RANDOM.nextInt(SEVERITY_CHOICES.size())));

        return vul;
    }

    private static final int twoDigitInt() {
        return RANDOM.nextInt(90) + 10;
    }

}
