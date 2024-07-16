package com.epam.training.sofia_millan.framework.task1.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage extends BasePage{

    @FindBy(xpath = "//div[contains(@class, 'YSM5S')]")
    WebElement searchIcon;

    @FindBy(xpath = "//input[contains(@class, 'mb2a7b')]")
    WebElement searchBar;

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

    public void performSearch(){
        searchIcon.click();
        wait.until(ExpectedConditions.visibilityOf(searchBar)).sendKeys("Google Cloud Platform Pricing Calculator");
        searchBar.sendKeys(Keys.RETURN);
    }
}
