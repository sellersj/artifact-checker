
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
@JsonPropertyOrder({"name", "groupID", "artifactID", "version", "reportDate", "credits"})
public class ProjectInfo {

    @JsonProperty("name")
    private String name;

    @JsonProperty("groupID")
    private String groupID;

    @JsonProperty("artifactID")
    private String artifactID;

    @JsonProperty("version")
    private String version;

    @JsonProperty("reportDate")
    private String reportDate;

    @JsonProperty("credits")
    private Credits credits;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("groupID")
    public String getGroupID() {
        return groupID;
    }

    @JsonProperty("groupID")
    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    @JsonProperty("artifactID")
    public String getArtifactID() {
        return artifactID;
    }

    @JsonProperty("artifactID")
    public void setArtifactID(String artifactID) {
        this.artifactID = artifactID;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("reportDate")
    public String getReportDate() {
        return reportDate;
    }

    @JsonProperty("reportDate")
    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    @JsonProperty("credits")
    public Credits getCredits() {
        return credits;
    }

    @JsonProperty("credits")
    public void setCredits(Credits credits) {
        this.credits = credits;
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
        sb.append(ProjectInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("groupID");
        sb.append('=');
        sb.append(((this.groupID == null) ? "<null>" : this.groupID));
        sb.append(',');
        sb.append("artifactID");
        sb.append('=');
        sb.append(((this.artifactID == null) ? "<null>" : this.artifactID));
        sb.append(',');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null) ? "<null>" : this.version));
        sb.append(',');
        sb.append("reportDate");
        sb.append('=');
        sb.append(((this.reportDate == null) ? "<null>" : this.reportDate));
        sb.append(',');
        sb.append("credits");
        sb.append('=');
        sb.append(((this.credits == null) ? "<null>" : this.credits));
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
        result = ((result * 31) + ((this.reportDate == null) ? 0 : this.reportDate.hashCode()));
        result = ((result * 31) + ((this.credits == null) ? 0 : this.credits.hashCode()));
        result = ((result * 31) + ((this.groupID == null) ? 0 : this.groupID.hashCode()));
        result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((result * 31) + ((this.artifactID == null) ? 0 : this.artifactID.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.version == null) ? 0 : this.version.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProjectInfo) == false) {
            return false;
        }
        ProjectInfo rhs = ((ProjectInfo) other);
        return ((((((((this.reportDate == rhs.reportDate)
            || ((this.reportDate != null) && this.reportDate.equals(rhs.reportDate)))
            && ((this.credits == rhs.credits) || ((this.credits != null) && this.credits.equals(rhs.credits))))
            && ((this.groupID == rhs.groupID) || ((this.groupID != null) && this.groupID.equals(rhs.groupID))))
            && ((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name))))
            && ((this.artifactID == rhs.artifactID)
                || ((this.artifactID != null) && this.artifactID.equals(rhs.artifactID))))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.version == rhs.version) || ((this.version != null) && this.version.equals(rhs.version))));
    }

}
