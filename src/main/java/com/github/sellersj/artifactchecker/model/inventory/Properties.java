
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
    "TNSEntryName",
    "URL",
    "connRetriesDuringDBFailover",
    "connRetryIntervalDuringDBFailover",
    "dataSourceName",
    "databaseName",
    "dbFailOverEnabled",
    "description",
    "driverType",
    "enableMultithreadedAccessDetection",
    "jmsOnePhaseOptimization",
    "loginTimeout",
    "networkProtocol",
    "oracle9iLogTraceLevel",
    "oracleLogFileCount",
    "oracleLogFileName",
    "oracleLogFileSizeLimit",
    "oracleLogFormat",
    "oracleLogPackageName",
    "oracleLogTraceLevel",
    "portNumber",
    "preTestSQLString",
    "reauthentication",
    "serverName",
    "validateNewConnection",
    "validateNewConnectionRetryCount",
    "validateNewConnectionRetryInterval",
    "beginTranForResultSetScrollingAPIs",
    "beginTranForVendorAPIs",
    "connectionSharing",
    "enableClientInformation",
    "errorDetectionModel",
    "freeResourcesOnClose",
    "nonTransactionalDataSource",
    "syncQueryTimeoutWithTransactionTimeout",
    "userDefinedErrorMap",
    "validateNewConnectionTimeout",
    "webSphereDefaultIsolationLevel",
    "webSphereDefaultQueryTimeout",
    "JDBCBehavior",
    "accountingInfo",
    "alternateServers",
    "applicationName",
    "batchPerformanceWorkaround",
    "bulkLoadBatchSize",
    "catalogIncludesSynonyms",
    "catalogOptions",
    "clientAcctInfo",
    "clientAppName",
    "clientHostName",
    "clientLanguage",
    "clientProgramID",
    "clientUser",
    "clobCodePage",
    "codePage",
    "connectionLog",
    "connectionRetryCount",
    "connectionRetryDelay",
    "convertNull",
    "cursorHoldability",
    "dateFormat",
    "defaultSchema",
    "embedded",
    "enableBulkLoad",
    "encryptionMethod",
    "extendedOptions",
    "failoverGranularity",
    "failoverMode",
    "failoverPreconnect",
    "future1",
    "future2",
    "future3",
    "future4",
    "future5",
    "future6",
    "hostNameInCertificate",
    "idleConnectionTimeout",
    "importStatementPool",
    "initialPoolSize",
    "initializationString",
    "insensitiveResultSetBufferSize",
    "isolationLevel",
    "javaDoubleToString",
    "loadBalancing",
    "loadLibraryPath",
    "lockWaitTimeout",
    "logWriter",
    "maxIdleTime",
    "maxOpenCursors",
    "maxPoolSize",
    "maxPooledStatements",
    "maxStatements",
    "maxXids",
    "minPoolSize",
    "numericFormat",
    "password",
    "privateBuffers",
    "programID",
    "promsgsCharSet",
    "propertyCycle",
    "queryTimeout",
    "resultsetMetaDataOptions",
    "roleName",
    "serverLog",
    "serviceName",
    "spyAttributes",
    "sqlDebug",
    "statementCacheSize",
    "tempStoreDisk",
    "threadStackSize",
    "trustStore",
    "trustStorePassword",
    "user",
    "userType",
    "validateServerCertificate",
    "w",
    "workarounds",
    "z",
    "connectionProperties",
    "connectionAttributes",
    "createDatabase",
    "cryptoProtocolVersion",
    "loginConfigName",
    "randomGenerator",
    "registerStatementPoolMonitorMBean",
    "secureRandomAlgorithm",
    "servicePrincipalName",
    "truncateTooLarge"
})
@Generated("jsonschema2pojo")
public class Properties {

    @JsonProperty("TNSEntryName")
    private String tNSEntryName;
    @JsonProperty("URL")
    private String url;
    @JsonProperty("connRetriesDuringDBFailover")
    private String connRetriesDuringDBFailover;
    @JsonProperty("connRetryIntervalDuringDBFailover")
    private String connRetryIntervalDuringDBFailover;
    @JsonProperty("dataSourceName")
    private String dataSourceName;
    @JsonProperty("databaseName")
    private String databaseName;
    @JsonProperty("dbFailOverEnabled")
    private String dbFailOverEnabled;
    @JsonProperty("description")
    private String description;
    @JsonProperty("driverType")
    private String driverType;
    @JsonProperty("enableMultithreadedAccessDetection")
    private String enableMultithreadedAccessDetection;
    @JsonProperty("jmsOnePhaseOptimization")
    private String jmsOnePhaseOptimization;
    @JsonProperty("loginTimeout")
    private String loginTimeout;
    @JsonProperty("networkProtocol")
    private String networkProtocol;
    @JsonProperty("oracle9iLogTraceLevel")
    private String oracle9iLogTraceLevel;
    @JsonProperty("oracleLogFileCount")
    private String oracleLogFileCount;
    @JsonProperty("oracleLogFileName")
    private String oracleLogFileName;
    @JsonProperty("oracleLogFileSizeLimit")
    private String oracleLogFileSizeLimit;
    @JsonProperty("oracleLogFormat")
    private String oracleLogFormat;
    @JsonProperty("oracleLogPackageName")
    private String oracleLogPackageName;
    @JsonProperty("oracleLogTraceLevel")
    private String oracleLogTraceLevel;
    @JsonProperty("portNumber")
    private String portNumber;
    @JsonProperty("preTestSQLString")
    private String preTestSQLString;
    @JsonProperty("reauthentication")
    private String reauthentication;
    @JsonProperty("serverName")
    private String serverName;
    @JsonProperty("validateNewConnection")
    private String validateNewConnection;
    @JsonProperty("validateNewConnectionRetryCount")
    private String validateNewConnectionRetryCount;
    @JsonProperty("validateNewConnectionRetryInterval")
    private String validateNewConnectionRetryInterval;
    @JsonProperty("beginTranForResultSetScrollingAPIs")
    private String beginTranForResultSetScrollingAPIs;
    @JsonProperty("beginTranForVendorAPIs")
    private String beginTranForVendorAPIs;
    @JsonProperty("connectionSharing")
    private String connectionSharing;
    @JsonProperty("enableClientInformation")
    private String enableClientInformation;
    @JsonProperty("errorDetectionModel")
    private String errorDetectionModel;
    @JsonProperty("freeResourcesOnClose")
    private String freeResourcesOnClose;
    @JsonProperty("nonTransactionalDataSource")
    private String nonTransactionalDataSource;
    @JsonProperty("syncQueryTimeoutWithTransactionTimeout")
    private String syncQueryTimeoutWithTransactionTimeout;
    @JsonProperty("userDefinedErrorMap")
    private String userDefinedErrorMap;
    @JsonProperty("validateNewConnectionTimeout")
    private String validateNewConnectionTimeout;
    @JsonProperty("webSphereDefaultIsolationLevel")
    private String webSphereDefaultIsolationLevel;
    @JsonProperty("webSphereDefaultQueryTimeout")
    private String webSphereDefaultQueryTimeout;
    @JsonProperty("JDBCBehavior")
    private String jDBCBehavior;
    @JsonProperty("accountingInfo")
    private String accountingInfo;
    @JsonProperty("alternateServers")
    private String alternateServers;
    @JsonProperty("applicationName")
    private String applicationName;
    @JsonProperty("batchPerformanceWorkaround")
    private String batchPerformanceWorkaround;
    @JsonProperty("bulkLoadBatchSize")
    private String bulkLoadBatchSize;
    @JsonProperty("catalogIncludesSynonyms")
    private String catalogIncludesSynonyms;
    @JsonProperty("catalogOptions")
    private String catalogOptions;
    @JsonProperty("clientAcctInfo")
    private String clientAcctInfo;
    @JsonProperty("clientAppName")
    private String clientAppName;
    @JsonProperty("clientHostName")
    private String clientHostName;
    @JsonProperty("clientLanguage")
    private String clientLanguage;
    @JsonProperty("clientProgramID")
    private String clientProgramID;
    @JsonProperty("clientUser")
    private String clientUser;
    @JsonProperty("clobCodePage")
    private String clobCodePage;
    @JsonProperty("codePage")
    private String codePage;
    @JsonProperty("connectionLog")
    private String connectionLog;
    @JsonProperty("connectionRetryCount")
    private String connectionRetryCount;
    @JsonProperty("connectionRetryDelay")
    private String connectionRetryDelay;
    @JsonProperty("convertNull")
    private String convertNull;
    @JsonProperty("cursorHoldability")
    private String cursorHoldability;
    @JsonProperty("dateFormat")
    private String dateFormat;
    @JsonProperty("defaultSchema")
    private String defaultSchema;
    @JsonProperty("embedded")
    private String embedded;
    @JsonProperty("enableBulkLoad")
    private String enableBulkLoad;
    @JsonProperty("encryptionMethod")
    private String encryptionMethod;
    @JsonProperty("extendedOptions")
    private String extendedOptions;
    @JsonProperty("failoverGranularity")
    private String failoverGranularity;
    @JsonProperty("failoverMode")
    private String failoverMode;
    @JsonProperty("failoverPreconnect")
    private String failoverPreconnect;
    @JsonProperty("future1")
    private String future1;
    @JsonProperty("future2")
    private String future2;
    @JsonProperty("future3")
    private String future3;
    @JsonProperty("future4")
    private String future4;
    @JsonProperty("future5")
    private String future5;
    @JsonProperty("future6")
    private String future6;
    @JsonProperty("hostNameInCertificate")
    private String hostNameInCertificate;
    @JsonProperty("idleConnectionTimeout")
    private String idleConnectionTimeout;
    @JsonProperty("importStatementPool")
    private String importStatementPool;
    @JsonProperty("initialPoolSize")
    private String initialPoolSize;
    @JsonProperty("initializationString")
    private String initializationString;
    @JsonProperty("insensitiveResultSetBufferSize")
    private String insensitiveResultSetBufferSize;
    @JsonProperty("isolationLevel")
    private String isolationLevel;
    @JsonProperty("javaDoubleToString")
    private String javaDoubleToString;
    @JsonProperty("loadBalancing")
    private String loadBalancing;
    @JsonProperty("loadLibraryPath")
    private String loadLibraryPath;
    @JsonProperty("lockWaitTimeout")
    private String lockWaitTimeout;
    @JsonProperty("logWriter")
    private String logWriter;
    @JsonProperty("maxIdleTime")
    private String maxIdleTime;
    @JsonProperty("maxOpenCursors")
    private String maxOpenCursors;
    @JsonProperty("maxPoolSize")
    private String maxPoolSize;
    @JsonProperty("maxPooledStatements")
    private String maxPooledStatements;
    @JsonProperty("maxStatements")
    private String maxStatements;
    @JsonProperty("maxXids")
    private String maxXids;
    @JsonProperty("minPoolSize")
    private String minPoolSize;
    @JsonProperty("numericFormat")
    private String numericFormat;
    @JsonProperty("password")
    private String password;
    @JsonProperty("privateBuffers")
    private String privateBuffers;
    @JsonProperty("programID")
    private String programID;
    @JsonProperty("promsgsCharSet")
    private String promsgsCharSet;
    @JsonProperty("propertyCycle")
    private String propertyCycle;
    @JsonProperty("queryTimeout")
    private String queryTimeout;
    @JsonProperty("resultsetMetaDataOptions")
    private String resultsetMetaDataOptions;
    @JsonProperty("roleName")
    private String roleName;
    @JsonProperty("serverLog")
    private String serverLog;
    @JsonProperty("serviceName")
    private String serviceName;
    @JsonProperty("spyAttributes")
    private String spyAttributes;
    @JsonProperty("sqlDebug")
    private String sqlDebug;
    @JsonProperty("statementCacheSize")
    private String statementCacheSize;
    @JsonProperty("tempStoreDisk")
    private String tempStoreDisk;
    @JsonProperty("threadStackSize")
    private String threadStackSize;
    @JsonProperty("trustStore")
    private String trustStore;
    @JsonProperty("trustStorePassword")
    private String trustStorePassword;
    @JsonProperty("user")
    private String user;
    @JsonProperty("userType")
    private String userType;
    @JsonProperty("validateServerCertificate")
    private String validateServerCertificate;
    @JsonProperty("w")
    private String w;
    @JsonProperty("workarounds")
    private String workarounds;
    @JsonProperty("z")
    private String z;
    @JsonProperty("connectionProperties")
    private String connectionProperties;
    @JsonProperty("connectionAttributes")
    private String connectionAttributes;
    @JsonProperty("createDatabase")
    private String createDatabase;
    @JsonProperty("cryptoProtocolVersion")
    private String cryptoProtocolVersion;
    @JsonProperty("loginConfigName")
    private String loginConfigName;
    @JsonProperty("randomGenerator")
    private String randomGenerator;
    @JsonProperty("registerStatementPoolMonitorMBean")
    private String registerStatementPoolMonitorMBean;
    @JsonProperty("secureRandomAlgorithm")
    private String secureRandomAlgorithm;
    @JsonProperty("servicePrincipalName")
    private String servicePrincipalName;
    @JsonProperty("truncateTooLarge")
    private String truncateTooLarge;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("TNSEntryName")
    public String getTNSEntryName() {
        return tNSEntryName;
    }

