package com.github.sellersj.artifactchecker;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.github.sellersj.artifactchecker.model.App;

public class AppFileParserTest {

    @Test
    @Ignore("Fix this so that it will parse out properly")
    public void parseAppFile() {
        AppFileParser parser = new AppFileParser();

        File file = InventoryFileUtil.getFileOnClasspath("/app-test.txt");
        List<App> parseAppFile = parser.parseAppFile(file);
        assertNotNull(parseAppFile);

        // TODO put this back in
        // assertEquals("size", 2, parseAppFile.size());

        for (App app : parseAppFile) {
            System.out.println(app);

            checkKey(app, "APP");
            checkKey(app, "SERVER");
        }
    }

    private void checkKey(App app, String key) {
        assertTrue("should have key '" + key + "' but key are: " + app.getAttributes().keySet(),
            app.getAttributes().containsKey(key));
    }

}
