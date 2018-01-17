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
    public void hasRequiredGitInfoNoHashButVersion() {
        ArtifactAttributes gav = new ArtifactAttributes();
        assertFalse("nothing set", gav.hasRequiredGitInfo());

        gav.getManifest().put(ArtifactAttributes.SCM_PROJECT, "sellersj");
        assertFalse("only project set", gav.hasRequiredGitInfo());

        gav.getManifest().put(ArtifactAttributes.SCM_REPO, "artifact-checker");
        assertFalse("only project and repo set", gav.hasRequiredGitInfo());

        gav.getManifest().put(ArtifactAttributes.VERSION, "1.2.3");
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

    @Test
    public void getJiraKeyNoKey() {
        ArtifactAttributes art = new ArtifactAttributes();
        art.getManifest().put(ArtifactAttributes.ISSUE_TRACKING, "");
        assertEquals("", art.getJiraKey());
    }

    @Test
    public void getJiraKeyWithKey() {
        ArtifactAttributes art = new ArtifactAttributes();
        art.getManifest().put(ArtifactAttributes.ISSUE_TRACKING, "http://jira.example.com/browse/TEST");
        assertEquals("TEST", art.getJiraKey());
    }

    @Test
    public void getArtifactIdNoCorrectionNeeded() {
        String artifactId = "myArtifactId";
        ArtifactAttributes art = new ArtifactAttributes();
        art.getManifest().put(ArtifactAttributes.ARTIFACT_ID, artifactId);
        assertEquals(artifactId, art.getArtifactId());
    }

    @Test
    public void getArtifactIdCorrectionNeeded() {
        String artifactId = "myArtifactId";
        ArtifactAttributes art = new ArtifactAttributes();
        art.getManifest().put(ArtifactAttributes.ARTIFACT_ID, "");
        art.setCorrectedArtifactId(artifactId);
        assertEquals(artifactId, art.getArtifactId());
    }

    @Test
    public void getArtifactIdBothSetButUsingManifest() {
        String artifactId = "myArtifactId";
        ArtifactAttributes art = new ArtifactAttributes();
        art.getManifest().put(ArtifactAttributes.ARTIFACT_ID, artifactId);
        art.setCorrectedArtifactId("myCorrectedArtifactId");
        assertEquals(artifactId, art.getArtifactId());
    }

    @Test
    public void getBaseUrlHasHash() {
        String scmProject = "myProject";
        String scmRepo = "myRepo";
        String scmHash = "faaa0e7";

        ArtifactAttributes art = new ArtifactAttributes();
        art.getManifest().put(ArtifactAttributes.SCM_PROJECT, scmProject);
        art.getManifest().put(ArtifactAttributes.SCM_REPO, scmRepo);
        art.getManifest().put(ArtifactAttributes.SCM_HASH, scmHash);

        String expected = scmProject + "/" + scmRepo + "/" + scmHash + "/" + scmRepo;
        assertEquals(expected, art.getBaseUrl());
    }

    @Test
    public void getBaseUrlHasVersion() {
        String scmProject = "myProject";
        String scmRepo = "myRepo";
        String version = "1.2.3";

        ArtifactAttributes art = new ArtifactAttributes();
        art.getManifest().put(ArtifactAttributes.SCM_PROJECT, scmProject);
        art.getManifest().put(ArtifactAttributes.SCM_REPO, scmRepo);
        art.getManifest().put(ArtifactAttributes.VERSION, version);

        String expected = scmProject + "/" + scmRepo + "/" + version + "/" + scmRepo;
        assertEquals(expected, art.getBaseUrl());
    }

    @Test
    public void getApplicationUrlNoContextRoot() {

        ArtifactAttributes art = new ArtifactAttributes();
        // blank app, no context too
        art.setDeploymentInfo(new App());

        String url = art.getApplicationUrl();
        assertNull(url);
    }

    @Test
    public void getApplicationUrlHasContextRoot() {
        String contextRoot = "/some/context/root";

        ArtifactAttributes art = new ArtifactAttributes();
        App app = new App();
        app.putItem(App.CONTEXT_ROOT, contextRoot);
        art.setDeploymentInfo(app);

        String url = art.getApplicationUrl();
        assertTrue(url + "should have ended with " + contextRoot, url.endsWith("/some/context/root"));
    }

}
