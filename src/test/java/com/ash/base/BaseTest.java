        package com.ash.base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ash.utility.BasePage;
import com.ash.utils.ExtentManager;
import com.ash.utils.ScreenshotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class BaseTest extends BasePage{
	

	
	    protected WebDriver driver;
	    protected static ExtentReports extent;
	    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

	    @BeforeSuite
	    public void setUpExtent() {
	        extent = ExtentManager.getInstance();
	    }

	    @BeforeMethod
	    public void setUp(Method method) {
	        driver = new ChromeDriver();
	        ExtentTest test = extent.createTest(method.getName());
	        testThread.set(test);
	    }

	    @AfterMethod
	    public void tearDown(ITestResult result) {
	        ExtentTest test = testThread.get();

	        if (result.getStatus() == ITestResult.FAILURE) {
	            String screenshotBase64 = ScreenshotUtil.captureScreenshotToFile(driver,result.getName());
	            test.fail("Test Failed: " + result.getThrowable(),
	                      MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());
	        } else if (result.getStatus() == ITestResult.SUCCESS) {
	            test.pass("Test Passed");
	        } else if (result.getStatus() == ITestResult.SKIP) {
	            test.skip("Test Skipped: " + result.getThrowable());
	        }

	        driver.quit();
	    }

	    @AfterSuite
	    public void tearDownExtent() {
	        extent.flush();
	    }

	    protected ExtentTest getTest() {
	        return testThread.get();
	    }

	    protected void logStep(String message) {
	        String base64Screenshot = ScreenshotUtil.captureScreenshotToFile(driver,"step");
	        getTest().info(message,
	                       MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
	    }
	}



