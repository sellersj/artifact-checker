package com.github.sellersj.artifactchecker;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.github.sellersj.artifactchecker.model.ArtifactAttributes;

public class DownloadArtifactsTest {

    @Test
    public void testDownloadAndReadManifest() {
        ArtifactAttributes gav = new ArtifactAttributes();
        gav.getManifest().put(ArtifactAttributes.SCM_PROJECT, "sellersj");
        gav.getManifest().put(ArtifactAttributes.SCM_REPO, "artifact-checker");
        gav.getManifest().put(ArtifactAttributes.SCM_HASH, "1c6c1006f11661902b6f48cddbfa8b3ba2cc7385");

        DownloadArtifacts downloadArtifacts = new DownloadArtifacts();
        ArtifactAttributes attributes = downloadArtifacts.downloadAndReadManifest(gav);

        assertNotNull("manifest should be filled out", attributes);
        // TODO check the content of the attributes
    }

}
