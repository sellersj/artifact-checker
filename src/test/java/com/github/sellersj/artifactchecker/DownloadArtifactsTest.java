package com.github.sellersj.artifactchecker;

import java.io.File;

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
    public void testCopyFiles() {
        // create the "from" directory is it doesn't exist for this unit test.
        // TODO ensure that there is actually data in that directory
        new File(DownloadArtifacts.WORKING_DIR).mkdirs();

        // smoke test
        DownloadArtifacts downloadArtifacts = new DownloadArtifacts();
        downloadArtifacts.copyFiles();
    }

}
