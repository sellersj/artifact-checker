package com.github.sellersj.artifactchecker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
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

    @Test
    public void getLoginPageLines() throws Exception {
        File baseDir = Files.createTempDirectory("tmpDirPrefix").toFile();
        {
            File jsp = new File(baseDir, "src/main/webapp/WEB-INF/loginForm.jsp");
            jsp.deleteOnExit();
            jsp.getParentFile().mkdirs();
            FileUtils.writeLines(jsp, Arrays.asList("something", //
                "my form /login that shoudl match in jsp", //
                "this should not match "));
        }
        {
            File html = new File(baseDir, "src/main/resources/loginForm.html");
            html.deleteOnExit();
            html.getParentFile().mkdirs();
            FileUtils.writeLines(html, Arrays.asList("something", //
                "my form j_security_check that shoudl match in html", //
                "this should not match "));
        }
        {
            // add a file we're not checking for
            File bad = new File(baseDir, "src/main/resources/another.html");
            bad.deleteOnExit();
            bad.getParentFile().mkdirs();
            FileUtils.writeLines(bad, Arrays.asList("something", //
                "should not match", //
                "this should not match "));
        }

        Set<String> lines = check.getLoginPageLines(baseDir);
        assertEquals(2, lines.size(), "should have the right number for " + lines);

        // make sure we didn't find the "bad" file
        for (String string : lines) {
            assertFalse(string.contains("another.html"), "not what we were expecting. It was " + string);
        }
    }

}
