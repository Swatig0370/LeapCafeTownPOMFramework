package com.leap.cafetown.tests;

import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.leap.cafetown.common.SeleniumUtil;
import com.leap.cafetown.pages.HomePage;
import com.leap.cafetown.pages.LoginPage;

public class HomeTest extends SeleniumUtil{

	private WebDriver driver;
	private HomePage home;
	private LoginPage login;
	
	
	@BeforeMethod
	public void setUp(){
		driver = getDriver();
		login = new LoginPage(driver);
	}
	
	
	//@Test
	public void ValidateLogoutbutton(){
		home = login.LoginFunction("Luke", "Skywalker");
		Assert.assertTrue(home.verifyLogoutbtn(), "User logged out successfully");
	}
	
	@Test(priority =0)
	public void validateRecordsOnHomePage(){
		home = login.LoginFunction("Luke", "Skywalker");
		Assert.assertTrue(home.verifyRecords(),"Records are visiable on the Home Page");
	}
	
	@Test(priority =1)
	public void validateloggedUser(){
		home = login.LoginFunction("Luke", "Skywalker");
		Assert.assertTrue(home.verifyHomePage(),"User id is correct");
	}
	
	@Test(priority =2)
	public void validateCreateButtonEnable(){
		home = login.LoginFunction("Luke", "Skywalker");
		Assert.assertTrue(home.getCreateBtn().isEnabled(),"Edit id is correct");
	}
	
	@Test(priority =3)
	public void validateEditButtonDisabled(){
		home = login.LoginFunction("Luke", "Skywalker");
		String value = home.getEditBtn().getAttribute("class");
		boolean classValue = value.contains("disable");
		Assert.assertTrue(classValue,"Edit button is disabled");
	}
	
	@Test(priority =4)
	public void validateDeleteButtonDisabled(){
		home = login.LoginFunction("Luke", "Skywalker");
		String value = home.getDeleteBtn().getAttribute("class");
		boolean classValue = value.contains("disable");
		Assert.assertTrue(classValue,"Delete button is disabled");
	}
	
	@Test(priority =5)
	public void validateEditButtonEnabled(){
		home = login.LoginFunction("Luke", "Skywalker");
		home.selectRecord();
		String value = home.getEditBtn().getAttribute("class");
		boolean classValue = value.contains("disable");
		Assert.assertFalse(classValue,"Edit button is Enabled");
	}
	
	@Test(priority =6)
	public void validateDeleteButtonEnabled(){
		home = login.LoginFunction("Luke", "Skywalker");
		home.selectRecord();
		String value = home.getEditBtn().getAttribute("class");
		boolean classValue = value.contains("disable");
		Assert.assertFalse(classValue,"Delete id is Enabled");
	}
	
	@Test(priority =7)
	public void validateDeleteEmployeeRecord(){
		home = login.LoginFunction("Luke", "Skywalker");
		home.selectRecord();
		String delrecord = home.getRecord().getText();
		home.clickOnDeleteBtn();
		driver.switchTo().alert().accept();
		driver.switchTo().parentFrame();
		Iterator<WebElement> iterat = home.getRecordList().iterator();
		while(iterat.hasNext())
		{
			if((iterat.next().getText().contains(delrecord))!=true)
			{
				boolean deletestatus = iterat.next().getText().contains(delrecord);
				Assert.assertFalse(deletestatus, "Record is not deleted");
				break;
			}
		}
				
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.close();
		driver.quit();
	}
	
	
	
}
