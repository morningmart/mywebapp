package com.mywebapp.test.mywebapptest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.ie.InternetExplorerDriver; 
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

	WebDriver driver; 
     
    @Test
	public void testCaseGoogleHomePageWithFirefox() {
    	driver= new FirefoxDriver();
    	commonCode(driver); 
	}
    
    @Test
	public void testCaseGoogleHomePageWithChrome() {
    	// Set Path in system environmental variables or include below line  
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\g1\\SeleniumDrivers\\chromedriver.exe");
    	driver= new ChromeDriver();
    	commonCode(driver); 
	}
    
    @Test
	public void testCaseGoogleHomePageWithSafari() {
    	driver= new SafariDriver();
    	commonCode(driver); 
	}
    
    @Test
   	public void testCaseGoogleHomePageWithOpera() {
       	// Set Path in system environmental variables or include below line  
       	System.setProperty("webdriver.opera.driver","C:\\Users\\g1\\SeleniumDrivers\\operadriver.exe");
       	driver= new SafariDriver();
       	commonCode(driver); 
   	}
    
    @Test
	public void testCaseGoogleHomePageWithInternetExplorer() {
    	driver= new InternetExplorerDriver();
    	commonCode(driver); 
	}
    
    @Test
	public void testCaseGoogleHomePageWithHTMLunit() {
    	driver= new HtmlUnitDriver(true);
    	commonCode(driver); 
	}
    
    void commonCode(WebDriver webDriver)
    {
    	//Implicit Wait - pause 10 seconds for each .... 
    	webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
    	
    	//Open the web page 
    	webDriver.get("http://google.com");

    	//Verifying the title page 
		Assert.assertEquals("Google", webDriver.getTitle());
		
		//Close browser
		webDriver.close();
    }

}