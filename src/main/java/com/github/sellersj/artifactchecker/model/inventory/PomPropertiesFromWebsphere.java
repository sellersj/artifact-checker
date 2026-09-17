
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
    "artifactId",
    "groupId",
    "version"
})
@Generated("jsonschema2pojo")
public class PomPropertiesFromWebsphere {

    @JsonProperty("artifactId")
    private String artifactId;
    @JsonProperty("groupId")
    private String groupId;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("artifactId")
    public String getArtifactId() {
        return artifactId;
    }

    @JsonProperty("artifactId")
    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    @JsonProperty("groupId")
    public String getGroupId() {
        return groupId;
    }

    @JsonProperty("groupId")
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
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
        sb.append(PomPropertiesFromWebsphere.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("artifactId");
        sb.append('=');
        sb.append(((this.artifactId == null)?"<null>":this.artifactId));
        sb.append(',');
        sb.append("groupId");
        sb.append('=');
        sb.append(((this.groupId == null)?"<null>":this.groupId));
        sb.append(',');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null)?"<null>":this.version));
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
        result = ((result* 31)+((this.artifactId == null)? 0 :this.artifactId.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        result = ((result* 31)+((this.groupId == null)? 0 :this.groupId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PomPropertiesFromWebsphere) == false) {
            return false;
        }
        PomPropertiesFromWebsphere rhs = ((PomPropertiesFromWebsphere) other);
        return (((((this.artifactId == rhs.artifactId)||((this.artifactId!= null)&&this.artifactId.equals(rhs.artifactId)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))))&&((this.groupId == rhs.groupId)||((this.groupId!= null)&&this.groupId.equals(rhs.groupId))));
    }

}
