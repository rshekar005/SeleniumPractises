package com.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBasicAuthentication {
	
	static WebDriver driver;
	public static void main(String args[])
	{	
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		// Actual Url :https://the-internet.herokuapp.com/basic_auth
		
		// Need to pass admin and password in url itself because we cannot find elements in pop up
		
		// After https: need to add username:password @ followed by url
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth"); // It will directly to go dashboard after login
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String text = driver.findElement(By.cssSelector("p")).getText();
		System.out.println(text);
		
	}
	

}
