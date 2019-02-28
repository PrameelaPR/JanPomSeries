package com.qa.hubspot.tests;

import org.testng.annotations.Test;

public class DependsOnMethodConcept {
	
	@Test
	public void LoginTest(){

		System.out.println("Login Test");
		//int i=9/0;

	}
	@Test(priority =2, dependsOnMethods="LoginTest")
	public void clickOnContactsTest(){

		System.out.println("clickOnContactsTestTest");

	}

}
