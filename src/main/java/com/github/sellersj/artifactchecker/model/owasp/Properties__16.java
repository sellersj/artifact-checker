
package com.github.sellersj.artifactchecker.model.owasp;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"fileName", "filePath", "md5", "sha1", "sha256", "description", "license", "projectReferences",
    "relatedDependencies", "analysisExceptions", "evidenceCollected", "identifiers", "vulnerabilities", "isVirtual"})
public class Properties__16 {

    @JsonProperty("fileName")
    private FileName fileName;

    @JsonProperty("filePath")
    private FilePath__1 filePath;

    @JsonProperty("md5")
    private Md5__1 md5;

    @JsonProperty("sha1")
    private Sha1__1 sha1;

    @JsonProperty("sha256")
    private Sha256__1 sha256;

    @JsonProperty("description")
    private Description__2 description;

    @JsonProperty("license")
    private License license;

    @JsonProperty("projectReferences")
    private ProjectReferences projectReferences;

    @JsonProperty("relatedDependencies")
    private RelatedDependencies relatedDependencies;

    @JsonProperty("analysisExceptions")
    private AnalysisExceptions analysisExceptions;

    @JsonProperty("evidenceCollected")
    private EvidenceCollected__1 evidenceCollected;

    @JsonProperty("identifiers")
    private Identifiers__1 identifiers;

    @JsonProperty("vulnerabilities")
    private Vulnerabilities vulnerabilities;

    @JsonProperty("isVirtual")
    private IsVirtual__1 isVirtual;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("fileName")
    public FileName getFileName() {
        return fileName;
    }

    @JsonProperty("fileName")
    public void setFileName(FileName fileName) {
        this.fileName = fileName;
    }

    @JsonProperty("filePath")
    public FilePath__1 getFilePath() {
        return filePath;
    }

    @JsonProperty("filePath")
    public void setFilePath(FilePath__1 filePath) {
        this.filePath = filePath;
    }

    @JsonProperty("md5")
    public Md5__1 getMd5() {
        return md5;
    }

    @JsonProperty("md5")
    public void setMd5(Md5__1 md5) {
        this.md5 = md5;
    }

    @JsonProperty("sha1")
    public Sha1__1 getSha1() {
        return sha1;
    }

    @JsonProperty("sha1")
    public void setSha1(Sha1__1 sha1) {
        this.sha1 = sha1;
    }

    @JsonProperty("sha256")
    public Sha256__1 getSha256() {
        return sha256;
    }

    @JsonProperty("sha256")
    public void setSha256(Sha256__1 sha256) {
        this.sha256 = sha256;
    }

