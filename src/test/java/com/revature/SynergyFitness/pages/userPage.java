package com.revature.SynergyFitness.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class userPage {
private WebDriver driver;
	
	@FindBy(id="seltest")
	private WebElement profiledata;
	
	public userPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void navigateTo() {
		driver.get("http://localhost:4200/userprofile");
	}

}
