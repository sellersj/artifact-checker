package com.github.sellersj.artifactchecker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FindJava8IssuesTest {

    public static Stream<Arguments> data() {
        return Stream.of( //
            Arguments.of(Arrays.asList("+- asm:asm:jar:3.3.1:compile"), 1), //
            Arguments.of(Arrays.asList("org.easymock:easymock:jar:3.3.0:compile"), 1), //
            Arguments.of(Arrays.asList("cglib:cglib:3.1"), 1), //
            Arguments.of(Arrays.asList("org.springframework:spring-core:3.2.8:compile"), 1), //

            // all the ones that should pass
            Arguments.of(Arrays.asList("org.apache.commons:commons-lang3:jar:3.7:compile"), 0), //
            Arguments.of(Arrays.asList("org.easymock:easymock:jar:3.3.1:compile"), 0), //
            Arguments.of(Arrays.asList("cglib:cglib:3.2"), 0), //
            Arguments.of(Arrays.asList("cglib:cglib:3.3.0"), 0), //
            Arguments.of(Arrays.asList("org.springframework:spring-core:3.2.9:compile"), 0), //
            Arguments.of(Arrays.asList("org.springframework:spring-core:4.3.6:compile"), 0), //

            // ignore libs that are listed as test or provided
            Arguments.of(Arrays.asList("cglib:cglib:3.1:test"), 0), //
            Arguments.of(Arrays.asList("cglib:cglib:3.1:provided"), 0), //

            // compile scope, but has test in the name
            Arguments.of(Arrays.asList("org.springframework:spring-test:3.2.8:compile"), 1) //
        // FIXME we still need to take care of this case
        // Arguments.of(Arrays.asList("org.springframework:test:3.2.8:compile"), 1), //
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testCheckTreeForJava8Issues(List<String> lines, int expectedSize) {
        List<String> issues = FindJava8Issues.checkTreeForJava8Issues(lines);
        if (expectedSize != issues.size()) {
            System.out.println(issues);
        }
        assertEquals(expectedSize, issues.size(), "For lines: " + lines);
    }

}
