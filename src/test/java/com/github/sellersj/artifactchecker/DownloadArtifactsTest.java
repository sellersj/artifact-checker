package com.github.sellersj.artifactchecker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.github.sellersj.artifactchecker.model.ArtifactAttributes;
import com.github.sellersj.artifactchecker.model.owasp.Vulnerability;

public class DownloadArtifactsTest {

    @Test
    public void testcloneAndCheckProjectNotCloneable() {
        ArtifactAttributes gav = new ArtifactAttributes();

        DownloadArtifacts downloadArtifacts = new DownloadArtifacts();
        downloadArtifacts.cloneAndCheckProject(gav);

        // TODO check the content of the attributes
    }

    @Test
    @Disabled("ignore for now. CI server has trouble reading this for some reason.")
    public void testcloneAndCheckProject() {
        ArtifactAttributes gav = new ArtifactAttributes();
        gav.setGithub(true);
        gav.getManifest().put(ArtifactAttributes.SCM_PROJECT, "sellersj");
        gav.getManifest().put(ArtifactAttributes.SCM_REPO, "tomcat-extractor");
        gav.getManifest().put(ArtifactAttributes.SCM_HASH, "e507b001c2a170c6f7c50169a48aaa76ad3b4c3f");

        DownloadArtifacts downloadArtifacts = new DownloadArtifacts();
        downloadArtifacts.cloneAndCheckProject(gav);

        // TODO check the content of the attributes
    }

    @Test
    public void testcloneAndCheckProjectTestProject() {
        ArtifactAttributes gav = new ArtifactAttributes();
        gav.getManifest().put(ArtifactAttributes.SCM_PROJECT, "sandbox");
        gav.getManifest().put(ArtifactAttributes.SCM_REPO, "sis-test-project");
        gav.getManifest().put(ArtifactAttributes.SCM_HASH, "c8e6aa1828945fb7db31762f1c39dccd16cd3e34");

        DownloadArtifacts downloadArtifacts = new DownloadArtifacts();
        downloadArtifacts.cloneAndCheckProject(gav);

        // if this test fails with a xsd error, check that the owasp.dependency.check.xsd.file property in the pom file
        // matches what is being generated.

        // TODO check the content of the attributes
    }

    @Test
    public void testcloneAndCheckProjectSpringBootThymleaf(TestInfo testInfo) {
        if (!SystemUtils.IS_OS_MAC_OSX) {
            System.out.println("Not going to run the test " + testInfo.getTestMethod() + " except on a mac");
            return;
        }

        ArtifactAttributes gav = new ArtifactAttributes();
        gav.setGithub(true);
        gav.getManifest().put(ArtifactAttributes.SCM_PROJECT, "wet-boew");
        gav.getManifest().put(ArtifactAttributes.SCM_REPO, "spring-boot-thymeleaf");
        gav.getManifest().put(ArtifactAttributes.VERSION, "4.0.26.2");

        DownloadArtifacts downloadArtifacts = new DownloadArtifacts();
        downloadArtifacts.cloneAndCheckProject(gav);

        // check the content of the attributes
        assertEquals("2018-02-13 14:56:54 -0500", gav.getScmAuthorDate(), "commit date");
        assertEquals("wet-cdts-spring-boot-thymeleaf-starter-4.0.26.2", gav.getScmTag(), "scm tag");

        // extra checks for the date
        Date buildDate = gav.getBuildDate();
        assertNotNull(buildDate, "build date shouldn't be null");
        Calendar cal = Calendar.getInstance();
        cal.setTime(buildDate);

        assertEquals(2018, cal.get(Calendar.YEAR), "year");
        assertEquals(1, cal.get(Calendar.MONTH), "month");
        assertEquals(13, cal.get(Calendar.DAY_OF_MONTH), "day of month");
    }

    @Test
    public void testCopyFiles() {
        // create the "from" directory is it doesn't exist for this unit test.
        // TODO ensure that there is actually data in that directory
        new File(DownloadArtifacts.WORKING_DIR).mkdirs();

        // smoke test
        DownloadArtifacts downloadArtifacts = new DownloadArtifacts();
        downloadArtifacts.copyFiles();
    }

    @Test
    @Disabled
    public void testSwitchToCommitNoHash() {
        // TODO refactor this test
        File directory = new File("E:/Workspaces/IC_Eclipse_44/TestProject");
        if (!directory.exists()) {
            System.err.println(directory.getAbsolutePath() + " doesn't exist. Exiting test");
            return;
        }

        ArtifactAttributes gav = new ArtifactAttributes();
        gav.getManifest().put(ArtifactAttributes.VERSION, "1.5.11");

        DownloadArtifacts downloadArtifacts = new DownloadArtifacts();
        downloadArtifacts.switchToCommit(gav, directory);

    }

    @Test
    public void getMatchingTagsOneLine() {
        String tags = "1.5.11\n";

        DownloadArtifacts downloadArtifacts = new DownloadArtifacts();
        List<String> matchingTags = downloadArtifacts.getMatchingTags(tags);
        assertEquals(1, matchingTags.size(), "size");
        assertEquals("1.5.11", matchingTags.get(0));
    }

    @Test
    public void getMatchingTagsManyLine() {
        int size = 4;
        String tags = "";
        for (int i = 0; i < size; i++) {
            tags += "1.5.1" + i + "\n";
        }

        DownloadArtifacts downloadArtifacts = new DownloadArtifacts();
        List<String> matchingTags = downloadArtifacts.getMatchingTags(tags);
        assertEquals(size, matchingTags.size(), "size");
    }

    @Test
    public void getMatchingTagsManyBlankLines() {
        int size = 4;
        String tags = "";
        for (int i = 0; i < size; i++) {
            tags += "\r\n\t\n";
        }

        DownloadArtifacts downloadArtifacts = new DownloadArtifacts();
        List<String> matchingTags = downloadArtifacts.getMatchingTags(tags);
        assertEquals(0, matchingTags.size(), "should be empty");
    }

    /**
     * Used to supply an updated form to check for the dependenices
     *
     * @throws Exception
     */
    @Test
    @Disabled
    public void parseDependencyCheckReport() throws Exception {
        String url = "https://.../dependency-check-report.xml";
        File tempFile = File.createTempFile("dependency-check-report", ".json");
        FileUtils.copyURLToFile(URI.create(url).toURL(), tempFile);

        DownloadArtifacts downloadArtifacts = new DownloadArtifacts();
        List<Vulnerability> vuls = downloadArtifacts.parseDependencyCheckReport(tempFile);

        System.out.println(vuls);
    }

}
