
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
    "apmKey",
    "appServers",
    "applicationLogsAsAHtmlString",
    "artifactFoundInProduction",
    "businessLeadsLinks",
    "cell",
    "classloadingMatch",
    "classloadingMatchProd",
    "clusterTarget",
    "consoleHost",
    "consoleVersion",
    "contextRoots",
    "contextRootsAsAString",
    "correctedJiraKey",
    "correctedMavenArtifactId",
    "correctedMavenGroupId",
    "correctedScmProject",
    "correctedScmRepo",
    "deploymentContents",
    "deploymentDate",
    "implementationTitle",
    "issueTrackingUrl",
    "jiraKey",
    "loggingConfig",
    "loggingWorkAround",
    "manifest",
    "manifestFromWebsphere",
    "manifestImplementationVersion",
    "mavenArtifactId",
    "mavenGroupId",
    "mavenInfoFilledOut",
    "mavenVersion",
    "moduleClassloading",
    "modules",
    "name",
    "newerThanProd",
    "nexusUrl",
    "nexusUrlProd",
    "notWebsphereInternalApp",
    "pomPropertiesFromWebsphere",
    "prod",
    "prodVersion",
    "resourceRefBindingNames",
    "resourceRefBindingNamesAsAString",
    "scmProjectName",
    "scmRepoName",
    "scmUrl",
    "securityBindings",
    "securityBindingsAsAString",
    "securityBindingsMatch",
    "serverLogsAsAHtmlString",
    "serverTargets",
    "sharedLibraries",
    "sharedLibrariesAsAString",
    "techLeadsLinks",
    "techOwner",
    "urls",
    "urlsAsAHtmlString",
    "urlsAsAString",
    "virtualHosts",
    "virtualHostsAsAString",
    "virtualHostsMatch"
})
@Generated("jsonschema2pojo")
public class AllEnvsInventory {

    @JsonProperty("apmKey")
    private String apmKey;
    @JsonProperty("appServers")
    private List<AppServer> appServers = new ArrayList<AppServer>();
    @JsonProperty("applicationLogsAsAHtmlString")
    private String applicationLogsAsAHtmlString;
    @JsonProperty("artifactFoundInProduction")
    private Boolean artifactFoundInProduction;
    @JsonProperty("businessLeadsLinks")
    private List<String> businessLeadsLinks = new ArrayList<String>();
    @JsonProperty("cell")
    private String cell;
    @JsonProperty("classloadingMatch")
    private Boolean classloadingMatch;
    @JsonProperty("classloadingMatchProd")
    private Boolean classloadingMatchProd;
    @JsonProperty("clusterTarget")
    private String clusterTarget;
    @JsonProperty("consoleHost")
    private String consoleHost;
    @JsonProperty("consoleVersion")
    private String consoleVersion;
    @JsonProperty("contextRoots")
    private List<String> contextRoots = new ArrayList<String>();
    @JsonProperty("contextRootsAsAString")
    private String contextRootsAsAString;
    @JsonProperty("correctedJiraKey")
    private String correctedJiraKey;
    @JsonProperty("correctedMavenArtifactId")
    private String correctedMavenArtifactId;
    @JsonProperty("correctedMavenGroupId")
    private String correctedMavenGroupId;
    @JsonProperty("correctedScmProject")
    private String correctedScmProject;
    @JsonProperty("correctedScmRepo")
    private String correctedScmRepo;
    @JsonProperty("deploymentContents")
    private String deploymentContents;
    @JsonProperty("deploymentDate")
    private String deploymentDate;
    @JsonProperty("implementationTitle")
    private String implementationTitle;
    @JsonProperty("issueTrackingUrl")
    private String issueTrackingUrl;
    @JsonProperty("jiraKey")
    private String jiraKey;
    @JsonProperty("loggingConfig")
    private List<LoggingConfig> loggingConfig = new ArrayList<LoggingConfig>();
    @JsonProperty("loggingWorkAround")
    private List<String> loggingWorkAround = new ArrayList<String>();
    @JsonProperty("manifest")
    private Manifest manifest;
    @JsonProperty("manifestFromWebsphere")
    private ManifestFromWebsphere manifestFromWebsphere;
    @JsonProperty("manifestImplementationVersion")
    private String manifestImplementationVersion;
    @JsonProperty("mavenArtifactId")
    private String mavenArtifactId;
    @JsonProperty("mavenGroupId")
    private String mavenGroupId;
    @JsonProperty("mavenInfoFilledOut")
    private Boolean mavenInfoFilledOut;
    @JsonProperty("mavenVersion")
    private String mavenVersion;
    @JsonProperty("moduleClassloading")
    private String moduleClassloading;
    @JsonProperty("modules")
    private List<Module> modules = new ArrayList<Module>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("newerThanProd")
    private Boolean newerThanProd;
    @JsonProperty("nexusUrl")
    private String nexusUrl;
    @JsonProperty("nexusUrlProd")
    private String nexusUrlProd;
    @JsonProperty("notWebsphereInternalApp")
    private Boolean notWebsphereInternalApp;
    @JsonProperty("pomPropertiesFromWebsphere")
    private PomPropertiesFromWebsphere pomPropertiesFromWebsphere;
    @JsonProperty("prod")
    private Boolean prod;
    @JsonProperty("prodVersion")
    private String prodVersion;
    @JsonProperty("resourceRefBindingNames")
    private List<String> resourceRefBindingNames = new ArrayList<String>();
    @JsonProperty("resourceRefBindingNamesAsAString")
    private String resourceRefBindingNamesAsAString;
    @JsonProperty("scmProjectName")
    private String scmProjectName;
    @JsonProperty("scmRepoName")
    private String scmRepoName;
    @JsonProperty("scmUrl")
    private String scmUrl;
    @JsonProperty("securityBindings")
    private List<String> securityBindings = new ArrayList<String>();
    @JsonProperty("securityBindingsAsAString")
    private String securityBindingsAsAString;
    @JsonProperty("securityBindingsMatch")
    private Boolean securityBindingsMatch;
    @JsonProperty("serverLogsAsAHtmlString")
    private String serverLogsAsAHtmlString;
    @JsonProperty("serverTargets")
    private List<ServerTarget> serverTargets = new ArrayList<ServerTarget>();
    @JsonProperty("sharedLibraries")
    private List<String> sharedLibraries = new ArrayList<String>();
    @JsonProperty("sharedLibrariesAsAString")
    private String sharedLibrariesAsAString;
    @JsonProperty("techLeadsLinks")
    private List<String> techLeadsLinks = new ArrayList<String>();
    @JsonProperty("techOwner")
    private String techOwner;
    @JsonProperty("urls")
    private List<String> urls = new ArrayList<String>();
    @JsonProperty("urlsAsAHtmlString")
    private String urlsAsAHtmlString;
    @JsonProperty("urlsAsAString")
    private String urlsAsAString;
    @JsonProperty("virtualHosts")
    private List<String> virtualHosts = new ArrayList<String>();
    @JsonProperty("virtualHostsAsAString")
    private String virtualHostsAsAString;
    @JsonProperty("virtualHostsMatch")
    private Boolean virtualHostsMatch;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("apmKey")
    public String getApmKey() {
        return apmKey;
    }

