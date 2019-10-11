package com.github.sellersj.artifactchecker.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void getPossibleArtifactIds() {
        App app = new App();

        for (String suffix : App.DEPLOYMENT_SUFFIX_LIST) {

            String baseName = "MY_APPLICATION";
            app.getAttributes().put("APP", Arrays.asList(baseName + suffix));

            List<String> expected = Arrays.asList(//
                baseName, // just the artifactId
                baseName + "-ear", //
                baseName + "-app", //
                baseName + "_EAR", //
                baseName + "EAR" //
            );

            List<String> possibleArtifactIds = app.getPossibleArtifactIds();
            for (String string : expected) {
                assertTrue(possibleArtifactIds.contains(string),
                    "should have found: " + string + " but had " + possibleArtifactIds);
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

    @Test
    public void getDeploymentDateAsStringNoValue() {
        App app = new App();
        assertNull(app.getDeploymentDate());
    }

    @Test
    public void getDeploymentDateAsStringGarbageValue() {
        // if unparsble, give back null
        String input = "aksfhaskjfh";
        App app = new App();
        app.putItem(App.DEPLOY_DATE, input);
        assertNull(app.getDeploymentDate());
    }

    @Test
    public void getDeploymentDateAsStringActualValue() {
        String input = "Tue May 16 13:46:34 2017";
        App app = new App();
        app.putItem(App.DEPLOY_DATE, input);

        // being lazy and just comparing the toString values
        assertEquals("Tue May 16 13:46:34 EDT 2017", app.getDeploymentDate().toString());
    }

    @Test
    public void getDeploymentDateAsStringActualValueHasManySpacesInIt() {
        String input = "Thu Aug  8 07:11:09 2019";
        App app = new App();
        app.putItem(App.DEPLOY_DATE, input);

        // being lazy and just comparing the toString values
        assertNotNull(app.getDeploymentDate(), "the date shouldn't be null");
        assertEquals("Thu Aug 08 07:11:09 EDT 2019", app.getDeploymentDate().toString());
    }
}
