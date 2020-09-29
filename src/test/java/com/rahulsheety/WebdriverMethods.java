package com.rahulsheety;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverMethods {
	
	static WebDriver driver;
	public static void main(String args[])
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("Title of the page is "+driver.getTitle());
		System.out.println("Current URL is "+driver.getCurrentUrl());
		/*System.out.println("Page source is "+driver.getPageSource());*/
		
		driver.get("https://www.yahoo.com");
		System.out.println("Title of the page is "+driver.getTitle());
		System.out.println("Current URL is "+driver.getCurrentUrl());
		driver.navigate().back();
		driver.close();//It closes current browser
		driver.quit();//It will close all the browsers which are opened by webdriver.
		
	}

}
