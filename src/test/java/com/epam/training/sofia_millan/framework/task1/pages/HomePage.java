package com.epam.training.sofia_millan.framework.task1.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * The HomePage class represents the main page of the Google Cloud website.
 * It extends the BasePage class, initializing web elements and providing methods to interact with the page.
 * @author Sofía Millán
 */
public class HomePage extends BasePage{

    @FindBy(xpath = "//div[contains(@class, 'YSM5S')]")
    WebElement searchIcon;

    @FindBy(xpath = "//input[contains(@class, 'mb2a7b')]")
    WebElement searchBar;

    /**
     * Constructs a new HomePage.
     *
     * @param driver the WebDriver instance to be used by this page class
     */
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    /**
     * Opens the calculator page in the web browser.
     * Maximizes the browser window.
     */
    public void openPage() {
        driver.get("https://cloud.google.com/");
        driver.manage().window().maximize();

    }

    /**
     * Performs a search for the Google Cloud Platform Pricing Calculator using the search bar.
     * It clicks the search icon, waits for the search bar to be visible, enters the search term, and submits the search.
     */
    public void performSearch(){
        searchIcon.click();
        wait.until(ExpectedConditions.visibilityOf(searchBar)).sendKeys("Google Cloud Platform Pricing Calculator");
        searchBar.sendKeys(Keys.RETURN);
    }
}
