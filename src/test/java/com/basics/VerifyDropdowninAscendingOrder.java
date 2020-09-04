package com.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyDropdowninAscendingOrder {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element=driver.findElement(By.id("month"));
		
		Select select = new Select(element);
		List actual = new ArrayList();
		List<WebElement> list =select.getOptions();
		
		for(WebElement el: list)
		{
			//Here adding all list text to actual list
			String data= el.getText();
			actual.add(data);
		}
		
		List temp = new ArrayList();
		temp.addAll(actual);
		
		//Ascending
		Collections.sort(temp);
		
	//	Assert.assertTrue(actual.equals(temp));
		
		if(actual.equals(temp))
		{
			System.out.println("Arranged in ascending order");
		}
		else
		{
			System.out.println(" It is not in ascending order ");
		}
		
		
		
	}

}
