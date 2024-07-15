package com.epam.training.sofia_millan.framework.task1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    WebDriver driver;

    @FindBy(className = "YSM5S")
    WebElement searchIcon;

    @FindBy(className = "mb2a7b")
    WebElement searchBar;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void openPage() {
        driver.get("https://cloud.google.com/");
        driver.manage().window().maximize();

    }

    public void performSearch(){
        searchIcon.click();
        searchBar.sendKeys("Google Cloud Platform Pricing Calculator");
        searchBar.sendKeys(Keys.RETURN);
    }
}
