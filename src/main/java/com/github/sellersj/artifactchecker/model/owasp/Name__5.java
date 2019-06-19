
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
@JsonPropertyOrder({"allOf"})
public class Name__5 {

    @JsonProperty("allOf")
    private List<AllOf__102> allOf = new ArrayList<AllOf__102>();

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("allOf")
    public List<AllOf__102> getAllOf() {
        return allOf;
    }

    @JsonProperty("allOf")
    public void setAllOf(List<AllOf__102> allOf) {
        this.allOf = allOf;
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
        sb.append(Name__5.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("allOf");
        sb.append('=');
        sb.append(((this.allOf == null) ? "<null>" : this.allOf));
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
        result = ((result * 31) + ((this.allOf == null) ? 0 : this.allOf.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Name__5) == false) {
            return false;
        }
        Name__5 rhs = ((Name__5) other);
        return (((this.allOf == rhs.allOf) || ((this.allOf != null) && this.allOf.equals(rhs.allOf)))
            && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
                && this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
