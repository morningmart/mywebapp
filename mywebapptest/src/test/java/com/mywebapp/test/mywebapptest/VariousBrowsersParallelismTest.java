package com.mywebapp.test.mywebapptest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class VariousBrowsersParallelismTest {

	WebDriver driver; 
     
    @Test
	public void testCaseGoogleHomePageWithFirefox() {
    	Reporter.log("########## Entering testCaseGoogleHomePageWithFirefox ##########", true);
    	Reporter.log("Initializing FirefoxDriver", true);
    	driver= new FirefoxDriver();
    	commonCode(driver); 
	}
    
    @Test
	public void testCaseGoogleHomePageWithChrome() {
    	Reporter.log("########## Entering testCaseGoogleHomePageWithChrome ##########", true);
    	// Set Path in system environmental variables or include below line  
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\g1\\SeleniumDrivers\\chromedriver.exe");
    	Reporter.log("Initializing ChromeDriver", true);
    	driver= new ChromeDriver();
    	commonCode(driver); 
	}
    
    @Test
	public void testCaseGoogleHomePageWithSafari() {
    	Reporter.log("########## Entering testCaseGoogleHomePageWithSafari ##########", true);
    	Reporter.log("Initializing SafariDriver", true);
    	driver= new SafariDriver();
    	commonCode(driver); 
	}
    
    @Test
   	public void testCaseGoogleHomePageWithOpera() {
    	Reporter.log("########## Entering testCaseGoogleHomePageWithOpera ##########", true);
       	// Set Path in system environmental variables or include below line  
       	System.setProperty("webdriver.opera.driver","C:\\Users\\g1\\SeleniumDrivers\\operadriver.exe");
       	
       	Reporter.log("Initializing OperaDriver", true);
       	driver= new OperaDriver();
       	commonCode(driver); 
   	}
    
    @Test
	public void testCaseGoogleHomePageWithInternetExplorer() {
    	Reporter.log("########## Entering testCaseGoogleHomePageWithInternetExplorer ##########", true);
    	Reporter.log("Initializing InternetExplorerDriver", true);
    	driver= new InternetExplorerDriver();
    	commonCode(driver); 
	}
    
    @Test
	public void testCaseGoogleHomePageWithHTMLunit() {
    	Reporter.log("########## Entering testCaseGoogleHomePageWithHTMLunit ##########", true);
    	Reporter.log("Initializing HtmlUnitDriver", true);
    	driver= new HtmlUnitDriver(true);
    	commonCode(driver); 
	}
    
    void commonCode(WebDriver webDriver)
    {
    	Reporter.log("########## Entering commonCode ##########", true);
    	
    	//Implicit Wait - pause 10 seconds for each .... 
    	Reporter.log("Adding implicit wait time 10 seconds", true);
    	webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
    	
    	//Open the web page 
    	Reporter.log("Opening the google home page", true);
    	webDriver.get("http://google.com");

    	//Verifying the title page 
    	Reporter.log("Checkinig the title of the google page", true);
		Assert.assertEquals("Google", webDriver.getTitle());
		
		//Close browser
		Reporter.log("Closing the current window", true);
		webDriver.close();
    }

}