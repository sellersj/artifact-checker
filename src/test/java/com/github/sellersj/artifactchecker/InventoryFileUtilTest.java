package com.github.sellersj.artifactchecker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.sellersj.artifactchecker.model.App;
import com.github.sellersj.artifactchecker.model.ArtifactAttributes;
import com.github.sellersj.artifactchecker.model.MavenGAV;
import com.github.sellersj.artifactchecker.model.TechOwner;
import com.github.sellersj.artifactchecker.model.owasp.CvssV2;
import com.github.sellersj.artifactchecker.model.owasp.CvssV3;
import com.github.sellersj.artifactchecker.model.owasp.Severity;
import com.github.sellersj.artifactchecker.model.owasp.Vulnerability;

public class InventoryFileUtilTest {

    @BeforeEach
    public void setToolsHost() {
        ConstantsTest.setTestValues();
    }

    private static final Random RANDOM = new Random();

    private static final List<String> SEVERITY_CHOICES = Arrays.asList("CRITICAL", "HIGH", "MEDIUM", "LOW", "0.0");

    @Test
    public void testWriteRead() throws Exception {
        // load the junit version from the properties as captured in the pom
        DownloadArtifacts da = new DownloadArtifacts();
        Properties mavenProperties = da.getMavenProperties();

        String junitVersion = mavenProperties.getProperty("junit.version");
        assertNotNull(junitVersion, "The junit version as captured from the pom should not be null");
        String fileName = System.getProperty("user.home") + //
            "/.m2/repository/org/junit/jupiter/junit-jupiter-engine/" //
            + junitVersion + "/junit-jupiter-engine-" + junitVersion + ".jar";

        ArtifactAttributes attributes = new ArtifactAttributes();
        attributes.setManifest(GetManifest.getMainAttributes(fileName));

        Set<ArtifactAttributes> appInventory = new TreeSet<>();
        appInventory.add(attributes);

        File file = ReportBuilderTest.createTempFile("appInventory", ".json");
        InventoryFileUtil.write(file, appInventory);

        String contents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        System.out.println(contents);
        // TODO probably should check the contents of the file
    }

    @Test
    public void testWriteBadFile() throws Exception {
        Assertions.assertThrows(RuntimeException.class, () -> {
            Path dir = Files.createTempDirectory("testWriteBadFile");
            InventoryFileUtil.write(dir.toFile(), null);
        });
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

        assertTrue(junitFound, "should have found junit");
        assertTrue(wetFound, "should have found wet");
    }

