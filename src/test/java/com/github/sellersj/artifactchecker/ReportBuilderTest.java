package com.github.sellersj.artifactchecker;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class ReportBuilderTest {

    @Test
    public void buildJsonReport() {
        String toolsHost = System.getProperty("TOOLS_HOST");
        assertTrue("The TOOLS_HOST variable has to be set", StringUtils.isBlank(toolsHost));

        String location = "https://" + toolsHost + "/deployed-to/manifest-combined.txt";
        String target = "/data00/bamboo/projectsites/app-inventory.json";

        ReportBuilder.buildJsonReport(location, target);
    }

}
