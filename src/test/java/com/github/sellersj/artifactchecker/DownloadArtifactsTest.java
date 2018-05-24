package com.github.sellersj.artifactchecker;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.github.sellersj.artifactchecker.model.ArtifactAttributes;

public class DownloadArtifactsTest {

    @Test
    public void testcloneAndCheckProjectNotCloneable() {
        ArtifactAttributes gav = new ArtifactAttributes();

        DownloadArtifacts downloadArtifacts = new DownloadArtifacts();
        downloadArtifacts.cloneAndCheckProject(gav);

        // TODO check the content of the attributes
    }

    @Test
    @Ignore("ignore for now. CI server has trouble reading this for some reason.")
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

        // TODO check the content of the attributes
    }

    @Test
    public void testcloneAndCheckProjectSpringBootThymleaf() {
        ArtifactAttributes gav = new ArtifactAttributes();
        gav.setGithub(true);
        gav.getManifest().put(ArtifactAttributes.SCM_PROJECT, "wet-boew");
        gav.getManifest().put(ArtifactAttributes.SCM_REPO, "spring-boot-thymeleaf");
        gav.getManifest().put(ArtifactAttributes.VERSION, "4.0.26.2");

        DownloadArtifacts downloadArtifacts = new DownloadArtifacts();
        downloadArtifacts.cloneAndCheckProject(gav);

        // TODO check the content of the attributes
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
    @Ignore
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
        assertEquals("size", 1, matchingTags.size());
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
        assertEquals("size", size, matchingTags.size());
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
        assertEquals("should be empty", 0, matchingTags.size());
    }

}
