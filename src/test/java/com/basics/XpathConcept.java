 package com.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://guru99.com");
		
		driver.manage().window().maximize();
		
		//Syntax : //tagName[@attribute="attributevalue"]
				
		/*Absolute XPath:
		*It is the direct way to find the element, but the disadvantage of the absolute XPath is that 
		*if there are any changes made in the path of the element then that XPath gets failed.
		*
		*Ex:html/body/div[1]/section/div[1]/div/div/div/div[1]/div/div/div/div/div[3]/div[1]/div/h4[1]/b
		*
		*Contains '/' --> Single slash
		*/
		
		/*
		 * Relative xpath:For Relative Xpath the path starts from the middle of the HTML DOM structure. 
		 * It starts with the double forward slash (//), 
		 * which means it can search the element anywhere at the webpage.
		 * 
		 * Without knowing parent node we can directly switch to child node.It means it doesnot depend on parent node
		 * 
		 * Example: //*[@class='featured-box']//*[text()='Testing']
		 */
		
		
		//Basic xpaths
        //driver.findElement(By.xpath("//input[@name='username']")).sendKeys("batchautomation");;	
		
		/*xpath with and and or
		driver.findElement(By.xpath("//input[@name='password' and @type='password']")).sendKeys("Test@12345");
		//input[@name='password' or @type='password']
		*/
		
		
		/*  text() function in xpath
		 * xpath with text. Here text is a function we cannot use @ annotation for attribute
	    driver.findElement(By.xpath("//a[text()='Features']")).click();
	    */
		
		/*  Contains Keyword
		 * xpath with contains. Above one can short list with Features as Featu
		 * We cannot use @ with = operator in contains xpath
		driver.findElement(By.xpath("//a[contains(text(),'Featur')]")); 
			a[contains(@id,'xyz')];
			a[contains(text(),'xyz')] 
		*/
		
		
		/* XPath axes methods
		 * 
		 *  1. Following:
		 *     Example: Xpath=//*[@type='text']//following::input --> Here it point to next input value
		 *  2. Ancestor : The ancestor axis selects all ancestors element (grandparent, parent, etc.) of the current node(Enterprise Testing)
		 *     Expample; //*[text()='Enterprise Testing']//ancestor::div
		 *  3. Child : It will find the all child xpaths of current node (Java_technologies) is the current node and it contains child nodes
		 *     Example: //*[@id='java_technologies']//child::li
		 *  4. Preceding: Select all nodes that come before the current node (submit)
		 *     Example: //*[@type='submit']//preceding::input --> Here it will point to username and password
		 *  5. Following-sibling: Select the following siblings of the context node. Siblings are at the same level of the current node
		 *     Example: //*[@name='username']//following-sibling::input  --> Here it will point to password which has same type
		 */
		
	
		/* starts-with functions
		 * 
		 * In this expression, match the starting text of the attribute is used to find the element whose attribute changes dynamically. 
		 * You can also find the element whose attribute value is static (not changes).
		 * 
		 * Example: //*[starts-with(@id,'xyz')]
		 * 
		 * 
		 */

		
		

	}

}
