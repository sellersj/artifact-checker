package com.github.sellersj.artifactchecker.model;

import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class MailSource implements Comparable<MailSource> {

    /** The key for name of the app. */
    public static final String MAIL_SOURCE_NAME = "MAIL_SOURCE_NAME";

    /** The key that the cluster is stored under. */
    public static final String MAIL_JNDI = "MAIL_JNDI";

    /** The key that the version is stored under. */
    public static final String APP_KEY = "APP";

    /** The mail source name. */
    private String name;

    /** The jndi name. */
    private String jndiName;

    /** The app names. */
    private Set<String> appNames = new TreeSet<>();

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public int compareTo(MailSource o) {
        return CompareToBuilder.reflectionCompare(this, o);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the jndiName
     */
    public String getJndiName() {
        return jndiName;
    }

    /**
     * @param jndiName the jndiName to set
     */
    public void setJndiName(String jndiName) {
        this.jndiName = jndiName;
    }

    /**
     * @return the appNames
     */
    public Set<String> getAppNames() {
        return appNames;
    }

    /**
     * @param appNames the appNames to set
     */
    public void setAppNames(Set<String> appNames) {
        this.appNames = appNames;
    }

}
