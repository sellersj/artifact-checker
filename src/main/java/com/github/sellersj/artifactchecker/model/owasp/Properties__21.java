
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
@JsonPropertyOrder({"vulnerability", "suppressedVulnerability"})
public class Properties__21 {

    @JsonProperty("vulnerability")
    private Vulnerability__2 vulnerability;

    @JsonProperty("suppressedVulnerability")
    private SuppressedVulnerability__1 suppressedVulnerability;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("vulnerability")
    public Vulnerability__2 getVulnerability() {
        return vulnerability;
    }

    @JsonProperty("vulnerability")
    public void setVulnerability(Vulnerability__2 vulnerability) {
        this.vulnerability = vulnerability;
    }

    @JsonProperty("suppressedVulnerability")
    public SuppressedVulnerability__1 getSuppressedVulnerability() {
        return suppressedVulnerability;
    }

    @JsonProperty("suppressedVulnerability")
    public void setSuppressedVulnerability(SuppressedVulnerability__1 suppressedVulnerability) {
        this.suppressedVulnerability = suppressedVulnerability;
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
        sb.append(Properties__21.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("vulnerability");
        sb.append('=');
        sb.append(((this.vulnerability == null) ? "<null>" : this.vulnerability));
        sb.append(',');
        sb.append("suppressedVulnerability");
        sb.append('=');
        sb.append(((this.suppressedVulnerability == null) ? "<null>" : this.suppressedVulnerability));
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
        result = ((result * 31) + ((this.vulnerability == null) ? 0 : this.vulnerability.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31)
            + ((this.suppressedVulnerability == null) ? 0 : this.suppressedVulnerability.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Properties__21) == false) {
            return false;
        }
        Properties__21 rhs = ((Properties__21) other);
        return ((((this.vulnerability == rhs.vulnerability)
            || ((this.vulnerability != null) && this.vulnerability.equals(rhs.vulnerability)))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.suppressedVulnerability == rhs.suppressedVulnerability) || ((this.suppressedVulnerability != null)
                && this.suppressedVulnerability.equals(rhs.suppressedVulnerability))));
    }

}
