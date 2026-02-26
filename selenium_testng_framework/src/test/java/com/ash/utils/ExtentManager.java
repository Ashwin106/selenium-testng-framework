 package com.ash.utils;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
  
public class ExtentManager {
	private static ExtentReports extent;
	@BeforeTest
	
	 public static ExtentReports getInstance() {
        if (extent == null) {
            extent = createInstance("test-output/ExtentReport.html");
        }
        return extent;
    }

    private static ExtentReports createInstance(String fileName) {
        ExtentSparkReporter reporter = new ExtentSparkReporter(fileName);
        reporter.config().setReportName("Automation Test Report");
        reporter.config().setDocumentTitle("Automation");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Tester", "ASHWIN");
        return extent;
    }
	

}
