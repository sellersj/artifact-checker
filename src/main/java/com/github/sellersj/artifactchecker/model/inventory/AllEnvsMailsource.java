
package com.github.sellersj.artifactchecker.model.inventory;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "consoleHost",
    "consoleVersion",
    "jndiName",
    "mailFrom",
    "mailStoreUser",
    "mailTransportHost",
    "name",
    "prod",
    "properties"
})
@Generated("jsonschema2pojo")
public class AllEnvsMailsource {

    @JsonProperty("consoleHost")
    private String consoleHost;
    @JsonProperty("consoleVersion")
    private String consoleVersion;
    @JsonProperty("jndiName")
    private String jndiName;
    @JsonProperty("mailFrom")
    private String mailFrom;
    @JsonProperty("mailStoreUser")
    private String mailStoreUser;
    @JsonProperty("mailTransportHost")
    private String mailTransportHost;
    @JsonProperty("name")
    private String name;
    @JsonProperty("prod")
    private Boolean prod;
    @JsonProperty("properties")
    private Properties__1 properties;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("consoleHost")
    public String getConsoleHost() {
        return consoleHost;
    }

    @JsonProperty("consoleHost")
    public void setConsoleHost(String consoleHost) {
        this.consoleHost = consoleHost;
    }

    @JsonProperty("consoleVersion")
    public String getConsoleVersion() {
        return consoleVersion;
    }

    @JsonProperty("consoleVersion")
    public void setConsoleVersion(String consoleVersion) {
        this.consoleVersion = consoleVersion;
    }

    @JsonProperty("jndiName")
    public String getJndiName() {
        return jndiName;
    }

    @JsonProperty("jndiName")
    public void setJndiName(String jndiName) {
        this.jndiName = jndiName;
    }

    @JsonProperty("mailFrom")
    public String getMailFrom() {
        return mailFrom;
    }

    @JsonProperty("mailFrom")
    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    @JsonProperty("mailStoreUser")
    public String getMailStoreUser() {
        return mailStoreUser;
    }

    @JsonProperty("mailStoreUser")
    public void setMailStoreUser(String mailStoreUser) {
        this.mailStoreUser = mailStoreUser;
    }

    @JsonProperty("mailTransportHost")
    public String getMailTransportHost() {
        return mailTransportHost;
    }

    @JsonProperty("mailTransportHost")
    public void setMailTransportHost(String mailTransportHost) {
        this.mailTransportHost = mailTransportHost;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("prod")
    public Boolean getProd() {
        return prod;
    }

    @JsonProperty("prod")
    public void setProd(Boolean prod) {
        this.prod = prod;
    }

    @JsonProperty("properties")
    public Properties__1 getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Properties__1 properties) {
        this.properties = properties;
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
        sb.append(AllEnvsMailsource.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("consoleHost");
        sb.append('=');
        sb.append(((this.consoleHost == null)?"<null>":this.consoleHost));
        sb.append(',');
        sb.append("consoleVersion");
        sb.append('=');
        sb.append(((this.consoleVersion == null)?"<null>":this.consoleVersion));
        sb.append(',');
        sb.append("jndiName");
        sb.append('=');
        sb.append(((this.jndiName == null)?"<null>":this.jndiName));
        sb.append(',');
        sb.append("mailFrom");
        sb.append('=');
        sb.append(((this.mailFrom == null)?"<null>":this.mailFrom));
        sb.append(',');
        sb.append("mailStoreUser");
        sb.append('=');
        sb.append(((this.mailStoreUser == null)?"<null>":this.mailStoreUser));
        sb.append(',');
        sb.append("mailTransportHost");
        sb.append('=');
        sb.append(((this.mailTransportHost == null)?"<null>":this.mailTransportHost));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("prod");
        sb.append('=');
        sb.append(((this.prod == null)?"<null>":this.prod));
        sb.append(',');
        sb.append("properties");
        sb.append('=');
        sb.append(((this.properties == null)?"<null>":this.properties));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.consoleVersion == null)? 0 :this.consoleVersion.hashCode()));
        result = ((result* 31)+((this.mailTransportHost == null)? 0 :this.mailTransportHost.hashCode()));
        result = ((result* 31)+((this.prod == null)? 0 :this.prod.hashCode()));
        result = ((result* 31)+((this.consoleHost == null)? 0 :this.consoleHost.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.mailStoreUser == null)? 0 :this.mailStoreUser.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.mailFrom == null)? 0 :this.mailFrom.hashCode()));
        result = ((result* 31)+((this.properties == null)? 0 :this.properties.hashCode()));
        result = ((result* 31)+((this.jndiName == null)? 0 :this.jndiName.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AllEnvsMailsource) == false) {
            return false;
        }
        AllEnvsMailsource rhs = ((AllEnvsMailsource) other);
        return (((((((((((this.consoleVersion == rhs.consoleVersion)||((this.consoleVersion!= null)&&this.consoleVersion.equals(rhs.consoleVersion)))&&((this.mailTransportHost == rhs.mailTransportHost)||((this.mailTransportHost!= null)&&this.mailTransportHost.equals(rhs.mailTransportHost))))&&((this.prod == rhs.prod)||((this.prod!= null)&&this.prod.equals(rhs.prod))))&&((this.consoleHost == rhs.consoleHost)||((this.consoleHost!= null)&&this.consoleHost.equals(rhs.consoleHost))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.mailStoreUser == rhs.mailStoreUser)||((this.mailStoreUser!= null)&&this.mailStoreUser.equals(rhs.mailStoreUser))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.mailFrom == rhs.mailFrom)||((this.mailFrom!= null)&&this.mailFrom.equals(rhs.mailFrom))))&&((this.properties == rhs.properties)||((this.properties!= null)&&this.properties.equals(rhs.properties))))&&((this.jndiName == rhs.jndiName)||((this.jndiName!= null)&&this.jndiName.equals(rhs.jndiName))));
    }

}
