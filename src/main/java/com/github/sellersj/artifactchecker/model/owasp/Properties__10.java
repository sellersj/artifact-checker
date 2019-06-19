
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
@JsonPropertyOrder({"scanInfo", "projectInfo", "dependencies"})
public class Properties__10 {

    @JsonProperty("scanInfo")
    private ScanInfo__1 scanInfo;

    @JsonProperty("projectInfo")
    private ProjectInfo__1 projectInfo;

    @JsonProperty("dependencies")
    private Dependencies dependencies;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("scanInfo")
    public ScanInfo__1 getScanInfo() {
        return scanInfo;
    }

    @JsonProperty("scanInfo")
    public void setScanInfo(ScanInfo__1 scanInfo) {
        this.scanInfo = scanInfo;
    }

    @JsonProperty("projectInfo")
    public ProjectInfo__1 getProjectInfo() {
        return projectInfo;
    }

    @JsonProperty("projectInfo")
    public void setProjectInfo(ProjectInfo__1 projectInfo) {
        this.projectInfo = projectInfo;
    }

    @JsonProperty("dependencies")
    public Dependencies getDependencies() {
        return dependencies;
    }

    @JsonProperty("dependencies")
    public void setDependencies(Dependencies dependencies) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Properties__10.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("scanInfo");
        sb.append('=');
        sb.append(((this.scanInfo == null) ? "<null>" : this.scanInfo));
        sb.append(',');
        sb.append("projectInfo");
        sb.append('=');
        sb.append(((this.projectInfo == null) ? "<null>" : this.projectInfo));
        sb.append(',');
        sb.append("dependencies");
        sb.append('=');
        sb.append(((this.dependencies == null) ? "<null>" : this.dependencies));
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
        result = ((result * 31) + ((this.projectInfo == null) ? 0 : this.projectInfo.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.scanInfo == null) ? 0 : this.scanInfo.hashCode()));
        result = ((result * 31) + ((this.dependencies == null) ? 0 : this.dependencies.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Properties__10) == false) {
            return false;
        }
        Properties__10 rhs = ((Properties__10) other);
        return (((((this.projectInfo == rhs.projectInfo)
            || ((this.projectInfo != null) && this.projectInfo.equals(rhs.projectInfo)))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.scanInfo == rhs.scanInfo) || ((this.scanInfo != null) && this.scanInfo.equals(rhs.scanInfo))))
            && ((this.dependencies == rhs.dependencies)
                || ((this.dependencies != null) && this.dependencies.equals(rhs.dependencies))));
    }

}
