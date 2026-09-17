
package com.github.sellersj.artifactchecker.model.inventory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    "cell",
    "deploymentName",
    "logDirFound",
    "nodeName"
})
@Generated("jsonschema2pojo")
public class LoggingConfig {

    @JsonProperty("cell")
    private String cell;
    @JsonProperty("deploymentName")
    private String deploymentName;
    @JsonProperty("logDirFound")
    private List<String> logDirFound = new ArrayList<String>();
    @JsonProperty("nodeName")
    private String nodeName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("cell")
    public String getCell() {
        return cell;
    }

    @JsonProperty("cell")
    public void setCell(String cell) {
        this.cell = cell;
    }

    @JsonProperty("deploymentName")
    public String getDeploymentName() {
        return deploymentName;
    }

    @JsonProperty("deploymentName")
    public void setDeploymentName(String deploymentName) {
        this.deploymentName = deploymentName;
    }

    @JsonProperty("logDirFound")
    public List<String> getLogDirFound() {
        return logDirFound;
    }

    @JsonProperty("logDirFound")
    public void setLogDirFound(List<String> logDirFound) {
        this.logDirFound = logDirFound;
    }

    @JsonProperty("nodeName")
    public String getNodeName() {
        return nodeName;
    }

    @JsonProperty("nodeName")
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
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
        sb.append(LoggingConfig.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cell");
        sb.append('=');
        sb.append(((this.cell == null)?"<null>":this.cell));
        sb.append(',');
        sb.append("deploymentName");
        sb.append('=');
        sb.append(((this.deploymentName == null)?"<null>":this.deploymentName));
        sb.append(',');
        sb.append("logDirFound");
        sb.append('=');
        sb.append(((this.logDirFound == null)?"<null>":this.logDirFound));
        sb.append(',');
        sb.append("nodeName");
        sb.append('=');
        sb.append(((this.nodeName == null)?"<null>":this.nodeName));
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
        result = ((result* 31)+((this.logDirFound == null)? 0 :this.logDirFound.hashCode()));
        result = ((result* 31)+((this.nodeName == null)? 0 :this.nodeName.hashCode()));
        result = ((result* 31)+((this.deploymentName == null)? 0 :this.deploymentName.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.cell == null)? 0 :this.cell.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LoggingConfig) == false) {
            return false;
        }
        LoggingConfig rhs = ((LoggingConfig) other);
        return ((((((this.logDirFound == rhs.logDirFound)||((this.logDirFound!= null)&&this.logDirFound.equals(rhs.logDirFound)))&&((this.nodeName == rhs.nodeName)||((this.nodeName!= null)&&this.nodeName.equals(rhs.nodeName))))&&((this.deploymentName == rhs.deploymentName)||((this.deploymentName!= null)&&this.deploymentName.equals(rhs.deploymentName))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.cell == rhs.cell)||((this.cell!= null)&&this.cell.equals(rhs.cell))));
    }

}
