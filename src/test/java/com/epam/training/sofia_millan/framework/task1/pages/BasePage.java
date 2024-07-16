package com.epam.training.sofia_millan.framework.task1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * The BasePage class serves as a foundational class for all page objects in a Selenium framework.
 * It initializes the WebDriver and WebDriverWait, providing basic setup for all derived page classes.
 * @author Sofía Millán
 */
public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Constructor for BasePage.
     * @param driver the WebDriver instance to be used by this page class
     */
    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
