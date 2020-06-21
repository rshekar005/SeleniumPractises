package com.dataprovider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderConcept {
	
	static WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--incognito");
		driver= new ChromeDriver(options);
		driver.get("https://reg.ebay.in/reg/PartialReg");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	/*
	 * If we get org.testng.internal.reflect.MethodMatcherException: 
	 *  Data provider mismatch error then 
	 *  1. we have passed wrong arguments which not matching(count) with test class and data provider.
	 *     Suppose if data provider providing 5 parameters then in test we are using less/greater than will get above error
	 *  2. If using String as a parameter but test declared with int then also will above error
	 *  3. In Util class if declared only object but in data provider accepting array of object then above error will occur
	 *     
	 *     
	 *     Final Solution for this issue is data from excel, data provider and test class argument should match same.
	 */
	@DataProvider(name="getData")
	public Iterator<Object[]> getTestData() throws IOException
	{
		ArrayList<Object[]> testData=TestUtil.getDatafromExcel();
		return testData.iterator();
	}
	
	
	@Test(dataProvider="getData")
	public void enterDetails(String firstname, String lastname, String email, String password) throws InterruptedException
	{
		driver.findElement(By.name("firstname")).sendKeys(firstname);;
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("PASSWORD")).sendKeys(password);
		
		
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
