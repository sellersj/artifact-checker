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
     * Skip the clone and checks against the actual project.
     */
    public static final String SKIP_CLONE = "SKIP_CLONE";

    /** The url of the applications file. */
    public static final String APPLICATIONS_URL = "APPLICATIONS_URL";

    /** The filename where we track java 8 issues with dependencies. */
    public static final String JAVA8_ISSUES_FILENAME = "java8-issues.txt";

    /** The hostname of the public facing apps. */
    public static final String PUBLIC_HOSTNAME = "PUBLIC_HOSTNAME";

    /** The hostname of the intranet facing apps. */
    public static final String INTRANET_HOSTNAME = "INTRANET_HOSTNAME";

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
