package com.basics;
import java.util.List;
/**
 * Drop down which are named with the tagname select i.e drop downs are listed based on UI, LI etc then those drop downs are called bootsrap downs
 * 1. Click on drop down menu
 * 2. Drop down values will have all ui or li tags
 * 3. Find out all the li tags and add to List
 * 4. From list use required value
 */
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapdropdown {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/bootstrap/bootstrap_dropdowns.asp");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Click on drop down menu
		driver.findElement(By.id("menu1")).click();
		Thread.sleep(3000);
		//2. Drop down values will have all ui or li tags
		//3. Find out all the li tags and add to List
		List<WebElement> ele= driver.findElements(By.xpath("//*[@role='menu' and @aria-labelledby='menu1']//li/a"));
		System.out.println("List is ");
		for(int i=0;i<ele.size();i++)
		{
			
			System.out.println(ele.get(i).getText());
			//From list use required value and perform required actions
			if(ele.get(i).getText().contains("JavaScript"))
			{
				ele.get(i).click();
				break;
			}
		}
		
		

	}

}
