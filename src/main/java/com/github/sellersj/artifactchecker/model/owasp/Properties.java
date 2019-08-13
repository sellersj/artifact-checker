
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
@JsonPropertyOrder({"name", "severity", "cvssV2", "cvssV3", "cwes", "description", "notes", "references",
    "vulnerableSoftware", "source"})
public class Properties {

    @JsonProperty("name")
    private Name name;

    @JsonProperty("severity")
    private Severity severity;

    @JsonProperty("cvssV2")
    private CvssV2__2 cvssV2;

    @JsonProperty("cvssV3")
    private CvssV3__2 cvssV3;

    @JsonProperty("cwes")
    private Cwes cwes;

    @JsonProperty("description")
    private Description description;

    @JsonProperty("notes")
    private Notes notes;

    @JsonProperty("references")
    private References references;

    @JsonProperty("vulnerableSoftware")
    private VulnerableSoftware__2 vulnerableSoftware;

    @JsonProperty("source")
    private Source source;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public Name getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Name name) {
        this.name = name;
    }

    @JsonProperty("severity")
    public Severity getSeverity() {
        return severity;
    }

    @JsonProperty("severity")
    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    @JsonProperty("cvssV2")
    public CvssV2__2 getCvssV2() {
        return cvssV2;
    }

    @JsonProperty("cvssV2")
    public void setCvssV2(CvssV2__2 cvssV2) {
        this.cvssV2 = cvssV2;
    }

    @JsonProperty("cvssV3")
    public CvssV3__2 getCvssV3() {
        return cvssV3;
    }

    @JsonProperty("cvssV3")
    public void setCvssV3(CvssV3__2 cvssV3) {
        this.cvssV3 = cvssV3;
    }

    @JsonProperty("cwes")
    public Cwes getCwes() {
        return cwes;
    }

    @JsonProperty("cwes")
    public void setCwes(Cwes cwes) {
        this.cwes = cwes;
    }

    @JsonProperty("description")
    public Description getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Description description) {
        this.description = description;
    }

    @JsonProperty("notes")
    public Notes getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    @JsonProperty("references")
    public References getReferences() {
        return references;
    }

    @JsonProperty("references")
    public void setReferences(References references) {
        this.references = references;
    }

    @JsonProperty("vulnerableSoftware")
    public VulnerableSoftware__2 getVulnerableSoftware() {
        return vulnerableSoftware;
    }

    @JsonProperty("vulnerableSoftware")
    public void setVulnerableSoftware(VulnerableSoftware__2 vulnerableSoftware) {
        this.vulnerableSoftware = vulnerableSoftware;
    }

    @JsonProperty("source")
    public Source getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(Source source) {
        this.source = source;
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
        sb.append(Properties.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("severity");
        sb.append('=');
        sb.append(((this.severity == null) ? "<null>" : this.severity));
        sb.append(',');
        sb.append("cvssV2");
        sb.append('=');
        sb.append(((this.cvssV2 == null) ? "<null>" : this.cvssV2));
        sb.append(',');
        sb.append("cvssV3");
        sb.append('=');
        sb.append(((this.cvssV3 == null) ? "<null>" : this.cvssV3));
        sb.append(',');
        sb.append("cwes");
        sb.append('=');
        sb.append(((this.cwes == null) ? "<null>" : this.cwes));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null) ? "<null>" : this.description));
        sb.append(',');
        sb.append("notes");
        sb.append('=');
        sb.append(((this.notes == null) ? "<null>" : this.notes));
        sb.append(',');
        sb.append("references");
        sb.append('=');
        sb.append(((this.references == null) ? "<null>" : this.references));
        sb.append(',');
        sb.append("vulnerableSoftware");
        sb.append('=');
        sb.append(((this.vulnerableSoftware == null) ? "<null>" : this.vulnerableSoftware));
        sb.append(',');
        sb.append("source");
        sb.append('=');
        sb.append(((this.source == null) ? "<null>" : this.source));
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
        result = ((result * 31) + ((this.severity == null) ? 0 : this.severity.hashCode()));
        result = ((result * 31) + ((this.notes == null) ? 0 : this.notes.hashCode()));
        result = ((result * 31) + ((this.cvssV3 == null) ? 0 : this.cvssV3.hashCode()));
        result = ((result * 31) + ((this.references == null) ? 0 : this.references.hashCode()));
        result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((result * 31) + ((this.description == null) ? 0 : this.description.hashCode()));
        result = ((result * 31) + ((this.cvssV2 == null) ? 0 : this.cvssV2.hashCode()));
        result = ((result * 31) + ((this.source == null) ? 0 : this.source.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.cwes == null) ? 0 : this.cwes.hashCode()));
        result = ((result * 31) + ((this.vulnerableSoftware == null) ? 0 : this.vulnerableSoftware.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Properties) == false) {
            return false;
        }
        Properties rhs = ((Properties) other);
        return ((((((((((((this.severity == rhs.severity)
            || ((this.severity != null) && this.severity.equals(rhs.severity)))
            && ((this.notes == rhs.notes) || ((this.notes != null) && this.notes.equals(rhs.notes))))
            && ((this.cvssV3 == rhs.cvssV3) || ((this.cvssV3 != null) && this.cvssV3.equals(rhs.cvssV3))))
            && ((this.references == rhs.references)
                || ((this.references != null) && this.references.equals(rhs.references))))
            && ((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name))))
            && ((this.description == rhs.description)
                || ((this.description != null) && this.description.equals(rhs.description))))
            && ((this.cvssV2 == rhs.cvssV2) || ((this.cvssV2 != null) && this.cvssV2.equals(rhs.cvssV2))))
            && ((this.source == rhs.source) || ((this.source != null) && this.source.equals(rhs.source))))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.cwes == rhs.cwes) || ((this.cwes != null) && this.cwes.equals(rhs.cwes))))
            && ((this.vulnerableSoftware == rhs.vulnerableSoftware)
                || ((this.vulnerableSoftware != null) && this.vulnerableSoftware.equals(rhs.vulnerableSoftware))));
    }

}
