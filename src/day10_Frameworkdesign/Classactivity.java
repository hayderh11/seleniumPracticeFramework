package day10_Frameworkdesign;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.FacebookPage;
import utils.DataReader;
import utils.Driver;

public class Classactivity {

	public static void main(String[] args) throws InterruptedException {
//		alertdemo();
		testcase2();
	}
	public static void alertdemo() throws InterruptedException {
		Driver.getDriver();
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
		Driver.getDriver().get("http://practice.primetech-apps.com/practice/alerts/");
		
		Driver.getDriver().findElement(By.id("confirm")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert handle = Driver.getDriver().switchTo().alert();
		Thread.sleep(1000);
		handle.accept();
		
		Driver.getDriver().findElement(By.id("prompt")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.alertIsPresent());

		Alert handle2= Driver.getDriver().switchTo().alert();
		System.out.println(handle2.getText());
		handle2.sendKeys("John");
		Thread.sleep(1000);
		handle2.dismiss();
	}
	
	public static void testcase1() {
		Driver.getDriver();
		Driver.getDriver().get(DataReader.getProperty("testingurl2"));
		WebElement searchBox = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Coffee mug" + Keys.ENTER);
		Driver.getDriver().navigate().back();
		WebElement newSearchbox = Driver.getDriver().findElement(By.xpath("//input[@id ='twotabsearchtextbox']"));
		newSearchbox.sendKeys("Pretty Coffee Mug" + Keys.ENTER);
		Driver.getDriver().navigate().back();
		Driver.getDriver().navigate().forward();
		Driver.getDriver().navigate().refresh();
	}

	public static void testcase2() throws InterruptedException {
		FacebookPage fbpage;
		fbpage = new FacebookPage();
		Driver.getDriver().get(DataReader.getProperty("testingurl"));
		fbpage.FbEmailField.sendKeys(DataReader.getProperty("facebookUsername"));
		fbpage.FbPasswordField.sendKeys(DataReader.getProperty("facebookPassword"));
		Thread.sleep(2000);
		fbpage.FbLoginButton.click();
		Thread.sleep(1000);
		Driver.quitDriver();
	}
}
