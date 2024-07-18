package com.epam.training.sofia_millan.framework.task1.utils;

import com.epam.training.sofia_millan.framework.task1.driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

// ******* CRITERIA 6 *********
/**
 * This class provides custom behavior for handling test events in a test framework.
 * @author Sofía Millán
 */
public class TestListener implements ITestListener {
    private final Logger logger = LogManager.getRootLogger();

    /**
     * Invoked when a test fails. Takes a screenshot the browser and saves it to a specified directory.
     * @param iTestResult the result of the test that failed.
     */
    public void onTestFailure(ITestResult iTestResult) {
        saveScreenshot();
    }

    /**
     * Takes a screenshot of the current state of the active browser window and saves it to the
     * {@code target/test-failure-screenshots/} directory with a timestamp in the filename.
     */
    private void saveScreenshot(){
        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/test-failure-screenshots/"
                            + Utils.getCurrentTimeAsString() +
                            ".png"));
        } catch (IOException e) {
            logger.error("Unable to save the screenshot: "+e.getMessage());
        }
    }


}
