package com.org.library;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Utility {

	public static String captureScreenshot(WebDriver driver, String ScreenshotName)
	{
		//Date and time for screenshots
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss"); 
		String currentTime = formatter.format(calendar.getTime());
		System.out.println(currentTime);
		
		
		String destination = "./Screenshots/"+ScreenshotName+"_"+currentTime+".png";
		
		try {
						
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File finalDestination= new File(destination);
			FileUtils.copyFile(source,finalDestination);
			System.out.println("*******************Screenshot taken **************");
			
			
			
		} catch (Exception e) {
			System.out.println("Exception while taking Screenshot "+ e.getMessage());
		}
		System.out.println("Screenshot Path is : "+destination);
		return destination;
	}
}
