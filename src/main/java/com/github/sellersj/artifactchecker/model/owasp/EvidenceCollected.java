
package com.github.sellersj.artifactchecker.model.owasp;

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
@JsonPropertyOrder({ "vendorEvidence", "productEvidence", "versionEvidence" })
public class EvidenceCollected {

    @JsonProperty("vendorEvidence")
    private List<VendorEvidence> vendorEvidence = null;

    @JsonProperty("productEvidence")
    private List<ProductEvidence> productEvidence = null;

    @JsonProperty("versionEvidence")
    private List<VersionEvidence> versionEvidence = null;

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

}
