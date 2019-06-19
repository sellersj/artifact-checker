
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
@JsonPropertyOrder({"source", "name", "value", "type", "confidence"})
public class Properties__6 {

    @JsonProperty("source")
    private Source__2 source;

    @JsonProperty("name")
    private Name__3 name;

    @JsonProperty("value")
    private Value value;

    @JsonProperty("type")
    private Type type;

    @JsonProperty("confidence")
    private Confidence confidence;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("source")
    public Source__2 getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(Source__2 source) {
        this.source = source;
    }

    @JsonProperty("name")
    public Name__3 getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Name__3 name) {
        this.name = name;
    }

    @JsonProperty("value")
    public Value getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Value value) {
        this.value = value;
    }

    @JsonProperty("type")
    public Type getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(Type type) {
        this.type = type;
    }

    @JsonProperty("confidence")
    public Confidence getConfidence() {
        return confidence;
    }

    @JsonProperty("confidence")
    public void setConfidence(Confidence confidence) {
        this.confidence = confidence;
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
        sb.append(Properties__6.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("source");
        sb.append('=');
        sb.append(((this.source == null) ? "<null>" : this.source));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("value");
        sb.append('=');
        sb.append(((this.value == null) ? "<null>" : this.value));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null) ? "<null>" : this.type));
        sb.append(',');
        sb.append("confidence");
        sb.append('=');
        sb.append(((this.confidence == null) ? "<null>" : this.confidence));
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
        result = ((result * 31) + ((this.confidence == null) ? 0 : this.confidence.hashCode()));
        result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((result * 31) + ((this.source == null) ? 0 : this.source.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.type == null) ? 0 : this.type.hashCode()));
        result = ((result * 31) + ((this.value == null) ? 0 : this.value.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Properties__6) == false) {
            return false;
        }
        Properties__6 rhs = ((Properties__6) other);
        return (((((((this.confidence == rhs.confidence)
            || ((this.confidence != null) && this.confidence.equals(rhs.confidence)))
            && ((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name))))
            && ((this.source == rhs.source) || ((this.source != null) && this.source.equals(rhs.source))))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.type == rhs.type) || ((this.type != null) && this.type.equals(rhs.type))))
            && ((this.value == rhs.value) || ((this.value != null) && this.value.equals(rhs.value))));
    }

}
