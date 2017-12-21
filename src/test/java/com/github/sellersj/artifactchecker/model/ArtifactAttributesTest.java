package com.github.sellersj.artifactchecker.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class ArtifactAttributesTest {

    @Test
    public void hasRequiredGitInfo() {
        ArtifactAttributes gav = new ArtifactAttributes();
        assertFalse("nothing set", gav.hasRequiredGitInfo());

        gav.getManifest().put(ArtifactAttributes.SCM_PROJECT, "sellersj");
        assertFalse("only project set", gav.hasRequiredGitInfo());

        gav.getManifest().put(ArtifactAttributes.SCM_REPO, "artifact-checker");
        assertFalse("only project and repo set", gav.hasRequiredGitInfo());

        gav.getManifest().put(ArtifactAttributes.SCM_HASH, "1c6c1006f11661902b6f48cddbfa8b3ba2cc7385");
        assertTrue("should show as cloneable", gav.hasRequiredGitInfo());
    }

    @Test
    public void getScmProjectDefaultsOnlyWhenOtherInfoFilledOut() {
        assertNull(new ArtifactAttributes().getScmProject());

        ArtifactAttributes art = new ArtifactAttributes();
        art.getManifest().put(ArtifactAttributes.SCM_REPO, "bob");
        art.getManifest().put(ArtifactAttributes.SCM_HASH, "akshfkjashfkasjhf");
        assertEquals("ICAPPS", art.getScmProject());
    }

    @Test
    public void getScmHashEmptyHash() {
        ArtifactAttributes art = new ArtifactAttributes();
        assertEquals(null, art.getScmHash());
    }

    @Test
    public void getScmHashNormalHash() {
        String hash = "1c6c1006f11661902b6f48cddbfa8b3ba2cc7385";
        ArtifactAttributes art = new ArtifactAttributes();
        art.getManifest().put(ArtifactAttributes.SCM_HASH, hash);
        assertEquals(hash, art.getScmHash());
    }

    @Test
    public void getScmHashWithDirtyFlag() {
        String hash = "1c6c1006f11661902b6f48cddbfa8b3ba2cc7385";
        ArtifactAttributes art = new ArtifactAttributes();
        art.getManifest().put(ArtifactAttributes.SCM_HASH, hash + "-dirty");
        assertEquals(hash, art.getScmHash());
    }

    @Test
    public void getBuildDateNullValue() {
        String dateString = null;
        ArtifactAttributes art = new ArtifactAttributes();
        art.getManifest().put(ArtifactAttributes.BUILD_TIME, dateString);
        assertEquals(null, art.getBuildDate());
    }

    @Test
    public void getBuildDateOldDateFormat() {
        String dateString = "20130731-1130";
        ArtifactAttributes art = new ArtifactAttributes();
        art.getManifest().put(ArtifactAttributes.BUILD_TIME, dateString);

        Date date = art.getBuildDate();
        assertNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        assertEquals(2013, calendar.get(Calendar.YEAR));
        // Calendar.MONTH is zero based
        assertEquals(6, calendar.get(Calendar.MONTH));
        assertEquals(31, calendar.get(Calendar.DAY_OF_MONTH));

        assertEquals(11, calendar.get(Calendar.HOUR_OF_DAY));
        assertEquals(30, calendar.get(Calendar.MINUTE));
    }

    @Test
    public void getBuildDateNewDateFormat() {
        String dateString = "2016-08-31T13:56:45Z";
        ArtifactAttributes art = new ArtifactAttributes();
        art.getManifest().put(ArtifactAttributes.BUILD_TIME, dateString);

        Date date = art.getBuildDate();
        assertNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        assertEquals(2016, calendar.get(Calendar.YEAR));
        // Calendar.MONTH is zero based
        assertEquals(7, calendar.get(Calendar.MONTH));
        assertEquals(31, calendar.get(Calendar.DAY_OF_MONTH));

        assertEquals(13, calendar.get(Calendar.HOUR_OF_DAY));
        assertEquals(56, calendar.get(Calendar.MINUTE));
    }

}
