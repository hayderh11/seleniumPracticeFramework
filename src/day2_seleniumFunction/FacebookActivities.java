package day2_seleniumFunction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookActivities {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:/Users/hayde/OneDrive/Desktop/SeleniumTools/ChromeDriver/chromedriver_win32 (1)/chromedriver.exe");
		FacebookActivities fb = new FacebookActivities();
		fb.testcase1();
		fb.testcase2();

	}

	public void testcase1() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");

		driver.findElement(By.id("email")).sendKeys("Automation");
		driver.findElement(By.id("pass")).sendKeys("Automation");
		driver.findElement(By.name("login")).click();
		driver.close();
	}

	public void testcase2() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("firstname")).sendKeys("automation");
		driver.findElement(By.name("lastname")).sendKeys("automation");
		driver.findElement(By.name("reg_email__")).sendKeys("automation");
		driver.findElement(By.name("reg_passwd__")).sendKeys("automation");
		driver.findElement(By.name("websubmit")).click();
		driver.close();
	}
	
	public void getTextPractice() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		
		driver.findElement(By.name("login")).getText();
		
	}

}