    @JsonProperty("TNSEntryName")
    public void setTNSEntryName(String tNSEntryName) {
        this.tNSEntryName = tNSEntryName;
    }

    @JsonProperty("URL")
    public String getUrl() {
        return url;
    }

    @JsonProperty("URL")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("connRetriesDuringDBFailover")
    public String getConnRetriesDuringDBFailover() {
        return connRetriesDuringDBFailover;
    }

    @JsonProperty("connRetriesDuringDBFailover")
    public void setConnRetriesDuringDBFailover(String connRetriesDuringDBFailover) {
        this.connRetriesDuringDBFailover = connRetriesDuringDBFailover;
    }

    @JsonProperty("connRetryIntervalDuringDBFailover")
    public String getConnRetryIntervalDuringDBFailover() {
        return connRetryIntervalDuringDBFailover;
    }

    @JsonProperty("connRetryIntervalDuringDBFailover")
    public void setConnRetryIntervalDuringDBFailover(String connRetryIntervalDuringDBFailover) {
        this.connRetryIntervalDuringDBFailover = connRetryIntervalDuringDBFailover;
    }

    @JsonProperty("dataSourceName")
    public String getDataSourceName() {
        return dataSourceName;
    }

    @JsonProperty("dataSourceName")
    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }

    @JsonProperty("databaseName")
    public String getDatabaseName() {
        return databaseName;
    }

    @JsonProperty("databaseName")
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    @JsonProperty("dbFailOverEnabled")
    public String getDbFailOverEnabled() {
        return dbFailOverEnabled;
    }

    @JsonProperty("dbFailOverEnabled")
    public void setDbFailOverEnabled(String dbFailOverEnabled) {
        this.dbFailOverEnabled = dbFailOverEnabled;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("driverType")
    public String getDriverType() {
        return driverType;
    }

    @JsonProperty("driverType")
    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    @JsonProperty("enableMultithreadedAccessDetection")
    public String getEnableMultithreadedAccessDetection() {
        return enableMultithreadedAccessDetection;
    }

    @JsonProperty("enableMultithreadedAccessDetection")
    public void setEnableMultithreadedAccessDetection(String enableMultithreadedAccessDetection) {
        this.enableMultithreadedAccessDetection = enableMultithreadedAccessDetection;
    }

    @JsonProperty("jmsOnePhaseOptimization")
    public String getJmsOnePhaseOptimization() {
        return jmsOnePhaseOptimization;
    }

    @JsonProperty("jmsOnePhaseOptimization")
    public void setJmsOnePhaseOptimization(String jmsOnePhaseOptimization) {
        this.jmsOnePhaseOptimization = jmsOnePhaseOptimization;
    }

    @JsonProperty("loginTimeout")
    public String getLoginTimeout() {
        return loginTimeout;
    }

    @JsonProperty("loginTimeout")
    public void setLoginTimeout(String loginTimeout) {
        this.loginTimeout = loginTimeout;
    }

    @JsonProperty("networkProtocol")
    public String getNetworkProtocol() {
        return networkProtocol;
    }

    @JsonProperty("networkProtocol")
    public void setNetworkProtocol(String networkProtocol) {
        this.networkProtocol = networkProtocol;
    }

    @JsonProperty("oracle9iLogTraceLevel")
    public String getOracle9iLogTraceLevel() {
        return oracle9iLogTraceLevel;
    }

    @JsonProperty("oracle9iLogTraceLevel")
    public void setOracle9iLogTraceLevel(String oracle9iLogTraceLevel) {
        this.oracle9iLogTraceLevel = oracle9iLogTraceLevel;
    }

    @JsonProperty("oracleLogFileCount")
    public String getOracleLogFileCount() {
        return oracleLogFileCount;
    }

    @JsonProperty("oracleLogFileCount")
    public void setOracleLogFileCount(String oracleLogFileCount) {
        this.oracleLogFileCount = oracleLogFileCount;
    }

    @JsonProperty("oracleLogFileName")
    public String getOracleLogFileName() {
        return oracleLogFileName;
    }

    @JsonProperty("oracleLogFileName")
    public void setOracleLogFileName(String oracleLogFileName) {
        this.oracleLogFileName = oracleLogFileName;
    }

    @JsonProperty("oracleLogFileSizeLimit")
    public String getOracleLogFileSizeLimit() {
        return oracleLogFileSizeLimit;
    }

    @JsonProperty("oracleLogFileSizeLimit")
    public void setOracleLogFileSizeLimit(String oracleLogFileSizeLimit) {
        this.oracleLogFileSizeLimit = oracleLogFileSizeLimit;
    }

    @JsonProperty("oracleLogFormat")
    public String getOracleLogFormat() {
        return oracleLogFormat;
    }

    @JsonProperty("oracleLogFormat")
    public void setOracleLogFormat(String oracleLogFormat) {
        this.oracleLogFormat = oracleLogFormat;
    }

    @JsonProperty("oracleLogPackageName")
    public String getOracleLogPackageName() {
        return oracleLogPackageName;
    }

    @JsonProperty("oracleLogPackageName")
    public void setOracleLogPackageName(String oracleLogPackageName) {
        this.oracleLogPackageName = oracleLogPackageName;
    }

    @JsonProperty("oracleLogTraceLevel")
    public String getOracleLogTraceLevel() {
        return oracleLogTraceLevel;
    }

    @JsonProperty("oracleLogTraceLevel")
    public void setOracleLogTraceLevel(String oracleLogTraceLevel) {
        this.oracleLogTraceLevel = oracleLogTraceLevel;
    }

    @JsonProperty("portNumber")
    public String getPortNumber() {
        return portNumber;
    }

    @JsonProperty("portNumber")
    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    @JsonProperty("preTestSQLString")
    public String getPreTestSQLString() {
        return preTestSQLString;
    }

    @JsonProperty("preTestSQLString")
    public void setPreTestSQLString(String preTestSQLString) {
        this.preTestSQLString = preTestSQLString;
    }

    @JsonProperty("reauthentication")
    public String getReauthentication() {
        return reauthentication;
    }

    @JsonProperty("reauthentication")
    public void setReauthentication(String reauthentication) {
        this.reauthentication = reauthentication;
    }

    @JsonProperty("serverName")
    public String getServerName() {
        return serverName;
    }

    @JsonProperty("serverName")
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    @JsonProperty("validateNewConnection")
    public String getValidateNewConnection() {
        return validateNewConnection;
    }

    @JsonProperty("validateNewConnection")
    public void setValidateNewConnection(String validateNewConnection) {
        this.validateNewConnection = validateNewConnection;
    }

    @JsonProperty("validateNewConnectionRetryCount")
    public String getValidateNewConnectionRetryCount() {
        return validateNewConnectionRetryCount;
    }

    @JsonProperty("validateNewConnectionRetryCount")
    public void setValidateNewConnectionRetryCount(String validateNewConnectionRetryCount) {
        this.validateNewConnectionRetryCount = validateNewConnectionRetryCount;
    }

    @JsonProperty("validateNewConnectionRetryInterval")
    public String getValidateNewConnectionRetryInterval() {
        return validateNewConnectionRetryInterval;
    }

    @JsonProperty("validateNewConnectionRetryInterval")
    public void setValidateNewConnectionRetryInterval(String validateNewConnectionRetryInterval) {
        this.validateNewConnectionRetryInterval = validateNewConnectionRetryInterval;
    }

    @JsonProperty("beginTranForResultSetScrollingAPIs")
    public String getBeginTranForResultSetScrollingAPIs() {
        return beginTranForResultSetScrollingAPIs;
    }

    @JsonProperty("beginTranForResultSetScrollingAPIs")
    public void setBeginTranForResultSetScrollingAPIs(String beginTranForResultSetScrollingAPIs) {
        this.beginTranForResultSetScrollingAPIs = beginTranForResultSetScrollingAPIs;
    }

    @JsonProperty("beginTranForVendorAPIs")
    public String getBeginTranForVendorAPIs() {
        return beginTranForVendorAPIs;
    }

    @JsonProperty("beginTranForVendorAPIs")
    public void setBeginTranForVendorAPIs(String beginTranForVendorAPIs) {
        this.beginTranForVendorAPIs = beginTranForVendorAPIs;
    }

    @JsonProperty("connectionSharing")
    public String getConnectionSharing() {
        return connectionSharing;
    }

    @JsonProperty("connectionSharing")
    public void setConnectionSharing(String connectionSharing) {
        this.connectionSharing = connectionSharing;
    }

    @JsonProperty("enableClientInformation")
    public String getEnableClientInformation() {
        return enableClientInformation;
    }

    @JsonProperty("enableClientInformation")
    public void setEnableClientInformation(String enableClientInformation) {
        this.enableClientInformation = enableClientInformation;
    }

    @JsonProperty("errorDetectionModel")
    public String getErrorDetectionModel() {
        return errorDetectionModel;
    }

    @JsonProperty("errorDetectionModel")
    public void setErrorDetectionModel(String errorDetectionModel) {
        this.errorDetectionModel = errorDetectionModel;
    }

    @JsonProperty("freeResourcesOnClose")
    public String getFreeResourcesOnClose() {
        return freeResourcesOnClose;
    }

    @JsonProperty("freeResourcesOnClose")
    public void setFreeResourcesOnClose(String freeResourcesOnClose) {
        this.freeResourcesOnClose = freeResourcesOnClose;
    }

    @JsonProperty("nonTransactionalDataSource")
    public String getNonTransactionalDataSource() {
        return nonTransactionalDataSource;
    }

    @JsonProperty("nonTransactionalDataSource")
    public void setNonTransactionalDataSource(String nonTransactionalDataSource) {
        this.nonTransactionalDataSource = nonTransactionalDataSource;
    }

    @JsonProperty("syncQueryTimeoutWithTransactionTimeout")
    public String getSyncQueryTimeoutWithTransactionTimeout() {
        return syncQueryTimeoutWithTransactionTimeout;
    }

    @JsonProperty("syncQueryTimeoutWithTransactionTimeout")
    public void setSyncQueryTimeoutWithTransactionTimeout(String syncQueryTimeoutWithTransactionTimeout) {
        this.syncQueryTimeoutWithTransactionTimeout = syncQueryTimeoutWithTransactionTimeout;
    }

    @JsonProperty("userDefinedErrorMap")
    public String getUserDefinedErrorMap() {
        return userDefinedErrorMap;
    }

    @JsonProperty("userDefinedErrorMap")
    public void setUserDefinedErrorMap(String userDefinedErrorMap) {
        this.userDefinedErrorMap = userDefinedErrorMap;
    }

    @JsonProperty("validateNewConnectionTimeout")
    public String getValidateNewConnectionTimeout() {
        return validateNewConnectionTimeout;
    }

    @JsonProperty("validateNewConnectionTimeout")
    public void setValidateNewConnectionTimeout(String validateNewConnectionTimeout) {
        this.validateNewConnectionTimeout = validateNewConnectionTimeout;
    }

    @JsonProperty("webSphereDefaultIsolationLevel")
    public String getWebSphereDefaultIsolationLevel() {
        return webSphereDefaultIsolationLevel;
    }

    @JsonProperty("webSphereDefaultIsolationLevel")
    public void setWebSphereDefaultIsolationLevel(String webSphereDefaultIsolationLevel) {
        this.webSphereDefaultIsolationLevel = webSphereDefaultIsolationLevel;
    }

    @JsonProperty("webSphereDefaultQueryTimeout")
    public String getWebSphereDefaultQueryTimeout() {
        return webSphereDefaultQueryTimeout;
    }

    @JsonProperty("webSphereDefaultQueryTimeout")
    public void setWebSphereDefaultQueryTimeout(String webSphereDefaultQueryTimeout) {
        this.webSphereDefaultQueryTimeout = webSphereDefaultQueryTimeout;
    }

    @JsonProperty("JDBCBehavior")
    public String getJDBCBehavior() {
        return jDBCBehavior;
    }

    @JsonProperty("JDBCBehavior")
    public void setJDBCBehavior(String jDBCBehavior) {
        this.jDBCBehavior = jDBCBehavior;
    }

    @JsonProperty("accountingInfo")
    public String getAccountingInfo() {
        return accountingInfo;
    }

    @JsonProperty("accountingInfo")
    public void setAccountingInfo(String accountingInfo) {
        this.accountingInfo = accountingInfo;
    }

    @JsonProperty("alternateServers")
    public String getAlternateServers() {
        return alternateServers;
    }

    @JsonProperty("alternateServers")
    public void setAlternateServers(String alternateServers) {
        this.alternateServers = alternateServers;
    }

    @JsonProperty("applicationName")
    public String getApplicationName() {
        return applicationName;
    }

    @JsonProperty("applicationName")
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    @JsonProperty("batchPerformanceWorkaround")
    public String getBatchPerformanceWorkaround() {
        return batchPerformanceWorkaround;
    }

    @JsonProperty("batchPerformanceWorkaround")
    public void setBatchPerformanceWorkaround(String batchPerformanceWorkaround) {
        this.batchPerformanceWorkaround = batchPerformanceWorkaround;
    }

    @JsonProperty("bulkLoadBatchSize")
    public String getBulkLoadBatchSize() {
        return bulkLoadBatchSize;
    }

    @JsonProperty("bulkLoadBatchSize")
    public void setBulkLoadBatchSize(String bulkLoadBatchSize) {
        this.bulkLoadBatchSize = bulkLoadBatchSize;
    }

    @JsonProperty("catalogIncludesSynonyms")
    public String getCatalogIncludesSynonyms() {
        return catalogIncludesSynonyms;
    }

    @JsonProperty("catalogIncludesSynonyms")
    public void setCatalogIncludesSynonyms(String catalogIncludesSynonyms) {
        this.catalogIncludesSynonyms = catalogIncludesSynonyms;
    }

    @JsonProperty("catalogOptions")
    public String getCatalogOptions() {
        return catalogOptions;
    }

    @JsonProperty("catalogOptions")
    public void setCatalogOptions(String catalogOptions) {
        this.catalogOptions = catalogOptions;
    }

    @JsonProperty("clientAcctInfo")
    public String getClientAcctInfo() {
        return clientAcctInfo;
    }

    @JsonProperty("clientAcctInfo")
    public void setClientAcctInfo(String clientAcctInfo) {
        this.clientAcctInfo = clientAcctInfo;
    }

    @JsonProperty("clientAppName")
    public String getClientAppName() {
        return clientAppName;
    }

    @JsonProperty("clientAppName")
    public void setClientAppName(String clientAppName) {
        this.clientAppName = clientAppName;
    }

    @JsonProperty("clientHostName")
    public String getClientHostName() {
        return clientHostName;
    }

    @JsonProperty("clientHostName")
    public void setClientHostName(String clientHostName) {
        this.clientHostName = clientHostName;
    }

    @JsonProperty("clientLanguage")
    public String getClientLanguage() {
        return clientLanguage;
    }

    @JsonProperty("clientLanguage")
    public void setClientLanguage(String clientLanguage) {
        this.clientLanguage = clientLanguage;
    }

    @JsonProperty("clientProgramID")
    public String getClientProgramID() {
        return clientProgramID;
    }

    @JsonProperty("clientProgramID")
    public void setClientProgramID(String clientProgramID) {
        this.clientProgramID = clientProgramID;
    }

    @JsonProperty("clientUser")
    public String getClientUser() {
        return clientUser;
    }

    @JsonProperty("clientUser")
    public void setClientUser(String clientUser) {
        this.clientUser = clientUser;
    }

    @JsonProperty("clobCodePage")
    public String getClobCodePage() {
        return clobCodePage;
    }

    @JsonProperty("clobCodePage")
    public void setClobCodePage(String clobCodePage) {
        this.clobCodePage = clobCodePage;
    }

    @JsonProperty("codePage")
    public String getCodePage() {
        return codePage;
    }

    @JsonProperty("codePage")
    public void setCodePage(String codePage) {
        this.codePage = codePage;
    }

    @JsonProperty("connectionLog")
    public String getConnectionLog() {
        return connectionLog;
    }

    @JsonProperty("connectionLog")
    public void setConnectionLog(String connectionLog) {
        this.connectionLog = connectionLog;
    }

    @JsonProperty("connectionRetryCount")
    public String getConnectionRetryCount() {
        return connectionRetryCount;
    }

    @JsonProperty("connectionRetryCount")
    public void setConnectionRetryCount(String connectionRetryCount) {
        this.connectionRetryCount = connectionRetryCount;
    }

    @JsonProperty("connectionRetryDelay")
    public String getConnectionRetryDelay() {
        return connectionRetryDelay;
    }

    @JsonProperty("connectionRetryDelay")
    public void setConnectionRetryDelay(String connectionRetryDelay) {
        this.connectionRetryDelay = connectionRetryDelay;
    }

    @JsonProperty("convertNull")
    public String getConvertNull() {
        return convertNull;
    }

    @JsonProperty("convertNull")
    public void setConvertNull(String convertNull) {
        this.convertNull = convertNull;
    }

    @JsonProperty("cursorHoldability")
    public String getCursorHoldability() {
        return cursorHoldability;
    }

    @JsonProperty("cursorHoldability")
    public void setCursorHoldability(String cursorHoldability) {
        this.cursorHoldability = cursorHoldability;
    }

    @JsonProperty("dateFormat")
    public String getDateFormat() {
        return dateFormat;
    }

    @JsonProperty("dateFormat")
    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @JsonProperty("defaultSchema")
    public String getDefaultSchema() {
        return defaultSchema;
    }

    @JsonProperty("defaultSchema")
    public void setDefaultSchema(String defaultSchema) {
        this.defaultSchema = defaultSchema;
    }

    @JsonProperty("embedded")
    public String getEmbedded() {
        return embedded;
    }

    @JsonProperty("embedded")
    public void setEmbedded(String embedded) {
        this.embedded = embedded;
    }

    @JsonProperty("enableBulkLoad")
    public String getEnableBulkLoad() {
        return enableBulkLoad;
    }

    @JsonProperty("enableBulkLoad")
    public void setEnableBulkLoad(String enableBulkLoad) {
        this.enableBulkLoad = enableBulkLoad;
    }

    @JsonProperty("encryptionMethod")
    public String getEncryptionMethod() {
        return encryptionMethod;
    }

    @JsonProperty("encryptionMethod")
    public void setEncryptionMethod(String encryptionMethod) {
        this.encryptionMethod = encryptionMethod;
    }

    @JsonProperty("extendedOptions")
    public String getExtendedOptions() {
        return extendedOptions;
    }

    @JsonProperty("extendedOptions")
    public void setExtendedOptions(String extendedOptions) {
        this.extendedOptions = extendedOptions;
    }

    @JsonProperty("failoverGranularity")
    public String getFailoverGranularity() {
        return failoverGranularity;
    }

    @JsonProperty("failoverGranularity")
    public void setFailoverGranularity(String failoverGranularity) {
        this.failoverGranularity = failoverGranularity;
    }

    @JsonProperty("failoverMode")
    public String getFailoverMode() {
        return failoverMode;
    }

    @JsonProperty("failoverMode")
    public void setFailoverMode(String failoverMode) {
        this.failoverMode = failoverMode;
    }

    @JsonProperty("failoverPreconnect")
    public String getFailoverPreconnect() {
        return failoverPreconnect;
    }

    @JsonProperty("failoverPreconnect")
    public void setFailoverPreconnect(String failoverPreconnect) {
        this.failoverPreconnect = failoverPreconnect;
    }

    @JsonProperty("future1")
    public String getFuture1() {
        return future1;
    }

    @JsonProperty("future1")
    public void setFuture1(String future1) {
        this.future1 = future1;
    }

    @JsonProperty("future2")
    public String getFuture2() {
        return future2;
    }

    @JsonProperty("future2")
    public void setFuture2(String future2) {
        this.future2 = future2;
    }

    @JsonProperty("future3")
    public String getFuture3() {
        return future3;
    }

    @JsonProperty("future3")
    public void setFuture3(String future3) {
        this.future3 = future3;
    }

    @JsonProperty("future4")
    public String getFuture4() {
        return future4;
    }

    @JsonProperty("future4")
    public void setFuture4(String future4) {
        this.future4 = future4;
    }

    @JsonProperty("future5")
    public String getFuture5() {
        return future5;
    }

    @JsonProperty("future5")
    public void setFuture5(String future5) {
        this.future5 = future5;
    }

    @JsonProperty("future6")
    public String getFuture6() {
        return future6;
    }

    @JsonProperty("future6")
    public void setFuture6(String future6) {
        this.future6 = future6;
    }

    @JsonProperty("hostNameInCertificate")
    public String getHostNameInCertificate() {
        return hostNameInCertificate;
    }

    @JsonProperty("hostNameInCertificate")
    public void setHostNameInCertificate(String hostNameInCertificate) {
        this.hostNameInCertificate = hostNameInCertificate;
    }

    @JsonProperty("idleConnectionTimeout")
    public String getIdleConnectionTimeout() {
        return idleConnectionTimeout;
    }

    @JsonProperty("idleConnectionTimeout")
    public void setIdleConnectionTimeout(String idleConnectionTimeout) {
        this.idleConnectionTimeout = idleConnectionTimeout;
    }

    @JsonProperty("importStatementPool")
    public String getImportStatementPool() {
        return importStatementPool;
    }

    @JsonProperty("importStatementPool")
    public void setImportStatementPool(String importStatementPool) {
        this.importStatementPool = importStatementPool;
    }

    @JsonProperty("initialPoolSize")
    public String getInitialPoolSize() {
        return initialPoolSize;
    }

    @JsonProperty("initialPoolSize")
    public void setInitialPoolSize(String initialPoolSize) {
        this.initialPoolSize = initialPoolSize;
    }

    @JsonProperty("initializationString")
    public String getInitializationString() {
        return initializationString;
    }

    @JsonProperty("initializationString")
    public void setInitializationString(String initializationString) {
        this.initializationString = initializationString;
    }

    @JsonProperty("insensitiveResultSetBufferSize")
    public String getInsensitiveResultSetBufferSize() {
        return insensitiveResultSetBufferSize;
    }

    @JsonProperty("insensitiveResultSetBufferSize")
    public void setInsensitiveResultSetBufferSize(String insensitiveResultSetBufferSize) {
        this.insensitiveResultSetBufferSize = insensitiveResultSetBufferSize;
    }

    @JsonProperty("isolationLevel")
    public String getIsolationLevel() {
        return isolationLevel;
    }

    @JsonProperty("isolationLevel")
    public void setIsolationLevel(String isolationLevel) {
        this.isolationLevel = isolationLevel;
    }

    @JsonProperty("javaDoubleToString")
    public String getJavaDoubleToString() {
        return javaDoubleToString;
    }

    @JsonProperty("javaDoubleToString")
    public void setJavaDoubleToString(String javaDoubleToString) {
        this.javaDoubleToString = javaDoubleToString;
    }

    @JsonProperty("loadBalancing")
    public String getLoadBalancing() {
        return loadBalancing;
    }

    @JsonProperty("loadBalancing")
    public void setLoadBalancing(String loadBalancing) {
        this.loadBalancing = loadBalancing;
    }

    @JsonProperty("loadLibraryPath")
    public String getLoadLibraryPath() {
        return loadLibraryPath;
    }

    @JsonProperty("loadLibraryPath")
    public void setLoadLibraryPath(String loadLibraryPath) {
        this.loadLibraryPath = loadLibraryPath;
    }

    @JsonProperty("lockWaitTimeout")
    public String getLockWaitTimeout() {
        return lockWaitTimeout;
    }

    @JsonProperty("lockWaitTimeout")
    public void setLockWaitTimeout(String lockWaitTimeout) {
        this.lockWaitTimeout = lockWaitTimeout;
    }

    @JsonProperty("logWriter")
    public String getLogWriter() {
        return logWriter;
    }

    @JsonProperty("logWriter")
    public void setLogWriter(String logWriter) {
        this.logWriter = logWriter;
    }

    @JsonProperty("maxIdleTime")
    public String getMaxIdleTime() {
        return maxIdleTime;
    }

    @JsonProperty("maxIdleTime")
    public void setMaxIdleTime(String maxIdleTime) {
        this.maxIdleTime = maxIdleTime;
    }

    @JsonProperty("maxOpenCursors")
    public String getMaxOpenCursors() {
        return maxOpenCursors;
    }

    @JsonProperty("maxOpenCursors")
    public void setMaxOpenCursors(String maxOpenCursors) {
        this.maxOpenCursors = maxOpenCursors;
    }

    @JsonProperty("maxPoolSize")
    public String getMaxPoolSize() {
        return maxPoolSize;
    }

    @JsonProperty("maxPoolSize")
    public void setMaxPoolSize(String maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    @JsonProperty("maxPooledStatements")
    public String getMaxPooledStatements() {
        return maxPooledStatements;
    }

    @JsonProperty("maxPooledStatements")
    public void setMaxPooledStatements(String maxPooledStatements) {
        this.maxPooledStatements = maxPooledStatements;
    }

    @JsonProperty("maxStatements")
    public String getMaxStatements() {
        return maxStatements;
    }

    @JsonProperty("maxStatements")
    public void setMaxStatements(String maxStatements) {
        this.maxStatements = maxStatements;
    }

    @JsonProperty("maxXids")
    public String getMaxXids() {
        return maxXids;
    }

    @JsonProperty("maxXids")
    public void setMaxXids(String maxXids) {
        this.maxXids = maxXids;
    }

    @JsonProperty("minPoolSize")
    public String getMinPoolSize() {
        return minPoolSize;
    }

    @JsonProperty("minPoolSize")
    public void setMinPoolSize(String minPoolSize) {
        this.minPoolSize = minPoolSize;
    }

    @JsonProperty("numericFormat")
    public String getNumericFormat() {
        return numericFormat;
    }

    @JsonProperty("numericFormat")
    public void setNumericFormat(String numericFormat) {
        this.numericFormat = numericFormat;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("privateBuffers")
    public String getPrivateBuffers() {
        return privateBuffers;
    }

    @JsonProperty("privateBuffers")
    public void setPrivateBuffers(String privateBuffers) {
        this.privateBuffers = privateBuffers;
    }

    @JsonProperty("programID")
    public String getProgramID() {
        return programID;
    }

    @JsonProperty("programID")
    public void setProgramID(String programID) {
        this.programID = programID;
    }

    @JsonProperty("promsgsCharSet")
    public String getPromsgsCharSet() {
        return promsgsCharSet;
    }

    @JsonProperty("promsgsCharSet")
    public void setPromsgsCharSet(String promsgsCharSet) {
        this.promsgsCharSet = promsgsCharSet;
    }

    @JsonProperty("propertyCycle")
    public String getPropertyCycle() {
        return propertyCycle;
    }

    @JsonProperty("propertyCycle")
    public void setPropertyCycle(String propertyCycle) {
        this.propertyCycle = propertyCycle;
    }

    @JsonProperty("queryTimeout")
    public String getQueryTimeout() {
        return queryTimeout;
    }

    @JsonProperty("queryTimeout")
    public void setQueryTimeout(String queryTimeout) {
        this.queryTimeout = queryTimeout;
    }

    @JsonProperty("resultsetMetaDataOptions")
    public String getResultsetMetaDataOptions() {
        return resultsetMetaDataOptions;
    }

    @JsonProperty("resultsetMetaDataOptions")
    public void setResultsetMetaDataOptions(String resultsetMetaDataOptions) {
        this.resultsetMetaDataOptions = resultsetMetaDataOptions;
    }

    @JsonProperty("roleName")
    public String getRoleName() {
        return roleName;
    }

    @JsonProperty("roleName")
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @JsonProperty("serverLog")
    public String getServerLog() {
        return serverLog;
    }

    @JsonProperty("serverLog")
    public void setServerLog(String serverLog) {
        this.serverLog = serverLog;
    }

    @JsonProperty("serviceName")
    public String getServiceName() {
        return serviceName;
    }

    @JsonProperty("serviceName")
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @JsonProperty("spyAttributes")
    public String getSpyAttributes() {
        return spyAttributes;
    }

    @JsonProperty("spyAttributes")
    public void setSpyAttributes(String spyAttributes) {
        this.spyAttributes = spyAttributes;
    }

    @JsonProperty("sqlDebug")
    public String getSqlDebug() {
        return sqlDebug;
    }

    @JsonProperty("sqlDebug")
    public void setSqlDebug(String sqlDebug) {
        this.sqlDebug = sqlDebug;
    }

    @JsonProperty("statementCacheSize")
    public String getStatementCacheSize() {
        return statementCacheSize;
    }

    @JsonProperty("statementCacheSize")
    public void setStatementCacheSize(String statementCacheSize) {
        this.statementCacheSize = statementCacheSize;
    }

    @JsonProperty("tempStoreDisk")
    public String getTempStoreDisk() {
        return tempStoreDisk;
    }

    @JsonProperty("tempStoreDisk")
    public void setTempStoreDisk(String tempStoreDisk) {
        this.tempStoreDisk = tempStoreDisk;
    }

    @JsonProperty("threadStackSize")
    public String getThreadStackSize() {
        return threadStackSize;
    }

    @JsonProperty("threadStackSize")
    public void setThreadStackSize(String threadStackSize) {
        this.threadStackSize = threadStackSize;
    }

    @JsonProperty("trustStore")
    public String getTrustStore() {
        return trustStore;
    }

    @JsonProperty("trustStore")
    public void setTrustStore(String trustStore) {
        this.trustStore = trustStore;
    }

    @JsonProperty("trustStorePassword")
    public String getTrustStorePassword() {
        return trustStorePassword;
    }

    @JsonProperty("trustStorePassword")
    public void setTrustStorePassword(String trustStorePassword) {
        this.trustStorePassword = trustStorePassword;
    }

    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    @JsonProperty("userType")
    public String getUserType() {
        return userType;
    }

    @JsonProperty("userType")
    public void setUserType(String userType) {
        this.userType = userType;
    }

    @JsonProperty("validateServerCertificate")
    public String getValidateServerCertificate() {
        return validateServerCertificate;
    }

    @JsonProperty("validateServerCertificate")
    public void setValidateServerCertificate(String validateServerCertificate) {
        this.validateServerCertificate = validateServerCertificate;
    }

    @JsonProperty("w")
    public String getW() {
        return w;
    }

    @JsonProperty("w")
    public void setW(String w) {
        this.w = w;
    }

    @JsonProperty("workarounds")
    public String getWorkarounds() {
        return workarounds;
    }

    @JsonProperty("workarounds")
    public void setWorkarounds(String workarounds) {
        this.workarounds = workarounds;
    }

    @JsonProperty("z")
    public String getZ() {
        return z;
    }

    @JsonProperty("z")
    public void setZ(String z) {
        this.z = z;
    }

    @JsonProperty("connectionProperties")
    public String getConnectionProperties() {
        return connectionProperties;
    }

    @JsonProperty("connectionProperties")
    public void setConnectionProperties(String connectionProperties) {
        this.connectionProperties = connectionProperties;
    }

    @JsonProperty("connectionAttributes")
    public String getConnectionAttributes() {
        return connectionAttributes;
    }

    @JsonProperty("connectionAttributes")
    public void setConnectionAttributes(String connectionAttributes) {
        this.connectionAttributes = connectionAttributes;
    }

    @JsonProperty("createDatabase")
    public String getCreateDatabase() {
        return createDatabase;
    }

    @JsonProperty("createDatabase")
    public void setCreateDatabase(String createDatabase) {
        this.createDatabase = createDatabase;
    }

    @JsonProperty("cryptoProtocolVersion")
    public String getCryptoProtocolVersion() {
        return cryptoProtocolVersion;
    }

    @JsonProperty("cryptoProtocolVersion")
    public void setCryptoProtocolVersion(String cryptoProtocolVersion) {
        this.cryptoProtocolVersion = cryptoProtocolVersion;
    }

    @JsonProperty("loginConfigName")
    public String getLoginConfigName() {
        return loginConfigName;
    }

    @JsonProperty("loginConfigName")
    public void setLoginConfigName(String loginConfigName) {
        this.loginConfigName = loginConfigName;
    }

    @JsonProperty("randomGenerator")
    public String getRandomGenerator() {
        return randomGenerator;
    }

    @JsonProperty("randomGenerator")
    public void setRandomGenerator(String randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @JsonProperty("registerStatementPoolMonitorMBean")
    public String getRegisterStatementPoolMonitorMBean() {
        return registerStatementPoolMonitorMBean;
    }

    @JsonProperty("registerStatementPoolMonitorMBean")
    public void setRegisterStatementPoolMonitorMBean(String registerStatementPoolMonitorMBean) {
        this.registerStatementPoolMonitorMBean = registerStatementPoolMonitorMBean;
    }

    @JsonProperty("secureRandomAlgorithm")
    public String getSecureRandomAlgorithm() {
        return secureRandomAlgorithm;
    }

    @JsonProperty("secureRandomAlgorithm")
    public void setSecureRandomAlgorithm(String secureRandomAlgorithm) {
        this.secureRandomAlgorithm = secureRandomAlgorithm;
    }

    @JsonProperty("servicePrincipalName")
    public String getServicePrincipalName() {
        return servicePrincipalName;
    }

    @JsonProperty("servicePrincipalName")
    public void setServicePrincipalName(String servicePrincipalName) {
        this.servicePrincipalName = servicePrincipalName;
    }

    @JsonProperty("truncateTooLarge")
    public String getTruncateTooLarge() {
        return truncateTooLarge;
    }

    @JsonProperty("truncateTooLarge")
    public void setTruncateTooLarge(String truncateTooLarge) {
        this.truncateTooLarge = truncateTooLarge;
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
        sb.append(Properties.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("tNSEntryName");
        sb.append('=');
        sb.append(((this.tNSEntryName == null)?"<null>":this.tNSEntryName));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("connRetriesDuringDBFailover");
        sb.append('=');
        sb.append(((this.connRetriesDuringDBFailover == null)?"<null>":this.connRetriesDuringDBFailover));
        sb.append(',');
        sb.append("connRetryIntervalDuringDBFailover");
        sb.append('=');
        sb.append(((this.connRetryIntervalDuringDBFailover == null)?"<null>":this.connRetryIntervalDuringDBFailover));
        sb.append(',');
        sb.append("dataSourceName");
        sb.append('=');
        sb.append(((this.dataSourceName == null)?"<null>":this.dataSourceName));
        sb.append(',');
        sb.append("databaseName");
        sb.append('=');
        sb.append(((this.databaseName == null)?"<null>":this.databaseName));
        sb.append(',');
        sb.append("dbFailOverEnabled");
        sb.append('=');
        sb.append(((this.dbFailOverEnabled == null)?"<null>":this.dbFailOverEnabled));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("driverType");
        sb.append('=');
        sb.append(((this.driverType == null)?"<null>":this.driverType));
        sb.append(',');
        sb.append("enableMultithreadedAccessDetection");
        sb.append('=');
        sb.append(((this.enableMultithreadedAccessDetection == null)?"<null>":this.enableMultithreadedAccessDetection));
        sb.append(',');
        sb.append("jmsOnePhaseOptimization");
        sb.append('=');
        sb.append(((this.jmsOnePhaseOptimization == null)?"<null>":this.jmsOnePhaseOptimization));
        sb.append(',');
        sb.append("loginTimeout");
        sb.append('=');
        sb.append(((this.loginTimeout == null)?"<null>":this.loginTimeout));
        sb.append(',');
        sb.append("networkProtocol");
        sb.append('=');
        sb.append(((this.networkProtocol == null)?"<null>":this.networkProtocol));
        sb.append(',');
        sb.append("oracle9iLogTraceLevel");
        sb.append('=');
        sb.append(((this.oracle9iLogTraceLevel == null)?"<null>":this.oracle9iLogTraceLevel));
        sb.append(',');
        sb.append("oracleLogFileCount");
        sb.append('=');
        sb.append(((this.oracleLogFileCount == null)?"<null>":this.oracleLogFileCount));
        sb.append(',');
        sb.append("oracleLogFileName");
        sb.append('=');
        sb.append(((this.oracleLogFileName == null)?"<null>":this.oracleLogFileName));
        sb.append(',');
        sb.append("oracleLogFileSizeLimit");
        sb.append('=');
        sb.append(((this.oracleLogFileSizeLimit == null)?"<null>":this.oracleLogFileSizeLimit));
        sb.append(',');
        sb.append("oracleLogFormat");
        sb.append('=');
        sb.append(((this.oracleLogFormat == null)?"<null>":this.oracleLogFormat));
        sb.append(',');
        sb.append("oracleLogPackageName");
        sb.append('=');
        sb.append(((this.oracleLogPackageName == null)?"<null>":this.oracleLogPackageName));
        sb.append(',');
        sb.append("oracleLogTraceLevel");
        sb.append('=');
        sb.append(((this.oracleLogTraceLevel == null)?"<null>":this.oracleLogTraceLevel));
        sb.append(',');
        sb.append("portNumber");
        sb.append('=');
        sb.append(((this.portNumber == null)?"<null>":this.portNumber));
        sb.append(',');
        sb.append("preTestSQLString");
        sb.append('=');
        sb.append(((this.preTestSQLString == null)?"<null>":this.preTestSQLString));
        sb.append(',');
        sb.append("reauthentication");
        sb.append('=');
        sb.append(((this.reauthentication == null)?"<null>":this.reauthentication));
        sb.append(',');
        sb.append("serverName");
        sb.append('=');
        sb.append(((this.serverName == null)?"<null>":this.serverName));
        sb.append(',');
        sb.append("validateNewConnection");
        sb.append('=');
        sb.append(((this.validateNewConnection == null)?"<null>":this.validateNewConnection));
        sb.append(',');
        sb.append("validateNewConnectionRetryCount");
        sb.append('=');
        sb.append(((this.validateNewConnectionRetryCount == null)?"<null>":this.validateNewConnectionRetryCount));
        sb.append(',');
        sb.append("validateNewConnectionRetryInterval");
        sb.append('=');
        sb.append(((this.validateNewConnectionRetryInterval == null)?"<null>":this.validateNewConnectionRetryInterval));
        sb.append(',');
        sb.append("beginTranForResultSetScrollingAPIs");
        sb.append('=');
        sb.append(((this.beginTranForResultSetScrollingAPIs == null)?"<null>":this.beginTranForResultSetScrollingAPIs));
        sb.append(',');
        sb.append("beginTranForVendorAPIs");
        sb.append('=');
        sb.append(((this.beginTranForVendorAPIs == null)?"<null>":this.beginTranForVendorAPIs));
        sb.append(',');
        sb.append("connectionSharing");
        sb.append('=');
        sb.append(((this.connectionSharing == null)?"<null>":this.connectionSharing));
        sb.append(',');
        sb.append("enableClientInformation");
        sb.append('=');
        sb.append(((this.enableClientInformation == null)?"<null>":this.enableClientInformation));
        sb.append(',');
        sb.append("errorDetectionModel");
        sb.append('=');
        sb.append(((this.errorDetectionModel == null)?"<null>":this.errorDetectionModel));
        sb.append(',');
        sb.append("freeResourcesOnClose");
        sb.append('=');
        sb.append(((this.freeResourcesOnClose == null)?"<null>":this.freeResourcesOnClose));
        sb.append(',');
        sb.append("nonTransactionalDataSource");
        sb.append('=');
        sb.append(((this.nonTransactionalDataSource == null)?"<null>":this.nonTransactionalDataSource));
        sb.append(',');
        sb.append("syncQueryTimeoutWithTransactionTimeout");
        sb.append('=');
        sb.append(((this.syncQueryTimeoutWithTransactionTimeout == null)?"<null>":this.syncQueryTimeoutWithTransactionTimeout));
        sb.append(',');
        sb.append("userDefinedErrorMap");
        sb.append('=');
        sb.append(((this.userDefinedErrorMap == null)?"<null>":this.userDefinedErrorMap));
        sb.append(',');
        sb.append("validateNewConnectionTimeout");
        sb.append('=');
        sb.append(((this.validateNewConnectionTimeout == null)?"<null>":this.validateNewConnectionTimeout));
        sb.append(',');
        sb.append("webSphereDefaultIsolationLevel");
        sb.append('=');
        sb.append(((this.webSphereDefaultIsolationLevel == null)?"<null>":this.webSphereDefaultIsolationLevel));
        sb.append(',');
        sb.append("webSphereDefaultQueryTimeout");
        sb.append('=');
        sb.append(((this.webSphereDefaultQueryTimeout == null)?"<null>":this.webSphereDefaultQueryTimeout));
        sb.append(',');
        sb.append("jDBCBehavior");
        sb.append('=');
        sb.append(((this.jDBCBehavior == null)?"<null>":this.jDBCBehavior));
        sb.append(',');
        sb.append("accountingInfo");
        sb.append('=');
        sb.append(((this.accountingInfo == null)?"<null>":this.accountingInfo));
        sb.append(',');
        sb.append("alternateServers");
        sb.append('=');
        sb.append(((this.alternateServers == null)?"<null>":this.alternateServers));
        sb.append(',');
        sb.append("applicationName");
        sb.append('=');
        sb.append(((this.applicationName == null)?"<null>":this.applicationName));
        sb.append(',');
        sb.append("batchPerformanceWorkaround");
        sb.append('=');
        sb.append(((this.batchPerformanceWorkaround == null)?"<null>":this.batchPerformanceWorkaround));
        sb.append(',');
        sb.append("bulkLoadBatchSize");
        sb.append('=');
        sb.append(((this.bulkLoadBatchSize == null)?"<null>":this.bulkLoadBatchSize));
        sb.append(',');
        sb.append("catalogIncludesSynonyms");
        sb.append('=');
        sb.append(((this.catalogIncludesSynonyms == null)?"<null>":this.catalogIncludesSynonyms));
        sb.append(',');
        sb.append("catalogOptions");
        sb.append('=');
        sb.append(((this.catalogOptions == null)?"<null>":this.catalogOptions));
        sb.append(',');
        sb.append("clientAcctInfo");
        sb.append('=');
        sb.append(((this.clientAcctInfo == null)?"<null>":this.clientAcctInfo));
        sb.append(',');
        sb.append("clientAppName");
        sb.append('=');
        sb.append(((this.clientAppName == null)?"<null>":this.clientAppName));
        sb.append(',');
        sb.append("clientHostName");
        sb.append('=');
        sb.append(((this.clientHostName == null)?"<null>":this.clientHostName));
        sb.append(',');
        sb.append("clientLanguage");
        sb.append('=');
        sb.append(((this.clientLanguage == null)?"<null>":this.clientLanguage));
        sb.append(',');
        sb.append("clientProgramID");
        sb.append('=');
        sb.append(((this.clientProgramID == null)?"<null>":this.clientProgramID));
        sb.append(',');
        sb.append("clientUser");
        sb.append('=');
        sb.append(((this.clientUser == null)?"<null>":this.clientUser));
        sb.append(',');
        sb.append("clobCodePage");
        sb.append('=');
        sb.append(((this.clobCodePage == null)?"<null>":this.clobCodePage));
        sb.append(',');
        sb.append("codePage");
        sb.append('=');
        sb.append(((this.codePage == null)?"<null>":this.codePage));
        sb.append(',');
        sb.append("connectionLog");
        sb.append('=');
        sb.append(((this.connectionLog == null)?"<null>":this.connectionLog));
        sb.append(',');
        sb.append("connectionRetryCount");
        sb.append('=');
        sb.append(((this.connectionRetryCount == null)?"<null>":this.connectionRetryCount));
        sb.append(',');
        sb.append("connectionRetryDelay");
        sb.append('=');
        sb.append(((this.connectionRetryDelay == null)?"<null>":this.connectionRetryDelay));
        sb.append(',');
        sb.append("convertNull");
        sb.append('=');
        sb.append(((this.convertNull == null)?"<null>":this.convertNull));
        sb.append(',');
        sb.append("cursorHoldability");
        sb.append('=');
        sb.append(((this.cursorHoldability == null)?"<null>":this.cursorHoldability));
        sb.append(',');
        sb.append("dateFormat");
        sb.append('=');
        sb.append(((this.dateFormat == null)?"<null>":this.dateFormat));
        sb.append(',');
        sb.append("defaultSchema");
        sb.append('=');
        sb.append(((this.defaultSchema == null)?"<null>":this.defaultSchema));
        sb.append(',');
        sb.append("embedded");
        sb.append('=');
        sb.append(((this.embedded == null)?"<null>":this.embedded));
        sb.append(',');
        sb.append("enableBulkLoad");
        sb.append('=');
        sb.append(((this.enableBulkLoad == null)?"<null>":this.enableBulkLoad));
        sb.append(',');
        sb.append("encryptionMethod");
        sb.append('=');
        sb.append(((this.encryptionMethod == null)?"<null>":this.encryptionMethod));
        sb.append(',');
        sb.append("extendedOptions");
        sb.append('=');
        sb.append(((this.extendedOptions == null)?"<null>":this.extendedOptions));
        sb.append(',');
        sb.append("failoverGranularity");
        sb.append('=');
        sb.append(((this.failoverGranularity == null)?"<null>":this.failoverGranularity));
        sb.append(',');
        sb.append("failoverMode");
        sb.append('=');
        sb.append(((this.failoverMode == null)?"<null>":this.failoverMode));
        sb.append(',');
        sb.append("failoverPreconnect");
        sb.append('=');
        sb.append(((this.failoverPreconnect == null)?"<null>":this.failoverPreconnect));
        sb.append(',');
        sb.append("future1");
        sb.append('=');
        sb.append(((this.future1 == null)?"<null>":this.future1));
        sb.append(',');
        sb.append("future2");
        sb.append('=');
        sb.append(((this.future2 == null)?"<null>":this.future2));
        sb.append(',');
        sb.append("future3");
        sb.append('=');
        sb.append(((this.future3 == null)?"<null>":this.future3));
        sb.append(',');
        sb.append("future4");
        sb.append('=');
        sb.append(((this.future4 == null)?"<null>":this.future4));
        sb.append(',');
        sb.append("future5");
        sb.append('=');
        sb.append(((this.future5 == null)?"<null>":this.future5));
        sb.append(',');
        sb.append("future6");
        sb.append('=');
        sb.append(((this.future6 == null)?"<null>":this.future6));
        sb.append(',');
        sb.append("hostNameInCertificate");
        sb.append('=');
        sb.append(((this.hostNameInCertificate == null)?"<null>":this.hostNameInCertificate));
        sb.append(',');
        sb.append("idleConnectionTimeout");
        sb.append('=');
        sb.append(((this.idleConnectionTimeout == null)?"<null>":this.idleConnectionTimeout));
        sb.append(',');
        sb.append("importStatementPool");
        sb.append('=');
        sb.append(((this.importStatementPool == null)?"<null>":this.importStatementPool));
        sb.append(',');
        sb.append("initialPoolSize");
        sb.append('=');
        sb.append(((this.initialPoolSize == null)?"<null>":this.initialPoolSize));
        sb.append(',');
        sb.append("initializationString");
        sb.append('=');
        sb.append(((this.initializationString == null)?"<null>":this.initializationString));
        sb.append(',');
        sb.append("insensitiveResultSetBufferSize");
        sb.append('=');
        sb.append(((this.insensitiveResultSetBufferSize == null)?"<null>":this.insensitiveResultSetBufferSize));
        sb.append(',');
        sb.append("isolationLevel");
        sb.append('=');
        sb.append(((this.isolationLevel == null)?"<null>":this.isolationLevel));
        sb.append(',');
        sb.append("javaDoubleToString");
        sb.append('=');
        sb.append(((this.javaDoubleToString == null)?"<null>":this.javaDoubleToString));
        sb.append(',');
        sb.append("loadBalancing");
        sb.append('=');
        sb.append(((this.loadBalancing == null)?"<null>":this.loadBalancing));
        sb.append(',');
        sb.append("loadLibraryPath");
        sb.append('=');
        sb.append(((this.loadLibraryPath == null)?"<null>":this.loadLibraryPath));
        sb.append(',');
        sb.append("lockWaitTimeout");
        sb.append('=');
        sb.append(((this.lockWaitTimeout == null)?"<null>":this.lockWaitTimeout));
        sb.append(',');
        sb.append("logWriter");
        sb.append('=');
        sb.append(((this.logWriter == null)?"<null>":this.logWriter));
        sb.append(',');
        sb.append("maxIdleTime");
        sb.append('=');
        sb.append(((this.maxIdleTime == null)?"<null>":this.maxIdleTime));
        sb.append(',');
        sb.append("maxOpenCursors");
        sb.append('=');
        sb.append(((this.maxOpenCursors == null)?"<null>":this.maxOpenCursors));
        sb.append(',');
        sb.append("maxPoolSize");
        sb.append('=');
        sb.append(((this.maxPoolSize == null)?"<null>":this.maxPoolSize));
        sb.append(',');
        sb.append("maxPooledStatements");
        sb.append('=');
        sb.append(((this.maxPooledStatements == null)?"<null>":this.maxPooledStatements));
        sb.append(',');
        sb.append("maxStatements");
        sb.append('=');
        sb.append(((this.maxStatements == null)?"<null>":this.maxStatements));
        sb.append(',');
        sb.append("maxXids");
        sb.append('=');
        sb.append(((this.maxXids == null)?"<null>":this.maxXids));
        sb.append(',');
        sb.append("minPoolSize");
        sb.append('=');
        sb.append(((this.minPoolSize == null)?"<null>":this.minPoolSize));
        sb.append(',');
        sb.append("numericFormat");
        sb.append('=');
        sb.append(((this.numericFormat == null)?"<null>":this.numericFormat));
        sb.append(',');
        sb.append("password");
        sb.append('=');
        sb.append(((this.password == null)?"<null>":this.password));
        sb.append(',');
        sb.append("privateBuffers");
        sb.append('=');
        sb.append(((this.privateBuffers == null)?"<null>":this.privateBuffers));
        sb.append(',');
        sb.append("programID");
        sb.append('=');
        sb.append(((this.programID == null)?"<null>":this.programID));
        sb.append(',');
        sb.append("promsgsCharSet");
        sb.append('=');
        sb.append(((this.promsgsCharSet == null)?"<null>":this.promsgsCharSet));
        sb.append(',');
        sb.append("propertyCycle");
        sb.append('=');
        sb.append(((this.propertyCycle == null)?"<null>":this.propertyCycle));
        sb.append(',');
        sb.append("queryTimeout");
        sb.append('=');
        sb.append(((this.queryTimeout == null)?"<null>":this.queryTimeout));
        sb.append(',');
        sb.append("resultsetMetaDataOptions");
        sb.append('=');
        sb.append(((this.resultsetMetaDataOptions == null)?"<null>":this.resultsetMetaDataOptions));
        sb.append(',');
        sb.append("roleName");
        sb.append('=');
        sb.append(((this.roleName == null)?"<null>":this.roleName));
        sb.append(',');
        sb.append("serverLog");
        sb.append('=');
        sb.append(((this.serverLog == null)?"<null>":this.serverLog));
        sb.append(',');
        sb.append("serviceName");
        sb.append('=');
        sb.append(((this.serviceName == null)?"<null>":this.serviceName));
        sb.append(',');
        sb.append("spyAttributes");
        sb.append('=');
        sb.append(((this.spyAttributes == null)?"<null>":this.spyAttributes));
        sb.append(',');
        sb.append("sqlDebug");
        sb.append('=');
        sb.append(((this.sqlDebug == null)?"<null>":this.sqlDebug));
        sb.append(',');
        sb.append("statementCacheSize");
        sb.append('=');
        sb.append(((this.statementCacheSize == null)?"<null>":this.statementCacheSize));
        sb.append(',');
        sb.append("tempStoreDisk");
        sb.append('=');
        sb.append(((this.tempStoreDisk == null)?"<null>":this.tempStoreDisk));
        sb.append(',');
        sb.append("threadStackSize");
        sb.append('=');
        sb.append(((this.threadStackSize == null)?"<null>":this.threadStackSize));
        sb.append(',');
        sb.append("trustStore");
        sb.append('=');
        sb.append(((this.trustStore == null)?"<null>":this.trustStore));
        sb.append(',');
        sb.append("trustStorePassword");
        sb.append('=');
        sb.append(((this.trustStorePassword == null)?"<null>":this.trustStorePassword));
        sb.append(',');
        sb.append("user");
        sb.append('=');
        sb.append(((this.user == null)?"<null>":this.user));
        sb.append(',');
        sb.append("userType");
        sb.append('=');
        sb.append(((this.userType == null)?"<null>":this.userType));
        sb.append(',');
        sb.append("validateServerCertificate");
        sb.append('=');
        sb.append(((this.validateServerCertificate == null)?"<null>":this.validateServerCertificate));
        sb.append(',');
        sb.append("w");
        sb.append('=');
        sb.append(((this.w == null)?"<null>":this.w));
        sb.append(',');
        sb.append("workarounds");
        sb.append('=');
        sb.append(((this.workarounds == null)?"<null>":this.workarounds));
        sb.append(',');
        sb.append("z");
        sb.append('=');
        sb.append(((this.z == null)?"<null>":this.z));
        sb.append(',');
        sb.append("connectionProperties");
        sb.append('=');
        sb.append(((this.connectionProperties == null)?"<null>":this.connectionProperties));
        sb.append(',');
        sb.append("connectionAttributes");
        sb.append('=');
        sb.append(((this.connectionAttributes == null)?"<null>":this.connectionAttributes));
        sb.append(',');
        sb.append("createDatabase");
        sb.append('=');
        sb.append(((this.createDatabase == null)?"<null>":this.createDatabase));
        sb.append(',');
        sb.append("cryptoProtocolVersion");
        sb.append('=');
        sb.append(((this.cryptoProtocolVersion == null)?"<null>":this.cryptoProtocolVersion));
        sb.append(',');
        sb.append("loginConfigName");
        sb.append('=');
        sb.append(((this.loginConfigName == null)?"<null>":this.loginConfigName));
        sb.append(',');
        sb.append("randomGenerator");
        sb.append('=');
        sb.append(((this.randomGenerator == null)?"<null>":this.randomGenerator));
        sb.append(',');
        sb.append("registerStatementPoolMonitorMBean");
        sb.append('=');
        sb.append(((this.registerStatementPoolMonitorMBean == null)?"<null>":this.registerStatementPoolMonitorMBean));
        sb.append(',');
        sb.append("secureRandomAlgorithm");
        sb.append('=');
        sb.append(((this.secureRandomAlgorithm == null)?"<null>":this.secureRandomAlgorithm));
        sb.append(',');
        sb.append("servicePrincipalName");
        sb.append('=');
        sb.append(((this.servicePrincipalName == null)?"<null>":this.servicePrincipalName));
        sb.append(',');
        sb.append("truncateTooLarge");
        sb.append('=');
        sb.append(((this.truncateTooLarge == null)?"<null>":this.truncateTooLarge));
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
        result = ((result* 31)+((this.connectionProperties == null)? 0 :this.connectionProperties.hashCode()));
        result = ((result* 31)+((this.threadStackSize == null)? 0 :this.threadStackSize.hashCode()));
        result = ((result* 31)+((this.databaseName == null)? 0 :this.databaseName.hashCode()));
        result = ((result* 31)+((this.webSphereDefaultIsolationLevel == null)? 0 :this.webSphereDefaultIsolationLevel.hashCode()));
        result = ((result* 31)+((this.catalogIncludesSynonyms == null)? 0 :this.catalogIncludesSynonyms.hashCode()));
        result = ((result* 31)+((this.dateFormat == null)? 0 :this.dateFormat.hashCode()));
        result = ((result* 31)+((this.oracle9iLogTraceLevel == null)? 0 :this.oracle9iLogTraceLevel.hashCode()));
        result = ((result* 31)+((this.idleConnectionTimeout == null)? 0 :this.idleConnectionTimeout.hashCode()));
        result = ((result* 31)+((this.oracleLogFileName == null)? 0 :this.oracleLogFileName.hashCode()));
        result = ((result* 31)+((this.preTestSQLString == null)? 0 :this.preTestSQLString.hashCode()));
        result = ((result* 31)+((this.portNumber == null)? 0 :this.portNumber.hashCode()));
        result = ((result* 31)+((this.clientAcctInfo == null)? 0 :this.clientAcctInfo.hashCode()));
        result = ((result* 31)+((this.password == null)? 0 :this.password.hashCode()));
        result = ((result* 31)+((this.registerStatementPoolMonitorMBean == null)? 0 :this.registerStatementPoolMonitorMBean.hashCode()));
        result = ((result* 31)+((this.privateBuffers == null)? 0 :this.privateBuffers.hashCode()));
        result = ((result* 31)+((this.validateNewConnectionRetryInterval == null)? 0 :this.validateNewConnectionRetryInterval.hashCode()));
        result = ((result* 31)+((this.errorDetectionModel == null)? 0 :this.errorDetectionModel.hashCode()));
        result = ((result* 31)+((this.validateNewConnectionTimeout == null)? 0 :this.validateNewConnectionTimeout.hashCode()));
        result = ((result* 31)+((this.maxOpenCursors == null)? 0 :this.maxOpenCursors.hashCode()));
        result = ((result* 31)+((this.initialPoolSize == null)? 0 :this.initialPoolSize.hashCode()));
        result = ((result* 31)+((this.numericFormat == null)? 0 :this.numericFormat.hashCode()));
        result = ((result* 31)+((this.clientLanguage == null)? 0 :this.clientLanguage.hashCode()));
        result = ((result* 31)+((this.maxStatements == null)? 0 :this.maxStatements.hashCode()));
        result = ((result* 31)+((this.sqlDebug == null)? 0 :this.sqlDebug.hashCode()));
        result = ((result* 31)+((this.alternateServers == null)? 0 :this.alternateServers.hashCode()));
        result = ((result* 31)+((this.importStatementPool == null)? 0 :this.importStatementPool.hashCode()));
        result = ((result* 31)+((this.maxIdleTime == null)? 0 :this.maxIdleTime.hashCode()));
        result = ((result* 31)+((this.connRetryIntervalDuringDBFailover == null)? 0 :this.connRetryIntervalDuringDBFailover.hashCode()));
        result = ((result* 31)+((this.future3 == null)? 0 :this.future3 .hashCode()));
        result = ((result* 31)+((this.loadBalancing == null)? 0 :this.loadBalancing.hashCode()));
        result = ((result* 31)+((this.future4 == null)? 0 :this.future4 .hashCode()));
        result = ((result* 31)+((this.failoverPreconnect == null)? 0 :this.failoverPreconnect.hashCode()));
        result = ((result* 31)+((this.future5 == null)? 0 :this.future5 .hashCode()));
        result = ((result* 31)+((this.future6 == null)? 0 :this.future6 .hashCode()));
        result = ((result* 31)+((this.createDatabase == null)? 0 :this.createDatabase.hashCode()));
        result = ((result* 31)+((this.future1 == null)? 0 :this.future1 .hashCode()));
        result = ((result* 31)+((this.future2 == null)? 0 :this.future2 .hashCode()));
        result = ((result* 31)+((this.minPoolSize == null)? 0 :this.minPoolSize.hashCode()));
        result = ((result* 31)+((this.lockWaitTimeout == null)? 0 :this.lockWaitTimeout.hashCode()));
        result = ((result* 31)+((this.isolationLevel == null)? 0 :this.isolationLevel.hashCode()));
        result = ((result* 31)+((this.roleName == null)? 0 :this.roleName.hashCode()));
        result = ((result* 31)+((this.serverLog == null)? 0 :this.serverLog.hashCode()));
        result = ((result* 31)+((this.randomGenerator == null)? 0 :this.randomGenerator.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.beginTranForResultSetScrollingAPIs == null)? 0 :this.beginTranForResultSetScrollingAPIs.hashCode()));
        result = ((result* 31)+((this.tNSEntryName == null)? 0 :this.tNSEntryName.hashCode()));
        result = ((result* 31)+((this.maxPoolSize == null)? 0 :this.maxPoolSize.hashCode()));
        result = ((result* 31)+((this.connectionRetryCount == null)? 0 :this.connectionRetryCount.hashCode()));
        result = ((result* 31)+((this.failoverMode == null)? 0 :this.failoverMode.hashCode()));
        result = ((result* 31)+((this.jDBCBehavior == null)? 0 :this.jDBCBehavior.hashCode()));
        result = ((result* 31)+((this.validateServerCertificate == null)? 0 :this.validateServerCertificate.hashCode()));
        result = ((result* 31)+((this.reauthentication == null)? 0 :this.reauthentication.hashCode()));
        result = ((result* 31)+((this.serverName == null)? 0 :this.serverName.hashCode()));
        result = ((result* 31)+((this.encryptionMethod == null)? 0 :this.encryptionMethod.hashCode()));
        result = ((result* 31)+((this.insensitiveResultSetBufferSize == null)? 0 :this.insensitiveResultSetBufferSize.hashCode()));
        result = ((result* 31)+((this.syncQueryTimeoutWithTransactionTimeout == null)? 0 :this.syncQueryTimeoutWithTransactionTimeout.hashCode()));
        result = ((result* 31)+((this.defaultSchema == null)? 0 :this.defaultSchema.hashCode()));
        result = ((result* 31)+((this.promsgsCharSet == null)? 0 :this.promsgsCharSet.hashCode()));
        result = ((result* 31)+((this.userDefinedErrorMap == null)? 0 :this.userDefinedErrorMap.hashCode()));
        result = ((result* 31)+((this.webSphereDefaultQueryTimeout == null)? 0 :this.webSphereDefaultQueryTimeout.hashCode()));
        result = ((result* 31)+((this.cursorHoldability == null)? 0 :this.cursorHoldability.hashCode()));
        result = ((result* 31)+((this.resultsetMetaDataOptions == null)? 0 :this.resultsetMetaDataOptions.hashCode()));
        result = ((result* 31)+((this.truncateTooLarge == null)? 0 :this.truncateTooLarge.hashCode()));
        result = ((result* 31)+((this.enableMultithreadedAccessDetection == null)? 0 :this.enableMultithreadedAccessDetection.hashCode()));
        result = ((result* 31)+((this.codePage == null)? 0 :this.codePage.hashCode()));
        result = ((result* 31)+((this.embedded == null)? 0 :this.embedded.hashCode()));
        result = ((result* 31)+((this.applicationName == null)? 0 :this.applicationName.hashCode()));
        result = ((result* 31)+((this.accountingInfo == null)? 0 :this.accountingInfo.hashCode()));
        result = ((result* 31)+((this.statementCacheSize == null)? 0 :this.statementCacheSize.hashCode()));
        result = ((result* 31)+((this.clientProgramID == null)? 0 :this.clientProgramID.hashCode()));
        result = ((result* 31)+((this.loadLibraryPath == null)? 0 :this.loadLibraryPath.hashCode()));
        result = ((result* 31)+((this.clobCodePage == null)? 0 :this.clobCodePage.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        result = ((result* 31)+((this.dataSourceName == null)? 0 :this.dataSourceName.hashCode()));
        result = ((result* 31)+((this.oracleLogFormat == null)? 0 :this.oracleLogFormat.hashCode()));
        result = ((result* 31)+((this.oracleLogFileSizeLimit == null)? 0 :this.oracleLogFileSizeLimit.hashCode()));
        result = ((result* 31)+((this.enableClientInformation == null)? 0 :this.enableClientInformation.hashCode()));
        result = ((result* 31)+((this.bulkLoadBatchSize == null)? 0 :this.bulkLoadBatchSize.hashCode()));
        result = ((result* 31)+((this.w == null)? 0 :this.w.hashCode()));
        result = ((result* 31)+((this.z == null)? 0 :this.z.hashCode()));
        result = ((result* 31)+((this.validateNewConnectionRetryCount == null)? 0 :this.validateNewConnectionRetryCount.hashCode()));
        result = ((result* 31)+((this.clientUser == null)? 0 :this.clientUser.hashCode()));
        result = ((result* 31)+((this.oracleLogTraceLevel == null)? 0 :this.oracleLogTraceLevel.hashCode()));
        result = ((result* 31)+((this.extendedOptions == null)? 0 :this.extendedOptions.hashCode()));
        result = ((result* 31)+((this.enableBulkLoad == null)? 0 :this.enableBulkLoad.hashCode()));
        result = ((result* 31)+((this.maxPooledStatements == null)? 0 :this.maxPooledStatements.hashCode()));
        result = ((result* 31)+((this.jmsOnePhaseOptimization == null)? 0 :this.jmsOnePhaseOptimization.hashCode()));
        result = ((result* 31)+((this.oracleLogFileCount == null)? 0 :this.oracleLogFileCount.hashCode()));
        result = ((result* 31)+((this.failoverGranularity == null)? 0 :this.failoverGranularity.hashCode()));
        result = ((result* 31)+((this.tempStoreDisk == null)? 0 :this.tempStoreDisk.hashCode()));
        result = ((result* 31)+((this.trustStorePassword == null)? 0 :this.trustStorePassword.hashCode()));
        result = ((result* 31)+((this.dbFailOverEnabled == null)? 0 :this.dbFailOverEnabled.hashCode()));
        result = ((result* 31)+((this.maxXids == null)? 0 :this.maxXids.hashCode()));
        result = ((result* 31)+((this.nonTransactionalDataSource == null)? 0 :this.nonTransactionalDataSource.hashCode()));
        result = ((result* 31)+((this.javaDoubleToString == null)? 0 :this.javaDoubleToString.hashCode()));
        result = ((result* 31)+((this.batchPerformanceWorkaround == null)? 0 :this.batchPerformanceWorkaround.hashCode()));
        result = ((result* 31)+((this.clientHostName == null)? 0 :this.clientHostName.hashCode()));
        result = ((result* 31)+((this.spyAttributes == null)? 0 :this.spyAttributes.hashCode()));
        result = ((result* 31)+((this.beginTranForVendorAPIs == null)? 0 :this.beginTranForVendorAPIs.hashCode()));
        result = ((result* 31)+((this.propertyCycle == null)? 0 :this.propertyCycle.hashCode()));
        result = ((result* 31)+((this.clientAppName == null)? 0 :this.clientAppName.hashCode()));
        result = ((result* 31)+((this.connectionRetryDelay == null)? 0 :this.connectionRetryDelay.hashCode()));
        result = ((result* 31)+((this.trustStore == null)? 0 :this.trustStore.hashCode()));
        result = ((result* 31)+((this.convertNull == null)? 0 :this.convertNull.hashCode()));
        result = ((result* 31)+((this.userType == null)? 0 :this.userType.hashCode()));
        result = ((result* 31)+((this.queryTimeout == null)? 0 :this.queryTimeout.hashCode()));
        result = ((result* 31)+((this.workarounds == null)? 0 :this.workarounds.hashCode()));
        result = ((result* 31)+((this.connRetriesDuringDBFailover == null)? 0 :this.connRetriesDuringDBFailover.hashCode()));
        result = ((result* 31)+((this.connectionAttributes == null)? 0 :this.connectionAttributes.hashCode()));
        result = ((result* 31)+((this.loginConfigName == null)? 0 :this.loginConfigName.hashCode()));
        result = ((result* 31)+((this.logWriter == null)? 0 :this.logWriter.hashCode()));
        result = ((result* 31)+((this.cryptoProtocolVersion == null)? 0 :this.cryptoProtocolVersion.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.initializationString == null)? 0 :this.initializationString.hashCode()));
        result = ((result* 31)+((this.secureRandomAlgorithm == null)? 0 :this.secureRandomAlgorithm.hashCode()));
        result = ((result* 31)+((this.catalogOptions == null)? 0 :this.catalogOptions.hashCode()));
        result = ((result* 31)+((this.servicePrincipalName == null)? 0 :this.servicePrincipalName.hashCode()));
        result = ((result* 31)+((this.validateNewConnection == null)? 0 :this.validateNewConnection.hashCode()));
        result = ((result* 31)+((this.loginTimeout == null)? 0 :this.loginTimeout.hashCode()));
        result = ((result* 31)+((this.connectionSharing == null)? 0 :this.connectionSharing.hashCode()));
        result = ((result* 31)+((this.programID == null)? 0 :this.programID.hashCode()));
        result = ((result* 31)+((this.freeResourcesOnClose == null)? 0 :this.freeResourcesOnClose.hashCode()));
        result = ((result* 31)+((this.serviceName == null)? 0 :this.serviceName.hashCode()));
        result = ((result* 31)+((this.driverType == null)? 0 :this.driverType.hashCode()));
        result = ((result* 31)+((this.connectionLog == null)? 0 :this.connectionLog.hashCode()));
        result = ((result* 31)+((this.oracleLogPackageName == null)? 0 :this.oracleLogPackageName.hashCode()));
        result = ((result* 31)+((this.hostNameInCertificate == null)? 0 :this.hostNameInCertificate.hashCode()));
        result = ((result* 31)+((this.user == null)? 0 :this.user.hashCode()));
        result = ((result* 31)+((this.networkProtocol == null)? 0 :this.networkProtocol.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Properties) == false) {
            return false;
        }
        Properties rhs = ((Properties) other);
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.connectionProperties == rhs.connectionProperties)||((this.connectionProperties!= null)&&this.connectionProperties.equals(rhs.connectionProperties)))&&((this.threadStackSize == rhs.threadStackSize)||((this.threadStackSize!= null)&&this.threadStackSize.equals(rhs.threadStackSize))))&&((this.databaseName == rhs.databaseName)||((this.databaseName!= null)&&this.databaseName.equals(rhs.databaseName))))&&((this.webSphereDefaultIsolationLevel == rhs.webSphereDefaultIsolationLevel)||((this.webSphereDefaultIsolationLevel!= null)&&this.webSphereDefaultIsolationLevel.equals(rhs.webSphereDefaultIsolationLevel))))&&((this.catalogIncludesSynonyms == rhs.catalogIncludesSynonyms)||((this.catalogIncludesSynonyms!= null)&&this.catalogIncludesSynonyms.equals(rhs.catalogIncludesSynonyms))))&&((this.dateFormat == rhs.dateFormat)||((this.dateFormat!= null)&&this.dateFormat.equals(rhs.dateFormat))))&&((this.oracle9iLogTraceLevel == rhs.oracle9iLogTraceLevel)||((this.oracle9iLogTraceLevel!= null)&&this.oracle9iLogTraceLevel.equals(rhs.oracle9iLogTraceLevel))))&&((this.idleConnectionTimeout == rhs.idleConnectionTimeout)||((this.idleConnectionTimeout!= null)&&this.idleConnectionTimeout.equals(rhs.idleConnectionTimeout))))&&((this.oracleLogFileName == rhs.oracleLogFileName)||((this.oracleLogFileName!= null)&&this.oracleLogFileName.equals(rhs.oracleLogFileName))))&&((this.preTestSQLString == rhs.preTestSQLString)||((this.preTestSQLString!= null)&&this.preTestSQLString.equals(rhs.preTestSQLString))))&&((this.portNumber == rhs.portNumber)||((this.portNumber!= null)&&this.portNumber.equals(rhs.portNumber))))&&((this.clientAcctInfo == rhs.clientAcctInfo)||((this.clientAcctInfo!= null)&&this.clientAcctInfo.equals(rhs.clientAcctInfo))))&&((this.password == rhs.password)||((this.password!= null)&&this.password.equals(rhs.password))))&&((this.registerStatementPoolMonitorMBean == rhs.registerStatementPoolMonitorMBean)||((this.registerStatementPoolMonitorMBean!= null)&&this.registerStatementPoolMonitorMBean.equals(rhs.registerStatementPoolMonitorMBean))))&&((this.privateBuffers == rhs.privateBuffers)||((this.privateBuffers!= null)&&this.privateBuffers.equals(rhs.privateBuffers))))&&((this.validateNewConnectionRetryInterval == rhs.validateNewConnectionRetryInterval)||((this.validateNewConnectionRetryInterval!= null)&&this.validateNewConnectionRetryInterval.equals(rhs.validateNewConnectionRetryInterval))))&&((this.errorDetectionModel == rhs.errorDetectionModel)||((this.errorDetectionModel!= null)&&this.errorDetectionModel.equals(rhs.errorDetectionModel))))&&((this.validateNewConnectionTimeout == rhs.validateNewConnectionTimeout)||((this.validateNewConnectionTimeout!= null)&&this.validateNewConnectionTimeout.equals(rhs.validateNewConnectionTimeout))))&&((this.maxOpenCursors == rhs.maxOpenCursors)||((this.maxOpenCursors!= null)&&this.maxOpenCursors.equals(rhs.maxOpenCursors))))&&((this.initialPoolSize == rhs.initialPoolSize)||((this.initialPoolSize!= null)&&this.initialPoolSize.equals(rhs.initialPoolSize))))&&((this.numericFormat == rhs.numericFormat)||((this.numericFormat!= null)&&this.numericFormat.equals(rhs.numericFormat))))&&((this.clientLanguage == rhs.clientLanguage)||((this.clientLanguage!= null)&&this.clientLanguage.equals(rhs.clientLanguage))))&&((this.maxStatements == rhs.maxStatements)||((this.maxStatements!= null)&&this.maxStatements.equals(rhs.maxStatements))))&&((this.sqlDebug == rhs.sqlDebug)||((this.sqlDebug!= null)&&this.sqlDebug.equals(rhs.sqlDebug))))&&((this.alternateServers == rhs.alternateServers)||((this.alternateServers!= null)&&this.alternateServers.equals(rhs.alternateServers))))&&((this.importStatementPool == rhs.importStatementPool)||((this.importStatementPool!= null)&&this.importStatementPool.equals(rhs.importStatementPool))))&&((this.maxIdleTime == rhs.maxIdleTime)||((this.maxIdleTime!= null)&&this.maxIdleTime.equals(rhs.maxIdleTime))))&&((this.connRetryIntervalDuringDBFailover == rhs.connRetryIntervalDuringDBFailover)||((this.connRetryIntervalDuringDBFailover!= null)&&this.connRetryIntervalDuringDBFailover.equals(rhs.connRetryIntervalDuringDBFailover))))&&((this.future3 == rhs.future3)||((this.future3 != null)&&this.future3 .equals(rhs.future3))))&&((this.loadBalancing == rhs.loadBalancing)||((this.loadBalancing!= null)&&this.loadBalancing.equals(rhs.loadBalancing))))&&((this.future4 == rhs.future4)||((this.future4 != null)&&this.future4 .equals(rhs.future4))))&&((this.failoverPreconnect == rhs.failoverPreconnect)||((this.failoverPreconnect!= null)&&this.failoverPreconnect.equals(rhs.failoverPreconnect))))&&((this.future5 == rhs.future5)||((this.future5 != null)&&this.future5 .equals(rhs.future5))))&&((this.future6 == rhs.future6)||((this.future6 != null)&&this.future6 .equals(rhs.future6))))&&((this.createDatabase == rhs.createDatabase)||((this.createDatabase!= null)&&this.createDatabase.equals(rhs.createDatabase))))&&((this.future1 == rhs.future1)||((this.future1 != null)&&this.future1 .equals(rhs.future1))))&&((this.future2 == rhs.future2)||((this.future2 != null)&&this.future2 .equals(rhs.future2))))&&((this.minPoolSize == rhs.minPoolSize)||((this.minPoolSize!= null)&&this.minPoolSize.equals(rhs.minPoolSize))))&&((this.lockWaitTimeout == rhs.lockWaitTimeout)||((this.lockWaitTimeout!= null)&&this.lockWaitTimeout.equals(rhs.lockWaitTimeout))))&&((this.isolationLevel == rhs.isolationLevel)||((this.isolationLevel!= null)&&this.isolationLevel.equals(rhs.isolationLevel))))&&((this.roleName == rhs.roleName)||((this.roleName!= null)&&this.roleName.equals(rhs.roleName))))&&((this.serverLog == rhs.serverLog)||((this.serverLog!= null)&&this.serverLog.equals(rhs.serverLog))))&&((this.randomGenerator == rhs.randomGenerator)||((this.randomGenerator!= null)&&this.randomGenerator.equals(rhs.randomGenerator))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.beginTranForResultSetScrollingAPIs == rhs.beginTranForResultSetScrollingAPIs)||((this.beginTranForResultSetScrollingAPIs!= null)&&this.beginTranForResultSetScrollingAPIs.equals(rhs.beginTranForResultSetScrollingAPIs))))&&((this.tNSEntryName == rhs.tNSEntryName)||((this.tNSEntryName!= null)&&this.tNSEntryName.equals(rhs.tNSEntryName))))&&((this.maxPoolSize == rhs.maxPoolSize)||((this.maxPoolSize!= null)&&this.maxPoolSize.equals(rhs.maxPoolSize))))&&((this.connectionRetryCount == rhs.connectionRetryCount)||((this.connectionRetryCount!= null)&&this.connectionRetryCount.equals(rhs.connectionRetryCount))))&&((this.failoverMode == rhs.failoverMode)||((this.failoverMode!= null)&&this.failoverMode.equals(rhs.failoverMode))))&&((this.jDBCBehavior == rhs.jDBCBehavior)||((this.jDBCBehavior!= null)&&this.jDBCBehavior.equals(rhs.jDBCBehavior))))&&((this.validateServerCertificate == rhs.validateServerCertificate)||((this.validateServerCertificate!= null)&&this.validateServerCertificate.equals(rhs.validateServerCertificate))))&&((this.reauthentication == rhs.reauthentication)||((this.reauthentication!= null)&&this.reauthentication.equals(rhs.reauthentication))))&&((this.serverName == rhs.serverName)||((this.serverName!= null)&&this.serverName.equals(rhs.serverName))))&&((this.encryptionMethod == rhs.encryptionMethod)||((this.encryptionMethod!= null)&&this.encryptionMethod.equals(rhs.encryptionMethod))))&&((this.insensitiveResultSetBufferSize == rhs.insensitiveResultSetBufferSize)||((this.insensitiveResultSetBufferSize!= null)&&this.insensitiveResultSetBufferSize.equals(rhs.insensitiveResultSetBufferSize))))&&((this.syncQueryTimeoutWithTransactionTimeout == rhs.syncQueryTimeoutWithTransactionTimeout)||((this.syncQueryTimeoutWithTransactionTimeout!= null)&&this.syncQueryTimeoutWithTransactionTimeout.equals(rhs.syncQueryTimeoutWithTransactionTimeout))))&&((this.defaultSchema == rhs.defaultSchema)||((this.defaultSchema!= null)&&this.defaultSchema.equals(rhs.defaultSchema))))&&((this.promsgsCharSet == rhs.promsgsCharSet)||((this.promsgsCharSet!= null)&&this.promsgsCharSet.equals(rhs.promsgsCharSet))))&&((this.userDefinedErrorMap == rhs.userDefinedErrorMap)||((this.userDefinedErrorMap!= null)&&this.userDefinedErrorMap.equals(rhs.userDefinedErrorMap))))&&((this.webSphereDefaultQueryTimeout == rhs.webSphereDefaultQueryTimeout)||((this.webSphereDefaultQueryTimeout!= null)&&this.webSphereDefaultQueryTimeout.equals(rhs.webSphereDefaultQueryTimeout))))&&((this.cursorHoldability == rhs.cursorHoldability)||((this.cursorHoldability!= null)&&this.cursorHoldability.equals(rhs.cursorHoldability))))&&((this.resultsetMetaDataOptions == rhs.resultsetMetaDataOptions)||((this.resultsetMetaDataOptions!= null)&&this.resultsetMetaDataOptions.equals(rhs.resultsetMetaDataOptions))))&&((this.truncateTooLarge == rhs.truncateTooLarge)||((this.truncateTooLarge!= null)&&this.truncateTooLarge.equals(rhs.truncateTooLarge))))&&((this.enableMultithreadedAccessDetection == rhs.enableMultithreadedAccessDetection)||((this.enableMultithreadedAccessDetection!= null)&&this.enableMultithreadedAccessDetection.equals(rhs.enableMultithreadedAccessDetection))))&&((this.codePage == rhs.codePage)||((this.codePage!= null)&&this.codePage.equals(rhs.codePage))))&&((this.embedded == rhs.embedded)||((this.embedded!= null)&&this.embedded.equals(rhs.embedded))))&&((this.applicationName == rhs.applicationName)||((this.applicationName!= null)&&this.applicationName.equals(rhs.applicationName))))&&((this.accountingInfo == rhs.accountingInfo)||((this.accountingInfo!= null)&&this.accountingInfo.equals(rhs.accountingInfo))))&&((this.statementCacheSize == rhs.statementCacheSize)||((this.statementCacheSize!= null)&&this.statementCacheSize.equals(rhs.statementCacheSize))))&&((this.clientProgramID == rhs.clientProgramID)||((this.clientProgramID!= null)&&this.clientProgramID.equals(rhs.clientProgramID))))&&((this.loadLibraryPath == rhs.loadLibraryPath)||((this.loadLibraryPath!= null)&&this.loadLibraryPath.equals(rhs.loadLibraryPath))))&&((this.clobCodePage == rhs.clobCodePage)||((this.clobCodePage!= null)&&this.clobCodePage.equals(rhs.clobCodePage))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))))&&((this.dataSourceName == rhs.dataSourceName)||((this.dataSourceName!= null)&&this.dataSourceName.equals(rhs.dataSourceName))))&&((this.oracleLogFormat == rhs.oracleLogFormat)||((this.oracleLogFormat!= null)&&this.oracleLogFormat.equals(rhs.oracleLogFormat))))&&((this.oracleLogFileSizeLimit == rhs.oracleLogFileSizeLimit)||((this.oracleLogFileSizeLimit!= null)&&this.oracleLogFileSizeLimit.equals(rhs.oracleLogFileSizeLimit))))&&((this.enableClientInformation == rhs.enableClientInformation)||((this.enableClientInformation!= null)&&this.enableClientInformation.equals(rhs.enableClientInformation))))&&((this.bulkLoadBatchSize == rhs.bulkLoadBatchSize)||((this.bulkLoadBatchSize!= null)&&this.bulkLoadBatchSize.equals(rhs.bulkLoadBatchSize))))&&((this.w == rhs.w)||((this.w!= null)&&this.w.equals(rhs.w))))&&((this.z == rhs.z)||((this.z!= null)&&this.z.equals(rhs.z))))&&((this.validateNewConnectionRetryCount == rhs.validateNewConnectionRetryCount)||((this.validateNewConnectionRetryCount!= null)&&this.validateNewConnectionRetryCount.equals(rhs.validateNewConnectionRetryCount))))&&((this.clientUser == rhs.clientUser)||((this.clientUser!= null)&&this.clientUser.equals(rhs.clientUser))))&&((this.oracleLogTraceLevel == rhs.oracleLogTraceLevel)||((this.oracleLogTraceLevel!= null)&&this.oracleLogTraceLevel.equals(rhs.oracleLogTraceLevel))))&&((this.extendedOptions == rhs.extendedOptions)||((this.extendedOptions!= null)&&this.extendedOptions.equals(rhs.extendedOptions))))&&((this.enableBulkLoad == rhs.enableBulkLoad)||((this.enableBulkLoad!= null)&&this.enableBulkLoad.equals(rhs.enableBulkLoad))))&&((this.maxPooledStatements == rhs.maxPooledStatements)||((this.maxPooledStatements!= null)&&this.maxPooledStatements.equals(rhs.maxPooledStatements))))&&((this.jmsOnePhaseOptimization == rhs.jmsOnePhaseOptimization)||((this.jmsOnePhaseOptimization!= null)&&this.jmsOnePhaseOptimization.equals(rhs.jmsOnePhaseOptimization))))&&((this.oracleLogFileCount == rhs.oracleLogFileCount)||((this.oracleLogFileCount!= null)&&this.oracleLogFileCount.equals(rhs.oracleLogFileCount))))&&((this.failoverGranularity == rhs.failoverGranularity)||((this.failoverGranularity!= null)&&this.failoverGranularity.equals(rhs.failoverGranularity))))&&((this.tempStoreDisk == rhs.tempStoreDisk)||((this.tempStoreDisk!= null)&&this.tempStoreDisk.equals(rhs.tempStoreDisk))))&&((this.trustStorePassword == rhs.trustStorePassword)||((this.trustStorePassword!= null)&&this.trustStorePassword.equals(rhs.trustStorePassword))))&&((this.dbFailOverEnabled == rhs.dbFailOverEnabled)||((this.dbFailOverEnabled!= null)&&this.dbFailOverEnabled.equals(rhs.dbFailOverEnabled))))&&((this.maxXids == rhs.maxXids)||((this.maxXids!= null)&&this.maxXids.equals(rhs.maxXids))))&&((this.nonTransactionalDataSource == rhs.nonTransactionalDataSource)||((this.nonTransactionalDataSource!= null)&&this.nonTransactionalDataSource.equals(rhs.nonTransactionalDataSource))))&&((this.javaDoubleToString == rhs.javaDoubleToString)||((this.javaDoubleToString!= null)&&this.javaDoubleToString.equals(rhs.javaDoubleToString))))&&((this.batchPerformanceWorkaround == rhs.batchPerformanceWorkaround)||((this.batchPerformanceWorkaround!= null)&&this.batchPerformanceWorkaround.equals(rhs.batchPerformanceWorkaround))))&&((this.clientHostName == rhs.clientHostName)||((this.clientHostName!= null)&&this.clientHostName.equals(rhs.clientHostName))))&&((this.spyAttributes == rhs.spyAttributes)||((this.spyAttributes!= null)&&this.spyAttributes.equals(rhs.spyAttributes))))&&((this.beginTranForVendorAPIs == rhs.beginTranForVendorAPIs)||((this.beginTranForVendorAPIs!= null)&&this.beginTranForVendorAPIs.equals(rhs.beginTranForVendorAPIs))))&&((this.propertyCycle == rhs.propertyCycle)||((this.propertyCycle!= null)&&this.propertyCycle.equals(rhs.propertyCycle))))&&((this.clientAppName == rhs.clientAppName)||((this.clientAppName!= null)&&this.clientAppName.equals(rhs.clientAppName))))&&((this.connectionRetryDelay == rhs.connectionRetryDelay)||((this.connectionRetryDelay!= null)&&this.connectionRetryDelay.equals(rhs.connectionRetryDelay))))&&((this.trustStore == rhs.trustStore)||((this.trustStore!= null)&&this.trustStore.equals(rhs.trustStore))))&&((this.convertNull == rhs.convertNull)||((this.convertNull!= null)&&this.convertNull.equals(rhs.convertNull))))&&((this.userType == rhs.userType)||((this.userType!= null)&&this.userType.equals(rhs.userType))))&&((this.queryTimeout == rhs.queryTimeout)||((this.queryTimeout!= null)&&this.queryTimeout.equals(rhs.queryTimeout))))&&((this.workarounds == rhs.workarounds)||((this.workarounds!= null)&&this.workarounds.equals(rhs.workarounds))))&&((this.connRetriesDuringDBFailover == rhs.connRetriesDuringDBFailover)||((this.connRetriesDuringDBFailover!= null)&&this.connRetriesDuringDBFailover.equals(rhs.connRetriesDuringDBFailover))))&&((this.connectionAttributes == rhs.connectionAttributes)||((this.connectionAttributes!= null)&&this.connectionAttributes.equals(rhs.connectionAttributes))))&&((this.loginConfigName == rhs.loginConfigName)||((this.loginConfigName!= null)&&this.loginConfigName.equals(rhs.loginConfigName))))&&((this.logWriter == rhs.logWriter)||((this.logWriter!= null)&&this.logWriter.equals(rhs.logWriter))))&&((this.cryptoProtocolVersion == rhs.cryptoProtocolVersion)||((this.cryptoProtocolVersion!= null)&&this.cryptoProtocolVersion.equals(rhs.cryptoProtocolVersion))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.initializationString == rhs.initializationString)||((this.initializationString!= null)&&this.initializationString.equals(rhs.initializationString))))&&((this.secureRandomAlgorithm == rhs.secureRandomAlgorithm)||((this.secureRandomAlgorithm!= null)&&this.secureRandomAlgorithm.equals(rhs.secureRandomAlgorithm))))&&((this.catalogOptions == rhs.catalogOptions)||((this.catalogOptions!= null)&&this.catalogOptions.equals(rhs.catalogOptions))))&&((this.servicePrincipalName == rhs.servicePrincipalName)||((this.servicePrincipalName!= null)&&this.servicePrincipalName.equals(rhs.servicePrincipalName))))&&((this.validateNewConnection == rhs.validateNewConnection)||((this.validateNewConnection!= null)&&this.validateNewConnection.equals(rhs.validateNewConnection))))&&((this.loginTimeout == rhs.loginTimeout)||((this.loginTimeout!= null)&&this.loginTimeout.equals(rhs.loginTimeout))))&&((this.connectionSharing == rhs.connectionSharing)||((this.connectionSharing!= null)&&this.connectionSharing.equals(rhs.connectionSharing))))&&((this.programID == rhs.programID)||((this.programID!= null)&&this.programID.equals(rhs.programID))))&&((this.freeResourcesOnClose == rhs.freeResourcesOnClose)||((this.freeResourcesOnClose!= null)&&this.freeResourcesOnClose.equals(rhs.freeResourcesOnClose))))&&((this.serviceName == rhs.serviceName)||((this.serviceName!= null)&&this.serviceName.equals(rhs.serviceName))))&&((this.driverType == rhs.driverType)||((this.driverType!= null)&&this.driverType.equals(rhs.driverType))))&&((this.connectionLog == rhs.connectionLog)||((this.connectionLog!= null)&&this.connectionLog.equals(rhs.connectionLog))))&&((this.oracleLogPackageName == rhs.oracleLogPackageName)||((this.oracleLogPackageName!= null)&&this.oracleLogPackageName.equals(rhs.oracleLogPackageName))))&&((this.hostNameInCertificate == rhs.hostNameInCertificate)||((this.hostNameInCertificate!= null)&&this.hostNameInCertificate.equals(rhs.hostNameInCertificate))))&&((this.user == rhs.user)||((this.user!= null)&&this.user.equals(rhs.user))))&&((this.networkProtocol == rhs.networkProtocol)||((this.networkProtocol!= null)&&this.networkProtocol.equals(rhs.networkProtocol))));
    }

}
