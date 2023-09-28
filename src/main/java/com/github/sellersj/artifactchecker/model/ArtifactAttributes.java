package com.github.sellersj.artifactchecker.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.sellersj.artifactchecker.Constants;
import com.github.sellersj.artifactchecker.DateUtils;
import com.github.sellersj.artifactchecker.model.owasp.KnownExploitedVulnerability;
import com.github.sellersj.artifactchecker.model.owasp.Vulnerability;
import com.opencsv.bean.CsvBindByName;

/**
 * Any attributes that we will track for an artifact.
 *
 * There are some hacky members that do nothing so that we can trick the opencsv library to using the getters to get the
 * values that we want. See <a href="https://sourceforge.net/p/opencsv/feature-requests/105/?limit=25">the ticket</a>
 *
 * @author sellersj
 */
public class ArtifactAttributes implements Comparable<ArtifactAttributes> {

    public static final String ISSUE_TRACKING = "Issue-Tracking";

    /** The project or user that a git repo is stored under. */
    public final static String SCM_PROJECT = "Scm-Project-Id";

    /** The git repo name. */
    public static final String SCM_REPO = "Scm-Repo-Name";

    /** The git hash that we want to checkout. */
    public static final String SCM_HASH = "Scm-Sha1";

    /** The Implementation-Title from the manifest. */
    public static final String IMPLEMENTATION_TITLE = "Implementation-Title";

    /** The Build-Time from the manifest. */
    public static final String BUILD_TIME = "Build-Time";

    /** The Implementation-Artifact-Id from the manifest which is used for the artifactId. */
    public static final String ARTIFACT_ID = "Implementation-Artifact-Id";

    /** The tag we're looking for the version with. */
    public static final String VERSION = "Implementation-Version";

    /** The maven date format. */
    public static final DateTimeFormatter MAVEN_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    /** The old maven date format. */
    private static final DateTimeFormatter MAVEN_OLD_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd-HHmm");

    /** We keep on finding different date formats. */
    private static final List<DateTimeFormatter> BUILD_TIME_DATE_FORMATS = Arrays.asList( //
        MAVEN_DATE_FORMAT, //
        MAVEN_OLD_DATE_FORMAT, //
        DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm") // another date format that we've found
    );

    /** The ISO 8601 date format used by git. */
    private static final DateTimeFormatter GIT_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");

    /** The date format with just the year. */
    private static final DateTimeFormatter SHORT_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /** The format from the output. */
    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /** If this is a github host. */
    private boolean github = false;

    /** Our corrected scm project from a static file. */
    private String correctedScmProject;

    /** Our corrected scm repo from a static file. */
    private String correctedScmRepo;

    /** Our corrected artifactId from a static file. */
    private String correctedArtifactId;

    /** From another source. */
    private String correctedGroupId;

    /**
     * Flag for if this artficat's repo was already checked by another artifact (e.g. 1 repo, 2 ears).
     */
    private boolean alreadyTrackedByAnother = false;

    /** Flag for if we can run this on java 8. */
    @CsvBindByName
    private boolean java8Ready = false;

    /** If the library checks (dependency, owasp, etc) worked. */
    private boolean libraryCheckedWorked = true;

    /** The manifest associated with this artifact. */
    private SortedMap<String, String> manifest = new TreeMap<>();

    /** A list of all the vulnerabilties found with this artifact. */
    @JsonIgnore
    private List<Vulnerability> vulnerabilities = new ArrayList<>();

    /**
     * The scm tag if an artifact doesn't have the hash.
     */
    @CsvBindByName
    private String scmTag = "";

    /** The date that git thinks the commit happened. */
    @CsvBindByName
    private String scmAuthorDate = "";

    /** The info that is configured for the prod deployment. */
    private App deploymentInfo;

    /** Our corrected jira key from a static file. */
    private String correctedJiraKey = "";

    /** Our tech owner from a static file. */
    @CsvBindByName
    private String techOwner = "";

    /** If this is targetted for decomissioning. */
    @CsvBindByName
    private boolean toDecomission = false;

    /** The data sources that are linked to this app. */
    private Set<ParsedDataSource> linkedDataSources = new TreeSet<>();

