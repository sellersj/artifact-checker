
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
@JsonPropertyOrder({"type", "properties", "elementName"})
public class AnyOf {

    @JsonProperty("type")
    private String type;

    @JsonProperty("properties")
    private Properties__28 properties;

    @JsonProperty("elementName")
    private ElementName__89 elementName;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("properties")
    public Properties__28 getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Properties__28 properties) {
        this.properties = properties;
    }

    @JsonProperty("elementName")
    public ElementName__89 getElementName() {
        return elementName;
    }

    @JsonProperty("elementName")
    public void setElementName(ElementName__89 elementName) {
        this.elementName = elementName;
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
        sb.append(AnyOf.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null) ? "<null>" : this.type));
        sb.append(',');
        sb.append("properties");
        sb.append('=');
        sb.append(((this.properties == null) ? "<null>" : this.properties));
        sb.append(',');
        sb.append("elementName");
        sb.append('=');
        sb.append(((this.elementName == null) ? "<null>" : this.elementName));
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
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.type == null) ? 0 : this.type.hashCode()));
        result = ((result * 31) + ((this.properties == null) ? 0 : this.properties.hashCode()));
        result = ((result * 31) + ((this.elementName == null) ? 0 : this.elementName.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AnyOf) == false) {
            return false;
        }
        AnyOf rhs = ((AnyOf) other);
        return (((((this.additionalProperties == rhs.additionalProperties)
            || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))
            && ((this.type == rhs.type) || ((this.type != null) && this.type.equals(rhs.type))))
            && ((this.properties == rhs.properties)
                || ((this.properties != null) && this.properties.equals(rhs.properties))))
            && ((this.elementName == rhs.elementName)
                || ((this.elementName != null) && this.elementName.equals(rhs.elementName))));
    }

}
