
package com.github.sellersj.artifactchecker.model.inventory;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Build-Jdk-Spec",
    "Build-Time",
    "Created-By",
    "Implementation-Artifact-Id",
    "Implementation-Title",
    "Implementation-Vendor",
    "Implementation-Version",
    "Issue-System",
    "Issue-Tracking",
    "Manifest-Version",
    "Maven-Project-ArtifactId",
    "Maven-Project-GroupId",
    "Maven-Project-Version",
    "Scm-Commit-Date",
    "Scm-Project-Id",
    "Scm-Repo-Name",
    "Scm-Sha1",
    "Scm-Sha1-Abbrev",
    "Scm-branch",
    "Archiver-Version",
    "Build-Java",
    "Build-Jdk",
    "Build-Label",
    "Build-Maven",
    "Build-OS",
    "Build-User",
    "Built-By",
    "Class-Path",
    "Implementation-Vendor-Id",
    "Ignore-Scanning-Archives",
    "Implementation-Deployment-Version",
    "Ant-Version",
    "Specification-Title",
    "Specification-Vendor",
    "Specification-Version"
})
@Generated("jsonschema2pojo")
public class ManifestFromWebsphere {

    @JsonProperty("Build-Jdk-Spec")
    private String buildJdkSpec;
    @JsonProperty("Build-Time")
    private String buildTime;
    @JsonProperty("Created-By")
    private String createdBy;
    @JsonProperty("Implementation-Artifact-Id")
    private String implementationArtifactId;
    @JsonProperty("Implementation-Title")
    private String implementationTitle;
    @JsonProperty("Implementation-Vendor")
    private String implementationVendor;
    @JsonProperty("Implementation-Version")
    private String implementationVersion;
    @JsonProperty("Issue-System")
    private String issueSystem;
    @JsonProperty("Issue-Tracking")
    private String issueTracking;
    @JsonProperty("Manifest-Version")
    private String manifestVersion;
    @JsonProperty("Maven-Project-ArtifactId")
    private String mavenProjectArtifactId;
    @JsonProperty("Maven-Project-GroupId")
    private String mavenProjectGroupId;
    @JsonProperty("Maven-Project-Version")
    private String mavenProjectVersion;
    @JsonProperty("Scm-Commit-Date")
    private String scmCommitDate;
    @JsonProperty("Scm-Project-Id")
    private String scmProjectId;
    @JsonProperty("Scm-Repo-Name")
    private String scmRepoName;
    @JsonProperty("Scm-Sha1")
    private String scmSha1;
    @JsonProperty("Scm-Sha1-Abbrev")
    private String scmSha1Abbrev;
    @JsonProperty("Scm-branch")
    private String scmBranch;
    @JsonProperty("Archiver-Version")
    private String archiverVersion;
    @JsonProperty("Build-Java")
    private String buildJava;
    @JsonProperty("Build-Jdk")
    private String buildJdk;
    @JsonProperty("Build-Label")
    private String buildLabel;
    @JsonProperty("Build-Maven")
    private String buildMaven;
    @JsonProperty("Build-OS")
    private String buildOS;
    @JsonProperty("Build-User")
    private String buildUser;
    @JsonProperty("Built-By")
    private String builtBy;
    @JsonProperty("Class-Path")
    private String classPath;
    @JsonProperty("Implementation-Vendor-Id")
    private String implementationVendorId;
    @JsonProperty("Ignore-Scanning-Archives")
    private String ignoreScanningArchives;
    @JsonProperty("Implementation-Deployment-Version")
    private String implementationDeploymentVersion;
    @JsonProperty("Ant-Version")
    private String antVersion;
    @JsonProperty("Specification-Title")
    private String specificationTitle;
    @JsonProperty("Specification-Vendor")
    private String specificationVendor;
    @JsonProperty("Specification-Version")
    private String specificationVersion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("Build-Jdk-Spec")
    public String getBuildJdkSpec() {
        return buildJdkSpec;
    }

    @JsonProperty("Build-Jdk-Spec")
    public void setBuildJdkSpec(String buildJdkSpec) {
        this.buildJdkSpec = buildJdkSpec;
    }

