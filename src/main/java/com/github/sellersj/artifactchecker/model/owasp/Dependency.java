
package com.github.sellersj.artifactchecker.model.owasp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"isVirtual", "fileName", "filePath", "md5", "sha1", "sha256", "description", "projectReferences",
    "relatedDependencies", "evidenceCollected", "packages", "vulnerabilityIds", "license", "vulnerabilities",
    "suppressedVulnerabilities"})
public class Dependency {

    @JsonProperty("isVirtual")
    private Boolean isVirtual;

    @JsonProperty("fileName")
    private String fileName;

    @JsonProperty("filePath")
    private String filePath;

    @JsonProperty("md5")
    private String md5;

    @JsonProperty("sha1")
    private String sha1;

    @JsonProperty("sha256")
    private String sha256;

    @JsonProperty("description")
    private String description;

    @JsonProperty("projectReferences")
    private List<String> projectReferences = new ArrayList<String>();

    @JsonProperty("relatedDependencies")
    private List<RelatedDependency> relatedDependencies = new ArrayList<RelatedDependency>();

    @JsonProperty("evidenceCollected")
    private EvidenceCollected evidenceCollected;

    @JsonProperty("packages")
    private List<Package> packages = new ArrayList<Package>();

    @JsonProperty("vulnerabilityIds")
    private List<VulnerabilityId> vulnerabilityIds = new ArrayList<VulnerabilityId>();

    @JsonProperty("license")
    private String license;

    @JsonProperty("vulnerabilities")
    private List<Vulnerability> vulnerabilities = new ArrayList<Vulnerability>();

    @JsonProperty("suppressedVulnerabilities")
    private List<SuppressedVulnerability> suppressedVulnerabilities = new ArrayList<SuppressedVulnerability>();

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("isVirtual")
    public Boolean getIsVirtual() {
        return isVirtual;
    }

    @JsonProperty("isVirtual")
    public void setIsVirtual(Boolean isVirtual) {
        this.isVirtual = isVirtual;
    }

    @JsonProperty("fileName")
    public String getFileName() {
        return fileName;
    }

    @JsonProperty("fileName")
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @JsonProperty("filePath")
    public String getFilePath() {
        return filePath;
    }

    @JsonProperty("filePath")
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @JsonProperty("md5")
    public String getMd5() {
        return md5;
    }

    @JsonProperty("md5")
    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @JsonProperty("sha1")
    public String getSha1() {
        return sha1;
    }

    @JsonProperty("sha1")
    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    @JsonProperty("sha256")
    public String getSha256() {
        return sha256;
    }

    @JsonProperty("sha256")
    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("projectReferences")
    public List<String> getProjectReferences() {
        return projectReferences;
    }

    @JsonProperty("projectReferences")
    public void setProjectReferences(List<String> projectReferences) {
        this.projectReferences = projectReferences;
    }

    @JsonProperty("relatedDependencies")
    public List<RelatedDependency> getRelatedDependencies() {
        return relatedDependencies;
    }

    @JsonProperty("relatedDependencies")
    public void setRelatedDependencies(List<RelatedDependency> relatedDependencies) {
        this.relatedDependencies = relatedDependencies;
    }

    @JsonProperty("evidenceCollected")
    public EvidenceCollected getEvidenceCollected() {
        return evidenceCollected;
    }

    @JsonProperty("evidenceCollected")
    public void setEvidenceCollected(EvidenceCollected evidenceCollected) {
        this.evidenceCollected = evidenceCollected;
    }

    @JsonProperty("packages")
    public List<Package> getPackages() {
        return packages;
    }

