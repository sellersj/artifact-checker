
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
    "driverClass",
    "jarFile",
    "mainClassOutput",
    "manifestVersion",
    "matchesProd",
    "pathToJarInWas",
    "prod",
    "version",
    "was8"
})
@Generated("jsonschema2pojo")
public class AllEnvsDatadriver {

    @JsonProperty("consoleHost")
    private String consoleHost;
    @JsonProperty("consoleVersion")
    private String consoleVersion;
    @JsonProperty("driverClass")
    private String driverClass;
    @JsonProperty("jarFile")
    private String jarFile;
    @JsonProperty("mainClassOutput")
    private String mainClassOutput;
    @JsonProperty("manifestVersion")
    private String manifestVersion;
    @JsonProperty("matchesProd")
    private Boolean matchesProd;
    @JsonProperty("pathToJarInWas")
    private String pathToJarInWas;
    @JsonProperty("prod")
    private Boolean prod;
    @JsonProperty("version")
    private String version;
    @JsonProperty("was8")
    private Boolean was8;
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

    @JsonProperty("driverClass")
    public String getDriverClass() {
        return driverClass;
    }

    @JsonProperty("driverClass")
    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    @JsonProperty("jarFile")
    public String getJarFile() {
        return jarFile;
    }

    @JsonProperty("jarFile")
    public void setJarFile(String jarFile) {
        this.jarFile = jarFile;
    }

    @JsonProperty("mainClassOutput")
    public String getMainClassOutput() {
        return mainClassOutput;
    }

    @JsonProperty("mainClassOutput")
    public void setMainClassOutput(String mainClassOutput) {
        this.mainClassOutput = mainClassOutput;
    }

    @JsonProperty("manifestVersion")
    public String getManifestVersion() {
        return manifestVersion;
    }

    @JsonProperty("manifestVersion")
    public void setManifestVersion(String manifestVersion) {
        this.manifestVersion = manifestVersion;
    }

    @JsonProperty("matchesProd")
    public Boolean getMatchesProd() {
        return matchesProd;
    }

    @JsonProperty("matchesProd")
    public void setMatchesProd(Boolean matchesProd) {
        this.matchesProd = matchesProd;
    }

    @JsonProperty("pathToJarInWas")
    public String getPathToJarInWas() {
        return pathToJarInWas;
    }

    @JsonProperty("pathToJarInWas")
    public void setPathToJarInWas(String pathToJarInWas) {
        this.pathToJarInWas = pathToJarInWas;
    }

    @JsonProperty("prod")
    public Boolean getProd() {
        return prod;
    }

    @JsonProperty("prod")
    public void setProd(Boolean prod) {
        this.prod = prod;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("was8")
    public Boolean getWas8() {
        return was8;
    }

    @JsonProperty("was8")
    public void setWas8(Boolean was8) {
        this.was8 = was8;
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
        sb.append(AllEnvsDatadriver.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("consoleHost");
        sb.append('=');
        sb.append(((this.consoleHost == null)?"<null>":this.consoleHost));
        sb.append(',');
        sb.append("consoleVersion");
        sb.append('=');
        sb.append(((this.consoleVersion == null)?"<null>":this.consoleVersion));
        sb.append(',');
        sb.append("driverClass");
        sb.append('=');
        sb.append(((this.driverClass == null)?"<null>":this.driverClass));
        sb.append(',');
        sb.append("jarFile");
        sb.append('=');
        sb.append(((this.jarFile == null)?"<null>":this.jarFile));
        sb.append(',');
        sb.append("mainClassOutput");
        sb.append('=');
        sb.append(((this.mainClassOutput == null)?"<null>":this.mainClassOutput));
        sb.append(',');
        sb.append("manifestVersion");
        sb.append('=');
        sb.append(((this.manifestVersion == null)?"<null>":this.manifestVersion));
        sb.append(',');
        sb.append("matchesProd");
        sb.append('=');
        sb.append(((this.matchesProd == null)?"<null>":this.matchesProd));
        sb.append(',');
        sb.append("pathToJarInWas");
        sb.append('=');
        sb.append(((this.pathToJarInWas == null)?"<null>":this.pathToJarInWas));
        sb.append(',');
        sb.append("prod");
        sb.append('=');
        sb.append(((this.prod == null)?"<null>":this.prod));
        sb.append(',');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null)?"<null>":this.version));
        sb.append(',');
        sb.append("was8");
        sb.append('=');
        sb.append(((this.was8 == null)?"<null>":this.was8));
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
        result = ((result* 31)+((this.prod == null)? 0 :this.prod.hashCode()));
        result = ((result* 31)+((this.jarFile == null)? 0 :this.jarFile.hashCode()));
        result = ((result* 31)+((this.manifestVersion == null)? 0 :this.manifestVersion.hashCode()));
        result = ((result* 31)+((this.driverClass == null)? 0 :this.driverClass.hashCode()));
        result = ((result* 31)+((this.mainClassOutput == null)? 0 :this.mainClassOutput.hashCode()));
        result = ((result* 31)+((this.consoleHost == null)? 0 :this.consoleHost.hashCode()));
        result = ((result* 31)+((this.pathToJarInWas == null)? 0 :this.pathToJarInWas.hashCode()));
        result = ((result* 31)+((this.was8 == null)? 0 :this.was8 .hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.matchesProd == null)? 0 :this.matchesProd.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AllEnvsDatadriver) == false) {
            return false;
        }
        AllEnvsDatadriver rhs = ((AllEnvsDatadriver) other);
        return (((((((((((((this.consoleVersion == rhs.consoleVersion)||((this.consoleVersion!= null)&&this.consoleVersion.equals(rhs.consoleVersion)))&&((this.prod == rhs.prod)||((this.prod!= null)&&this.prod.equals(rhs.prod))))&&((this.jarFile == rhs.jarFile)||((this.jarFile!= null)&&this.jarFile.equals(rhs.jarFile))))&&((this.manifestVersion == rhs.manifestVersion)||((this.manifestVersion!= null)&&this.manifestVersion.equals(rhs.manifestVersion))))&&((this.driverClass == rhs.driverClass)||((this.driverClass!= null)&&this.driverClass.equals(rhs.driverClass))))&&((this.mainClassOutput == rhs.mainClassOutput)||((this.mainClassOutput!= null)&&this.mainClassOutput.equals(rhs.mainClassOutput))))&&((this.consoleHost == rhs.consoleHost)||((this.consoleHost!= null)&&this.consoleHost.equals(rhs.consoleHost))))&&((this.pathToJarInWas == rhs.pathToJarInWas)||((this.pathToJarInWas!= null)&&this.pathToJarInWas.equals(rhs.pathToJarInWas))))&&((this.was8 == rhs.was8)||((this.was8 != null)&&this.was8 .equals(rhs.was8))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.matchesProd == rhs.matchesProd)||((this.matchesProd!= null)&&this.matchesProd.equals(rhs.matchesProd))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))));
    }

}
