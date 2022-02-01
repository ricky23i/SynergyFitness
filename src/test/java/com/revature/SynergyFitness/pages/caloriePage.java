package com.revature.SynergyFitness.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class caloriePage {
private WebDriver driver;
	
	@FindBy(id="seltest")
	private WebElement profiledata;
	
	public caloriePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void navigateTo() {
		driver.get("http://localhost:4200/calorietracker");
	}
//	@SuppressWarnings("deprecation")
	//public String getElementValue() {
//		WebDriverWait wait = new WebDriverWait(driver,15);
//		wait.FIVE_HUNDRED_MILLIS;
		//return profiledata.getText();
//	}
	
}
