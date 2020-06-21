package com.calendar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectCalendarByJS {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element=driver.findElement(By.id("ctl00_mainContent_view_date1"));
		String date="30/06";
		selectDatebyJS(driver, element, date);
	}
	
	public static void selectDatebyJS(WebDriver driver,WebElement element,String date)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
			//Why we are using value in JS because date set value attribute in DOB. because of this we are changing directly that value date.
			//Refer DOM for reference
			js.executeScript("arguments[0].setAttribute('value', '"+date+"');", element);
		
	}
		

}
