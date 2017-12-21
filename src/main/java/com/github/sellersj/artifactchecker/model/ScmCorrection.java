package com.github.sellersj.artifactchecker.model;

public class ScmCorrection {

    /** The title that is captured in the manifest. */
    private String implementationTitle;

    /** The proper scm project. */
    private String scmProject;

    /** The proper scm repo. */
    private String scmRepo;

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

}
