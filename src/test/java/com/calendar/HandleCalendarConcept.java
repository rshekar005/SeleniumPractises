package com.calendar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCalendarConcept {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("username")).sendKeys("batchautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");		
		driver.findElement(By.xpath("//*[@value='Login']")).click();
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//*[text()='Calendar']")).click();
		
		String date1= "31-September-2021";
		String date[]=date1.split("-");
		String day= date[0];
		String month= date[1];
		String year=date[2];
		
		Select select= new Select(driver.findElement(By.name("slctMonth")));
		select.selectByVisibleText(month);
		
		
		Select select1= new Select(driver.findElement(By.name("slctYear")));
		select1.selectByVisibleText(year);
		/*
		 * xpath for a date in this case is:
		 * //*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[6]
		 * 
		 * Here tr[2] at last is row starts from 2
		 * td[6] selecting 6th value in row 2
		 * 
		 * Dynamically above row and col values will change. 
		 * In order to make divided xpath into two parts like webtable example
		 * 
		 * Time complexity is O(n)^2 because of two inner loops
		 * 
		 */
		String beforexpath="//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterxpath="]/td[";
		boolean flag= false;
		final int noOfDaysinWeek=7;
		String dayval = null;
		//here row =2 because row 1 contains day
		for(int row=2;row<=7;row++)
		{
			for(int col=1;col<=noOfDaysinWeek;col++)
			{
				//Written this try catch block becuase sometimes day or month will get mismatch (wrong day)
				//If it is wrong then prints message
				try
				{
					dayval=driver.findElement(By.xpath(beforexpath+row+afterxpath+col +"]")).getText();
				}
				catch(NoSuchElementException e)
				{
					System.out.println(" Please enter correct date value");
					flag=false;
					break;
				}
				
				System.out.println(dayval);
				if(dayval.equals(day))
				{
					driver.findElement(By.xpath(beforexpath+row+afterxpath+col +"]")).click();
					flag=true;
					break;
				}
			}
			if(flag)
			{
				break;
			}
		}

	}
}
