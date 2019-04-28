package stepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.PropertyFileHandling;
import utils.WebDriverAutomation;

public class LoginStepdef extends WebDriverAutomation{

	
	@Given("^Navigate to Free CRM site$")
	public void navigate_to_Free_CRM_site() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("In Step1");
	    
	   driver= WebDriverAutomation.getWebDriver(PropertyFileHandling.getPropertyValue("BROWSER", CONFIG_FILE_PATH));
	   String URLvalue=PropertyFileHandling.getPropertyValue("URL", CONFIG_FILE_PATH);
		System.out.println("URL is "+URLvalue);
		driver.get(URLvalue);
		
	   
	}

	@When("^username and password$")
	public void username_and_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("In Step2");
		
		Thread.sleep(7000);
	    
	}

	@Then("^Login should be successful\\.$")
	public void login_should_be_successful() throws Throwable {
	    // Write code here that turns the phrase above into concrete action
		
		//loginPage.Login(PropertyFileHandling.getPropertyValue("UName", CONFIG_FILE_PATH), PropertyFileHandling.getPropertyValue("Pwd", CONFIG_FILE_PATH));
	
	    WebElement namePath=driver.findElement(By.name("username"));
	    
	    JavascriptExecutor js= (JavascriptExecutor) driver;
	    
	    js.executeScript("arguments[0].click();,arguments[1].value='Test';", namePath);
	    
		
	}


}
