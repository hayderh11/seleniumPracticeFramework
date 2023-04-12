package day6_workingwithWebElemetns;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.Driver;

public class Classactivity {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/hayde/OneDrive/Desktop/SeleniumTools/ChromeDriver/chromedriver_win32 (1)/chromedriver.exe");
//		testcase1();
//		listElements();
//		elementStatus();
//		TestCase2();
//		checkboxHomework();
		amazonHomework();
	}

	public static void testcase1() {
		Driver.getDriver();
		Driver.getDriver().navigate().to("https://www.amazon.com/ ");
		WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[@id ='twotabsearchtextbox']"));
		searchBox.sendKeys("Coffee mug" + Keys.ENTER);
		Driver.getDriver().navigate().back();
		WebElement newSearchbox = Driver.getDriver().findElement(By.xpath("//input[@id ='twotabsearchtextbox']"));
		newSearchbox.sendKeys("Pretty Coffee Mug" + Keys.ENTER);
		Driver.getDriver().navigate().back();
		Driver.getDriver().navigate().forward();
		Driver.getDriver().navigate().refresh();

	}

	public static void listElements() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.navigate().to("https://saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce" + Keys.ENTER);

		List<WebElement> items = driver.findElements(By.cssSelector(".inventory_item"));

		int listSize = items.size();
		System.out.println(listSize);

		List<WebElement> itemPrices = driver.findElements(By.cssSelector(".inventory_item_price"));

		for (int i = 0; i < itemPrices.size(); i++) {
			System.out.println(itemPrices.get(i).getText());
		}

	}

	public static void elementStatus() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.navigate().to("https://www.indeed.com/");
		WebElement whatfield = driver.findElement(By.id("text-input-what"));
		WebElement wherefield = driver.findElement(By.id("text-input-where"));

		if (whatfield.isEnabled() && whatfield.isDisplayed()) {
			System.out.println("What field is enabled and displayed");
		} else {
			System.out.println("What field is not enabled or displayed");
		}

		if (wherefield.isEnabled() && wherefield.isDisplayed()) {
			System.out.println("Where field is enabled and displayed");
		} else {
			System.out.println("Where field is not enabled or displayed");
		}
	}

	public static void TestCase2() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("http://practice.primetech-apps.com/practice/radio-button");

		List<WebElement> radiobuttons = driver.findElements(By.cssSelector(".form-check-input"));

		for (WebElement button : radiobuttons) {
			if (button.isEnabled() && button.isDisplayed()) {
				if (button.isSelected()) {
					System.out.println("Button is selected: " + button.isSelected());
				} else {
					System.out.println("Button is not selected");
					button.click();
					Thread.sleep(1000);
					System.out.println("Button is now selected: ");
				}
			} else {
				System.out.println("Radiobuttons is not enabled or displayed");
			}
			System.out.println("is radiobutton selected: " + button.isSelected());
		}

	}

	public static void checkboxHomework() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// find the checkboxes and verify if it’s displayed, if true, then verify if
		// it’s enabled,
		// if true, verify if it’s selected, if false, then check the boxes. Then verify
		// if it’s checked.
		driver.get("http://practice.primetech-apps.com/practice/check-box");
		List<WebElement> checkboxes = driver.findElements(By.cssSelector(".form-check-input"));
		for (WebElement checkbox : checkboxes) {
			if (checkbox.isDisplayed()) {
				System.out.println("Checkbox is displayed");
				if (checkbox.isEnabled()) {
					if (checkbox.isSelected()) {
						System.out.println("CheckBox is selected");
					} else {
						Thread.sleep(1000);
						checkbox.click();
					}
				}
			} else {
				System.out.println("checkbox is not displayed");
			}
			System.out.println("Checkbox is selected: " + checkbox.isSelected());
		}
	}

	public static void amazonHomework() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// go to amazon.com click on signin
		driver.get("https://www.amazon.com/");
		driver.findElement(By.xpath("//span[text()=\"Hello, sign in\"]")).click();
		Thread.sleep(1000);
		// verify that you are on sign in page (either by sign-in text or email field).
		if (driver.findElement(By.id("ap_email")).isDisplayed()) {
			System.out.println("I am on the sign in page");
		} else {
			System.out.println("I am not on the Sign in page");
		}
		// navigate back, and navigate forward
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
		Thread.sleep(1000);
		// verify that you are on sign in page (either by sign-in text or email field).
		if (driver.findElement(By.id("ap_email")).isDisplayed()) {
			System.out.println("I am on the sign in page for the second time ");
		} else {
			System.out.println("I am not on the Sign in page");
		}
		// click on create new account,
		driver.findElement(By.id("createAccountSubmit")).click();
		Thread.sleep(1000);
		// verify you are on new account create page.
		if (driver.findElement(By.xpath("//h1[contains(text(),\"Create account\")]")).isDisplayed()) {
			System.out.println("I am on the create account page");
		} else {
			System.out.println("I am not on the account creation page");
		}
		// navigate back, verify you are on the sign-in page.
		driver.navigate().back();
		Thread.sleep(1000);
		if (driver.findElement(By.id("ap_email")).isDisplayed()) {
			System.out.println("I am on the sign in page for the third time ");
		} else {
			System.out.println("I am not on the Sign in page");
		}
		// navigate forward,
		driver.navigate().forward();
		Thread.sleep(1000);
		// verify you are on the create account page.
		if (driver.findElement(By.xpath("//h1[contains(text(),\"Create account\")]")).isDisplayed()) {
			System.out.println("I am on the create account page for the second time");
		} else {
			System.out.println("I am not on the account creation page");
		}

		// click on the Continue button without filling the form
		driver.findElement(By.id("continue")).click();
		// verify error messages displayed and get text to verify:
		
		//Enter your name
		WebElement nameerror = driver.findElement(By.xpath("//div[contains(text(),\"Enter your name\")]"));
		if(nameerror.isDisplayed()) {
			System.out.println("Enter your name error message is displayed: "+nameerror.isDisplayed());
		}else {
			System.out.println("Enter your name error message is not displayed");
		}
		
		// Enter your email or mobile phone number
		WebElement emailorphone = driver.findElement(By.xpath("//div[contains(text(),\"  Enter your email or mobile phone number\")]"));
		if(emailorphone.isDisplayed()) {
			  
			System.out.println("Enter your email or mobile phone number erros message is displayed: "+emailorphone.isDisplayed());
		}
		else {
			System.out.println("Enter your email or mobile phone number erros message is not displayed");
		}
		
		//Minimum 6 characters required
		WebElement charlimit = driver.findElement(By.xpath("//div[contains(text(),\"  Minimum 6 characters required\")]"));
		if(charlimit.isDisplayed()) {
			System.out.println("Minimum 6 characters required error message is displayed: "+charlimit.isDisplayed());
		}
		else {
			System.out.println("Minimum 6 characters required error message is displayed: not displayed");
		}
	}

}