    @JsonProperty("description")
    public Description__2 getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Description__2 description) {
        this.description = description;
    }

    @JsonProperty("license")
    public License getLicense() {
        return license;
    }

    @JsonProperty("license")
    public void setLicense(License license) {
        this.license = license;
    }

    @JsonProperty("projectReferences")
    public ProjectReferences getProjectReferences() {
        return projectReferences;
    }

    @JsonProperty("projectReferences")
    public void setProjectReferences(ProjectReferences projectReferences) {
        this.projectReferences = projectReferences;
    }

    @JsonProperty("relatedDependencies")
    public RelatedDependencies getRelatedDependencies() {
        return relatedDependencies;
    }

    @JsonProperty("relatedDependencies")
    public void setRelatedDependencies(RelatedDependencies relatedDependencies) {
        this.relatedDependencies = relatedDependencies;
    }

    @JsonProperty("analysisExceptions")
    public AnalysisExceptions getAnalysisExceptions() {
        return analysisExceptions;
    }

    @JsonProperty("analysisExceptions")
    public void setAnalysisExceptions(AnalysisExceptions analysisExceptions) {
        this.analysisExceptions = analysisExceptions;
    }

    @JsonProperty("evidenceCollected")
    public EvidenceCollected__1 getEvidenceCollected() {
        return evidenceCollected;
    }

    @JsonProperty("evidenceCollected")
    public void setEvidenceCollected(EvidenceCollected__1 evidenceCollected) {
        this.evidenceCollected = evidenceCollected;
    }

    @JsonProperty("identifiers")
    public Identifiers__1 getIdentifiers() {
        return identifiers;
    }

    @JsonProperty("identifiers")
    public void setIdentifiers(Identifiers__1 identifiers) {
        this.identifiers = identifiers;
    }

    @JsonProperty("vulnerabilities")
    public Vulnerabilities getVulnerabilities() {
        return vulnerabilities;
    }

    @JsonProperty("vulnerabilities")
    public void setVulnerabilities(Vulnerabilities vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

    @JsonProperty("isVirtual")
    public IsVirtual__1 getIsVirtual() {
        return isVirtual;
    }

    @JsonProperty("isVirtual")
    public void setIsVirtual(IsVirtual__1 isVirtual) {
        this.isVirtual = isVirtual;
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
        sb.append(Properties__16.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
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
        sb.append("license");
        sb.append('=');
        sb.append(((this.license == null) ? "<null>" : this.license));
        sb.append(',');
        sb.append("projectReferences");
        sb.append('=');
        sb.append(((this.projectReferences == null) ? "<null>" : this.projectReferences));
        sb.append(',');
        sb.append("relatedDependencies");
        sb.append('=');
        sb.append(((this.relatedDependencies == null) ? "<null>" : this.relatedDependencies));
        sb.append(',');
        sb.append("analysisExceptions");
        sb.append('=');
        sb.append(((this.analysisExceptions == null) ? "<null>" : this.analysisExceptions));
        sb.append(',');
        sb.append("evidenceCollected");
        sb.append('=');
        sb.append(((this.evidenceCollected == null) ? "<null>" : this.evidenceCollected));
        sb.append(',');
        sb.append("identifiers");
        sb.append('=');
        sb.append(((this.identifiers == null) ? "<null>" : this.identifiers));
        sb.append(',');
        sb.append("vulnerabilities");
        sb.append('=');
        sb.append(((this.vulnerabilities == null) ? "<null>" : this.vulnerabilities));
        sb.append(',');
        sb.append("isVirtual");
        sb.append('=');
        sb.append(((this.isVirtual == null) ? "<null>" : this.isVirtual));
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
        result = ((result * 31) + ((this.identifiers == null) ? 0 : this.identifiers.hashCode()));
        result = ((result * 31) + ((this.filePath == null) ? 0 : this.filePath.hashCode()));
        result = ((result * 31) + ((this.description == null) ? 0 : this.description.hashCode()));
        result = ((result * 31) + ((this.sha1 == null) ? 0 : this.sha1.hashCode()));
        result = ((result * 31) + ((this.license == null) ? 0 : this.license.hashCode()));
        result = ((result * 31) + ((this.vulnerabilities == null) ? 0 : this.vulnerabilities.hashCode()));
        result = ((result * 31) + ((this.evidenceCollected == null) ? 0 : this.evidenceCollected.hashCode()));
        result = ((result * 31) + ((this.isVirtual == null) ? 0 : this.isVirtual.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.relatedDependencies == null) ? 0 : this.relatedDependencies.hashCode()));
        result = ((result * 31) + ((this.md5 == null) ? 0 : this.md5.hashCode()));
        result = ((result * 31) + ((this.analysisExceptions == null) ? 0 : this.analysisExceptions.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Properties__16) == false) {
            return false;
        }
        Properties__16 rhs = ((Properties__16) other);
        return ((((((((((((((((this.fileName == rhs.fileName)
            || ((this.fileName != null) && this.fileName.equals(rhs.fileName)))
            && ((this.projectReferences == rhs.projectReferences)
                || ((this.projectReferences != null) && this.projectReferences.equals(rhs.projectReferences))))
            && ((this.sha256 == rhs.sha256) || ((this.sha256 != null) && this.sha256.equals(rhs.sha256))))
            && ((this.identifiers == rhs.identifiers)
                || ((this.identifiers != null) && this.identifiers.equals(rhs.identifiers))))
            && ((this.filePath == rhs.filePath) || ((this.filePath != null) && this.filePath.equals(rhs.filePath))))
            && ((this.description == rhs.description)
                || ((this.description != null) && this.description.equals(rhs.description))))
            && ((this.sha1 == rhs.sha1) || ((this.sha1 != null) && this.sha1.equals(rhs.sha1))))
            && ((this.license == rhs.license) || ((this.license != null) && this.license.equals(rhs.license))))
            && ((this.vulnerabilities == rhs.vulnerabilities)
                || ((this.vulnerabilities != null) && this.vulnerabilities.equals(rhs.vulnerabilities))))
            && ((this.evidenceCollected == rhs.evidenceCollected)
                || ((this.evidenceCollected != null) && this.evidenceCollected.equals(rhs.evidenceCollected))))
            && ((this.isVirtual == rhs.isVirtual)
                || ((this.isVirtual != null) && this.isVirtual.equals(rhs.isVirtual))))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.relatedDependencies == rhs.relatedDependencies)
                || ((this.relatedDependencies != null) && this.relatedDependencies.equals(rhs.relatedDependencies))))
            && ((this.md5 == rhs.md5) || ((this.md5 != null) && this.md5.equals(rhs.md5))))
            && ((this.analysisExceptions == rhs.analysisExceptions)
                || ((this.analysisExceptions != null) && this.analysisExceptions.equals(rhs.analysisExceptions))));
    }

}
