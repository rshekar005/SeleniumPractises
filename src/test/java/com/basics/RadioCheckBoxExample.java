package com.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioCheckBoxExample {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		boolean isDisplayed= driver.findElement(By.id("u_0_7")).isDisplayed();
		System.out.println("Male button is displayed :" +isDisplayed);
		
		boolean isEnabled= driver.findElement(By.id("u_0_7")).isEnabled();
		System.out.println("Male button is enabled :" +isEnabled);
		
		boolean isSelected= driver.findElement(By.id("u_0_7")).isSelected();
		System.out.println("Male button is selected :"+isSelected);
		
		System.out.println(" Click on radio button ");
		driver.findElement(By.id("u_0_7")).click();
		
		boolean isSelected2= driver.findElement(By.id("u_0_7")).isSelected();
		System.out.println("Male button is selected :"+isSelected2);
		
		
		

	}

}
