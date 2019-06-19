
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
@JsonPropertyOrder({"localPart", "namespaceURI"})
public class ElementName__35 {

    @JsonProperty("localPart")
    private String localPart;

    @JsonProperty("namespaceURI")
    private String namespaceURI;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("localPart")
    public String getLocalPart() {
        return localPart;
    }

    @JsonProperty("localPart")
    public void setLocalPart(String localPart) {
        this.localPart = localPart;
    }

    @JsonProperty("namespaceURI")
    public String getNamespaceURI() {
        return namespaceURI;
    }

    @JsonProperty("namespaceURI")
    public void setNamespaceURI(String namespaceURI) {
        this.namespaceURI = namespaceURI;
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
        sb.append(ElementName__35.class.getName()).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("localPart");
        sb.append('=');
        sb.append(((this.localPart == null) ? "<null>" : this.localPart));
        sb.append(',');
        sb.append("namespaceURI");
        sb.append('=');
        sb.append(((this.namespaceURI == null) ? "<null>" : this.namespaceURI));
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
        result = ((result * 31) + ((this.namespaceURI == null) ? 0 : this.namespaceURI.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.localPart == null) ? 0 : this.localPart.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ElementName__35) == false) {
            return false;
        }
        ElementName__35 rhs = ((ElementName__35) other);
        return ((((this.namespaceURI == rhs.namespaceURI)
            || ((this.namespaceURI != null) && this.namespaceURI.equals(rhs.namespaceURI)))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.localPart == rhs.localPart)
                || ((this.localPart != null) && this.localPart.equals(rhs.localPart))));
    }

}
