package com.waits;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Fluent wait is a class it implements Wait interface
 * 
 * When you want fluent
 * apply wait on specific element
 * set max time period
 * set polling frequency
 * set to ignore specific exceptions
 */
public class FluentWaitExample {

	static WebDriver driver;
	public static void main(String[] args) throws AWTException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Step by Step Automation");
		
		//It will elementinteractable exception because this element is overriden with other element.
		// In fluent i am expecting error as "ElementNotInteractableException" so it won't throw an error
		// Waiting 30 seconds for an element to be present on the page, checking
		   // for its presence once every 5 seconds.
	  @SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(30, TimeUnit.SECONDS)
		       .pollingEvery(5, TimeUnit.SECONDS)
		       .ignoring(ElementNotInteractableException.class);

		   WebElement element = wait.until(new Function<WebDriver, WebElement>() 
		   {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.name("btnK"));
		     }
		   });
		   
		   element.click();
		 
		 
		

	}

}
