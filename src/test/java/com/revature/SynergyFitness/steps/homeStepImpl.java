package com.revature.SynergyFitness.steps;

import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.SynergyFitness.pages.homePage;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class homeStepImpl {
	private static homePage page;
	private static WebDriver driver;
	
	@BeforeAll
	public static void setupDriver() {
		File file =new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		driver = new ChromeDriver();
		page= new homePage(driver);
	}
	@Given("the user is on the home component")
	public void the_user_is_on_the_home_component() {
		page.navigateTo();
	}

	@Then("posts load")
	public void posts_load() {
		WebDriverWait wait = new WebDriverWait(driver,15);
		   wait.until(ExpectedConditions.presenceOfElementLocated(By.id("posttext")));
		WebElement text = driver.findElement(By.id("posttext"));
		assertNotNull(text.getText());
	}
	@Given("the user is loggedin")
	public void the_user_is_loggedin() {
		page.navigateTo();
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

@Given("the user clicks post button")
public void the_user_clicks_post_button() {
	WebDriverWait wait = new WebDriverWait(driver,15);
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.id("postbutton")));
	WebElement postp = driver.findElement(By.id("postbutton"));
	postp.click();
}

@When("the user types post")
public void the_user_types_post() {
	WebDriverWait waitb = new WebDriverWait(driver,15);
	waitb.until(ExpectedConditions.presenceOfElementLocated(By.id("wrkout222")));
	   WebElement usernameInput = driver.findElement(By.id("wrkout222"));
		usernameInput.sendKeys("post test");
		WebDriverWait waitb1 = new WebDriverWait(driver,2000);
}

@When("the user clicks submit")
public void the_user_clicks_submit() {
	WebDriverWait waitb1 = new WebDriverWait(driver,15);
	   waitb1.until(ExpectedConditions.presenceOfElementLocated(By.id("wrkoutbtn")));
	WebElement subBtn = driver.findElement(By.id("wrkoutbtn"));
	subBtn.click();
}



	@Then("the post shows on the feed")
	public void the_post_shows_on_the_feed() {
		WebDriverWait wait = new WebDriverWait(driver,15);
		   wait.until(ExpectedConditions.presenceOfElementLocated(By.id("posttext")));
		WebElement text = driver.findElement(By.id("posttext"));
		assertNotNull(text.getText());
	}
	@AfterAll
	public static void closeDriver() {
		driver.quit();
	}

}
