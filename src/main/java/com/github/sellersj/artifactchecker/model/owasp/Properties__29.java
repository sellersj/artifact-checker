
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
public class Properties__29 {

    @JsonProperty("localPart")
    private LocalPart localPart;

    @JsonProperty("namespaceURI")
    private NamespaceURI namespaceURI;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("localPart")
    public LocalPart getLocalPart() {
        return localPart;
    }

    @JsonProperty("localPart")
    public void setLocalPart(LocalPart localPart) {
        this.localPart = localPart;
    }

    @JsonProperty("namespaceURI")
    public NamespaceURI getNamespaceURI() {
        return namespaceURI;
    }

    @JsonProperty("namespaceURI")
    public void setNamespaceURI(NamespaceURI namespaceURI) {
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
        sb.append(Properties__29.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
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
        if ((other instanceof Properties__29) == false) {
            return false;
        }
        Properties__29 rhs = ((Properties__29) other);
        return ((((this.namespaceURI == rhs.namespaceURI)
            || ((this.namespaceURI != null) && this.namespaceURI.equals(rhs.namespaceURI)))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.localPart == rhs.localPart)
                || ((this.localPart != null) && this.localPart.equals(rhs.localPart))));
    }

}
