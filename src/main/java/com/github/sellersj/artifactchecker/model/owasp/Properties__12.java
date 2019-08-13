
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
@JsonPropertyOrder({"value", "vulnerabilityIdMatched", "versionStartIncluding", "versionStartExcluding",
    "versionEndIncluding", "versionEndExcluding", "vulnerable"})
public class Properties__12 {

    @JsonProperty("value")
    private Value__1 value;

    @JsonProperty("vulnerabilityIdMatched")
    private VulnerabilityIdMatched vulnerabilityIdMatched;

    @JsonProperty("versionStartIncluding")
    private VersionStartIncluding versionStartIncluding;

    @JsonProperty("versionStartExcluding")
    private VersionStartExcluding versionStartExcluding;

    @JsonProperty("versionEndIncluding")
    private VersionEndIncluding versionEndIncluding;

    @JsonProperty("versionEndExcluding")
    private VersionEndExcluding versionEndExcluding;

    @JsonProperty("vulnerable")
    private Vulnerable vulnerable;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("value")
    public Value__1 getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Value__1 value) {
        this.value = value;
    }

    @JsonProperty("vulnerabilityIdMatched")
    public VulnerabilityIdMatched getVulnerabilityIdMatched() {
        return vulnerabilityIdMatched;
    }

    @JsonProperty("vulnerabilityIdMatched")
    public void setVulnerabilityIdMatched(VulnerabilityIdMatched vulnerabilityIdMatched) {
        this.vulnerabilityIdMatched = vulnerabilityIdMatched;
    }

    @JsonProperty("versionStartIncluding")
    public VersionStartIncluding getVersionStartIncluding() {
        return versionStartIncluding;
    }

    @JsonProperty("versionStartIncluding")
    public void setVersionStartIncluding(VersionStartIncluding versionStartIncluding) {
        this.versionStartIncluding = versionStartIncluding;
    }

    @JsonProperty("versionStartExcluding")
    public VersionStartExcluding getVersionStartExcluding() {
        return versionStartExcluding;
    }

    @JsonProperty("versionStartExcluding")
    public void setVersionStartExcluding(VersionStartExcluding versionStartExcluding) {
        this.versionStartExcluding = versionStartExcluding;
    }

    @JsonProperty("versionEndIncluding")
    public VersionEndIncluding getVersionEndIncluding() {
        return versionEndIncluding;
    }

    @JsonProperty("versionEndIncluding")
    public void setVersionEndIncluding(VersionEndIncluding versionEndIncluding) {
        this.versionEndIncluding = versionEndIncluding;
    }

    @JsonProperty("versionEndExcluding")
    public VersionEndExcluding getVersionEndExcluding() {
        return versionEndExcluding;
    }

    @JsonProperty("versionEndExcluding")
    public void setVersionEndExcluding(VersionEndExcluding versionEndExcluding) {
        this.versionEndExcluding = versionEndExcluding;
    }

    @JsonProperty("vulnerable")
    public Vulnerable getVulnerable() {
        return vulnerable;
    }

    @JsonProperty("vulnerable")
    public void setVulnerable(Vulnerable vulnerable) {
        this.vulnerable = vulnerable;
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
        sb.append(Properties__12.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("value");
        sb.append('=');
        sb.append(((this.value == null) ? "<null>" : this.value));
        sb.append(',');
        sb.append("vulnerabilityIdMatched");
        sb.append('=');
        sb.append(((this.vulnerabilityIdMatched == null) ? "<null>" : this.vulnerabilityIdMatched));
        sb.append(',');
        sb.append("versionStartIncluding");
        sb.append('=');
        sb.append(((this.versionStartIncluding == null) ? "<null>" : this.versionStartIncluding));
        sb.append(',');
        sb.append("versionStartExcluding");
        sb.append('=');
        sb.append(((this.versionStartExcluding == null) ? "<null>" : this.versionStartExcluding));
        sb.append(',');
        sb.append("versionEndIncluding");
        sb.append('=');
        sb.append(((this.versionEndIncluding == null) ? "<null>" : this.versionEndIncluding));
        sb.append(',');
        sb.append("versionEndExcluding");
        sb.append('=');
        sb.append(((this.versionEndExcluding == null) ? "<null>" : this.versionEndExcluding));
        sb.append(',');
        sb.append("vulnerable");
        sb.append('=');
        sb.append(((this.vulnerable == null) ? "<null>" : this.vulnerable));
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
        result = ((result * 31) + ((this.vulnerable == null) ? 0 : this.vulnerable.hashCode()));
        result = ((result * 31) + ((this.versionStartExcluding == null) ? 0 : this.versionStartExcluding.hashCode()));
        result = ((result * 31) + ((this.versionEndExcluding == null) ? 0 : this.versionEndExcluding.hashCode()));
        result = ((result * 31) + ((this.versionEndIncluding == null) ? 0 : this.versionEndIncluding.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.value == null) ? 0 : this.value.hashCode()));
        result = ((result * 31) + ((this.vulnerabilityIdMatched == null) ? 0 : this.vulnerabilityIdMatched.hashCode()));
        result = ((result * 31) + ((this.versionStartIncluding == null) ? 0 : this.versionStartIncluding.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Properties__12) == false) {
            return false;
        }
        Properties__12 rhs = ((Properties__12) other);
        return (((((((((this.vulnerable == rhs.vulnerable)
            || ((this.vulnerable != null) && this.vulnerable.equals(rhs.vulnerable)))
            && ((this.versionStartExcluding == rhs.versionStartExcluding) || ((this.versionStartExcluding != null)
                && this.versionStartExcluding.equals(rhs.versionStartExcluding))))
            && ((this.versionEndExcluding == rhs.versionEndExcluding)
                || ((this.versionEndExcluding != null) && this.versionEndExcluding.equals(rhs.versionEndExcluding))))
            && ((this.versionEndIncluding == rhs.versionEndIncluding)
                || ((this.versionEndIncluding != null) && this.versionEndIncluding.equals(rhs.versionEndIncluding))))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.value == rhs.value) || ((this.value != null) && this.value.equals(rhs.value))))
            && ((this.vulnerabilityIdMatched == rhs.vulnerabilityIdMatched) || ((this.vulnerabilityIdMatched != null)
                && this.vulnerabilityIdMatched.equals(rhs.vulnerabilityIdMatched))))
            && ((this.versionStartIncluding == rhs.versionStartIncluding) || ((this.versionStartIncluding != null)
                && this.versionStartIncluding.equals(rhs.versionStartIncluding))));
    }

}
