package day3_advanceLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:/Users/hayde/OneDrive/Desktop/SeleniumTools/ChromeDriver/chromedriver_win32 (1)/chromedriver.exe");
		
		etsy();
	}
	
	public static void etsy() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.etsy.com");
		//Click on Sign in
		driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']")).click();
		
		Thread.sleep(1000);
		
		//Click on register
		driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--secondary wt-btn--small']")).click();
		Thread.sleep(1000);
		
		//Enter email
		
		driver.findElement(By.xpath("//input[@id='join_neu_email_field']")).sendKeys("jon.dow@gmail.com");
		Thread.sleep(1000);
		
		//Enter Name
		
		driver.findElement(By.xpath("//input[@id='join_neu_first_name_field']")).sendKeys("John");
		Thread.sleep(500);
		
		//Enter Password
		
		driver.findElement(By.xpath("//input[@id='join_neu_password_field']")).sendKeys("1224234ssfs");
		Thread.sleep(500);
		
		//Click Register
		
		driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--primary wt-width-full']")).click();
		Thread.sleep(500);

		//Verify Error meassage
		
		String expectedError = "Sorry, the email you have entered is already in use.";
		
		WebElement acutalerror = driver.findElement(By.xpath("//div[@class='wt-text-body-01 wt-text-center-xs']"));
	
		if(expectedError.equals(acutalerror)) {
			System.out.println("Error message Passed");
		}
		else {
			System.out.println("Error message Failed");
		}
		
		
		
		
		
	}
}
