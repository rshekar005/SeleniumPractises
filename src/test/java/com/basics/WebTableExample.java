package com.basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableExample 
{
	public static void main(String args[]) throws InterruptedException 
	{
		WebDriver dr;
		WebDriverManager.chromedriver().setup();
		dr = new ChromeDriver();
		dr.get("http://in.rediff.com/");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		dr.findElement(By.xpath("//a[@href='http://money.rediff.com']")).click();
		dr.findElement(By.xpath("//a[@href='//money.rediff.com/gainers/bse/daily/groupa']")).click();
		
/*		int columns = dr.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]")).size();
		int rows = dr.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]")).size();*/
		
	    WebElement parent= dr.findElement(By.xpath("//table[@class='dataTable']/tbody"));
	    List<WebElement> rows= parent.findElements(By.tagName("tr"));
	    System.out.println("Number of rows are : " +rows.size());
	    
	    List<WebElement> columns = rows.get(1).findElements(By.tagName("td"));
	    System.out.println("Number of columns are : "+columns.size());
		
		
		List<WebElement> names = dr.findElements(By.xpath("//table[@class='dataTale']/tbody/tr/td[1]")); //It will load all company names
		List<WebElement> prices = dr.findElements(By.xpath("//table[@class='dataTale']/tbody/tr/td[4]")); //It will load all prices
	    System.out.println("Total Names :"+names.size());
	    System.out.println("Total Prices :"+prices.size());
	}

}

