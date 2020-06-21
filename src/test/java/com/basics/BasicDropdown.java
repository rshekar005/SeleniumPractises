package com.basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicDropdown {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element=driver.findElement(By.id("month"));
		
		//Select class will display as a tag if it is not bootstrap down.
		// Select is a class in selenium which accepts Webelement as argument
		Select select= new Select(element);
		//Methods is select class
		//select.selectByIndex(10);//It will select based on index
		//select.selectByValue("5"); //It will selected based on the value
		//select.selectByVisibleText("Jan");
		
		System.out.println(select.getFirstSelectedOption().getText());// This method will print the selected value from drop down
		//select.deselectByIndex(6);// It will throw Exception in thread "main" java.lang.UnsupportedOperationException: You may only deselect options of a multi-select
		//because here only one element is selected by default if it contains more than 1 then we can use above function. Same for deselectAll()
		
		List<WebElement> list= select.getOptions(); // getOptions() is a method in select class which is used to get list of all options
		for(int i=0; i<list.size(); i++)
		{
			System.out.println(list.get(i).getText());
		}
		
		
		
		
		
	}

}
