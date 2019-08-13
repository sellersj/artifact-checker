
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
@JsonPropertyOrder({"vendorEvidence", "productEvidence", "versionEvidence"})
public class EvidenceCollected {

    @JsonProperty("vendorEvidence")
    private List<VendorEvidence> vendorEvidence = new ArrayList<VendorEvidence>();

    @JsonProperty("productEvidence")
    private List<ProductEvidence> productEvidence = new ArrayList<ProductEvidence>();

    @JsonProperty("versionEvidence")
    private List<VersionEvidence> versionEvidence = new ArrayList<VersionEvidence>();

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("vendorEvidence")
    public List<VendorEvidence> getVendorEvidence() {
        return vendorEvidence;
    }

    @JsonProperty("vendorEvidence")
    public void setVendorEvidence(List<VendorEvidence> vendorEvidence) {
        this.vendorEvidence = vendorEvidence;
    }

    @JsonProperty("productEvidence")
    public List<ProductEvidence> getProductEvidence() {
        return productEvidence;
    }

    @JsonProperty("productEvidence")
    public void setProductEvidence(List<ProductEvidence> productEvidence) {
        this.productEvidence = productEvidence;
    }

    @JsonProperty("versionEvidence")
    public List<VersionEvidence> getVersionEvidence() {
        return versionEvidence;
    }

    @JsonProperty("versionEvidence")
    public void setVersionEvidence(List<VersionEvidence> versionEvidence) {
        this.versionEvidence = versionEvidence;
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
        sb.append(EvidenceCollected.class.getName()).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("vendorEvidence");
        sb.append('=');
        sb.append(((this.vendorEvidence == null) ? "<null>" : this.vendorEvidence));
        sb.append(',');
        sb.append("productEvidence");
        sb.append('=');
        sb.append(((this.productEvidence == null) ? "<null>" : this.productEvidence));
        sb.append(',');
        sb.append("versionEvidence");
        sb.append('=');
        sb.append(((this.versionEvidence == null) ? "<null>" : this.versionEvidence));
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
        result = ((result * 31) + ((this.vendorEvidence == null) ? 0 : this.vendorEvidence.hashCode()));
        result = ((result * 31) + ((this.versionEvidence == null) ? 0 : this.versionEvidence.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.productEvidence == null) ? 0 : this.productEvidence.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EvidenceCollected) == false) {
            return false;
        }
        EvidenceCollected rhs = ((EvidenceCollected) other);
        return (((((this.vendorEvidence == rhs.vendorEvidence)
            || ((this.vendorEvidence != null) && this.vendorEvidence.equals(rhs.vendorEvidence)))
            && ((this.versionEvidence == rhs.versionEvidence)
                || ((this.versionEvidence != null) && this.versionEvidence.equals(rhs.versionEvidence))))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.productEvidence == rhs.productEvidence)
                || ((this.productEvidence != null) && this.productEvidence.equals(rhs.productEvidence))));
    }

}
