package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.Base.BasePage;


public class LoginPage extends BasePage{
	
	
	
	//1. a :define Page objects(Page OR):using PageFActory Pattern

	@FindBy(id="username")
	WebElement emailId;

	@FindBy(id="password")
	WebElement password;

	@FindBy(id="loginBtn")
	WebElement loginButton;
	
	@FindBy(linkText="Sign up")
	WebElement signUpLink;
	
	//1. b:Create constructor an initialize the elements
	public LoginPage(WebDriver driver){
		
	
		this.driver=driver;
		PageFactory.initElements(driver,this);//this is LoginPage.class...initialize the webElements 
		
		
	}
	
	//2.Methods-Actions:

	public String getLoginPage(){

		return driver.getTitle();

	}
	public boolean VerifySignUpLink(){

		return signUpLink.isDisplayed();

	}
	
	public HomePage login(String un,String pwd){

		emailId.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		
		return new HomePage(driver);

	}
	
	
	

}
