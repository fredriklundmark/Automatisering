package stepDefinitions;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SuccessEmail {

	private WebDriver driver;
	Random generate = new Random();
	
	@Given("User is on Sign up page")
	public void user_is_on_sign_up_page() {
	   System.setProperty("webdriver.chrome.driver", "C:\\Webbdrivers\\chromedriver.exe"); 
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://login.mailchimp.com/signup/");
	}

	@When("user enters {string}")
	public void user_enters_email(String emailAddress) {
		
		WebElement mail = driver.findElement(By.id("email"));
		int emailNumber = generate.nextInt();
		mail.sendKeys(emailNumber + 1000 + "@abc.com"); 					//The e-mail webElement required a minimum of 4 numbers and a @ to be supported.
		
	}
	@When("user selects a {string}")
	public void user_selects_a_username(String username) {
		
		int userNumber = generate.nextInt(); 
		WebElement name = driver.findElement(By.id("new_username"));
		name.sendKeys(userNumber + "");										// Successful random name
		//name.sendKeys("FredrikLundmark");									// Taken userName
	}
	
	@When("user types a {string}")
	public void user_types_a_password(String password) {
		 WebElement pass = driver.findElement(By.id("new_password"));
		 pass.sendKeys("Abcdef1!");
	}
	
	@When("user click on sign up button")
	public void user_click_on_sign_up_button() {
		 WebElement button = driver.findElement(By.id("create-account"));
		// button.click();
	}
	
	@Then("the {string} will be shown")
	public void the_result_will_be_shown(String result) {
		//String actualError = driver.findElement(By.className("invalid-error")).getText();								
		//String expectedError = "Another user with this username already exists. Maybe it's your evil twin. Spooky.";		//Taken username test
		//Assert.assertEquals(actualError, expectedError);
		
		//driver.close();
				 
	}

}
