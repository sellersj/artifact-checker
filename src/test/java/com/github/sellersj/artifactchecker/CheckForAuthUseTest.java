package com.github.sellersj.artifactchecker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class CheckForAuthUseTest {

    private CheckForAuthUse check = new CheckForAuthUse();

    @Test
    public void getWebDotXmlFiles_NoneInThisProject() {
        File dir = new File(".");
        List<File> list = check.getWebDotXmlFiles(dir);
        assertEquals(0, list.size(), "should be empty but had " + list);
    }

    @Test
    public void getSecurityRoleNames() {
        File file = new File("./src/test/resources/cma-example-web.xml");

        List<String> expected = Arrays.asList("Administrator", "Reviewer");
        Set<String> roles = check.getSecurityRoleNames(file);

        assertEquals(2, roles.size(), "should have the right number for " + roles);
        assertTrue(roles.containsAll(expected), "not what we were expecting. It was " + roles);
    }

}
