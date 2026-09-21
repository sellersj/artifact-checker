
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
    "authDataAlias",
    "connectionPoolAgedTimeout",
    "connectionPoolConnectionTimeout",
    "connectionPoolConsistantAcrossAllEnvs",
    "connectionPoolFreePoolDistributionTableSize",
    "connectionPoolMatchesProd",
    "connectionPoolMaxConnections",
    "connectionPoolMinConnections",
    "connectionPoolNumberOfFreePoolPartitions",
    "connectionPoolNumberOfSharedPoolPartitions",
    "connectionPoolNumberOfUnsharedPoolPartitions",
    "connectionPoolPurgePolicy",
    "connectionPoolReapTime",
    "connectionPoolStuckThreshold",
    "connectionPoolStuckTime",
    "connectionPoolStuckTimerTime",
    "connectionPoolSurgeCreationInterval",
    "connectionPoolSurgeThreshold",
    "connectionPoolTestConnection",
    "connectionPoolTestConnectionInterval",
    "connectionPoolUnusedTimeout",
    "consoleHost",
    "consoleVersion",
    "databaseHost",
    "databasePort",
    "databaseSid",
    "databaseUsername",
    "detailedVersion",
    "foundInProd",
    "inUseInAnyEnv",
    "inUseInCurrentEnv",
    "jiraKeys",
    "jndiName",
    "keyForInstance",
    "mappedInProd",
    "markedForDeletionByJndiName",
    "name",
    "onlyExistingInProd",
    "oracle",
    "probablyInconsistencyOfCharEncoding",
    "probablyMatchingOtherWas9Envs",
    "probablyMovedToUtf8",
    "prod",
    "prodUsernameMatches",
    "properties",
    "providerType",
    "trackedWithJiraTickets",
    "uniqueInCurrentEnv"
})
@Generated("jsonschema2pojo")
public class AllEnvsDatasource {

    @JsonProperty("authDataAlias")
    private String authDataAlias;
    @JsonProperty("connectionPoolAgedTimeout")
    private String connectionPoolAgedTimeout;
    @JsonProperty("connectionPoolConnectionTimeout")
    private String connectionPoolConnectionTimeout;
    @JsonProperty("connectionPoolConsistantAcrossAllEnvs")
    private Boolean connectionPoolConsistantAcrossAllEnvs;
    @JsonProperty("connectionPoolFreePoolDistributionTableSize")
    private String connectionPoolFreePoolDistributionTableSize;
    @JsonProperty("connectionPoolMatchesProd")
    private Boolean connectionPoolMatchesProd;
    @JsonProperty("connectionPoolMaxConnections")
    private String connectionPoolMaxConnections;
    @JsonProperty("connectionPoolMinConnections")
    private String connectionPoolMinConnections;
    @JsonProperty("connectionPoolNumberOfFreePoolPartitions")
    private String connectionPoolNumberOfFreePoolPartitions;
    @JsonProperty("connectionPoolNumberOfSharedPoolPartitions")
    private String connectionPoolNumberOfSharedPoolPartitions;
    @JsonProperty("connectionPoolNumberOfUnsharedPoolPartitions")
    private String connectionPoolNumberOfUnsharedPoolPartitions;
    @JsonProperty("connectionPoolPurgePolicy")
    private String connectionPoolPurgePolicy;
    @JsonProperty("connectionPoolReapTime")
    private String connectionPoolReapTime;
    @JsonProperty("connectionPoolStuckThreshold")
    private String connectionPoolStuckThreshold;
    @JsonProperty("connectionPoolStuckTime")
    private String connectionPoolStuckTime;
    @JsonProperty("connectionPoolStuckTimerTime")
    private String connectionPoolStuckTimerTime;
    @JsonProperty("connectionPoolSurgeCreationInterval")
    private String connectionPoolSurgeCreationInterval;
    @JsonProperty("connectionPoolSurgeThreshold")
    private String connectionPoolSurgeThreshold;
    @JsonProperty("connectionPoolTestConnection")
    private Boolean connectionPoolTestConnection;
    @JsonProperty("connectionPoolTestConnectionInterval")
    private String connectionPoolTestConnectionInterval;
    @JsonProperty("connectionPoolUnusedTimeout")
    private String connectionPoolUnusedTimeout;
    @JsonProperty("consoleHost")
    private String consoleHost;
    @JsonProperty("consoleVersion")
    private String consoleVersion;
    @JsonProperty("databaseHost")
    private String databaseHost;
    @JsonProperty("databasePort")
    private String databasePort;
    @JsonProperty("databaseSid")
    private String databaseSid;
    @JsonProperty("databaseUsername")
    private String databaseUsername;
    @JsonProperty("detailedVersion")
    private String detailedVersion;
    @JsonProperty("foundInProd")
    private Boolean foundInProd;
    @JsonProperty("inUseInAnyEnv")
    private Boolean inUseInAnyEnv;
    @JsonProperty("inUseInCurrentEnv")
    private Boolean inUseInCurrentEnv;
    @JsonProperty("jiraKeys")
    private List<Object> jiraKeys = new ArrayList<Object>();
    @JsonProperty("jndiName")
    private String jndiName;
    @JsonProperty("keyForInstance")
    private String keyForInstance;
    @JsonProperty("mappedInProd")
    private Boolean mappedInProd;
    @JsonProperty("markedForDeletionByJndiName")
    private Boolean markedForDeletionByJndiName;
    @JsonProperty("name")
    private String name;
    @JsonProperty("onlyExistingInProd")
    private Boolean onlyExistingInProd;
    @JsonProperty("oracle")
    private Boolean oracle;
    @JsonProperty("probablyInconsistencyOfCharEncoding")
    private Boolean probablyInconsistencyOfCharEncoding;
    @JsonProperty("probablyMatchingOtherWas9Envs")
    private Boolean probablyMatchingOtherWas9Envs;
    @JsonProperty("probablyMovedToUtf8")
    private Boolean probablyMovedToUtf8;
    @JsonProperty("prod")
    private Boolean prod;
    @JsonProperty("prodUsernameMatches")
    private Boolean prodUsernameMatches;
    @JsonProperty("properties")
    private Properties properties;
    @JsonProperty("providerType")
    private String providerType;
    @JsonProperty("trackedWithJiraTickets")
    private Boolean trackedWithJiraTickets;
    @JsonProperty("uniqueInCurrentEnv")
    private Boolean uniqueInCurrentEnv;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("authDataAlias")
    public String getAuthDataAlias() {
        return authDataAlias;
    }

