package day5_homworkReview;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day4_homeworkReview {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/hayde/OneDrive/Desktop/SeleniumTools/ChromeDriver/chromedriver_win32 (1)/chromedriver.exe");

//		testcase1();
		textBox();
	}

	public static void testcase1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
//			Go to http://practice.primetech-apps.com/practice/text-box
		driver.get("http://practice.primetech-apps.com/practice/text-box");
//			Find first name, last name, email, password, address fields, and type relevant information. 
//			(Create variables for those information and pass the variable to the sendkey() method).
		String firstname = "John";
		String lastname = "dow";
		String email = "johndow123@gmail.com";
		String password = "1123@fasf";
		String address = "12 main st, Fairfax, VA, 22030";
		driver.findElement(By.cssSelector("#firstName")).sendKeys(firstname);
		driver.findElement(By.cssSelector("#lastName")).sendKeys(lastname);
		driver.findElement(By.cssSelector("#email")).sendKeys(email);
		driver.findElement(By.cssSelector("input[id=password]")).sendKeys(password);
//		driver.findElement(By.xpath("//button[text()='Enable']")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("textarea[id=address]")).sendKeys(address);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		

		

//			Then click on submit button. (your inputs displays under user info section).
//			Find your inputs and get text of each and store them into variables.
//			Then compare your input with the displayed user information if they match.

	}

	public static void textBox() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		// Homework: Please use Xpath or Css selector only:
		// Testcase 1:
		// Go to http://practice.primetech-apps.com/practice/text-box
		driver.get("http://practice.primetech-apps.com/practice/text-box");
		// Find first name, last name, email, password, address fields, and type
		// relevant information.
		// (Create variables for those information and pass the variable to the
		// sendkey() method).
		String firstname = "Hello";
		String lastname = "dow";
		String email = "john.dow@gmail.com";
		String password = "12345hello";
		String address = "123 main st, fairfax, VA, 22030";
		driver.findElement(By.cssSelector("#firstName")).sendKeys(firstname);
		driver.findElement(By.cssSelector("#lastName")).sendKeys(lastname);
		driver.findElement(By.cssSelector("#email")).sendKeys(email);
		driver.findElement(By.cssSelector("input[id=password]")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Enable']")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("textarea[id=address]")).sendKeys(address);
		// Then click on submit button. (your inputs displays under user info section).
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(1000);
		// Find your inputs and get text of each and store them into variables.
		String firstNameActual = driver.findElement(By.xpath("//div[text()='" + firstname + "']")).getText();
		System.out.println("Actual first name is: " + firstNameActual);

		String lastNameActual = driver.findElement(By.xpath("//div[text()='" + lastname + "']")).getText();
		System.out.println("Actual last name is: " + lastNameActual);

		String emailActual = driver.findElement(By.xpath("//div[text()='" + email + "']")).getText();
		System.out.println("Actual email is: " + emailActual);

		String passwordActual = driver.findElement(By.xpath("//div[text()='" + password + "']")).getText();
		System.out.println("Actual password is: " + passwordActual);

		String addressActual = driver.findElement(By.xpath("//div[text()='" + address + "']")).getText();
		System.out.println("Actual address is: " + addressActual);
		// Then compare your input with the displayed user information if they match.

		if (firstNameActual.equals(firstname)) {
			System.out.println("Test Pass!");
		} else {
			System.out.println("Test Fail!");
		}
		if (lastNameActual.equals(lastname)) {
			System.out.println("Test Pass!");
		} else {
			System.out.println("Test Fail!");
		}
		if (emailActual.equals(email)) {
			System.out.println("Test Pass!");
		} else {
			System.out.println("Test Fail!");
		}
		if (passwordActual.equals(password)) {
			System.out.println("Test Pass!");
		} else {
			System.out.println("Test Fail!");
		}
		if (addressActual.equals(address)) {
			System.out.println("Test Pass!");
		} else {
			System.out.println("Test Fail!");
		}

	}
}