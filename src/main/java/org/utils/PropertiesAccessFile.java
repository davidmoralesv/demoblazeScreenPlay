package org.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesAccessFile {
    private PropertiesAccessFile() {
    }

    public static String getPropertyValue(String strFile, String strKey) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(strFile));
        return properties.getProperty(strKey);
    }
}
