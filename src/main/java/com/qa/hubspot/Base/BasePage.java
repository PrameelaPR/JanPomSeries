package com.qa.hubspot.Base;

import java.io.File;

import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	
	
	public WebDriver driver;
	public Properties prop;
	public static ThreadLocal<WebDriver> tdriver=new ThreadLocal<WebDriver>();
	
	public WebDriver initialize_driver(){
		
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\selinium\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		//driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		tdriver.set(driver);
		return getDriver();
		
	}
		
	public static synchronized WebDriver getDriver(){//get local copy of driver
		return tdriver.get();
	}
	
	public Properties initialize_Properites(){


		prop=new Properties();
		FileInputStream ip = null;
		try {
			ip = new FileInputStream("C:/Users/PRVK/gitrepos/JanPOMSeries/src/main/java/com/qa/hubspot/config/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

	
	public String getScreenshot(){

		File src=((TakesScreenshot)tdriver.get()).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+ " .png";
		File destination =new File(path);
		try{
		      FileUtils.copyFile(src,destination);
		    }catch(IOException e){
			System.out.println("Capture Failed "+e.getMessage());
		  }
		   return path;
		}

  }
	
	

