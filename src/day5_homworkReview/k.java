package day5_homworkReview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class k {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/hayde/OneDrive/Desktop/SeleniumTools/ChromeDriver/chromedriver_win32 (1)/chromedriver.exe");
//		textBox();
//		t();
		webtables();
	}

	public static void t() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("http://practice.primetech-apps.com/practice/text-box");
		Thread.sleep(1000);
		// Find first name, last name, email, password, address fields, and type
		// relevant information.
		// (Create variables for those information and pass the variable to the
		// sendkey() method).

		String fistname = "Pedri";
		WebElement firstName = driver.findElement(By.xpath("//input[contains(@id, 'firstName')]"));
		firstName.sendKeys(fistname);
		Thread.sleep(2000);
		String lastname = "Gonz";
		WebElement lastName = driver.findElement(By.xpath("//input[contains(@id, 'lastName')]"));
		lastName.sendKeys(lastname);
		Thread.sleep(2000);
		String theEmail = "Padri.gonz@gmail.com";
		WebElement email = driver.findElement(By.xpath("//input[contains(@id, 'email')]"));
		email.sendKeys(theEmail);
		Thread.sleep(2000);
		String thePassword = "Padrigonz123";
		WebElement password = driver.findElement(By.xpath("//input[contains(@id, 'password')]"));
		password.sendKeys(thePassword);
		Thread.sleep(2000);
		WebElement clickButton = driver.findElement(By.xpath("//button[contains(text(), 'Enable')]"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(clickButton));
		clickButton.click();
		Thread.sleep(3000);
		String TheAddressField = "Automation is Fun";
		WebElement addressField = driver.findElement(By.xpath("//textarea[contains(@id, 'address')]"));
		addressField.sendKeys(TheAddressField);
		Thread.sleep(1000);
		// Then click on submit button. (your inputs displays under user info section).
		WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(), 'Submit')]"));
		submitButton.click();
		Thread.sleep(3000);
		// Find your inputs and get text of each and store them into variables.

		String acutalFn = driver.findElement(By.xpath("//div[text()='" + fistname + "']")).getText();
		System.out.println("Acutal Fn is: " + acutalFn);

		String acutalLn = driver.findElement(By.xpath("//div[text()='" + lastname + "']")).getText();
		System.out.println("Acutal Ln is: " + acutalLn);

		String acutalemail = driver.findElement(By.xpath("//div[text()='" + theEmail + "']")).getText();
		System.out.println("Acutal Email is: " + acutalemail);

		String acutalPw = driver.findElement(By.xpath("//div[text()='" + thePassword + "']")).getText();
		System.out.println("Acutal password is: " + acutalPw);

		String acutalAddress = driver.findElement(By.xpath("//div[text()='" + TheAddressField + "']")).getText();
		System.out.println("Acutal addressField is: " + acutalAddress);
		// First name
		if (acutalFn.equals(fistname)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Fail!");
		}
		// Last name
		if (acutalLn.equals(lastname)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Fail!");
		}
		// Email
		if (acutalemail.equals(theEmail)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Fail!");
		}
		// Password
		if (acutalPw.equals(thePassword)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Fail!");
		}
		// Address
		if (acutalAddress.equals(TheAddressField)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test fail!");
		}

	}

	public static void webtables() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		// Homework: Please practice your element locating skills,id, name, xpath and
		// css selector

		// Testcase 2:

		// 1. Go to http://practice.primetech-apps.com/practice/web-tables
		driver.get("http://practice.primetech-apps.com/practice/web-tables");
		// 2. Verify that you see Web Table's text

		String headerText = driver.findElement(By.xpath("//h3[text()='Web Tables']")).getText();

		if (headerText.equals("Web Tables")) {
			System.out.println("We are on the WebTables Page");
		} else {
			System.out.println("We are not on the WebTables Page");
		}
		// 3. Find id, firstname, lastname, salary fields and give a relevant input.
		// (store the information into variables, then pass the variable to sendKeys()
		// method)
		String id = "hh24331";
		String firstName = "Moe";
		String lastName = "John";
		String salary = "120000";

		// ID Path
		WebElement idpath = driver.findElement(By.xpath("//input[@id ='Id']"));
		idpath.sendKeys(id);
		Thread.sleep(2000);
		// Firstname path
		WebElement firstnamePath = driver.findElement(By.xpath("//input[@id ='First Name']"));
		firstnamePath.sendKeys(firstName);
		Thread.sleep(2000);
		// Lastname Path
		WebElement lastnamePath = driver.findElement(By.xpath("//input[@id ='Last Name']"));
		lastnamePath.sendKeys(lastName);
		Thread.sleep(4000);
		//Salary
		WebElement salaryPath = driver.findElement(By.xpath("//input[@id = 'Salary']"));
		salaryPath.sendKeys(salary);
		Thread.sleep(4000);
		
		// 4. Click on Add button
		
		WebElement add = driver.findElement(By.xpath("//button[text()='Add']"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(add));
		Thread.sleep(4000);
		add.click();
		Thread.sleep(4000);
		
		// 5. Then your inputs will display under the table. (use xpath text()
		// contains() functions to locate those elements. get text and store them into
		// variables)
		String acutalId = driver.findElement(By.xpath("//td[text() ='"+id+"']")).getText();
		System.out.println("Acutal Id is : "+acutalId);
		
		//FirstName
		String acutalfirstName = driver.findElement(By.xpath("//td[text()= '"+firstName+"']")).getText();
		System.out.println("acutal first Name is: "+acutalfirstName);
		
		//Last Name
		String acutallastName = driver.findElement(By.xpath("//td[text()= '"+lastName+"']")).getText();
		System.out.println("acutal last Name is: "+acutallastName);
		
		//Salary
		String acutalsalary = driver.findElement(By.xpath("//td[text()= '"+salary+"']")).getText();
		System.out.println("acutal salary is: "+acutalsalary);
		
		// 6. Verify your input under the table match the input you added.
		//Id
		if(acutalId.equals(id)) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
		//First name
		if(acutalfirstName.equals(firstName)) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
		//Last name
		if(acutallastName.equals(lastName)) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
		//salary
		if(acutalsalary.equals(salary)) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
	}
}
