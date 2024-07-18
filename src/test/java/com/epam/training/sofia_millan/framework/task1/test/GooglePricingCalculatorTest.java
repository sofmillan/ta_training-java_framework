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


    @Test(groups = {"smoke"})
    void escenario1(){
        Instance instance = InstanceCreator.getInstance();
        SummaryPage summaryPage = flow(instance);

        assertEquals(summaryPage.getValueOf(InstanceConstants.INSTANCE_NUMBER), instance.getNumber());
        assertEquals(summaryPage.getValueOf(InstanceConstants.GPU_MODEL), instance.getGpuModel());
        assertEquals(summaryPage.getValueOf(InstanceConstants.REGION), instance.getRegion());
        assertEquals(summaryPage.getValueOf(InstanceConstants.PROVISIONING_MODEL), instance.getProvisioningModel());
        assertEquals(summaryPage.getValueOf(InstanceConstants.GPU_NUMBER), instance.getNumberGpus());
    }

    @Test
    void escenario2(){
        Instance instance = InstanceCreator.getInstance();
        SummaryPage summaryPage = flow(instance);

        assertEquals(summaryPage.getValueOf(InstanceConstants.LOCAL_SSD), instance.getLocalSSD());
        assertEquals(summaryPage.getValueOf(InstanceConstants.COMMITTED_USE), instance.getCommittedUse());
        assertEquals(summaryPage.getValueOf(InstanceConstants.OPERATING_SYSTEM), instance.getOperatingSystem());
        assertTrue(summaryPage.getValueOf(InstanceConstants.MACHINE_TYPE).contains(instance.getMachineType()));
    }

    private SummaryPage flow(Instance instance){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.performSearch();

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.followLinkToCalculator();

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.fillForm(instance);
        calculatorPage.shareEstimate();
        BrowserUtils.changeTab(driver,1);
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
