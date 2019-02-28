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
import com.qa.hubspot.pages.ProfileAndPreferencePage;

public class ProfileAndPreferenceTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	ProfileAndPreferencePage profileandPref;
	
	
	@BeforeMethod
	public void setUp(){

		basePage=new BasePage();
		driver=basePage.initialize_driver();
			prop=basePage.initialize_Properites();
		driver.get(prop.getProperty("url"));
		loginPage=new LoginPage( driver);
		homePage=loginPage.login(prop.getProperty("username_app"),prop.getProperty("password_app"));
		//profileandPref=new ProfileAndPreferencePage(driver);
		profileandPref=homePage.navigateToProfilePreference();

	}
	@Test
	public void verifyHomePageTitleTest(){
		String title=profileandPref.getUserPrefTitle();
		Assert.assertEquals(title,Constant.User_Pref_Title);

	}

	@Test

	public void verifyUserPrefPageHeader(){

		Assert.assertTrue(profileandPref.verifyUserPrefPageHeader());
		String userPrefPageHeader=profileandPref.getUserPrefTitle();
		System.out.println("The header is: "+userPrefPageHeader);
		Assert.assertEquals(userPrefPageHeader,Constant.User_Pref_Header);

	}
	
	@AfterMethod//this method is executed after every test method
	public void tearDown(){

		driver.quit();
	}
	
	
}
