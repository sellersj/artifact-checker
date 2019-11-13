package com.github.sellersj.artifactchecker.model;

import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.opencsv.bean.CsvIgnore;

public class ParsedDataSource implements Comparable<ParsedDataSource> {

    /** The key for name of the app. */
    @CsvIgnore
    public static final String DATA_SOURCE_KEY = "DATA_SOURCE";

    /** The key that the jndi is stored under. */
    @CsvIgnore
    public static final String JNDI = "JNDI";

    /** The key that the version is stored under. */
    @CsvIgnore
    public static final String DATABASE_USER = "USER";

    /** The key that the different app names is stored under. */
    @CsvIgnore
    public static final String APPLICATION = "APPLICATION";

    /** The WAS name. */
    private String name;

    /** The jndi name. */
    private String jndiName;

    /** The database user name. */
    private String databaseUsername;

    /** The names of apps that are mapped to this data source. */
    private final Set<String> appNames = new TreeSet<>();

    @Override
    public int compareTo(ParsedDataSource o) {
        CompareToBuilder builder = new CompareToBuilder();

        builder.append(getName(), o.getName());
        builder.append(getJndiName(), o.getJndiName());
        builder.append(getDatabaseUsername(), o.getDatabaseUsername());
        builder.append(getAppNames(), o.getAppNames());

        return builder.toComparison();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
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
     * @return the databaseUsername
     */
    public String getDatabaseUsername() {
        return databaseUsername;
    }

    /**
     * @param databaseUsername the databaseUsername to set
     */
    public void setDatabaseUsername(String databaseUsername) {
        this.databaseUsername = databaseUsername;
    }

    /**
     * @return the appNames
     */
    public Set<String> getAppNames() {
        return appNames;
    }

}