    @JsonProperty("apmKey")
    public void setApmKey(String apmKey) {
        this.apmKey = apmKey;
    }

    @JsonProperty("appServers")
    public List<AppServer> getAppServers() {
        return appServers;
    }

    @JsonProperty("appServers")
    public void setAppServers(List<AppServer> appServers) {
        this.appServers = appServers;
    }

    @JsonProperty("applicationLogsAsAHtmlString")
    public String getApplicationLogsAsAHtmlString() {
        return applicationLogsAsAHtmlString;
    }

    @JsonProperty("applicationLogsAsAHtmlString")
    public void setApplicationLogsAsAHtmlString(String applicationLogsAsAHtmlString) {
        this.applicationLogsAsAHtmlString = applicationLogsAsAHtmlString;
    }

    @JsonProperty("artifactFoundInProduction")
    public Boolean getArtifactFoundInProduction() {
        return artifactFoundInProduction;
    }

    @JsonProperty("artifactFoundInProduction")
    public void setArtifactFoundInProduction(Boolean artifactFoundInProduction) {
        this.artifactFoundInProduction = artifactFoundInProduction;
    }

    @JsonProperty("businessLeadsLinks")
    public List<String> getBusinessLeadsLinks() {
        return businessLeadsLinks;
    }

    @JsonProperty("businessLeadsLinks")
    public void setBusinessLeadsLinks(List<String> businessLeadsLinks) {
        this.businessLeadsLinks = businessLeadsLinks;
    }

    @JsonProperty("cell")
    public String getCell() {
        return cell;
    }

    @JsonProperty("cell")
    public void setCell(String cell) {
        this.cell = cell;
    }

    @JsonProperty("classloadingMatch")
    public Boolean getClassloadingMatch() {
        return classloadingMatch;
    }

    @JsonProperty("classloadingMatch")
    public void setClassloadingMatch(Boolean classloadingMatch) {
        this.classloadingMatch = classloadingMatch;
    }

    @JsonProperty("classloadingMatchProd")
    public Boolean getClassloadingMatchProd() {
        return classloadingMatchProd;
    }

    @JsonProperty("classloadingMatchProd")
    public void setClassloadingMatchProd(Boolean classloadingMatchProd) {
        this.classloadingMatchProd = classloadingMatchProd;
    }

    @JsonProperty("clusterTarget")
    public String getClusterTarget() {
        return clusterTarget;
    }

