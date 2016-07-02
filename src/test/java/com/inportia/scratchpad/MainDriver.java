package com.inportia.scratchpad;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import com.inportia.scratchpad.testcases.Checkboxes;


public class MainDriver {

	static ChromeDriver driver;
	
	
	public static void initDriver()
	{
		System.setProperty("selenium.chrome.driver", "/home/sohail/Documents/setups/chromedriver");
		MainDriver.driver = new ChromeDriver();
		MainDriver.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		MainDriver.driver.manage().deleteAllCookies();
		MainDriver.driver.manage().window().maximize();		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		MainDriver.initDriver();
		
		if(MainDriver.driver != null)
		{
			Checkboxes.test(MainDriver.driver);
			MainDriver.getScreenshot();
		}
		
		MainDriver.closeDriver();
	}
	
	
	public static void closeDriver()
	{
		try{
			MainDriver.driver.close();
		}catch(Exception ex){
			
		}
	}
	
	public static void getScreenshot()
	{
		try
		{
		   File capturedFile = ((TakesScreenshot)MainDriver.driver).getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(capturedFile, new File("/home/sohail/Desktop/seleniumScreenshots/sampleScreenshot.png"));
		}
		catch(IOException ex){
		   
		}
	}

}
