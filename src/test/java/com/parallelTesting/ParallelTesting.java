package com.parallelTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author rajasekhar
 *  -- It helps to execute test cases in parallel there we can save time.
 *  -- crosswbrowser testing can be done because of this we can make application more stable.
 *  -- we can cover number of tests.
 * 
 *  The parallel attribute of suite tag can accept four values:

    tests	All the test cases inside <test> tag of Testing xml file will run parallel.
    classes	All the test cases inside a Java class will run parallel
    methods	All the methods with @Test annotation will execute parallel.
   instances	Test cases in same instance will execute parallel but two methods of two different instances will run in different thread.
 *  
 */

public class ParallelTesting {

	//@BeforeMethod
	public void setUp()
	{
		
	}
	
	@Test
	public void test1() throws InterruptedException
	{
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Title is "+driver.getTitle());
		Thread.sleep(2000);
		driver.close();
	
	}
	@Test
	public void test2() throws InterruptedException
	{
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Title is "+driver.getTitle());
		Thread.sleep(2000);
		driver.close();
	}
	@Test
	public void test3() throws InterruptedException
	{
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Title is "+driver.getTitle());
		Thread.sleep(2000);
		driver.close();
	}
	
	//@AfterMethod
	public void tearDown()
	{
		//driver.close();
	}
}
