package day4_advanceLocatorContinue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathContainsText {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/hayde/OneDrive/Desktop/SeleniumTools/ChromeDriver/chromedriver_win32 (1)/chromedriver.exe");
		// xpath();
		cssSelector();
	}
	// //tagname[contains(@attribute, ‘someValue’)]

	public static void xpath() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		// Go to etsy
		driver.get("https://www.etsy.com/");

		// Click on sign in
		driver.findElement(By.xpath("//button[contains(text(),\"Sign in\")]")).click();
		Thread.sleep(500);

		// Click on register
		driver.findElement(By.xpath("//button[contains(text(),\"Register\")]")).click();
		Thread.sleep(500);

		// Enter an email
		driver.findElement(By.xpath("//input[contains(@id, 'email_field')]")).sendKeys("jon.dow@gmail.com");
		Thread.sleep(500);

		// Enter first name
		driver.findElement(By.xpath("//input[contains(@id, 'first_name_field')]")).sendKeys("Jon");
		Thread.sleep(500);

		// Enter Password
		driver.findElement(By.xpath("//input[contains(@id, 'password_field')]")).sendKeys("Jon123$gdg");
		Thread.sleep(500);

		// Click Register button
		driver.findElement(By.xpath("//button[contains(text(),'Register')]")).click();
		Thread.sleep(1000);

		// Verify Error message
		String errorMessage = driver.findElement(By.xpath("//div[contains(text(), 'already in use')]")).getText();
		if (errorMessage.equals("Sorry, the email you have entered is already in use.")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Fail");
		}
	}

	public static void cssSelector() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		// Go to etsy
		driver.get("https://www.etsy.com/");

		// Click on sign in
		driver.findElement(By.cssSelector(".select-signin")).click();
		Thread.sleep(500);

		// Click on register
		driver.findElement(By.cssSelector(".select-register")).click();
		Thread.sleep(500);

		// Enter an email
		driver.findElement(By.cssSelector("input[name=email]")).sendKeys("jon.dow@gmail.com");
		Thread.sleep(500);

		// Enter first name
		driver.findElement(By.cssSelector("input[name=first_name]")).sendKeys("Jon");
		Thread.sleep(500);

		// Enter Password
		driver.findElement(By.cssSelector("input[name=password]")).sendKeys("Jon123$gdg");
		Thread.sleep(500);

		// Click Register button
		driver.findElement(By.cssSelector("button[value=register]")).click();
		Thread.sleep(1000);

		// Verify Error message
		String errorMessage = driver.findElement(By.cssSelector("div[id=aria-join_neu_email_field-error]")).getText();
		if (errorMessage.equals("Sorry, the email you have entered is already in use.")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Fail");
		}
	}
}
