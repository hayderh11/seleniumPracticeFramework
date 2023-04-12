package day4_advanceLocatorContinue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day3_homworkRecap {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/hayde/OneDrive/Desktop/SeleniumTools/ChromeDriver/chromedriver_win32 (1)/chromedriver.exe");
//		faceBookTestCase1();

		indeedTestCase3();
	}

	public static void faceBookTestCase1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		// Test case 1 - (Use only Xpath)
		// go to facebook.com
		driver.get("https://www.facebook.com/");
		// find the Email or phone number field and type Automation
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Automation");
		Thread.sleep(500);
		// find the Password field and type Automation
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Automation");
		Thread.sleep(500);
		// find the Login button and click on it.
		driver.findElement(By.xpath("//button[@data-testid='royal_login_button']")).click();
		Thread.sleep(500);
	}

	public static void faceBookTestCase2() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		// go to facebook.com
		driver.get("https://www.facebook.com/");
		// find the Create New Account button and click on it
		driver.findElement(By.xpath("//a['@data-testid='open-registration-form-button']")).click();
		Thread.sleep(1000);
		// find the FirstName, LastName, Email and Password fields and type Automation
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Automation");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Automation");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("Automation");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Automation");
		Thread.sleep(500);
		// find the Sign Up button and click on it.
		driver.findElement(By.xpath("//button[@name='websubmit']"));

	}

	public static void indeedTestCase3() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		// Test case 3 - (Use only Xpath)
		// go to indeed.com
		driver.get("https://indeed.com");
		// 2. get the current URL and store it in a variable called homeURL.
		String homeURL = driver.getCurrentUrl();
		// 3. get the website title and store it in a variable homeTitle.
		String homeTitle = driver.getTitle();
		// 4. find the input field for WHAT and type SDET
		driver.findElement(By.xpath("//input[@id='text-input-what']")).sendKeys("SDET");
		// 5. find the input field for where, clear the field first and type washington
		// DC
		WebElement whereField = driver.findElement(By.xpath("//input[@name='l']"));
		whereField.sendKeys(Keys.COMMAND + "a"); // Selects all the content using Ctrl A
		whereField.sendKeys(Keys.DELETE); // Deletes the content

		// another way of deleting the text in a box by looping
		// gettin the pre-existing text in the box using getAttribute method
		String locationText = whereField.getAttribute("value");
		
		for (int i = 0; i < locationText.length(); i++) {
			whereField.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(100);
		}
		
		whereField.sendKeys("washington DC");
		// 6. find the Search button and click on it.
		driver.findElement(By.xpath("//button[@class='yosegi-InlineWhatWhere-primaryButton']")).click();
		Thread.sleep(1000);
		// get the current URL and store it as a variable searchURL.
		String searchURL = driver.getCurrentUrl();
		System.out.println("Search URL: "+searchURL);
		// 7. get the website title and store it in a variable searchTitle.
		String searchTitle = driver.getTitle();
		System.out.println("Search title "+searchTitle);
		// 8. verify that searchURL does not equal to homeURL and contains the search
		// criteria.
		// 9. verify that searchTitle does not equal to homeTitle and has the search
		// criteria.
		// 10. Get Text of the JobsInLocation field, store it in a variable,
		// 11. then verify if it's equal to your search criteria.
	}
}
