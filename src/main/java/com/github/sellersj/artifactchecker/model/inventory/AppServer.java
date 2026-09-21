
package com.github.sellersj.artifactchecker.model.inventory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    "appServer",
    "applicationClassLoadingMode",
    "cell",
    "clusterName",
    "consoleHost",
    "consoleVersion",
    "deploymentNames",
    "deploymentNamesAsString",
    "deploymentNamesSize",
    "genericJvmArguments",
    "genericJvmArgumentsMatchClusterMembers",
    "hostName",
    "javaMajorVersion",
    "name",
    "node",
    "prod",
    "serverVariables",
    "sessionPersistenceMode",
    "sessionPersistenceModeConsistentInCluster",
    "systemPropertyNames",
    "systemPropertyNamesAsString",
    "systemPropertyNamesThatDoNotExistInProd",
    "systemPropsMatchClusterMembers",
    "useContextRootAsPath",
    "useContextRootAsPathConsistentInCluster"
})
@Generated("jsonschema2pojo")
public class AppServer {

    @JsonProperty("appServer")
    private Boolean appServer;
    @JsonProperty("applicationClassLoadingMode")
    private String applicationClassLoadingMode;
    @JsonProperty("cell")
    private String cell;
    @JsonProperty("clusterName")
    private String clusterName;
    @JsonProperty("consoleHost")
    private String consoleHost;
    @JsonProperty("consoleVersion")
    private String consoleVersion;
    @JsonProperty("deploymentNames")
    private List<String> deploymentNames = new ArrayList<String>();
    @JsonProperty("deploymentNamesAsString")
    private String deploymentNamesAsString;
    @JsonProperty("deploymentNamesSize")
    private Integer deploymentNamesSize;
    @JsonProperty("genericJvmArguments")
    private String genericJvmArguments;
    @JsonProperty("genericJvmArgumentsMatchClusterMembers")
    private Boolean genericJvmArgumentsMatchClusterMembers;
    @JsonProperty("hostName")
    private String hostName;
    @JsonProperty("javaMajorVersion")
    private String javaMajorVersion;
    @JsonProperty("name")
    private String name;
    @JsonProperty("node")
    private String node;
    @JsonProperty("prod")
    private Boolean prod;
    @JsonProperty("serverVariables")
    private ServerVariables serverVariables;
    @JsonProperty("sessionPersistenceMode")
    private String sessionPersistenceMode;
    @JsonProperty("sessionPersistenceModeConsistentInCluster")
    private Boolean sessionPersistenceModeConsistentInCluster;
    @JsonProperty("systemPropertyNames")
    private List<String> systemPropertyNames = new ArrayList<String>();
    @JsonProperty("systemPropertyNamesAsString")
    private String systemPropertyNamesAsString;
    @JsonProperty("systemPropertyNamesThatDoNotExistInProd")
    private List<String> systemPropertyNamesThatDoNotExistInProd = new ArrayList<String>();
    @JsonProperty("systemPropsMatchClusterMembers")
    private Boolean systemPropsMatchClusterMembers;
    @JsonProperty("useContextRootAsPath")
    private Boolean useContextRootAsPath;
    @JsonProperty("useContextRootAsPathConsistentInCluster")
    private Boolean useContextRootAsPathConsistentInCluster;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("appServer")
    public Boolean getAppServer() {
        return appServer;
    }

    @JsonProperty("appServer")
    public void setAppServer(Boolean appServer) {
        this.appServer = appServer;
    }

    @JsonProperty("applicationClassLoadingMode")
    public String getApplicationClassLoadingMode() {
        return applicationClassLoadingMode;
    }

    @JsonProperty("applicationClassLoadingMode")
    public void setApplicationClassLoadingMode(String applicationClassLoadingMode) {
        this.applicationClassLoadingMode = applicationClassLoadingMode;
    }

    @JsonProperty("cell")
    public String getCell() {
        return cell;
    }

    @JsonProperty("cell")
    public void setCell(String cell) {
        this.cell = cell;
    }

    @JsonProperty("clusterName")
    public String getClusterName() {
        return clusterName;
    }

    @JsonProperty("clusterName")
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

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

    @JsonProperty("deploymentNames")
    public List<String> getDeploymentNames() {
        return deploymentNames;
    }

    @JsonProperty("deploymentNames")
    public void setDeploymentNames(List<String> deploymentNames) {
        this.deploymentNames = deploymentNames;
    }

    @JsonProperty("deploymentNamesAsString")
    public String getDeploymentNamesAsString() {
        return deploymentNamesAsString;
    }

