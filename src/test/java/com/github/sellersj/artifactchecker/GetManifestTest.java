package com.github.sellersj.artifactchecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

public class GetManifestTest {

    @Test
    public void getMainAtributes() throws Exception {
        String fileName = System.getProperty("user.home") + "/.m2/repository/junit/junit/4.12/junit-4.12.jar";

        Map<String, String> attributes = GetManifest.getMainAttributes(fileName);

        assertFalse(attributes.isEmpty());
        assertTrue(attributes.containsKey("Built-By"));

        assertEquals("JUnit", attributes.get("Implementation-Vendor"));
        assertEquals("junit", attributes.get("Implementation-Vendor-Id"));
        assertEquals("4.12", attributes.get("Implementation-Version"));
    }

}
