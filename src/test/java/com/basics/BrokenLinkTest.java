package com.basics;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Links are available in the form of a tag
 * Images are associated with img tag
 * 
 * Broken links/Img  -- If user clicks on a link some times will see 404 error / server error. These are called broken links
 * 
 * What are Broken Links?
Broken links are links or URLs that are not reachable. They may be down or not functioning due to some server error

An URL will always have a status with 2xx which is valid. There are different HTTP status codes which are having different purposes. For an invalid request, HTTP status is 4xx and 5xx.

4xx class of status code is mainly for client side error, and 5xx class of status codes is mainly for the server response error.

We will most likely be unable to confirm if that link is working or not until we click and confirm it.
 * 
 */
public class BrokenLinkTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://classic.crmpro.com/index.html");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("batchautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//*[@value='Login']")).click();
		Thread.sleep(3000);
		driver.switchTo().frame("mainpanel");

		// 1. get the list of links present in page
		List<WebElement> list = driver.findElements(By.tagName("a"));// We get to know the tags with a
		list.addAll(driver.findElements(By.tagName("img"))); // to the list will add image tag as well.

		// size of links and images present in page
		System.out.println("Number of links and images present in a page :" + list.size());

		List<WebElement> activelinks = new ArrayList<WebElement>();
		/**
		 * 
		 */
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAttribute("href") != null) {
				activelinks.add(list.get(i));
				String url = activelinks.get(i).getAttribute("href");
				verifyLinkActive(url);
			}
		}

		// get the size of active links and images
		System.out.println("Number of active links and images :" + activelinks.size());
		
	}

	// Through HttpURLConnection class we get to know the status of href
	public static void verifyLinkActive(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() == 200) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
						+ HttpURLConnection.HTTP_NOT_FOUND);
			}
		} catch (Exception e) {
			
		}
	}

}
