package com.demoqa.config;

import com.demoqa.entity.Employee;
import com.demoqa.pages.elements.WebTablesPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileReader {
    private static Properties properties;

    static {
    try {
        String path = "src/main/resources/app.properties";
        FileInputStream inputStream = new FileInputStream(path);
        properties = new Properties();
        properties.load(inputStream);
        inputStream.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public static String getValue(String key) {
        return properties.getProperty(key).trim();
    }
}
