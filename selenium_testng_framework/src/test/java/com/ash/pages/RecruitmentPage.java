package com.ash.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ash.utility.BasePage;
import com.ash.utils.waitStrategy;

public class RecruitmentPage extends BasePage {
	private final By RecruitmentButton = By.xpath("//a//span[text()='Recruitment']");
	private final By AddButton = By.xpath("//button[text()=' Add ']");
	private final By Firstname = By.xpath("//input[@name='firstName']");
	private final By Middlename = By.xpath("//input[@name='middleName']");
	private final By Lastname = By.xpath("//input[@name='lastName']");
	private final By VacancyDropdown = By.xpath("//div[@class='oxd-select-wrapper']");
	private final By Emailtext = By
			.xpath("(//div//label[text()='Email']//following::input[@placeholder='Type here'])[1]");
	private final By contactnum = By
			.xpath("(//div//label[text()='Contact Number']//following::input[@placeholder='Type here'])[1]");
	private final By notes = By
			.xpath("(//div//label[text()='Notes']//following::textarea[@placeholder='Type here'])[1]");
	private final By saveButton = By.xpath("//button[text()=' Save ']");

	public RecruitmentPage recruitmentTabClick() {
		clickBy(RecruitmentButton, waitStrategy.CLICKABLE);
		clickBy(AddButton, waitStrategy.CLICKABLE);

		return this;

	}

	public RecruitmentPage EnterName() {
		enterValue(Firstname, waitStrategy.PRESENCE, "Robert");
		enterValue(Middlename, waitStrategy.PRESENCE, "Downey");
		enterValue(Lastname, waitStrategy.PRESENCE, "Junior");

		return this;
	}

	public RecruitmentPage selectVacancy() {
		clickBy(VacancyDropdown, waitStrategy.VISIBLE);

		WebElement listofVacancy = driver.findElement(VacancyDropdown);
		String vacancyText = listofVacancy.getText();
		String[] vacancies = vacancyText.split("\\r?\\n");

		String vacancy = "Junior Account Assistant";

		for (String option : vacancies) {
			WebElement optionElement = listofVacancy.findElement(By.xpath(".//*[contains(text(),'" + vacancy + "')]"));
			optionElement.click();
		}
		return this;

	}

	public RecruitmentPage enterEmail() {
		enterValue(Emailtext, waitStrategy.VISIBLE, "RDJ@test.com");
		return this;

	}

	public RecruitmentPage entercContactNumber() {
		enterValue(contactnum, waitStrategy.VISIBLE, "9876543210");
		return this;
	}
	
	public RecruitmentPage datePicker() {
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-calendar oxd-date-input-icon']")).click();
		
			
//			String displayedmonthyear=driver.findElement(By.xpath("//i[@class='oxd-date-input-calendar' and contains(text(),'June']")).getText();
//			if(displayedmonthyear.contains("July")&&displayedmonthyear.contains("2025")) {
//				
//			
//			  driver.findElement(By.xpath("//button[@class='oxd-icon-button' and not(@disabled)]")).click();
//			
//		}
//		List<WebElement> dates = driver.findElements(By.xpath("//div[@class='oxd-calendar-date']"));
//	    for (WebElement date : dates) {
//	        if (date.getText().equals("5")) {
//	            date.click();
//	            break;
//	        }
//	    }
//		return this;
//		
		clickBy(By.className("oxd-calendar-dropdown--month"), waitStrategy.CLICKABLE);
		  //wait.until(ExpectedConditions.elementToBeClickable(By.className("oxd-calendar-dropdown--month"))).click();
	        // Select Month = June
		//clickBy(By.xpath("By.xpath(\"//div[@class='oxd-calendar-dropdown--option' and text()='June']");
	      //  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oxd-calendar-dropdown--option' and text()='June']"))).click();

	        // Click Year Dropdown
	      //  wait.until(ExpectedConditions.elementToBeClickable(By.className("oxd-calendar-dropdown--year"))).click();
	        // Select Year = 2025
	       // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oxd-calendar-dropdown--option' and text()='2025']"))).click();
//
	        // Now click on the date: 26
	       // wait.until(ExpectedConditions.elementToBeClickable(
	               // By.xpath("//div[@class='oxd-calendar-date' and text()='26']"))).click();
		return this;
	}

	public RecruitmentPage enterNotes() {
		enterValue(notes, waitStrategy.VISIBLE, "test NOtes-test");
		return this;
	}

	public RecruitmentPage save() {
		clickBy(saveButton, waitStrategy.VISIBLE);
		return this;
	}
	//new change in framework
	

}
