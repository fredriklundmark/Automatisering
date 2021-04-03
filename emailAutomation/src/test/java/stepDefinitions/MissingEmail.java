package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.When;

public class MissingEmail {
	
		WebDriver driver;
		
		@When("user enters email4")
		public void user_enters_testing4() {
			WebElement email = driver.findElement(By.id("email"));
			email.sendKeys("Forth try");
		}

		@When("user selects a username4")
		public void user_selects_a_username4() {
			WebElement username = driver.findElement(By.id("new_username"));
			username.sendKeys("Forth try");
		}
		@When("user types a password4")
		public void user_types_a_password4() {
			WebElement password = driver.findElement(By.id("new_password"));
			password.sendKeys("Forth try");
		}



}
