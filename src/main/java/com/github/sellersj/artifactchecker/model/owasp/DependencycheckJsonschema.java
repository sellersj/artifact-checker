
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
@JsonPropertyOrder({"id", "definitions", "anyOf"})
public class DependencycheckJsonschema {

    @JsonProperty("id")
    private String id;

    @JsonProperty("definitions")
    private Definitions definitions;

    @JsonProperty("anyOf")
    private List<AnyOf> anyOf = new ArrayList<AnyOf>();

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

    @JsonProperty("definitions")
    public Definitions getDefinitions() {
        return definitions;
    }

    @JsonProperty("definitions")
    public void setDefinitions(Definitions definitions) {
        this.definitions = definitions;
    }

    @JsonProperty("anyOf")
    public List<AnyOf> getAnyOf() {
        return anyOf;
    }

    @JsonProperty("anyOf")
    public void setAnyOf(List<AnyOf> anyOf) {
        this.anyOf = anyOf;
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
        sb.append(DependencycheckJsonschema.class.getName()).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("definitions");
        sb.append('=');
        sb.append(((this.definitions == null) ? "<null>" : this.definitions));
        sb.append(',');
        sb.append("anyOf");
        sb.append('=');
        sb.append(((this.anyOf == null) ? "<null>" : this.anyOf));
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
        result = ((result * 31) + ((this.anyOf == null) ? 0 : this.anyOf.hashCode()));
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.definitions == null) ? 0 : this.definitions.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DependencycheckJsonschema) == false) {
            return false;
        }
        DependencycheckJsonschema rhs = ((DependencycheckJsonschema) other);
        return (((((this.anyOf == rhs.anyOf) || ((this.anyOf != null) && this.anyOf.equals(rhs.anyOf)))
            && ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id))))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.definitions == rhs.definitions)
                || ((this.definitions != null) && this.definitions.equals(rhs.definitions))));
    }

}
