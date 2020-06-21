package com.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * SVG stands for Scalable Vector Graphics.
 */
public class SVGElementConcept {

	static WebDriver driver;
	public static void main(String args[])
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("E://Git//SeleniumExercises//SVG.html");
		
		// Normal locator concepts like id, class name , xpaths will not work for svg tags
		// In order to find elements follow below steps
		/*
		 * 1. Point to svg tag using //*[name()='svg'] --> It contains name as a function and svg as a attribute
		 * 2. Use local-name as attribute and it's value
		 *    Example: //*[local-name()='text'] --> if the tag name is text use text as a value if it is div then div etc...
		 * 3. and normal xpath
		 * 
		 * Example of complete svg path is :
		 * 
		 *  //*[name()='svg']//*[local-name()='text' and @id='pointline']
		 */
		
		String name =driver.findElement(By.xpath("(//*[name()='svg']//*[local-name()='text' and @id='pointline'])[1]")).getText();
		System.out.println("Name is "+name);
		
		
	}

}
