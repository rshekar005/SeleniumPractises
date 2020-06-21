package com.basics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownloadConcept {

	static File folder;
	static WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		File f= new File(System.setProperty("user.dir", "/Download/"+UUID.randomUUID().toString()));
		System.out.println(f.getAbsolutePath());
		
		ChromeOptions options = new ChromeOptions();
		
		Map<String, Object> prefs= new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.prompt_for_download", false);
	   // prefs.put("download.default_directory", f.getAbsoluteFile());
		
		options.setExperimentalOption("prefs", prefs);
		
	/*	DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY, options);*/
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		
	}
	
	
	@Test
	public void test() throws InterruptedException, AWTException
	{
		
		driver.get("https://the-internet.herokuapp.com/download");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()='some-file.txt']")).click();	
		Thread.sleep(3000);
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	//This method is used to delete the list of file as well as folder.
	@AfterMethod
	public void tearDown()
	{
		
		driver.quit();
		
	}

}
