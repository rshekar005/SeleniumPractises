package com.flashobject;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Youtube {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, FindFailed {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.youtube.com/watch?v=OtQAMoXYqes&list=PLFGoYjJG_fqo4oVsa6l_V-_7-tzBnlulT&index=22");
		Thread.sleep(5000);
		//create an screen object from Sikuli API
		Screen s= new Screen();
		String filepath="C:\\Users\\rajasekhar\\Documents\\";
		//pause 
		Pattern pause= new Pattern(filepath+"youtube_pause.png");
		s.wait(pause,2000);
		s.click();
		
		Pattern settings= new Pattern(filepath+"youtube_settings.png");
		s.wait(settings,3000);
		s.click();
		
		

	}

}
