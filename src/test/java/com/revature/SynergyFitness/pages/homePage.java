package com.revature.SynergyFitness.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
private WebDriver driver;
	
	@FindBy(id="seltest")
	private WebElement profiledata;
	
	public homePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void navigateTo() {
		driver.get("http://localhost:4200/post");
	}
//	@SuppressWarnings("deprecation")
}
