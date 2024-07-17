package com.epam.training.sofia_millan.framework.task1.service;

import java.util.ResourceBundle;

// ******* CRITERIA 4 *********
public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}
