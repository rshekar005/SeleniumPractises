package com.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HtmlUnitDriverConcept {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
	//	driver= new ChromeDriver();
		//driver.manage().window().maximize();
		//HtmlUnit driver is not in built class of selenium. Need to download external jar or maven dependencies
		driver = new HtmlUnitDriver();
		
		/*
		 * Advantages
		 * 
		 * 1. Testing will behind the scene. No GUI
		 * 2. Very Fast
		 * 3. not suitable for actions like mousehover, doubleclick , drag and drop
		 * 4. It is called as Ghost Driver , Headless driver
		 *    HtmlUnitDriver -- Java
		 *    PhantomJS      -- JavaScript
		 */
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html");
	
		System.out.println("Before login title is ----" + driver.getTitle());
		driver.findElement(By.name("username")).sendKeys("batchautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");

		driver.findElement(By.xpath("//*[@value='Login']")).click();
		
		System.out.println("After login title is ---- "+ driver.getTitle());
	}

}
