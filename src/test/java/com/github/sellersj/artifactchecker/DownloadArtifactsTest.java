package com.github.sellersj.artifactchecker;

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
    public void testcloneAndCheckProject() {
        ArtifactAttributes gav = new ArtifactAttributes();
        gav.setGithub(true);
        gav.getManifest().put(ArtifactAttributes.SCM_PROJECT, "sellersj");
        gav.getManifest().put(ArtifactAttributes.SCM_REPO, "artifact-checker");
        gav.getManifest().put(ArtifactAttributes.SCM_HASH, "1c6c1006f11661902b6f48cddbfa8b3ba2cc7385");

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
        // smoke test
        DownloadArtifacts downloadArtifacts = new DownloadArtifacts();
        downloadArtifacts.copyFiles();
    }

}
