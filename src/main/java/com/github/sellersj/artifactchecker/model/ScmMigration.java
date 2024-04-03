package com.github.sellersj.artifactchecker.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ScmMigration {

    /** The old scm project. */
    private String oldScmProject = "";

    /** The old scm repo. */
    private String oldScmRepo = "";

    /** The new scm project. */
    private String newScmProject = "";

    /** The new scm repo. */
    private String newScmRepo = "";

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

    /**
     * @return the oldScmProject
     */
    public String getOldScmProject() {
        return oldScmProject;
    }

    /**
     * @param oldScmProject the oldScmProject to set
     */
    public void setOldScmProject(String oldScmProject) {
        this.oldScmProject = oldScmProject;
    }

    /**
     * @return the oldScmRepo
     */
    public String getOldScmRepo() {
        return oldScmRepo;
    }

    /**
     * @param oldScmRepo the oldScmRepo to set
     */
    public void setOldScmRepo(String oldScmRepo) {
        this.oldScmRepo = oldScmRepo;
    }

    /**
     * @return the newScmProject
     */
    public String getNewScmProject() {
        return newScmProject;
    }

    /**
     * @param newScmProject the newScmProject to set
     */
    public void setNewScmProject(String newScmProject) {
        this.newScmProject = newScmProject;
    }

    /**
     * @return the newScmRepo
     */
    public String getNewScmRepo() {
        return newScmRepo;
    }

    /**
     * @param newScmRepo the newScmRepo to set
     */
    public void setNewScmRepo(String newScmRepo) {
        this.newScmRepo = newScmRepo;
    }

}
