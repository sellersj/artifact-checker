package com.github.sellersj.artifactchecker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.github.sellersj.artifactchecker.model.App;

public class AppFileParserTest {

    private AppFileParser parser = new AppFileParser();

    @Test
    public void parseAppFile() {
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

    @Test
    public void parseAppContentsMultipleContextRoots() {
        String part = "[APP]My_Name_Name\n" // //
            + "[SERVER]Intra-SharedServices-CL1\n" //
            + "[TYPE]Intranet Websphere 8.5\n" //
            + "[BUILD VERSION]1.6.15\n" //
            + "[DATE BUILT]2017--0-5- 8T:15\n" //
            + "[DEPLOY DATE]Wed Jun  7 07:14:37 2017\n" //
            + "[DATASOURCE]SOME_COMMON_DATA_UDS\n" //
            + "[DATASOURCE]APP_SPECIFIC_UDS\n" //
            + "[NODE]Was_In1\n" //
            + "[NODE]Was_In2\n" //
            + "[CONTEXT_ROOT]/my/app/context/root1\n" //
            + "[CONTEXT_ROOT]/my/app/context/root2\n";

        List<App> apps = parser.parseAppContents(part);
        assertNotNull(apps);
        assertEquals(1, apps.size());

        // check the context root size here
        for (App app : apps) {
            assertTrue(app.getAttributes().containsKey(App.CONTEXT_ROOT));
            List<String> contextRoots = app.getAttributes().get(App.CONTEXT_ROOT);
            assertNotNull(contextRoots);
            assertEquals(2, contextRoots.size());

            assertTrue(contextRoots.contains("/my/app/context/root1"));
            assertTrue(contextRoots.contains("/my/app/context/root2"));
        }
    }

    private void checkKey(App app, String key) {
        assertTrue(app.getAttributes().containsKey(key),
            "should have key '" + key + "' but key are: " + app.getAttributes().keySet());
    }

}
