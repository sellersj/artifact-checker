
package com.github.sellersj.artifactchecker.model.owasp;

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
@JsonPropertyOrder({ "reportSchema", "scanInfo", "projectInfo", "dependencies" })
public class DependencyCheck {

    @JsonProperty("reportSchema")
    private String reportSchema;

    @JsonProperty("scanInfo")
    private ScanInfo scanInfo;

    @JsonProperty("projectInfo")
    private ProjectInfo projectInfo;

    @JsonProperty("dependencies")
    private List<Dependency> dependencies = null;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("reportSchema")
    public String getReportSchema() {
        return reportSchema;
    }

    @JsonProperty("reportSchema")
    public void setReportSchema(String reportSchema) {
        this.reportSchema = reportSchema;
    }

    @JsonProperty("scanInfo")
    public ScanInfo getScanInfo() {
        return scanInfo;
    }

    @JsonProperty("scanInfo")
    public void setScanInfo(ScanInfo scanInfo) {
        this.scanInfo = scanInfo;
    }

    @JsonProperty("projectInfo")
    public ProjectInfo getProjectInfo() {
        return projectInfo;
    }

    @JsonProperty("projectInfo")
    public void setProjectInfo(ProjectInfo projectInfo) {
        this.projectInfo = projectInfo;
    }

    @JsonProperty("dependencies")
    public List<Dependency> getDependencies() {
        return dependencies;
    }

    @JsonProperty("dependencies")
    public void setDependencies(List<Dependency> dependencies) {
        this.dependencies = dependencies;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
