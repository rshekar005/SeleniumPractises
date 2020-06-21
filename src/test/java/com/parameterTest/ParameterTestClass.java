package com.parameterTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author rajasekhar
 * Using Parameterization is to maintain environmental varibale. 
 * We can use parameter concept or load from text file using Properties class
 * 
 * Suppose if we use login details in script. every time need to change the class. Instead we can use above concept.
 */
public class ParameterTestClass {
	
	WebDriver driver;
	@Test
	@Parameters({"browser","url","email"})
	public void test(String browser,String url, String email)
	{
		if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else
		{
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Gmail']")).click();
		
		//WebElement ele= driver.findElement(By.xpath("(//a[@ga-event-action='sign in'])[1]"));
		By element= By.xpath("(//a[@ga-event-action='sign in'])[2]");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
		driver.findElement(element).click();
		
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		
	}

}
