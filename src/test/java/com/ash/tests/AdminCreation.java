package com.ash.tests;

import org.testng.annotations.Test;

import com.ash.pages.AdminPage;
import com.ash.pages.LoginPage;
import com.ash.pages.RecruitmentPage;
import com.ash.utility.BasePage;

public class AdminCreation extends BasePage {
	@Test
	public void Admin() throws Exception {
		// launchBrowser();

		new LoginPage().enterusername().enterpassword().clickLogin();

		// Admin page
		new AdminPage().clickAdmin().userRole().employeeName().employeeStatus().userName().enterPassword()
				.confirmPassword().save();

	}
	

	
}
