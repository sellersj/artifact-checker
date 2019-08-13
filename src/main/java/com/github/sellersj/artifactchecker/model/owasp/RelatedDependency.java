
package com.github.sellersj.artifactchecker.model.owasp;

import java.util.ArrayList;
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
@JsonPropertyOrder({"isVirtual", "filePath", "sha256", "sha1", "md5", "packageIds"})
public class RelatedDependency {

    @JsonProperty("isVirtual")
    private Boolean isVirtual;

    @JsonProperty("filePath")
    private String filePath;

    @JsonProperty("sha256")
    private String sha256;

    @JsonProperty("sha1")
    private String sha1;

    @JsonProperty("md5")
    private String md5;

    @JsonProperty("packageIds")
    private List<PackageId> packageIds = new ArrayList<PackageId>();

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("isVirtual")
    public Boolean getIsVirtual() {
        return isVirtual;
    }

    @JsonProperty("isVirtual")
    public void setIsVirtual(Boolean isVirtual) {
        this.isVirtual = isVirtual;
    }

    @JsonProperty("filePath")
    public String getFilePath() {
        return filePath;
    }

    @JsonProperty("filePath")
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @JsonProperty("sha256")
    public String getSha256() {
        return sha256;
    }

    @JsonProperty("sha256")
    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }

    @JsonProperty("sha1")
    public String getSha1() {
        return sha1;
    }

    @JsonProperty("sha1")
    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    @JsonProperty("md5")
    public String getMd5() {
        return md5;
    }

    @JsonProperty("md5")
    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @JsonProperty("packageIds")
    public List<PackageId> getPackageIds() {
        return packageIds;
    }

    @JsonProperty("packageIds")
    public void setPackageIds(List<PackageId> packageIds) {
        this.packageIds = packageIds;
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
        sb.append(RelatedDependency.class.getName()).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("isVirtual");
        sb.append('=');
        sb.append(((this.isVirtual == null) ? "<null>" : this.isVirtual));
        sb.append(',');
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
        sb.append("packageIds");
        sb.append('=');
        sb.append(((this.packageIds == null) ? "<null>" : this.packageIds));
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
        result = ((result * 31) + ((this.filePath == null) ? 0 : this.filePath.hashCode()));
        result = ((result * 31) + ((this.isVirtual == null) ? 0 : this.isVirtual.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.packageIds == null) ? 0 : this.packageIds.hashCode()));
        result = ((result * 31) + ((this.md5 == null) ? 0 : this.md5.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RelatedDependency) == false) {
            return false;
        }
        RelatedDependency rhs = ((RelatedDependency) other);
        return ((((((((this.sha1 == rhs.sha1) || ((this.sha1 != null) && this.sha1.equals(rhs.sha1)))
            && ((this.sha256 == rhs.sha256) || ((this.sha256 != null) && this.sha256.equals(rhs.sha256))))
            && ((this.filePath == rhs.filePath) || ((this.filePath != null) && this.filePath.equals(rhs.filePath))))
            && ((this.isVirtual == rhs.isVirtual)
                || ((this.isVirtual != null) && this.isVirtual.equals(rhs.isVirtual))))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.packageIds == rhs.packageIds)
                || ((this.packageIds != null) && this.packageIds.equals(rhs.packageIds))))
            && ((this.md5 == rhs.md5) || ((this.md5 != null) && this.md5.equals(rhs.md5))));
    }

}
