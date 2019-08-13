
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
@JsonPropertyOrder({"Vulnerability", "Reference", "Vulnerability.VulnerableSoftware", "CvssV3", "ScanInfo.DataSource",
    "Analysis.Dependencies", "Evidence", "Dependency.Identifiers", "Identifier", "Exception", "Analysis",
    "RelatedDependency", "Software", "ProjectInfo", "Exception.StackTrace", "Exception.InnerException.StackTrace",
    "Dependency", "ScanInfo", "Exception.InnerException", "RelatedDependency.Identifiers",
    "Dependency.AnalysisExceptions", "Dependency.Vulnerabilities", "Vulnerability.References",
    "Dependency.ProjectReferences", "CvssV2", "Dependency.EvidenceCollected", "Dependency.RelatedDependencies",
    "Vulnerability.Cwes"})
public class Definitions {

    @JsonProperty("Vulnerability")
    private Vulnerability__1 vulnerability;

    @JsonProperty("Reference")
    private Reference__2 reference;

    @JsonProperty("Vulnerability.VulnerableSoftware")
    private VulnerabilityVulnerableSoftware vulnerabilityVulnerableSoftware;

    @JsonProperty("CvssV3")
    private CvssV3__3 cvssV3;

    @JsonProperty("ScanInfo.DataSource")
    private ScanInfoDataSource scanInfoDataSource;

    @JsonProperty("Analysis.Dependencies")
    private AnalysisDependencies analysisDependencies;

    @JsonProperty("Evidence")
    private Evidence evidence;

    @JsonProperty("Dependency.Identifiers")
    private DependencyIdentifiers dependencyIdentifiers;

    @JsonProperty("Identifier")
    private Identifier identifier;

    @JsonProperty("Exception")
    private Exception exception;

    @JsonProperty("Analysis")
    private Analysis analysis;

    @JsonProperty("RelatedDependency")
    private RelatedDependency__1 relatedDependency;

    @JsonProperty("Software")
    private Software__3 software;

    @JsonProperty("ProjectInfo")
    private ProjectInfo__2 projectInfo;

    @JsonProperty("Exception.StackTrace")
    private ExceptionStackTrace exceptionStackTrace;

    @JsonProperty("Exception.InnerException.StackTrace")
    private ExceptionInnerExceptionStackTrace exceptionInnerExceptionStackTrace;

    @JsonProperty("Dependency")
    private Dependency__2 dependency;

    @JsonProperty("ScanInfo")
    private ScanInfo__2 scanInfo;

    @JsonProperty("Exception.InnerException")
    private ExceptionInnerException exceptionInnerException;

    @JsonProperty("RelatedDependency.Identifiers")
    private RelatedDependencyIdentifiers relatedDependencyIdentifiers;

    @JsonProperty("Dependency.AnalysisExceptions")
    private DependencyAnalysisExceptions dependencyAnalysisExceptions;

    @JsonProperty("Dependency.Vulnerabilities")
    private DependencyVulnerabilities dependencyVulnerabilities;

    @JsonProperty("Vulnerability.References")
    private VulnerabilityReferences vulnerabilityReferences;

    @JsonProperty("Dependency.ProjectReferences")
    private DependencyProjectReferences dependencyProjectReferences;

    @JsonProperty("CvssV2")
    private CvssV2__3 cvssV2;

    @JsonProperty("Dependency.EvidenceCollected")
    private DependencyEvidenceCollected dependencyEvidenceCollected;

    @JsonProperty("Dependency.RelatedDependencies")
    private DependencyRelatedDependencies dependencyRelatedDependencies;

    @JsonProperty("Vulnerability.Cwes")
    private VulnerabilityCwes vulnerabilityCwes;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Vulnerability")
    public Vulnerability__1 getVulnerability() {
        return vulnerability;
    }

    @JsonProperty("Vulnerability")
    public void setVulnerability(Vulnerability__1 vulnerability) {
        this.vulnerability = vulnerability;
    }

    @JsonProperty("Reference")
    public Reference__2 getReference() {
        return reference;
    }

    @JsonProperty("Reference")
    public void setReference(Reference__2 reference) {
        this.reference = reference;
    }

    @JsonProperty("Vulnerability.VulnerableSoftware")
    public VulnerabilityVulnerableSoftware getVulnerabilityVulnerableSoftware() {
        return vulnerabilityVulnerableSoftware;
    }