    @JsonProperty("Build-Time")
    public String getBuildTime() {
        return buildTime;
    }

    @JsonProperty("Build-Time")
    public void setBuildTime(String buildTime) {
        this.buildTime = buildTime;
    }

    @JsonProperty("Created-By")
    public String getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("Created-By")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("Implementation-Artifact-Id")
    public String getImplementationArtifactId() {
        return implementationArtifactId;
    }

    @JsonProperty("Implementation-Artifact-Id")
    public void setImplementationArtifactId(String implementationArtifactId) {
        this.implementationArtifactId = implementationArtifactId;
    }

    @JsonProperty("Implementation-Title")
    public String getImplementationTitle() {
        return implementationTitle;
    }

    @JsonProperty("Implementation-Title")
    public void setImplementationTitle(String implementationTitle) {
        this.implementationTitle = implementationTitle;
    }

    @JsonProperty("Implementation-Vendor")
    public String getImplementationVendor() {
        return implementationVendor;
    }

    @JsonProperty("Implementation-Vendor")
    public void setImplementationVendor(String implementationVendor) {
        this.implementationVendor = implementationVendor;
    }

    @JsonProperty("Implementation-Version")
    public String getImplementationVersion() {
        return implementationVersion;
    }

    @JsonProperty("Implementation-Version")
    public void setImplementationVersion(String implementationVersion) {
        this.implementationVersion = implementationVersion;
    }

    @JsonProperty("Issue-System")
    public String getIssueSystem() {
        return issueSystem;
    }

    @JsonProperty("Issue-System")
    public void setIssueSystem(String issueSystem) {
        this.issueSystem = issueSystem;
    }

    @JsonProperty("Issue-Tracking")
    public String getIssueTracking() {
        return issueTracking;
    }

    @JsonProperty("Issue-Tracking")
    public void setIssueTracking(String issueTracking) {
        this.issueTracking = issueTracking;
    }

    @JsonProperty("Manifest-Version")
    public String getManifestVersion() {
        return manifestVersion;
    }

    @JsonProperty("Manifest-Version")
    public void setManifestVersion(String manifestVersion) {
        this.manifestVersion = manifestVersion;
    }

    @JsonProperty("Maven-Project-ArtifactId")
    public String getMavenProjectArtifactId() {
        return mavenProjectArtifactId;
    }

    @JsonProperty("Maven-Project-ArtifactId")
    public void setMavenProjectArtifactId(String mavenProjectArtifactId) {
        this.mavenProjectArtifactId = mavenProjectArtifactId;
    }

    @JsonProperty("Maven-Project-GroupId")
    public String getMavenProjectGroupId() {
        return mavenProjectGroupId;
    }

    @JsonProperty("Maven-Project-GroupId")
    public void setMavenProjectGroupId(String mavenProjectGroupId) {
        this.mavenProjectGroupId = mavenProjectGroupId;
    }

    @JsonProperty("Maven-Project-Version")
    public String getMavenProjectVersion() {
        return mavenProjectVersion;
    }

    @JsonProperty("Maven-Project-Version")
    public void setMavenProjectVersion(String mavenProjectVersion) {
        this.mavenProjectVersion = mavenProjectVersion;
    }

    @JsonProperty("Scm-Commit-Date")
    public String getScmCommitDate() {
        return scmCommitDate;
    }

    @JsonProperty("Scm-Commit-Date")
    public void setScmCommitDate(String scmCommitDate) {
        this.scmCommitDate = scmCommitDate;
    }

    @JsonProperty("Scm-Project-Id")
    public String getScmProjectId() {
        return scmProjectId;
    }

    @JsonProperty("Scm-Project-Id")
    public void setScmProjectId(String scmProjectId) {
        this.scmProjectId = scmProjectId;
    }

    @JsonProperty("Scm-Repo-Name")
    public String getScmRepoName() {
        return scmRepoName;
    }

    @JsonProperty("Scm-Repo-Name")
    public void setScmRepoName(String scmRepoName) {
        this.scmRepoName = scmRepoName;
    }

