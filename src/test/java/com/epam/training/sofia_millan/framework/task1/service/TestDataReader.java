package com.epam.training.sofia_millan.framework.task1.service;

import java.util.ResourceBundle;

// ******* CRITERIA 4 *********
/**
 * This class provides a method to read test data from a resource bundle
 * based on the specified environment.
 * @author Sofía Millán
 */
public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));


    /**
     * Retrieves the corresponding test data value from the resource bundle based on the provided key.
     * @param key the key for the desired test data value.
     * @return the test data value corresponding to the specified key.
     */
    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}
