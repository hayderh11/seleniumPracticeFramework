package day6_workingwithWebElemetns;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyEventPractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/hayde/OneDrive/Desktop/SeleniumTools/ChromeDriver/chromedriver_win32 (1)/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Coffee Mug"+ Keys.ENTER);
		Thread.sleep(1000);
		String f = "name";
		driver.findElement(By.name("q")).clear();
		Thread.sleep(1000);
		driver.findElement(By.name("q")).sendKeys("Selenium WebDriver"+ Keys.ENTER);
		
	}

}
