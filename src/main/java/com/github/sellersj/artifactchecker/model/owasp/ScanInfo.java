
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
@JsonPropertyOrder({"engineVersion", "dataSource"})
public class ScanInfo {

    @JsonProperty("engineVersion")
    private String engineVersion;

    @JsonProperty("dataSource")
    private List<DataSource> dataSource = null;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("engineVersion")
    public String getEngineVersion() {
        return engineVersion;
    }

    @JsonProperty("engineVersion")
    public void setEngineVersion(String engineVersion) {
        this.engineVersion = engineVersion;
    }

    @JsonProperty("dataSource")
    public List<DataSource> getDataSource() {
        return dataSource;
    }

    @JsonProperty("dataSource")
    public void setDataSource(List<DataSource> dataSource) {
        this.dataSource = dataSource;
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
