package com.github.sellersj.artifactchecker;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FindJava8Issues {

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
                System.out.println(string);
            }
        } catch (IOException e) {
            throw new RuntimeException("could not read file " + path, e);
        }

    }

}
