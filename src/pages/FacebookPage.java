package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class FacebookPage {
	
	public FacebookPage(){
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy(name = "email")
	public WebElement FbEmailField;
	
	@FindBy(name= "pass")
	public WebElement FbPasswordField;
	
	@FindBy(name = "login")
	public WebElement FbLoginButton;
	
}
