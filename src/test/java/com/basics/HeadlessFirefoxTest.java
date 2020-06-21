package com.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessFirefoxTest {

	static WebDriver driver;
	public static void main(String[] args) {
		
		FirefoxBinary binary = new FirefoxBinary();
		binary.addCommandLineOptions("--headless");
		
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary(binary);
		
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver(options);
		
		driver.get("https://www.google.com");
		
		System.out.println("Title is "+driver.getTitle());
		

	}

}
