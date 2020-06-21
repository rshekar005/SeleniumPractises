package com.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author rajasekhar
 *  
 *  StatelementReferenceException means our script is checking for old element, element is not present in DOM. 
 *  May be it DOM got refreshed then old id got changed then this exception will occurs
 *  
 *  To get experience on this put a debugger for username or any element.
 *  Run prgram in debug mode.
 *  After reaching element ex: username , mouse hover on the element there u can find an id for that element.
 *  Then do browser page refresh and run program.
 *  We will get stalelememtreferenceexception becuase previous id got changed with new id.
 *  If the page got refreshed then old id will replace with new id.
 *  In order to avoid this exception make sure that in middle of the execution page should not refreshed.
 *  If refreshed then put try catch exception handle exception and run the program.
 */
public class StaleElementException {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		driver.get("https://classic.crmpro.com/index.html");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		WebElement username=driver.findElement(By.name("username"));
		username.sendKeys("batchautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");

		
		driver.findElement(By.xpath("//*[@value='Login']")).click();
		
	

	}

}
