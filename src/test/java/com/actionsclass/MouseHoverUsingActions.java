package com.actionsclass;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverUsingActions {

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
		System.out.println("Parent window is "+parentwindow);
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
		driver.findElement(By.xpath("//input[@class='sugInp' and @name='keyword']")).sendKeys("QA");
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//*[@id='sugDrp_qsb-keyword-sugg']//ul/li[3]"));
		Thread.sleep(3000);
		action.moveToElement(ele);
		Thread.sleep(3000);
		action.click(ele).build().perform();

	}

}
