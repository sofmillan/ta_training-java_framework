package com.epam.training.sofia_millan.framework.task1.test;


import com.epam.training.sofia_millan.framework.task1.driver.DriverSingleton;
import com.epam.training.sofia_millan.framework.task1.pages.CalculatorPage;
import com.epam.training.sofia_millan.framework.task1.pages.SummaryPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import static org.testng.Assert.assertEquals;

/**
 * This class contains automated tests for the Google Cloud Pricing Calculator.
 * @author Sofía Millán
 */
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
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.openPage();
        calculatorPage.fillForm();
        double calculatorEstimate = calculatorPage.getEstimate();
        calculatorPage.shareEstimate();

        SummaryPage summaryPage = new SummaryPage(driver);
        double summaryEstimate = summaryPage.getEstimate();

        assertEquals(calculatorEstimate, summaryEstimate);
    }

    /**
     * Closes all driver windows after all test methods have been executed.
     */
    @AfterClass
    static void tearDown(){
        DriverSingleton.closeDriver();
    }
}
