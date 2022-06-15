package com.calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendar {
	
	static WebDriver driver;
	
	@Test
	public void test1(){
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.id("datepicker")).click();
		
		new WebDriverWait(driver, 20)
			.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar")));
		
		String monthyear=driver.findElement(By.className("ui-datepicker-title")).getText();
		String month= monthyear.split(" ")[0].trim();
		String year= monthyear.split(" ")[1].trim();
		
		while(!(month.equals("June")&& year.equals("2022"))) {
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			monthyear=driver.findElement(By.className("ui-datepicker-title")).getText();
			System.out.println(monthyear);
			month= monthyear.split(" ")[0].trim();
			year= monthyear.split(" ")[1].trim();
		}
		driver.findElement(By.xpath("//a[text()='23']")).click();
	}

}
