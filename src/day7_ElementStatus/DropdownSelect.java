package day7_ElementStatus;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownSelect {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/hayde/OneDrive/Desktop/SeleniumTools/ChromeDriver/chromedriver_win32 (1)/chromedriver.exe");
//		dropdownDemo();
		nonSelectDropdown();
	}

	public static void dropdownDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");

		WebElement selectelement = driver.findElement(By.id("searchDropdownBox"));
		Select choose = new Select(selectelement);

		WebElement firstSelectOption = choose.getFirstSelectedOption();
		System.out.println(firstSelectOption.getText());

		choose.selectByVisibleText("Home & Kitchen");
		Thread.sleep(1000);
		choose.selectByIndex(5);
		Thread.sleep(1000);
		choose.selectByValue("search-alias=stripbooks");

		System.out.println(choose.getFirstSelectedOption().getText());

		List<WebElement> allOptions = choose.getOptions();
		for (WebElement element : allOptions) {
			System.out.println(element.getText());
		}
	}

	public static void nonSelectDropdown() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, 5);

		// go to this website
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		// wait until the dropdown element is visible
		WebElement dropdown = driver.findElement(By.xpath("(//div[@class='ui fluid selection dropdown'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(dropdown));
		//and click on the dropdown element
		dropdown.click();
		//Wait until the matt guy visible
		WebElement mattOption = driver.findElement(By.xpath("//div[@data-value='matt']"));
		
		wait.until(ExpectedConditions.visibilityOf(mattOption));
		mattOption.click();
		
	}
}
