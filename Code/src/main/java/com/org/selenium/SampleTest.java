package com.org.selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.org.library.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.ITest;


public class SampleTest {

	public WebDriver driver;   //Define web driver
	public JavascriptExecutor jse;   //This is the interface in selenium which lets us excute few scripts.
	public String baseURL;
	public ExtentReports extent; 
	public ExtentTest exTest;
	public ITest iresult;

	@Before
	public void setUp()
	{
		try {

			//Instantiate driver
			System.setProperty("webdriver.chrome.driver", "./util/chromedriver");
			extent = new ExtentReports("./reports/TestResult.html",false);
			driver = new ChromeDriver();

			baseURL = "file:/Users/yidixu/Desktop/final/HTML/home_page.html";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public  void flushExtentReport()
	{
		//at the end of the test method to write all the test logs to the report file.
		extent.endTest(exTest);
		extent.flush();
	}
	public void invokeBrowser()
	{
		try {

			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();

			//Page Synchronization
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

			//fetch URL
			driver.get(baseURL);
			Thread.sleep(6000);
			driver.findElement(By.id("u1")).click();
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	 

	
	@Test
	public void test() throws IOException
	{ 
		try {

			invokeBrowser();

			// Sign up
			exTest = extent.startTest("Test 1: Sign up : Negative Scenario 1 ");
			exTest.log(LogStatus.INFO, "Test 1: Negative 1: All fields blank");
			Utility.captureScreenshot(driver,"Test1_N1_Before");

			//Negative Scenario 1: All the fields left blank
			driver.findElement(By.id("u90_input")).sendKeys(""); //username
			driver.findElement(By.id("u83_input")).sendKeys(""); //firstname
			driver.findElement(By.id("u84_input")).sendKeys(""); //lastname
			driver.findElement(By.id("u85_input")).sendKeys(""); //email
			driver.findElement(By.id("u93_input")).sendKeys(""); //password
			Thread.sleep(2000);
			driver.findElement(By.id("u86")).click(); // Sign up	
			Thread.sleep(2000);
			String ScreenshotPath =	Utility.captureScreenshot(driver,"Test1_N1_After");	
			exTest.log(LogStatus.PASS, "Test 1: Negative 1: All fields blank",exTest.addScreenCapture(ScreenshotPath));

			flushExtentReport();

			/*****************************************************************************************************************/			
			exTest = extent.startTest("Test 1: Sign up : Positive Scenario  ");
			exTest.log(LogStatus.INFO, "Test 1: Positive: All fields are properly filled ");
			//Positive scenario: ALL fields are properly filled
			driver.findElement(By.id("u90_input")).sendKeys("user"); //username
			driver.findElement(By.id("u83_input")).sendKeys("jake"); //firstname
			driver.findElement(By.id("u84_input")).sendKeys("Tim"); //lastname
			driver.findElement(By.id("u85_input")).sendKeys("jake@gmail.com"); //email
			driver.findElement(By.id("u93_input")).sendKeys("jake"); //password
			Thread.sleep(2000);
			driver.findElement(By.id("u86")).click(); // Sign up	
			Thread.sleep(2000);
			String ScreenshotPath1 = Utility.captureScreenshot(driver,"Test1_N2_After");
			exTest.log(LogStatus.PASS, "Test 1: Positive: All fields are properly filled",exTest.addScreenCapture(ScreenshotPath1));

			flushExtentReport();
			Thread.sleep(2000);



//			/***********************************************************************************************************************/			
//
//			exTest = extent.startTest("Test 1: Sign up : Positive Scenario  ");
//			exTest.log(LogStatus.INFO, "Test 1: Positive: All fields are properly filled ");
//			//Positive scenario: ALL fields are properly filled
//			driver.findElement(By.id("u14_input")).sendKeys(""); //username
//			driver.findElement(By.id("u7_input")).sendKeys(""); //firstname
//			driver.findElement(By.id("u8_input")).sendKeys("Tim"); //lastname
//			driver.findElement(By.id("u9_input")).sendKeys(""); //email
//			driver.findElement(By.id("u17_input")).sendKeys(""); //password
//			Thread.sleep(2000);
//			driver.findElement(By.id("u86")).click(); // Sign up	
//			Thread.sleep(2000);
//			String ScreenshotPath2 = Utility.captureScreenshot(driver,"Test1_P_After");
//			exTest.log(LogStatus.PASS, "Test 1: Positive: All fields are properly filled ");
//			flushExtentReport();
//
//			Thread.sleep(2000);
			
			// Sign in
			exTest = extent.startTest("Test 2: Sign in : Negative Scenario 1 ");
			exTest.log(LogStatus.INFO, "Test 2: Negative 1: All fields blank");
			Utility.captureScreenshot(driver,"Test2_N1_Before");

			//Negative Scenario 1: All the fields left blank
			driver.findElement(By.id("u100_input")).sendKeys(""); //Username
			driver.findElement(By.id("u101_input")).sendKeys(""); //Password
			Thread.sleep(2000);
			driver.findElement(By.id("u102")).click(); // Sign in	
			Thread.sleep(2000);
			String ScreenshotPath3 =	Utility.captureScreenshot(driver,"Test2_N1_After");	
			exTest.log(LogStatus.PASS, "Test 2: Negative 1: All fields blank",exTest.addScreenCapture(ScreenshotPath));

			flushExtentReport();

			/*****************************************************************************************************************/			
			exTest = extent.startTest("Test 2: Sign in : Negative Scenario 2 ");
			exTest.log(LogStatus.INFO, "Test 2: Negative 2: One field is blank");

			Utility.captureScreenshot(driver,"Test2_N2_Before");
			//Negative Scenario 2:Password field left blank
			driver.findElement(By.id("u100_input")).sendKeys("user"); //Username
			driver.findElement(By.id("u101_input")).sendKeys(""); //Password
			Thread.sleep(2000);
			driver.findElement(By.id("u102")).click(); // Sign in	
			Thread.sleep(2000);
			String ScreenshotPath4 = Utility.captureScreenshot(driver,"Test2_N2_After");
			exTest.log(LogStatus.PASS, "Test 2: Negative 2: One Field is blank",exTest.addScreenCapture(ScreenshotPath1));

			flushExtentReport();



			/***********************************************************************************************************************/			

			exTest = extent.startTest("Test 2: Sign in : Positive Scenario  ");
			exTest.log(LogStatus.INFO, "Test 2: Positive: All fields are properly filled ");
			//Positive scenario: Username and password is properly filled
			driver.findElement(By.id("u100_input")).sendKeys(""); //Username
			driver.findElement(By.id("u101_input")).sendKeys("jake"); //Password
			Thread.sleep(2000);
			String ss3= Utility.captureScreenshot(driver,"Test2_Positive");
			exTest.log(LogStatus.PASS, "Test 2: Negative 2: One Field is blank",exTest.addScreenCapture(ss3));
			driver.findElement(By.id("u102")).click(); // Sign in
			exTest.log(LogStatus.PASS, "Test 2: Positive: All fields are properly filled ");
			flushExtentReport();
			
			
			
			/***********************************************************************************************************************/			
			/*flow and add to collection*/
			jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0,1000)");
			
			exTest = extent.startTest("Test 3: Add : Add To Collection ");
			exTest.log(LogStatus.INFO, "Test 3: Add To Collection ");
			
			driver.findElement(By.id("addbutton")).click();
			Thread.sleep(3000);
			Utility.captureScreenshot(driver,"Test3_SelectRecipe");
			driver.findElement(By.id("u64_img")).click();
			Thread.sleep(3000);
			
//			jse = (JavascriptExecutor) driver;
//			jse.executeScript("scroll(0,1000)");

//			Utility.captureScreenshot(driver,"Test3_SelectRecipe");
			
//			exTest = extent.startTest("Test 3: Add : Add To Collection ");
//			exTest.log(LogStatus.INFO, "Test 3: Add To Collection ");
//			driver.findElement(By.id("u12")).click();
			String ss5 =  Utility.captureScreenshot(driver,"Test3_Add");
			Utility.captureScreenshot(driver,"Test3_AddedRecipe");

//			exTest.log(LogStatus.PASS, "Test 3: Add To Collection",exTest.addScreenCapture(ss5));
//			flushExtentReport();
//			Thread.sleep(2000);
//
//			driver.findElement(By.id("u64")).click();
//			Thread.sleep(2000);
			
			Utility.captureScreenshot(driver,"Test3_AddedRecipe");
			/*publish recipe*/
			driver.findElement(By.id("u317_img")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("cache1")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("create")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("addphoto")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("image1")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("openbutton")).click();
			Thread.sleep(7000);
			driver.findElement(By.id("addphoto")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("image2")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("openbutton")).click();
			Thread.sleep(7000);
			driver.findElement(By.id("addphoto")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("image3")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("openbutton")).click();
			Thread.sleep(8000);
			driver.findElement(By.id("u433_img")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("u432_img")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("u435_input")).sendKeys("dish");
			driver.findElement(By.id("u437_input")).sendKeys("love it");
			driver.findElement(By.id("u439_input")).sendKeys("parrot");
			driver.findElement(By.id("u441_input")).sendKeys("cook");
			Thread.sleep(2000);
			driver.findElement(By.id("savebtn")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("u353_img")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("golab")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("u23_img")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("Keylimeone")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("followbtn")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("golab")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("cache1")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("u344_img")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("probtn")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("golab")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("u23_img")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("addallbtn")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("u213_img")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("u108_img")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("checkbtn")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("u161_input")).sendKeys("!06 Hemenway St");
			driver.findElement(By.id("u164_input")).sendKeys("Apt 6");
			driver.findElement(By.id("u166_input")).sendKeys("left");
			driver.findElement(By.id("u168_input")).sendKeys("Boston");
			driver.findElement(By.id("u170_input")).sendKeys("MA");
			driver.findElement(By.id("u172_input")).sendKeys("02115");
			Thread.sleep(2000);
			driver.findElement(By.id("placebtn")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("logout")).click();
			Thread.sleep(2000);
			
			exTest.log(LogStatus.PASS, "Test 3: Add To Collection",exTest.addScreenCapture(ss5));
			flushExtentReport();
			Thread.sleep(2000);


			//Close all of the browser windows and ends the WebDriver session gracefully
			Thread.sleep(5000);
			driver.quit();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
