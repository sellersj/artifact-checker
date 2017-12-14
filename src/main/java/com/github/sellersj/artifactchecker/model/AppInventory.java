package com.github.sellersj.artifactchecker.model;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class AppInventory {

    private String env = "prod";

    private Set<ArtifactAttributes> apps = new HashSet<>();

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Add an app
     *
     * @param app to be added
     */
    public void add(ArtifactAttributes attributes) {
        apps.add(attributes);
    }

    /**
     * @return the env
     */
    public String getEnv() {
        return env;
    }

    /**
     * @param env the env to set
     */
    public void setEnv(String env) {
        this.env = env;
    }

    /**
     * @return the apps
     */
    public Set<ArtifactAttributes> getApps() {
        return apps;
    }

    /**
     * @param apps the apps to set
     */
    public void setApps(SortedSet<ArtifactAttributes> apps) {
        this.apps = apps;
    }

}
