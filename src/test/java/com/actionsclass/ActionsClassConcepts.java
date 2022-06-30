package com.actionsclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Action is an Interface
 * Actions is a class.
 *
 * If we want to perform series of operations then we need to use actions class
 *
 * Example: Input Capital words in field.
 *
 * Then we need to press shift button + characters + release shift button
 *
 * All these are a series of actions we need to perform .
 *
 * build() is from actions class where as perform() is from action interface.
 * Inorder to perform series of action then perform() is compulsory.
 *
 */
public class ActionsClassConcepts {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		/*
		 * build() method in Actions class is use to create chain of action or operation you want to perform.
		 * perform() this method in Actions Class is use to execute chain of action which are build using Action build method.
		 */
		
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