    /** The mail sources that are linked to this app. */
    private Set<MailSource> linkedMailSources = new TreeSet<>();

    /** The epic templating names we have identified for this project. */
    private Set<String> epicTemplatingNames = new TreeSet<>();

    /** If this is an app that uses cma. */
    @CsvBindByName
    private boolean cmaAuthApp = false;

    /** The pages we think are login with the line numbers. */
    private Set<String> loginPages = new TreeSet<>();

    /** Jndi names we found when parsing the source code. */
    private Set<String> possibleJndiNames = new TreeSet<>();

    /** What we think are the artifacts built by the project. */
    private Set<String> artifactsBuiltByProject = new TreeSet<>();

    /** Default constructor. */
    public ArtifactAttributes() {
    }

    /** Clone constructor. */
    public ArtifactAttributes(ArtifactAttributes source) {

        // ideally this should be done in a nicer way to copy all the fields over.
        // any time a new field is added, it will have to be added to this list

        this.github = source.github;
        this.correctedScmProject = source.correctedScmProject;
        this.correctedScmRepo = source.correctedScmRepo;
        this.correctedArtifactId = source.correctedArtifactId;
        this.alreadyTrackedByAnother = source.alreadyTrackedByAnother;
        this.java8Ready = source.java8Ready;
        this.libraryCheckedWorked = source.libraryCheckedWorked;
        this.manifest = source.manifest;
        this.vulnerabilities = source.vulnerabilities;
        this.scmTag = source.scmTag;
        this.scmAuthorDate = source.scmAuthorDate;
        this.deploymentInfo = source.deploymentInfo;
        this.correctedJiraKey = source.correctedJiraKey;
        this.techOwner = source.techOwner;
        this.toDecomission = source.toDecomission;
        this.linkedDataSources = source.linkedDataSources;
        this.linkedMailSources = source.linkedMailSources;
        this.epicTemplatingNames = source.epicTemplatingNames;
        this.loginPages = source.loginPages;
    }

    /**
     * @return true if the has the scm project, repo, and (hash or version).
     */
    public boolean hasRequiredGitInfo() {
        return StringUtils.isNotBlank(getScmProject()) && //
            StringUtils.isNotBlank(getScmRepo()) && //
            (StringUtils.isNotBlank(getScmHash()) || StringUtils.isNotBlank(getVersion()));
    }

    /**
     * @return true if the has the scm project, repo, and (hash or version).
     */
    public boolean hasSameGitInfo(ArtifactAttributes app) {
        return getScmProject().equals(app.getScmProject()) && //
            getScmRepo().equals(app.getScmRepo()) && //
            // either check the hash
            (StringUtils.isNotBlank(getScmHash()) && getScmHash().equals(app.getScmHash()) || //
            // or check the version
                (StringUtils.isNotBlank(getVersion()) && getVersion().equals(app.getVersion()))) //
        ;
    }

    /**
     * @return a string that can be used to uniquely identify this project, using git repo, hash, and version.
     */
    public String getUniqueStringForGitInfoAndVersion() {
        return buildGitCloneUrl() + "+" + getScmHash() + "+" + getVersion();
    }

    public String buildGitCloneUrl() {
        String cloneUrl;

        if (github) {
            cloneUrl = "git@github.com:" + getScmProject() + "/" + getScmRepo() + ".git";
        } else {
            String toolsHost = Constants.getSysOrEnvVariable(Constants.TOOLS_HOST);
            if (StringUtils.isBlank(toolsHost)) {
                throw new RuntimeException("The 'TOOLS_HOST' env variable has to be set");
            }
            cloneUrl = "ssh://git@" + toolsHost + ":7999/" + getScmProject() + "/" + getScmRepo() + ".git";
        }

        return cloneUrl;
    }

    public String getScmProject() {
        String scmProject = manifest.get(SCM_PROJECT);

        if (StringUtils.isNotBlank(correctedScmProject)) {
            scmProject = correctedScmProject;

        } else if (StringUtils.isBlank(scmProject) && StringUtils.isNotBlank(getScmRepo())
            && StringUtils.isNotBlank(getScmHash())) {

            // only default it if it's the only info missing
            scmProject = "ICAPPS";
            System.out.println("Defaulting project name to: " + scmProject + " for " + getScmRepo());
        }

        return scmProject;
    }

