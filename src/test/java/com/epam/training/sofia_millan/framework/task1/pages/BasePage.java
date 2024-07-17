package com.epam.training.sofia_millan.framework.task1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class serves as a parent class for all page objects.
 * It provides basic setup for derived page classes by initializing the WebDriver and WebDriverWait.
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
