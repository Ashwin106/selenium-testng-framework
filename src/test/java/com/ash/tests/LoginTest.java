package com.ash.tests;

import org.testng.annotations.Test;

import com.ash.pages.LoginPage;
import com.ash.utility.BasePage;

public class LoginTest extends BasePage{
	@Test
	public void Login() {
		new LoginPage().enterusername().enterpassword().clickLogin();
		
	}

}
