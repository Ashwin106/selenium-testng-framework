package com.ash.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import com.ash.base.BaseTest;
import com.ash.utility.BasePage;
//import com.ash.utils.ExtentTestManager;
import com.ash.utils.waitStrategy;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.model.Test;
//import com.aventstack.extentreports.reporter.ExtentReporter;

public class LoginPage extends BaseTest {
	// https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

	private final By username_textbox = By.xpath("//div//input[@name='username']");
	private final By password_textbox = By.xpath("//div//input[@name='password']");
	private final By loginBtn = By.xpath("//div//button[@type='submit']");

	public LoginPage enterusername() {
		enterValue(username_textbox, waitStrategy.VISIBLE, "Admin");
		//logStep("entered username:Admin");
	
		return this;

	}

	public LoginPage enterpassword() {
		
		enterValue(password_textbox, waitStrategy.VISIBLE, "admin123");
		//logStep("entered password: admin123");
	
		
				return this;

	}
	//login page

	public LoginPage clickLogin() {
		clickBy(loginBtn, waitStrategy.VISIBLE);
		//Set<Cookie> cookies=driver.manage().getCookies();
	//	System.out.println(cookies);
		//logStep("clicked on login successfully");
		return this;

	}

}