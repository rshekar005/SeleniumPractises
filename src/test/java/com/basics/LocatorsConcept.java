package com.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		
		//Immedaite after tag is called tag name
		//What ever we see in page is called web element
		//After tag name is called properties like id, class, etc
		// After tag name > Text <tagclose>
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Link Text
		//driver.findElement(By.linkText("Selenium Jobs")).click();
		
		//Partial link text
		driver.findElement(By.partialLinkText("Selenium")).click();
	
		//Name
		driver.findElement(By.name("username")).sendKeys("batchautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		
		//class
		driver.findElement(By.className("btn btn-small")).click();
		
		
		
		

	}

}
