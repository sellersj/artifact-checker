
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
@JsonPropertyOrder({"id", "url", "description", "notes", "confidence"})
public class Properties__8 {

    @JsonProperty("id")
    private Id id;

    @JsonProperty("url")
    private Url__1 url;

    @JsonProperty("description")
    private Description__1 description;

    @JsonProperty("notes")
    private Notes__1 notes;

    @JsonProperty("confidence")
    private Confidence__1 confidence;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Id getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Id id) {
        this.id = id;
    }

    @JsonProperty("url")
    public Url__1 getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(Url__1 url) {
        this.url = url;
    }

    @JsonProperty("description")
    public Description__1 getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Description__1 description) {
        this.description = description;
    }

    @JsonProperty("notes")
    public Notes__1 getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(Notes__1 notes) {
        this.notes = notes;
    }

    @JsonProperty("confidence")
    public Confidence__1 getConfidence() {
        return confidence;
    }

    @JsonProperty("confidence")
    public void setConfidence(Confidence__1 confidence) {
        this.confidence = confidence;
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
        sb.append(Properties__8.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null) ? "<null>" : this.url));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null) ? "<null>" : this.description));
        sb.append(',');
        sb.append("notes");
        sb.append('=');
        sb.append(((this.notes == null) ? "<null>" : this.notes));
        sb.append(',');
        sb.append("confidence");
        sb.append('=');
        sb.append(((this.confidence == null) ? "<null>" : this.confidence));
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
        result = ((result * 31) + ((this.notes == null) ? 0 : this.notes.hashCode()));
        result = ((result * 31) + ((this.confidence == null) ? 0 : this.confidence.hashCode()));
        result = ((result * 31) + ((this.description == null) ? 0 : this.description.hashCode()));
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.url == null) ? 0 : this.url.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Properties__8) == false) {
            return false;
        }
        Properties__8 rhs = ((Properties__8) other);
        return (((((((this.notes == rhs.notes) || ((this.notes != null) && this.notes.equals(rhs.notes)))
            && ((this.confidence == rhs.confidence)
                || ((this.confidence != null) && this.confidence.equals(rhs.confidence))))
            && ((this.description == rhs.description)
                || ((this.description != null) && this.description.equals(rhs.description))))
            && ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id))))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.url == rhs.url) || ((this.url != null) && this.url.equals(rhs.url))));
    }

}
