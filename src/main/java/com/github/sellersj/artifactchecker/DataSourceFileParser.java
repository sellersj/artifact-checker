/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.github.sellersj.artifactchecker.model.ArtifactAttributes;
import com.github.sellersj.artifactchecker.model.ParsedDataSource;

/**
 * @author sellersj
 */
public class DataSourceFileParser {

    public List<ParsedDataSource> parseDataSourceFile(String url) {

        try (InputStream in = URI.create(url).toURL().openStream()) {
            String contents = IOUtils.toString(in, StandardCharsets.UTF_8);
            return parseDataSourceContents(contents);
        } catch (Exception e) {
            throw new RuntimeException("Could not download and parse url " + url, e);
        }
    }

    public List<ParsedDataSource> parseDataSourceFile(File file) {
        try {
            String contents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            return parseDataSourceContents(contents);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file: " + file.getAbsolutePath(), e);
        }
    }

    public List<ParsedDataSource> parseDataSourceContents(String contents) {
        ArrayList<ParsedDataSource> result = new ArrayList<>();

        // split the file on a the manifest header, while keeping the header
        String[] chunks = contents.split("(?=\\[" + ParsedDataSource.DATA_SOURCE_KEY + "\\])");

        for (String chunk : chunks) {
            ParsedDataSource app = getDataSource(chunk);

            result.add(app);
        }

        System.out.println("Found " + result.size() + " datasources in production config");

        return result;
    }

    /**
     * Get all the unmapped dataSources
     *
     * @param ds to check
     * @param apps
     * @return all the ones that don't have apps mapped to them.
     */
    public List<ParsedDataSource> getUnmappedDataSources(List<ParsedDataSource> ds, Set<ArtifactAttributes> apps) {
        // build a list of all the jndi names in use
        HashSet<String> jndiNamesInUse = new HashSet<>();
        for (ArtifactAttributes artifactAttributes : apps) {
            jndiNamesInUse.addAll(artifactAttributes.getPossibleJndiNames());
            for (ParsedDataSource pds : artifactAttributes.getLinkedDataSources()) {
                jndiNamesInUse.add(pds.getJndiName());
            }
        }

        List<ParsedDataSource> unmapped = new ArrayList<>();
        for (ParsedDataSource pds : ds) {
            if (pds.getAppNames().isEmpty() && !jndiNamesInUse.contains(pds.getJndiName())) {
                unmapped.add(pds);
            }
        }
        System.out.println(
            String.format("There are %s data sources not mapped to an application: %s", unmapped.size(), unmapped));
        removeUnmappedDatasourceOnExceptionList(unmapped);

        return unmapped;
    }

    /**
     *
     * @param unmapped to be filtered
     */
    private void removeUnmappedDatasourceOnExceptionList(List<ParsedDataSource> unmapped) {
        File file = InventoryFileUtil.getFileOnClasspath("/unmapped-datasources-ignore-list.txt");
        try {
            List<String> jndiNames = FileUtils.readLines(file, StandardCharsets.ISO_8859_1);
            for (Iterator<ParsedDataSource> iterator = unmapped.iterator(); iterator.hasNext();) {
                ParsedDataSource parsedDataSource = iterator.next();
                if (jndiNames.contains(parsedDataSource.getJndiName())) {
                    System.out.println(String.format(
                        "We are removing %s from the list of unmapped datasources since it's on an exception list",
                        parsedDataSource.getJndiName()));
                    iterator.remove();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("could not read file " + file.getAbsolutePath(), e);
        }
    }

    private ParsedDataSource getDataSource(String chunk) {
        ParsedDataSource app = new ParsedDataSource();

        String lines[] = chunk.split("\\r?\\n");
        for (String string : lines) {
            try {
                int splitIndex = string.indexOf("]");
                String key = string.substring(1, splitIndex);
                String value = string.substring(splitIndex + 1);

                switch (key) {
                    case ParsedDataSource.DATA_SOURCE_KEY:
                        app.setName(value);
                        break;
                    case ParsedDataSource.JNDI:
                        app.setJndiName(value);
                        break;
                    case ParsedDataSource.DATABASE_USER:
                        app.setDatabaseUsername(value);
                        break;
                    case ParsedDataSource.APPLICATION:
                        app.getAppNames().add(value);
                        break;
                    default:
                        // ignore the other tags for now
                }
            } catch (Exception e) {
                throw new RuntimeException("Could not parse line: " + string, e);
            }
        }

        return app;
    }

}
