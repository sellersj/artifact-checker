package com.github.sellersj.artifactchecker.model;

import java.beans.Transient;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

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
    public final static String SCM_PROJECT = "SCM-PROJECT";

    /** The git repo name. */
    public static final String SCM_REPO = "SCM-SCM_REPO";

    /** The git hash that we want to checkout. */
    public static final String SCM_HASH = "SCM-HAS";

    /** If this is a githug host. */
    private boolean github = false;

    private SortedMap<String, String> manifest = new TreeMap<>();

    @Transient
    public String buildGitCloneUrl() {
        return "git@github.com:" + getScmProject() + "/" + getScmRepo() + ".git";
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
    public String getGroupId() {
        return manifest.get("Implementation-Vendor-Id");
    }

    @Transient
    public String getArtifactId() {
        System.out.println("getArtifactId is not done yet");
        return manifest.get("Implementation-Vendor-Id");
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
