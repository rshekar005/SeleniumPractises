package com.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClassConcepts {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		
		
	/*	 MovetoELemant method in actions
	 * driver.get("https://spicejet.com");
		
		
		action.moveToElement(driver.findElement(By.id("highlight-addons"))).build().perform();
		Thread.sleep(5000);*/
		//driver.findElement(By.xpath("//*[text()='MyFlexiPlan']")).click();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // It is for page
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); // It is for webelement
		//driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.id("draggable"));
		
		/* 1stway */
		action.dragAndDrop(driver.findElement(By.id("draggable")), 
				driver.findElement(By.id("droppable"))).build().perform();
			
		//2nd way using x and y cordinates
		/*action.dragAndDropBy(drag, 250, 100).build().perform();
		System.out.println("******");*/
		

	}

}
