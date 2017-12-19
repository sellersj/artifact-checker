package com.github.sellersj.artifactchecker;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;

import com.github.sellersj.artifactchecker.model.ArtifactAttributes;

public class DownloadArtifactsTest {

    @Test
    @Ignore("Needs to be refactored")
    public void testDownloadAndReadManifest() {
        ArtifactAttributes gav = new ArtifactAttributes();
        gav.getManifest();
        // gav.setGroupId("junit");
        // gav.setArtifactId("junit");
        // gav.setVersion("4.12");
        // gav.setPackaging("jar");

        DownloadArtifacts downloadArtifacts = new DownloadArtifacts();
        ArtifactAttributes attributes = downloadArtifacts.downloadAndReadManifest(gav);

        assertNotNull("manifest should be filled out", attributes);
        // TODO check the content of the attributes
    }

}
