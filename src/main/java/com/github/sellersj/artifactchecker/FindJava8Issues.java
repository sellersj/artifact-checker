package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class FindJava8Issues {

    /** A pattern for all libraries that have known issues with java 8. */
    private static final String REGEX_BLACKLIST = ".*(" + //
        "asm:asm|" + //
        "cglib:cglib:|" + //
        "cglib:cglib\\-nodep|" + //
        "com.esotericsoftware:reflectasm:|" + //
        "com.sun.jersey:jersey\\-server:|" + //
        "org.easymock:easymock:|" + //
        "org.easymock:easymockclassextension|" + //
        "org.jdbi:jdbi:|" + //
        "org.jruby:jruby\\-complete|" + //
        "org.mockito:mockito\\-all|" + //
        "org.mockito:mockito\\-core:|" + //
        "org.ow2.asm:asm:|" + //
        "org.ow2.asm:asm\\-all:|" + //
        "org.ow2.asm:asm\\-analysis:|" + //
        "org.ow2.asm:asm\\-commons:|" + //
        "org.ow2.asm:asm\\-parent:|" + //
        "org.ow2.asm:asm\\-tree:|" + //
        "org.ow2.asm:asm\\-util:|" + //
        "org.ow2.asm:asm\\-xml:|" + //
        "org.parboiled:parboiled\\-java:|" + //
        "eclipse:jdtcore|" + //
        "org.eclipse.jdt:core|" + //
        "org.eclipse.jdt:org.eclipse.jdt.core|" + //
        "com.entrust.toolkit|" + //
        "org.springframework:spring\\-" + //
        // make sure above line doesn't end with a pipe character |
        ").*";

    /** A pattern for all libraries that are fixed for java 8. */
    private static final String REGEX_WHITELIST = ".*(" + //
        "org.easymock:easymock:jar:3.3.1|" + //
        "org.easymock:easymock:jar:3.4|" + //
        "org.easymock:easymock:jar:3.5|" + //
        "org.easymock:easymock:jar:4|" + //
        "cglib:cglib.*:3.[2-9]|" + //
        "org.ow2.asm:.*:5.0.[3-9]|" + //
        "org.ow2.asm:.*:5.[1-9]|" + //
        "org.ow2.asm:.*:[6-9]|" + //
        "org.mockito:mockito.*:1.10.19|" + //
        "org.eclipse.jdt.core.*:3.10.0|" + //
        "org.springframework:spring-.*:3.2.9|" + //
        "org.springframework:spring-.*:3.2.1[0-9]|" + //
        "org.springframework:spring-.*:[4-9]|" + //
        ":provided|" + //
        ":test" + //
        // make sure above line doesn't end with a pipe character |
        ").*";

    public static List<String> checkTreeForJava8Issues(String treeOutputFile) {
        File treeFile = new File(treeOutputFile);
        File java8IssuesFile = new File(treeFile.getParent() + "/" + Constants.JAVA8_ISSUES_FILENAME);

        try {
            List<String> lines = FileUtils.readLines(treeFile, StandardCharsets.UTF_8);
            List<String> issues = checkTreeForJava8Issues(lines);

            // write the issues we found
            FileUtils.writeLines(java8IssuesFile, issues);
            return issues;
        } catch (IOException e) {
            throw new RuntimeException("Couldn't check file for java 8 issues " + treeOutputFile, e);
        }
    }

    public static List<String> checkTreeForJava8Issues(List<String> lines) {
        List<String> issues = new ArrayList<>();
        for (String string : lines) {
            if (Pattern.matches(REGEX_BLACKLIST, string) && !Pattern.matches(REGEX_WHITELIST, string)) {
                issues.add(string);
            }
        }
        return issues;
    }
}
