package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class IndeedPage {
	public IndeedPage(){
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy(id = "text-input-where")
	public WebElement wherefield;
	
	@FindBy(id = "text-input-what")
	public WebElement whatfield;
	
	@FindBy(xpath = "//button[text()='Search']")
	public WebElement searchBtn;
	
	@FindBy(linkText = "Upload your resume")
	public WebElement uploadResumeLink;
}
