package com.github.sellersj.artifactchecker.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.github.sellersj.artifactchecker.Constants;
import com.github.sellersj.artifactchecker.model.owasp.Vulnerability;

/**
 * Any attributes that we will track for an artifact.
 *
 * @author sellersj
 */
public class ArtifactAttributes implements Comparable<ArtifactAttributes> {

    public static final String ISSUE_TRACKING = "Issue-Tracking";

    /** The project or user that a git repo is stored under. */
    public final static String SCM_PROJECT = "Scm-Project-Id";

    /** The git repo name. */
    public static final String SCM_REPO = "Scm-Repo-Name";

    /** The git hash that we want to checkout. */
    public static final String SCM_HASH = "Scm-Sha1";

    /** The Implementation-Title from the manifest. */
    public static final String IMPLEMENTATION_TITLE = "Implementation-Title";

    /** The Build-Time from the manifest. */
    public static final String BUILD_TIME = "Build-Time";

    /** The Implementation-Artifact-Id from the manifest which is used for the artifactId. */
    public static final String ARTIFACT_ID = "Implementation-Artifact-Id";

    /** The tag we're looking for the version with. */
    public static final String VERSION = "Implementation-Version";

    /** The maven date format. */
    private static final SimpleDateFormat MAVEN_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    /** The old maven date format. */
    private static final SimpleDateFormat MAVEN_OLD_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd-HHmm");

    /** The date format with just the year. */
    private static final SimpleDateFormat SHORT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /** If this is a githug host. */
    private boolean github = false;

    /** Our corrected scm project from a static file. */
    private String correctedScmProject;

    /** Our corrected scm repo from a static file. */
    private String correctedScmRepo;

    /** Our corrected artifactId from a static file. */
    private String correctedArtifactId;

    /** Flag for if this artficat's repo was already checked by another artifact (e.g. 1 repo, 2 ears). */
    private boolean alreadyTrackedByAnother = false;

    /** Flag for if we can run this on java 8. */
    private boolean java8Ready = false;

    /** The manifest associated with this artifact. */
    private SortedMap<String, String> manifest = new TreeMap<>();

    /** A list of all the vulnerabilties found with this artifact. */
    private List<Vulnerability> vulnerabilities = new ArrayList<>();

    /**
     * The scm tag if an artifact doesn't have the hash.
     */
    private String scmTag = "";

    /**
     * @return true if the has the scm project, repo, and (hash or version).
     */
    public boolean hasRequiredGitInfo() {
        return StringUtils.isNotBlank(getScmProject()) && //
            StringUtils.isNotBlank(getScmRepo()) && //
            (StringUtils.isNotBlank(getScmHash()) || StringUtils.isNotBlank(getVersion()));
    }

    public String buildGitCloneUrl() {
        String cloneUrl;

        if (github) {
            cloneUrl = "git@github.com:" + getScmProject() + "/" + getScmRepo() + ".git";
        } else {
            String toolsHost = System.getenv(Constants.TOOLS_HOST);
            if (StringUtils.isBlank(toolsHost)) {
                throw new RuntimeException("The 'TOOLS_HOST' env variable has to be set");
            }
            cloneUrl = "ssh://git@" + toolsHost + ":7999/" + getScmProject() + "/" + getScmRepo() + ".git";
        }

        return cloneUrl;
    }

    public String getScmProject() {
        String scmProject = manifest.get(SCM_PROJECT);

        if (StringUtils.isNotBlank(correctedScmProject)) {
            scmProject = correctedScmProject;

        } else if (StringUtils.isBlank(scmProject) && StringUtils.isNotBlank(getScmRepo())
            && StringUtils.isNotBlank(getScmHash())) {

            // only default it if it's the only info missing
            scmProject = "ICAPPS";
            System.out.println("Defaulting project name to: " + scmProject + " for " + getScmRepo());
        }

        return scmProject;
    }

    public String getScmRepo() {
        String repo = manifest.get(SCM_REPO);

        if (StringUtils.isNotBlank(correctedScmRepo)) {
            repo = correctedScmRepo;
        }

        return repo;
    }

    public String getScmHash() {
        return cleanHash(manifest.get(SCM_HASH));
    }

    public String getScmHashAbbrev() {
        return cleanHash(manifest.get("Scm-Sha1-Abbrev"));
    }

