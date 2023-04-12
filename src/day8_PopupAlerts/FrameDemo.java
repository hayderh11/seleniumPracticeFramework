package day8_PopupAlerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/hayde/OneDrive/Desktop/SeleniumTools/ChromeDriver/chromedriver_win32 (1)/chromedriver.exe");
		framedemo();
	}
	public static void framedemo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		driver.get("http://practice.primetech-apps.com/practice/frames");
		
		driver.switchTo().frame("iframe1"); 
		driver.findElement(By.id("firstName")).sendKeys("Hello");
		
	}
}