    @JsonProperty("authDataAlias")
    public void setAuthDataAlias(String authDataAlias) {
        this.authDataAlias = authDataAlias;
    }

    @JsonProperty("connectionPoolAgedTimeout")
    public String getConnectionPoolAgedTimeout() {
        return connectionPoolAgedTimeout;
    }

    @JsonProperty("connectionPoolAgedTimeout")
    public void setConnectionPoolAgedTimeout(String connectionPoolAgedTimeout) {
        this.connectionPoolAgedTimeout = connectionPoolAgedTimeout;
    }

    @JsonProperty("connectionPoolConnectionTimeout")
    public String getConnectionPoolConnectionTimeout() {
        return connectionPoolConnectionTimeout;
    }

    @JsonProperty("connectionPoolConnectionTimeout")
    public void setConnectionPoolConnectionTimeout(String connectionPoolConnectionTimeout) {
        this.connectionPoolConnectionTimeout = connectionPoolConnectionTimeout;
    }

    @JsonProperty("connectionPoolConsistantAcrossAllEnvs")
    public Boolean getConnectionPoolConsistantAcrossAllEnvs() {
        return connectionPoolConsistantAcrossAllEnvs;
    }

    @JsonProperty("connectionPoolConsistantAcrossAllEnvs")
    public void setConnectionPoolConsistantAcrossAllEnvs(Boolean connectionPoolConsistantAcrossAllEnvs) {
        this.connectionPoolConsistantAcrossAllEnvs = connectionPoolConsistantAcrossAllEnvs;
    }

    @JsonProperty("connectionPoolFreePoolDistributionTableSize")
    public String getConnectionPoolFreePoolDistributionTableSize() {
        return connectionPoolFreePoolDistributionTableSize;
    }

    @JsonProperty("connectionPoolFreePoolDistributionTableSize")
    public void setConnectionPoolFreePoolDistributionTableSize(String connectionPoolFreePoolDistributionTableSize) {
        this.connectionPoolFreePoolDistributionTableSize = connectionPoolFreePoolDistributionTableSize;
    }

    @JsonProperty("connectionPoolMatchesProd")
    public Boolean getConnectionPoolMatchesProd() {
        return connectionPoolMatchesProd;
    }

    @JsonProperty("connectionPoolMatchesProd")
    public void setConnectionPoolMatchesProd(Boolean connectionPoolMatchesProd) {
        this.connectionPoolMatchesProd = connectionPoolMatchesProd;
    }

    @JsonProperty("connectionPoolMaxConnections")
    public String getConnectionPoolMaxConnections() {
        return connectionPoolMaxConnections;
    }

    @JsonProperty("connectionPoolMaxConnections")
    public void setConnectionPoolMaxConnections(String connectionPoolMaxConnections) {
        this.connectionPoolMaxConnections = connectionPoolMaxConnections;
    }

    @JsonProperty("connectionPoolMinConnections")
    public String getConnectionPoolMinConnections() {
        return connectionPoolMinConnections;
    }

    @JsonProperty("connectionPoolMinConnections")
    public void setConnectionPoolMinConnections(String connectionPoolMinConnections) {
        this.connectionPoolMinConnections = connectionPoolMinConnections;
    }

    @JsonProperty("connectionPoolNumberOfFreePoolPartitions")
    public String getConnectionPoolNumberOfFreePoolPartitions() {
        return connectionPoolNumberOfFreePoolPartitions;
    }

    @JsonProperty("connectionPoolNumberOfFreePoolPartitions")
    public void setConnectionPoolNumberOfFreePoolPartitions(String connectionPoolNumberOfFreePoolPartitions) {
        this.connectionPoolNumberOfFreePoolPartitions = connectionPoolNumberOfFreePoolPartitions;
    }

    @JsonProperty("connectionPoolNumberOfSharedPoolPartitions")
    public String getConnectionPoolNumberOfSharedPoolPartitions() {
        return connectionPoolNumberOfSharedPoolPartitions;
    }

    @JsonProperty("connectionPoolNumberOfSharedPoolPartitions")
    public void setConnectionPoolNumberOfSharedPoolPartitions(String connectionPoolNumberOfSharedPoolPartitions) {
        this.connectionPoolNumberOfSharedPoolPartitions = connectionPoolNumberOfSharedPoolPartitions;
    }

    @JsonProperty("connectionPoolNumberOfUnsharedPoolPartitions")
    public String getConnectionPoolNumberOfUnsharedPoolPartitions() {
        return connectionPoolNumberOfUnsharedPoolPartitions;
    }

    @JsonProperty("connectionPoolNumberOfUnsharedPoolPartitions")
    public void setConnectionPoolNumberOfUnsharedPoolPartitions(String connectionPoolNumberOfUnsharedPoolPartitions) {
        this.connectionPoolNumberOfUnsharedPoolPartitions = connectionPoolNumberOfUnsharedPoolPartitions;
    }

    @JsonProperty("connectionPoolPurgePolicy")
    public String getConnectionPoolPurgePolicy() {
        return connectionPoolPurgePolicy;
    }

    @JsonProperty("connectionPoolPurgePolicy")
    public void setConnectionPoolPurgePolicy(String connectionPoolPurgePolicy) {
        this.connectionPoolPurgePolicy = connectionPoolPurgePolicy;
    }

    @JsonProperty("connectionPoolReapTime")
    public String getConnectionPoolReapTime() {
        return connectionPoolReapTime;
    }

