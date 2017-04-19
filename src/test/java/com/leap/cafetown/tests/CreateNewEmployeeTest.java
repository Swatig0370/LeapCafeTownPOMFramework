package com.leap.cafetown.tests;

import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.leap.cafetown.common.SeleniumUtil;
import com.leap.cafetown.pages.CreateNewEmployeePage;
import com.leap.cafetown.pages.HomePage;
import com.leap.cafetown.pages.LoginPage;



public class CreateNewEmployeeTest extends SeleniumUtil{
	
	private WebDriver driver;
	private LoginPage login;
	private HomePage home;
	private CreateNewEmployeePage create;
	
	@BeforeMethod()
	public void setUp(){
		driver = getDriver();
		login = new LoginPage(driver);
	}
	
	@BeforeMethod(dependsOnMethods = {"setUp"})
	public CreateNewEmployeePage openCreateNewEmployeePage(){
		home = login.LoginFunction("Luke", "Skywalker");
		create = home.clickOnCreateBtn();
		return create;
	}
	
	@Test(priority = 0)
	public void verifyCreateNewPageOpen(){
		boolean isExist =  create.getAddBtn().isDisplayed();
		Assert.assertTrue(isExist,"We are on Create Employee page");
	}
	
	@Test(priority =1)
	public void verifyAllElementsOnCreatePage(){
		
		boolean isFNTBExist =  create.getFirstNameTB().isDisplayed();
		Assert.assertTrue(isFNTBExist, "First Name textbox is not visiable on the page");
		
		boolean isLNTBExist =  create.getLastNameTB().isDisplayed();
		Assert.assertTrue(isLNTBExist, "Last Name textbox is not visiable on the page");
		
		boolean isSDTBExist =  create.getStartDateTB().isDisplayed();
		Assert.assertTrue(isSDTBExist, "Start Date textbox is not visiable on the page");
		
		boolean isEmailTBExist =  create.getEmailTB().isDisplayed();
		Assert.assertTrue(isEmailTBExist, "Email textbox is not visiable on the page");
		
		boolean isAddbtnExist =  create.getAddBtn().isDisplayed();
		Assert.assertTrue(isAddbtnExist, "Add button is not visiable on the page");
		
		boolean isCancelbtnExist =  create.getCancelBtn().isDisplayed();
		Assert.assertTrue(isCancelbtnExist, "Cancel button is not visiable on the page");
	}
	
	@Test(priority =2)
	public void validateAddNewEmployee(){
		create.EnterFirstNameTB("SelFirst");
		create.EnterLastNameTB("SelLast");
		create.EnterStartDateTB("2012-12-12");
		create.EnterEmailTB("selFirst@sel.com");
		create.clickAddBtn();
		String actultext;
		Iterator<WebElement> iterat = home.getRecordList().iterator();
		while(iterat.hasNext())
		{
			
			if(iterat.next().getText().contains("SelFirst") )
			{
				actultext = iterat.next().getText();
				Assert.assertEquals(actultext, "SelFirst SelLast");
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
