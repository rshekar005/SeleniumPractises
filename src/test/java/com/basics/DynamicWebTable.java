package com.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTable {

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
		driver.findElement(By.xpath("//*[contains(text(),'Contacts')]")).click();
		
		//*[@id="vContactsForm"]/table/tbody/tr[6]/td[1]/input
		
		String beforexpath="//*[@id='vContactsForm']/table/tbody/tr[";
		String afterxpath= "]/td[2]/a";
		
		//Method 1: Here Several iterations are done to select required weblement
		/*for(int i=4;i<=24;i++)
		{
			String name= driver.findElement(By.xpath(beforexpath+i+afterxpath)).getText();
			
			System.out.println(name);
			if(name.contains("ajay verma"))
			{
				driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr["+i+"]/td[1]/input")).click();
			}
		}*/
		
		//Method 2 customized xpath
		//Here first Navigated text which contains checkbox then parent of text. 
		//Then followed preceding-sibling concept(elder --before)
		//Then followed by check box
		driver.findElement(By.xpath("//a[contains(text(),'ajay verma')]"
				+ "//parent::td"
				+ "//preceding-sibling::td"
				+ "//input[@name='contact_id']")).click();

	}

}
