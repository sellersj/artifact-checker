package com.github.sellersj.artifactchecker;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FindJava8IssuesTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{ //
            {Arrays.asList("+- asm:asm:jar:3.3.1:compile"), 1}, //
            {Arrays.asList("org.easymock:easymock:jar:3.3.0:compile"), 1}, //
            {Arrays.asList("cglib:cglib:3.1"), 1}, //
            {Arrays.asList("org.springframework:spring-core:3.2.8:compile"), 1}, //

            // all the ones that should pass
            {Arrays.asList("org.apache.commons:commons-lang3:jar:3.7:compile"), 0}, //
            {Arrays.asList("org.easymock:easymock:jar:3.3.1:compile"), 0}, //
            {Arrays.asList("cglib:cglib:3.2"), 0}, //
            {Arrays.asList("org.springframework:spring-core:3.2.9:compile"), 0}, //
            {Arrays.asList("org.springframework:spring-core:4.3.6:compile"), 0}, //

            // ignore libs that are listed as test or provided
            {Arrays.asList("cglib:cglib:3.1:test"), 0}, //
            {Arrays.asList("cglib:cglib:3.1:provided"), 0}, //

            // compile scope, but has test in the name
            {Arrays.asList("org.springframework:spring-test:3.2.8:compile"), 1}, //
            // FIXME we still need to take care of this case
            // {Arrays.asList("org.springframework:test:3.2.8:compile"), 1}, //
        });
    }

    /** The lines to test. */
    private List<String> lines;

    /** The expected number of lines that have issues. */
    private int expectedSize;

    public FindJava8IssuesTest(List<String> lines, int expected) {
        this.lines = lines;
        this.expectedSize = expected;
    }

    @Test
    public void testCheckTreeForJava8Issues() {
        List<String> issues = FindJava8Issues.checkTreeForJava8Issues(lines);
        if (expectedSize != issues.size()) {
            System.out.println(issues);
        }
        assertEquals("For lines: " + lines, expectedSize, issues.size());
    }

}
