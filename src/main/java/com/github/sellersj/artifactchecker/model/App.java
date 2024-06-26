package com.github.sellersj.artifactchecker.model;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.github.sellersj.artifactchecker.DateUtils;

public class App {

    /** The ICDC data center. */
    public static final String DATA_CENTER_ICDC = "ICDC";

    /** The KED data center. */
    public static final String DATA_CENTER_KED = "KEDC";

    /** The key for name of the app. */
    public static final String APP_KEY = "APP";

    /** The key that the cluster is stored under. */
    public static final String CLUSTER = "SERVER";

    /** The key that the version is stored under. */
    public static final String BUILD_VERSION = "BUILD VERSION";

    /** The key that the context root is stored under. */
    public static final String CONTEXT_ROOT = "CONTEXT_ROOT";

    /** The deployment date. */
    public static final String DEPLOY_DATE = "DEPLOY DATE";

    private Map<String, List<String>> attributes = new HashMap<>();

    /** The list of suffixes used on artifactIds */
    private static final List<String> ARTIFACTID_SUFFIX_LIST = Arrays.asList(//
        "-ear", "-app", "_EAR", "EAR", "Ear");

    /** The possible suffixes that apps use. */
    public static final List<String> DEPLOYMENT_SUFFIX_LIST = Arrays.asList(//
        "__PUBLIC", "__INTRA", "_UTF8-Intra", "-Solr_PUBLIC", "_Training", "-training", "_SOLR", "__PRD", "_INTRA");

    /** A way to flag what apps are tracked / linked to our other list. */
    private boolean appLinked = false;

    /** The data center. */
    private String dataCenter;

    /** The deployment date. */
    private Date deploymentDate;

    /** The format from the other file we're parsing. */
    private static final DateTimeFormatter APP_FILE_DATE_FORMAT = DateTimeFormatter.ofPattern("EEE MMM d HH:mm:ss yyyy")
        .withLocale(Locale.ENGLISH);

    /**
     * Adds an item to the list that is referenced by the key.
     *
     * @param key to use
     * @param value the value to add to the list
     */
    public void putItem(String key, String value) {
        List<String> items = attributes.get(key);

        // if the list is missing, add it in
        if (null == items) {
            items = new ArrayList<>();
            attributes.put(key, items);
        }

        items.add(value);
    }

    /**
     * Since the names in prod don't match the artifactId, make a list of guesses.
     *
     * @return
     */
    public List<String> getPossibleArtifactIds() {
        List<String> list = new ListIgnoreCase();

        if (attributes.containsKey(APP_KEY)) {
            for (String string : attributes.get(APP_KEY)) {

                String baseName = string;
                for (String deploymentSuffix : DEPLOYMENT_SUFFIX_LIST) {
                    // TODO it might be better to specify that this is the end of the line
                    baseName = baseName.replaceAll(deploymentSuffix, "");
                }

                // just the artifactId
                list.add(baseName);

                // build the possible suffixes
                for (String suffix : ARTIFACTID_SUFFIX_LIST) {
                    list.add(baseName + suffix);
                }
            }
        }

        return list;
    }

    /**
     * Checks if this app has a matching version.
     *
     * @param version to check
     * @return true if it's in the list
     */
    public boolean containsVersion(String version) {
        boolean result = false;

        if (attributes.containsKey(BUILD_VERSION)) {
            result = attributes.get(BUILD_VERSION).contains(version);
        }

        return result;
    }

    /**
     * @return the deployment date if we have it.
     */
    public Date getDeploymentDate() {

        if (null == deploymentDate) {
            List<String> list = attributes.get(DEPLOY_DATE);
            if (null != list && !list.isEmpty()) {
                // default the result to the value in the app
                String dateString = list.iterator().next();

                // we're going to try to get around the variable number of spaces by just changing multiple spaces to a
                // single space
                dateString = dateString.replaceAll("  +", " ");
                deploymentDate = DateUtils.parseToDate(dateString, APP_FILE_DATE_FORMAT);
            }
        }

        return deploymentDate;
    }

    /**
     * A list that will allow the {@link #contains(Object)} method to ignore the case of the java string.
     *
     * @author sellersj
     *
     */
    public class ListIgnoreCase extends ArrayList<String> {

        /** */
        private static final long serialVersionUID = 1L;

        @Override
        public boolean contains(Object o) {
            String paramStr = (String) o;
            if (null != paramStr) {
                for (String s : this) {
                    if (paramStr.equalsIgnoreCase(s)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * @return the attributes
     */
    public Map<String, List<String>> getAttributes() {
        return attributes;
    }

    /**
     * @param attributes the attributes to set
     */
    public void setAttributes(Map<String, List<String>> attributes) {
        this.attributes = attributes;
    }

    /**
     * @return the appLinked
     */
    public boolean isAppLinked() {
        return appLinked;
    }

    /**
     * @param appLinked the appLinked to set
     */
    public void setAppLinked(boolean appLinked) {
        this.appLinked = appLinked;
    }

    /**
     * @return the dataCenter
     */
    public String getDataCenter() {
        return dataCenter;
    }

    /**
     * @param dataCenter the dataCenter to set
     */
    public void setDataCenter(String dataCenter) {
        this.dataCenter = dataCenter;
    }

    /**
     * @param deploymentDate the deploymentDate to set
     */
    public void setDeploymentDate(Date deploymentDate) {
        this.deploymentDate = deploymentDate;
    }

}
