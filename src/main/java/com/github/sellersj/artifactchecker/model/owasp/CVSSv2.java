
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
@JsonPropertyOrder({"score", "accessVector", "accessComplexity", "authenticationr", "confidentialImpact",
    "integrityImpact", "availabilityImpact", "severity",})
public class CVSSv2 {

    @JsonProperty("score")
    private String score;

    @JsonProperty("accessVector")
    private String accessVector;

    @JsonProperty("accessComplexity")
    private String accessComplexity;

    @JsonProperty("authenticationr")
    private String authenticationr;

    @JsonProperty("confidentialImpact")
    private String confidentialImpact;

    @JsonProperty("integrityImpact")
    private String integrityImpact;

    @JsonProperty("availabilityImpact")
    private String availabilityImpact;

    @JsonProperty("severity")
    private String severity;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("score")
    public String getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(String score) {
        this.score = score;
    }

    @JsonProperty("accessVector")
    public String getAccessVector() {
        return accessVector;
    }

    @JsonProperty("accessVector")
    public void setAccessVector(String accessVector) {
        this.accessVector = accessVector;
    }

    @JsonProperty("accessComplexity")
    public String getAccessComplexity() {
        return accessComplexity;
    }

    @JsonProperty("accessComplexity")
    public void setAccessComplexity(String accessComplexity) {
        this.accessComplexity = accessComplexity;
    }

    @JsonProperty("authenticationr")
    public String getAuthenticationr() {
        return authenticationr;
    }

    @JsonProperty("authenticationr")
    public void setAuthenticationr(String authenticationr) {
        this.authenticationr = authenticationr;
    }

    @JsonProperty("confidentialImpact")
    public String getConfidentialImpact() {
        return confidentialImpact;
    }

    @JsonProperty("confidentialImpact")
    public void setConfidentialImpact(String confidentialImpact) {
        this.confidentialImpact = confidentialImpact;
    }

    @JsonProperty("integrityImpact")
    public String getIntegrityImpact() {
        return integrityImpact;
    }

    @JsonProperty("integrityImpact")
    public void setIntegrityImpact(String integrityImpact) {
        this.integrityImpact = integrityImpact;
    }

    @JsonProperty("availabilityImpact")
    public String getAvailabilityImpact() {
        return availabilityImpact;
    }

    @JsonProperty("availabilityImpact")
    public void setAvailabilityImpact(String availabilityImpact) {
        this.availabilityImpact = availabilityImpact;
    }

    @JsonProperty("severity")
    public String getSeverity() {
        return severity;
    }

    @JsonProperty("severity")
    public void setSeverity(String severity) {
        this.severity = severity;
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
