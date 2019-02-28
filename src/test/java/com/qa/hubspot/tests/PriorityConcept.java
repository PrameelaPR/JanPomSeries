package com.qa.hubspot.tests;

import org.testng.annotations.Test;

public class PriorityConcept {

	@Test(priority=-1)
	public void aLoginTest(){

		System.out.println("aLogin Test");
		

	}
	@Test(priority=2)
	public void bLoginTest(){

		System.out.println("bLogin Test");
		

	}
	@Test(priority=3)
	public void cLoginTest(){

		System.out.println("cLogin Test");
		

	}
	@Test(priority=-4)
	public void dLoginTest(){

		System.out.println("dLogin Test");
		

	}
	
	
}
