package com.github.sellersj.artifactchecker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import com.github.sellersj.artifactchecker.model.MailSource;

public class MailSourceFileParserTest {

    @Test
    public void parseMailSourceFile() {
        MailSourceFileParser parser = new MailSourceFileParser();

        File file = InventoryFileUtil.getFileOnClasspath("/mailSourceData-test.txt");
        List<MailSource> parseAppFile = parser.parseMailSourceFile(file);
        assertNotNull(parseAppFile);

        assertEquals(2, parseAppFile.size(), "size");

        for (MailSource app : parseAppFile) {
            System.out.println(app);

            assertTrue(StringUtils.isNotEmpty(app.getName()), "name shouldn't be empty");
            assertTrue(StringUtils.isNotEmpty(app.getJndiName()), "jndi name shouldn't be empty");
            assertFalse(app.getAppNames().isEmpty(), "app names");
        }
    }

}
