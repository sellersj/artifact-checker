
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
@JsonPropertyOrder({"engineVersion", "dataSource"})
public class ScanInfo {

    @JsonProperty("engineVersion")
    private String engineVersion;

    @JsonProperty("dataSource")
    private List<DataSource> dataSource = new ArrayList<DataSource>();

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ScanInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("engineVersion");
        sb.append('=');
        sb.append(((this.engineVersion == null) ? "<null>" : this.engineVersion));
        sb.append(',');
        sb.append("dataSource");
        sb.append('=');
        sb.append(((this.dataSource == null) ? "<null>" : this.dataSource));
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
        result = ((result * 31) + ((this.engineVersion == null) ? 0 : this.engineVersion.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.dataSource == null) ? 0 : this.dataSource.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ScanInfo) == false) {
            return false;
        }
        ScanInfo rhs = ((ScanInfo) other);
        return ((((this.engineVersion == rhs.engineVersion)
            || ((this.engineVersion != null) && this.engineVersion.equals(rhs.engineVersion)))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.dataSource == rhs.dataSource)
                || ((this.dataSource != null) && this.dataSource.equals(rhs.dataSource))));
    }

}
