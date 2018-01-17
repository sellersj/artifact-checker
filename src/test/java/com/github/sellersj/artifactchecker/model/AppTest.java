package com.github.sellersj.artifactchecker.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AppTest {

    @Test
    public void getPossibleArtifactIds() {
        App app = new App();

        List<String> suffixes = Arrays.asList("__PUBLIC", "__INTRA", "_UTF8-Intra");

        for (String suffix : suffixes) {

            String baseName = "MY_APPLICATION";
            app.getAttributes().put("APP", Arrays.asList(baseName + suffix));

            List<String> expected = Arrays.asList(//
                baseName + "-ear", //
                baseName + "EAR", //
                baseName + "-app" //
            );

            List<String> possibleArtifactIds = app.getPossibleArtifactIds();
            for (String string : expected) {
                assertTrue("should have found: " + string + " but had " + possibleArtifactIds,
                    possibleArtifactIds.contains(string));
            }
        }
    }

    @Test
    public void containsVersionHasVersion() {
        String version = "1.2.9";
        App app = new App();
        app.putItem(App.BUILD_VERSION, version);
        assertTrue(app.containsVersion(version));
    }

    @Test
    public void containsVersionDoesNotHaveVersion() {
        String version = "1.2.9";
        App app = new App();
        app.putItem(App.BUILD_VERSION, "9.2.2");
        assertFalse(app.containsVersion(version));
    }
}
