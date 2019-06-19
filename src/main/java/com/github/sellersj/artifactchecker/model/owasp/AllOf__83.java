
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
@JsonPropertyOrder({"type", "items", "minItems"})
public class AllOf__83 {

    @JsonProperty("type")
    private String type;

    @JsonProperty("items")
    private Items__11 items;

    @JsonProperty("minItems")
    private Integer minItems;

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

    @JsonProperty("items")
    public Items__11 getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(Items__11 items) {
        this.items = items;
    }

    @JsonProperty("minItems")
    public Integer getMinItems() {
        return minItems;
    }

    @JsonProperty("minItems")
    public void setMinItems(Integer minItems) {
        this.minItems = minItems;
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
        sb.append(AllOf__83.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null) ? "<null>" : this.type));
        sb.append(',');
        sb.append("items");
        sb.append('=');
        sb.append(((this.items == null) ? "<null>" : this.items));
        sb.append(',');
        sb.append("minItems");
        sb.append('=');
        sb.append(((this.minItems == null) ? "<null>" : this.minItems));
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
        result = ((result * 31) + ((this.minItems == null) ? 0 : this.minItems.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.type == null) ? 0 : this.type.hashCode()));
        result = ((result * 31) + ((this.items == null) ? 0 : this.items.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AllOf__83) == false) {
            return false;
        }
        AllOf__83 rhs = ((AllOf__83) other);
        return (((((this.minItems == rhs.minItems) || ((this.minItems != null) && this.minItems.equals(rhs.minItems)))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.type == rhs.type) || ((this.type != null) && this.type.equals(rhs.type))))
            && ((this.items == rhs.items) || ((this.items != null) && this.items.equals(rhs.items))));
    }

}
