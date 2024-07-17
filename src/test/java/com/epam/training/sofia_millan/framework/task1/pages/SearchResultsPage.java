package com.epam.training.sofia_millan.framework.task1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * The SearchResultsPage class represents the search results page on the Google Cloud website.
 * It extends the BasePage class, initializing web elements and providing methods to interact with the page.
 * @author Sofía Millán
 */
public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class, 'gs-title') and contains(., 'Google Cloud Pricing Calculator')]")
    WebElement result;

    /**
     * Constructs a new SearchResultsPage.
     *
     * @param driver the WebDriver instance to be used by this page class
     */
    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


    /**
     * Clicks on the link to the Google Cloud Pricing Calculator in the search results.
     * Waits until the link is visible before clicking.
     */
    public void followLinkToCalculator() {
        wait.until(ExpectedConditions.visibilityOf(result)).click();
    }
}