    /**
     * This will build a url to the commit in source control.
     *
     * @return the link to the scm commit, or blank if we don't have enough info
     */
    public String getScmUrl() {
        String url = "";

        // only build the url if we have the needed data
        if (StringUtils.isNotBlank(getScmProject()) && //
            StringUtils.isNotBlank(getScmRepo())) {

            String toolsHost = System.getenv(Constants.TOOLS_HOST);
            url = "https://" + toolsHost + "/scm/projects/" + getScmProject() + "/repos/" + getScmRepo();

            if (StringUtils.isNotBlank(getScmHash())) {
                url += "/commits/" + getScmHash();
            } else {
                url += "/browse?at=refs%2Ftags%2F" + getScmTag();
            }
        }

        return url;
    }

    /**
     * Removes the "-dirty" text that some older versions had added.
     *
     * @param hash to be cleaned
     * @return a clean hash
     */
    private String cleanHash(String hash) {
        if (StringUtils.isNotBlank(hash) && hash.endsWith("-dirty")) {
            hash = hash.replaceAll("-dirty", "");
        }
        return hash;
    }

    /**
     * @return the build date if it exists and is parsable.
     */

    public Date getBuildDate() {
        String string = manifest.get(BUILD_TIME);
        Date date = null;

        if (StringUtils.isNotBlank(string)) {

            // try the first date format
            try {
                date = MAVEN_DATE_FORMAT.parse(string);
            } catch (ParseException e) {
                // don't log
            }

            // if it didn't work, try the older format
            if (null == date) {
                try {
                    date = MAVEN_OLD_DATE_FORMAT.parse(string);
                } catch (ParseException e) {
                    // don't log
                }
            }

            // if it's not blank and we can't parse either date format, something is wrong
            if (null == date) {
                System.err.println("Could not parse date : " + string);
            }
        }

        return date;
    }

    /**
     * @return a short formatted build date
     */
    public String getBuildDateFormatted() {
        String result = "";
        Date date = getBuildDate();
        if (null != date) {
            result = SHORT_DATE_FORMAT.format(date);
        }
        return result;
    }

    public String getGroupId() {
        return manifest.get("Implementation-Vendor-Id");
    }

    /**
     * @return the artifactId if we have it in the manifest, or the corrected one otherwise.
     */
    public String getArtifactId() {
        String artifactId = manifest.get(ARTIFACT_ID);

        if (StringUtils.isBlank(artifactId)) {
            artifactId = correctedArtifactId;
        }

        return artifactId;
    }

    public String getVersion() {
        return manifest.get(VERSION);
    }

    public String getTitle() {
        return manifest.get(IMPLEMENTATION_TITLE);
    }

    public String getJiraKey() {
        String url = manifest.get(ISSUE_TRACKING);
        String key = "";

        if (StringUtils.isNotBlank(url)) {
            key = url.substring(url.lastIndexOf("/") + 1);
        }

        return key;
    }

    public String getNexusUrl() {
        String toolsHost = System.getenv(Constants.TOOLS_HOST);

        // default it to a blank string if we don't have the the artifactId
        String artifactId = getArtifactId();
        if (null == artifactId) {
            artifactId = "";
        }

        return "https://" + toolsHost + "/maven-proxy/#nexus-search;gav~" + getGroupId() + "~" + artifactId + "~"
            + getVersion() + "~ear~";

    }

    /** A link to the file that has the issues with java 8. */
    public String getJava8Url() {
        String baseUrl = getBaseUrl();
        if (null == baseUrl) {
            return "#";
        } // else
        return baseUrl + "/" + Constants.JAVA8_ISSUES_FILENAME;
    }

    /** A link to the dependency tree. */
    public String getDependencyTree() {
        String baseUrl = getBaseUrl();
        if (null == baseUrl) {
            return "#";
        } // else
        return baseUrl + "/tree.txt";
    }

    private String getBaseUrl() {
        // default to null
        String url = null;

        if (StringUtils.isNotBlank(getScmProject()) && //
            StringUtils.isNotBlank(getScmRepo()) && //
            (StringUtils.isNotBlank(getScmHash()) || StringUtils.isNotBlank(getVersion()))) {

            url = getScmProject() + "/" + getScmRepo() + "/" + getScmHash() + "/";
            if (StringUtils.isBlank(getScmHash())) {
                url += getVersion();
            } else {
                url += getScmHash();
            }
        }

        return url;
    }

