package com.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaunchBrowser {

	static WebDriver driver;
	public static void main(String[] args) {
		
		//Chrome browser launch
		System.setProperty("webdriver.chrome.driver","E://Git//SeleniumExercises//Drivers//chromedriver.exe");
		driver= new ChromeDriver();
		
		//Firefox driver launch
		/*System.setProperty("webdriver.gecko.driver", "E://Git//SeleniumExercises//Drivers//geckodriver.exe");
		driver= new FirefoxDriver();*/
		
		/*System.setProperty("webdriver.ie.driver", "E://Git//SeleniumExercises//Drivers//IEDriverServer.exe");
		driver= new InternetExplorerDriver();*/
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		
		String title = driver.getTitle();
		System.out.println("Title is "+title);
		
		if(title.equals("Google"))
		{
			System.out.println("Test case pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		//Resize the browser
		Dimension d= new Dimension(200, 200);
		driver.manage().window().setSize(d);
		
		//Change the position of the browser like middle, left, right based on the point position
		Point p = new Point(300, 400);
		driver.manage().window().setPosition(p);
		
		//It will maximize the position
		driver.manage().window().maximize();
		
		driver.close();
		
	}

}
