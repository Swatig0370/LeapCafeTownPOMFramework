package com.leap.cafetown.tests;

import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.leap.cafetown.common.SeleniumUtil;
import com.leap.cafetown.pages.HomePage;
import com.leap.cafetown.pages.LoginPage;

//Home Page Test Cases.
public class HomeTest extends SeleniumUtil{

	private WebDriver driver;
	private HomePage home;
	private LoginPage login;
	
	
	@BeforeMethod
	public void setUp(){
		driver = getDriver();
		login = new LoginPage(driver);
	}
	
	@BeforeMethod(dependsOnMethods = {"setUp"})
	public HomePage openHomePage(){
		home = login.LoginFunction("Luke", "Skywalker");
		return home;
	}
	
	@Test(priority =0)
	public void validateRecordsOnHomePage(){
		
		Assert.assertTrue(home.verifyRecords(),"Records are not visiable on the Home Page");
	}
	
	@Test(priority =1)
	public void validateloggedUser(){
		
		Assert.assertTrue(home.verifyHomePage(),"User id is incorrect");
	}
	
	@Test(priority =2)
	public void validateCreateButtonEnable(){
		
		Assert.assertTrue(home.getCreateBtn().isEnabled(),"Create button is not enable");
	}
	
	@Test(priority =3)
	public void validateEditButtonDisabled(){
		
		String value = home.getEditBtn().getAttribute("class");
		boolean classValue = value.contains("disable");
		Assert.assertTrue(classValue,"Edit button is not disabled");
	}
	
	@Test(priority =4)
	public void validateDeleteButtonDisabled(){
		
		String value = home.getDeleteBtn().getAttribute("class");
		boolean classValue = value.contains("disable");
		Assert.assertTrue(classValue,"Delete button is not disabled");
	}
	
	@Test(priority =5)
	public void validateEditButtonEnabled(){
		
		home.selectRecord();
		String value = home.getEditBtn().getAttribute("class");
		boolean classValue = value.contains("disable");
		Assert.assertFalse(classValue,"Edit button is not Enabled");
	}
	
	@Test(priority =6)
	public void validateDeleteButtonEnabled(){
		
		home.selectRecord();
		String value = home.getEditBtn().getAttribute("class");
		boolean classValue = value.contains("disable");
		Assert.assertFalse(classValue,"Delete id is not Enabled");
	}
	
	@Test(priority =7)
	public void validateDeleteEmployeeRecord(){
		
		home.selectRecord();
		String delrecord = home.getRecord().getText();
		home.clickOnDeleteBtn();
		driver.switchTo().alert().accept();
		driver.switchTo().parentFrame();
		Iterator<WebElement> iterat = home.getRecordList().iterator();
		while(iterat.hasNext())
		{
			String actultext = iterat.next().getText();
			if(actultext.contains(delrecord)!= true )
			{
				boolean deletestatus = actultext.contains("Sel");
				Assert.assertFalse(deletestatus, "Record is deleted");
				break;
			}
		}
				
	}
	
	@Test(priority =8)
	public void ValidateLogoutbutton(){
		
		Actions action = new Actions(driver);
		action.moveToElement(home.getLogoutBtn()).perform();
		action.moveToElement(home.getLogoutBtn()).click().perform();
		
		boolean logoutstatus = login.getLoginBtn().isDisplayed();
		Assert.assertTrue(logoutstatus, "User didn't logged out unsuccessfully");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
		driver.quit();
	}
	
	
	
}
