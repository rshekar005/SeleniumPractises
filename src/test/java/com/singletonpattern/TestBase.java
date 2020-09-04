package com.singletonpattern;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author rajasekhar
 *  Singleton Pattern --> It is a class which have only one object(instance of a class) at a time.
 *  
 *  How to achieve?
 *  1. Create a constructor as private
 *  2. Write a static method that has return type of object of this singleton class (Lazy initialization)
 */
public class TestBase {
	
	public static WebDriver driver=null;
	

	
	public static void initialization()
	{//Singleton Pattern
		if(driver==null)
		{
			if(Constants.browserName.equalsIgnoreCase("Chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
			}
			else if(Constants.browserName.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver= new FirefoxDriver();
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constants.url);
	}
	
	public static void quit()
	{
		System.out.println("Quitting the browser");
		driver.quit();
		driver=null;
	}
	

}
