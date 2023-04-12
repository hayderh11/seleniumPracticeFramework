package day8_PopupAlerts;

import java.awt.Window;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupWindowsOrTabs {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/hayde/OneDrive/Desktop/SeleniumTools/ChromeDriver/chromedriver_win32 (1)/chromedriver.exe");
//		newTabDemo();
		testcase2();
	}

	public static void newTabDemo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// go to http://practice.primetech-apps.com/practice/browser-windowsClick on
		// ‘New Tab’ button.
		// Then get the window handles and print what are they.
		driver.get("http://practice.primetech-apps.com/practice/browser-windows");
		String mainWindowID = driver.getWindowHandle();
		System.out.println("Main window Id: " + mainWindowID);

		driver.findElement(By.id("newTab")).click();
		Set<String> windowIds = driver.getWindowHandles();
		for (String windowId : windowIds) {
			System.out.println("Window Id is: " + windowId);
		}

		Iterator<String> ids = windowIds.iterator();
		String firstWindowId = ids.next();
		String secondWindowId = ids.next();

		System.out.println("First WindowId: " + firstWindowId);
		System.out.println("Second WindowId: " + secondWindowId);

		driver.switchTo().window(secondWindowId);

		String newTabTextOnSecondWindow = driver.findElement(By.xpath("//h1[text()=\"New Tab\"]")).getText();
		System.out.println(newTabTextOnSecondWindow);

		driver.close();

		driver.switchTo().window(firstWindowId);
		String mainWindowText = driver.findElement(By.xpath("//h3[text()=\"Browser Windows\"]")).getText();
		System.out.println("Main window browser text is: " + mainWindowText);

		if (driver.getWindowHandle().equals(mainWindowID)) {
			System.out.println("Test Pass!");
		} else {
			System.out.println("Test Fail!");

		}
	}

	public static void testcase2() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// go to http://practice.primetech-apps.com/practice/browser-windows1.
		driver.get("http://practice.primetech-apps.com/practice/browser-windows");
		// Get the main window ID and store it in a String called mainWindowId,
		String mainWindowId = driver.getWindowHandle();
		// 2. Click on the ‘New Tab’ button
		driver.findElement(By.id("newTab")).click();
		Thread.sleep(1000);
		// 3. Get window IDs and store it into a Set
		Set<String> windowIds = driver.getWindowHandles();
		// 4. Get the first window ID from the Set and Verify it matches with the main
		// window id in step 1.
		Iterator<String> ids = windowIds.iterator();
		String firstWindowId = ids.next();
		if (firstWindowId.equals(mainWindowId)) {
			System.out.println("FirstWindow Id matches the main Window Id");
		} else {
			System.out.println("The FirstWindow Id does not matche the main Window Id");
		}
		// Then get the second window id and store it in variable called secondWindowId.
		String secondWindowId = ids.next();
		// 5. Switch to the second window
		driver.switchTo().window(secondWindowId);
		// 6. Verify that there is a button called ‘New Tab’
		
		if (driver.findElement(By.id("newTab")).isDisplayed()) {
			System.out.println("Test Pass!");
			System.out.println("There is a button that is Called 'New Tab'");
		} else {
			System.out.println("Test Fail!");
			System.out.println("There is no button that is Called 'New Tab'");
		}
		// 7. Close the window,
		Thread.sleep(1000);
		driver.close();
		// Switch back to the main window,
		driver.switchTo().window(mainWindowId);
		// Verify you are on the main window.
		if (driver.getWindowHandle().equals(mainWindowId)) {
			System.out.println("Test Pass!");
		} else {
			System.out.println("Test Fail!");

		}
	}

}
