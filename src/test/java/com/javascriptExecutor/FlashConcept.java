package com.javascriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlashConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("username")).sendKeys("batchautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");

		//Hightlight on login button
		
		WebElement element= driver.findElement(By.xpath("//*[@value='Login']"));
		flash(element, driver);
	}
		
	//For every element flashing will slow down the code. Use in assertion
	
	public static void flash(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		String bgcolor= element.getCssValue("backgroundColor");// It will get background color of an element
		System.out.println(" Back ground color of element is "+bgcolor);
		
		//Background color of element will flash upto 100 times
		for(int i=0;i<100;i++)
		{
			changeColor("rgb(0,200,0)", element, driver); //1
			changeColor(bgcolor, element, driver); //2
		}
		
	}
	
	//Change color method
	public static void changeColor(String color, WebElement element, WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor = '" +color+"'" , element);
		
	}

}
