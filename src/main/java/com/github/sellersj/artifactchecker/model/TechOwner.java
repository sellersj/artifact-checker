package com.github.sellersj.artifactchecker.model;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class TechOwner implements Comparable<TechOwner> {

    /** The jira key. */
    private String jiraKey = "";

    /** The proper techOwner. */
    private String techOwner = "";

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
    public int compareTo(TechOwner rhs) {
        CompareToBuilder builder = new CompareToBuilder();

        builder.append(getJiraKey(), rhs.getJiraKey());
        builder.append(getTechOwner(), rhs.getTechOwner());

        return builder.toComparison();
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
     * @return the techOwner
     */
    public String getTechOwner() {
        return techOwner;
    }

    /**
     * @param techOwner the techOwner to set
     */
    public void setTechOwner(String techOwner) {
        this.techOwner = techOwner;
    }

}
