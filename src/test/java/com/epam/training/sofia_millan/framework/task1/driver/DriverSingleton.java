package com.epam.training.sofia_millan.framework.task1.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

// ******* CRITERIA 1 *********
/**
 * This class implements the Singleton pattern to provide a single point of access to a WebDriver object.
 * @author Sofía Millán
 */
public class DriverSingleton {
    private static WebDriver driver;

    /**
     * Provides a single WebDriver instance. If the driver instance is null,
     * it initializes it based on the system property "browser".
     * @return the single instance of WebDriver.
     */
    public static WebDriver getDriver(){
        if (null == driver){
            switch (System.getProperty("browser")){
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-search-engine-choice-screen");
                    driver = new ChromeDriver();
                }
            }
        }
        return driver;
    }

    /**
     * Closes the WebDriver instance and terminates all browser windows.
     */
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
        }
    }
}
