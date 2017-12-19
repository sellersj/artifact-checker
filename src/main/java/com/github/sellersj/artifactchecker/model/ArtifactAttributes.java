package com.github.sellersj.artifactchecker.model;

import java.beans.Transient;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Any attributes that we will track for an artifact.
 *
 * @author sellersj
 */
public class ArtifactAttributes implements Comparable<ArtifactAttributes> {

    /** The project or user that a git repo is stored under. */
    public final static String SCM_PROJECT = "Scm-Project-Id";

    /** The git repo name. */
    public static final String SCM_REPO = "Scm-Repo-Name";

    /** The git hash that we want to checkout. */
    public static final String SCM_HASH = "Scm-Sha1";

    /** If this is a githug host. */
    private boolean github = false;

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

    @Transient
    public String buildGitCloneUrl() {
        String cloneUrl;

        if (github) {
            cloneUrl = "git@github.com:" + getScmProject() + "/" + getScmRepo() + ".git";
        } else {
            String toolsHost = System.getenv("TOOLS_HOST");
            if (StringUtils.isBlank(toolsHost)) {
                throw new RuntimeException("The 'TOOLS_HOST' env variable has to be set");
            }
            cloneUrl = "ssh://git@" + toolsHost + ":7999/" + getScmProject() + "/" + getScmRepo() + ".git";
        }

        return cloneUrl;
    }

    @Transient
    public String getScmProject() {
        return manifest.get(SCM_PROJECT);
    }

    @Transient
    public String getScmRepo() {
        return manifest.get(SCM_REPO);
    }

    @Transient
    public String getScmHash() {
        return manifest.get(SCM_HASH);
    }

    @Transient
    public String getGroupId() {
        return manifest.get("Implementation-Vendor-Id");
    }

    @Transient
    public String getArtifactId() {
        return manifest.get("Implementation-Artifact-Id");
    }

    @Transient
    public String getVersion() {
        return manifest.get("Implementation-Version");
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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

}
