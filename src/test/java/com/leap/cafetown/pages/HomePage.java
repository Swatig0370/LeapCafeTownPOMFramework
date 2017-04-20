package com.leap.cafetown.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.leap.cafetown.common.SeleniumUtil;

//Home Page object repository.
public class HomePage {
	
	private WebDriver driver;
	SeleniumUtil util = new SeleniumUtil();
	LoginPage login;
		
	@FindBy(id="greetings")
	private WebElement userId;
	
	@FindBy(xpath="//*[@class='main-button']")
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
	
	public WebElement getLogoutBtn() {
		return logoutBtn;
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
	
	public boolean verifyRecords(){
		boolean validrecord = (getRecord().getText().length()> 0);
		return validrecord;
	}

	public void selectRecord(){
		record.click();
	}
	
	
	
}
