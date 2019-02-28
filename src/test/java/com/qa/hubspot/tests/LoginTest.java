package com.qa.hubspot.tests;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.constants.Constant;
import com.qa.hubspot.pages.LoginPage;




public class LoginTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	//test classes:-->test methods--test cases

	//test case 1:
	//pre condition:open browser,url,un/pwd
	//test steps--test case:loginTEst--un/pwd/loginbtn
	//validations- actual versus expected

	//post step:close the browser



	//test case 2:chk signup link available


	//pre condition:open browser,url,un/pwd
	//test steps--test case:chk signup link on the page
	//validations- actual versus expected
	//post step:close the browser
	
	@BeforeMethod
	public void setUp(){

		basePage=new BasePage();
		driver=basePage.initialize_driver();
		prop=basePage.initialize_Properites();
		driver.get(prop.getProperty("url"));
		loginPage=new LoginPage( driver);
		
		
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest(){

		String title=loginPage.getLoginPage();
		System.out.println("The login page title is: "+title);
		Assert.assertEquals(title, Constant.Login_Page_Title);

	}
	@Test(priority=2)
	public void verifySignUpLinkTest(){

		Assert.assertTrue(loginPage.VerifySignUpLink());

	}
	@Test(priority=3)
	
	public void loginCorrectCredentialsTest(){
		loginPage.login(prop.getProperty("username_app"),prop.getProperty("password_app"));



	}
	
	@AfterMethod//this method is executed after every test method
	public void tearDown(){

		driver.quit();
	}
	

}
