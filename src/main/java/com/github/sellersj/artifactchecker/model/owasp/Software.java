
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
@JsonPropertyOrder({"id", "vulnerabilityIdMatched", "versionEndExcluding", "versionStartIncluding",
    "versionEndIncluding", "versionStartExcluding"})
public class Software {

    @JsonProperty("id")
    private String id;

    @JsonProperty("vulnerabilityIdMatched")
    private String vulnerabilityIdMatched;

    @JsonProperty("versionEndExcluding")
    private String versionEndExcluding;

    @JsonProperty("versionStartIncluding")
    private String versionStartIncluding;

    @JsonProperty("versionEndIncluding")
    private String versionEndIncluding;

    @JsonProperty("versionStartExcluding")
    private String versionStartExcluding;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("vulnerabilityIdMatched")
    public String getVulnerabilityIdMatched() {
        return vulnerabilityIdMatched;
    }

    @JsonProperty("vulnerabilityIdMatched")
    public void setVulnerabilityIdMatched(String vulnerabilityIdMatched) {
        this.vulnerabilityIdMatched = vulnerabilityIdMatched;
    }

    @JsonProperty("versionEndExcluding")
    public String getVersionEndExcluding() {
        return versionEndExcluding;
    }

    @JsonProperty("versionEndExcluding")
    public void setVersionEndExcluding(String versionEndExcluding) {
        this.versionEndExcluding = versionEndExcluding;
    }

    @JsonProperty("versionStartIncluding")
    public String getVersionStartIncluding() {
        return versionStartIncluding;
    }

    @JsonProperty("versionStartIncluding")
    public void setVersionStartIncluding(String versionStartIncluding) {
        this.versionStartIncluding = versionStartIncluding;
    }

    @JsonProperty("versionEndIncluding")
    public String getVersionEndIncluding() {
        return versionEndIncluding;
    }

    @JsonProperty("versionEndIncluding")
    public void setVersionEndIncluding(String versionEndIncluding) {
        this.versionEndIncluding = versionEndIncluding;
    }

    @JsonProperty("versionStartExcluding")
    public String getVersionStartExcluding() {
        return versionStartExcluding;
    }

    @JsonProperty("versionStartExcluding")
    public void setVersionStartExcluding(String versionStartExcluding) {
        this.versionStartExcluding = versionStartExcluding;
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
        sb.append(Software.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("vulnerabilityIdMatched");
        sb.append('=');
        sb.append(((this.vulnerabilityIdMatched == null) ? "<null>" : this.vulnerabilityIdMatched));
        sb.append(',');
        sb.append("versionEndExcluding");
        sb.append('=');
        sb.append(((this.versionEndExcluding == null) ? "<null>" : this.versionEndExcluding));
        sb.append(',');
        sb.append("versionStartIncluding");
        sb.append('=');
        sb.append(((this.versionStartIncluding == null) ? "<null>" : this.versionStartIncluding));
        sb.append(',');
        sb.append("versionEndIncluding");
        sb.append('=');
        sb.append(((this.versionEndIncluding == null) ? "<null>" : this.versionEndIncluding));
        sb.append(',');
        sb.append("versionStartExcluding");
        sb.append('=');
        sb.append(((this.versionStartExcluding == null) ? "<null>" : this.versionStartExcluding));
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
        result = ((result * 31) + ((this.versionStartExcluding == null) ? 0 : this.versionStartExcluding.hashCode()));
        result = ((result * 31) + ((this.versionEndExcluding == null) ? 0 : this.versionEndExcluding.hashCode()));
        result = ((result * 31) + ((this.versionEndIncluding == null) ? 0 : this.versionEndIncluding.hashCode()));
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.vulnerabilityIdMatched == null) ? 0 : this.vulnerabilityIdMatched.hashCode()));
        result = ((result * 31) + ((this.versionStartIncluding == null) ? 0 : this.versionStartIncluding.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Software) == false) {
            return false;
        }
        Software rhs = ((Software) other);
        return ((((((((this.versionStartExcluding == rhs.versionStartExcluding)
            || ((this.versionStartExcluding != null) && this.versionStartExcluding.equals(rhs.versionStartExcluding)))
            && ((this.versionEndExcluding == rhs.versionEndExcluding)
                || ((this.versionEndExcluding != null) && this.versionEndExcluding.equals(rhs.versionEndExcluding))))
            && ((this.versionEndIncluding == rhs.versionEndIncluding)
                || ((this.versionEndIncluding != null) && this.versionEndIncluding.equals(rhs.versionEndIncluding))))
            && ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id))))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.vulnerabilityIdMatched == rhs.vulnerabilityIdMatched) || ((this.vulnerabilityIdMatched != null)
                && this.vulnerabilityIdMatched.equals(rhs.vulnerabilityIdMatched))))
            && ((this.versionStartIncluding == rhs.versionStartIncluding) || ((this.versionStartIncluding != null)
                && this.versionStartIncluding.equals(rhs.versionStartIncluding))));
    }

}
