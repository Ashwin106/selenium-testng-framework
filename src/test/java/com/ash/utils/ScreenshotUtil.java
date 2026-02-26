package com.ash.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.ash.utility.BasePage;

public class ScreenshotUtil extends BasePage{
	
	public static String captureScreenshotToFile(WebDriver driver, String screenshotName) {
	    String filePath = "screenshots/screenshots/" + screenshotName + "_" + System.currentTimeMillis() + ".png";
	    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    File destFile = new File(filePath);
	    try {
	        FileUtils.copyFile(srcFile, destFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return filePath;
	}

	

	

}

