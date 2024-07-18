package com.epam.training.sofia_millan.framework.task1.utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * Utility class providing browser-related functions.
 * @author Sofía Millán
 */
public class BrowserUtils {

    /**
     * Changes the browser tab to the specified title.
     * @param driver the WebDriver instance
     * @param tabTitle the title of the tab to switch to
     */
    public static void changeTab(WebDriver driver, String tabTitle){
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(tabTitle)) {
                break;
            }
        }
    }
}
