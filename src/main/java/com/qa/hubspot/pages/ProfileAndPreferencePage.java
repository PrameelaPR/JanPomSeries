package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.constants.Constant;
import com.qa.hubspot.util.TestUtil;

public class ProfileAndPreferencePage extends BasePage {
	
	
	
	@FindBy(className="private-header__title private-page__title")
	WebElement userPrefPageHeader;
	
	
	
	
	public ProfileAndPreferencePage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public String getUserPrefTitle(){
		

		WebDriverWait wait=new WebDriverWait(driver,20);

		wait.until(ExpectedConditions.titleContains(Constant.User_Pref_Title));

		return driver.getTitle();

	}

	

	public boolean verifyUserPrefPageHeader(){
		HomePage homePage=new HomePage(driver);
		homePage.navigateToProfilePreference();

		WebDriverWait wait=new WebDriverWait(driver,20);

		wait.until(ExpectedConditions.visibilityOf(userPrefPageHeader));

		return userPrefPageHeader.isDisplayed();

	}
	
	
	
	
	
	

}