    @JsonProperty("Scm-Sha1")
    public String getScmSha1() {
        return scmSha1;
    }

    @JsonProperty("Scm-Sha1")
    public void setScmSha1(String scmSha1) {
        this.scmSha1 = scmSha1;
    }

    @JsonProperty("Scm-Sha1-Abbrev")
    public String getScmSha1Abbrev() {
        return scmSha1Abbrev;
    }

    @JsonProperty("Scm-Sha1-Abbrev")
    public void setScmSha1Abbrev(String scmSha1Abbrev) {
        this.scmSha1Abbrev = scmSha1Abbrev;
    }

    @JsonProperty("Scm-branch")
    public String getScmBranch() {
        return scmBranch;
    }

    @JsonProperty("Scm-branch")
    public void setScmBranch(String scmBranch) {
        this.scmBranch = scmBranch;
    }

    @JsonProperty("Archiver-Version")
    public String getArchiverVersion() {
        return archiverVersion;
    }

    @JsonProperty("Archiver-Version")
    public void setArchiverVersion(String archiverVersion) {
        this.archiverVersion = archiverVersion;
    }

    @JsonProperty("Build-Java")
    public String getBuildJava() {
        return buildJava;
    }

    @JsonProperty("Build-Java")
    public void setBuildJava(String buildJava) {
        this.buildJava = buildJava;
    }

    @JsonProperty("Build-Jdk")
    public String getBuildJdk() {
        return buildJdk;
    }

    @JsonProperty("Build-Jdk")
    public void setBuildJdk(String buildJdk) {
        this.buildJdk = buildJdk;
    }

    @JsonProperty("Build-Label")
    public String getBuildLabel() {
        return buildLabel;
    }

    @JsonProperty("Build-Label")
    public void setBuildLabel(String buildLabel) {
        this.buildLabel = buildLabel;
    }

    @JsonProperty("Build-Maven")
    public String getBuildMaven() {
        return buildMaven;
    }

    @JsonProperty("Build-Maven")
    public void setBuildMaven(String buildMaven) {
        this.buildMaven = buildMaven;
    }

    @JsonProperty("Build-OS")
    public String getBuildOS() {
        return buildOS;
    }

    @JsonProperty("Build-OS")
    public void setBuildOS(String buildOS) {
        this.buildOS = buildOS;
    }

    @JsonProperty("Build-User")
    public String getBuildUser() {
        return buildUser;
    }

    @JsonProperty("Build-User")
    public void setBuildUser(String buildUser) {
        this.buildUser = buildUser;
    }

    @JsonProperty("Built-By")
    public String getBuiltBy() {
        return builtBy;
    }

    @JsonProperty("Built-By")
    public void setBuiltBy(String builtBy) {
        this.builtBy = builtBy;
    }

    @JsonProperty("Class-Path")
    public String getClassPath() {
        return classPath;
    }

    @JsonProperty("Class-Path")
    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    @JsonProperty("Implementation-Vendor-Id")
    public String getImplementationVendorId() {
        return implementationVendorId;
    }

    @JsonProperty("Implementation-Vendor-Id")
    public void setImplementationVendorId(String implementationVendorId) {
        this.implementationVendorId = implementationVendorId;
    }

    @JsonProperty("Ignore-Scanning-Archives")
    public String getIgnoreScanningArchives() {
        return ignoreScanningArchives;
    }

    @JsonProperty("Ignore-Scanning-Archives")
    public void setIgnoreScanningArchives(String ignoreScanningArchives) {
        this.ignoreScanningArchives = ignoreScanningArchives;
    }

    @JsonProperty("Implementation-Deployment-Version")
    public String getImplementationDeploymentVersion() {
        return implementationDeploymentVersion;
    }

    @JsonProperty("Implementation-Deployment-Version")
    public void setImplementationDeploymentVersion(String implementationDeploymentVersion) {
        this.implementationDeploymentVersion = implementationDeploymentVersion;
    }

    @JsonProperty("Ant-Version")
    public String getAntVersion() {
        return antVersion;
    }

    @JsonProperty("Ant-Version")
    public void setAntVersion(String antVersion) {
        this.antVersion = antVersion;
    }

