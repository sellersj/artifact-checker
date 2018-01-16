package com.github.sellersj.artifactchecker.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class App {

    /** */
    public static final String APP_KEY = "APP";

    private Map<String, List<String>> attributes = new HashMap<>();

    /** The list of suffixes used on artifactIds */
    private static final List<String> ARTIFACTID_SUFFIX_LIST = Arrays.asList(//
        "-ear", "-app", "EAR");

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
                String baseName = string.replace("__PUBLIC", "") //
                    .replaceAll("__INTRA", "")//
                    .replaceAll("_UTF8-Intra", "");

                for (String suffix : ARTIFACTID_SUFFIX_LIST) {
                    list.add(baseName + suffix);
                }
            }
        }

        return list;
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
