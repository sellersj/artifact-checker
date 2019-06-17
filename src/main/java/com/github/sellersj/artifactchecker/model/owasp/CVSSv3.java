
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
@JsonPropertyOrder({"baseScore", "attackVector", "attackComplexity", "privilegesRequired", "userInteraction", "scope",
    "confidentialityImpact", "integrityImpact", "availabilityImpact", "baseSeverity",})
public class CVSSv3 {

    @JsonProperty("baseScore")
    private String baseScore;

    @JsonProperty("attackVector")
    private String attackVector;

    @JsonProperty("attackComplexity")
    private String attackComplexity;

    @JsonProperty("privilegesRequired")
    private String privilegesRequired;

    @JsonProperty("userInteraction")
    private String userInteraction;

    @JsonProperty("scope")
    private String scope;

    @JsonProperty("confidentialityImpact")
    private String confidentialityImpact;

    @JsonProperty("integrityImpact")
    private String integrityImpact;

    @JsonProperty("availabilityImpact")
    private String availabilityImpact;

    @JsonProperty("baseSeverity")
    private String baseSeverity;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("baseScore")
    public String getBaseScore() {
        return baseScore;
    }

    @JsonProperty("baseScore")
    public void setBaseScore(String baseScore) {
        this.baseScore = baseScore;
    }

    @JsonProperty("attackVector")
    public String getAttackVector() {
        return attackVector;
    }

    @JsonProperty("attackVector")
    public void setAttackVector(String attackVector) {
        this.attackVector = attackVector;
    }

    @JsonProperty("attackComplexity")
    public String getAttackComplexity() {
        return attackComplexity;
    }

    @JsonProperty("attackComplexity")
    public void setAttackComplexity(String attackComplexity) {
        this.attackComplexity = attackComplexity;
    }

    @JsonProperty("privilegesRequired")
    public String getPrivilegesRequired() {
        return privilegesRequired;
    }

    @JsonProperty("privilegesRequired")
    public void setPrivilegesRequired(String privilegesRequired) {
        this.privilegesRequired = privilegesRequired;
    }

    @JsonProperty("userInteraction")
    public String getUserInteraction() {
        return userInteraction;
    }

    @JsonProperty("userInteraction")
    public void setUserInteraction(String userInteraction) {
        this.userInteraction = userInteraction;
    }

    @JsonProperty("scope")
    public String getScope() {
        return scope;
    }

    @JsonProperty("scope")
    public void setScope(String scope) {
        this.scope = scope;
    }

    @JsonProperty("confidentialityImpact")
    public String getConfidentialityImpact() {
        return confidentialityImpact;
    }

    @JsonProperty("confidentialityImpact")
    public void setConfidentialityImpact(String confidentialityImpact) {
        this.confidentialityImpact = confidentialityImpact;
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

    @JsonProperty("baseSeverity")
    public String getBaseSeverity() {
        return baseSeverity;
    }

    @JsonProperty("baseSeverity")
    public void setBaseSeverity(String baseSeverity) {
        this.baseSeverity = baseSeverity;
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