    public String getScmRepo() {
        String repo = manifest.get(SCM_REPO);

        if (StringUtils.isNotBlank(correctedScmRepo)) {
            repo = correctedScmRepo;
        }

        return repo;
    }

    public String getScmHash() {
        return cleanHash(manifest.get(SCM_HASH));
    }

    public String getScmHashAbbrev() {
        return cleanHash(manifest.get("Scm-Sha1-Abbrev"));
    }

    /**
     * This will build a url to the commit in source control.
     *
     * @return the link to the scm commit, or blank if we don't have enough info
     */
    public String getScmUrl() {
        String url = "";

        // only build the url if we have the needed data
        if (StringUtils.isNotBlank(getScmProject()) && //
            StringUtils.isNotBlank(getScmRepo())) {

            String toolsHost = Constants.getSysOrEnvVariable(Constants.TOOLS_HOST);
            url = "https://" + toolsHost + "/scm/projects/" + getScmProject() + "/repos/" + getScmRepo();

            if (StringUtils.isNotBlank(getScmHash())) {
                url += "/commits/" + getScmHash();
            } else {
                url += "/browse?at=refs%2Ftags%2F" + getScmTag();
            }
        }

        return url;
    }

    /**
     * Removes the "-dirty" text that some older versions had added.
     *
     * @param hash to be cleaned
     * @return a clean hash
     */
    private String cleanHash(String hash) {
        if (StringUtils.isNotBlank(hash) && hash.endsWith("-dirty")) {
            hash = hash.replaceAll("-dirty", "");
        }
        return hash;
    }

    /**
     * @return the build date if it exists and is parsable.
     */
    public Date getBuildDate() {
        String string = manifest.get(BUILD_TIME);
        Date date = null;

        if (StringUtils.isNotBlank(string)) {

            // try all the date formats, until we find one that works
            for (DateTimeFormatter dateFormat : BUILD_TIME_DATE_FORMATS) {
                date = DateUtils.parseToDate(string, dateFormat);

                // if we find a date, stop looking at the different formats
                if (null != date) {
                    break;
                }
            }

            // if it's not blank and we can't parse either date format, something is wrong
            if (null == date) {
                System.err.println("Could not parse date : " + string);
            }
        } else if (StringUtils.isNotBlank(getScmAuthorDate())) {
            // try the iso 8601 format that git uses
            date = DateUtils.parseToDate(getScmAuthorDate(), GIT_DATE_FORMAT);
        }

        return date;
    }

    /** For the opencsv. */
    @CsvBindByName
    private String deploymentDate;

    /**
     * @return the deployment date.
     */
    public String getDeploymentDate() {
        String result = "";
        if (null != deploymentInfo) {
            Date date = deploymentInfo.getDeploymentDate();
            if (null != date) {
                LocalDateTime dateTime = DateUtils.asLocalDateTime(date);
                result = DATE_TIME_FORMAT.format(dateTime);
            }
        }
        return result;
    }

    /** For the opencsv. */
    @CsvBindByName
    private String buildDateFormatted;

    /**
     * @return a short formatted build date
     */
    public String getBuildDateFormatted() {
        String result = "";
        Date date = getBuildDate();
        if (null != date) {
            LocalDateTime dateTime = DateUtils.asLocalDateTime(date);
            result = SHORT_DATE_FORMAT.format(dateTime);
        }
        return result;
    }

    public String getGroupId() {
        String groupId = manifest.get("Maven-Project-GroupId");
        if (StringUtils.isBlank(groupId)) {
            groupId = manifest.get("Implementation-Vendor-Id");
        }

        // if it's still blank, try to use the corrected one
        if (StringUtils.isBlank(groupId)) {
            groupId = correctedGroupId;
        }

        return groupId;
    }

    /**
     * @return the artifactId if we have it in the manifest, or the corrected one otherwise.
     */
    public String getArtifactId() {
        String artifactId = manifest.get(ARTIFACT_ID);

        if (StringUtils.isBlank(artifactId)) {
            artifactId = correctedArtifactId;
        }

        return artifactId;
    }

    /** For the opencsv. */
    @CsvBindByName
    private String version;

