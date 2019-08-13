
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
@JsonPropertyOrder({"type", "title", "properties", "typeType", "propertiesOrder"})
public class DependencyEvidenceCollected {

    @JsonProperty("type")
    private String type;

    @JsonProperty("title")
    private String title;

    @JsonProperty("properties")
    private Properties__25 properties;

    @JsonProperty("typeType")
    private String typeType;

    @JsonProperty("propertiesOrder")
    private List<String> propertiesOrder = new ArrayList<String>();

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

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("properties")
    public Properties__25 getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Properties__25 properties) {
        this.properties = properties;
    }

    @JsonProperty("typeType")
    public String getTypeType() {
        return typeType;
    }

    @JsonProperty("typeType")
    public void setTypeType(String typeType) {
        this.typeType = typeType;
    }

    @JsonProperty("propertiesOrder")
    public List<String> getPropertiesOrder() {
        return propertiesOrder;
    }

    @JsonProperty("propertiesOrder")
    public void setPropertiesOrder(List<String> propertiesOrder) {
        this.propertiesOrder = propertiesOrder;
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
        sb.append(DependencyEvidenceCollected.class.getName()).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null) ? "<null>" : this.type));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null) ? "<null>" : this.title));
        sb.append(',');
        sb.append("properties");
        sb.append('=');
        sb.append(((this.properties == null) ? "<null>" : this.properties));
        sb.append(',');
        sb.append("typeType");
        sb.append('=');
        sb.append(((this.typeType == null) ? "<null>" : this.typeType));
        sb.append(',');
        sb.append("propertiesOrder");
        sb.append('=');
        sb.append(((this.propertiesOrder == null) ? "<null>" : this.propertiesOrder));
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
        result = ((result * 31) + ((this.propertiesOrder == null) ? 0 : this.propertiesOrder.hashCode()));
        result = ((result * 31) + ((this.typeType == null) ? 0 : this.typeType.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.type == null) ? 0 : this.type.hashCode()));
        result = ((result * 31) + ((this.title == null) ? 0 : this.title.hashCode()));
        result = ((result * 31) + ((this.properties == null) ? 0 : this.properties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DependencyEvidenceCollected) == false) {
            return false;
        }
        DependencyEvidenceCollected rhs = ((DependencyEvidenceCollected) other);
        return (((((((this.propertiesOrder == rhs.propertiesOrder)
            || ((this.propertiesOrder != null) && this.propertiesOrder.equals(rhs.propertiesOrder)))
            && ((this.typeType == rhs.typeType) || ((this.typeType != null) && this.typeType.equals(rhs.typeType))))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.type == rhs.type) || ((this.type != null) && this.type.equals(rhs.type))))
            && ((this.title == rhs.title) || ((this.title != null) && this.title.equals(rhs.title))))
            && ((this.properties == rhs.properties)
                || ((this.properties != null) && this.properties.equals(rhs.properties))));
    }

}
