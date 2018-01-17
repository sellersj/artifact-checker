package com.github.sellersj.artifactchecker.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class App {

    /** The key for name of the app. */
    public static final String APP_KEY = "APP";

    /** The key that the cluster is stored under. */
    public static final String CLUSTER = "SERVER";

    /** The key that the version is stored under. */
    public static final String BUILD_VERSION = "BUILD VERSION";

    private Map<String, List<String>> attributes = new HashMap<>();

    /** The list of suffixes used on artifactIds */
    private static final List<String> ARTIFACTID_SUFFIX_LIST = Arrays.asList(//
        "-ear", "-app", "EAR");

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
        ArrayList<String> list = new ArrayList<>();

        if (attributes.containsKey(APP_KEY)) {
            for (String string : attributes.get(APP_KEY)) {

                // TODO it might be better to specify that this is the end of the line
                String baseName = string.replaceAll("__PUBLIC", "") //
                    .replaceAll("__INTRA", "")//
                    .replaceAll("_UTF8-Intra", "");

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

}
