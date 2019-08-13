
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
    "confidentialityImpact", "integrityImpact", "availabilityImpact", "baseSeverity"})
public class Properties__3 {

    @JsonProperty("baseScore")
    private BaseScore baseScore;

    @JsonProperty("attackVector")
    private AttackVector attackVector;

    @JsonProperty("attackComplexity")
    private AttackComplexity attackComplexity;

    @JsonProperty("privilegesRequired")
    private PrivilegesRequired privilegesRequired;

    @JsonProperty("userInteraction")
    private UserInteraction userInteraction;

    @JsonProperty("scope")
    private Scope scope;

    @JsonProperty("confidentialityImpact")
    private ConfidentialityImpact confidentialityImpact;

    @JsonProperty("integrityImpact")
    private IntegrityImpact integrityImpact;

    @JsonProperty("availabilityImpact")
    private AvailabilityImpact availabilityImpact;

    @JsonProperty("baseSeverity")
    private BaseSeverity baseSeverity;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("baseScore")
    public BaseScore getBaseScore() {
        return baseScore;
    }

    @JsonProperty("baseScore")
    public void setBaseScore(BaseScore baseScore) {
        this.baseScore = baseScore;
    }

    @JsonProperty("attackVector")
    public AttackVector getAttackVector() {
        return attackVector;
    }

    @JsonProperty("attackVector")
    public void setAttackVector(AttackVector attackVector) {
        this.attackVector = attackVector;
    }

    @JsonProperty("attackComplexity")
    public AttackComplexity getAttackComplexity() {
        return attackComplexity;
    }

    @JsonProperty("attackComplexity")
    public void setAttackComplexity(AttackComplexity attackComplexity) {
        this.attackComplexity = attackComplexity;
    }

    @JsonProperty("privilegesRequired")
    public PrivilegesRequired getPrivilegesRequired() {
        return privilegesRequired;
    }

    @JsonProperty("privilegesRequired")
    public void setPrivilegesRequired(PrivilegesRequired privilegesRequired) {
        this.privilegesRequired = privilegesRequired;
    }

    @JsonProperty("userInteraction")
    public UserInteraction getUserInteraction() {
        return userInteraction;
    }

    @JsonProperty("userInteraction")
    public void setUserInteraction(UserInteraction userInteraction) {
        this.userInteraction = userInteraction;
    }

    @JsonProperty("scope")
    public Scope getScope() {
        return scope;
    }

    @JsonProperty("scope")
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    @JsonProperty("confidentialityImpact")
    public ConfidentialityImpact getConfidentialityImpact() {
        return confidentialityImpact;
    }

    @JsonProperty("confidentialityImpact")
    public void setConfidentialityImpact(ConfidentialityImpact confidentialityImpact) {
        this.confidentialityImpact = confidentialityImpact;
    }

    @JsonProperty("integrityImpact")
    public IntegrityImpact getIntegrityImpact() {
        return integrityImpact;
    }

    @JsonProperty("integrityImpact")
    public void setIntegrityImpact(IntegrityImpact integrityImpact) {
        this.integrityImpact = integrityImpact;
    }

    @JsonProperty("availabilityImpact")
    public AvailabilityImpact getAvailabilityImpact() {
        return availabilityImpact;
    }

    @JsonProperty("availabilityImpact")
    public void setAvailabilityImpact(AvailabilityImpact availabilityImpact) {
        this.availabilityImpact = availabilityImpact;
    }

    @JsonProperty("baseSeverity")
    public BaseSeverity getBaseSeverity() {
        return baseSeverity;
    }

