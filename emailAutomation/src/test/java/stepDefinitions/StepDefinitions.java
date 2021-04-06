package stepDefinitions;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	private WebDriver driver;
	private String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
	private String randomName = "";
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
			text[i] = alphabet.charAt(generate.nextInt(alphabet.length()));	 // Saves the randomized characters from the alphabet-string according to the preset length of 20.
		}
		for(int i = 0; i <text.length; i++) {
			randomName += text[i];
		}
	}

	@When("user enters {string}")
	public void user_enters_email(String emailAddress) {
		WebElement emailInput = driver.findElement(By.id("email"));
		
		if(emailAddress.matches("successEmail")) {
		emailInput.sendKeys(randomName + "@abc.com");
		} 
		if(emailAddress.matches("email2")) {
		emailInput.sendKeys(randomName + "@abc.com");
		}
		if(emailAddress.matches("email3")) {
		emailInput.sendKeys(randomName + "@abc.com");
		}
		if(emailAddress.matches("missingEmail")) {	// Not necessary, but added for symmetry and overview with the rest of the code. (4 test cases)
		emailInput.sendKeys("");
		}
	}
	
	@When("user selects a {string}")
	public void user_selects_a_username(String username) {
		WebElement userNameInput = driver.findElement(By.id("new_username"));
		
		if(username.matches("successUsername")) {							
		userNameInput.sendKeys(randomName);
		}
		if(username.matches("longUsername")) {								
		userNameInput.sendKeys(randomName.repeat(5) + "a");
		}
		if(username.matches("takenUsername")) {	
		userNameInput.sendKeys("FredrikLundmark");
		}
		if(username.matches("username")) {
		userNameInput.sendKeys(randomName);	
		}
	}
	
	@When("user types a {string}")
	public void user_types_a_password(String password) {
		WebElement passwordInput = driver.findElement(By.id("new_password"));
		passwordInput.sendKeys("Abcdef1!");	 // A preset password that fulfills the sites requirements.
		 
		String actualPass = driver.findElement(By.className("c-media")).getText();
		String expectedPass = "Your password is secure and you're all set!";
		Assert.assertEquals(actualPass, expectedPass);
	}

	@When("user click on sign up button")
	public void user_click_on_sign_up_button() {
		driver.findElement(By.id("create-account")).click();
	}
	
	@Then("the {string} will be shown")
	public void the_result_will_be_shown(String result) {
		
		if(result.matches("success")) {
		WebElement successRegistration = driver.findElement(By.cssSelector("h1[class='!margin-bottom--lv3 no-transform center-on-medium']"));
		WebElement successInformation = driver.findElement(By.className("signup-wrap"));
		
		String successPageText = "Check your email";
		boolean pageAfterSignUp = successInformation.isDisplayed();
		
		Assert.assertEquals(successRegistration.getText(), successPageText);
		Assert.assertEquals(true, pageAfterSignUp);
		}
		if(result.matches("failLong")) {
		WebElement longUsernameError = driver.findElement(By.cssSelector(".invalid-error"));
		String expectedLongUsernameError = "Enter a value less than 100 characters long";
		Assert.assertEquals(longUsernameError.getText(), expectedLongUsernameError);
		}
		if(result.matches("failTaken")) {
		WebElement takenUsernameError = driver.findElement(By.cssSelector(".invalid-error"));						
		String expectedTakenError = "Another user with this username already exists. Maybe it's your evil twin. Spooky.";
		Assert.assertEquals(takenUsernameError.getText(), expectedTakenError);
		}
		if(result.matches("failMissing")) {
		WebElement missingEmailError = driver.findElement(By.cssSelector(".invalid-error"));
		String expectedMissingEmailError = "Please enter a value";
		Assert.assertEquals(missingEmailError.getText(), expectedMissingEmailError);
		}		
	}
	@After
	public void driverClose() { 
		driver.close();
	}
}

