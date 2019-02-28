package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.constants.Constant;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

public class HomeTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setUp(){

		basePage=new BasePage();
		driver=basePage.initialize_driver();
		prop=basePage.initialize_Properites();
		driver.get(prop.getProperty("url"));
		loginPage=new LoginPage( driver);
		homePage=loginPage.login(prop.getProperty("username_app"),prop.getProperty("password_app"));

	}

	@Test
	public void verifyHomePageTitleTest(){
		String title=homePage.getHomePageTitle();
		Assert.assertEquals(title,Constant.Home_Page_Title);

	}

	@Test(enabled=false)
	public void verifyDealsLinkTest(){

		Assert.assertEquals(true,false);

	}
	
	@Test


	public void verifyHomePageHeaderTest(){

		Assert.assertTrue(homePage.verifyHomePageHeader());
		String homePageHeader=homePage.getHomePageHeaderText();
		System.out.println("Home page header is: "+homePageHeader);
		Assert.assertEquals(homePageHeader,Constant.Home_Page_Header);

	}

	@Test
	public void navigateToContactsPageTest(){


		homePage.navigateToContactsPage();
		String currentURL=homePage.getCurrentURL();
		Assert.assertEquals(currentURL, Constant.Contact_Link_Landing_URL);


	}
	
	@Test
	public void navigateToProfilePreferenceTest(){


		homePage.navigateToProfilePreference();
		String currentURL=homePage.getCurrentURL();
		Assert.assertEquals(currentURL, Constant.ProfileAndPreference_Link_Landing_URL);


	}


	@AfterMethod//this method is executed after every test method
	public void tearDown(){

		driver.quit();
	}



}
