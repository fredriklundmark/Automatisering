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
	private String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private String randomText = "";
	private int length = 20;
	private Random generate = new Random();
	
	@Given("User is on Sign up page")
	public void user_is_on_sign_up_page() {
	   System.setProperty("webdriver.chrome.driver", "C:\\Webbdrivers\\chromedriver.exe"); 
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://login.mailchimp.com/signup/");
	   
	   char[] text = new char[length];
		
		for(int i = 0; i <length; i++) {
			text[i] = alphabet.charAt(generate.nextInt(alphabet.length()));			// Saves the randomized characters from the alphabet-string according to the preset length of 20.
		}
		for(int i = 0; i <text.length; i++) {
			randomText += text[i];
		}
	}

	@When("user enters {string}")
	public void user_enters_email(String emailAddress) {
		WebElement mail = driver.findElement(By.id("email"));
		
		if(emailAddress.matches("successEmail")) {
		mail.sendKeys(randomText + "@abc.com");
		} 
		if(emailAddress.matches("email2")) {
		mail.sendKeys(randomText + "@abc.com");
		}
		if(emailAddress.matches("email3")) {
		mail.sendKeys(randomText + "@abc.com");
		}
		if(emailAddress.matches("missingEmail")) {						// Not necessary, but added for symmetry and overview with the rest of the code. (4 test cases)
		mail.sendKeys("");
			}
	}
	
	@When("user selects a {string}")
	public void user_selects_a_username(String username) {
		WebElement name = driver.findElement(By.id("new_username"));
		
		if(username.matches("successUsername")) {							
		name.sendKeys(randomText);										// Successful random name
		}
		if(username.matches("longUsername")) {								
		name.sendKeys(randomText.repeat(5) + "a");						// Long username - 100 characters + a 
		}
		if(username.matches("takenUsername")) {	
		name.sendKeys("FredrikLundmark");								// Taken name
		}
		if(username.matches("username")) {
			name.sendKeys(randomText);									// Valid username but missing e-mail.
		}
	}
	
	@When("user types a {string}")
	public void user_types_a_password(String password) {
		 WebElement pass = driver.findElement(By.id("new_password"));
		 pass.sendKeys("Abcdef1!");										// A preset password that fulfills the sites requirements.
		 
		 String actualPass = driver.findElement(By.className("c-media")).getText();
		 String expectedPass = "Your password is secure and you're all set!";
		 Assert.assertEquals(actualPass, expectedPass);
	}
	
	@When("user click on sign up button")
	public void user_click_on_sign_up_button() {
		 WebElement button = driver.findElement(By.id("create-account"));
		 button.click();
	}
	
	@Then("the {string} will be shown")
	public void the_result_will_be_shown(String result) {
		
		if(result.matches("success")) {
		
		WebElement successPage = driver.findElement(By.className("signup-wrap"));
		boolean pageAfterSignUp = successPage.isDisplayed();
		//String successPage = driver.findElement(By.className("margin-bottom--lv5")).getText();
		//String successfulRegistration = driver.findElement(By.className("signup-wrap")).getText();
		//String expectedSuccessfulRegistration = "We've sent a message to"; //"Mailchimp | Success" with textLink
		//Assert.assertEquals(successPage, expectedSuccessfulRegistration);
		Assert.assertEquals(true, pageAfterSignUp);
		}
		if(result.matches("failLong")) {
		String longUsernameError = driver.findElement(By.className("invalid-error")).getText();
		String expectedLongUsernameError = "Enter a value less than 100 characters long";
		Assert.assertEquals(longUsernameError, expectedLongUsernameError);
		}
		if(result.matches("failTaken")) {
		String takenUsernameError = driver.findElement(By.className("invalid-error")).getText();								
		String expectedTakenError = "Another user with this username already exists. Maybe it's your evil twin. Spooky.";		//Taken username test
		Assert.assertEquals(takenUsernameError, expectedTakenError);
		}
		if(result.matches("failMissing")) {
		String missingEmailError = driver.findElement(By.className("invalid-error")).getText();
		String expectedMissingEmailError = "Please enter a value";
		Assert.assertEquals(missingEmailError, expectedMissingEmailError);
		}
		//driver.close();
				 
	}
	
}
