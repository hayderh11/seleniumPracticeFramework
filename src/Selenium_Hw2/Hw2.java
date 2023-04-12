package Selenium_Hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hw2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/hayde/OneDrive/Desktop/SeleniumTools/ChromeDriver/chromedriver_win32 (1)/chromedriver.exe");

		Hw2 hw2 = new Hw2();
//		hw2.testcase1();
		hw2.testcase2();

	}

	public void testcase1() throws InterruptedException {
		WebDriver wb = new ChromeDriver();

		wb.get("https://www.etsy.com/");

		wb.findElement(By.className("select-signin")).click();
		Thread.sleep(1000);
		wb.findElement(By.name("email")).sendKeys("automation");
		wb.findElement(By.name("password")).sendKeys("automation");
		wb.findElement(By.name("submit_attempt")).click();
		Thread.sleep(1000);
		wb.close();
	}

	public void testcase2() {
		WebDriver wb = new ChromeDriver();
		// Step 1:
		wb.get("https://www.indeed.com/");
		String homeURL = wb.getCurrentUrl();
		System.out.println("Current URL: " + homeURL);
		//Step 2
		String homeTitle = wb.getTitle();
		System.out.println("Title: " + homeTitle);
		//Step 3
		wb.findElement(By.name("q")).sendKeys("SDET");
		wb.findElement(By.className("yosegi-InlineWhatWhere-primaryButton")).click();
		//Step 4
		String searchURL = wb.getCurrentUrl();
		System.out.println("Search URL: " + searchURL);
		//Step 5
		String searchTitle = wb.getTitle();
		System.out.println("Search Title: " + searchTitle);
		//Step 6
		boolean url = searchURL == homeURL;
		System.out.println("Are the URLS equal: " + url);
		//Step 7
		boolean titles = homeTitle == searchTitle;
		System.out.println("Are the Titles equal: " + titles);
		//Step 8
		String JobsInLocation = wb.findElement(By.id("label-text-input-where")).getText();
		System.out.println("This is the JobsInLocation: " + JobsInLocation);
		if (JobsInLocation.equals(searchTitle)
				&& searchTitle.contains("Sdet Jobs, Employment in Manassas, VA | Indeed.com")) {
			System.out.println("Valid JobInLocation");
		} else {
			System.out.println("Invalid JobInLocation");
		}
	}

}
