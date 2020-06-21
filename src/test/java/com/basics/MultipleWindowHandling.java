package com.basics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindowHandling {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// Using Chromeoptions we can handle browser notifications and we can
		// open in incognito
		ChromeOptions options = new ChromeOptions();

		// Open browser in incognito mode
		options.addArguments("--incognito");

		// Disablig browser notifications
		options.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		driver.get("https://www.naukri.com");

		// Handling multiple window
		String parentwindow = driver.getWindowHandle();
		System.out.println("Parent window is "+parentwindow.toString());
		Set<String> multiplewindow = driver.getWindowHandles();
		int noOfWindows = multiplewindow.size();
		System.out.println("Number of child windows " + noOfWindows);
		Iterator<String> itr = multiplewindow.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next();

			if (!parentwindow.equals(childwindow)) {
				System.out.println(driver.switchTo().window(childwindow).getTitle());
				driver.close();
			}
			driver.switchTo().window(parentwindow);

		}
	}

}
