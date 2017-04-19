package com.leap.cafetown.tests;

import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.leap.cafetown.common.SeleniumUtil;
import com.leap.cafetown.pages.EditEmployeePage;
import com.leap.cafetown.pages.HomePage;
import com.leap.cafetown.pages.LoginPage;

public class EditEmployeeTest extends SeleniumUtil{


	private WebDriver driver;
	private LoginPage login;
	private HomePage home;
	private EditEmployeePage editpage;
	
	@BeforeMethod()
	public void setUp(){
		driver = getDriver();
		login = new LoginPage(driver);
	}
	
	@BeforeMethod(dependsOnMethods = {"setUp"})
	public EditEmployeePage openEditNewEmployeePage(){
		home = login.LoginFunction("Luke", "Skywalker");
		editpage = home.clickOnEditBtn();
		return editpage;
	}
	
	@Test(priority = 0)
	public void verifyEditEmployeePageOpen(){
		boolean isExist =  editpage.getUpdateBtn().isDisplayed();
		Assert.assertTrue(isExist,"We are not on edit Employee page");
	}
	
	@Test(priority =1)
	public void verifyAllElementsOnEditEmployeePage(){
		
		boolean isFNTBExist =  editpage.getFirstNameTB().isDisplayed();
		Assert.assertTrue(isFNTBExist, "First Name textbox is not visiable on the page");
		
		boolean isLNTBExist =  editpage.getLastNameTB().isDisplayed();
		Assert.assertTrue(isLNTBExist, "Last Name textbox is not visiable on the page");
		
		boolean isSDTBExist =  editpage.getStartDateTB().isDisplayed();
		Assert.assertTrue(isSDTBExist, "Start Date textbox is not visiable on the page");
		
		boolean isEmailTBExist =  editpage.getEmailTB().isDisplayed();
		Assert.assertTrue(isEmailTBExist, "Email textbox is not visiable on the page");
		
		boolean isBackbtnExist =  editpage.getBackBtn().isDisplayed();
		Assert.assertTrue(isBackbtnExist, "Back button is not visiable on the page");
		
		boolean isUpdatebtnExist =  editpage.getUpdateBtn().isDisplayed();
		Assert.assertTrue(isUpdatebtnExist, "Update button is not visiable on the page");
		
		boolean isDeletebtnExist =  editpage.getDeleteBtn().isDisplayed();
		Assert.assertTrue(isDeletebtnExist, "Delete button is not visiable on the page");
	}
	
	@Test(priority =2)
	public void validateUpdateEmployee(){
				
		System.out.println(editpage.getFirstNameTB().getText());
		editpage.getFirstNameTB().clear();
		editpage.EnterFirstNameTB("SelUpdated");
		editpage.clickUpdateBtn();
		
		Iterator<WebElement> iterat = home.getRecordList().iterator();
		while(iterat.hasNext())
		{
			
			if(iterat.next().getText().contains("SelUpdated") )
			{
				
				boolean updatestatus = iterat.next().getText().contains("SelUpdated");
				Assert.assertTrue(updatestatus, "Record is not updated");
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
