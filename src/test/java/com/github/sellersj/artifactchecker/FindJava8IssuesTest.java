package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class FindJava8IssuesTest {

    @Test
    public void createFilesThatIdentifyJava8Issues() {
        // smoke test
        FindJava8Issues.createFilesThatIdentifyJava8Issues(DownloadArtifacts.FILES_GENERATED);
    }

    @Test
    public void checkTreeForJava8Issues() throws IOException {
        File file = InventoryFileUtil.getFileOnClasspath("/testproject-tree.txt");
        FindJava8Issues.checkTreeForJava8Issues(file.toPath());
    }

}
