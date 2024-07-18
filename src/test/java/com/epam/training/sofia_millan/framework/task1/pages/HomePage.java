package com.epam.training.sofia_millan.framework.task1.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This class represents the main page of the Google Cloud website.
 * @author Sofía Millán
 */
public class HomePage extends BasePage{
    private final static String URL = "https://cloud.google.com/";

    @FindBy(xpath = "//div[contains(@class, 'YSM5S')]")
    WebElement searchIcon;

    @FindBy(xpath = "//input[contains(@class, 'mb2a7b')]")
    WebElement searchBar;

    /**
     * Constructor for HomePage.
     *  It sets up PageFactory.
     * @param driver the WebDriver instance
     */
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    /**
     * Opens the Google Cloud website.
     * Maximizes the browser window.
     */
    public void openPage() {
        driver.get(URL);
        driver.manage().window().maximize();
    }

    /**
     * Performs a search using the search bar.
     * @param searchTerm term to be searched
     */
    public void performSearch(String searchTerm){
        searchIcon.click();
        wait.until(ExpectedConditions.visibilityOf(searchBar)).sendKeys(searchTerm);
        searchBar.sendKeys(Keys.RETURN);
    }
}
