package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	
	@FindBy(name="username")
	WebElement Username;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement LoginButton;
	
	
	//Actions
	
//	public void Login(String Uname,String pwd)
//	{
//		Username.sendKeys(Uname);
//		Password.sendKeys(pwd);
//		LoginButton.click();
//	}
	
}
