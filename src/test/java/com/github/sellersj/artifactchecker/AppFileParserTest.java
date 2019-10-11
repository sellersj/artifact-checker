package com.github.sellersj.artifactchecker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.github.sellersj.artifactchecker.model.App;

public class AppFileParserTest {

    @Test
    public void parseAppFile() {
        AppFileParser parser = new AppFileParser();

        File file = InventoryFileUtil.getFileOnClasspath("/app-test.txt");
        List<App> parseAppFile = parser.parseAppFile(file);
        assertNotNull(parseAppFile);

        assertEquals(4, parseAppFile.size(), "size");

        for (App app : parseAppFile) {
            System.out.println(app);

            checkKey(app, App.APP_KEY);
            checkKey(app, App.CLUSTER);
            checkKey(app, App.BUILD_VERSION);

            List<String> nodes = app.getAttributes().get("NODE");
            assertEquals(2, nodes.size(), "wrong number of nodes " + nodes);
        }
    }

    private void checkKey(App app, String key) {
        assertTrue(app.getAttributes().containsKey(key),
            "should have key '" + key + "' but key are: " + app.getAttributes().keySet());
    }

}
