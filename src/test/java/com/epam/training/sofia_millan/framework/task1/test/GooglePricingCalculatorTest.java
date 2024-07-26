package com.epam.training.sofia_millan.framework.task1.test;

import com.epam.training.sofia_millan.framework.task1.driver.DriverSingleton;
import com.epam.training.sofia_millan.framework.task1.model.Instance;
import com.epam.training.sofia_millan.framework.task1.pages.CalculatorPage;
import com.epam.training.sofia_millan.framework.task1.pages.HomePage;
import com.epam.training.sofia_millan.framework.task1.pages.SearchResultsPage;
import com.epam.training.sofia_millan.framework.task1.pages.SummaryPage;
import com.epam.training.sofia_millan.framework.task1.service.InstanceCreator;
import com.epam.training.sofia_millan.framework.task1.utils.BrowserUtils;
import com.epam.training.sofia_millan.framework.task1.utils.InstanceConstants;
import com.epam.training.sofia_millan.framework.task1.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * This class contains automated tests for the Google Cloud Pricing Calculator.
 * @author Sofía Millán
 */
@Listeners({TestListener.class})
public class GooglePricingCalculatorTest {
     WebDriver driver;

    /**
     * Initializes the driver before any test methods are executed.
     */
    @BeforeClass(alwaysRun = true)
    public void setUp(){
        driver = DriverSingleton.getDriver();
    }


    /**
     * This test method compares the values provided in the form (GPU number and model, number of instances, provisioning model and region)
     * to the ones presented on the Cost Estimate Summary
     */
    @Test(groups = {"smoke"})
    void scenario1(){
        Instance instance = InstanceCreator.getInstance();
        SummaryPage summaryPage = task1Flow(instance);

        //assertEquals(summaryPage.getValueOf(InstanceConstants.INSTANCE_NUMBER), "Error");  // Uncommenting this line will result in a failure.
        assertEquals(summaryPage.getValueOf(InstanceConstants.INSTANCE_NUMBER), instance.getNumber());
        assertEquals(summaryPage.getValueOf(InstanceConstants.GPU_MODEL), instance.getGpuModel());
        assertEquals(summaryPage.getValueOf(InstanceConstants.REGION), instance.getRegion());
        assertEquals(summaryPage.getValueOf(InstanceConstants.PROVISIONING_MODEL), instance.getProvisioningModel());
        assertEquals(summaryPage.getValueOf(InstanceConstants.GPU_NUMBER), instance.getNumberGpus());
    }

    /**
     * This test method compares the values provided in the form (local SSD, committed use option, machine type and operating system)
     * to the ones presented on the Cost Estimate Summary
     */
    @Test
    void scenario2(){
        Instance instance = InstanceCreator.getInstance();
        SummaryPage summaryPage = task1Flow(instance);

        assertEquals(summaryPage.getValueOf(InstanceConstants.LOCAL_SSD), instance.getLocalSSD());
        assertEquals(summaryPage.getValueOf(InstanceConstants.COMMITTED_USE), instance.getCommittedUse());
        assertEquals(summaryPage.getValueOf(InstanceConstants.OPERATING_SYSTEM), instance.getOperatingSystem());
        assertTrue(summaryPage.getValueOf(InstanceConstants.MACHINE_TYPE).contains(instance.getMachineType()));
    }

    /**
     * This method represent the flow to use the Google Cloud Pricing Calculator.
     * @param instance an Instance object with data to fill form
     * @return a SummaryPage instance
     */
    private SummaryPage task1Flow(Instance instance){
        String searchTerm = "Google Cloud Platform Pricing Calculator";
        String tabTitle="Google Cloud Estimate Summary";

        // 1. Opens the Google Cloud Page and searches for the Pricing Calculator
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.performSearch(searchTerm);

        // 2. Selects the link related to the Pricing Calculator
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.followLinkToCalculator();

        // 3. Fills form related to Compute Engine and shares the estimate
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.fillForm(instance);
        calculatorPage.shareEstimate();
        BrowserUtils.changeTab(driver,tabTitle);

        return new SummaryPage(driver);
    }

    /**
     * Closes all driver windows after all test methods have been executed.
     */
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        DriverSingleton.closeDriver();
    }
}
