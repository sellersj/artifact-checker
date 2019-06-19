
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
@JsonPropertyOrder({"trace"})
public class Properties__15 {

    @JsonProperty("trace")
    private Trace__1 trace;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("trace")
    public Trace__1 getTrace() {
        return trace;
    }

    @JsonProperty("trace")
    public void setTrace(Trace__1 trace) {
        this.trace = trace;
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
        sb.append(Properties__15.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("trace");
        sb.append('=');
        sb.append(((this.trace == null) ? "<null>" : this.trace));
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
        result = ((result * 31) + ((this.trace == null) ? 0 : this.trace.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Properties__15) == false) {
            return false;
        }
        Properties__15 rhs = ((Properties__15) other);
        return (((this.trace == rhs.trace) || ((this.trace != null) && this.trace.equals(rhs.trace)))
            && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
                && this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
