package com.github.sellersj.artifactchecker.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    /** The maven date format. */
    private static final SimpleDateFormat MAVEN_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    /** The old maven date format. */
    private static final SimpleDateFormat MAVEN_OLD_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd-HHmm");

    /** If this is a githug host. */
    private boolean github = false;

    /** Our corrected scm project from a static file. */
    private String correctedScmProject;

    /** Our corrected scm repo from a static file. */
    private String correctedScmRepo;

    /** Flag for if this artficat's repo was already checked by another artifact (e.g. 1 repo, 2 ears). */
    private boolean alreadyTrackedByAnother = false;

    /** Flag for if we can run this on java 8. */
    private boolean java8Ready = false;

    private SortedMap<String, String> manifest = new TreeMap<>();

    /**
     *
     * @return true if the has the scm project, repo, and hash.
     */
    public boolean hasRequiredGitInfo() {
        return StringUtils.isNotBlank(getScmProject()) && //
            StringUtils.isNotBlank(getScmRepo()) && //
            StringUtils.isNotBlank(getScmHash());
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
            StringUtils.isNotBlank(getScmRepo()) && //
            StringUtils.isNotBlank(getScmHash()) //
        ) {
            String toolsHost = System.getenv(Constants.TOOLS_HOST);
            url = "https://" + toolsHost + "/scm/projects/" + getScmProject() + "/repos/" + getScmRepo() + "/"
                + getScmHash();
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

    public String getGroupId() {
        return manifest.get("Implementation-Vendor-Id");
    }

    public String getArtifactId() {
        return manifest.get("Implementation-Artifact-Id");
    }

    public String getVersion() {
        return manifest.get("Implementation-Version");
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
        return "https://" + toolsHost + "/maven-proxy/search?g=" + getGroupId() + "&a=" + getArtifactId() + "&v="
            + getVersion();
    }

    public String getJiraUrl() {
        return manifest.get(ISSUE_TRACKING);
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

}