    @JsonProperty("connectionPoolReapTime")
    public void setConnectionPoolReapTime(String connectionPoolReapTime) {
        this.connectionPoolReapTime = connectionPoolReapTime;
    }

    @JsonProperty("connectionPoolStuckThreshold")
    public String getConnectionPoolStuckThreshold() {
        return connectionPoolStuckThreshold;
    }

    @JsonProperty("connectionPoolStuckThreshold")
    public void setConnectionPoolStuckThreshold(String connectionPoolStuckThreshold) {
        this.connectionPoolStuckThreshold = connectionPoolStuckThreshold;
    }

    @JsonProperty("connectionPoolStuckTime")
    public String getConnectionPoolStuckTime() {
        return connectionPoolStuckTime;
    }

    @JsonProperty("connectionPoolStuckTime")
    public void setConnectionPoolStuckTime(String connectionPoolStuckTime) {
        this.connectionPoolStuckTime = connectionPoolStuckTime;
    }

    @JsonProperty("connectionPoolStuckTimerTime")
    public String getConnectionPoolStuckTimerTime() {
        return connectionPoolStuckTimerTime;
    }

    @JsonProperty("connectionPoolStuckTimerTime")
    public void setConnectionPoolStuckTimerTime(String connectionPoolStuckTimerTime) {
        this.connectionPoolStuckTimerTime = connectionPoolStuckTimerTime;
    }

    @JsonProperty("connectionPoolSurgeCreationInterval")
    public String getConnectionPoolSurgeCreationInterval() {
        return connectionPoolSurgeCreationInterval;
    }

    @JsonProperty("connectionPoolSurgeCreationInterval")
    public void setConnectionPoolSurgeCreationInterval(String connectionPoolSurgeCreationInterval) {
        this.connectionPoolSurgeCreationInterval = connectionPoolSurgeCreationInterval;
    }

    @JsonProperty("connectionPoolSurgeThreshold")
    public String getConnectionPoolSurgeThreshold() {
        return connectionPoolSurgeThreshold;
    }

    @JsonProperty("connectionPoolSurgeThreshold")
    public void setConnectionPoolSurgeThreshold(String connectionPoolSurgeThreshold) {
        this.connectionPoolSurgeThreshold = connectionPoolSurgeThreshold;
    }

    @JsonProperty("connectionPoolTestConnection")
    public Boolean getConnectionPoolTestConnection() {
        return connectionPoolTestConnection;
    }

    @JsonProperty("connectionPoolTestConnection")
    public void setConnectionPoolTestConnection(Boolean connectionPoolTestConnection) {
        this.connectionPoolTestConnection = connectionPoolTestConnection;
    }

    @JsonProperty("connectionPoolTestConnectionInterval")
    public String getConnectionPoolTestConnectionInterval() {
        return connectionPoolTestConnectionInterval;
    }

    @JsonProperty("connectionPoolTestConnectionInterval")
    public void setConnectionPoolTestConnectionInterval(String connectionPoolTestConnectionInterval) {
        this.connectionPoolTestConnectionInterval = connectionPoolTestConnectionInterval;
    }

    @JsonProperty("connectionPoolUnusedTimeout")
    public String getConnectionPoolUnusedTimeout() {
        return connectionPoolUnusedTimeout;
    }

