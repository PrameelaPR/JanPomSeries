package com.qa.hubspot.pages;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.constants.Constant;
import com.qa.hubspot.util.TestUtil;

public class DifferentTests {

	
	
	public static void main(String args[]){
		WebDriverWait wait;
		
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\selinium\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://www.hubspot.com/login");
		driver.findElement(By.id("username")).sendKeys("naveenanimation20@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Test@1234");
		driver.findElement(By.id("loginBtn")).click();

		
		
		//clicking the contacts page
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement contactsTab=driver.findElement(By.id("nav-primary-contacts-branch"));
		 wait=new WebDriverWait(driver,20);
		
		wait.until(ExpectedConditions.visibilityOf(contactsTab));

		contactsTab.click();
		
		WebElement contactsLink=driver.findElement(By.id("nav-secondary-contacts"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contactsLink.click();
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*WebElement ImportButton=driver.findElement(By.xpath("//a/span/span[text()='Import']"));
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(ImportButton));
		
		ImportButton.click();*/
		
		
		
		WebElement createContactBtn=driver.findElement(By.xpath("//button/span/span[text()='Create contact']"));
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(createContactBtn));
		
		createContactBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement headerElement=driver.findElement(By.xpath("//div/h3[text()='Create contact']"));
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(headerElement));
		
		String str=headerElement.getText();
		
		System.out.println(str);
		
		
		/*//wait2.until(ExpectedConditions.visibilityOf(contactsTab));
		WebElement editProperty=driver.findElement(By.xpath("//*[@id='dropdown-menu-136']/ul/li[2]/a/span/span"));
		wait.until(ExpectedConditions.visibilityOf(editProperty));
		editProperty.click();*/
		
	}
	
}
