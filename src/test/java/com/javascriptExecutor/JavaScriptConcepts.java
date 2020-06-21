package com.javascriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptConcepts {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("username")).sendKeys("batchautomation");
		driver.findElement(By.name("password")).sendKeys("Test@123451");

		WebElement element= driver.findElement(By.xpath("//*[@value='Login']"));
		WebElement forgotpassword= driver.findElement(By.xpath("//*[contains(text(),'Forgot Password?')]"));
	/*	drawBorder(element, driver);
		clickElementByJS(element, driver);
		//generateAlert(driver, "Login Button");
*/	
		Thread.sleep(2000);
		//refresh(driver);
		getTitleJS(driver);
		//pageScrollDown(driver);
		scrollIntoView(forgotpassword, driver);
		highlight(forgotpassword);
		
		//System.out.println(getPageText(driver));
		}
	
	public static void drawBorder(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	//This is Javascript alerts
	public static void generateAlert(WebDriver driver, String message)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickElementByJS(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	public static void refresh(WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	
	public static void getTitleJS(WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		String title=js.executeScript("return document.title;").toString();
		System.out.println("Title is "+title);
	}
	
	//It will get pageText
	public static String getPageText(WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		 String pageText=js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	
	public static void pageScrollDown(WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)" );
	}
	
	public static void scrollIntoView(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public static void highlight(WebElement element)
	  {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='3px dotted green'", element);
	  }

}
