package com.github.sellersj.artifactchecker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CheckForTemplatingUseTest {

    @Test
    public void getJspFiles_NoneInThisProject() {
        File dir = new File(".");
        CheckForTemplatingUse checkForTemplatingUse = new CheckForTemplatingUse();
        List<File> list = checkForTemplatingUse.getJspFiles(dir);
        assertEquals(0, list.size(), "should be empty but had " + list);
    }

}