    @JsonProperty("connectionPoolUnusedTimeout")
    public void setConnectionPoolUnusedTimeout(String connectionPoolUnusedTimeout) {
        this.connectionPoolUnusedTimeout = connectionPoolUnusedTimeout;
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

    @JsonProperty("databaseHost")
    public String getDatabaseHost() {
        return databaseHost;
    }

    @JsonProperty("databaseHost")
    public void setDatabaseHost(String databaseHost) {
        this.databaseHost = databaseHost;
    }

    @JsonProperty("databasePort")
    public String getDatabasePort() {
        return databasePort;
    }

    @JsonProperty("databasePort")
    public void setDatabasePort(String databasePort) {
        this.databasePort = databasePort;
    }

    @JsonProperty("databaseSid")
    public String getDatabaseSid() {
        return databaseSid;
    }

    @JsonProperty("databaseSid")
    public void setDatabaseSid(String databaseSid) {
        this.databaseSid = databaseSid;
    }

    @JsonProperty("databaseUsername")
    public String getDatabaseUsername() {
        return databaseUsername;
    }

    @JsonProperty("databaseUsername")
    public void setDatabaseUsername(String databaseUsername) {
        this.databaseUsername = databaseUsername;
    }

    @JsonProperty("detailedVersion")
    public String getDetailedVersion() {
        return detailedVersion;
    }

    @JsonProperty("detailedVersion")
    public void setDetailedVersion(String detailedVersion) {
        this.detailedVersion = detailedVersion;
    }

    @JsonProperty("foundInProd")
    public Boolean getFoundInProd() {
        return foundInProd;
    }

    @JsonProperty("foundInProd")
    public void setFoundInProd(Boolean foundInProd) {
        this.foundInProd = foundInProd;
    }

    @JsonProperty("inUseInAnyEnv")
    public Boolean getInUseInAnyEnv() {
        return inUseInAnyEnv;
    }

    @JsonProperty("inUseInAnyEnv")
    public void setInUseInAnyEnv(Boolean inUseInAnyEnv) {
        this.inUseInAnyEnv = inUseInAnyEnv;
    }

    @JsonProperty("inUseInCurrentEnv")
    public Boolean getInUseInCurrentEnv() {
        return inUseInCurrentEnv;
    }

    @JsonProperty("inUseInCurrentEnv")
    public void setInUseInCurrentEnv(Boolean inUseInCurrentEnv) {
        this.inUseInCurrentEnv = inUseInCurrentEnv;
    }

    @JsonProperty("jiraKeys")
    public List<Object> getJiraKeys() {
        return jiraKeys;
    }

    @JsonProperty("jiraKeys")
    public void setJiraKeys(List<Object> jiraKeys) {
        this.jiraKeys = jiraKeys;
    }

    @JsonProperty("jndiName")
    public String getJndiName() {
        return jndiName;
    }

    @JsonProperty("jndiName")
    public void setJndiName(String jndiName) {
        this.jndiName = jndiName;
    }

    @JsonProperty("keyForInstance")
    public String getKeyForInstance() {
        return keyForInstance;
    }

    @JsonProperty("keyForInstance")
    public void setKeyForInstance(String keyForInstance) {
        this.keyForInstance = keyForInstance;
    }

    @JsonProperty("mappedInProd")
    public Boolean getMappedInProd() {
        return mappedInProd;
    }

    @JsonProperty("mappedInProd")
    public void setMappedInProd(Boolean mappedInProd) {
        this.mappedInProd = mappedInProd;
    }

    @JsonProperty("markedForDeletionByJndiName")
    public Boolean getMarkedForDeletionByJndiName() {
        return markedForDeletionByJndiName;
    }

    @JsonProperty("markedForDeletionByJndiName")
    public void setMarkedForDeletionByJndiName(Boolean markedForDeletionByJndiName) {
        this.markedForDeletionByJndiName = markedForDeletionByJndiName;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("onlyExistingInProd")
    public Boolean getOnlyExistingInProd() {
        return onlyExistingInProd;
    }

    @JsonProperty("onlyExistingInProd")
    public void setOnlyExistingInProd(Boolean onlyExistingInProd) {
        this.onlyExistingInProd = onlyExistingInProd;
    }

    @JsonProperty("oracle")
    public Boolean getOracle() {
        return oracle;
    }

    @JsonProperty("oracle")
    public void setOracle(Boolean oracle) {
        this.oracle = oracle;
    }

    @JsonProperty("probablyInconsistencyOfCharEncoding")
    public Boolean getProbablyInconsistencyOfCharEncoding() {
        return probablyInconsistencyOfCharEncoding;
    }

    @JsonProperty("probablyInconsistencyOfCharEncoding")
    public void setProbablyInconsistencyOfCharEncoding(Boolean probablyInconsistencyOfCharEncoding) {
        this.probablyInconsistencyOfCharEncoding = probablyInconsistencyOfCharEncoding;
    }

    @JsonProperty("probablyMatchingOtherWas9Envs")
    public Boolean getProbablyMatchingOtherWas9Envs() {
        return probablyMatchingOtherWas9Envs;
    }

    @JsonProperty("probablyMatchingOtherWas9Envs")
    public void setProbablyMatchingOtherWas9Envs(Boolean probablyMatchingOtherWas9Envs) {
        this.probablyMatchingOtherWas9Envs = probablyMatchingOtherWas9Envs;
    }

    @JsonProperty("probablyMovedToUtf8")
    public Boolean getProbablyMovedToUtf8() {
        return probablyMovedToUtf8;
    }

    @JsonProperty("probablyMovedToUtf8")
    public void setProbablyMovedToUtf8(Boolean probablyMovedToUtf8) {
        this.probablyMovedToUtf8 = probablyMovedToUtf8;
    }

    @JsonProperty("prod")
    public Boolean getProd() {
        return prod;
    }

    @JsonProperty("prod")
    public void setProd(Boolean prod) {
        this.prod = prod;
    }

    @JsonProperty("prodUsernameMatches")
    public Boolean getProdUsernameMatches() {
        return prodUsernameMatches;
    }

    @JsonProperty("prodUsernameMatches")
    public void setProdUsernameMatches(Boolean prodUsernameMatches) {
        this.prodUsernameMatches = prodUsernameMatches;
    }

    @JsonProperty("properties")
    public Properties getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @JsonProperty("providerType")
    public String getProviderType() {
        return providerType;
    }

    @JsonProperty("providerType")
    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }

    @JsonProperty("trackedWithJiraTickets")
    public Boolean getTrackedWithJiraTickets() {
        return trackedWithJiraTickets;
    }

    @JsonProperty("trackedWithJiraTickets")
    public void setTrackedWithJiraTickets(Boolean trackedWithJiraTickets) {
        this.trackedWithJiraTickets = trackedWithJiraTickets;
    }

    @JsonProperty("uniqueInCurrentEnv")
    public Boolean getUniqueInCurrentEnv() {
        return uniqueInCurrentEnv;
    }

    @JsonProperty("uniqueInCurrentEnv")
    public void setUniqueInCurrentEnv(Boolean uniqueInCurrentEnv) {
        this.uniqueInCurrentEnv = uniqueInCurrentEnv;
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
        sb.append(AllEnvsDatasource.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("authDataAlias");
        sb.append('=');
        sb.append(((this.authDataAlias == null)?"<null>":this.authDataAlias));
        sb.append(',');
        sb.append("connectionPoolAgedTimeout");
        sb.append('=');
        sb.append(((this.connectionPoolAgedTimeout == null)?"<null>":this.connectionPoolAgedTimeout));
        sb.append(',');
        sb.append("connectionPoolConnectionTimeout");
        sb.append('=');
        sb.append(((this.connectionPoolConnectionTimeout == null)?"<null>":this.connectionPoolConnectionTimeout));
        sb.append(',');
        sb.append("connectionPoolConsistantAcrossAllEnvs");
        sb.append('=');
        sb.append(((this.connectionPoolConsistantAcrossAllEnvs == null)?"<null>":this.connectionPoolConsistantAcrossAllEnvs));
        sb.append(',');
        sb.append("connectionPoolFreePoolDistributionTableSize");
        sb.append('=');
        sb.append(((this.connectionPoolFreePoolDistributionTableSize == null)?"<null>":this.connectionPoolFreePoolDistributionTableSize));
        sb.append(',');
        sb.append("connectionPoolMatchesProd");
        sb.append('=');
        sb.append(((this.connectionPoolMatchesProd == null)?"<null>":this.connectionPoolMatchesProd));
        sb.append(',');
        sb.append("connectionPoolMaxConnections");
        sb.append('=');
        sb.append(((this.connectionPoolMaxConnections == null)?"<null>":this.connectionPoolMaxConnections));
        sb.append(',');
        sb.append("connectionPoolMinConnections");
        sb.append('=');
        sb.append(((this.connectionPoolMinConnections == null)?"<null>":this.connectionPoolMinConnections));
        sb.append(',');
        sb.append("connectionPoolNumberOfFreePoolPartitions");
        sb.append('=');
        sb.append(((this.connectionPoolNumberOfFreePoolPartitions == null)?"<null>":this.connectionPoolNumberOfFreePoolPartitions));
        sb.append(',');
        sb.append("connectionPoolNumberOfSharedPoolPartitions");
        sb.append('=');
        sb.append(((this.connectionPoolNumberOfSharedPoolPartitions == null)?"<null>":this.connectionPoolNumberOfSharedPoolPartitions));
        sb.append(',');
        sb.append("connectionPoolNumberOfUnsharedPoolPartitions");
        sb.append('=');
        sb.append(((this.connectionPoolNumberOfUnsharedPoolPartitions == null)?"<null>":this.connectionPoolNumberOfUnsharedPoolPartitions));
        sb.append(',');
        sb.append("connectionPoolPurgePolicy");
        sb.append('=');
        sb.append(((this.connectionPoolPurgePolicy == null)?"<null>":this.connectionPoolPurgePolicy));
        sb.append(',');
        sb.append("connectionPoolReapTime");
        sb.append('=');
        sb.append(((this.connectionPoolReapTime == null)?"<null>":this.connectionPoolReapTime));
        sb.append(',');
        sb.append("connectionPoolStuckThreshold");
        sb.append('=');
        sb.append(((this.connectionPoolStuckThreshold == null)?"<null>":this.connectionPoolStuckThreshold));
        sb.append(',');
        sb.append("connectionPoolStuckTime");
        sb.append('=');
        sb.append(((this.connectionPoolStuckTime == null)?"<null>":this.connectionPoolStuckTime));
        sb.append(',');
        sb.append("connectionPoolStuckTimerTime");
        sb.append('=');
        sb.append(((this.connectionPoolStuckTimerTime == null)?"<null>":this.connectionPoolStuckTimerTime));
        sb.append(',');
        sb.append("connectionPoolSurgeCreationInterval");
        sb.append('=');
        sb.append(((this.connectionPoolSurgeCreationInterval == null)?"<null>":this.connectionPoolSurgeCreationInterval));
        sb.append(',');
        sb.append("connectionPoolSurgeThreshold");
        sb.append('=');
        sb.append(((this.connectionPoolSurgeThreshold == null)?"<null>":this.connectionPoolSurgeThreshold));
        sb.append(',');
        sb.append("connectionPoolTestConnection");
        sb.append('=');
        sb.append(((this.connectionPoolTestConnection == null)?"<null>":this.connectionPoolTestConnection));
        sb.append(',');
        sb.append("connectionPoolTestConnectionInterval");
        sb.append('=');
        sb.append(((this.connectionPoolTestConnectionInterval == null)?"<null>":this.connectionPoolTestConnectionInterval));
        sb.append(',');
        sb.append("connectionPoolUnusedTimeout");
        sb.append('=');
        sb.append(((this.connectionPoolUnusedTimeout == null)?"<null>":this.connectionPoolUnusedTimeout));
        sb.append(',');
        sb.append("consoleHost");
        sb.append('=');
        sb.append(((this.consoleHost == null)?"<null>":this.consoleHost));
        sb.append(',');
        sb.append("consoleVersion");
        sb.append('=');
        sb.append(((this.consoleVersion == null)?"<null>":this.consoleVersion));
        sb.append(',');
        sb.append("databaseHost");
        sb.append('=');
        sb.append(((this.databaseHost == null)?"<null>":this.databaseHost));
        sb.append(',');
        sb.append("databasePort");
        sb.append('=');
        sb.append(((this.databasePort == null)?"<null>":this.databasePort));
        sb.append(',');
        sb.append("databaseSid");
        sb.append('=');
        sb.append(((this.databaseSid == null)?"<null>":this.databaseSid));
        sb.append(',');
        sb.append("databaseUsername");
        sb.append('=');
        sb.append(((this.databaseUsername == null)?"<null>":this.databaseUsername));
        sb.append(',');
        sb.append("detailedVersion");
        sb.append('=');
        sb.append(((this.detailedVersion == null)?"<null>":this.detailedVersion));
        sb.append(',');
        sb.append("foundInProd");
        sb.append('=');
        sb.append(((this.foundInProd == null)?"<null>":this.foundInProd));
        sb.append(',');
        sb.append("inUseInAnyEnv");
        sb.append('=');
        sb.append(((this.inUseInAnyEnv == null)?"<null>":this.inUseInAnyEnv));
        sb.append(',');
        sb.append("inUseInCurrentEnv");
        sb.append('=');
        sb.append(((this.inUseInCurrentEnv == null)?"<null>":this.inUseInCurrentEnv));
        sb.append(',');
        sb.append("jiraKeys");
        sb.append('=');
        sb.append(((this.jiraKeys == null)?"<null>":this.jiraKeys));
        sb.append(',');
        sb.append("jndiName");
        sb.append('=');
        sb.append(((this.jndiName == null)?"<null>":this.jndiName));
        sb.append(',');
        sb.append("keyForInstance");
        sb.append('=');
        sb.append(((this.keyForInstance == null)?"<null>":this.keyForInstance));
        sb.append(',');
        sb.append("mappedInProd");
        sb.append('=');
        sb.append(((this.mappedInProd == null)?"<null>":this.mappedInProd));
        sb.append(',');
        sb.append("markedForDeletionByJndiName");
        sb.append('=');
        sb.append(((this.markedForDeletionByJndiName == null)?"<null>":this.markedForDeletionByJndiName));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("onlyExistingInProd");
        sb.append('=');
        sb.append(((this.onlyExistingInProd == null)?"<null>":this.onlyExistingInProd));
        sb.append(',');
        sb.append("oracle");
        sb.append('=');
        sb.append(((this.oracle == null)?"<null>":this.oracle));
        sb.append(',');
        sb.append("probablyInconsistencyOfCharEncoding");
        sb.append('=');
        sb.append(((this.probablyInconsistencyOfCharEncoding == null)?"<null>":this.probablyInconsistencyOfCharEncoding));
        sb.append(',');
        sb.append("probablyMatchingOtherWas9Envs");
        sb.append('=');
        sb.append(((this.probablyMatchingOtherWas9Envs == null)?"<null>":this.probablyMatchingOtherWas9Envs));
        sb.append(',');
        sb.append("probablyMovedToUtf8");
        sb.append('=');
        sb.append(((this.probablyMovedToUtf8 == null)?"<null>":this.probablyMovedToUtf8));
        sb.append(',');
        sb.append("prod");
        sb.append('=');
        sb.append(((this.prod == null)?"<null>":this.prod));
        sb.append(',');
        sb.append("prodUsernameMatches");
        sb.append('=');
        sb.append(((this.prodUsernameMatches == null)?"<null>":this.prodUsernameMatches));
        sb.append(',');
        sb.append("properties");
        sb.append('=');
        sb.append(((this.properties == null)?"<null>":this.properties));
        sb.append(',');
        sb.append("providerType");
        sb.append('=');
        sb.append(((this.providerType == null)?"<null>":this.providerType));
        sb.append(',');
        sb.append("trackedWithJiraTickets");
        sb.append('=');
        sb.append(((this.trackedWithJiraTickets == null)?"<null>":this.trackedWithJiraTickets));
        sb.append(',');
        sb.append("uniqueInCurrentEnv");
        sb.append('=');
        sb.append(((this.uniqueInCurrentEnv == null)?"<null>":this.uniqueInCurrentEnv));
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
        result = ((result* 31)+((this.connectionPoolReapTime == null)? 0 :this.connectionPoolReapTime.hashCode()));
        result = ((result* 31)+((this.connectionPoolAgedTimeout == null)? 0 :this.connectionPoolAgedTimeout.hashCode()));
        result = ((result* 31)+((this.foundInProd == null)? 0 :this.foundInProd.hashCode()));
        result = ((result* 31)+((this.probablyMovedToUtf8 == null)? 0 :this.probablyMovedToUtf8 .hashCode()));
        result = ((result* 31)+((this.connectionPoolMaxConnections == null)? 0 :this.connectionPoolMaxConnections.hashCode()));
        result = ((result* 31)+((this.authDataAlias == null)? 0 :this.authDataAlias.hashCode()));
        result = ((result* 31)+((this.connectionPoolFreePoolDistributionTableSize == null)? 0 :this.connectionPoolFreePoolDistributionTableSize.hashCode()));
        result = ((result* 31)+((this.uniqueInCurrentEnv == null)? 0 :this.uniqueInCurrentEnv.hashCode()));
        result = ((result* 31)+((this.onlyExistingInProd == null)? 0 :this.onlyExistingInProd.hashCode()));
        result = ((result* 31)+((this.connectionPoolConnectionTimeout == null)? 0 :this.connectionPoolConnectionTimeout.hashCode()));
        result = ((result* 31)+((this.databaseUsername == null)? 0 :this.databaseUsername.hashCode()));
        result = ((result* 31)+((this.oracle == null)? 0 :this.oracle.hashCode()));
        result = ((result* 31)+((this.probablyMatchingOtherWas9Envs == null)? 0 :this.probablyMatchingOtherWas9Envs.hashCode()));
        result = ((result* 31)+((this.inUseInCurrentEnv == null)? 0 :this.inUseInCurrentEnv.hashCode()));
        result = ((result* 31)+((this.connectionPoolNumberOfFreePoolPartitions == null)? 0 :this.connectionPoolNumberOfFreePoolPartitions.hashCode()));
        result = ((result* 31)+((this.consoleHost == null)? 0 :this.consoleHost.hashCode()));
        result = ((result* 31)+((this.keyForInstance == null)? 0 :this.keyForInstance.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.probablyInconsistencyOfCharEncoding == null)? 0 :this.probablyInconsistencyOfCharEncoding.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.databasePort == null)? 0 :this.databasePort.hashCode()));
        result = ((result* 31)+((this.markedForDeletionByJndiName == null)? 0 :this.markedForDeletionByJndiName.hashCode()));
        result = ((result* 31)+((this.mappedInProd == null)? 0 :this.mappedInProd.hashCode()));
        result = ((result* 31)+((this.connectionPoolSurgeCreationInterval == null)? 0 :this.connectionPoolSurgeCreationInterval.hashCode()));
        result = ((result* 31)+((this.connectionPoolMatchesProd == null)? 0 :this.connectionPoolMatchesProd.hashCode()));
        result = ((result* 31)+((this.providerType == null)? 0 :this.providerType.hashCode()));
        result = ((result* 31)+((this.jndiName == null)? 0 :this.jndiName.hashCode()));
        result = ((result* 31)+((this.connectionPoolNumberOfUnsharedPoolPartitions == null)? 0 :this.connectionPoolNumberOfUnsharedPoolPartitions.hashCode()));
        result = ((result* 31)+((this.connectionPoolStuckTime == null)? 0 :this.connectionPoolStuckTime.hashCode()));
        result = ((result* 31)+((this.detailedVersion == null)? 0 :this.detailedVersion.hashCode()));
        result = ((result* 31)+((this.connectionPoolStuckTimerTime == null)? 0 :this.connectionPoolStuckTimerTime.hashCode()));
        result = ((result* 31)+((this.consoleVersion == null)? 0 :this.consoleVersion.hashCode()));
        result = ((result* 31)+((this.databaseHost == null)? 0 :this.databaseHost.hashCode()));
        result = ((result* 31)+((this.prod == null)? 0 :this.prod.hashCode()));
        result = ((result* 31)+((this.connectionPoolTestConnection == null)? 0 :this.connectionPoolTestConnection.hashCode()));
        result = ((result* 31)+((this.connectionPoolPurgePolicy == null)? 0 :this.connectionPoolPurgePolicy.hashCode()));
        result = ((result* 31)+((this.connectionPoolTestConnectionInterval == null)? 0 :this.connectionPoolTestConnectionInterval.hashCode()));
        result = ((result* 31)+((this.jiraKeys == null)? 0 :this.jiraKeys.hashCode()));
        result = ((result* 31)+((this.connectionPoolMinConnections == null)? 0 :this.connectionPoolMinConnections.hashCode()));
        result = ((result* 31)+((this.connectionPoolSurgeThreshold == null)? 0 :this.connectionPoolSurgeThreshold.hashCode()));
        result = ((result* 31)+((this.prodUsernameMatches == null)? 0 :this.prodUsernameMatches.hashCode()));
        result = ((result* 31)+((this.trackedWithJiraTickets == null)? 0 :this.trackedWithJiraTickets.hashCode()));
        result = ((result* 31)+((this.connectionPoolStuckThreshold == null)? 0 :this.connectionPoolStuckThreshold.hashCode()));
        result = ((result* 31)+((this.connectionPoolUnusedTimeout == null)? 0 :this.connectionPoolUnusedTimeout.hashCode()));
        result = ((result* 31)+((this.connectionPoolNumberOfSharedPoolPartitions == null)? 0 :this.connectionPoolNumberOfSharedPoolPartitions.hashCode()));
        result = ((result* 31)+((this.databaseSid == null)? 0 :this.databaseSid.hashCode()));
        result = ((result* 31)+((this.inUseInAnyEnv == null)? 0 :this.inUseInAnyEnv.hashCode()));
        result = ((result* 31)+((this.connectionPoolConsistantAcrossAllEnvs == null)? 0 :this.connectionPoolConsistantAcrossAllEnvs.hashCode()));
        result = ((result* 31)+((this.properties == null)? 0 :this.properties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AllEnvsDatasource) == false) {
            return false;
        }
        AllEnvsDatasource rhs = ((AllEnvsDatasource) other);
        return ((((((((((((((((((((((((((((((((((((((((((((((((((this.connectionPoolReapTime == rhs.connectionPoolReapTime)||((this.connectionPoolReapTime!= null)&&this.connectionPoolReapTime.equals(rhs.connectionPoolReapTime)))&&((this.connectionPoolAgedTimeout == rhs.connectionPoolAgedTimeout)||((this.connectionPoolAgedTimeout!= null)&&this.connectionPoolAgedTimeout.equals(rhs.connectionPoolAgedTimeout))))&&((this.foundInProd == rhs.foundInProd)||((this.foundInProd!= null)&&this.foundInProd.equals(rhs.foundInProd))))&&((this.probablyMovedToUtf8 == rhs.probablyMovedToUtf8)||((this.probablyMovedToUtf8 != null)&&this.probablyMovedToUtf8 .equals(rhs.probablyMovedToUtf8))))&&((this.connectionPoolMaxConnections == rhs.connectionPoolMaxConnections)||((this.connectionPoolMaxConnections!= null)&&this.connectionPoolMaxConnections.equals(rhs.connectionPoolMaxConnections))))&&((this.authDataAlias == rhs.authDataAlias)||((this.authDataAlias!= null)&&this.authDataAlias.equals(rhs.authDataAlias))))&&((this.connectionPoolFreePoolDistributionTableSize == rhs.connectionPoolFreePoolDistributionTableSize)||((this.connectionPoolFreePoolDistributionTableSize!= null)&&this.connectionPoolFreePoolDistributionTableSize.equals(rhs.connectionPoolFreePoolDistributionTableSize))))&&((this.uniqueInCurrentEnv == rhs.uniqueInCurrentEnv)||((this.uniqueInCurrentEnv!= null)&&this.uniqueInCurrentEnv.equals(rhs.uniqueInCurrentEnv))))&&((this.onlyExistingInProd == rhs.onlyExistingInProd)||((this.onlyExistingInProd!= null)&&this.onlyExistingInProd.equals(rhs.onlyExistingInProd))))&&((this.connectionPoolConnectionTimeout == rhs.connectionPoolConnectionTimeout)||((this.connectionPoolConnectionTimeout!= null)&&this.connectionPoolConnectionTimeout.equals(rhs.connectionPoolConnectionTimeout))))&&((this.databaseUsername == rhs.databaseUsername)||((this.databaseUsername!= null)&&this.databaseUsername.equals(rhs.databaseUsername))))&&((this.oracle == rhs.oracle)||((this.oracle!= null)&&this.oracle.equals(rhs.oracle))))&&((this.probablyMatchingOtherWas9Envs == rhs.probablyMatchingOtherWas9Envs)||((this.probablyMatchingOtherWas9Envs!= null)&&this.probablyMatchingOtherWas9Envs.equals(rhs.probablyMatchingOtherWas9Envs))))&&((this.inUseInCurrentEnv == rhs.inUseInCurrentEnv)||((this.inUseInCurrentEnv!= null)&&this.inUseInCurrentEnv.equals(rhs.inUseInCurrentEnv))))&&((this.connectionPoolNumberOfFreePoolPartitions == rhs.connectionPoolNumberOfFreePoolPartitions)||((this.connectionPoolNumberOfFreePoolPartitions!= null)&&this.connectionPoolNumberOfFreePoolPartitions.equals(rhs.connectionPoolNumberOfFreePoolPartitions))))&&((this.consoleHost == rhs.consoleHost)||((this.consoleHost!= null)&&this.consoleHost.equals(rhs.consoleHost))))&&((this.keyForInstance == rhs.keyForInstance)||((this.keyForInstance!= null)&&this.keyForInstance.equals(rhs.keyForInstance))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.probablyInconsistencyOfCharEncoding == rhs.probablyInconsistencyOfCharEncoding)||((this.probablyInconsistencyOfCharEncoding!= null)&&this.probablyInconsistencyOfCharEncoding.equals(rhs.probablyInconsistencyOfCharEncoding))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.databasePort == rhs.databasePort)||((this.databasePort!= null)&&this.databasePort.equals(rhs.databasePort))))&&((this.markedForDeletionByJndiName == rhs.markedForDeletionByJndiName)||((this.markedForDeletionByJndiName!= null)&&this.markedForDeletionByJndiName.equals(rhs.markedForDeletionByJndiName))))&&((this.mappedInProd == rhs.mappedInProd)||((this.mappedInProd!= null)&&this.mappedInProd.equals(rhs.mappedInProd))))&&((this.connectionPoolSurgeCreationInterval == rhs.connectionPoolSurgeCreationInterval)||((this.connectionPoolSurgeCreationInterval!= null)&&this.connectionPoolSurgeCreationInterval.equals(rhs.connectionPoolSurgeCreationInterval))))&&((this.connectionPoolMatchesProd == rhs.connectionPoolMatchesProd)||((this.connectionPoolMatchesProd!= null)&&this.connectionPoolMatchesProd.equals(rhs.connectionPoolMatchesProd))))&&((this.providerType == rhs.providerType)||((this.providerType!= null)&&this.providerType.equals(rhs.providerType))))&&((this.jndiName == rhs.jndiName)||((this.jndiName!= null)&&this.jndiName.equals(rhs.jndiName))))&&((this.connectionPoolNumberOfUnsharedPoolPartitions == rhs.connectionPoolNumberOfUnsharedPoolPartitions)||((this.connectionPoolNumberOfUnsharedPoolPartitions!= null)&&this.connectionPoolNumberOfUnsharedPoolPartitions.equals(rhs.connectionPoolNumberOfUnsharedPoolPartitions))))&&((this.connectionPoolStuckTime == rhs.connectionPoolStuckTime)||((this.connectionPoolStuckTime!= null)&&this.connectionPoolStuckTime.equals(rhs.connectionPoolStuckTime))))&&((this.detailedVersion == rhs.detailedVersion)||((this.detailedVersion!= null)&&this.detailedVersion.equals(rhs.detailedVersion))))&&((this.connectionPoolStuckTimerTime == rhs.connectionPoolStuckTimerTime)||((this.connectionPoolStuckTimerTime!= null)&&this.connectionPoolStuckTimerTime.equals(rhs.connectionPoolStuckTimerTime))))&&((this.consoleVersion == rhs.consoleVersion)||((this.consoleVersion!= null)&&this.consoleVersion.equals(rhs.consoleVersion))))&&((this.databaseHost == rhs.databaseHost)||((this.databaseHost!= null)&&this.databaseHost.equals(rhs.databaseHost))))&&((this.prod == rhs.prod)||((this.prod!= null)&&this.prod.equals(rhs.prod))))&&((this.connectionPoolTestConnection == rhs.connectionPoolTestConnection)||((this.connectionPoolTestConnection!= null)&&this.connectionPoolTestConnection.equals(rhs.connectionPoolTestConnection))))&&((this.connectionPoolPurgePolicy == rhs.connectionPoolPurgePolicy)||((this.connectionPoolPurgePolicy!= null)&&this.connectionPoolPurgePolicy.equals(rhs.connectionPoolPurgePolicy))))&&((this.connectionPoolTestConnectionInterval == rhs.connectionPoolTestConnectionInterval)||((this.connectionPoolTestConnectionInterval!= null)&&this.connectionPoolTestConnectionInterval.equals(rhs.connectionPoolTestConnectionInterval))))&&((this.jiraKeys == rhs.jiraKeys)||((this.jiraKeys!= null)&&this.jiraKeys.equals(rhs.jiraKeys))))&&((this.connectionPoolMinConnections == rhs.connectionPoolMinConnections)||((this.connectionPoolMinConnections!= null)&&this.connectionPoolMinConnections.equals(rhs.connectionPoolMinConnections))))&&((this.connectionPoolSurgeThreshold == rhs.connectionPoolSurgeThreshold)||((this.connectionPoolSurgeThreshold!= null)&&this.connectionPoolSurgeThreshold.equals(rhs.connectionPoolSurgeThreshold))))&&((this.prodUsernameMatches == rhs.prodUsernameMatches)||((this.prodUsernameMatches!= null)&&this.prodUsernameMatches.equals(rhs.prodUsernameMatches))))&&((this.trackedWithJiraTickets == rhs.trackedWithJiraTickets)||((this.trackedWithJiraTickets!= null)&&this.trackedWithJiraTickets.equals(rhs.trackedWithJiraTickets))))&&((this.connectionPoolStuckThreshold == rhs.connectionPoolStuckThreshold)||((this.connectionPoolStuckThreshold!= null)&&this.connectionPoolStuckThreshold.equals(rhs.connectionPoolStuckThreshold))))&&((this.connectionPoolUnusedTimeout == rhs.connectionPoolUnusedTimeout)||((this.connectionPoolUnusedTimeout!= null)&&this.connectionPoolUnusedTimeout.equals(rhs.connectionPoolUnusedTimeout))))&&((this.connectionPoolNumberOfSharedPoolPartitions == rhs.connectionPoolNumberOfSharedPoolPartitions)||((this.connectionPoolNumberOfSharedPoolPartitions!= null)&&this.connectionPoolNumberOfSharedPoolPartitions.equals(rhs.connectionPoolNumberOfSharedPoolPartitions))))&&((this.databaseSid == rhs.databaseSid)||((this.databaseSid!= null)&&this.databaseSid.equals(rhs.databaseSid))))&&((this.inUseInAnyEnv == rhs.inUseInAnyEnv)||((this.inUseInAnyEnv!= null)&&this.inUseInAnyEnv.equals(rhs.inUseInAnyEnv))))&&((this.connectionPoolConsistantAcrossAllEnvs == rhs.connectionPoolConsistantAcrossAllEnvs)||((this.connectionPoolConsistantAcrossAllEnvs!= null)&&this.connectionPoolConsistantAcrossAllEnvs.equals(rhs.connectionPoolConsistantAcrossAllEnvs))))&&((this.properties == rhs.properties)||((this.properties!= null)&&this.properties.equals(rhs.properties))));
    }

}
