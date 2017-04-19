package com.leap.cafetown.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.leap.cafetown.common.SeleniumUtil;


public class HomePage {
	
	private WebDriver driver;
	SeleniumUtil util = new SeleniumUtil();
	
	
	@FindBy(id="greetings")
	private WebElement userId;
	
	@FindBy(xpath="/html/body/div/header/div/p[1]")
	private WebElement logoutBtn;
	
	@FindBy(xpath="//*[@id='bAdd']")
	private WebElement createBtn;
	
	@FindBy(xpath="//*[@id='bEdit']")
	private WebElement editBtn;
		
	@FindBy(xpath="//*[@id='bDelete']")
	private WebElement deleteBtn;
	
	@FindBy(xpath="//*[@id='employee-list']/li")
	private WebElement record;
	

	@FindBy(xpath="//*[@id='employee-list']/li")
	private List<WebElement> recordList;
	
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		}
	
	public WebElement getCreateBtn() {
		return createBtn;
	}
	
	public WebElement getEditBtn() {
			return editBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getRecord() {
		return record;
	}

	public List<WebElement> getRecordList() {
		return recordList;
	}

	public CreateNewEmployeePage clickOnCreateBtn()
	{
		createBtn.click();
		return new CreateNewEmployeePage(driver);
	}
	
	public EditEmployeePage clickOnEditBtn()
	{
		record.click();
		editBtn.click();
		return new EditEmployeePage(driver);
	}
	
	public void clickOnDeleteBtn()
	{
		deleteBtn.click();
	}
	
	private String getUserID()
	{
		return userId.getText();
	}
	
	public boolean verifyHomePage(){
		
		return getUserID().contains("Hello Luke");
	}
	
	
	public boolean verifyLogoutbtn(){
		
		util.waitForPageToLoadImplicit(driver);
		if(logoutBtn.isEnabled()&& logoutBtn.isEnabled())
		{ 
			System.out.println("Logout button is clickable.");	
			logoutBtn.click();
		}
		return driver.getCurrentUrl().contains("login");
		
	}
	
	public boolean verifyRecords(){
		boolean validrecord = (getRecord().getText().length()> 0);
		return validrecord;
	}

	public void selectRecord(){
		record.click();
	}
	
	
	
}
