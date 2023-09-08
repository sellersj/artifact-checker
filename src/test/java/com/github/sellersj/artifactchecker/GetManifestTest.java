package com.github.sellersj.artifactchecker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URL;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

public class GetManifestTest {

    @Test
    public void getMainAtributes() throws Exception {

        String junitVersion = getJunitVersion();
        String fileName = System.getProperty("user.home")
            + String.format("/.m2/repository/org/junit/jupiter/junit-jupiter-api/%s/junit-jupiter-api-%s.jar",
                junitVersion, junitVersion);

        Map<String, String> attributes = GetManifest.getMainAttributes(fileName);

        assertFalse(attributes.isEmpty());
        assertTrue(attributes.containsKey("Built-By"));

        assertEquals("junit.org", attributes.get("Implementation-Vendor"));
        assertEquals("junit-jupiter-api", attributes.get("Specification-Title"));
        assertEquals(junitVersion, attributes.get("Implementation-Version"));
    }

    /**
     * Rather than messing around with maven properties we are just parsing out the version from the jar path.
     * 
     * @return the junit version
     * @throws Exception
     */
    private String getJunitVersion() throws Exception {
        Class<Test> testClass = Test.class;

        URL location = testClass.getResource('/' + testClass.getName().replace('.', '/') + ".class");
        String urlPath = location.toString();
        String jarLocation = StringUtils.substringBefore(urlPath, ".jar!");
        String[] split = jarLocation.split("/");
        String version = split[split.length - 2];

        return version;
    }

}
