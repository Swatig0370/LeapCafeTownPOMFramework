package com.leap.cafetown.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.leap.cafetown.common.SeleniumUtil;
import com.leap.cafetown.pages.HomePage;
import com.leap.cafetown.pages.LoginPage;



public class LoginTest extends SeleniumUtil {

	private WebDriver driver;
	private LoginPage login;
	
	@BeforeMethod
	public void setUp(){
		driver = getDriver();
	}
	
	@Test(priority =0)
	public void verifyLoginPageTitle(){
		login = new LoginPage(driver);
		
		Assert.assertEquals(login.getPageTitle(),"CafeTownsend-AngularJS-Rails","Incorrect Title");
	}
	
	@Test(priority =1)
	public void verifyValidLogin(){
		login = new LoginPage(driver);
		HomePage home = login.LoginFunction("Luke", "Skywalker");
		Assert.assertTrue(home.verifyHomePage());
	}
	
	@Test(priority =2)
	public void verifyInvalidLogin(){
		login = new LoginPage(driver);
		login.enterUsername("Luke");
		login.enterPassword("Sky");
		login.clickLoginbtn();
		waitForPageToLoadImplicit(driver);
		Assert.assertEquals(login.getErrorMsg(),"Invalid username or password!");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
		driver.quit();
	}
	
}
