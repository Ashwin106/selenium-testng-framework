package com.ash.tests;

import org.testng.annotations.Test;

import com.ash.pages.AdminPage;
import com.ash.pages.LoginPage;
import com.ash.pages.RecruitmentPage;
import com.ash.utility.BasePage;

public class RecritmentCreation extends BasePage{
	@Test
	public void Recruit() {
		new LoginPage().enterusername().enterpassword().clickLogin();
		new RecruitmentPage().recruitmentTabClick().EnterName().selectVacancy().enterEmail().entercContactNumber().
		// datePicker().
				enterNotes().save();

	}

}
