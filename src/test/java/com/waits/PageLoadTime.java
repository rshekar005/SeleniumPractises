package com.waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadTime {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		//pageLoadTimeout. Sets the amount of time to wait for a page load to complete before throwing an error. 
		//If the timeout is negative, page loads can be indefinite.
		//here we defining page to be loaded with in 0 seconds. If page is not loaded with in 0 seconds then it will throw Timeoutexception
		driver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);// CHange 0 to 0+ then it will not thrown any Timeoutexception
		driver.get("https:www.google.com");
		//driver.findElement(By.id("qa")).sendKeys("Hello");
		

	}

}
