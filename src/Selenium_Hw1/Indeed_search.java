package Selenium_Hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Indeed_search {

	public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver","C:/Users/hayde/OneDrive/Desktop/SeleniumTools/ChromeDriver/chromedriver_win32 (1)/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://indeed.com");
	}

}
