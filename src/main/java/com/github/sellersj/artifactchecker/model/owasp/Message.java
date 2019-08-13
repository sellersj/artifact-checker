
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
@JsonPropertyOrder({"title", "allOf", "propertyType", "elementName"})
public class Message {

    @JsonProperty("title")
    private String title;

    @JsonProperty("allOf")
    private List<AllOf__40> allOf = new ArrayList<AllOf__40>();

    @JsonProperty("propertyType")
    private String propertyType;

    @JsonProperty("elementName")
    private ElementName__36 elementName;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("allOf")
    public List<AllOf__40> getAllOf() {
        return allOf;
    }

    @JsonProperty("allOf")
    public void setAllOf(List<AllOf__40> allOf) {
        this.allOf = allOf;
    }

    @JsonProperty("propertyType")
    public String getPropertyType() {
        return propertyType;
    }

    @JsonProperty("propertyType")
    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    @JsonProperty("elementName")
    public ElementName__36 getElementName() {
        return elementName;
    }

    @JsonProperty("elementName")
    public void setElementName(ElementName__36 elementName) {
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
        sb.append(Message.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null) ? "<null>" : this.title));
        sb.append(',');
        sb.append("allOf");
        sb.append('=');
        sb.append(((this.allOf == null) ? "<null>" : this.allOf));
        sb.append(',');
        sb.append("propertyType");
        sb.append('=');
        sb.append(((this.propertyType == null) ? "<null>" : this.propertyType));
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
        result = ((result * 31) + ((this.allOf == null) ? 0 : this.allOf.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.title == null) ? 0 : this.title.hashCode()));
        result = ((result * 31) + ((this.propertyType == null) ? 0 : this.propertyType.hashCode()));
        result = ((result * 31) + ((this.elementName == null) ? 0 : this.elementName.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Message) == false) {
            return false;
        }
        Message rhs = ((Message) other);
        return ((((((this.allOf == rhs.allOf) || ((this.allOf != null) && this.allOf.equals(rhs.allOf)))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.title == rhs.title) || ((this.title != null) && this.title.equals(rhs.title))))
            && ((this.propertyType == rhs.propertyType)
                || ((this.propertyType != null) && this.propertyType.equals(rhs.propertyType))))
            && ((this.elementName == rhs.elementName)
                || ((this.elementName != null) && this.elementName.equals(rhs.elementName))));
    }

}