    public String getVersion() {
        return manifest.get(VERSION);
    }

    /** For the opencsv. */
    @CsvBindByName
    private String title;

    public String getTitle() {
        return manifest.get(IMPLEMENTATION_TITLE);
    }

    /** For the opencsv. */
    @CsvBindByName
    private String jiraKey;

    public String getJiraKey() {
        String url = manifest.get(ISSUE_TRACKING);
        String key = "";

        if (StringUtils.isNotBlank(url)) {
            key = url.substring(url.lastIndexOf("/") + 1);
        }

        // we don't have a value from the manifest
        if (StringUtils.isBlank(key)) {
            key = correctedJiraKey;
        }

        return key;
    }

    public String getNexusUrl() {
        String toolsHost = Constants.getSysOrEnvVariable(Constants.TOOLS_HOST);

        // default it to a blank string if we don't have the the artifactId
        String artifactId = getArtifactId();
        if (null == artifactId) {
            artifactId = "";
        }

        return "https://" + toolsHost + "/maven-proxy/#nexus-search;gav~" + getGroupId() + "~" + artifactId + "~"
            + getVersion() + "~ear~";

    }

    /** A link to the file that has the issues with java 8. */
    public String getJava8Url() {
        String baseUrl = getBaseUrl();
        if (null == baseUrl) {
            return "#";
        } // else
        return baseUrl + "/" + Constants.JAVA8_ISSUES_FILENAME;
    }

    /** A link to the dependency tree. */
    public String getDependencyTree() {
        String baseUrl = getBaseUrl();
        if (null == baseUrl) {
            return "#";
        } // else
        return baseUrl + "/" + Constants.TREE_TXT_FILE;
    }

    /**
     * @return a base url where the files are stored
     */
    /* package */ String getBaseUrl() {
        // default to null
        String url = null;

        if (StringUtils.isNotBlank(getScmProject()) && //
            StringUtils.isNotBlank(getScmRepo()) && //
            (StringUtils.isNotBlank(getScmHash()) || StringUtils.isNotBlank(getVersion()))) {

            url = getScmProject() + "/" + getScmRepo() + "/";
            if (StringUtils.isBlank(getScmHash())) {
                url += getVersion();
            } else {
                url += getScmHash();
            }
            url += "/" + getScmRepo();
        }

        return url;
    }

    /** For the opencsv. */
    @CsvBindByName
    private String jiraUrl;

    public String getJiraUrl() {
        String url = manifest.get(ISSUE_TRACKING);

        if (StringUtils.isBlank(url)) {
            String jiraHost = Constants.getSysOrEnvVariable(Constants.CORRECTED_JIRA_HOST);
            url = jiraHost + "/browse/" + getJiraKey();
        }

        return url;
    }

    /** A link to the owasp dependency check report. */
    public String getOwaspDependencyCheckUrl() {
        String baseUrl = getBaseUrl();
        if (null == baseUrl) {
            return "#";
        } // else
        return baseUrl + "/target/dependency-check-report.html";
    }

    /**
     * @return the number of cve's with severity of Low.
     */
    public int getCveSeverityCountLow() {
        int count = 0;
        for (Vulnerability vulnerability : vulnerabilities) {
            if ("Low".equalsIgnoreCase(vulnerability.getSeverity().getValue())) {
                count++;
            }
        }
        return count;
    }

    /**
     * @return the number of cve's with severity of Medium.
     */
    public int getCveSeverityCountMedium() {
        int count = 0;
        for (Vulnerability vulnerability : vulnerabilities) {
            if ("Medium".equalsIgnoreCase(vulnerability.getSeverity().getValue())) {
                count++;
            }
        }
        return count;
    }

    /**
     * @return the number of cve's with severity of High.
     */
    public int getCveSeverityCountHigh() {
        int count = 0;
        for (Vulnerability vulnerability : vulnerabilities) {
            if ("High".equalsIgnoreCase(vulnerability.getSeverity().getValue())) {
                count++;
            }
        }
        return count;
    }

    /**
     * @return the number of cve's with severity of Critical.
     */
    public int getCveSeverityCountCritical() {
        int count = 0;
        for (Vulnerability vulnerability : vulnerabilities) {
            if ("Critical".equalsIgnoreCase(vulnerability.getSeverity().getValue())) {
                count++;
            }
        }
        return count;
    }

