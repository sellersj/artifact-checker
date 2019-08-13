
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
    "integrityImpact", "availabilityImpact", "severity"})
public class Cvssv2 {

    @JsonProperty("score")
    private Float score;

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
    public Float getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Float score) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Cvssv2.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("score");
        sb.append('=');
        sb.append(((this.score == null) ? "<null>" : this.score));
        sb.append(',');
        sb.append("accessVector");
        sb.append('=');
        sb.append(((this.accessVector == null) ? "<null>" : this.accessVector));
        sb.append(',');
        sb.append("accessComplexity");
        sb.append('=');
        sb.append(((this.accessComplexity == null) ? "<null>" : this.accessComplexity));
        sb.append(',');
        sb.append("authenticationr");
        sb.append('=');
        sb.append(((this.authenticationr == null) ? "<null>" : this.authenticationr));
        sb.append(',');
        sb.append("confidentialImpact");
        sb.append('=');
        sb.append(((this.confidentialImpact == null) ? "<null>" : this.confidentialImpact));
        sb.append(',');
        sb.append("integrityImpact");
        sb.append('=');
        sb.append(((this.integrityImpact == null) ? "<null>" : this.integrityImpact));
        sb.append(',');
        sb.append("availabilityImpact");
        sb.append('=');
        sb.append(((this.availabilityImpact == null) ? "<null>" : this.availabilityImpact));
        sb.append(',');
        sb.append("severity");
        sb.append('=');
        sb.append(((this.severity == null) ? "<null>" : this.severity));
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
        result = ((result * 31) + ((this.confidentialImpact == null) ? 0 : this.confidentialImpact.hashCode()));
        result = ((result * 31) + ((this.severity == null) ? 0 : this.severity.hashCode()));
        result = ((result * 31) + ((this.score == null) ? 0 : this.score.hashCode()));
        result = ((result * 31) + ((this.accessComplexity == null) ? 0 : this.accessComplexity.hashCode()));
        result = ((result * 31) + ((this.availabilityImpact == null) ? 0 : this.availabilityImpact.hashCode()));
        result = ((result * 31) + ((this.integrityImpact == null) ? 0 : this.integrityImpact.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.accessVector == null) ? 0 : this.accessVector.hashCode()));
        result = ((result * 31) + ((this.authenticationr == null) ? 0 : this.authenticationr.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Cvssv2) == false) {
            return false;
        }
        Cvssv2 rhs = ((Cvssv2) other);
        return ((((((((((this.confidentialImpact == rhs.confidentialImpact)
            || ((this.confidentialImpact != null) && this.confidentialImpact.equals(rhs.confidentialImpact)))
            && ((this.severity == rhs.severity) || ((this.severity != null) && this.severity.equals(rhs.severity))))
            && ((this.score == rhs.score) || ((this.score != null) && this.score.equals(rhs.score))))
            && ((this.accessComplexity == rhs.accessComplexity)
                || ((this.accessComplexity != null) && this.accessComplexity.equals(rhs.accessComplexity))))
            && ((this.availabilityImpact == rhs.availabilityImpact)
                || ((this.availabilityImpact != null) && this.availabilityImpact.equals(rhs.availabilityImpact))))
            && ((this.integrityImpact == rhs.integrityImpact)
                || ((this.integrityImpact != null) && this.integrityImpact.equals(rhs.integrityImpact))))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.accessVector == rhs.accessVector)
                || ((this.accessVector != null) && this.accessVector.equals(rhs.accessVector))))
            && ((this.authenticationr == rhs.authenticationr)
                || ((this.authenticationr != null) && this.authenticationr.equals(rhs.authenticationr))));
    }

}