    @JsonProperty("deploymentNamesAsString")
    public void setDeploymentNamesAsString(String deploymentNamesAsString) {
        this.deploymentNamesAsString = deploymentNamesAsString;
    }

    @JsonProperty("deploymentNamesSize")
    public Integer getDeploymentNamesSize() {
        return deploymentNamesSize;
    }

    @JsonProperty("deploymentNamesSize")
    public void setDeploymentNamesSize(Integer deploymentNamesSize) {
        this.deploymentNamesSize = deploymentNamesSize;
    }

    @JsonProperty("genericJvmArguments")
    public String getGenericJvmArguments() {
        return genericJvmArguments;
    }

    @JsonProperty("genericJvmArguments")
    public void setGenericJvmArguments(String genericJvmArguments) {
        this.genericJvmArguments = genericJvmArguments;
    }

    @JsonProperty("genericJvmArgumentsMatchClusterMembers")
    public Boolean getGenericJvmArgumentsMatchClusterMembers() {
        return genericJvmArgumentsMatchClusterMembers;
    }

    @JsonProperty("genericJvmArgumentsMatchClusterMembers")
    public void setGenericJvmArgumentsMatchClusterMembers(Boolean genericJvmArgumentsMatchClusterMembers) {
        this.genericJvmArgumentsMatchClusterMembers = genericJvmArgumentsMatchClusterMembers;
    }

    @JsonProperty("hostName")
    public String getHostName() {
        return hostName;
    }

    @JsonProperty("hostName")
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    @JsonProperty("javaMajorVersion")
    public String getJavaMajorVersion() {
        return javaMajorVersion;
    }

