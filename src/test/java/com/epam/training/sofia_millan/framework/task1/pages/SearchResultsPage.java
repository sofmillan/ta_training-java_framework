package com.epam.training.sofia_millan.framework.task1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class, 'gs-title') and contains(., 'Google Cloud Pricing Calculator')]")
    WebElement result;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void search() {
        wait.until(ExpectedConditions.visibilityOf(result)).click();
    }
}
