package com.github.sellersj.artifactchecker.model;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class App {

    private static final String EAR_PACKAGING = "ear";

    private String groupId;

    private String artifactId;

    private String version;

    private String packaging = EAR_PACKAGING;

    private Map<String, String> manifest;

    public String generateKey() {
        return generateKey(groupId, artifactId, version, packaging);
    }

    public static String generateKey(String groupId, String artifactId, String version) {
        return generateKey(groupId, artifactId, version, EAR_PACKAGING);
    }

    private static String generateKey(String groupId, String artifactId, String version, String packaging) {
        String seperator = ":";
        return groupId + seperator + //
            artifactId + seperator + //
            version + seperator + //
            packaging;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * @return the groupId
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * @param groupId the groupId to set
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * @return the artifactId
     */
    public String getArtifactId() {
        return artifactId;
    }

    /**
     * @param artifactId the artifactId to set
     */
    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return the packaging
     */
    public String getPackaging() {
        return packaging;
    }

    /**
     * @param packaging the packaging to set
     */
    public void setPackaging(String packaging) {
        this.packaging = packaging;
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
    public void setManifest(Map<String, String> manifest) {
        this.manifest = manifest;
    }

}