    public String getJiraUrl() {
        return manifest.get(ISSUE_TRACKING);
    }

    /** A link to the owasp dependency check report. */
    public String getOwaspDependencyCheckUrl() {
        String baseUrl = getBaseUrl();
        if (null == baseUrl) {
            return "#";
        } // else
        return baseUrl + "/target/dependency-check-report.html";
    }

    /**
     * @return the number of cve's with severity of Low.
     */
    public int getCveSeverityCountLow() {
        int count = 0;
        for (Vulnerability vulnerability : vulnerabilities) {
            if ("Low".equals(vulnerability.getSeverity())) {
                count++;
            }
        }
        return count;
    }

    /**
     * @return the number of cve's with severity of Medium.
     */
    public int getCveSeverityCountMedium() {
        int count = 0;
        for (Vulnerability vulnerability : vulnerabilities) {
            if ("Medium".equals(vulnerability.getSeverity())) {
                count++;
            }
        }
        return count;
    }

    /**
     * @return the number of cve's with severity of High.
     */
    public int getCveSeverityCountHigh() {
        int count = 0;
        for (Vulnerability vulnerability : vulnerabilities) {
            if ("High".equals(vulnerability.getSeverity())) {
                count++;
            }
        }
        return count;
    }

    /**
     * @return the hash or tag so we can link to it
     */
    public String getHashOrTag() {
        String text = getScmHashAbbrev();
        if (StringUtils.isBlank(text)) {
            text = getScmTag();
        }
        return text;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int compareTo(ArtifactAttributes o) {
        return CompareToBuilder.reflectionCompare(this, o);
    }

    /**
     * @return the manifest
     */
    public Map<String, String> getManifest() {
        return manifest;
    }

    /**
     * @param manifest the manifest to set
     */
    public void setManifest(SortedMap<String, String> manifest) {
        this.manifest = manifest;
    }

    /**
     * @return the github
     */
    public boolean isGithub() {
        return github;
    }

    /**
     * @param github the github to set
     */
    public void setGithub(boolean github) {
        this.github = github;
    }

    /**
     * @return the correctedScmProject
     */
    public String getCorrectedScmProject() {
        return correctedScmProject;
    }

    /**
     * @param correctedScmProject the correctedScmProject to set
     */
    public void setCorrectedScmProject(String correctedScmProject) {
        this.correctedScmProject = correctedScmProject;
    }

    /**
     * @return the correctedScmRepo
     */
    public String getCorrectedScmRepo() {
        return correctedScmRepo;
    }

    /**
     * @param correctedScmRepo the correctedScmRepo to set
     */
    public void setCorrectedScmRepo(String correctedScmRepo) {
        this.correctedScmRepo = correctedScmRepo;
    }

    /**
     * @return the alreadyTrackedByAnother
     */
    public boolean isAlreadyTrackedByAnother() {
        return alreadyTrackedByAnother;
    }

    /**
     * @param alreadyTrackedByAnother the alreadyTrackedByAnother to set
     */
    public void setAlreadyTrackedByAnother(boolean alreadyTrackedByAnother) {
        this.alreadyTrackedByAnother = alreadyTrackedByAnother;
    }

    /**
     * @return the java8Ready
     */
    public boolean isJava8Ready() {
        return java8Ready;
    }

    /**
     * @param java8Ready the java8Ready to set
     */
    public void setJava8Ready(boolean java8Ready) {
        this.java8Ready = java8Ready;
    }

    /**
     * @return the vulnerabilities
     */
    public List<Vulnerability> getVulnerabilities() {
        return vulnerabilities;
    }

    /**
     * @param vulnerabilities the vulnerabilities to set
     */
    public void setVulnerabilities(List<Vulnerability> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

    /**
     * @return the correctedArtifactId
     */
    public String getCorrectedArtifactId() {
        return correctedArtifactId;
    }

    /**
     * @param correctedArtifactId the correctedArtifactId to set
     */
    public void setCorrectedArtifactId(String correctedArtifactId) {
        this.correctedArtifactId = correctedArtifactId;
    }

    /**
     * @return the scmTag
     */
    public String getScmTag() {
        return scmTag;
    }

    /**
     * @param scmTag the scmTag to set
     */
    public void setScmTag(String scmTag) {
        this.scmTag = scmTag;
    }

}