    @Test
    public void testReadMergedManifestsNoEmptyProject() throws Exception {
        Set<ArtifactAttributes> apps = getTestAppInventory();
        assertFalse(apps.isEmpty(), "should be checking some apps");

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

            assertTrue(hasValues, "should have found at least one entry in the manifest: " + artifactAttributes);
        }
    }

    @Test
    public void getJiraKeysToBeDecomissioned() {
        List<String> keys = InventoryFileUtil.getJiraKeysToBeDecomissioned();
        assertNotNull(keys);
        assertFalse(keys.isEmpty(), "shouldn't be empty");
        String keyToFind = "FDOGCPD";
        assertTrue(keys.contains(keyToFind), "should contain " + keyToFind + " but had " + keys);
        assertTrue(keys.size() >= 10, "should be correct size but was " + keys.size());
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

                // set a build time
                artifactAttributes.getManifest().put(ArtifactAttributes.BUILD_TIME, getMockBuildDate());
            }
            return apps;
        } catch (Exception e) {
            throw new RuntimeException("Couldn't load the merged manifest test file", e);
        }
    }

    @Test
    public void testReadMergedPomFiles() throws Exception {
        String toolsHost = Constants.getSysOrEnvVariable(Constants.TOOLS_HOST);
        Set<MavenGAV> gavs = InventoryFileUtil
            .readMergedPomFiles(URI.create("https://" + toolsHost + "/deployed-to/pom-info-combined.txt").toURL());

        // TODO assert not empty
        assertFalse(gavs.isEmpty(), "gav list should not be empty");

        for (MavenGAV gav : gavs) {
            System.out.println(gav);

            assertNotNull(gav.getGroupId(), "groupId shouldn't be null for " + gav);
            assertNotNull(gav.getArtifactId(), "artifactId shouldn't be null for " + gav);
            assertNotNull(gav.getVersion(), "version shouldn't be null for " + gav);
        }
    }

    @Test
    public void testReadMergedApplicationListing() throws Exception {
        String appHost = Constants.getSysOrEnvVariable(Constants.WAS_CIPO_HOST);
        Set<ArtifactAttributes> attributes = InventoryFileUtil
            .readMergedApplicationListing(URI.create("https://" + appHost + "/app_version.txt").toURL());

        assertFalse(attributes.isEmpty(), "gav list should not be empty");

        for (ArtifactAttributes att : attributes) {
            assertNotNull(att.getTitle(), "title");
            assertFalse(att.getNodes().isEmpty(), "node list");
            assertNotNull(att.getBuildDate(),
                "build date for " + att + " check if this has enough info to look up in nexus");
            assertNotNull(att.getArtifactId(), "artifactId");
            assertNotNull(att.getVersion(), "version");
            assertEquals(App.DATA_CENTER_KED, att.getDeploymentInfo().getDataCenter(), "data center");
        }
    }

    @Test
    public void readTechOwners_SanityCheck() {
        File file = InventoryFileUtil.getFileOnClasspath("/tech-owner.json");
        List<TechOwner> techOwner = InventoryFileUtil.readTechOwners(file);

        // find any places in use
        TreeMap<String, List<TechOwner>> found = new TreeMap<>();
        for (TechOwner owner : techOwner) {
            if (!found.containsKey(owner.getJiraKey())) {
                found.put(owner.getJiraKey(), new ArrayList<TechOwner>());
            }

            found.get(owner.getJiraKey()).add(owner);
        }

        for (Entry<String, List<TechOwner>> entry : found.entrySet()) {
            if (entry.getValue().size() > 1) {
                fail(String.format("SHould not have %s duplicate enteries for key %s with tech owner but was %s",
                    entry.getValue().size(), entry.getKey(), entry.getValue()));
            }
        }
    }

    private static Vulnerability generateMockVulnerability() {
        Vulnerability vul = new Vulnerability();

        // make fake CVE
        vul.setName(String.format("CVE-201%s-010%s", RANDOM.nextInt(3), RANDOM.nextInt(9)));

        // RandomStringUtils.insecure().ra;
        vul.setDescription("Fake cve goes " + RandomStringUtils.secure().nextAlphanumeric(0, 100));

        BigDecimal score = new BigDecimal(RANDOM.nextFloat() * 10.0f).setScale(1, RoundingMode.HALF_UP);
        BigDecimal cvsScore = BigDecimal.valueOf(score.floatValue());
        if (RANDOM.nextBoolean()) {
            CvssV3 cvssv3 = new CvssV3();
            cvssv3.setBaseScore(cvsScore);
            vul.setCvssV3(cvssv3);
        } else {
            CvssV2 cvssv2 = new CvssV2();
            cvssv2.setScore(cvsScore);
            vul.setCvssV2(cvssv2);
        }

        // get a random severity
        Severity severity = new Severity();
        severity.setValue(SEVERITY_CHOICES.get(RANDOM.nextInt(SEVERITY_CHOICES.size())));
        vul.setSeverity(severity);

        return vul;
    }

    private static String getMockBuildDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1 * RANDOM.nextInt(90));
        cal.add(Calendar.HOUR, -1 * RANDOM.nextInt(6));
        cal.add(Calendar.MINUTE, -1 * RANDOM.nextInt(60));

        return ArtifactAttributes.MAVEN_DATE_FORMAT.format(DateUtils.asLocalDateTime(cal.getTime()));
    }

}
