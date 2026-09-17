
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
    "JAVA_HOME",
    "SERVER_LOG_ROOT",
    "WAS_SERVER_NAME",
    "WEB_INSTALL_ROOT"
})
@Generated("jsonschema2pojo")
public class ServerVariables {

    @JsonProperty("JAVA_HOME")
    private String javaHome;
    @JsonProperty("SERVER_LOG_ROOT")
    private String serverLogRoot;
    @JsonProperty("WAS_SERVER_NAME")
    private String wasServerName;
    @JsonProperty("WEB_INSTALL_ROOT")
    private String webInstallRoot;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("JAVA_HOME")
    public String getJavaHome() {
        return javaHome;
    }

    @JsonProperty("JAVA_HOME")
    public void setJavaHome(String javaHome) {
        this.javaHome = javaHome;
    }

    @JsonProperty("SERVER_LOG_ROOT")
    public String getServerLogRoot() {
        return serverLogRoot;
    }

    @JsonProperty("SERVER_LOG_ROOT")
    public void setServerLogRoot(String serverLogRoot) {
        this.serverLogRoot = serverLogRoot;
    }

    @JsonProperty("WAS_SERVER_NAME")
    public String getWasServerName() {
        return wasServerName;
    }

    @JsonProperty("WAS_SERVER_NAME")
    public void setWasServerName(String wasServerName) {
        this.wasServerName = wasServerName;
    }

    @JsonProperty("WEB_INSTALL_ROOT")
    public String getWebInstallRoot() {
        return webInstallRoot;
    }

    @JsonProperty("WEB_INSTALL_ROOT")
    public void setWebInstallRoot(String webInstallRoot) {
        this.webInstallRoot = webInstallRoot;
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
        sb.append(ServerVariables.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("javaHome");
        sb.append('=');
        sb.append(((this.javaHome == null)?"<null>":this.javaHome));
        sb.append(',');
        sb.append("serverLogRoot");
        sb.append('=');
        sb.append(((this.serverLogRoot == null)?"<null>":this.serverLogRoot));
        sb.append(',');
        sb.append("wasServerName");
        sb.append('=');
        sb.append(((this.wasServerName == null)?"<null>":this.wasServerName));
        sb.append(',');
        sb.append("webInstallRoot");
        sb.append('=');
        sb.append(((this.webInstallRoot == null)?"<null>":this.webInstallRoot));
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
        result = ((result* 31)+((this.webInstallRoot == null)? 0 :this.webInstallRoot.hashCode()));
        result = ((result* 31)+((this.wasServerName == null)? 0 :this.wasServerName.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.serverLogRoot == null)? 0 :this.serverLogRoot.hashCode()));
        result = ((result* 31)+((this.javaHome == null)? 0 :this.javaHome.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ServerVariables) == false) {
            return false;
        }
        ServerVariables rhs = ((ServerVariables) other);
        return ((((((this.webInstallRoot == rhs.webInstallRoot)||((this.webInstallRoot!= null)&&this.webInstallRoot.equals(rhs.webInstallRoot)))&&((this.wasServerName == rhs.wasServerName)||((this.wasServerName!= null)&&this.wasServerName.equals(rhs.wasServerName))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.serverLogRoot == rhs.serverLogRoot)||((this.serverLogRoot!= null)&&this.serverLogRoot.equals(rhs.serverLogRoot))))&&((this.javaHome == rhs.javaHome)||((this.javaHome!= null)&&this.javaHome.equals(rhs.javaHome))));
    }

}
