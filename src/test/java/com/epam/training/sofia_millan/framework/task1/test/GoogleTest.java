package com.epam.training.sofia_millan.framework.task1.test;


import com.epam.training.sofia_millan.framework.task1.driver.DriverSingleton;
import com.epam.training.sofia_millan.framework.task1.model.Instance;
import com.epam.training.sofia_millan.framework.task1.pages.CalculatorPage;
import com.epam.training.sofia_millan.framework.task1.pages.HomePage;
import com.epam.training.sofia_millan.framework.task1.pages.SearchResultsPage;
import com.epam.training.sofia_millan.framework.task1.pages.SummaryPage;
import com.epam.training.sofia_millan.framework.task1.service.InstanceCreator;
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
public class GoogleTest {
    static WebDriver driver;

    /**
     * Initializes the driver before any test methods are executed.
     */
    @BeforeClass
    static void setUp(){
        driver = DriverSingleton.getDriver();
    }


    /**
     * This test method:
     * 1. Opens the Google Cloud home page.
     * 2. Searches for the Google Cloud Pricing Calculator.
     * 3. Completes the required form fields to get an estimate.
     * 4. Obtains and stores the estimate from the calculator.
     * 5. Shares the estimate to generate a summary.
     * 6. Obtains and stores the estimate from the summary page.
     * 7. Compares the calculator's estimate with the summary's estimate to ensure they match,
     * as well as the values provided in the form.
     */
    @Test
    void calculateEstimate(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.performSearch();

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.followLinkToCalculator();

        Instance instance = InstanceCreator.getInstance();

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.fillForm(instance);
        double calculatorEstimate = calculatorPage.getEstimate();
        calculatorPage.shareEstimate();

        SummaryPage summaryPage = new SummaryPage(driver);
        double summaryEstimate = summaryPage.getEstimate();

        //assertEquals(calculatorEstimate, summaryEstimate*2); //If this line is uncommented the test will fail
        assertEquals(calculatorEstimate, summaryEstimate);
        assertEquals(summaryPage.getValueOf(InstanceConstants.INSTANCE_NUMBER), instance.getNumber());
        assertEquals(summaryPage.getValueOf(InstanceConstants.GPU_MODEL), instance.getGpuModel());
        assertEquals(summaryPage.getValueOf(InstanceConstants.REGION), instance.getRegion());
        assertEquals(summaryPage.getValueOf(InstanceConstants.PROVISIONING_MODEL), instance.getProvisioningModel());
        assertEquals(summaryPage.getValueOf(InstanceConstants.GPU_NUMBER), instance.getNumberGpus());
        assertEquals(summaryPage.getValueOf(InstanceConstants.LOCAL_SSD), instance.getLocalSSD());
        assertEquals(summaryPage.getValueOf(InstanceConstants.COMMITTED_USE), instance.getCommittedUse());
        assertEquals(summaryPage.getValueOf(InstanceConstants.OPERATING_SYSTEM), instance.getOperatingSystem());
        assertTrue(summaryPage.getValueOf(InstanceConstants.MACHINE_TYPE).contains(instance.getMachineType()));

    }

    /**
     * Closes all driver windows after all test methods have been executed.
     */
    @AfterClass
    static void tearDown(){
        DriverSingleton.closeDriver();
    }
}
