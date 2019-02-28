package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.constants.Constant;
import com.qa.hubspot.util.TestUtil;

public class HomePage extends BasePage {


	@FindBy(className="private-page__title")
	WebElement homePageHeader;

	@FindBy(id="nav-primary-contacts-branch")
	WebElement contactsTab;

	@FindBy(id="nav-secondary-contacts")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[@id='account-menu']")
	WebElement accountMenuLink;
	
	@FindBy(xpath="//div[text()='Profile & Preferences']")
	WebElement ProfilePrefEle;


public HomePage(WebDriver driver){

		this.driver=driver;
		PageFactory.initElements(driver,this);

	}



public String getHomePageTitle(){

		WebDriverWait wait=new WebDriverWait(driver,20);

		wait.until(ExpectedConditions.titleContains(Constant.Home_Page_Title));

		return driver.getTitle();

	}


	public boolean verifyHomePageHeader(){

		WebDriverWait wait=new WebDriverWait(driver,20);

		wait.until(ExpectedConditions.visibilityOf(homePageHeader));

		return homePageHeader.isDisplayed();

	}

	public String getHomePageHeaderText(){

		WebDriverWait wait=new WebDriverWait(driver,20);

		wait.until(ExpectedConditions.visibilityOf(homePageHeader));

		return homePageHeader.getText();
	}



	public ContactsPage navigateToContactsPage(){

		WebDriverWait wait=new WebDriverWait(driver,20);

		wait.until(ExpectedConditions.visibilityOf(contactsTab));

		contactsTab.click();

		TestUtil.shortWait();
		contactsLink.click();
		return new ContactsPage(driver);

	}


	public String getCurrentURL(){

		return driver.getCurrentUrl();
	}
	
	public ProfileAndPreferencePage navigateToProfilePreference(){

		WebDriverWait wait=new WebDriverWait(driver,20);

		wait.until(ExpectedConditions.visibilityOf(accountMenuLink));

		accountMenuLink.click();

		TestUtil.shortWait();
		ProfilePrefEle.click();
		return new ProfileAndPreferencePage(driver);

	}



}
