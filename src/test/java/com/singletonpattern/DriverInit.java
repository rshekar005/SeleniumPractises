package com.singletonpattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author rajasekhar
 *  Singleton Pattern --> It is a class which have only one object(instance of a class) at a time.
 *  
 *  How to achieve?
 *  1. Create a constructor as private
 *  2. Write a static method that has return type of object of this singleton class (Lazy initialization)
 *  3.Keep track of same driver instance throughout execution.
 *  
 *  
 * Difference between Normal class and Singleton
 *  In Normal class we have a constructor but in singleton we use getInstance() for initialization
 */
public class DriverInit {
	
	public static DriverInit instanceDriver=null;
	private WebDriver driver;
	
	private DriverInit()
	{
		
	}
	
	public static DriverInit getInstance()
	{
		if(instanceDriver==null)
		{
			instanceDriver= new DriverInit();
		}
		return instanceDriver;
	}
	public WebDriver openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		return driver;	
	}

}
