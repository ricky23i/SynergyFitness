package com.revature.SynergyFitness.pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class profilesPage {
	private WebDriver driver;
	
	@FindBy(id="seltest")
	private WebElement profiledata;
	
	public profilesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void navigateTo() {
		driver.get("http://localhost:4200/users");
	}
	@SuppressWarnings("deprecation")
	public String getElementValue() {
//		WebDriverWait wait = new WebDriverWait(driver,15);
//		wait.FIVE_HUNDRED_MILLIS;
		return profiledata.getText();
	}

}
