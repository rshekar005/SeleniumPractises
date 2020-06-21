package com.retryfailedtestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Mytests {
	
	/* RetryAnalyser is a class
	 * The name of the class that should be called to test if the testshould be retried.
	 * 
	 * If test is failed then it will retry based on the count which is declared in RetryAnalyser class.
	 * After count then it will fail the test cases.
	 * 
	 * 
	 * Suppose if there is multiple test cases which needs to be run 
	 * then every time we need to write for every retryAnalyzer= RetryAnalyser.class test cases. 
	 * But it is not a good approach.
	 * 
	 * In order to overcome there is a annotation called IAnnotationTransformer is a listner which contains transform().
	 * In that method need to declare RetryAnalyser.class
	 * 
	 * IAnnotationTransformer is a listener it will listen all the failed cases and run all the failed cases based on count and then it fail.
	 * 
	 * This listener need to add in testNG.xml
	 * 
	 * 
	 */
	
	@Test//(retryAnalyzer= RetryAnalyser.class)
	public void test1()
	{
		Assert.assertEquals(true, true);
	}
	
	@Test
	public void test2()
	{
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void test3()
	{
		Assert.assertEquals(true, true);
	}
	
	@Test
	public void test4()
	{
		Assert.assertEquals(false, true);
	}

}
