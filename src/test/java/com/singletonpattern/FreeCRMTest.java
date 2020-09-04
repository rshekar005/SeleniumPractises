package com.singletonpattern;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FreeCRMTest {
	
	@BeforeClass
	public void setUp()
	{
		TestBase.initialization();
	}
	
	@Test
	public void verifyCRMTitle()
	{
		String title=TestBase.driver.getTitle();
		System.out.println("Title of the page is "+title);
		Assert.assertEquals(title, "CRMPRO  - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test
	public void verifyLogin()
	{
		
	}
	
	@AfterClass
	public void tearDown()
	{
		TestBase.quit();
	}
	
	

}
