/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.github.sellersj.artifactchecker.model.App;

/**
 * @author sellersj
 */
public class AppFileParser {

    public List<App> parseAppFile(File file) {
        try {
            String contents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            return parseAppFile(contents);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file: " + file.getAbsolutePath(), e);
        }
    }

    public List<App> parseAppFile(String contents) {
        ArrayList<App> result = new ArrayList<>();

        // split the file on a the manifest header, while keeping the header
        String[] chunks = contents.split("(?=\\[APP\\])");

        for (String chunk : chunks) {
            result.add(getApp(chunk));
        }

        return result;
    }

    private App getApp(String chunk) {
        App app = new App();

        String lines[] = chunk.split("\\r?\\n");
        for (String string : lines) {
            int splitIndex = string.indexOf("]");
            String key = string.substring(1, splitIndex);
            String value = string.substring(splitIndex);

            app.getAttributes().put(key, value);
        }

        return app;
    }

}
