package com.epam.training.sofia_millan.framework.task1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * This class represents the summary page of the Google Cloud Pricing Calculator,
 * which displays the estimated cost of selected services and the details of the selected configuration.
 * @author Sofía Millán
 */
public class SummaryPage extends  BasePage{

    @FindBy(xpath = "//h4[contains(@class, 'n8xu5')]")
    private WebElement estimatedCostTitle;

    private String baseResult = "//span[contains(@class,'Z7Pe2d') and contains(., '%s')]//span[contains(@class,'Kfvdz')]";
    /**
     * Constructor for SummaryPage.
     * It sets up PageFactory.
     * @param driver the WebDriver instance
     */
    public SummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Retrieves the text value of a web element based on the specified title.
     * @param title the title used to locate the web element
     * @return the text value of the web element
     */
    public String getValueOf(String title){
        String dropDownLocator = String.format(baseResult, title);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropDownLocator))).getText();
    }
}
