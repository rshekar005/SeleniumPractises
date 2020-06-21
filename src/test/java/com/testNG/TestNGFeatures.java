package com.testNG;

import org.testng.annotations.Test;

public class TestNGFeatures {
	
	
	@Test()
	public void login()
	{
		System.out.println("Login Page");
		//int i=9/0;
	}
	/**
	 *  Depends on Method Feature:
	 *  
	 *  Before running this test it will check for login() executed or not. 
	 *  If not then login() method will execute
	 *  If login Failed then dashboard test will not execute
	 */
	@Test(dependsOnMethods="login")
	public void dashboard()
	{
		System.out.println("Dashboard and it is depends on Login");
	}

}
