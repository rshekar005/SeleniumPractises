package com.fileupload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadUsingRobotClass {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.monsterindia.com/seeker/registration?");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,400)");
		driver.findElement(By.xpath("//span[text()='Choose file']")).click();
		//1 st way but sometimes will get element not interactable exceptions in that case use second way
		driver.findElement(By.xpath("//span[text()='Choose file']")).sendKeys("C:\\Users\\rajasekhar\\Documents\\sel.docx");
		Thread.sleep(3000);
		//2nd way
		// Find the path
		// StringSelection is a class that can be used for copy and paste
		// operations.
		/*Step 1- We have to copy the file location in system clipboard.
		Step 2- We have to click on upload button and use CTR+V and ENTER.*/
		StringSelection sel = new StringSelection("C:\\Users\\rajasekhar\\Documents\\sel.docx");
		// copying to keyboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		System.out.println("Selections " + sel);
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
