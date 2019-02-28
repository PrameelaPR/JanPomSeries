package com.qa.hubspot.tests;

import java.util.Properties;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.constants.Constant;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.TestUtil;

public class ContactTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	
	@BeforeMethod
	public void setUp(){

		basePage=new BasePage();
		driver=basePage.initialize_driver();
		prop=basePage.initialize_Properites();
		driver.get(prop.getProperty("url"));
		loginPage=new LoginPage( driver);
		homePage=loginPage.login(prop.getProperty("username_app"),prop.getProperty("password_app"));
		contactPage=homePage.navigateToContactsPage();

	}

	/*
	@Test
	public void enterSearchTest(){
		
		contactPage.enterSearch();
		
	
	}
	
	@Test
	public void clickImportButtonTest(){
		
		contactPage.clickImportButton();
		String title=contactPage.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constant.Import_Page__Title);
	
	
	}
	

	@Test
	public void clickRemoveIconTest(){
		contactPage.enterSearch();
		 contactPage.clickRemoveIcon();
		
	}
	
	@Test
	public void CreateContactButton(){
		contactPage.createContactButtonClick();
		TestUtil.shortWait();
		String headerName=contactPage.getHeaderName();
		Assert.assertEquals(headerName, Constant.Create_Contact_Header_Name);
		
	}*/
	
	
	@DataProvider(name = "getContactsTestData")
	public Object[][] getContactsTestData() {
		Object contactsData[][] = TestUtil.getTestData(Constant.CONTACTS_SHEET_NAME);
		return contactsData;
	}
	
	

	@Test(dataProvider = "getContactsTestData")
	public void createNewContactTest(String email, String firstName, String lastName, String jobTitle) {
		contactPage.createNewContact(email, firstName, lastName, jobTitle);
		
	}

	@AfterMethod // --this method will be executed after every test method
	public void tearDown() {
		driver.quit();
	}


	
}
