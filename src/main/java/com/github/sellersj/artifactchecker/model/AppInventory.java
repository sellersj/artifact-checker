package com.github.sellersj.artifactchecker.model;

import java.util.ArrayList;
import java.util.List;

public class AppInventory {

    private String env = "prod";

    // TODO this should be sorted by GAV
    private List<App> apps = new ArrayList<>();

    /**
     * Add an app
     * 
     * @param app to be added
     */
    public void add(App app) {
        apps.add(app);
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
    public List<App> getApps() {
        return apps;
    }

    /**
     * @param apps the apps to set
     */
    public void setApps(List<App> apps) {
        this.apps = apps;
    }

}
