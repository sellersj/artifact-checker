package com.github.sellersj.artifactchecker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class CheckForTemplatingUseTest {

    private CheckForTemplatingUse checkForTemplatingUse = new CheckForTemplatingUse();

    @Test
    public void getJspFiles_NoneInThisProject() {
        File dir = new File(".");
        List<File> list = checkForTemplatingUse.getJspFiles(dir);
        assertEquals(0, list.size(), "should be empty but had " + list);
    }

    @Test
    public void getTemplateNames() {
        List<String> lines = Arrays.asList(
            // "./ALSC_AdminWAR/src/main/webapp/WEB-INF/content/common/headFoot/footer.jsp:3:<template:write
            // templateName=\"usability-2-col-template\" sectionName=\"EPIC_FOOTER\">",
            "./ALSC_AdminWAR/src/main/webapp/WEB-INF/content/common/headFoot/footer1Col.jsp:3:<template:write templateName=\"usability-1-col-template\" sectionName=\"EPIC_FOOTER\">",
            "./ALSC_AdminWAR/src/main/webapp/WEB-INF/content/common/headFoot/header.jsp:5:<template:write templateName=\"usability-2-col-template\" sectionName=\"EPIC_HEADER\">",
            "./ALSC_AdminWAR/src/main/webapp/WEB-INF/content/common/headFoot/header1Col.jsp:5:<template:write templateName=\"usability-1-col-template\" sectionName=\"EPIC_HEADER\">");

        List<String> expected = Arrays.asList("usability-1-col-template", "usability-2-col-template");

        Set<String> templateNames = checkForTemplatingUse.getTemplateNames(lines);
        assertEquals(2, templateNames.size(), "should have the right number");
        assertTrue(templateNames.containsAll(expected), "not what we were expecting. It was " + templateNames);
    }

    @Test
    public void getLinesOfTemplating_Footer() {

        File file = new File("./src/test/resources/test-template-footer.jsp");
        assertTrue(file.exists(), file.getAbsolutePath() + " doesn't exist");
        List<String> lines = checkForTemplatingUse.getLinesOfTemplating(Arrays.asList(file));

        assertEquals(1, lines.size(), "not the expected number of lines " + lines);
        for (String line : lines) {
            assertTrue(line.contains("templateName"), "should contain the attribute, but it is " + line);
        }

        List<String> expectedTemplateNames = Arrays.asList("usability-2-col-template");
        Set<String> templateNames = checkForTemplatingUse.getTemplateNames(lines);
        assertEquals(expectedTemplateNames.size(), templateNames.size(), "not the right size");
        assertTrue(templateNames.containsAll(expectedTemplateNames),
            "not what we were expecting but was " + templateNames);
    }

}
