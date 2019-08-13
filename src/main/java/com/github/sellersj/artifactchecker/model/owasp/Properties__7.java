
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
@JsonPropertyOrder({"_package", "vulnerabilityIds", "suppressedVulnerabilityIds"})
public class Properties__7 {

    @JsonProperty("_package")
    private Package__1 _package;

    @JsonProperty("vulnerabilityIds")
    private VulnerabilityIds vulnerabilityIds;

    @JsonProperty("suppressedVulnerabilityIds")
    private SuppressedVulnerabilityIds suppressedVulnerabilityIds;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("_package")
    public Package__1 getPackage() {
        return _package;
    }

    @JsonProperty("_package")
    public void setPackage(Package__1 _package) {
        this._package = _package;
    }

    @JsonProperty("vulnerabilityIds")
    public VulnerabilityIds getVulnerabilityIds() {
        return vulnerabilityIds;
    }

    @JsonProperty("vulnerabilityIds")
    public void setVulnerabilityIds(VulnerabilityIds vulnerabilityIds) {
        this.vulnerabilityIds = vulnerabilityIds;
    }

    @JsonProperty("suppressedVulnerabilityIds")
    public SuppressedVulnerabilityIds getSuppressedVulnerabilityIds() {
        return suppressedVulnerabilityIds;
    }

    @JsonProperty("suppressedVulnerabilityIds")
    public void setSuppressedVulnerabilityIds(SuppressedVulnerabilityIds suppressedVulnerabilityIds) {
        this.suppressedVulnerabilityIds = suppressedVulnerabilityIds;
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
        sb.append(Properties__7.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("_package");
        sb.append('=');
        sb.append(((this._package == null) ? "<null>" : this._package));
        sb.append(',');
        sb.append("vulnerabilityIds");
        sb.append('=');
        sb.append(((this.vulnerabilityIds == null) ? "<null>" : this.vulnerabilityIds));
        sb.append(',');
        sb.append("suppressedVulnerabilityIds");
        sb.append('=');
        sb.append(((this.suppressedVulnerabilityIds == null) ? "<null>" : this.suppressedVulnerabilityIds));
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
        result = ((result * 31) + ((this._package == null) ? 0 : this._package.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.vulnerabilityIds == null) ? 0 : this.vulnerabilityIds.hashCode()));
        result = ((result * 31)
            + ((this.suppressedVulnerabilityIds == null) ? 0 : this.suppressedVulnerabilityIds.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Properties__7) == false) {
            return false;
        }
        Properties__7 rhs = ((Properties__7) other);
        return (((((this._package == rhs._package) || ((this._package != null) && this._package.equals(rhs._package)))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.vulnerabilityIds == rhs.vulnerabilityIds)
                || ((this.vulnerabilityIds != null) && this.vulnerabilityIds.equals(rhs.vulnerabilityIds))))
            && ((this.suppressedVulnerabilityIds == rhs.suppressedVulnerabilityIds)
                || ((this.suppressedVulnerabilityIds != null)
                    && this.suppressedVulnerabilityIds.equals(rhs.suppressedVulnerabilityIds))));
    }

}
