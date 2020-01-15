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

import com.github.sellersj.artifactchecker.model.MailSource;

/**
 * @author sellersj
 */
public class MailSourceFileParser {

    public List<MailSource> parseMailSourceFile(String url) {

        try (InputStream in = new URL(url).openStream()) {
            String contents = IOUtils.toString(in, StandardCharsets.UTF_8);
            return parseAppContents(contents);
        } catch (Exception e) {
            throw new RuntimeException("Could not download and parse url " + url, e);
        }
    }

    public List<MailSource> parseMailSourceFile(File file) {
        try {
            String contents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            return parseAppContents(contents);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file: " + file.getAbsolutePath(), e);
        }
    }

    public List<MailSource> parseAppContents(String contents) {
        List<MailSource> result = new ArrayList<>();

        // split the file on a the manifest header, while keeping the header
        String[] chunks = contents.split("(?=\\[" + MailSource.MAIL_SOURCE_NAME + "\\])");

        for (String chunk : chunks) {
            MailSource app = getApp(chunk);
            result.add(app);
        }

        System.out.println("Found " + result.size() + " mail sources in production config");

        return result;
    }

    private MailSource getApp(String chunk) {
        MailSource app = new MailSource();

        String lines[] = chunk.split("\\r?\\n");
        for (String string : lines) {
            int splitIndex = string.indexOf("]");
            String key = string.substring(1, splitIndex);
            String value = string.substring(splitIndex + 1);

            if (MailSource.MAIL_SOURCE_NAME.equals(key)) {
                app.setName(value);
            } else if (MailSource.MAIL_JNDI.equals(key)) {
                app.setJndiName(value);
            } else if (MailSource.APP_KEY.equals(key)) {
                app.getAppNames().add(value);
            }
        }

        return app;
    }

}