    @JsonProperty("Specification-Title")
    public String getSpecificationTitle() {
        return specificationTitle;
    }

    @JsonProperty("Specification-Title")
    public void setSpecificationTitle(String specificationTitle) {
        this.specificationTitle = specificationTitle;
    }

    @JsonProperty("Specification-Vendor")
    public String getSpecificationVendor() {
        return specificationVendor;
    }

    @JsonProperty("Specification-Vendor")
    public void setSpecificationVendor(String specificationVendor) {
        this.specificationVendor = specificationVendor;
    }

    @JsonProperty("Specification-Version")
    public String getSpecificationVersion() {
        return specificationVersion;
    }

    @JsonProperty("Specification-Version")
    public void setSpecificationVersion(String specificationVersion) {
        this.specificationVersion = specificationVersion;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ManifestFromWebsphere.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("buildJdkSpec");
        sb.append('=');
        sb.append(((this.buildJdkSpec == null)?"<null>":this.buildJdkSpec));
        sb.append(',');
        sb.append("buildTime");
        sb.append('=');
        sb.append(((this.buildTime == null)?"<null>":this.buildTime));
        sb.append(',');
        sb.append("createdBy");
        sb.append('=');
        sb.append(((this.createdBy == null)?"<null>":this.createdBy));
        sb.append(',');
        sb.append("implementationArtifactId");
        sb.append('=');
        sb.append(((this.implementationArtifactId == null)?"<null>":this.implementationArtifactId));
        sb.append(',');
        sb.append("implementationTitle");
        sb.append('=');
        sb.append(((this.implementationTitle == null)?"<null>":this.implementationTitle));
        sb.append(',');
        sb.append("implementationVendor");
        sb.append('=');
        sb.append(((this.implementationVendor == null)?"<null>":this.implementationVendor));
        sb.append(',');
        sb.append("implementationVersion");
        sb.append('=');
        sb.append(((this.implementationVersion == null)?"<null>":this.implementationVersion));
        sb.append(',');
        sb.append("issueSystem");
        sb.append('=');
        sb.append(((this.issueSystem == null)?"<null>":this.issueSystem));
        sb.append(',');
        sb.append("issueTracking");
        sb.append('=');
        sb.append(((this.issueTracking == null)?"<null>":this.issueTracking));
        sb.append(',');
        sb.append("manifestVersion");
        sb.append('=');
        sb.append(((this.manifestVersion == null)?"<null>":this.manifestVersion));
        sb.append(',');
        sb.append("mavenProjectArtifactId");
        sb.append('=');
        sb.append(((this.mavenProjectArtifactId == null)?"<null>":this.mavenProjectArtifactId));
        sb.append(',');
        sb.append("mavenProjectGroupId");
        sb.append('=');
        sb.append(((this.mavenProjectGroupId == null)?"<null>":this.mavenProjectGroupId));
        sb.append(',');
        sb.append("mavenProjectVersion");
        sb.append('=');
        sb.append(((this.mavenProjectVersion == null)?"<null>":this.mavenProjectVersion));
        sb.append(',');
        sb.append("scmCommitDate");
        sb.append('=');
        sb.append(((this.scmCommitDate == null)?"<null>":this.scmCommitDate));
        sb.append(',');
        sb.append("scmProjectId");
        sb.append('=');
        sb.append(((this.scmProjectId == null)?"<null>":this.scmProjectId));
        sb.append(',');
        sb.append("scmRepoName");
        sb.append('=');
        sb.append(((this.scmRepoName == null)?"<null>":this.scmRepoName));
        sb.append(',');
        sb.append("scmSha1");
        sb.append('=');
        sb.append(((this.scmSha1 == null)?"<null>":this.scmSha1));
        sb.append(',');
        sb.append("scmSha1Abbrev");
        sb.append('=');
        sb.append(((this.scmSha1Abbrev == null)?"<null>":this.scmSha1Abbrev));
        sb.append(',');
        sb.append("scmBranch");
        sb.append('=');
        sb.append(((this.scmBranch == null)?"<null>":this.scmBranch));
        sb.append(',');
        sb.append("archiverVersion");
        sb.append('=');
        sb.append(((this.archiverVersion == null)?"<null>":this.archiverVersion));
        sb.append(',');
        sb.append("buildJava");
        sb.append('=');
        sb.append(((this.buildJava == null)?"<null>":this.buildJava));
        sb.append(',');
        sb.append("buildJdk");
        sb.append('=');
        sb.append(((this.buildJdk == null)?"<null>":this.buildJdk));
        sb.append(',');
        sb.append("buildLabel");
        sb.append('=');
        sb.append(((this.buildLabel == null)?"<null>":this.buildLabel));
        sb.append(',');
        sb.append("buildMaven");
        sb.append('=');
        sb.append(((this.buildMaven == null)?"<null>":this.buildMaven));
        sb.append(',');
        sb.append("buildOS");
        sb.append('=');
        sb.append(((this.buildOS == null)?"<null>":this.buildOS));
        sb.append(',');
        sb.append("buildUser");
        sb.append('=');
        sb.append(((this.buildUser == null)?"<null>":this.buildUser));
        sb.append(',');
        sb.append("builtBy");
        sb.append('=');
        sb.append(((this.builtBy == null)?"<null>":this.builtBy));
        sb.append(',');
        sb.append("classPath");
        sb.append('=');
        sb.append(((this.classPath == null)?"<null>":this.classPath));
        sb.append(',');
        sb.append("implementationVendorId");
        sb.append('=');
        sb.append(((this.implementationVendorId == null)?"<null>":this.implementationVendorId));
        sb.append(',');
        sb.append("ignoreScanningArchives");
        sb.append('=');
        sb.append(((this.ignoreScanningArchives == null)?"<null>":this.ignoreScanningArchives));
        sb.append(',');
        sb.append("implementationDeploymentVersion");
        sb.append('=');
        sb.append(((this.implementationDeploymentVersion == null)?"<null>":this.implementationDeploymentVersion));
        sb.append(',');
        sb.append("antVersion");
        sb.append('=');
        sb.append(((this.antVersion == null)?"<null>":this.antVersion));
        sb.append(',');
        sb.append("specificationTitle");
        sb.append('=');
        sb.append(((this.specificationTitle == null)?"<null>":this.specificationTitle));
        sb.append(',');
        sb.append("specificationVendor");
        sb.append('=');
        sb.append(((this.specificationVendor == null)?"<null>":this.specificationVendor));
        sb.append(',');
        sb.append("specificationVersion");
        sb.append('=');
        sb.append(((this.specificationVersion == null)?"<null>":this.specificationVersion));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.antVersion == null)? 0 :this.antVersion.hashCode()));
        result = ((result* 31)+((this.specificationVendor == null)? 0 :this.specificationVendor.hashCode()));
        result = ((result* 31)+((this.scmRepoName == null)? 0 :this.scmRepoName.hashCode()));
        result = ((result* 31)+((this.scmSha1 == null)? 0 :this.scmSha1 .hashCode()));
        result = ((result* 31)+((this.implementationVersion == null)? 0 :this.implementationVersion.hashCode()));
        result = ((result* 31)+((this.manifestVersion == null)? 0 :this.manifestVersion.hashCode()));
        result = ((result* 31)+((this.buildLabel == null)? 0 :this.buildLabel.hashCode()));
        result = ((result* 31)+((this.buildJdkSpec == null)? 0 :this.buildJdkSpec.hashCode()));
        result = ((result* 31)+((this.buildJava == null)? 0 :this.buildJava.hashCode()));
        result = ((result* 31)+((this.implementationTitle == null)? 0 :this.implementationTitle.hashCode()));
        result = ((result* 31)+((this.mavenProjectGroupId == null)? 0 :this.mavenProjectGroupId.hashCode()));
        result = ((result* 31)+((this.mavenProjectVersion == null)? 0 :this.mavenProjectVersion.hashCode()));
        result = ((result* 31)+((this.archiverVersion == null)? 0 :this.archiverVersion.hashCode()));
        result = ((result* 31)+((this.buildOS == null)? 0 :this.buildOS.hashCode()));
        result = ((result* 31)+((this.buildMaven == null)? 0 :this.buildMaven.hashCode()));
        result = ((result* 31)+((this.specificationTitle == null)? 0 :this.specificationTitle.hashCode()));
        result = ((result* 31)+((this.classPath == null)? 0 :this.classPath.hashCode()));
        result = ((result* 31)+((this.implementationVendor == null)? 0 :this.implementationVendor.hashCode()));
        result = ((result* 31)+((this.buildJdk == null)? 0 :this.buildJdk.hashCode()));
        result = ((result* 31)+((this.issueTracking == null)? 0 :this.issueTracking.hashCode()));
        result = ((result* 31)+((this.specificationVersion == null)? 0 :this.specificationVersion.hashCode()));
        result = ((result* 31)+((this.issueSystem == null)? 0 :this.issueSystem.hashCode()));
        result = ((result* 31)+((this.implementationVendorId == null)? 0 :this.implementationVendorId.hashCode()));
        result = ((result* 31)+((this.mavenProjectArtifactId == null)? 0 :this.mavenProjectArtifactId.hashCode()));
        result = ((result* 31)+((this.buildTime == null)? 0 :this.buildTime.hashCode()));
        result = ((result* 31)+((this.buildUser == null)? 0 :this.buildUser.hashCode()));
        result = ((result* 31)+((this.scmCommitDate == null)? 0 :this.scmCommitDate.hashCode()));
        result = ((result* 31)+((this.scmProjectId == null)? 0 :this.scmProjectId.hashCode()));
        result = ((result* 31)+((this.scmSha1Abbrev == null)? 0 :this.scmSha1Abbrev.hashCode()));
        result = ((result* 31)+((this.builtBy == null)? 0 :this.builtBy.hashCode()));
        result = ((result* 31)+((this.scmBranch == null)? 0 :this.scmBranch.hashCode()));
        result = ((result* 31)+((this.createdBy == null)? 0 :this.createdBy.hashCode()));
        result = ((result* 31)+((this.implementationArtifactId == null)? 0 :this.implementationArtifactId.hashCode()));
        result = ((result* 31)+((this.ignoreScanningArchives == null)? 0 :this.ignoreScanningArchives.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.implementationDeploymentVersion == null)? 0 :this.implementationDeploymentVersion.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ManifestFromWebsphere) == false) {
            return false;
        }
        ManifestFromWebsphere rhs = ((ManifestFromWebsphere) other);
        return (((((((((((((((((((((((((((((((((((((this.antVersion == rhs.antVersion)||((this.antVersion!= null)&&this.antVersion.equals(rhs.antVersion)))&&((this.specificationVendor == rhs.specificationVendor)||((this.specificationVendor!= null)&&this.specificationVendor.equals(rhs.specificationVendor))))&&((this.scmRepoName == rhs.scmRepoName)||((this.scmRepoName!= null)&&this.scmRepoName.equals(rhs.scmRepoName))))&&((this.scmSha1 == rhs.scmSha1)||((this.scmSha1 != null)&&this.scmSha1 .equals(rhs.scmSha1))))&&((this.implementationVersion == rhs.implementationVersion)||((this.implementationVersion!= null)&&this.implementationVersion.equals(rhs.implementationVersion))))&&((this.manifestVersion == rhs.manifestVersion)||((this.manifestVersion!= null)&&this.manifestVersion.equals(rhs.manifestVersion))))&&((this.buildLabel == rhs.buildLabel)||((this.buildLabel!= null)&&this.buildLabel.equals(rhs.buildLabel))))&&((this.buildJdkSpec == rhs.buildJdkSpec)||((this.buildJdkSpec!= null)&&this.buildJdkSpec.equals(rhs.buildJdkSpec))))&&((this.buildJava == rhs.buildJava)||((this.buildJava!= null)&&this.buildJava.equals(rhs.buildJava))))&&((this.implementationTitle == rhs.implementationTitle)||((this.implementationTitle!= null)&&this.implementationTitle.equals(rhs.implementationTitle))))&&((this.mavenProjectGroupId == rhs.mavenProjectGroupId)||((this.mavenProjectGroupId!= null)&&this.mavenProjectGroupId.equals(rhs.mavenProjectGroupId))))&&((this.mavenProjectVersion == rhs.mavenProjectVersion)||((this.mavenProjectVersion!= null)&&this.mavenProjectVersion.equals(rhs.mavenProjectVersion))))&&((this.archiverVersion == rhs.archiverVersion)||((this.archiverVersion!= null)&&this.archiverVersion.equals(rhs.archiverVersion))))&&((this.buildOS == rhs.buildOS)||((this.buildOS!= null)&&this.buildOS.equals(rhs.buildOS))))&&((this.buildMaven == rhs.buildMaven)||((this.buildMaven!= null)&&this.buildMaven.equals(rhs.buildMaven))))&&((this.specificationTitle == rhs.specificationTitle)||((this.specificationTitle!= null)&&this.specificationTitle.equals(rhs.specificationTitle))))&&((this.classPath == rhs.classPath)||((this.classPath!= null)&&this.classPath.equals(rhs.classPath))))&&((this.implementationVendor == rhs.implementationVendor)||((this.implementationVendor!= null)&&this.implementationVendor.equals(rhs.implementationVendor))))&&((this.buildJdk == rhs.buildJdk)||((this.buildJdk!= null)&&this.buildJdk.equals(rhs.buildJdk))))&&((this.issueTracking == rhs.issueTracking)||((this.issueTracking!= null)&&this.issueTracking.equals(rhs.issueTracking))))&&((this.specificationVersion == rhs.specificationVersion)||((this.specificationVersion!= null)&&this.specificationVersion.equals(rhs.specificationVersion))))&&((this.issueSystem == rhs.issueSystem)||((this.issueSystem!= null)&&this.issueSystem.equals(rhs.issueSystem))))&&((this.implementationVendorId == rhs.implementationVendorId)||((this.implementationVendorId!= null)&&this.implementationVendorId.equals(rhs.implementationVendorId))))&&((this.mavenProjectArtifactId == rhs.mavenProjectArtifactId)||((this.mavenProjectArtifactId!= null)&&this.mavenProjectArtifactId.equals(rhs.mavenProjectArtifactId))))&&((this.buildTime == rhs.buildTime)||((this.buildTime!= null)&&this.buildTime.equals(rhs.buildTime))))&&((this.buildUser == rhs.buildUser)||((this.buildUser!= null)&&this.buildUser.equals(rhs.buildUser))))&&((this.scmCommitDate == rhs.scmCommitDate)||((this.scmCommitDate!= null)&&this.scmCommitDate.equals(rhs.scmCommitDate))))&&((this.scmProjectId == rhs.scmProjectId)||((this.scmProjectId!= null)&&this.scmProjectId.equals(rhs.scmProjectId))))&&((this.scmSha1Abbrev == rhs.scmSha1Abbrev)||((this.scmSha1Abbrev!= null)&&this.scmSha1Abbrev.equals(rhs.scmSha1Abbrev))))&&((this.builtBy == rhs.builtBy)||((this.builtBy!= null)&&this.builtBy.equals(rhs.builtBy))))&&((this.scmBranch == rhs.scmBranch)||((this.scmBranch!= null)&&this.scmBranch.equals(rhs.scmBranch))))&&((this.createdBy == rhs.createdBy)||((this.createdBy!= null)&&this.createdBy.equals(rhs.createdBy))))&&((this.implementationArtifactId == rhs.implementationArtifactId)||((this.implementationArtifactId!= null)&&this.implementationArtifactId.equals(rhs.implementationArtifactId))))&&((this.ignoreScanningArchives == rhs.ignoreScanningArchives)||((this.ignoreScanningArchives!= null)&&this.ignoreScanningArchives.equals(rhs.ignoreScanningArchives))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.implementationDeploymentVersion == rhs.implementationDeploymentVersion)||((this.implementationDeploymentVersion!= null)&&this.implementationDeploymentVersion.equals(rhs.implementationDeploymentVersion))));
    }

}
