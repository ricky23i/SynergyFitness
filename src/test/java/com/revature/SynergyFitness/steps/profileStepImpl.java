package com.revature.SynergyFitness.steps;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.revature.SynergyFitness.pages.profilesPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class profileStepImpl {
	private profilesPage page;
	private WebDriver driver;
	{
		File file =new File("SynergyFitnessBackEnd/src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		driver = new ChromeDriver();
		page= new profilesPage(driver);
	}

	@Given("the user is on the profiles component")
	public void the_user_is_on_the_profiles_component() {
	   page.navigateTo();
	}

	@Then("profiles load")
	public void profiles_load() {
		
	   assertNotNull(page.getElementValue());
	}
}
