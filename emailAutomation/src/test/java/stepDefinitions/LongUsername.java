package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.When;

public class LongUsername {
	
	 	WebDriver driver;

	 	@When("user enters email2")
		public void user_enters_testing2() {
			//driver = new ChromeDriver();
			WebElement email = driver.findElement(By.id("email"));
			email.sendKeys("Second try");
		}

		@When("user selects a username2")
		public void user_selects_a_username2() {
			WebElement username = driver.findElement(By.id("new_username"));
			username.sendKeys("Second try");
		}
		@When("user types a password2")
		public void user_types_a_password2() {
			WebElement password = driver.findElement(By.id("new_password"));
			password.sendKeys("Second try");
		}

}
