
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
@JsonPropertyOrder({"name", "groupID", "artifactID", "version", "reportDate", "credits"})
public class ProjectInfo {

    @JsonProperty("name")
    private String name;

    @JsonProperty("groupID")
    private String groupID;

    @JsonProperty("artifactID")
    private String artifactID;

    @JsonProperty("version")
    private String version;

    @JsonProperty("reportDate")
    private String reportDate;

    @JsonProperty("credits")
    private Credits credits;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("groupID")
    public String getGroupID() {
        return groupID;
    }

    @JsonProperty("groupID")
    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    @JsonProperty("artifactID")
    public String getArtifactID() {
        return artifactID;
    }

    @JsonProperty("artifactID")
    public void setArtifactID(String artifactID) {
        this.artifactID = artifactID;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("reportDate")
    public String getReportDate() {
        return reportDate;
    }

    @JsonProperty("reportDate")
    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    @JsonProperty("credits")
    public Credits getCredits() {
        return credits;
    }

    @JsonProperty("credits")
    public void setCredits(Credits credits) {
        this.credits = credits;
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
