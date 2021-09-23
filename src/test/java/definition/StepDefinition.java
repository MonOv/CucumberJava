package definition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class StepDefinition {
	WebDriver driver;
	WebDriverWait wait;
	@Given("I am able to navigate onto Magento homepage")
	public void i_am_able_to_navigate_onto_magento_homepage() {
	    // Write code here that turns the phrase above into concrete actions
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   wait=new WebDriverWait(driver,30);
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.get("https://magento.com/");
	   
	}
	@Given("i click on sign in link")
	public void i_click_on_sign_in_link() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.linkText("Sign in")).click();
	}
	@When("I update the username as {string}")
	public void i_update_the_username_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.id("email")).sendKeys(string);
	}
	@When("I update the password as {string}")
	public void i_update_the_password_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.id("pass")).sendKeys(string);
	}
	@When("I click on the continue button")
	public void i_click_on_the_continue_button() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.name("send")).click();
	}
	@Then("I should see the error message {string}")
	public void i_should_see_the_error_message(String string) {
	    // Write code here that turns the phrase above into concrete actions
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Invalid login or password.')]")));
	    Assert.assertEquals(string,driver.findElement(By.xpath("//div[contains(text(),'Invalid login or password.')]")).getText());
	    driver.quit();
		
	   
	    }
	@Then("I should see the 'email-error'message as {string}")
	public void i_should_see_the_email_error_message_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass-error")));
		Assert.assertEquals(string,driver.findElement(By.id("pass-error")).getText());
		driver.quit();
		
	  
	
	}




}
