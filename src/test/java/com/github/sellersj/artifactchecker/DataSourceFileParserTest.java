package com.github.sellersj.artifactchecker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.github.sellersj.artifactchecker.model.ParsedDataSource;

public class DataSourceFileParserTest {

    @Test
    public void parseAppFile() {
        DataSourceFileParser parser = new DataSourceFileParser();

        File file = InventoryFileUtil.getFileOnClasspath("/dataSources-test.txt");
        List<ParsedDataSource> parseAppFile = parser.parseDataSourceFile(file);
        assertNotNull(parseAppFile);

        assertEquals(2, parseAppFile.size(), "size");
        boolean foundAbc = false;
        boolean foundSomething = false;

        for (ParsedDataSource app : parseAppFile) {
            // check the first app
            if ("ABC_Corporate_UDS".equals(app.getName())) {
                assertEquals("jdbc/abc/corporate/CorporateUDS", app.getJndiName(), "jndi");
                assertEquals("myawesome_user", app.getDatabaseUsername(), "db user");

                List<String> appNames = Arrays.asList("XYZ_MY_APP__PUBLIC", "CDE_ANOTHER_APP__PUBLIC");
                assertTrue(app.getAppNames().containsAll(appNames),
                    "should have found " + appNames + " but was " + app.getAppNames());

                foundAbc = true;
            }

            // check the second app
            if ("ABC_Semething_Access".equals(app.getName())) {
                assertEquals("jdbc/abc/audit/SomethingAccessDS", app.getJndiName(), "jndi");
                assertEquals("bob_user", app.getDatabaseUsername(), "db user");

                assertTrue(app.getAppNames().isEmpty(), "should have been empty but was " + app.getAppNames());

                foundSomething = true;
            }
        }

        assertTrue(foundAbc, "should have found abc ds");
        assertTrue(foundSomething, "should have found something ds");
    }

}
