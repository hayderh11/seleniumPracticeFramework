package day10_Frameworkdesign;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import pages.IndeedPage;
import utils.DataReader;
import utils.Driver;

public class JsExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		IndeedPage indeedPage = new IndeedPage();
		BrowserUtilsDemo utils = new BrowserUtilsDemo();
		
		Driver.getDriver().get(DataReader.getProperty("indeedUrl"));
		indeedPage.whatfield.sendKeys("SDET");
		utils.highlightElement(indeedPage.whatfield);
		indeedPage.searchBtn.click();
		Thread.sleep(1000);
		
		utils.scrollDownByPixels(1500);
		
	}

}
