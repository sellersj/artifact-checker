
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
@JsonPropertyOrder({"software"})
public class VulnerableSoftware {

    @JsonProperty("software")
    private Software software;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("software")
    public Software getSoftware() {
        return software;
    }

    @JsonProperty("software")
    public void setSoftware(Software software) {
        this.software = software;
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
        sb.append(VulnerableSoftware.class.getName()).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("software");
        sb.append('=');
        sb.append(((this.software == null) ? "<null>" : this.software));
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
        result = ((result * 31) + ((this.software == null) ? 0 : this.software.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof VulnerableSoftware) == false) {
            return false;
        }
        VulnerableSoftware rhs = ((VulnerableSoftware) other);
        return (((this.software == rhs.software) || ((this.software != null) && this.software.equals(rhs.software)))
            && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
                && this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
