package com.epam.training.sofia_millan.framework.task1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * This class represents the search results page on the Google Cloud website.
 * @author Sofía Millán
 */
public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class, 'gs-title') and contains(., 'Google Cloud Pricing Calculator')]")
    WebElement result;

    /**
     * Constructor for SearchResultsPage.
     *  It sets up PageFactory.
     * @param driver the WebDriver instance
     */
    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    /**
     * Clicks on the link to the Google Cloud Pricing Calculator in the search results.
     */
    public void followLinkToCalculator() {
        wait.until(ExpectedConditions.visibilityOf(result)).click();
    }
}
