package com.github.sellersj.artifactchecker;

import org.apache.commons.lang3.StringUtils;

public class Constants {

    /**
     * The hostname where the tools are runnings.
     */
    public static final String TOOLS_HOST = "TOOLS_HOST";

    /**
     * The hostname where we can access the logs.
     */
    public static final String PROD_LOG_HOST = "PROD_LOG_HOST";

    /**
     * If there are jira key corrections, we will use this host.
     */
    public static final String CORRECTED_JIRA_HOST = "CORRECTED_JIRA_HOST";

    /**
     * Skip the clone and checks against the actual project.
     */
    public static final String SKIP_CLONE = "SKIP_CLONE";

    /** The url of the applications directory. */
    public static final String WAS_INFO_HOST = "WAS_INFO_HOST";

    /** The url of the cipo host. */
    public static final String WAS_CIPO_HOST = "WAS_CIPO_HOST";

    /** The filename where we track java 8 issues with dependencies. */
    public static final String JAVA8_ISSUES_FILENAME = "java8-issues.txt";

    /** The name of the file we will put matching epic templating lines. */
    public static final String TEMPLATE_MATCHING_LINE_FILENAME = "epic-template-lines.txt";

    /** The name of the file we will put matching epic usage lines. */
    public static final String EPIC_MATCHING_LINE_FILENAME = "epic-resource-lines.txt";

    /** So we can use to figure out resource mapping. */
    public static final String WEB_DOT_XML_FILENAME = "web.xml";

    /** So we can use to figure out resource mapping. */
    public static final String IBM_WEB_BINDING_FILENAME = "ibm-web-bnd.xml";

    /** The hostname of the public facing apps. */
    public static final String PUBLIC_HOSTNAME = "PUBLIC_HOSTNAME";

    /** The hostname of the intranet facing apps. */
    public static final String INTRANET_HOSTNAME = "INTRANET_HOSTNAME";

    /** The place to write the files from the report. */
    public static final String DEST_DIR_OVERRIDE = "DEST_DIR_OVERRIDE";

    /** The name of the file we will put matching a possible jdbc usage lines. */
    public static final String JDBC_MATCHING_LINE_FILENAME = "jdbc-lines.txt";

    /** Where we have the tree file. */
    public static final String TREE_TXT_FILE = "tree.txt";

    /** The file for the maven effective pom for this project. */
    public static final String EFFECTIVE_POM_XML_FILE = "effective-pom.xml";

    /** The file for the maven plugins for this project. */
    public static final String EFFECTIVE_POM_PLUGINS = "effective-pom-plugins.txt";

    /**
     * This will try to get the variable as a system var, if not falls back to env var. If it's still not found, it will
     * throw an exception.
     *
     * @param varName that we are looking for.
     * @return
     */
    public static final String getSysOrEnvVariable(String varName, boolean throwIfMissing) {
        String result = System.getProperty(varName);

        if (StringUtils.isBlank(result)) {
            // fall back to env variable
            result = System.getenv(varName);

            if (StringUtils.isBlank(result) && throwIfMissing) {
                throw new RuntimeException(String.format("The '%s' system or env variable has to be set", varName));
            }
        }

        return result;
    }

    /**
     * This will try to get the variable as a system var, if not falls back to env var. If it's still not found, it will
     * throw an exception.
     *
     * @param varName that we are looking for.
     * @return
     */
    public static final String getSysOrEnvVariable(String varName) {
        return getSysOrEnvVariable(varName, true);
    }

}
