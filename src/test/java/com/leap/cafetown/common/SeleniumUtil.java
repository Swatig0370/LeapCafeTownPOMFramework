package com.leap.cafetown.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class SeleniumUtil {

	//Common utilities class
	private WebDriver driver;
	static String driverPath = "F:\\MVCSpring\\YLPPOMFW\\src\\test\\resources\\browser\\";
	
	
	//Method to get the WebDriver object.
	public WebDriver getDriver( ){
		return driver;
	}
	
	//Method to launch the browser based on the user input in the testng.xml file.
	private void setDriver(String browserType, String appURL){
		
		if(browserType.equalsIgnoreCase("CH"))
			driver = initChromeDriver(appURL);
		
		else if (browserType.equalsIgnoreCase("FF"))
			driver = initFirefoxDriver(appURL);
		
		else if (browserType.equalsIgnoreCase("IE"))
			driver = initIEDriver(appURL);
		
		else{ 
			System.out.println("Browser : "+ browserType + "is invaild, launching the Chrome browser as default..");
			driver = initChromeDriver(appURL);
		}
		
	 }	
	
	 //Method to initiate Chrome Browser
	 private static WebDriver initChromeDriver(String appURL){
		
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	 }
		
	 //Method to initiate IE Browser
	 private WebDriver initIEDriver(String appURL) {
			
	    System.out.println("Launching Internet Explorer with new profile..");
		System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	  }

	//Method to initiate FireFox Browser
	private WebDriver initFirefoxDriver(String appURL) {
		
		System.out.println("Launching Firefox with new profile..");
		System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
		DesiredCapabilities cap = new DesiredCapabilities();
		WebDriver driver = new FirefoxDriver(cap);
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		
		return driver;
	}
	
	//Implicit wait method
	public void waitForPageToLoadImplicit(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	//Explicit-Fluent wait method
	public Wait<WebDriver>  waitForPageToLoadExplicit(WebDriver driver) {
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)

			.withTimeout(30, TimeUnit.SECONDS)

			.pollingEvery(5, TimeUnit.SECONDS)

			.ignoring(NoSuchElementException.class);
	
	return wait;
	}
	
	
	/*
	 * This method will fetch the Browser detail and Application URL from the TestNG.xml 
	 * file using @Parameter annotation and launch the browser with the given URL.
	 *  
	 */
	
	@Parameters({"browserType", "appURL"})
	@BeforeMethod
	public void initializeTestBaseSetup(String browserType, String appURL){
		setDriver(browserType,appURL);
	}
		
		

}
