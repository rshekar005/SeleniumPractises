package com.waits;
//Implicit waits
		/*
		 * Implicit for all elements present in a DOM is a specified time
		 * 
		 * syntax: driver.manage().timeout.implicitwait(10, TimeUnit.SECONDS);
		 * 
		 * from above syntax driver will wait upto 10 seconds for an element present in DOM.
		 * After 10 seconds if the element is not found then it will throw NoSuchElementException
		 * 
		 * It will apply for all elements present in a DOM
		 * 
		 * Usually implicitwait are written immedaiate after browser launch. 
		 * 
		 * It is applicable for all the element after initialization.
		 * 
		 * It will wait only weblelement ot web element not for all condtions
		 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https:www.google.com");
		//driver.findElement(By.id("qa")).sendKeys("Hello");//Here it will throw immediate NoSuchElementException exception even if we given correct xpath,id,class etc  because still DOM is not loaded completely.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("Hello");
		driver.findElement(By.id("qa")).sendKeys("Hello");// It will wait upto 10 seconds and throws error message because there is no id with the qa value
	
		
	}

}
