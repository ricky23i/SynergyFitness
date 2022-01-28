package com.revature.SynergyFitness.steps;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.SynergyFitness.pages.caloriePage;

import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class calorieStepImpl {
	private static caloriePage page;
	private static WebDriver driver;
	@BeforeAll
	public static void setupDriver() {
		File file =new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		driver = new ChromeDriver();
		page= new caloriePage(driver);
	}
	@Given("the user is on the tracker component")
	public void the_user_is_on_the_tracker_component() {
		page.navigateTo();
	}

	@Given("the user is logged in")
	public void the_user_is_logged_in() {
		WebDriverWait wait = new WebDriverWait(driver,15);
		   wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		WebElement loginLink = driver.findElement(By.id("login"));
		loginLink.click();
		WebElement usernameInput = driver.findElement(By.id("username"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		usernameInput.sendKeys("ricky23i");
		passwordInput.sendKeys("123456789");
		WebDriverWait wait1 = new WebDriverWait(driver,15);
		   wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("loginBtn")));
		WebElement loginBtn = driver.findElement(By.id("loginBtn"));
		loginBtn.click();
		
	}

	@Then("tracker displays info")
	public void tracker_displays_info() {
	 
	   WebDriverWait wait = new WebDriverWait(driver,15);
	   By element= By.id("lcals");
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		  WebElement text= driver.findElement(By.id("lcals"));
		  assertNotNull(text.getText());
	}

	@When("the user enters calories")
	public void the_user_enters_calories() {
		WebElement calInput = driver.findElement(By.id("calsadd"));
		WebElement foodInput = driver.findElement(By.id("foodl"));
		calInput.sendKeys("100");
		foodInput.sendKeys("pineapple");
		 WebDriverWait wait = new WebDriverWait(driver,15);
		   wait.until(ExpectedConditions.presenceOfElementLocated(By.id("calbutton")));
			WebElement submit = driver.findElement(By.id("calbutton"));
		submit.click();
	}

	@Then("the appropiate msg appears")
	public void the_appropiate_msg_appears() {
		 WebDriverWait wait = new WebDriverWait(driver,15);
		   By element= By.id("msg");
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
		WebElement text = driver.findElement(By.id("msg"));
		 assertNotNull(text.getText());
	}
	@AfterAll
	public static void closeDriver() {
		driver.quit();
	}
}