    @JsonProperty("clusterTarget")
    public void setClusterTarget(String clusterTarget) {
        this.clusterTarget = clusterTarget;
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

    @JsonProperty("contextRoots")
    public List<String> getContextRoots() {
        return contextRoots;
    }

    @JsonProperty("contextRoots")
    public void setContextRoots(List<String> contextRoots) {
        this.contextRoots = contextRoots;
    }

    @JsonProperty("contextRootsAsAString")
    public String getContextRootsAsAString() {
        return contextRootsAsAString;
    }

    @JsonProperty("contextRootsAsAString")
    public void setContextRootsAsAString(String contextRootsAsAString) {
        this.contextRootsAsAString = contextRootsAsAString;
    }

    @JsonProperty("correctedJiraKey")
    public String getCorrectedJiraKey() {
        return correctedJiraKey;
    }

    @JsonProperty("correctedJiraKey")
    public void setCorrectedJiraKey(String correctedJiraKey) {
        this.correctedJiraKey = correctedJiraKey;
    }

    @JsonProperty("correctedMavenArtifactId")
    public String getCorrectedMavenArtifactId() {
        return correctedMavenArtifactId;
    }

    @JsonProperty("correctedMavenArtifactId")
    public void setCorrectedMavenArtifactId(String correctedMavenArtifactId) {
        this.correctedMavenArtifactId = correctedMavenArtifactId;
    }

    @JsonProperty("correctedMavenGroupId")
    public String getCorrectedMavenGroupId() {
        return correctedMavenGroupId;
    }

    @JsonProperty("correctedMavenGroupId")
    public void setCorrectedMavenGroupId(String correctedMavenGroupId) {
        this.correctedMavenGroupId = correctedMavenGroupId;
    }

    @JsonProperty("correctedScmProject")
    public String getCorrectedScmProject() {
        return correctedScmProject;
    }

    @JsonProperty("correctedScmProject")
    public void setCorrectedScmProject(String correctedScmProject) {
        this.correctedScmProject = correctedScmProject;
    }

    @JsonProperty("correctedScmRepo")
    public String getCorrectedScmRepo() {
        return correctedScmRepo;
    }

    @JsonProperty("correctedScmRepo")
    public void setCorrectedScmRepo(String correctedScmRepo) {
        this.correctedScmRepo = correctedScmRepo;
    }

    @JsonProperty("deploymentContents")
    public String getDeploymentContents() {
        return deploymentContents;
    }

    @JsonProperty("deploymentContents")
    public void setDeploymentContents(String deploymentContents) {
        this.deploymentContents = deploymentContents;
    }

    @JsonProperty("deploymentDate")
    public String getDeploymentDate() {
        return deploymentDate;
    }

    @JsonProperty("deploymentDate")
    public void setDeploymentDate(String deploymentDate) {
        this.deploymentDate = deploymentDate;
    }

    @JsonProperty("implementationTitle")
    public String getImplementationTitle() {
        return implementationTitle;
    }

    @JsonProperty("implementationTitle")
    public void setImplementationTitle(String implementationTitle) {
        this.implementationTitle = implementationTitle;
    }

    @JsonProperty("issueTrackingUrl")
    public String getIssueTrackingUrl() {
        return issueTrackingUrl;
    }

    @JsonProperty("issueTrackingUrl")
    public void setIssueTrackingUrl(String issueTrackingUrl) {
        this.issueTrackingUrl = issueTrackingUrl;
    }

    @JsonProperty("jiraKey")
    public String getJiraKey() {
        return jiraKey;
    }

    @JsonProperty("jiraKey")
    public void setJiraKey(String jiraKey) {
        this.jiraKey = jiraKey;
    }

    @JsonProperty("loggingConfig")
    public List<LoggingConfig> getLoggingConfig() {
        return loggingConfig;
    }

    @JsonProperty("loggingConfig")
    public void setLoggingConfig(List<LoggingConfig> loggingConfig) {
        this.loggingConfig = loggingConfig;
    }

    @JsonProperty("loggingWorkAround")
    public List<String> getLoggingWorkAround() {
        return loggingWorkAround;
    }

    @JsonProperty("loggingWorkAround")
    public void setLoggingWorkAround(List<String> loggingWorkAround) {
        this.loggingWorkAround = loggingWorkAround;
    }

    @JsonProperty("manifest")
    public Manifest getManifest() {
        return manifest;
    }

    @JsonProperty("manifest")
    public void setManifest(Manifest manifest) {
        this.manifest = manifest;
    }

    @JsonProperty("manifestFromWebsphere")
    public ManifestFromWebsphere getManifestFromWebsphere() {
        return manifestFromWebsphere;
    }

    @JsonProperty("manifestFromWebsphere")
    public void setManifestFromWebsphere(ManifestFromWebsphere manifestFromWebsphere) {
        this.manifestFromWebsphere = manifestFromWebsphere;
    }

    @JsonProperty("manifestImplementationVersion")
    public String getManifestImplementationVersion() {
        return manifestImplementationVersion;
    }

    @JsonProperty("manifestImplementationVersion")
    public void setManifestImplementationVersion(String manifestImplementationVersion) {
        this.manifestImplementationVersion = manifestImplementationVersion;
    }

    @JsonProperty("mavenArtifactId")
    public String getMavenArtifactId() {
        return mavenArtifactId;
    }

    @JsonProperty("mavenArtifactId")
    public void setMavenArtifactId(String mavenArtifactId) {
        this.mavenArtifactId = mavenArtifactId;
    }

    @JsonProperty("mavenGroupId")
    public String getMavenGroupId() {
        return mavenGroupId;
    }

    @JsonProperty("mavenGroupId")
    public void setMavenGroupId(String mavenGroupId) {
        this.mavenGroupId = mavenGroupId;
    }

    @JsonProperty("mavenInfoFilledOut")
    public Boolean getMavenInfoFilledOut() {
        return mavenInfoFilledOut;
    }

    @JsonProperty("mavenInfoFilledOut")
    public void setMavenInfoFilledOut(Boolean mavenInfoFilledOut) {
        this.mavenInfoFilledOut = mavenInfoFilledOut;
    }

    @JsonProperty("mavenVersion")
    public String getMavenVersion() {
        return mavenVersion;
    }

    @JsonProperty("mavenVersion")
    public void setMavenVersion(String mavenVersion) {
        this.mavenVersion = mavenVersion;
    }

    @JsonProperty("moduleClassloading")
    public String getModuleClassloading() {
        return moduleClassloading;
    }

    @JsonProperty("moduleClassloading")
    public void setModuleClassloading(String moduleClassloading) {
        this.moduleClassloading = moduleClassloading;
    }

    @JsonProperty("modules")
    public List<Module> getModules() {
        return modules;
    }

    @JsonProperty("modules")
    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("newerThanProd")
    public Boolean getNewerThanProd() {
        return newerThanProd;
    }

    @JsonProperty("newerThanProd")
    public void setNewerThanProd(Boolean newerThanProd) {
        this.newerThanProd = newerThanProd;
    }

    @JsonProperty("nexusUrl")
    public String getNexusUrl() {
        return nexusUrl;
    }

    @JsonProperty("nexusUrl")
    public void setNexusUrl(String nexusUrl) {
        this.nexusUrl = nexusUrl;
    }

    @JsonProperty("nexusUrlProd")
    public String getNexusUrlProd() {
        return nexusUrlProd;
    }

    @JsonProperty("nexusUrlProd")
    public void setNexusUrlProd(String nexusUrlProd) {
        this.nexusUrlProd = nexusUrlProd;
    }

    @JsonProperty("notWebsphereInternalApp")
    public Boolean getNotWebsphereInternalApp() {
        return notWebsphereInternalApp;
    }

    @JsonProperty("notWebsphereInternalApp")
    public void setNotWebsphereInternalApp(Boolean notWebsphereInternalApp) {
        this.notWebsphereInternalApp = notWebsphereInternalApp;
    }

    @JsonProperty("pomPropertiesFromWebsphere")
    public PomPropertiesFromWebsphere getPomPropertiesFromWebsphere() {
        return pomPropertiesFromWebsphere;
    }

    @JsonProperty("pomPropertiesFromWebsphere")
    public void setPomPropertiesFromWebsphere(PomPropertiesFromWebsphere pomPropertiesFromWebsphere) {
        this.pomPropertiesFromWebsphere = pomPropertiesFromWebsphere;
    }

    @JsonProperty("prod")
    public Boolean getProd() {
        return prod;
    }

    @JsonProperty("prod")
    public void setProd(Boolean prod) {
        this.prod = prod;
    }

    @JsonProperty("prodVersion")
    public String getProdVersion() {
        return prodVersion;
    }

    @JsonProperty("prodVersion")
    public void setProdVersion(String prodVersion) {
        this.prodVersion = prodVersion;
    }

    @JsonProperty("resourceRefBindingNames")
    public List<String> getResourceRefBindingNames() {
        return resourceRefBindingNames;
    }

    @JsonProperty("resourceRefBindingNames")
    public void setResourceRefBindingNames(List<String> resourceRefBindingNames) {
        this.resourceRefBindingNames = resourceRefBindingNames;
    }

    @JsonProperty("resourceRefBindingNamesAsAString")
    public String getResourceRefBindingNamesAsAString() {
        return resourceRefBindingNamesAsAString;
    }

    @JsonProperty("resourceRefBindingNamesAsAString")
    public void setResourceRefBindingNamesAsAString(String resourceRefBindingNamesAsAString) {
        this.resourceRefBindingNamesAsAString = resourceRefBindingNamesAsAString;
    }

    @JsonProperty("scmProjectName")
    public String getScmProjectName() {
        return scmProjectName;
    }

    @JsonProperty("scmProjectName")
    public void setScmProjectName(String scmProjectName) {
        this.scmProjectName = scmProjectName;
    }

    @JsonProperty("scmRepoName")
    public String getScmRepoName() {
        return scmRepoName;
    }

    @JsonProperty("scmRepoName")
    public void setScmRepoName(String scmRepoName) {
        this.scmRepoName = scmRepoName;
    }

    @JsonProperty("scmUrl")
    public String getScmUrl() {
        return scmUrl;
    }

    @JsonProperty("scmUrl")
    public void setScmUrl(String scmUrl) {
        this.scmUrl = scmUrl;
    }

    @JsonProperty("securityBindings")
    public List<String> getSecurityBindings() {
        return securityBindings;
    }

    @JsonProperty("securityBindings")
    public void setSecurityBindings(List<String> securityBindings) {
        this.securityBindings = securityBindings;
    }

    @JsonProperty("securityBindingsAsAString")
    public String getSecurityBindingsAsAString() {
        return securityBindingsAsAString;
    }

    @JsonProperty("securityBindingsAsAString")
    public void setSecurityBindingsAsAString(String securityBindingsAsAString) {
        this.securityBindingsAsAString = securityBindingsAsAString;
    }

    @JsonProperty("securityBindingsMatch")
    public Boolean getSecurityBindingsMatch() {
        return securityBindingsMatch;
    }

    @JsonProperty("securityBindingsMatch")
    public void setSecurityBindingsMatch(Boolean securityBindingsMatch) {
        this.securityBindingsMatch = securityBindingsMatch;
    }

    @JsonProperty("serverLogsAsAHtmlString")
    public String getServerLogsAsAHtmlString() {
        return serverLogsAsAHtmlString;
    }

    @JsonProperty("serverLogsAsAHtmlString")
    public void setServerLogsAsAHtmlString(String serverLogsAsAHtmlString) {
        this.serverLogsAsAHtmlString = serverLogsAsAHtmlString;
    }

    @JsonProperty("serverTargets")
    public List<ServerTarget> getServerTargets() {
        return serverTargets;
    }

    @JsonProperty("serverTargets")
    public void setServerTargets(List<ServerTarget> serverTargets) {
        this.serverTargets = serverTargets;
    }

    @JsonProperty("sharedLibraries")
    public List<String> getSharedLibraries() {
        return sharedLibraries;
    }

    @JsonProperty("sharedLibraries")
    public void setSharedLibraries(List<String> sharedLibraries) {
        this.sharedLibraries = sharedLibraries;
    }

    @JsonProperty("sharedLibrariesAsAString")
    public String getSharedLibrariesAsAString() {
        return sharedLibrariesAsAString;
    }

    @JsonProperty("sharedLibrariesAsAString")
    public void setSharedLibrariesAsAString(String sharedLibrariesAsAString) {
        this.sharedLibrariesAsAString = sharedLibrariesAsAString;
    }

    @JsonProperty("techLeadsLinks")
    public List<String> getTechLeadsLinks() {
        return techLeadsLinks;
    }

    @JsonProperty("techLeadsLinks")
    public void setTechLeadsLinks(List<String> techLeadsLinks) {
        this.techLeadsLinks = techLeadsLinks;
    }

    @JsonProperty("techOwner")
    public String getTechOwner() {
        return techOwner;
    }

    @JsonProperty("techOwner")
    public void setTechOwner(String techOwner) {
        this.techOwner = techOwner;
    }

    @JsonProperty("urls")
    public List<String> getUrls() {
        return urls;
    }

    @JsonProperty("urls")
    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    @JsonProperty("urlsAsAHtmlString")
    public String getUrlsAsAHtmlString() {
        return urlsAsAHtmlString;
    }

    @JsonProperty("urlsAsAHtmlString")
    public void setUrlsAsAHtmlString(String urlsAsAHtmlString) {
        this.urlsAsAHtmlString = urlsAsAHtmlString;
    }

    @JsonProperty("urlsAsAString")
    public String getUrlsAsAString() {
        return urlsAsAString;
    }

    @JsonProperty("urlsAsAString")
    public void setUrlsAsAString(String urlsAsAString) {
        this.urlsAsAString = urlsAsAString;
    }

    @JsonProperty("virtualHosts")
    public List<String> getVirtualHosts() {
        return virtualHosts;
    }

    @JsonProperty("virtualHosts")
    public void setVirtualHosts(List<String> virtualHosts) {
        this.virtualHosts = virtualHosts;
    }

    @JsonProperty("virtualHostsAsAString")
    public String getVirtualHostsAsAString() {
        return virtualHostsAsAString;
    }

    @JsonProperty("virtualHostsAsAString")
    public void setVirtualHostsAsAString(String virtualHostsAsAString) {
        this.virtualHostsAsAString = virtualHostsAsAString;
    }

    @JsonProperty("virtualHostsMatch")
    public Boolean getVirtualHostsMatch() {
        return virtualHostsMatch;
    }

    @JsonProperty("virtualHostsMatch")
    public void setVirtualHostsMatch(Boolean virtualHostsMatch) {
        this.virtualHostsMatch = virtualHostsMatch;
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
        sb.append(AllEnvsInventory.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("apmKey");
        sb.append('=');
        sb.append(((this.apmKey == null)?"<null>":this.apmKey));
        sb.append(',');
        sb.append("appServers");
        sb.append('=');
        sb.append(((this.appServers == null)?"<null>":this.appServers));
        sb.append(',');
        sb.append("applicationLogsAsAHtmlString");
        sb.append('=');
        sb.append(((this.applicationLogsAsAHtmlString == null)?"<null>":this.applicationLogsAsAHtmlString));
        sb.append(',');
        sb.append("artifactFoundInProduction");
        sb.append('=');
        sb.append(((this.artifactFoundInProduction == null)?"<null>":this.artifactFoundInProduction));
        sb.append(',');
        sb.append("businessLeadsLinks");
        sb.append('=');
        sb.append(((this.businessLeadsLinks == null)?"<null>":this.businessLeadsLinks));
        sb.append(',');
        sb.append("cell");
        sb.append('=');
        sb.append(((this.cell == null)?"<null>":this.cell));
        sb.append(',');
        sb.append("classloadingMatch");
        sb.append('=');
        sb.append(((this.classloadingMatch == null)?"<null>":this.classloadingMatch));
        sb.append(',');
        sb.append("classloadingMatchProd");
        sb.append('=');
        sb.append(((this.classloadingMatchProd == null)?"<null>":this.classloadingMatchProd));
        sb.append(',');
        sb.append("clusterTarget");
        sb.append('=');
        sb.append(((this.clusterTarget == null)?"<null>":this.clusterTarget));
        sb.append(',');
        sb.append("consoleHost");
        sb.append('=');
        sb.append(((this.consoleHost == null)?"<null>":this.consoleHost));
        sb.append(',');
        sb.append("consoleVersion");
        sb.append('=');
        sb.append(((this.consoleVersion == null)?"<null>":this.consoleVersion));
        sb.append(',');
        sb.append("contextRoots");
        sb.append('=');
        sb.append(((this.contextRoots == null)?"<null>":this.contextRoots));
        sb.append(',');
        sb.append("contextRootsAsAString");
        sb.append('=');
        sb.append(((this.contextRootsAsAString == null)?"<null>":this.contextRootsAsAString));
        sb.append(',');
        sb.append("correctedJiraKey");
        sb.append('=');
        sb.append(((this.correctedJiraKey == null)?"<null>":this.correctedJiraKey));
        sb.append(',');
        sb.append("correctedMavenArtifactId");
        sb.append('=');
        sb.append(((this.correctedMavenArtifactId == null)?"<null>":this.correctedMavenArtifactId));
        sb.append(',');
        sb.append("correctedMavenGroupId");
        sb.append('=');
        sb.append(((this.correctedMavenGroupId == null)?"<null>":this.correctedMavenGroupId));
        sb.append(',');
        sb.append("correctedScmProject");
        sb.append('=');
        sb.append(((this.correctedScmProject == null)?"<null>":this.correctedScmProject));
        sb.append(',');
        sb.append("correctedScmRepo");
        sb.append('=');
        sb.append(((this.correctedScmRepo == null)?"<null>":this.correctedScmRepo));
        sb.append(',');
        sb.append("deploymentContents");
        sb.append('=');
        sb.append(((this.deploymentContents == null)?"<null>":this.deploymentContents));
        sb.append(',');
        sb.append("deploymentDate");
        sb.append('=');
        sb.append(((this.deploymentDate == null)?"<null>":this.deploymentDate));
        sb.append(',');
        sb.append("implementationTitle");
        sb.append('=');
        sb.append(((this.implementationTitle == null)?"<null>":this.implementationTitle));
        sb.append(',');
        sb.append("issueTrackingUrl");
        sb.append('=');
        sb.append(((this.issueTrackingUrl == null)?"<null>":this.issueTrackingUrl));
        sb.append(',');
        sb.append("jiraKey");
        sb.append('=');
        sb.append(((this.jiraKey == null)?"<null>":this.jiraKey));
        sb.append(',');
        sb.append("loggingConfig");
        sb.append('=');
        sb.append(((this.loggingConfig == null)?"<null>":this.loggingConfig));
        sb.append(',');
        sb.append("loggingWorkAround");
        sb.append('=');
        sb.append(((this.loggingWorkAround == null)?"<null>":this.loggingWorkAround));
        sb.append(',');
        sb.append("manifest");
        sb.append('=');
        sb.append(((this.manifest == null)?"<null>":this.manifest));
        sb.append(',');
        sb.append("manifestFromWebsphere");
        sb.append('=');
        sb.append(((this.manifestFromWebsphere == null)?"<null>":this.manifestFromWebsphere));
        sb.append(',');
        sb.append("manifestImplementationVersion");
        sb.append('=');
        sb.append(((this.manifestImplementationVersion == null)?"<null>":this.manifestImplementationVersion));
        sb.append(',');
        sb.append("mavenArtifactId");
        sb.append('=');
        sb.append(((this.mavenArtifactId == null)?"<null>":this.mavenArtifactId));
        sb.append(',');
        sb.append("mavenGroupId");
        sb.append('=');
        sb.append(((this.mavenGroupId == null)?"<null>":this.mavenGroupId));
        sb.append(',');
        sb.append("mavenInfoFilledOut");
        sb.append('=');
        sb.append(((this.mavenInfoFilledOut == null)?"<null>":this.mavenInfoFilledOut));
        sb.append(',');
        sb.append("mavenVersion");
        sb.append('=');
        sb.append(((this.mavenVersion == null)?"<null>":this.mavenVersion));
        sb.append(',');
        sb.append("moduleClassloading");
        sb.append('=');
        sb.append(((this.moduleClassloading == null)?"<null>":this.moduleClassloading));
        sb.append(',');
        sb.append("modules");
        sb.append('=');
        sb.append(((this.modules == null)?"<null>":this.modules));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("newerThanProd");
        sb.append('=');
        sb.append(((this.newerThanProd == null)?"<null>":this.newerThanProd));
        sb.append(',');
        sb.append("nexusUrl");
        sb.append('=');
        sb.append(((this.nexusUrl == null)?"<null>":this.nexusUrl));
        sb.append(',');
        sb.append("nexusUrlProd");
        sb.append('=');
        sb.append(((this.nexusUrlProd == null)?"<null>":this.nexusUrlProd));
        sb.append(',');
        sb.append("notWebsphereInternalApp");
        sb.append('=');
        sb.append(((this.notWebsphereInternalApp == null)?"<null>":this.notWebsphereInternalApp));
        sb.append(',');
        sb.append("pomPropertiesFromWebsphere");
        sb.append('=');
        sb.append(((this.pomPropertiesFromWebsphere == null)?"<null>":this.pomPropertiesFromWebsphere));
        sb.append(',');
        sb.append("prod");
        sb.append('=');
        sb.append(((this.prod == null)?"<null>":this.prod));
        sb.append(',');
        sb.append("prodVersion");
        sb.append('=');
        sb.append(((this.prodVersion == null)?"<null>":this.prodVersion));
        sb.append(',');
        sb.append("resourceRefBindingNames");
        sb.append('=');
        sb.append(((this.resourceRefBindingNames == null)?"<null>":this.resourceRefBindingNames));
        sb.append(',');
        sb.append("resourceRefBindingNamesAsAString");
        sb.append('=');
        sb.append(((this.resourceRefBindingNamesAsAString == null)?"<null>":this.resourceRefBindingNamesAsAString));
        sb.append(',');
        sb.append("scmProjectName");
        sb.append('=');
        sb.append(((this.scmProjectName == null)?"<null>":this.scmProjectName));
        sb.append(',');
        sb.append("scmRepoName");
        sb.append('=');
        sb.append(((this.scmRepoName == null)?"<null>":this.scmRepoName));
        sb.append(',');
        sb.append("scmUrl");
        sb.append('=');
        sb.append(((this.scmUrl == null)?"<null>":this.scmUrl));
        sb.append(',');
        sb.append("securityBindings");
        sb.append('=');
        sb.append(((this.securityBindings == null)?"<null>":this.securityBindings));
        sb.append(',');
        sb.append("securityBindingsAsAString");
        sb.append('=');
        sb.append(((this.securityBindingsAsAString == null)?"<null>":this.securityBindingsAsAString));
        sb.append(',');
        sb.append("securityBindingsMatch");
        sb.append('=');
        sb.append(((this.securityBindingsMatch == null)?"<null>":this.securityBindingsMatch));
        sb.append(',');
        sb.append("serverLogsAsAHtmlString");
        sb.append('=');
        sb.append(((this.serverLogsAsAHtmlString == null)?"<null>":this.serverLogsAsAHtmlString));
        sb.append(',');
        sb.append("serverTargets");
        sb.append('=');
        sb.append(((this.serverTargets == null)?"<null>":this.serverTargets));
        sb.append(',');
        sb.append("sharedLibraries");
        sb.append('=');
        sb.append(((this.sharedLibraries == null)?"<null>":this.sharedLibraries));
        sb.append(',');
        sb.append("sharedLibrariesAsAString");
        sb.append('=');
        sb.append(((this.sharedLibrariesAsAString == null)?"<null>":this.sharedLibrariesAsAString));
        sb.append(',');
        sb.append("techLeadsLinks");
        sb.append('=');
        sb.append(((this.techLeadsLinks == null)?"<null>":this.techLeadsLinks));
        sb.append(',');
        sb.append("techOwner");
        sb.append('=');
        sb.append(((this.techOwner == null)?"<null>":this.techOwner));
        sb.append(',');
        sb.append("urls");
        sb.append('=');
        sb.append(((this.urls == null)?"<null>":this.urls));
        sb.append(',');
        sb.append("urlsAsAHtmlString");
        sb.append('=');
        sb.append(((this.urlsAsAHtmlString == null)?"<null>":this.urlsAsAHtmlString));
        sb.append(',');
        sb.append("urlsAsAString");
        sb.append('=');
        sb.append(((this.urlsAsAString == null)?"<null>":this.urlsAsAString));
        sb.append(',');
        sb.append("virtualHosts");
        sb.append('=');
        sb.append(((this.virtualHosts == null)?"<null>":this.virtualHosts));
        sb.append(',');
        sb.append("virtualHostsAsAString");
        sb.append('=');
        sb.append(((this.virtualHostsAsAString == null)?"<null>":this.virtualHostsAsAString));
        sb.append(',');
        sb.append("virtualHostsMatch");
        sb.append('=');
        sb.append(((this.virtualHostsMatch == null)?"<null>":this.virtualHostsMatch));
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
        result = ((result* 31)+((this.correctedMavenGroupId == null)? 0 :this.correctedMavenGroupId.hashCode()));
        result = ((result* 31)+((this.apmKey == null)? 0 :this.apmKey.hashCode()));
        result = ((result* 31)+((this.virtualHosts == null)? 0 :this.virtualHosts.hashCode()));
        result = ((result* 31)+((this.virtualHostsAsAString == null)? 0 :this.virtualHostsAsAString.hashCode()));
        result = ((result* 31)+((this.deploymentContents == null)? 0 :this.deploymentContents.hashCode()));
        result = ((result* 31)+((this.sharedLibraries == null)? 0 :this.sharedLibraries.hashCode()));
        result = ((result* 31)+((this.applicationLogsAsAHtmlString == null)? 0 :this.applicationLogsAsAHtmlString.hashCode()));
        result = ((result* 31)+((this.prodVersion == null)? 0 :this.prodVersion.hashCode()));
        result = ((result* 31)+((this.urlsAsAString == null)? 0 :this.urlsAsAString.hashCode()));
        result = ((result* 31)+((this.correctedJiraKey == null)? 0 :this.correctedJiraKey.hashCode()));
        result = ((result* 31)+((this.resourceRefBindingNamesAsAString == null)? 0 :this.resourceRefBindingNamesAsAString.hashCode()));
        result = ((result* 31)+((this.urlsAsAHtmlString == null)? 0 :this.urlsAsAHtmlString.hashCode()));
        result = ((result* 31)+((this.nexusUrlProd == null)? 0 :this.nexusUrlProd.hashCode()));
        result = ((result* 31)+((this.classloadingMatch == null)? 0 :this.classloadingMatch.hashCode()));
        result = ((result* 31)+((this.correctedMavenArtifactId == null)? 0 :this.correctedMavenArtifactId.hashCode()));
        result = ((result* 31)+((this.jiraKey == null)? 0 :this.jiraKey.hashCode()));
        result = ((result* 31)+((this.mavenArtifactId == null)? 0 :this.mavenArtifactId.hashCode()));
        result = ((result* 31)+((this.classloadingMatchProd == null)? 0 :this.classloadingMatchProd.hashCode()));
        result = ((result* 31)+((this.modules == null)? 0 :this.modules.hashCode()));
        result = ((result* 31)+((this.deploymentDate == null)? 0 :this.deploymentDate.hashCode()));
        result = ((result* 31)+((this.scmProjectName == null)? 0 :this.scmProjectName.hashCode()));
        result = ((result* 31)+((this.consoleHost == null)? 0 :this.consoleHost.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.contextRoots == null)? 0 :this.contextRoots.hashCode()));
        result = ((result* 31)+((this.resourceRefBindingNames == null)? 0 :this.resourceRefBindingNames.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.scmRepoName == null)? 0 :this.scmRepoName.hashCode()));
        result = ((result* 31)+((this.securityBindings == null)? 0 :this.securityBindings.hashCode()));
        result = ((result* 31)+((this.manifestImplementationVersion == null)? 0 :this.manifestImplementationVersion.hashCode()));
        result = ((result* 31)+((this.clusterTarget == null)? 0 :this.clusterTarget.hashCode()));
        result = ((result* 31)+((this.mavenInfoFilledOut == null)? 0 :this.mavenInfoFilledOut.hashCode()));
        result = ((result* 31)+((this.pomPropertiesFromWebsphere == null)? 0 :this.pomPropertiesFromWebsphere.hashCode()));
        result = ((result* 31)+((this.implementationTitle == null)? 0 :this.implementationTitle.hashCode()));
        result = ((result* 31)+((this.cell == null)? 0 :this.cell.hashCode()));
        result = ((result* 31)+((this.serverTargets == null)? 0 :this.serverTargets.hashCode()));
        result = ((result* 31)+((this.correctedScmRepo == null)? 0 :this.correctedScmRepo.hashCode()));
        result = ((result* 31)+((this.newerThanProd == null)? 0 :this.newerThanProd.hashCode()));
        result = ((result* 31)+((this.urls == null)? 0 :this.urls.hashCode()));
        result = ((result* 31)+((this.manifestFromWebsphere == null)? 0 :this.manifestFromWebsphere.hashCode()));
        result = ((result* 31)+((this.sharedLibrariesAsAString == null)? 0 :this.sharedLibrariesAsAString.hashCode()));
        result = ((result* 31)+((this.contextRootsAsAString == null)? 0 :this.contextRootsAsAString.hashCode()));
        result = ((result* 31)+((this.serverLogsAsAHtmlString == null)? 0 :this.serverLogsAsAHtmlString.hashCode()));
        result = ((result* 31)+((this.techOwner == null)? 0 :this.techOwner.hashCode()));
        result = ((result* 31)+((this.mavenVersion == null)? 0 :this.mavenVersion.hashCode()));
        result = ((result* 31)+((this.moduleClassloading == null)? 0 :this.moduleClassloading.hashCode()));
        result = ((result* 31)+((this.virtualHostsMatch == null)? 0 :this.virtualHostsMatch.hashCode()));
        result = ((result* 31)+((this.consoleVersion == null)? 0 :this.consoleVersion.hashCode()));
        result = ((result* 31)+((this.techLeadsLinks == null)? 0 :this.techLeadsLinks.hashCode()));
        result = ((result* 31)+((this.prod == null)? 0 :this.prod.hashCode()));
        result = ((result* 31)+((this.securityBindingsAsAString == null)? 0 :this.securityBindingsAsAString.hashCode()));
        result = ((result* 31)+((this.manifest == null)? 0 :this.manifest.hashCode()));
        result = ((result* 31)+((this.artifactFoundInProduction == null)? 0 :this.artifactFoundInProduction.hashCode()));
        result = ((result* 31)+((this.correctedScmProject == null)? 0 :this.correctedScmProject.hashCode()));
        result = ((result* 31)+((this.appServers == null)? 0 :this.appServers.hashCode()));
        result = ((result* 31)+((this.scmUrl == null)? 0 :this.scmUrl.hashCode()));
        result = ((result* 31)+((this.nexusUrl == null)? 0 :this.nexusUrl.hashCode()));
        result = ((result* 31)+((this.mavenGroupId == null)? 0 :this.mavenGroupId.hashCode()));
        result = ((result* 31)+((this.businessLeadsLinks == null)? 0 :this.businessLeadsLinks.hashCode()));
        result = ((result* 31)+((this.loggingWorkAround == null)? 0 :this.loggingWorkAround.hashCode()));
        result = ((result* 31)+((this.loggingConfig == null)? 0 :this.loggingConfig.hashCode()));
        result = ((result* 31)+((this.notWebsphereInternalApp == null)? 0 :this.notWebsphereInternalApp.hashCode()));
        result = ((result* 31)+((this.securityBindingsMatch == null)? 0 :this.securityBindingsMatch.hashCode()));
        result = ((result* 31)+((this.issueTrackingUrl == null)? 0 :this.issueTrackingUrl.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AllEnvsInventory) == false) {
            return false;
        }
        AllEnvsInventory rhs = ((AllEnvsInventory) other);
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.correctedMavenGroupId == rhs.correctedMavenGroupId)||((this.correctedMavenGroupId!= null)&&this.correctedMavenGroupId.equals(rhs.correctedMavenGroupId)))&&((this.apmKey == rhs.apmKey)||((this.apmKey!= null)&&this.apmKey.equals(rhs.apmKey))))&&((this.virtualHosts == rhs.virtualHosts)||((this.virtualHosts!= null)&&this.virtualHosts.equals(rhs.virtualHosts))))&&((this.virtualHostsAsAString == rhs.virtualHostsAsAString)||((this.virtualHostsAsAString!= null)&&this.virtualHostsAsAString.equals(rhs.virtualHostsAsAString))))&&((this.deploymentContents == rhs.deploymentContents)||((this.deploymentContents!= null)&&this.deploymentContents.equals(rhs.deploymentContents))))&&((this.sharedLibraries == rhs.sharedLibraries)||((this.sharedLibraries!= null)&&this.sharedLibraries.equals(rhs.sharedLibraries))))&&((this.applicationLogsAsAHtmlString == rhs.applicationLogsAsAHtmlString)||((this.applicationLogsAsAHtmlString!= null)&&this.applicationLogsAsAHtmlString.equals(rhs.applicationLogsAsAHtmlString))))&&((this.prodVersion == rhs.prodVersion)||((this.prodVersion!= null)&&this.prodVersion.equals(rhs.prodVersion))))&&((this.urlsAsAString == rhs.urlsAsAString)||((this.urlsAsAString!= null)&&this.urlsAsAString.equals(rhs.urlsAsAString))))&&((this.correctedJiraKey == rhs.correctedJiraKey)||((this.correctedJiraKey!= null)&&this.correctedJiraKey.equals(rhs.correctedJiraKey))))&&((this.resourceRefBindingNamesAsAString == rhs.resourceRefBindingNamesAsAString)||((this.resourceRefBindingNamesAsAString!= null)&&this.resourceRefBindingNamesAsAString.equals(rhs.resourceRefBindingNamesAsAString))))&&((this.urlsAsAHtmlString == rhs.urlsAsAHtmlString)||((this.urlsAsAHtmlString!= null)&&this.urlsAsAHtmlString.equals(rhs.urlsAsAHtmlString))))&&((this.nexusUrlProd == rhs.nexusUrlProd)||((this.nexusUrlProd!= null)&&this.nexusUrlProd.equals(rhs.nexusUrlProd))))&&((this.classloadingMatch == rhs.classloadingMatch)||((this.classloadingMatch!= null)&&this.classloadingMatch.equals(rhs.classloadingMatch))))&&((this.correctedMavenArtifactId == rhs.correctedMavenArtifactId)||((this.correctedMavenArtifactId!= null)&&this.correctedMavenArtifactId.equals(rhs.correctedMavenArtifactId))))&&((this.jiraKey == rhs.jiraKey)||((this.jiraKey!= null)&&this.jiraKey.equals(rhs.jiraKey))))&&((this.mavenArtifactId == rhs.mavenArtifactId)||((this.mavenArtifactId!= null)&&this.mavenArtifactId.equals(rhs.mavenArtifactId))))&&((this.classloadingMatchProd == rhs.classloadingMatchProd)||((this.classloadingMatchProd!= null)&&this.classloadingMatchProd.equals(rhs.classloadingMatchProd))))&&((this.modules == rhs.modules)||((this.modules!= null)&&this.modules.equals(rhs.modules))))&&((this.deploymentDate == rhs.deploymentDate)||((this.deploymentDate!= null)&&this.deploymentDate.equals(rhs.deploymentDate))))&&((this.scmProjectName == rhs.scmProjectName)||((this.scmProjectName!= null)&&this.scmProjectName.equals(rhs.scmProjectName))))&&((this.consoleHost == rhs.consoleHost)||((this.consoleHost!= null)&&this.consoleHost.equals(rhs.consoleHost))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.contextRoots == rhs.contextRoots)||((this.contextRoots!= null)&&this.contextRoots.equals(rhs.contextRoots))))&&((this.resourceRefBindingNames == rhs.resourceRefBindingNames)||((this.resourceRefBindingNames!= null)&&this.resourceRefBindingNames.equals(rhs.resourceRefBindingNames))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.scmRepoName == rhs.scmRepoName)||((this.scmRepoName!= null)&&this.scmRepoName.equals(rhs.scmRepoName))))&&((this.securityBindings == rhs.securityBindings)||((this.securityBindings!= null)&&this.securityBindings.equals(rhs.securityBindings))))&&((this.manifestImplementationVersion == rhs.manifestImplementationVersion)||((this.manifestImplementationVersion!= null)&&this.manifestImplementationVersion.equals(rhs.manifestImplementationVersion))))&&((this.clusterTarget == rhs.clusterTarget)||((this.clusterTarget!= null)&&this.clusterTarget.equals(rhs.clusterTarget))))&&((this.mavenInfoFilledOut == rhs.mavenInfoFilledOut)||((this.mavenInfoFilledOut!= null)&&this.mavenInfoFilledOut.equals(rhs.mavenInfoFilledOut))))&&((this.pomPropertiesFromWebsphere == rhs.pomPropertiesFromWebsphere)||((this.pomPropertiesFromWebsphere!= null)&&this.pomPropertiesFromWebsphere.equals(rhs.pomPropertiesFromWebsphere))))&&((this.implementationTitle == rhs.implementationTitle)||((this.implementationTitle!= null)&&this.implementationTitle.equals(rhs.implementationTitle))))&&((this.cell == rhs.cell)||((this.cell!= null)&&this.cell.equals(rhs.cell))))&&((this.serverTargets == rhs.serverTargets)||((this.serverTargets!= null)&&this.serverTargets.equals(rhs.serverTargets))))&&((this.correctedScmRepo == rhs.correctedScmRepo)||((this.correctedScmRepo!= null)&&this.correctedScmRepo.equals(rhs.correctedScmRepo))))&&((this.newerThanProd == rhs.newerThanProd)||((this.newerThanProd!= null)&&this.newerThanProd.equals(rhs.newerThanProd))))&&((this.urls == rhs.urls)||((this.urls!= null)&&this.urls.equals(rhs.urls))))&&((this.manifestFromWebsphere == rhs.manifestFromWebsphere)||((this.manifestFromWebsphere!= null)&&this.manifestFromWebsphere.equals(rhs.manifestFromWebsphere))))&&((this.sharedLibrariesAsAString == rhs.sharedLibrariesAsAString)||((this.sharedLibrariesAsAString!= null)&&this.sharedLibrariesAsAString.equals(rhs.sharedLibrariesAsAString))))&&((this.contextRootsAsAString == rhs.contextRootsAsAString)||((this.contextRootsAsAString!= null)&&this.contextRootsAsAString.equals(rhs.contextRootsAsAString))))&&((this.serverLogsAsAHtmlString == rhs.serverLogsAsAHtmlString)||((this.serverLogsAsAHtmlString!= null)&&this.serverLogsAsAHtmlString.equals(rhs.serverLogsAsAHtmlString))))&&((this.techOwner == rhs.techOwner)||((this.techOwner!= null)&&this.techOwner.equals(rhs.techOwner))))&&((this.mavenVersion == rhs.mavenVersion)||((this.mavenVersion!= null)&&this.mavenVersion.equals(rhs.mavenVersion))))&&((this.moduleClassloading == rhs.moduleClassloading)||((this.moduleClassloading!= null)&&this.moduleClassloading.equals(rhs.moduleClassloading))))&&((this.virtualHostsMatch == rhs.virtualHostsMatch)||((this.virtualHostsMatch!= null)&&this.virtualHostsMatch.equals(rhs.virtualHostsMatch))))&&((this.consoleVersion == rhs.consoleVersion)||((this.consoleVersion!= null)&&this.consoleVersion.equals(rhs.consoleVersion))))&&((this.techLeadsLinks == rhs.techLeadsLinks)||((this.techLeadsLinks!= null)&&this.techLeadsLinks.equals(rhs.techLeadsLinks))))&&((this.prod == rhs.prod)||((this.prod!= null)&&this.prod.equals(rhs.prod))))&&((this.securityBindingsAsAString == rhs.securityBindingsAsAString)||((this.securityBindingsAsAString!= null)&&this.securityBindingsAsAString.equals(rhs.securityBindingsAsAString))))&&((this.manifest == rhs.manifest)||((this.manifest!= null)&&this.manifest.equals(rhs.manifest))))&&((this.artifactFoundInProduction == rhs.artifactFoundInProduction)||((this.artifactFoundInProduction!= null)&&this.artifactFoundInProduction.equals(rhs.artifactFoundInProduction))))&&((this.correctedScmProject == rhs.correctedScmProject)||((this.correctedScmProject!= null)&&this.correctedScmProject.equals(rhs.correctedScmProject))))&&((this.appServers == rhs.appServers)||((this.appServers!= null)&&this.appServers.equals(rhs.appServers))))&&((this.scmUrl == rhs.scmUrl)||((this.scmUrl!= null)&&this.scmUrl.equals(rhs.scmUrl))))&&((this.nexusUrl == rhs.nexusUrl)||((this.nexusUrl!= null)&&this.nexusUrl.equals(rhs.nexusUrl))))&&((this.mavenGroupId == rhs.mavenGroupId)||((this.mavenGroupId!= null)&&this.mavenGroupId.equals(rhs.mavenGroupId))))&&((this.businessLeadsLinks == rhs.businessLeadsLinks)||((this.businessLeadsLinks!= null)&&this.businessLeadsLinks.equals(rhs.businessLeadsLinks))))&&((this.loggingWorkAround == rhs.loggingWorkAround)||((this.loggingWorkAround!= null)&&this.loggingWorkAround.equals(rhs.loggingWorkAround))))&&((this.loggingConfig == rhs.loggingConfig)||((this.loggingConfig!= null)&&this.loggingConfig.equals(rhs.loggingConfig))))&&((this.notWebsphereInternalApp == rhs.notWebsphereInternalApp)||((this.notWebsphereInternalApp!= null)&&this.notWebsphereInternalApp.equals(rhs.notWebsphereInternalApp))))&&((this.securityBindingsMatch == rhs.securityBindingsMatch)||((this.securityBindingsMatch!= null)&&this.securityBindingsMatch.equals(rhs.securityBindingsMatch))))&&((this.issueTrackingUrl == rhs.issueTrackingUrl)||((this.issueTrackingUrl!= null)&&this.issueTrackingUrl.equals(rhs.issueTrackingUrl))));
    }

}