    @JsonProperty("Vulnerability.VulnerableSoftware")
    public void setVulnerabilityVulnerableSoftware(VulnerabilityVulnerableSoftware vulnerabilityVulnerableSoftware) {
        this.vulnerabilityVulnerableSoftware = vulnerabilityVulnerableSoftware;
    }

    @JsonProperty("CvssV3")
    public CvssV3__3 getCvssV3() {
        return cvssV3;
    }

    @JsonProperty("CvssV3")
    public void setCvssV3(CvssV3__3 cvssV3) {
        this.cvssV3 = cvssV3;
    }

    @JsonProperty("ScanInfo.DataSource")
    public ScanInfoDataSource getScanInfoDataSource() {
        return scanInfoDataSource;
    }

    @JsonProperty("ScanInfo.DataSource")
    public void setScanInfoDataSource(ScanInfoDataSource scanInfoDataSource) {
        this.scanInfoDataSource = scanInfoDataSource;
    }

    @JsonProperty("Analysis.Dependencies")
    public AnalysisDependencies getAnalysisDependencies() {
        return analysisDependencies;
    }

    @JsonProperty("Analysis.Dependencies")
    public void setAnalysisDependencies(AnalysisDependencies analysisDependencies) {
        this.analysisDependencies = analysisDependencies;
    }

    @JsonProperty("Evidence")
    public Evidence getEvidence() {
        return evidence;
    }

    @JsonProperty("Evidence")
    public void setEvidence(Evidence evidence) {
        this.evidence = evidence;
    }

    @JsonProperty("Dependency.Identifiers")
    public DependencyIdentifiers getDependencyIdentifiers() {
        return dependencyIdentifiers;
    }

    @JsonProperty("Dependency.Identifiers")
    public void setDependencyIdentifiers(DependencyIdentifiers dependencyIdentifiers) {
        this.dependencyIdentifiers = dependencyIdentifiers;
    }

    @JsonProperty("Identifier")
    public Identifier getIdentifier() {
        return identifier;
    }

    @JsonProperty("Identifier")
    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    @JsonProperty("Exception")
    public Exception getException() {
        return exception;
    }

    @JsonProperty("Exception")
    public void setException(Exception exception) {
        this.exception = exception;
    }

    @JsonProperty("Analysis")
    public Analysis getAnalysis() {
        return analysis;
    }

    @JsonProperty("Analysis")
    public void setAnalysis(Analysis analysis) {
        this.analysis = analysis;
    }

    @JsonProperty("RelatedDependency")
    public RelatedDependency__1 getRelatedDependency() {
        return relatedDependency;
    }

    @JsonProperty("RelatedDependency")
    public void setRelatedDependency(RelatedDependency__1 relatedDependency) {
        this.relatedDependency = relatedDependency;
    }

    @JsonProperty("Software")
    public Software__3 getSoftware() {
        return software;
    }

    @JsonProperty("Software")
    public void setSoftware(Software__3 software) {
        this.software = software;
    }

    @JsonProperty("ProjectInfo")
    public ProjectInfo__2 getProjectInfo() {
        return projectInfo;
    }

    @JsonProperty("ProjectInfo")
    public void setProjectInfo(ProjectInfo__2 projectInfo) {
        this.projectInfo = projectInfo;
    }

    @JsonProperty("Exception.StackTrace")
    public ExceptionStackTrace getExceptionStackTrace() {
        return exceptionStackTrace;
    }

    @JsonProperty("Exception.StackTrace")
    public void setExceptionStackTrace(ExceptionStackTrace exceptionStackTrace) {
        this.exceptionStackTrace = exceptionStackTrace;
    }

    @JsonProperty("Exception.InnerException.StackTrace")
    public ExceptionInnerExceptionStackTrace getExceptionInnerExceptionStackTrace() {
        return exceptionInnerExceptionStackTrace;
    }

    @JsonProperty("Exception.InnerException.StackTrace")
    public void setExceptionInnerExceptionStackTrace(ExceptionInnerExceptionStackTrace exceptionInnerExceptionStackTrace) {
        this.exceptionInnerExceptionStackTrace = exceptionInnerExceptionStackTrace;
    }

    @JsonProperty("Dependency")
    public Dependency__2 getDependency() {
        return dependency;
    }

    @JsonProperty("Dependency")
    public void setDependency(Dependency__2 dependency) {
        this.dependency = dependency;
    }

    @JsonProperty("ScanInfo")
    public ScanInfo__2 getScanInfo() {
        return scanInfo;
    }

    @JsonProperty("ScanInfo")
    public void setScanInfo(ScanInfo__2 scanInfo) {
        this.scanInfo = scanInfo;
    }