    /**
     * @return the number of cve's that are known to be exploted.
     */
    public int getCveKnownExploitedVulnerabilityCount() {
        int count = 0;
        for (Vulnerability vulnerability : vulnerabilities) {
            KnownExploitedVulnerability known = vulnerability.getKnownExploitedVulnerability();
            if (null != known) {
                count++;
            }
        }
        return count;
    }

    /**
     * @return the hash or tag so we can link to it
     */
    public String getHashOrTag() {
        String text = getScmHashAbbrev();
        if (StringUtils.isBlank(text)) {
            text = getScmTag();
        }
        return text;
    }

    /** For the opencsv. */
    @CsvBindByName
    private String deploymentName;

    /** The deployment cluster. */
    public String getDeploymentName() {
        return getDeploymentInfo("APP");
    }

    /** For the opencsv. */
    @CsvBindByName
    private String cluster;

    /** The deployment cluster. */
    public String getCluster() {
        return getDeploymentInfo("SERVER");
    }

    /** For the opencsv. */
    @CsvBindByName
    private boolean clusterJava8;

    /** The deployment cluster. */
    public boolean isClusterJava8() {
        String cluster = getCluster();
        return StringUtils.isNotBlank(cluster) && cluster.contains("jdk8");
    }

    /** For the opencsv. */
    @CsvBindByName
    private String nodes;

    /** The deployment nodes. */
    public String getNodes() {
        return getDeploymentInfo("NODE");
    }

    /** Makes links right into the logging location. */
    public List<String> getNodeUrls() {
        String[] nodes = getNodes().split(" ");
        Arrays.sort(nodes);

        if (null != getDeploymentInfo() && App.DATA_CENTER_KED.equals(getDeploymentInfo().getDataCenter())) {
            return Arrays.asList(nodes);

        } else {
            String logHost = Constants.getSysOrEnvVariable(Constants.PROD_LOG_HOST);
            ArrayList<String> nodeUrls = new ArrayList<>();
            for (String node : nodes) {
                nodeUrls.add("<a href=\"http://" + logHost + "/logs/" + nodeLogLocationCorrection(node) + "/\">" + node
                    + "</a>");
            }
            return nodeUrls;
        }
    }

    public String nodeLogLocationCorrection(String node) {
        return node.toLowerCase() //
            .replace("was_osbp", "wasosbpublic") //
            .replaceAll("_", "");
    }

    /** For the opencsv. */
    @CsvBindByName
    private String nodeHostnames;

    /** The hostnames of the deployment nodes. */
    public Set<String> getNodeHostnames() {
        TreeSet<String> nodeHosts = new TreeSet<>();
        for (String node : getNodes().split(" ")) {
            nodeHosts.add(nodeLogLocationCorrection(node));
        }

        return nodeHosts;
    }

    /** If this app is public facing. */
    public boolean isPublic() {
        return getDeploymentInfo("TYPE").contains("Public");
    }

    /** For the opencsv. */
    @CsvBindByName
    private SortedSet<String> applicationUrls;

    /** The link to the app. */
    public SortedSet<String> getApplicationUrls() {
        TreeSet<String> urls = new TreeSet<>();
        String contextRoot = getDeploymentInfo(App.CONTEXT_ROOT);

        if (StringUtils.isNotBlank(contextRoot)) {
            String host;
            if (isPublic()) {
                host = Constants.getSysOrEnvVariable(Constants.PUBLIC_HOSTNAME);
            } else {
                host = Constants.getSysOrEnvVariable(Constants.INTRANET_HOSTNAME);
            }

            urls.add(host + contextRoot);
        }

        return urls;
    }

    /** The links to the apps. */
    public List<String> getApplicationUrlsAsHtml() {
        SortedSet<String> urls = getApplicationUrls();

        ArrayList<String> markup = new ArrayList<>();
        for (String url : urls) {
            markup.add(String.format("<a href=\"%s\">url</a?", url));
        }

        return markup;
    }