    @JsonProperty("javaMajorVersion")
    public void setJavaMajorVersion(String javaMajorVersion) {
        this.javaMajorVersion = javaMajorVersion;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("node")
    public String getNode() {
        return node;
    }

    @JsonProperty("node")
    public void setNode(String node) {
        this.node = node;
    }

    @JsonProperty("prod")
    public Boolean getProd() {
        return prod;
    }

    @JsonProperty("prod")
    public void setProd(Boolean prod) {
        this.prod = prod;
    }

    @JsonProperty("serverVariables")
    public ServerVariables getServerVariables() {
        return serverVariables;
    }

    @JsonProperty("serverVariables")
    public void setServerVariables(ServerVariables serverVariables) {
        this.serverVariables = serverVariables;
    }

    @JsonProperty("sessionPersistenceMode")
    public String getSessionPersistenceMode() {
        return sessionPersistenceMode;
    }

    @JsonProperty("sessionPersistenceMode")
    public void setSessionPersistenceMode(String sessionPersistenceMode) {
        this.sessionPersistenceMode = sessionPersistenceMode;
    }

    @JsonProperty("sessionPersistenceModeConsistentInCluster")
    public Boolean getSessionPersistenceModeConsistentInCluster() {
        return sessionPersistenceModeConsistentInCluster;
    }

    @JsonProperty("sessionPersistenceModeConsistentInCluster")
    public void setSessionPersistenceModeConsistentInCluster(Boolean sessionPersistenceModeConsistentInCluster) {
        this.sessionPersistenceModeConsistentInCluster = sessionPersistenceModeConsistentInCluster;
    }

    @JsonProperty("systemPropertyNames")
    public List<String> getSystemPropertyNames() {
        return systemPropertyNames;
    }

    @JsonProperty("systemPropertyNames")
    public void setSystemPropertyNames(List<String> systemPropertyNames) {
        this.systemPropertyNames = systemPropertyNames;
    }

    @JsonProperty("systemPropertyNamesAsString")
    public String getSystemPropertyNamesAsString() {
        return systemPropertyNamesAsString;
    }

    @JsonProperty("systemPropertyNamesAsString")
    public void setSystemPropertyNamesAsString(String systemPropertyNamesAsString) {
        this.systemPropertyNamesAsString = systemPropertyNamesAsString;
    }

    @JsonProperty("systemPropertyNamesThatDoNotExistInProd")
    public List<String> getSystemPropertyNamesThatDoNotExistInProd() {
        return systemPropertyNamesThatDoNotExistInProd;
    }

    @JsonProperty("systemPropertyNamesThatDoNotExistInProd")
    public void setSystemPropertyNamesThatDoNotExistInProd(List<String> systemPropertyNamesThatDoNotExistInProd) {
        this.systemPropertyNamesThatDoNotExistInProd = systemPropertyNamesThatDoNotExistInProd;
    }

    @JsonProperty("systemPropsMatchClusterMembers")
    public Boolean getSystemPropsMatchClusterMembers() {
        return systemPropsMatchClusterMembers;
    }

    @JsonProperty("systemPropsMatchClusterMembers")
    public void setSystemPropsMatchClusterMembers(Boolean systemPropsMatchClusterMembers) {
        this.systemPropsMatchClusterMembers = systemPropsMatchClusterMembers;
    }

    @JsonProperty("useContextRootAsPath")
    public Boolean getUseContextRootAsPath() {
        return useContextRootAsPath;
    }

    @JsonProperty("useContextRootAsPath")
    public void setUseContextRootAsPath(Boolean useContextRootAsPath) {
        this.useContextRootAsPath = useContextRootAsPath;
    }

    @JsonProperty("useContextRootAsPathConsistentInCluster")
    public Boolean getUseContextRootAsPathConsistentInCluster() {
        return useContextRootAsPathConsistentInCluster;
    }

    @JsonProperty("useContextRootAsPathConsistentInCluster")
    public void setUseContextRootAsPathConsistentInCluster(Boolean useContextRootAsPathConsistentInCluster) {
        this.useContextRootAsPathConsistentInCluster = useContextRootAsPathConsistentInCluster;
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
        sb.append(AppServer.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("appServer");
        sb.append('=');
        sb.append(((this.appServer == null)?"<null>":this.appServer));
        sb.append(',');
        sb.append("applicationClassLoadingMode");
        sb.append('=');
        sb.append(((this.applicationClassLoadingMode == null)?"<null>":this.applicationClassLoadingMode));
        sb.append(',');
        sb.append("cell");
        sb.append('=');
        sb.append(((this.cell == null)?"<null>":this.cell));
        sb.append(',');
        sb.append("clusterName");
        sb.append('=');
        sb.append(((this.clusterName == null)?"<null>":this.clusterName));
        sb.append(',');
        sb.append("consoleHost");
        sb.append('=');
        sb.append(((this.consoleHost == null)?"<null>":this.consoleHost));
        sb.append(',');
        sb.append("consoleVersion");
        sb.append('=');
        sb.append(((this.consoleVersion == null)?"<null>":this.consoleVersion));
        sb.append(',');
        sb.append("deploymentNames");
        sb.append('=');
        sb.append(((this.deploymentNames == null)?"<null>":this.deploymentNames));
        sb.append(',');
        sb.append("deploymentNamesAsString");
        sb.append('=');
        sb.append(((this.deploymentNamesAsString == null)?"<null>":this.deploymentNamesAsString));
        sb.append(',');
        sb.append("deploymentNamesSize");
        sb.append('=');
        sb.append(((this.deploymentNamesSize == null)?"<null>":this.deploymentNamesSize));
        sb.append(',');
        sb.append("genericJvmArguments");
        sb.append('=');
        sb.append(((this.genericJvmArguments == null)?"<null>":this.genericJvmArguments));
        sb.append(',');
        sb.append("genericJvmArgumentsMatchClusterMembers");
        sb.append('=');
        sb.append(((this.genericJvmArgumentsMatchClusterMembers == null)?"<null>":this.genericJvmArgumentsMatchClusterMembers));
        sb.append(',');
        sb.append("hostName");
        sb.append('=');
        sb.append(((this.hostName == null)?"<null>":this.hostName));
        sb.append(',');
        sb.append("javaMajorVersion");
        sb.append('=');
        sb.append(((this.javaMajorVersion == null)?"<null>":this.javaMajorVersion));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("node");
        sb.append('=');
        sb.append(((this.node == null)?"<null>":this.node));
        sb.append(',');
        sb.append("prod");
        sb.append('=');
        sb.append(((this.prod == null)?"<null>":this.prod));
        sb.append(',');
        sb.append("serverVariables");
        sb.append('=');
        sb.append(((this.serverVariables == null)?"<null>":this.serverVariables));
        sb.append(',');
        sb.append("sessionPersistenceMode");
        sb.append('=');
        sb.append(((this.sessionPersistenceMode == null)?"<null>":this.sessionPersistenceMode));
        sb.append(',');
        sb.append("sessionPersistenceModeConsistentInCluster");
        sb.append('=');
        sb.append(((this.sessionPersistenceModeConsistentInCluster == null)?"<null>":this.sessionPersistenceModeConsistentInCluster));
        sb.append(',');
        sb.append("systemPropertyNames");
        sb.append('=');
        sb.append(((this.systemPropertyNames == null)?"<null>":this.systemPropertyNames));
        sb.append(',');
        sb.append("systemPropertyNamesAsString");
        sb.append('=');
        sb.append(((this.systemPropertyNamesAsString == null)?"<null>":this.systemPropertyNamesAsString));
        sb.append(',');
        sb.append("systemPropertyNamesThatDoNotExistInProd");
        sb.append('=');
        sb.append(((this.systemPropertyNamesThatDoNotExistInProd == null)?"<null>":this.systemPropertyNamesThatDoNotExistInProd));
        sb.append(',');
        sb.append("systemPropsMatchClusterMembers");
        sb.append('=');
        sb.append(((this.systemPropsMatchClusterMembers == null)?"<null>":this.systemPropsMatchClusterMembers));
        sb.append(',');
        sb.append("useContextRootAsPath");
        sb.append('=');
        sb.append(((this.useContextRootAsPath == null)?"<null>":this.useContextRootAsPath));
        sb.append(',');
        sb.append("useContextRootAsPathConsistentInCluster");
        sb.append('=');
        sb.append(((this.useContextRootAsPathConsistentInCluster == null)?"<null>":this.useContextRootAsPathConsistentInCluster));
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
        result = ((result* 31)+((this.hostName == null)? 0 :this.hostName.hashCode()));
        result = ((result* 31)+((this.sessionPersistenceModeConsistentInCluster == null)? 0 :this.sessionPersistenceModeConsistentInCluster.hashCode()));
        result = ((result* 31)+((this.applicationClassLoadingMode == null)? 0 :this.applicationClassLoadingMode.hashCode()));
        result = ((result* 31)+((this.deploymentNamesSize == null)? 0 :this.deploymentNamesSize.hashCode()));
        result = ((result* 31)+((this.genericJvmArguments == null)? 0 :this.genericJvmArguments.hashCode()));
        result = ((result* 31)+((this.genericJvmArgumentsMatchClusterMembers == null)? 0 :this.genericJvmArgumentsMatchClusterMembers.hashCode()));
        result = ((result* 31)+((this.cell == null)? 0 :this.cell.hashCode()));
        result = ((result* 31)+((this.systemPropertyNames == null)? 0 :this.systemPropertyNames.hashCode()));
        result = ((result* 31)+((this.appServer == null)? 0 :this.appServer.hashCode()));
        result = ((result* 31)+((this.clusterName == null)? 0 :this.clusterName.hashCode()));
        result = ((result* 31)+((this.consoleVersion == null)? 0 :this.consoleVersion.hashCode()));
        result = ((result* 31)+((this.prod == null)? 0 :this.prod.hashCode()));
        result = ((result* 31)+((this.javaMajorVersion == null)? 0 :this.javaMajorVersion.hashCode()));
        result = ((result* 31)+((this.systemPropertyNamesThatDoNotExistInProd == null)? 0 :this.systemPropertyNamesThatDoNotExistInProd.hashCode()));
        result = ((result* 31)+((this.sessionPersistenceMode == null)? 0 :this.sessionPersistenceMode.hashCode()));
        result = ((result* 31)+((this.deploymentNames == null)? 0 :this.deploymentNames.hashCode()));
        result = ((result* 31)+((this.useContextRootAsPath == null)? 0 :this.useContextRootAsPath.hashCode()));
        result = ((result* 31)+((this.deploymentNamesAsString == null)? 0 :this.deploymentNamesAsString.hashCode()));
        result = ((result* 31)+((this.node == null)? 0 :this.node.hashCode()));
        result = ((result* 31)+((this.systemPropsMatchClusterMembers == null)? 0 :this.systemPropsMatchClusterMembers.hashCode()));
        result = ((result* 31)+((this.useContextRootAsPathConsistentInCluster == null)? 0 :this.useContextRootAsPathConsistentInCluster.hashCode()));
        result = ((result* 31)+((this.serverVariables == null)? 0 :this.serverVariables.hashCode()));
        result = ((result* 31)+((this.consoleHost == null)? 0 :this.consoleHost.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.systemPropertyNamesAsString == null)? 0 :this.systemPropertyNamesAsString.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AppServer) == false) {
            return false;
        }
        AppServer rhs = ((AppServer) other);
        return (((((((((((((((((((((((((((this.hostName == rhs.hostName)||((this.hostName!= null)&&this.hostName.equals(rhs.hostName)))&&((this.sessionPersistenceModeConsistentInCluster == rhs.sessionPersistenceModeConsistentInCluster)||((this.sessionPersistenceModeConsistentInCluster!= null)&&this.sessionPersistenceModeConsistentInCluster.equals(rhs.sessionPersistenceModeConsistentInCluster))))&&((this.applicationClassLoadingMode == rhs.applicationClassLoadingMode)||((this.applicationClassLoadingMode!= null)&&this.applicationClassLoadingMode.equals(rhs.applicationClassLoadingMode))))&&((this.deploymentNamesSize == rhs.deploymentNamesSize)||((this.deploymentNamesSize!= null)&&this.deploymentNamesSize.equals(rhs.deploymentNamesSize))))&&((this.genericJvmArguments == rhs.genericJvmArguments)||((this.genericJvmArguments!= null)&&this.genericJvmArguments.equals(rhs.genericJvmArguments))))&&((this.genericJvmArgumentsMatchClusterMembers == rhs.genericJvmArgumentsMatchClusterMembers)||((this.genericJvmArgumentsMatchClusterMembers!= null)&&this.genericJvmArgumentsMatchClusterMembers.equals(rhs.genericJvmArgumentsMatchClusterMembers))))&&((this.cell == rhs.cell)||((this.cell!= null)&&this.cell.equals(rhs.cell))))&&((this.systemPropertyNames == rhs.systemPropertyNames)||((this.systemPropertyNames!= null)&&this.systemPropertyNames.equals(rhs.systemPropertyNames))))&&((this.appServer == rhs.appServer)||((this.appServer!= null)&&this.appServer.equals(rhs.appServer))))&&((this.clusterName == rhs.clusterName)||((this.clusterName!= null)&&this.clusterName.equals(rhs.clusterName))))&&((this.consoleVersion == rhs.consoleVersion)||((this.consoleVersion!= null)&&this.consoleVersion.equals(rhs.consoleVersion))))&&((this.prod == rhs.prod)||((this.prod!= null)&&this.prod.equals(rhs.prod))))&&((this.javaMajorVersion == rhs.javaMajorVersion)||((this.javaMajorVersion!= null)&&this.javaMajorVersion.equals(rhs.javaMajorVersion))))&&((this.systemPropertyNamesThatDoNotExistInProd == rhs.systemPropertyNamesThatDoNotExistInProd)||((this.systemPropertyNamesThatDoNotExistInProd!= null)&&this.systemPropertyNamesThatDoNotExistInProd.equals(rhs.systemPropertyNamesThatDoNotExistInProd))))&&((this.sessionPersistenceMode == rhs.sessionPersistenceMode)||((this.sessionPersistenceMode!= null)&&this.sessionPersistenceMode.equals(rhs.sessionPersistenceMode))))&&((this.deploymentNames == rhs.deploymentNames)||((this.deploymentNames!= null)&&this.deploymentNames.equals(rhs.deploymentNames))))&&((this.useContextRootAsPath == rhs.useContextRootAsPath)||((this.useContextRootAsPath!= null)&&this.useContextRootAsPath.equals(rhs.useContextRootAsPath))))&&((this.deploymentNamesAsString == rhs.deploymentNamesAsString)||((this.deploymentNamesAsString!= null)&&this.deploymentNamesAsString.equals(rhs.deploymentNamesAsString))))&&((this.node == rhs.node)||((this.node!= null)&&this.node.equals(rhs.node))))&&((this.systemPropsMatchClusterMembers == rhs.systemPropsMatchClusterMembers)||((this.systemPropsMatchClusterMembers!= null)&&this.systemPropsMatchClusterMembers.equals(rhs.systemPropsMatchClusterMembers))))&&((this.useContextRootAsPathConsistentInCluster == rhs.useContextRootAsPathConsistentInCluster)||((this.useContextRootAsPathConsistentInCluster!= null)&&this.useContextRootAsPathConsistentInCluster.equals(rhs.useContextRootAsPathConsistentInCluster))))&&((this.serverVariables == rhs.serverVariables)||((this.serverVariables!= null)&&this.serverVariables.equals(rhs.serverVariables))))&&((this.consoleHost == rhs.consoleHost)||((this.consoleHost!= null)&&this.consoleHost.equals(rhs.consoleHost))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.systemPropertyNamesAsString == rhs.systemPropertyNamesAsString)||((this.systemPropertyNamesAsString!= null)&&this.systemPropertyNamesAsString.equals(rhs.systemPropertyNamesAsString))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
