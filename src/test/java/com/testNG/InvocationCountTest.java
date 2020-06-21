package com.testNG;

import org.testng.annotations.Test;

/**
 * 
 * @author rajasekhar
 *  If user wants to execute same test case for multiple times then use invocation count
 */
public class InvocationCountTest {
	
	@Test(invocationCount=10) // It means it will exceute 10 times
	public void test1()
	{
		int a=20;
		int b=30;
		int c= a+b;
		System.out.println("Sum is "+c);
	}

}