    private String getDeploymentInfo(String key) {
        String result = "";

        if (null != deploymentInfo && deploymentInfo.getAttributes().containsKey(key)) {
            List<String> list = deploymentInfo.getAttributes().get(key);
            for (String string : list) {
                result += string + " ";
            }
            result = result.trim();
        }

        return result;
    }

    /** For the opencsv. */
    @CsvBindByName
    private String databaseUserNames;

    /** Build a space seperated list of oracle usernames used by this app. */
    public String getDatabaseUserNames() {
        Set<String> usernames = new TreeSet<>();

        for (ParsedDataSource ds : getLinkedDataSources()) {
            usernames.add(ds.getDatabaseUsername());
        }
        return String.join(" ", usernames);
    }

    /** For the opencsv. */
    @CsvBindByName
    private Boolean sendsEmail;

    /** If this app is mapped to a mail source. */
    public Boolean isSendsEmail() {
        return !getLinkedMailSources().isEmpty();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int compareTo(ArtifactAttributes o) {
        return CompareToBuilder.reflectionCompare(this, o);
    }

    /**
     * @return the manifest
     */
    public Map<String, String> getManifest() {
        return manifest;
    }

    /**
     * @param manifest the manifest to set
     */
    public void setManifest(SortedMap<String, String> manifest) {
        this.manifest = manifest;
    }

    /**
     * @return the github
     */
    public boolean isGithub() {
        return github;
    }

    /**
     * @param github the github to set
     */
    public void setGithub(boolean github) {
        this.github = github;
    }

    /**
     * @return the correctedScmProject
     */
    public String getCorrectedScmProject() {
        return correctedScmProject;
    }

    /**
     * @param correctedScmProject the correctedScmProject to set
     */
    public void setCorrectedScmProject(String correctedScmProject) {
        this.correctedScmProject = correctedScmProject;
    }

    /**
     * @return the correctedScmRepo
     */
    public String getCorrectedScmRepo() {
        return correctedScmRepo;
    }

    /**
     * @param correctedScmRepo the correctedScmRepo to set
     */
    public void setCorrectedScmRepo(String correctedScmRepo) {
        this.correctedScmRepo = correctedScmRepo;
    }

    /**
     * @return the alreadyTrackedByAnother
     */
    public boolean isAlreadyTrackedByAnother() {
        return alreadyTrackedByAnother;
    }

    /**
     * @param alreadyTrackedByAnother the alreadyTrackedByAnother to set
     */
    public void setAlreadyTrackedByAnother(boolean alreadyTrackedByAnother) {
        this.alreadyTrackedByAnother = alreadyTrackedByAnother;
    }

    /**
     * @return the java8Ready
     */
    public boolean isJava8Ready() {
        return java8Ready;
    }

    /**
     * @param java8Ready the java8Ready to set
     */
    public void setJava8Ready(boolean java8Ready) {
        this.java8Ready = java8Ready;
    }

    /**
     * @return the vulnerabilities
     */
    public List<Vulnerability> getVulnerabilities() {
        return vulnerabilities;
    }

    /**
     * @param vulnerabilities the vulnerabilities to set
     */
    public void setVulnerabilities(List<Vulnerability> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

    /**
     * @return the correctedArtifactId
     */
    public String getCorrectedArtifactId() {
        return correctedArtifactId;
    }

    /**
     * @param correctedArtifactId the correctedArtifactId to set
     */
    public void setCorrectedArtifactId(String correctedArtifactId) {
        this.correctedArtifactId = correctedArtifactId;
    }

    /**
     * @return the scmTag
     */
    public String getScmTag() {
        return scmTag;
    }

    /**
     * @param scmTag the scmTag to set
     */
    public void setScmTag(String scmTag) {
        this.scmTag = scmTag;
    }

    /**
     * @return the deploymentInfo
     */
    public App getDeploymentInfo() {
        return deploymentInfo;
    }

    /**
     * @param deploymentInfo the deploymentInfo to set
     */
    public void setDeploymentInfo(App deploymentInfo) {
        this.deploymentInfo = deploymentInfo;
    }

    /**
     * @return the scmAuthorDate
     */
    public String getScmAuthorDate() {
        return scmAuthorDate;
    }

    /**
     * @param scmAuthorDate the scmAuthorDate to set
     */
    public void setScmAuthorDate(String scmAuthorDate) {
        this.scmAuthorDate = scmAuthorDate;
    }

    /**
     * @return the correctedJiraKey
     */
    public String getCorrectedJiraKey() {
        return correctedJiraKey;
    }

    /**
     * @param correctedJiraKey the correctedJiraKey to set
     */
    public void setCorrectedJiraKey(String correctedJiraKey) {
        this.correctedJiraKey = correctedJiraKey;
    }

    /**
     * @return the techOwner
     */
    public String getTechOwner() {
        return techOwner;
    }

    /**
     * @param techOwner the techOwner to set
     */
    public void setTechOwner(String techOwner) {
        this.techOwner = techOwner;
    }

    /**
     * @return the libraryCheckedWorked
     */
    public boolean isLibraryCheckedWorked() {
        return libraryCheckedWorked;
    }

    /**
     * @param libraryCheckedWorked the libraryCheckedWorked to set
     */
    public void setLibraryCheckedWorked(boolean libraryCheckedWorked) {
        this.libraryCheckedWorked = libraryCheckedWorked;
    }

    /**
     * @return the toDecomission
     */
    public boolean isToDecomission() {
        return toDecomission;
    }

    /**
     * @param toDecomission the toDecomission to set
     */
    public void setToDecomission(boolean toDecomission) {
        this.toDecomission = toDecomission;
    }

    /**
     * @return the linkedDataSources
     */
    public Set<ParsedDataSource> getLinkedDataSources() {
        return linkedDataSources;
    }

    /**
     * @param linkedDataSources the linkedDataSources to set
     */
    public void setLinkedDataSources(Set<ParsedDataSource> linkedDataSources) {
        this.linkedDataSources = linkedDataSources;
    }

    /**
     * @return the linkedMailSources
     */
    public Set<MailSource> getLinkedMailSources() {
        return linkedMailSources;
    }

    /**
     * @param linkedMailSources the linkedMailSources to set
     */
    public void setLinkedMailSources(Set<MailSource> linkedMailSources) {
        this.linkedMailSources = linkedMailSources;
    }

    /**
     * @return the epicTemplatingNames
     */
    public Set<String> getEpicTemplatingNames() {
        return epicTemplatingNames;
    }

    /**
     * @param epicTemplatingNames the epicTemplatingNames to set
     */
    public void setEpicTemplatingNames(Set<String> epicTemplatingNames) {
        this.epicTemplatingNames = epicTemplatingNames;
    }

    /**
     * @return the correctedGroupId
     */
    public String getCorrectedGroupId() {
        return correctedGroupId;
    }

    /**
     * @param correctedGroupId the correctedGroupId to set
     */
    public void setCorrectedGroupId(String correctedGroupId) {
        this.correctedGroupId = correctedGroupId;
    }

    /**
     * @return the cmaAuthApp
     */
    public boolean isCmaAuthApp() {
        return cmaAuthApp;
    }

    /**
     * @param cmaAuthApp the cmaAuthApp to set
     */
    public void setCmaAuthApp(boolean cmaAuthApp) {
        this.cmaAuthApp = cmaAuthApp;
    }

    /**
     * @return the loginPages
     */
    public Set<String> getLoginPages() {
        return loginPages;
    }

    /**
     * @param loginPages the loginPages to set
     */
    public void setLoginPages(Set<String> loginPages) {
        this.loginPages = loginPages;
    }

    /**
     * @return the possibleJndiNames
     */
    public Set<String> getPossibleJndiNames() {
        return possibleJndiNames;
    }

    /**
     * @param possibleJndiNames the possibleJndiNames to set
     */
    public void setPossibleJndiNames(Set<String> possibleJndiNames) {
        this.possibleJndiNames = possibleJndiNames;
    }

    /**
     * @return the artifactsBuiltByProject
     */
    public Set<String> getArtifactsBuiltByProject() {
        return artifactsBuiltByProject;
    }

    /**
     * @param artifactsBuiltByProject the artifactsBuiltByProject to set
     */
    public void setArtifactsBuiltByProject(Set<String> artifactsBuiltByProject) {
        this.artifactsBuiltByProject = artifactsBuiltByProject;
    }

}
