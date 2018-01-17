/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.github.sellersj.artifactchecker.model.App;

/**
 * @author sellersj
 */
public class AppFileParser {

    public List<App> parseAppFile(String url) {

        try (InputStream in = new URL(url).openStream()) {
            String contents = IOUtils.toString(in, StandardCharsets.UTF_8);
            return parseAppContents(contents);
        } catch (Exception e) {
            throw new RuntimeException("Could not download and parse url " + url, e);
        }
    }

    public List<App> parseAppFile(File file) {
        try {
            String contents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            return parseAppContents(contents);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file: " + file.getAbsolutePath(), e);
        }
    }

    public List<App> parseAppContents(String contents) {
        ArrayList<App> result = new ArrayList<>();

        // split the file on a the manifest header, while keeping the header
        String[] chunks = contents.split("(?=\\[APP\\])");

        for (String chunk : chunks) {
            App app = getApp(chunk);

            // ignore empty apps (e.g. it's the break line)
            if (!app.getAttributes().isEmpty()) {
                result.add(app);
            }
        }

        return result;
    }

    private App getApp(String chunk) {
        App app = new App();

        String lines[] = chunk.split("\\r?\\n");
        for (String string : lines) {
            int splitIndex = string.indexOf("]");
            String key = string.substring(1, splitIndex);
            String value = string.substring(splitIndex + 1);

            if (!"BREAK".equals(key)) {
                List<String> items = app.getAttributes().get(key);

                // if the list is missing, add it in
                if (null == items) {
                    items = new ArrayList<>();
                    app.getAttributes().put(key, items);
                }

                items.add(value);
            }
        }

        return app;
    }

}