    @JsonProperty("packages")
    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }

    @JsonProperty("vulnerabilityIds")
    public List<VulnerabilityId> getVulnerabilityIds() {
        return vulnerabilityIds;
    }

    @JsonProperty("vulnerabilityIds")
    public void setVulnerabilityIds(List<VulnerabilityId> vulnerabilityIds) {
        this.vulnerabilityIds = vulnerabilityIds;
    }

    @JsonProperty("license")
    public String getLicense() {
        return license;
    }

    @JsonProperty("license")
    public void setLicense(String license) {
        this.license = license;
    }

    @JsonProperty("vulnerabilities")
    public List<Vulnerability> getVulnerabilities() {
        return vulnerabilities;
    }

    @JsonProperty("vulnerabilities")
    public void setVulnerabilities(List<Vulnerability> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

    @JsonProperty("suppressedVulnerabilities")
    public List<SuppressedVulnerability> getSuppressedVulnerabilities() {
        return suppressedVulnerabilities;
    }

    @JsonProperty("suppressedVulnerabilities")
    public void setSuppressedVulnerabilities(List<SuppressedVulnerability> suppressedVulnerabilities) {
        this.suppressedVulnerabilities = suppressedVulnerabilities;
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
        sb.append(Dependency.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("isVirtual");
        sb.append('=');
        sb.append(((this.isVirtual == null) ? "<null>" : this.isVirtual));
        sb.append(',');
        sb.append("fileName");
        sb.append('=');
        sb.append(((this.fileName == null) ? "<null>" : this.fileName));
        sb.append(',');
        sb.append("filePath");
        sb.append('=');
        sb.append(((this.filePath == null) ? "<null>" : this.filePath));
        sb.append(',');
        sb.append("md5");
        sb.append('=');
        sb.append(((this.md5 == null) ? "<null>" : this.md5));
        sb.append(',');
        sb.append("sha1");
        sb.append('=');
        sb.append(((this.sha1 == null) ? "<null>" : this.sha1));
        sb.append(',');
        sb.append("sha256");
        sb.append('=');
        sb.append(((this.sha256 == null) ? "<null>" : this.sha256));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null) ? "<null>" : this.description));
        sb.append(',');
        sb.append("projectReferences");
        sb.append('=');
        sb.append(((this.projectReferences == null) ? "<null>" : this.projectReferences));
        sb.append(',');
        sb.append("relatedDependencies");
        sb.append('=');
        sb.append(((this.relatedDependencies == null) ? "<null>" : this.relatedDependencies));
        sb.append(',');
        sb.append("evidenceCollected");
        sb.append('=');
        sb.append(((this.evidenceCollected == null) ? "<null>" : this.evidenceCollected));
        sb.append(',');
        sb.append("packages");
        sb.append('=');
        sb.append(((this.packages == null) ? "<null>" : this.packages));
        sb.append(',');
        sb.append("vulnerabilityIds");
        sb.append('=');
        sb.append(((this.vulnerabilityIds == null) ? "<null>" : this.vulnerabilityIds));
        sb.append(',');
        sb.append("license");
        sb.append('=');
        sb.append(((this.license == null) ? "<null>" : this.license));
        sb.append(',');
        sb.append("vulnerabilities");
        sb.append('=');
        sb.append(((this.vulnerabilities == null) ? "<null>" : this.vulnerabilities));
        sb.append(',');
        sb.append("suppressedVulnerabilities");
        sb.append('=');
        sb.append(((this.suppressedVulnerabilities == null) ? "<null>" : this.suppressedVulnerabilities));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.fileName == null) ? 0 : this.fileName.hashCode()));
        result = ((result * 31) + ((this.projectReferences == null) ? 0 : this.projectReferences.hashCode()));
        result = ((result * 31) + ((this.sha256 == null) ? 0 : this.sha256.hashCode()));
        result = ((result * 31) + ((this.vulnerabilityIds == null) ? 0 : this.vulnerabilityIds.hashCode()));
        result = ((result * 31) + ((this.filePath == null) ? 0 : this.filePath.hashCode()));
        result = ((result * 31) + ((this.description == null) ? 0 : this.description.hashCode()));
        result = ((result * 31) + ((this.packages == null) ? 0 : this.packages.hashCode()));
        result = ((result * 31) + ((this.sha1 == null) ? 0 : this.sha1.hashCode()));
        result = ((result * 31) + ((this.license == null) ? 0 : this.license.hashCode()));
        result = ((result * 31) + ((this.vulnerabilities == null) ? 0 : this.vulnerabilities.hashCode()));
        result = ((result * 31)
            + ((this.suppressedVulnerabilities == null) ? 0 : this.suppressedVulnerabilities.hashCode()));
        result = ((result * 31) + ((this.isVirtual == null) ? 0 : this.isVirtual.hashCode()));
        result = ((result * 31) + ((this.evidenceCollected == null) ? 0 : this.evidenceCollected.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.relatedDependencies == null) ? 0 : this.relatedDependencies.hashCode()));
        result = ((result * 31) + ((this.md5 == null) ? 0 : this.md5.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Dependency) == false) {
            return false;
        }
        Dependency rhs = ((Dependency) other);
        return (((((((((((((((((this.fileName == rhs.fileName)
            || ((this.fileName != null) && this.fileName.equals(rhs.fileName)))
            && ((this.projectReferences == rhs.projectReferences)
                || ((this.projectReferences != null) && this.projectReferences.equals(rhs.projectReferences))))
            && ((this.sha256 == rhs.sha256) || ((this.sha256 != null) && this.sha256.equals(rhs.sha256))))
            && ((this.vulnerabilityIds == rhs.vulnerabilityIds)
                || ((this.vulnerabilityIds != null) && this.vulnerabilityIds.equals(rhs.vulnerabilityIds))))
            && ((this.filePath == rhs.filePath) || ((this.filePath != null) && this.filePath.equals(rhs.filePath))))
            && ((this.description == rhs.description)
                || ((this.description != null) && this.description.equals(rhs.description))))
            && ((this.packages == rhs.packages) || ((this.packages != null) && this.packages.equals(rhs.packages))))
            && ((this.sha1 == rhs.sha1) || ((this.sha1 != null) && this.sha1.equals(rhs.sha1))))
            && ((this.license == rhs.license) || ((this.license != null) && this.license.equals(rhs.license))))
            && ((this.vulnerabilities == rhs.vulnerabilities)
                || ((this.vulnerabilities != null) && this.vulnerabilities.equals(rhs.vulnerabilities))))
            && ((this.suppressedVulnerabilities == rhs.suppressedVulnerabilities)
                || ((this.suppressedVulnerabilities != null)
                    && this.suppressedVulnerabilities.equals(rhs.suppressedVulnerabilities))))
            && ((this.isVirtual == rhs.isVirtual)
                || ((this.isVirtual != null) && this.isVirtual.equals(rhs.isVirtual))))
            && ((this.evidenceCollected == rhs.evidenceCollected)
                || ((this.evidenceCollected != null) && this.evidenceCollected.equals(rhs.evidenceCollected))))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.relatedDependencies == rhs.relatedDependencies)
                || ((this.relatedDependencies != null) && this.relatedDependencies.equals(rhs.relatedDependencies))))
            && ((this.md5 == rhs.md5) || ((this.md5 != null) && this.md5.equals(rhs.md5))));
    }

}
