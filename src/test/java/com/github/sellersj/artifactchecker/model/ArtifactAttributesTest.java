package com.github.sellersj.artifactchecker.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.sellersj.artifactchecker.Constants;
import com.github.sellersj.artifactchecker.ConstantsTest;

public class ArtifactAttributesTest {

    @BeforeEach
    public void setToolsHost() {
        ConstantsTest.setTestValues();
    }

    @Test
    public void hasRequiredGitInfo() {
        ArtifactAttributes gav = new ArtifactAttributes();
        assertFalse(gav.hasRequiredGitInfo(), "nothing set");

        gav.getManifest().put(ArtifactAttributes.SCM_PROJECT, "sellersj");
        assertFalse(gav.hasRequiredGitInfo(), "only project set");

        gav.getManifest().put(ArtifactAttributes.SCM_REPO, "artifact-checker");
        assertFalse(gav.hasRequiredGitInfo(), "only project and repo set");

        gav.getManifest().put(ArtifactAttributes.SCM_HASH, "1c6c1006f11661902b6f48cddbfa8b3ba2cc7385");
        assertTrue(gav.hasRequiredGitInfo(), "should show as cloneable");
    }

    @Test
    public void hasRequiredGitInfoNoHashButVersion() {
        ArtifactAttributes gav = new ArtifactAttributes();
        assertFalse(gav.hasRequiredGitInfo(), "nothing set");

        gav.getManifest().put(ArtifactAttributes.SCM_PROJECT, "sellersj");
        assertFalse(gav.hasRequiredGitInfo(), "only project set");

        gav.getManifest().put(ArtifactAttributes.SCM_REPO, "artifact-checker");
        assertFalse(gav.hasRequiredGitInfo(), "only project and repo set");

        gav.getManifest().put(ArtifactAttributes.VERSION, "1.2.3");
        assertTrue(gav.hasRequiredGitInfo(), "should show as cloneable");
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
    public void getBuildDateWeirdDateFormat() {
        // yet another date format
        String dateString = "2019-09-10-13:16";
        ArtifactAttributes art = new ArtifactAttributes();
        art.getManifest().put(ArtifactAttributes.BUILD_TIME, dateString);

        Date date = art.getBuildDate();
        assertNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        assertEquals(2019, calendar.get(Calendar.YEAR));
        // Calendar.MONTH is zero based
        assertEquals(8, calendar.get(Calendar.MONTH));
        assertEquals(10, calendar.get(Calendar.DAY_OF_MONTH));

        assertEquals(13, calendar.get(Calendar.HOUR_OF_DAY));
        assertEquals(16, calendar.get(Calendar.MINUTE));
    }

    @Test
    public void getBuildDateUsingScmInfo() {
        String dateString = "2018-02-13 14:56:54 -0500";
        ArtifactAttributes art = new ArtifactAttributes();
        art.setScmAuthorDate(dateString);

        Date date = art.getBuildDate();
        assertNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        assertEquals(2018, calendar.get(Calendar.YEAR));
        // Calendar.MONTH is zero based
        assertEquals(1, calendar.get(Calendar.MONTH));
        assertEquals(13, calendar.get(Calendar.DAY_OF_MONTH));

        assertEquals(14, calendar.get(Calendar.HOUR_OF_DAY));
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
    public void getJiraKeyWithManifestAndCorrectedValue() {
        ArtifactAttributes art = new ArtifactAttributes();
        art.getManifest().put(ArtifactAttributes.ISSUE_TRACKING, "http://jira.example.com/browse/TEST");
        art.setCorrectedJiraKey("TOM");
        assertEquals("TOM", art.getJiraKey());
        assertEquals("http://jira.example.com/browse/TOM", art.getJiraUrl());
    }

    @Test
    public void getJiraKeyUsingCorrectedValue() {
        ArtifactAttributes art = new ArtifactAttributes();
        art.setCorrectedJiraKey("TOM");
        assertEquals("TOM", art.getJiraKey());
        assertEquals("http://jira.example.com/browse/TOM", art.getJiraUrl());
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

        SortedSet<String> urls = art.getApplicationUrls();
        assertNotNull(urls);
        assertTrue(urls.isEmpty());
    }

    @Test
    public void getApplicationUrlHasContextRoot() {
        String contextRoot = "/some/context/root";

        ArtifactAttributes art = new ArtifactAttributes();
        App app = new App();
        app.putItem(App.CONTEXT_ROOT, contextRoot);
        art.setDeploymentInfo(app);

        SortedSet<String> urls = art.getApplicationUrls();
        assertNotNull(urls);
        assertEquals(1, urls.size(), "not correct size for " + urls);
        for (String url : urls) {
            assertTrue(url.endsWith("/some/context/root"), url + "should have ended with " + contextRoot);
        }
    }

    @Test
    public void getDeploymentDateNoDeployment() {
        ArtifactAttributes art = new ArtifactAttributes();
        art.setDeploymentInfo(null);
        assertEquals("", art.getDeploymentDate());
    }

    @Test
    public void getDeploymentDateNoDateInDeployment() {
        ArtifactAttributes art = new ArtifactAttributes();
        art.setDeploymentInfo(new App());
        assertEquals("", art.getDeploymentDate());
    }

    @Test
    public void getDeploymentDateHasAllValues() {
        ArtifactAttributes art = new ArtifactAttributes();
        App app = new App();
        app.putItem(App.DEPLOY_DATE, "Thu Mar 5 07:05:10 2015");
        art.setDeploymentInfo(app);
        assertNotNull(art.getDeploymentDate());
        assertEquals("2015-03-05 07:05:10", art.getDeploymentDate());
    }

    @Test
    public void getNodeUrls() {
        String logHost = "logs.example.com";
        System.setProperty(Constants.PROD_LOG_HOST, logHost);

        ArtifactAttributes art = new ArtifactAttributes();
        art.setDeploymentInfo(new App());
        art.getDeploymentInfo().putItem("NODE", "Was_In2 Was_In1");

        List<String> nodeUrls = art.getNodeUrls();
        assertEquals(2, nodeUrls.size(), "size");

        List<String> expected = Arrays.asList("<a href=\"http://logs.example.com/logs/wasin1/\">Was_In1</a>", //
            "<a href=\"http://logs.example.com/logs/wasin2/\">Was_In2</a>");

        assertEquals(expected, nodeUrls);
    }

    /**
     * They have discontinued the use of <code>Implementation-Vendor-Id</code>
     * https://issues.apache.org/jira/browse/MSHARED-777
     */
    @Test
    public void getGroupIdOldManifestEntry() {
        String expected = "old Value";
        ArtifactAttributes art = new ArtifactAttributes();
        art.getManifest().put("Implementation-Vendor-Id", expected);
        assertEquals(expected, art.getGroupId());
    }

    /**
     * They have discontinued the use of <code>Implementation-Vendor-Id</code>
     * https://issues.apache.org/jira/browse/MSHARED-777
     */
    @Test
    public void getGroupIdNewManifestEntry() {
        String expected = "new Value";
        ArtifactAttributes art = new ArtifactAttributes();
        art.getManifest().put("Maven-Project-GroupId", expected);
        assertEquals(expected, art.getGroupId());
    }

    /**
     * They have discontinued the use of <code>Implementation-Vendor-Id</code>
     * https://issues.apache.org/jira/browse/MSHARED-777
     */
    @Test
    public void getGroupIdBothManifestEntry() {
        String expected = "new Value";
        ArtifactAttributes art = new ArtifactAttributes();
        art.getManifest().put("Implementation-Vendor-Id", "old value");
        art.getManifest().put("Maven-Project-GroupId", expected);
        assertEquals(expected, art.getGroupId());
    }

    @Test
    public void nodeLogLocationCorrection_RegularNode() {
        String input = "Was_Public1";
        String expected = "waspublic1";
        ArtifactAttributes art = new ArtifactAttributes();
        assertEquals(expected, art.nodeLogLocationCorrection(input));
    }

    @Test
    public void nodeLogLocationCorrection_OsbNode() {
        String input = "Was_OsbP1";
        String expected = "wasosbpublic1";
        ArtifactAttributes art = new ArtifactAttributes();
        assertEquals(expected, art.nodeLogLocationCorrection(input));
    }

}