    @JsonProperty("Exception.InnerException")
    public ExceptionInnerException getExceptionInnerException() {
        return exceptionInnerException;
    }

    @JsonProperty("Exception.InnerException")
    public void setExceptionInnerException(ExceptionInnerException exceptionInnerException) {
        this.exceptionInnerException = exceptionInnerException;
    }

    @JsonProperty("RelatedDependency.Identifiers")
    public RelatedDependencyIdentifiers getRelatedDependencyIdentifiers() {
        return relatedDependencyIdentifiers;
    }

    @JsonProperty("RelatedDependency.Identifiers")
    public void setRelatedDependencyIdentifiers(RelatedDependencyIdentifiers relatedDependencyIdentifiers) {
        this.relatedDependencyIdentifiers = relatedDependencyIdentifiers;
    }

    @JsonProperty("Dependency.AnalysisExceptions")
    public DependencyAnalysisExceptions getDependencyAnalysisExceptions() {
        return dependencyAnalysisExceptions;
    }

    @JsonProperty("Dependency.AnalysisExceptions")
    public void setDependencyAnalysisExceptions(DependencyAnalysisExceptions dependencyAnalysisExceptions) {
        this.dependencyAnalysisExceptions = dependencyAnalysisExceptions;
    }

    @JsonProperty("Dependency.Vulnerabilities")
    public DependencyVulnerabilities getDependencyVulnerabilities() {
        return dependencyVulnerabilities;
    }

    @JsonProperty("Dependency.Vulnerabilities")
    public void setDependencyVulnerabilities(DependencyVulnerabilities dependencyVulnerabilities) {
        this.dependencyVulnerabilities = dependencyVulnerabilities;
    }

    @JsonProperty("Vulnerability.References")
    public VulnerabilityReferences getVulnerabilityReferences() {
        return vulnerabilityReferences;
    }

    @JsonProperty("Vulnerability.References")
    public void setVulnerabilityReferences(VulnerabilityReferences vulnerabilityReferences) {
        this.vulnerabilityReferences = vulnerabilityReferences;
    }

    @JsonProperty("Dependency.ProjectReferences")
    public DependencyProjectReferences getDependencyProjectReferences() {
        return dependencyProjectReferences;
    }

    @JsonProperty("Dependency.ProjectReferences")
    public void setDependencyProjectReferences(DependencyProjectReferences dependencyProjectReferences) {
        this.dependencyProjectReferences = dependencyProjectReferences;
    }

    @JsonProperty("CvssV2")
    public CvssV2__3 getCvssV2() {
        return cvssV2;
    }

    @JsonProperty("CvssV2")
    public void setCvssV2(CvssV2__3 cvssV2) {
        this.cvssV2 = cvssV2;
    }

    @JsonProperty("Dependency.EvidenceCollected")
    public DependencyEvidenceCollected getDependencyEvidenceCollected() {
        return dependencyEvidenceCollected;
    }

    @JsonProperty("Dependency.EvidenceCollected")
    public void setDependencyEvidenceCollected(DependencyEvidenceCollected dependencyEvidenceCollected) {
        this.dependencyEvidenceCollected = dependencyEvidenceCollected;
    }

    @JsonProperty("Dependency.RelatedDependencies")
    public DependencyRelatedDependencies getDependencyRelatedDependencies() {
        return dependencyRelatedDependencies;
    }

    @JsonProperty("Dependency.RelatedDependencies")
    public void setDependencyRelatedDependencies(DependencyRelatedDependencies dependencyRelatedDependencies) {
        this.dependencyRelatedDependencies = dependencyRelatedDependencies;
    }

    @JsonProperty("Vulnerability.Cwes")
    public VulnerabilityCwes getVulnerabilityCwes() {
        return vulnerabilityCwes;
    }

