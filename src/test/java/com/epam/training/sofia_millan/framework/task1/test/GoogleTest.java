package com.epam.training.sofia_millan.framework.task1.test;


import com.epam.training.sofia_millan.framework.task1.driver.DriverSingleton;
import com.epam.training.sofia_millan.framework.task1.model.Instance;
import com.epam.training.sofia_millan.framework.task1.pages.CalculatorPage;
import com.epam.training.sofia_millan.framework.task1.pages.HomePage;
import com.epam.training.sofia_millan.framework.task1.pages.SearchResultsPage;
import com.epam.training.sofia_millan.framework.task1.pages.SummaryPage;
import com.epam.training.sofia_millan.framework.task1.service.InstanceCreator;
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
     * Initializes the driver, using ChromeDriver, before any test methods are executed.
     */
    @BeforeClass
    static void setUp(){
        driver = DriverSingleton.getDriver();
    }


    /**
     * This test method:
     * 1. Opens the Google Cloud Pricing Calculator page.
     * 2. Completes the required form fields to get an estimate.
     * 3. Obtains and stores the estimate from the calculator.
     * 4. Shares the estimate to generate a summary.
     * 5. Obtains and stores the estimate from the summary page.
     * 6. Compares the calculator's estimate with the summary's estimate to ensure they match.
     */
    @Test
    void calculateEstimate() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.performSearch();

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.search();

        Instance instance = InstanceCreator.getInstance();

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.fillForm(instance);
        double calculatorEstimate = calculatorPage.getEstimate();
        calculatorPage.shareEstimate();

        SummaryPage summaryPage = new SummaryPage(driver);
        double summaryEstimate = summaryPage.getEstimate();

        assertEquals(calculatorEstimate, summaryEstimate);
        assertEquals(instance.getNumber(), summaryPage.getValueOf("Number of Instances"));
        assertEquals(instance.getGpuModel(), summaryPage.getValueOf("GPU Model"));
        assertEquals(instance.getRegion(), summaryPage.getValueOf("Region"));
        assertEquals(instance.getModel(), summaryPage.getValueOf("Provisioning Model"));
        assertEquals(instance.getNumberGpus(), summaryPage.getValueOf("Number of GPUs"));
        assertEquals(instance.getLocalSSD(), summaryPage.getValueOf("Local SSD"));
        assertEquals(instance.getComittedUse(), summaryPage.getValueOf("Committed use discount options"));
        assertEquals(instance.getOs(), summaryPage.getValueOf("Operating System"));
        assertTrue(summaryPage.getValueOf("Machine type").contains(instance.getMachineType()));

    }

    /**
     * Closes all driver windows after all test methods have been executed.
     */
  /*  @AfterClass
    static void tearDown(){
        DriverSingleton.closeDriver();
    }*/
}
