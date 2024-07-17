package com.epam.training.sofia_millan.framework.task1.pages;

import com.epam.training.sofia_millan.framework.task1.model.Instance;
import com.epam.training.sofia_millan.framework.task1.utils.InstanceConstants;
import com.epam.training.sofia_millan.framework.task1.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This class represents the calculator page of the Google Cloud Pricing Calculator,
 * which allows users to input different configurations and estimate costs.
 * @author Sofía Millán
 */
public class CalculatorPage extends BasePage{
    @FindBy(xpath ="//span[@class='qdOxv-fmcmS-wGMbrd-sM5MNb']//input[@type='number']")
    private WebElement numberInstancesInput;
    @FindBy(xpath ="//h2[text()='Compute Engine']")
    private WebElement product;
    @FindBy(xpath ="//button[@aria-label='Add GPUs']")
    private WebElement addGPUButton;
    @FindBy(xpath ="//span[contains(@class, 'FOBRw-RLmnJb')]")
    private WebElement shareButton;
    @FindBy(xpath ="//a[contains(@class, 'rP2xkc')]")
    private WebElement openEstimateButton;
    @FindBy(xpath ="//span[contains(@class, 'MyvX5d')]")
    private WebElement estimatedCost;
    @FindBy(css =".jirROd button")
    private WebElement addToEstimateButton;
    @FindBy(xpath = "//div[contains(@class,'Z7Qi9d') and contains(@class, ' HY0Uh')]")
    private WebElement updateMessage;
    private String baseDropDown = "//div[contains(@class, 'VfPpkd-TkwUic') and .//span[contains(@class, 'VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe') and contains(text(), '%s')]]";
    private String baseLabel = "//label[contains(@class, 'zT2df') and contains(., '%s')]";
    private String baseListItem = "//ul[@aria-label='%s']//li[contains(.,'%s')]";

    /**
     * Constructor for CalculatorPage.
     * It sets up the PageFactory.
     *
     * @param driver the WebDriver instance.
     */
    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Fills the form for Computer Engine.
     */
    public void fillForm(Instance instance) {
        addProductToEstimate(product);
        wait.until(ExpectedConditions.invisibilityOf(updateMessage));
        wait.until(ExpectedConditions.visibilityOf(numberInstancesInput)).clear();
        numberInstancesInput.sendKeys(instance.getNumber());

        findDropDown(InstanceConstants.OPERATING_SYSTEM).click();
        findItemInList(InstanceConstants.OPERATING_SYSTEM, instance.getOperatingSystem()).click();

        findLabel(instance.getProvisioningModel()).click();

        findDropDown(InstanceConstants.MACHINE_FAMILY).click();
        findItemInList(InstanceConstants.MACHINE_FAMILY, instance.getMachineFamily()).click();

        findDropDown(InstanceConstants.SERIES).click();
        findItemInList(InstanceConstants.SERIES, instance.getSeries()).click();


        findDropDown(InstanceConstants.MACHINE_TYPE).click();
        findItemInList(InstanceConstants.MACHINE_TYPE, instance.getMachineType()).click();

        addGPUButton.click();

        findDropDown(InstanceConstants.GPU_MODEL).click();
        findItemInList(InstanceConstants.GPU_MODEL, instance.getGpuModel()).click();

        findDropDown(InstanceConstants.GPU_NUMBER).click();
        findItemInList(InstanceConstants.GPU_NUMBER,instance.getNumberGpus()).click();


        findDropDown(InstanceConstants.LOCAL_SSD).click();
        findItemInList(InstanceConstants.LOCAL_SSD,instance.getLocalSSD()).click();

        findDropDown(InstanceConstants.REGION).click();
        findItemInList(InstanceConstants.REGION,instance.getRegion()).click();

        findLabel(instance.getCommittedUse()).click();
    }

    /**
     * Shares the resulting estimate by clicking the share button.
     */
    public void shareEstimate(){
        wait.until(ExpectedConditions.invisibilityOf(updateMessage));
        shareButton.click();
        wait.until(ExpectedConditions.visibilityOf(openEstimateButton)).click();
    }

    /**
     * Waits for any update messages to disappear before retrieving the estimated cost.
     * @return the estimated cost as a double
     */
    public Double getEstimate(){
        wait.until(ExpectedConditions.invisibilityOf(updateMessage));
        String estimate = estimatedCost.getText();
        return Utils.convertStringToDouble(estimate);
    }

    /**
     * Finds a drop-down element by its title.
     * @param title the title of the drop-down
     * @return the WebElement representing the drop-down
     */
    private WebElement findDropDown(String title){
        String dropDownLocator = String.format(baseDropDown, title);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropDownLocator)));
    }

    /**
     * Finds a label element by its title.
     * @param title the title of the label
     * @return the WebElement representing the label
     */
    private WebElement findLabel(String title){
        String labelLocator = String.format(baseLabel, title);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(labelLocator)));
    }

    /**
     * Finds an item in a list by its value.
     * @param title the title of the list
     * @param value the value of the list item
     * @return the WebElement representing the list item
     */

    private WebElement findItemInList(String title, String value){
        String listItemLocator = String.format(baseListItem, title, value);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(listItemLocator)));
    }

    /**
     * Adds a product to the estimate by clicking the "Add to Estimate" button and selecting the product.
     * @param product the WebElement representing the product to add
     */
    private void addProductToEstimate(WebElement product){
        wait.until(ExpectedConditions.visibilityOf(addToEstimateButton)).click();
        wait.until(ExpectedConditions.visibilityOf(product)).click();
    }
}