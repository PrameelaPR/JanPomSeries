package com.qa.hubspot.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.constants.Constant;


public class ContactsPage extends BasePage {

	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchBox;
	
	
	@FindBy(xpath="//a/span/span[text()='Import']")
	WebElement importButton;
	
	@FindBy(xpath="//div/span[text()='remove']")
	WebElement removeIcon;
	
	
	@FindBy(xpath="//div/h3[text()='Create contact']")
	WebElement headerTitle;
	
	@FindBy(xpath = "//span[text()='Create contact']")
	WebElement createContactBtn;
	
	@FindBy(xpath = "//li//span[text()='Create contact']")
	WebElement createContactSecondBtn;
	
	@FindBy(id = "uid-ctrl-1")
	WebElement email;
	
	@FindBy(id = "uid-ctrl-2")
	WebElement firstName;
	
	@FindBy(id = "uid-ctrl-3")
	WebElement lastName;
	
	@FindBy(id = "uid-ctrl-5")
	WebElement jobTitle;
	
	
	
	public ContactsPage(WebDriver driver){

		this.driver=driver;
		PageFactory.initElements(driver,this);

	}
	
	public void enterSearch(){
		
		WebDriverWait wait=new WebDriverWait(driver,20);

		wait.until(ExpectedConditions.visibilityOf(searchBox));
		
	  searchBox.sendKeys(Constant.Contact_Search_Input);
		
	}
	
	public void findOptionsForActionsDropDown(){
		
	}
	
	public void clickImportButton(){
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(importButton));
		
		importButton.click();
	}
	
	public void clickRemoveIcon(){
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(removeIcon));
		
		removeIcon.click();
		
	}
	
	public void createContactButtonClick(){
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(createContactBtn));
		createContactBtn.click();
		
		
		
	}
	
	public String getHeaderName(){
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(headerTitle));
		
		return headerTitle.getText();
		
	}
	
	public String getTitle(){
		
		return driver.getTitle();
	}
	
	public void createNewContact(String emailVal, String firstname, String lastname, String jobtitle ){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.elementToBeClickable(createContactBtn));
		createContactBtn.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(email));
		email.sendKeys(emailVal);
		
		wait.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.sendKeys(firstname);
		
		wait.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.sendKeys(lastname);
		
		wait.until(ExpectedConditions.elementToBeClickable(jobTitle));
		jobTitle.sendKeys(jobtitle);
		
		wait.until(ExpectedConditions.elementToBeClickable(createContactSecondBtn));
		createContactSecondBtn.click();
		
	}
	

}

	



