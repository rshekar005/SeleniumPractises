package com.testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *  This class contains priority , grouping and DependsonMethods concept
 */
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {
	
	static WebDriver driver;
	@BeforeMethod // This method will run before every test method 
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test(priority=1, groups="Title")
	public void test1()
	{
		String title= driver.getTitle();
		System.out.println(driver.getTitle());
		Assert.assertEquals(title, "Google");  // Expecting wrong title. Here it will fail
	}
	
	@Test(priority=2,dependsOnMethods="test1", groups="Gmail") // Used DependsOnMethod of test1 . If test1 fails then test2 will get skipped. If it is pass then test2 will get execute
	public void test2()
	{
		String gmail= driver.findElement(By.xpath("//*[text()='Gmail']")).getText();
		System.out.println(gmail);
	}
	
	@Test(priority=3, groups="Logo")
	public void test3()
	{
		boolean b = driver.findElement(By.id("hplogo")).isDisplayed();
		Assert.assertSame(b, true);
	}
	
	@Test(priority=4, groups="Test")
	public void test4()
	{
		System.out.println("Test 4");
	}
	
	@Test(priority=5,groups="Test")
	public void test5()
	{
		System.out.println("Test 5");
	}
	
	@Test(priority=6,groups="Test")
	public void test6()
	{
		System.out.println("Test 6");
	}
	
	@Test(priority=7,groups="Test")
	public void test7()
	{
		System.out.println("Test 7");
	}
	
	
	@AfterMethod // This will execute every after test
	public void tearDown()
	{
		driver.close();
	}

}