    @JsonProperty("Vulnerability.Cwes")
    public void setVulnerabilityCwes(VulnerabilityCwes vulnerabilityCwes) {
        this.vulnerabilityCwes = vulnerabilityCwes;
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
        sb.append(Definitions.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("vulnerability");
        sb.append('=');
        sb.append(((this.vulnerability == null) ? "<null>" : this.vulnerability));
        sb.append(',');
        sb.append("reference");
        sb.append('=');
        sb.append(((this.reference == null) ? "<null>" : this.reference));
        sb.append(',');
        sb.append("vulnerabilityVulnerableSoftware");
        sb.append('=');
        sb.append(((this.vulnerabilityVulnerableSoftware == null) ? "<null>" : this.vulnerabilityVulnerableSoftware));
        sb.append(',');
        sb.append("cvssV3");
        sb.append('=');
        sb.append(((this.cvssV3 == null) ? "<null>" : this.cvssV3));
        sb.append(',');
        sb.append("scanInfoDataSource");
        sb.append('=');
        sb.append(((this.scanInfoDataSource == null) ? "<null>" : this.scanInfoDataSource));
        sb.append(',');
        sb.append("analysisDependencies");
        sb.append('=');
        sb.append(((this.analysisDependencies == null) ? "<null>" : this.analysisDependencies));
        sb.append(',');
        sb.append("evidence");
        sb.append('=');
        sb.append(((this.evidence == null) ? "<null>" : this.evidence));
        sb.append(',');
        sb.append("dependencyIdentifiers");
        sb.append('=');
        sb.append(((this.dependencyIdentifiers == null) ? "<null>" : this.dependencyIdentifiers));
        sb.append(',');
        sb.append("identifier");
        sb.append('=');
        sb.append(((this.identifier == null) ? "<null>" : this.identifier));
        sb.append(',');
        sb.append("exception");
        sb.append('=');
        sb.append(((this.exception == null) ? "<null>" : this.exception));
        sb.append(',');
        sb.append("analysis");
        sb.append('=');
        sb.append(((this.analysis == null) ? "<null>" : this.analysis));
        sb.append(',');
        sb.append("relatedDependency");
        sb.append('=');
        sb.append(((this.relatedDependency == null) ? "<null>" : this.relatedDependency));
        sb.append(',');
        sb.append("software");
        sb.append('=');
        sb.append(((this.software == null) ? "<null>" : this.software));
        sb.append(',');
        sb.append("projectInfo");
        sb.append('=');
        sb.append(((this.projectInfo == null) ? "<null>" : this.projectInfo));
        sb.append(',');
        sb.append("exceptionStackTrace");
        sb.append('=');
        sb.append(((this.exceptionStackTrace == null) ? "<null>" : this.exceptionStackTrace));
        sb.append(',');
        sb.append("exceptionInnerExceptionStackTrace");
        sb.append('=');
        sb.append(
            ((this.exceptionInnerExceptionStackTrace == null) ? "<null>" : this.exceptionInnerExceptionStackTrace));
        sb.append(',');
        sb.append("dependency");
        sb.append('=');
        sb.append(((this.dependency == null) ? "<null>" : this.dependency));
        sb.append(',');
        sb.append("scanInfo");
        sb.append('=');
        sb.append(((this.scanInfo == null) ? "<null>" : this.scanInfo));
        sb.append(',');
        sb.append("exceptionInnerException");
        sb.append('=');
        sb.append(((this.exceptionInnerException == null) ? "<null>" : this.exceptionInnerException));
        sb.append(',');
        sb.append("relatedDependencyIdentifiers");
        sb.append('=');
        sb.append(((this.relatedDependencyIdentifiers == null) ? "<null>" : this.relatedDependencyIdentifiers));
        sb.append(',');
        sb.append("dependencyAnalysisExceptions");
        sb.append('=');
        sb.append(((this.dependencyAnalysisExceptions == null) ? "<null>" : this.dependencyAnalysisExceptions));
        sb.append(',');
        sb.append("dependencyVulnerabilities");
        sb.append('=');
        sb.append(((this.dependencyVulnerabilities == null) ? "<null>" : this.dependencyVulnerabilities));
        sb.append(',');
        sb.append("vulnerabilityReferences");
        sb.append('=');
        sb.append(((this.vulnerabilityReferences == null) ? "<null>" : this.vulnerabilityReferences));
        sb.append(',');
        sb.append("dependencyProjectReferences");
        sb.append('=');
        sb.append(((this.dependencyProjectReferences == null) ? "<null>" : this.dependencyProjectReferences));
        sb.append(',');
        sb.append("cvssV2");
        sb.append('=');
        sb.append(((this.cvssV2 == null) ? "<null>" : this.cvssV2));
        sb.append(',');
        sb.append("dependencyEvidenceCollected");
        sb.append('=');
        sb.append(((this.dependencyEvidenceCollected == null) ? "<null>" : this.dependencyEvidenceCollected));
        sb.append(',');
        sb.append("dependencyRelatedDependencies");
        sb.append('=');
        sb.append(((this.dependencyRelatedDependencies == null) ? "<null>" : this.dependencyRelatedDependencies));
        sb.append(',');
        sb.append("vulnerabilityCwes");
        sb.append('=');
        sb.append(((this.vulnerabilityCwes == null) ? "<null>" : this.vulnerabilityCwes));
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
        result = ((result * 31) + ((this.exception == null) ? 0 : this.exception.hashCode()));
        result = ((result * 31)
            + ((this.dependencyRelatedDependencies == null) ? 0 : this.dependencyRelatedDependencies.hashCode()));
        result = ((result * 31) + ((this.relatedDependency == null) ? 0 : this.relatedDependency.hashCode()));
        result = ((result * 31) + ((this.analysisDependencies == null) ? 0 : this.analysisDependencies.hashCode()));
        result = ((result * 31) + ((this.evidence == null) ? 0 : this.evidence.hashCode()));
        result = ((result * 31) + ((this.software == null) ? 0 : this.software.hashCode()));
        result = ((result * 31) + ((this.cvssV2 == null) ? 0 : this.cvssV2.hashCode()));
        result = ((result * 31)
            + ((this.vulnerabilityVulnerableSoftware == null) ? 0 : this.vulnerabilityVulnerableSoftware.hashCode()));
        result = ((result * 31) + ((this.reference == null) ? 0 : this.reference.hashCode()));
        result = ((result * 31) + ((this.exceptionInnerExceptionStackTrace == null) ? 0
            : this.exceptionInnerExceptionStackTrace.hashCode()));
        result = ((result * 31) + ((this.projectInfo == null) ? 0 : this.projectInfo.hashCode()));
        result = ((result * 31) + ((this.cvssV3 == null) ? 0 : this.cvssV3.hashCode()));
        result = ((result * 31)
            + ((this.vulnerabilityReferences == null) ? 0 : this.vulnerabilityReferences.hashCode()));
        result = ((result * 31)
            + ((this.dependencyEvidenceCollected == null) ? 0 : this.dependencyEvidenceCollected.hashCode()));
        result = ((result * 31) + ((this.vulnerabilityCwes == null) ? 0 : this.vulnerabilityCwes.hashCode()));
        result = ((result * 31) + ((this.identifier == null) ? 0 : this.identifier.hashCode()));
        result = ((result * 31)
            + ((this.exceptionInnerException == null) ? 0 : this.exceptionInnerException.hashCode()));
        result = ((result * 31)
            + ((this.dependencyProjectReferences == null) ? 0 : this.dependencyProjectReferences.hashCode()));
        result = ((result * 31) + ((this.dependency == null) ? 0 : this.dependency.hashCode()));
        result = ((result * 31)
            + ((this.relatedDependencyIdentifiers == null) ? 0 : this.relatedDependencyIdentifiers.hashCode()));
        result = ((result * 31)
            + ((this.dependencyAnalysisExceptions == null) ? 0 : this.dependencyAnalysisExceptions.hashCode()));
        result = ((result * 31) + ((this.vulnerability == null) ? 0 : this.vulnerability.hashCode()));
        result = ((result * 31) + ((this.analysis == null) ? 0 : this.analysis.hashCode()));
        result = ((result * 31) + ((this.scanInfo == null) ? 0 : this.scanInfo.hashCode()));
        result = ((result * 31)
            + ((this.dependencyVulnerabilities == null) ? 0 : this.dependencyVulnerabilities.hashCode()));
        result = ((result * 31) + ((this.exceptionStackTrace == null) ? 0 : this.exceptionStackTrace.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.scanInfoDataSource == null) ? 0 : this.scanInfoDataSource.hashCode()));
        result = ((result * 31) + ((this.dependencyIdentifiers == null) ? 0 : this.dependencyIdentifiers.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Definitions) == false) {
            return false;
        }
        Definitions rhs = ((Definitions) other);
        return ((((((((((((((((((((((((((((((this.exception == rhs.exception)
            || ((this.exception != null) && this.exception.equals(rhs.exception)))
            && ((this.dependencyRelatedDependencies == rhs.dependencyRelatedDependencies)
                || ((this.dependencyRelatedDependencies != null)
                    && this.dependencyRelatedDependencies.equals(rhs.dependencyRelatedDependencies))))
            && ((this.relatedDependency == rhs.relatedDependency)
                || ((this.relatedDependency != null) && this.relatedDependency.equals(rhs.relatedDependency))))
            && ((this.analysisDependencies == rhs.analysisDependencies)
                || ((this.analysisDependencies != null) && this.analysisDependencies.equals(rhs.analysisDependencies))))
            && ((this.evidence == rhs.evidence) || ((this.evidence != null) && this.evidence.equals(rhs.evidence))))
            && ((this.software == rhs.software) || ((this.software != null) && this.software.equals(rhs.software))))
            && ((this.cvssV2 == rhs.cvssV2) || ((this.cvssV2 != null) && this.cvssV2.equals(rhs.cvssV2))))
            && ((this.vulnerabilityVulnerableSoftware == rhs.vulnerabilityVulnerableSoftware)
                || ((this.vulnerabilityVulnerableSoftware != null)
                    && this.vulnerabilityVulnerableSoftware.equals(rhs.vulnerabilityVulnerableSoftware))))
            && ((this.reference == rhs.reference)
                || ((this.reference != null) && this.reference.equals(rhs.reference))))
            && ((this.exceptionInnerExceptionStackTrace == rhs.exceptionInnerExceptionStackTrace)
                || ((this.exceptionInnerExceptionStackTrace != null)
                    && this.exceptionInnerExceptionStackTrace.equals(rhs.exceptionInnerExceptionStackTrace))))
            && ((this.projectInfo == rhs.projectInfo)
                || ((this.projectInfo != null) && this.projectInfo.equals(rhs.projectInfo))))
            && ((this.cvssV3 == rhs.cvssV3) || ((this.cvssV3 != null) && this.cvssV3.equals(rhs.cvssV3))))
            && ((this.vulnerabilityReferences == rhs.vulnerabilityReferences) || ((this.vulnerabilityReferences != null)
                && this.vulnerabilityReferences.equals(rhs.vulnerabilityReferences))))
            && ((this.dependencyEvidenceCollected == rhs.dependencyEvidenceCollected)
                || ((this.dependencyEvidenceCollected != null)
                    && this.dependencyEvidenceCollected.equals(rhs.dependencyEvidenceCollected))))
            && ((this.vulnerabilityCwes == rhs.vulnerabilityCwes)
                || ((this.vulnerabilityCwes != null) && this.vulnerabilityCwes.equals(rhs.vulnerabilityCwes))))
            && ((this.identifier == rhs.identifier)
                || ((this.identifier != null) && this.identifier.equals(rhs.identifier))))
            && ((this.exceptionInnerException == rhs.exceptionInnerException) || ((this.exceptionInnerException != null)
                && this.exceptionInnerException.equals(rhs.exceptionInnerException))))
            && ((this.dependencyProjectReferences == rhs.dependencyProjectReferences)
                || ((this.dependencyProjectReferences != null)
                    && this.dependencyProjectReferences.equals(rhs.dependencyProjectReferences))))
            && ((this.dependency == rhs.dependency)
                || ((this.dependency != null) && this.dependency.equals(rhs.dependency))))
            && ((this.relatedDependencyIdentifiers == rhs.relatedDependencyIdentifiers)
                || ((this.relatedDependencyIdentifiers != null)
                    && this.relatedDependencyIdentifiers.equals(rhs.relatedDependencyIdentifiers))))
            && ((this.dependencyAnalysisExceptions == rhs.dependencyAnalysisExceptions)
                || ((this.dependencyAnalysisExceptions != null)
                    && this.dependencyAnalysisExceptions.equals(rhs.dependencyAnalysisExceptions))))
            && ((this.vulnerability == rhs.vulnerability)
                || ((this.vulnerability != null) && this.vulnerability.equals(rhs.vulnerability))))
            && ((this.analysis == rhs.analysis) || ((this.analysis != null) && this.analysis.equals(rhs.analysis))))
            && ((this.scanInfo == rhs.scanInfo) || ((this.scanInfo != null) && this.scanInfo.equals(rhs.scanInfo))))
            && ((this.dependencyVulnerabilities == rhs.dependencyVulnerabilities)
                || ((this.dependencyVulnerabilities != null)
                    && this.dependencyVulnerabilities.equals(rhs.dependencyVulnerabilities))))
            && ((this.exceptionStackTrace == rhs.exceptionStackTrace)
                || ((this.exceptionStackTrace != null) && this.exceptionStackTrace.equals(rhs.exceptionStackTrace))))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.scanInfoDataSource == rhs.scanInfoDataSource)
                || ((this.scanInfoDataSource != null) && this.scanInfoDataSource.equals(rhs.scanInfoDataSource))))
            && ((this.dependencyIdentifiers == rhs.dependencyIdentifiers) || ((this.dependencyIdentifiers != null)
                && this.dependencyIdentifiers.equals(rhs.dependencyIdentifiers))));
    }

}
