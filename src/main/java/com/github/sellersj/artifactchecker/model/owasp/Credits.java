
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
@JsonPropertyOrder({"NVD", "NPM", "RETIREJS", "OSSINDEX"})
public class Credits {

    @JsonProperty("NVD")
    private String nvd;

    @JsonProperty("NPM")
    private String npm;

    @JsonProperty("RETIREJS")
    private String retirejs;

    @JsonProperty("OSSINDEX")
    private String ossindex;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("NVD")
    public String getNvd() {
        return nvd;
    }

    @JsonProperty("NVD")
    public void setNvd(String nvd) {
        this.nvd = nvd;
    }

    @JsonProperty("NPM")
    public String getNpm() {
        return npm;
    }

    @JsonProperty("NPM")
    public void setNpm(String npm) {
        this.npm = npm;
    }

    @JsonProperty("RETIREJS")
    public String getRetirejs() {
        return retirejs;
    }

    @JsonProperty("RETIREJS")
    public void setRetirejs(String retirejs) {
        this.retirejs = retirejs;
    }

    @JsonProperty("OSSINDEX")
    public String getOssindex() {
        return ossindex;
    }

    @JsonProperty("OSSINDEX")
    public void setOssindex(String ossindex) {
        this.ossindex = ossindex;
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
        sb.append(Credits.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("nvd");
        sb.append('=');
        sb.append(((this.nvd == null) ? "<null>" : this.nvd));
        sb.append(',');
        sb.append("npm");
        sb.append('=');
        sb.append(((this.npm == null) ? "<null>" : this.npm));
        sb.append(',');
        sb.append("retirejs");
        sb.append('=');
        sb.append(((this.retirejs == null) ? "<null>" : this.retirejs));
        sb.append(',');
        sb.append("ossindex");
        sb.append('=');
        sb.append(((this.ossindex == null) ? "<null>" : this.ossindex));
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
        result = ((result * 31) + ((this.npm == null) ? 0 : this.npm.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.ossindex == null) ? 0 : this.ossindex.hashCode()));
        result = ((result * 31) + ((this.nvd == null) ? 0 : this.nvd.hashCode()));
        result = ((result * 31) + ((this.retirejs == null) ? 0 : this.retirejs.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Credits) == false) {
            return false;
        }
        Credits rhs = ((Credits) other);
        return ((((((this.npm == rhs.npm) || ((this.npm != null) && this.npm.equals(rhs.npm)))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.ossindex == rhs.ossindex) || ((this.ossindex != null) && this.ossindex.equals(rhs.ossindex))))
            && ((this.nvd == rhs.nvd) || ((this.nvd != null) && this.nvd.equals(rhs.nvd))))
            && ((this.retirejs == rhs.retirejs) || ((this.retirejs != null) && this.retirejs.equals(rhs.retirejs))));
    }

}
