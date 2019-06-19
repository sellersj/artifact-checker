
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
@JsonPropertyOrder({"relatedDependency"})
public class Properties__26 {

    @JsonProperty("relatedDependency")
    private RelatedDependency__2 relatedDependency;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("relatedDependency")
    public RelatedDependency__2 getRelatedDependency() {
        return relatedDependency;
    }

    @JsonProperty("relatedDependency")
    public void setRelatedDependency(RelatedDependency__2 relatedDependency) {
        this.relatedDependency = relatedDependency;
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
        sb.append(Properties__26.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("relatedDependency");
        sb.append('=');
        sb.append(((this.relatedDependency == null) ? "<null>" : this.relatedDependency));
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
        result = ((result * 31) + ((this.relatedDependency == null) ? 0 : this.relatedDependency.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Properties__26) == false) {
            return false;
        }
        Properties__26 rhs = ((Properties__26) other);
        return (((this.relatedDependency == rhs.relatedDependency)
            || ((this.relatedDependency != null) && this.relatedDependency.equals(rhs.relatedDependency)))
            && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
                && this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
