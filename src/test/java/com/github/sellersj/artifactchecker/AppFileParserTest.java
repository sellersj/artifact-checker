package com.github.sellersj.artifactchecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.github.sellersj.artifactchecker.model.App;

public class AppFileParserTest {

    @Test
    public void parseAppFile() {
        AppFileParser parser = new AppFileParser();

        File file = InventoryFileUtil.getFileOnClasspath("/app-test.txt");
        List<App> parseAppFile = parser.parseAppFile(file);
        assertNotNull(parseAppFile);

        assertEquals("size", 4, parseAppFile.size());

        for (App app : parseAppFile) {
            System.out.println(app);

            checkKey(app, "APP");
            checkKey(app, "SERVER");

            List<String> nodes = app.getAttributes().get("NODE");
            assertEquals("wrong number of nodes " + nodes, 2, nodes.size());
        }
    }

    private void checkKey(App app, String key) {
        assertTrue("should have key '" + key + "' but key are: " + app.getAttributes().keySet(),
            app.getAttributes().containsKey(key));
    }

}
