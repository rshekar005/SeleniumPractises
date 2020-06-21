package com.testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertionConcept 
{
	static WebDriver driver;
	
	@BeforeTest
	public void initialize()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void test1()
	{
		
		
		String actual = driver.getTitle();
		
		/*Hard Assert -- If condition is not matched then it will throw an exception 
		                 remaining lines of code which are next to assert will not execute.
		                 It will execute to next test cases.
		                 
		                 Here test1 will get failed and test 2 will get execute
		  */
		
		Assert.assertEquals(actual, "Facebook");
		
		System.out.println(" Next Line ");
	}
	
	@Test
	public void test2()
	{
		System.out.println(" Test 2 ");
	}
	
	@Test
	public void test3()
	{
		String actual = driver.getTitle();
		
		/*
		 * Softassert is a class.
		 * If we use softassert , if softassert fails then it will execute next line of code unlike hardassert.
		 * 
		 * softassert.assertAll() --> it will capture all the assertions which are thrown by softassert and thrown at last.
		 * 
		 */
		SoftAssert softassert= new SoftAssert();
		softassert.assertEquals(actual, "Facebook");
		
		System.out.println("This statement executed even software assert fails");
		
		boolean b= false;
		softassert.assertTrue(b);
		
		System.out.println("Boolean condition");
		
		//Below assert will collect all the assertion and throws after all tests
		softassert.assertAll();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	

}
