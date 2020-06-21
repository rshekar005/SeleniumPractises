package com.basics;
/**
 * So the main difference between get() and navigate() is, both are performing the same task but with the use of navigate() you can move back() or forward() in your session's history.
navigate() is faster than get() because navigate() does not wait for the page to load fully or completely.
 */
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigateCommands {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  driver= new ChromeDriver();
	  
	  driver.navigate().to("https://www.facebook.com");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//a[text()='Forgotten account?']")).click();
	  driver.navigate().back();
	  Thread.sleep(2000);
	  driver.navigate().forward();
	  Thread.sleep(2000);
	  driver.navigate().refresh();
	  Thread.sleep(2000);
	  driver.close();
	  
	  

	}

}