    @JsonProperty("baseSeverity")
    public void setBaseSeverity(BaseSeverity baseSeverity) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Properties__3.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("baseScore");
        sb.append('=');
        sb.append(((this.baseScore == null) ? "<null>" : this.baseScore));
        sb.append(',');
        sb.append("attackVector");
        sb.append('=');
        sb.append(((this.attackVector == null) ? "<null>" : this.attackVector));
        sb.append(',');
        sb.append("attackComplexity");
        sb.append('=');
        sb.append(((this.attackComplexity == null) ? "<null>" : this.attackComplexity));
        sb.append(',');
        sb.append("privilegesRequired");
        sb.append('=');
        sb.append(((this.privilegesRequired == null) ? "<null>" : this.privilegesRequired));
        sb.append(',');
        sb.append("userInteraction");
        sb.append('=');
        sb.append(((this.userInteraction == null) ? "<null>" : this.userInteraction));
        sb.append(',');
        sb.append("scope");
        sb.append('=');
        sb.append(((this.scope == null) ? "<null>" : this.scope));
        sb.append(',');
        sb.append("confidentialityImpact");
        sb.append('=');
        sb.append(((this.confidentialityImpact == null) ? "<null>" : this.confidentialityImpact));
        sb.append(',');
        sb.append("integrityImpact");
        sb.append('=');
        sb.append(((this.integrityImpact == null) ? "<null>" : this.integrityImpact));
        sb.append(',');
        sb.append("availabilityImpact");
        sb.append('=');
        sb.append(((this.availabilityImpact == null) ? "<null>" : this.availabilityImpact));
        sb.append(',');
        sb.append("baseSeverity");
        sb.append('=');
        sb.append(((this.baseSeverity == null) ? "<null>" : this.baseSeverity));
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
        result = ((result * 31) + ((this.baseSeverity == null) ? 0 : this.baseSeverity.hashCode()));
        result = ((result * 31) + ((this.confidentialityImpact == null) ? 0 : this.confidentialityImpact.hashCode()));
        result = ((result * 31) + ((this.attackComplexity == null) ? 0 : this.attackComplexity.hashCode()));
        result = ((result * 31) + ((this.scope == null) ? 0 : this.scope.hashCode()));
        result = ((result * 31) + ((this.attackVector == null) ? 0 : this.attackVector.hashCode()));
        result = ((result * 31) + ((this.availabilityImpact == null) ? 0 : this.availabilityImpact.hashCode()));
        result = ((result * 31) + ((this.integrityImpact == null) ? 0 : this.integrityImpact.hashCode()));
        result = ((result * 31) + ((this.baseScore == null) ? 0 : this.baseScore.hashCode()));
        result = ((result * 31) + ((this.privilegesRequired == null) ? 0 : this.privilegesRequired.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.userInteraction == null) ? 0 : this.userInteraction.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Properties__3) == false) {
            return false;
        }
        Properties__3 rhs = ((Properties__3) other);
        return ((((((((((((this.baseSeverity == rhs.baseSeverity)
            || ((this.baseSeverity != null) && this.baseSeverity.equals(rhs.baseSeverity)))
            && ((this.confidentialityImpact == rhs.confidentialityImpact) || ((this.confidentialityImpact != null)
                && this.confidentialityImpact.equals(rhs.confidentialityImpact))))
            && ((this.attackComplexity == rhs.attackComplexity)
                || ((this.attackComplexity != null) && this.attackComplexity.equals(rhs.attackComplexity))))
            && ((this.scope == rhs.scope) || ((this.scope != null) && this.scope.equals(rhs.scope))))
            && ((this.attackVector == rhs.attackVector)
                || ((this.attackVector != null) && this.attackVector.equals(rhs.attackVector))))
            && ((this.availabilityImpact == rhs.availabilityImpact)
                || ((this.availabilityImpact != null) && this.availabilityImpact.equals(rhs.availabilityImpact))))
            && ((this.integrityImpact == rhs.integrityImpact)
                || ((this.integrityImpact != null) && this.integrityImpact.equals(rhs.integrityImpact))))
            && ((this.baseScore == rhs.baseScore)
                || ((this.baseScore != null) && this.baseScore.equals(rhs.baseScore))))
            && ((this.privilegesRequired == rhs.privilegesRequired)
                || ((this.privilegesRequired != null) && this.privilegesRequired.equals(rhs.privilegesRequired))))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.userInteraction == rhs.userInteraction)
                || ((this.userInteraction != null) && this.userInteraction.equals(rhs.userInteraction))));
    }

}
