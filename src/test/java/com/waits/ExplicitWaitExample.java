package com.waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/*
 * Why wait is required
1-Now a day many applications are using AJAX control, Jquery and many other complex widgets which make application slow and data takes some time to appear on screen so we need to wait until data is not present on UI.

2-When you perform the complex operation on any application it also takes some time for processing and we have to make sure our script should wait until specific conditions are not true.
 */
// Explicit wait is one of the dynamic waits
// Explicit wait will wait for a single element with the help of ExpectedConditions class which is implemented by WebDriverWait class
// By default it will wait in seconds
// It wait for a element for a specific conditions. 
/*
 *     Implicit Waits                                      Explicit wait
 *  1. It will wait whether element present or not         It has multiple specific conditions
 *     Only one condition. We cannot specify a 
 *     condition.
 * 	2. We can handle ‘Findelement’ and ‘Findelements’      We can handle any condition
 *  3. After duration it will throw "NoSuchElementExc.."   It will throw TimeOutException
 *     if timeouts
 *  4. We can declare time duration in seconds, hours, etc.. But in Explicit wait by default it is seconds (only seconds)   
 */
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitExample {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// below timeout wait for a page to load upto 10 seconds if not found
		// then it will throw timeout exception
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html");
		// below timeout will wait for all webelements present in a DOM upto 10
		// sec. It will apply for all web elements.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("username")).sendKeys("batchautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");

		driver.findElement(By.xpath("//*[@value='Login']")).click();
		driver.switchTo().frame("mainpanel");

		WebElement ele = driver.findElement(By.xpath("(//*[@class='topnavlink'])[3]"));
		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Using Explicit waits we can use different types of conditions which
		// present in ExpectedConditions class
		// But in implicit wait it will wait only whether element present or not
		// then it will throw NoSuchElementException
		// In Explicit wait if condition is fails then it will throw
		// TimeOutException
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();

	}

}
