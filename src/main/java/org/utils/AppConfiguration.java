package org.utils;

import java.io.IOException;

public class AppConfiguration {
    private static final String URL = "url";

    private AppConfiguration() {
    }

    public static String getURL() throws IOException {
        String PROPERTIES_FILE = "demoBlaze.properties";
        return PropertiesAccessFile.getPropertyValue(PROPERTIES_FILE, URL);
    }
}
