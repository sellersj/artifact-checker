package com.github.sellersj.artifactchecker;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class FindJava8Issues {

    /** A pattern for all libraries that have known issues with java 8. */
    private static final String REGEX_BLACKLIST = ".*(" + //
        "cglib:cglib:jar:3.1|" + //
        "httpclient:jar:4.3|" + //
        "hibernate-core:jar:4.2" + //
        ").*";

    public static void createFilesThatIdentifyJava8Issues(String rootLocation) {

        Path path = Paths.get(rootLocation);
        System.out.println("going to check " + path.toAbsolutePath());

        try {
            Files.walk(path).filter(p -> "tree.txt".equals(p.getFileName().toString()))// .peek(System.out::println);
                .forEach(p -> checkTreeForJava8Issues(p));
        } catch (IOException e) {
            throw new RuntimeException("had trouble reading " + path, e);
        }
    }

    public static void checkTreeForJava8Issues(Path path) {
        System.out.println(path.toAbsolutePath());
        try {
            List<String> lines = FileUtils.readLines(path.toFile(), StandardCharsets.UTF_8);
            for (String string : lines) {
                if (Pattern.matches(REGEX_BLACKLIST, string)) {
                    System.out.println(string);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("could not read file " + path, e);
        }

    }

}
