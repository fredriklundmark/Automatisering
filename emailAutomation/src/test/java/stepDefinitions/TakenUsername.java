package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.When;

public class TakenUsername {

		WebDriver driver;
		
		@When("user enters email3")
		public void user_enters_testing3() {
			WebElement email = driver.findElement(By.id("email"));
			email.sendKeys("Third try");
		}

		@When("user selects a username3")
		public void user_selects_a_username3() {
			WebElement username = driver.findElement(By.id("new_username"));
			username.sendKeys("Third try");
		}
		@When("user types a password3")
		public void user_types_a_password3() {
			WebElement password = driver.findElement(By.id("new_password"));
			password.sendKeys("Third try");
		}




}
