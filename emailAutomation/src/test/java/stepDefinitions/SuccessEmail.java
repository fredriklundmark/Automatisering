package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SuccessEmail {

	public WebDriver driver;
	
	@Given("User is on Sign up page")
	public void user_is_on_sign_up_page() {
	   System.setProperty("webdriver.chrome.driver", "C:\\Webbdrivers\\chromedriver.exe");
	   
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://login.mailchimp.com/signup/");
	}

	@When("user enters email1")
	public void user_enters_testing1() {
		 WebElement email = driver.findElement(By.id("email"));
		 email.sendKeys("emailaddress@123.com");
	}
	
	@When("user selects a username1")
	public void user_selects_a_username1() {
		 WebElement username = driver.findElement(By.id("new_username"));
		 username.sendKeys("Fredrik");
	}
	@When("user types a password1")
	public void user_types_a_password1() {
		 WebElement password = driver.findElement(By.id("new_password"));
		 password.sendKeys("Abcdef1!");
	}
	@When("user click on sign up button")
	public void user_click_on_sign_up_button() {
		// System.out.println("");
		 WebElement button = driver.findElement(By.id("create-account"));
		 button.click();
	}
	@Then("the result will be shown")
	public void the_result_will_be_shown() {
		 System.out.println("h1");
	}

}
