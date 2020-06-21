package com.testNG;

import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

public class ExceptionTimeOutTest {
	
	/**
	 * 1. Here it is milliseconds (2000) means 2 seconds. After that it will throw exception. 
	 * 2. I am expecting ThreadTimeoutException. SO it will not mark the test case as fail. 
	 *    Even it is fail it will show pass because we are expecting exception
	 */
	@Test(invocationTimeOut=2000,expectedExceptions=ThreadTimeoutException.class) 
	public void infiniteTest()
	{
		int i=1;
		while(i==1) // it will execute infinte times because there is no check like increasing i value.
		{
			System.out.println(i);
		}
	}

}
