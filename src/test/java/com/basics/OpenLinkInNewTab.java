package com.basics;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenLinkInNewTab {
	
	static WebDriver driver;
	public static void main(String args[])
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		String controlclick= Keys.chord(Keys.CONTROL, Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Advertising']")).sendKeys(controlclick);

		Set<String> windowns=driver.getWindowHandles();

		Iterator<String> itr=windowns.iterator();
				while(itr.hasNext()){
					String childwindow=itr.next();
					System.out.println(driver.switchTo().window(childwindow).getTitle());
				}
	}

}
