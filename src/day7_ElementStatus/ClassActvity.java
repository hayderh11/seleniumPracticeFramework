package day7_ElementStatus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClassActvity {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/hayde/OneDrive/Desktop/SeleniumTools/ChromeDriver/chromedriver_win32 (1)/chromedriver.exe");
		testcase1();
//		alertdemo();
	}

	public static void testcase1() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// go to amazon.
		driver.get("https://www.amazon.com/");
		// verify that you are on the amazon home page. (verify with title
		System.out.println(driver.getTitle());
		// verify dropdown value is by default “All Departments
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		Select element = new Select(dropdown);
		String firstSelectedOption = element.getFirstSelectedOption().getText();

		if (firstSelectedOption.equals("All Departments")) {
			System.out.println("Dropdown value by default is 'All Departments'");
		} else {
			System.out.println("Dropdown value by default is NOT 'All Departments'");
		}
		// select department Home & Kitchen, and search coffee mug
		element.selectByVisibleText("Home & Kitchen");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Coffee Mug" + Keys.ENTER);
		// verify you are on coffee mug search results page (use title).
		System.out.println(driver.getTitle());

		if (driver.getTitle().equals("Amazon.com : Coffee Mug")) {
			System.out.println("I am on the coffee results page");
		} else {
			System.out.println("I am not on the coffee results page");
		}
		// verify you are in Home & Kitchen department.
		 if(element.getFirstSelectedOption().getText().equals("Home & Kitchen")) {
			System.out.println("I am on the Home and Kitchen department");
		}else {
			System.out.println("I am not on the Home and kitchen department");
		}
	}

	public static void alertdemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert handle = driver.switchTo().alert();
		Thread.sleep(1000);
		handle.accept();
		
		driver.findElement(By.id("prompt")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.alertIsPresent());

		Alert handle2= driver.switchTo().alert();
		System.out.println(handle2.getText());
		handle2.sendKeys("John");
		Thread.sleep(1000);
		handle2.dismiss();
	}
}
