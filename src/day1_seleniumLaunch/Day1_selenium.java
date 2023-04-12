package day1_seleniumLaunch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1_selenium {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:/Users/hayde/OneDrive/Desktop/SeleniumTools/ChromeDriver/chromedriver_win32 (1)/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.com");
		
		System.out.println("Title: " +driver.getTitle());
		System.out.println("URL: "+ driver.getCurrentUrl());
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Soccer ball");
		driver.findElement(By.id("nav-search-submit-text")).click();
		
		driver.findElement(By.linkText("Customer Service")).click();
	}
}
