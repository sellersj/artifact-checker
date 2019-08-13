
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
@JsonPropertyOrder({"filePath", "sha256", "sha1", "md5", "identifiers", "isVirtual"})
public class Properties__11 {

    @JsonProperty("filePath")
    private FilePath filePath;

    @JsonProperty("sha256")
    private Sha256 sha256;

    @JsonProperty("sha1")
    private Sha1 sha1;

    @JsonProperty("md5")
    private Md5 md5;

    @JsonProperty("identifiers")
    private Identifiers identifiers;

    @JsonProperty("isVirtual")
    private IsVirtual isVirtual;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("filePath")
    public FilePath getFilePath() {
        return filePath;
    }

    @JsonProperty("filePath")
    public void setFilePath(FilePath filePath) {
        this.filePath = filePath;
    }

    @JsonProperty("sha256")
    public Sha256 getSha256() {
        return sha256;
    }

    @JsonProperty("sha256")
    public void setSha256(Sha256 sha256) {
        this.sha256 = sha256;
    }

    @JsonProperty("sha1")
    public Sha1 getSha1() {
        return sha1;
    }

    @JsonProperty("sha1")
    public void setSha1(Sha1 sha1) {
        this.sha1 = sha1;
    }

    @JsonProperty("md5")
    public Md5 getMd5() {
        return md5;
    }

    @JsonProperty("md5")
    public void setMd5(Md5 md5) {
        this.md5 = md5;
    }

    @JsonProperty("identifiers")
    public Identifiers getIdentifiers() {
        return identifiers;
    }

    @JsonProperty("identifiers")
    public void setIdentifiers(Identifiers identifiers) {
        this.identifiers = identifiers;
    }

    @JsonProperty("isVirtual")
    public IsVirtual getIsVirtual() {
        return isVirtual;
    }

    @JsonProperty("isVirtual")
    public void setIsVirtual(IsVirtual isVirtual) {
        this.isVirtual = isVirtual;
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
        sb.append(Properties__11.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("filePath");
        sb.append('=');
        sb.append(((this.filePath == null) ? "<null>" : this.filePath));
        sb.append(',');
        sb.append("sha256");
        sb.append('=');
        sb.append(((this.sha256 == null) ? "<null>" : this.sha256));
        sb.append(',');
        sb.append("sha1");
        sb.append('=');
        sb.append(((this.sha1 == null) ? "<null>" : this.sha1));
        sb.append(',');
        sb.append("md5");
        sb.append('=');
        sb.append(((this.md5 == null) ? "<null>" : this.md5));
        sb.append(',');
        sb.append("identifiers");
        sb.append('=');
        sb.append(((this.identifiers == null) ? "<null>" : this.identifiers));
        sb.append(',');
        sb.append("isVirtual");
        sb.append('=');
        sb.append(((this.isVirtual == null) ? "<null>" : this.isVirtual));
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
        result = ((result * 31) + ((this.sha1 == null) ? 0 : this.sha1.hashCode()));
        result = ((result * 31) + ((this.sha256 == null) ? 0 : this.sha256.hashCode()));
        result = ((result * 31) + ((this.identifiers == null) ? 0 : this.identifiers.hashCode()));
        result = ((result * 31) + ((this.filePath == null) ? 0 : this.filePath.hashCode()));
        result = ((result * 31) + ((this.isVirtual == null) ? 0 : this.isVirtual.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.md5 == null) ? 0 : this.md5.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Properties__11) == false) {
            return false;
        }
        Properties__11 rhs = ((Properties__11) other);
        return ((((((((this.sha1 == rhs.sha1) || ((this.sha1 != null) && this.sha1.equals(rhs.sha1)))
            && ((this.sha256 == rhs.sha256) || ((this.sha256 != null) && this.sha256.equals(rhs.sha256))))
            && ((this.identifiers == rhs.identifiers)
                || ((this.identifiers != null) && this.identifiers.equals(rhs.identifiers))))
            && ((this.filePath == rhs.filePath) || ((this.filePath != null) && this.filePath.equals(rhs.filePath))))
            && ((this.isVirtual == rhs.isVirtual)
                || ((this.isVirtual != null) && this.isVirtual.equals(rhs.isVirtual))))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.md5 == rhs.md5) || ((this.md5 != null) && this.md5.equals(rhs.md5))));
    }

}
