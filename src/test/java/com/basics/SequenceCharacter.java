package com.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SequenceCharacter {

	static WebDriver driver;
	public static void main(String args[])
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://classic.crmpro.com/index.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement ele= driver.findElement(By.name("username"));
		
		//1. Using string
		String name=" ";
		
		// Using StringBuilder
		StringBuilder username1= new StringBuilder();
		username1.append("Naveen")
				.append(" ")
				.append(" Automation")
				.append(" ")
				.append("labs");
		ele.sendKeys(username1);
		
		//Using StringBuffer
		StringBuffer username2= new StringBuffer();
		username2.append("I am")
				.append(" ")
				.append(" Learning ")
				.append(" ")
				.append("Selenium");
		
		ele.sendKeys(username1, username2 , name , Keys.TAB); // It means sendkeys allow sequence characters in a text field
		
	}

}
