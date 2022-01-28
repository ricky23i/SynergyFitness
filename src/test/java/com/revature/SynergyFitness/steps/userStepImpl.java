package com.revature.SynergyFitness.steps;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.SynergyFitness.pages.userPage;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class userStepImpl {
	private static userPage page;
	private static WebDriver driver;
	
	@BeforeAll
	public static void setupDriver() {
		File file =new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		driver = new ChromeDriver();
		page= new userPage(driver);
	}
	@Given("the user is on the user component")
	public void the_user_is_on_the_user_component() {
	    page.navigateTo();
	}

	@Given("the users is logged in")
	public void the_users_is_logged_in() {
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

	@Then("user info displays")
	public void user_info_displays() {
		WebDriverWait wait = new WebDriverWait(driver,15);
		   By element= By.id("ffname");
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
			  WebElement text= driver.findElement(By.id("ffname"));
			  assertNotNull(text.getText());
	}

	@When("the user changes info")
	public void the_user_changes_info() {
		WebElement usernameInput = driver.findElement(By.id("ffname"));
		usernameInput.sendKeys("Ricky");
	}

	@Then("the appropiate update msg appears")
	public void the_appropiate_update_msg_appears() {
		WebDriverWait wait = new WebDriverWait(driver,15);
		   By element= By.id("ffname");
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
			  WebElement text= driver.findElement(By.id("ffname"));
			  assertNotNull(text.getText());
	}
}
