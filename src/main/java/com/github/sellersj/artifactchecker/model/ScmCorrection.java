package com.github.sellersj.artifactchecker.model;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ScmCorrection implements Comparable<ScmCorrection> {

    /** The title that is captured in the manifest. */
    private String implementationTitle;

    /** The proper scm project. */
    private String scmProject = "";

    /** The proper scm repo. */
    private String scmRepo = "";

    /** The proper groupId. */
    private String groupId = "";

    /** The proper artifactId. */
    private String artifactId = "";

    /** The jira key. */
    private String jiraKey = "";

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int compareTo(ScmCorrection rhs) {
        CompareToBuilder builder = new CompareToBuilder();

        builder.append(getImplementationTitle(), rhs.getImplementationTitle());
        builder.append(getScmProject(), rhs.getScmProject());
        builder.append(getScmRepo(), rhs.getScmRepo());
        builder.append(getArtifactId(), rhs.getArtifactId());
        builder.append(getJiraKey(), rhs.getJiraKey());

        return builder.toComparison();
    }

    /**
     * @return the implementationTitle
     */
    public String getImplementationTitle() {
        return implementationTitle;
    }

    /**
     * @param implementationTitle the implementationTitle to set
     */
    public void setImplementationTitle(String implementationTitle) {
        this.implementationTitle = implementationTitle;
    }

    /**
     * @return the scmProject
     */
    public String getScmProject() {
        return scmProject;
    }

    /**
     * @param scmProject the scmProject to set
     */
    public void setScmProject(String scmProject) {
        this.scmProject = scmProject;
    }

    /**
     * @return the scmRepo
     */
    public String getScmRepo() {
        return scmRepo;
    }

    /**
     * @param scmRepo the scmRepo to set
     */
    public void setScmRepo(String scmRepo) {
        this.scmRepo = scmRepo;
    }

    /**
     * @return the artifactId
     */
    public String getArtifactId() {
        return artifactId;
    }

    /**
     * @param artifactId the artifactId to set
     */
    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    /**
     * @return the jiraKey
     */
    public String getJiraKey() {
        return jiraKey;
    }

    /**
     * @param jiraKey the jiraKey to set
     */
    public void setJiraKey(String jiraKey) {
        this.jiraKey = jiraKey;
    }

    /**
     * @return the groupId
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * @param groupId the groupId to set
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

}
