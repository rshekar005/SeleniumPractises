package com.retryfailedtestcases;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/*
 * This class will remove repeated code which is written for @Test method. Need to write about the listner in testng.xml file
 */
public class MyTransformer implements IAnnotationTransformer{

	//transform() is an unimplemented method for IAnnotationTransformer
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyser.class);
	}

}
