package com.github.sellersj.artifactchecker;

import org.apache.commons.lang3.StringUtils;

public class ConstantsTest {

    /** Sets values needed for the tests. */
    public static final void setTestValues() {
        setSystemVariable(Constants.TOOLS_HOST, "tools.example.com");
        setSystemVariable(Constants.PROD_LOG_HOST, "logs.example.com");
    }

    /**
     * Only will set the value if it doesn't exist
     *
     * @param key
     * @return value
     */
    public static final void setSystemVariable(String key, String value) {
        if (StringUtils.isBlank(Constants.getSysOrEnvVariable(key, false))) {
            System.setProperty(key, value);
        }
    }

}
