package com.leap.cafetown.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.leap.cafetown.common.SeleniumUtil;



public class LoginPage extends SeleniumUtil{
	
	private WebDriver driver;
		
	@FindBy(xpath="//input[@ng-model='user.name']")
	private WebElement userNameTB;
	
	@FindBy(xpath="//input[@ng-model='user.password']")
	private WebElement passwordTB;
	
	@FindBy(xpath=".//*[@id='login-form']/fieldset/button")
	private WebElement loginBtn;
	
	@FindBy(xpath=".//*[@id='login-form']/fieldset/p[1]")
	private WebElement errormsg;
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		}

	public void enterUsername(String username)
	{
		
		waitForPageToLoadImplicit(driver);
		userNameTB.sendKeys(username);
	}
	
	public void enterPassword(String pass)
	{
		waitForPageToLoadImplicit(driver);
		passwordTB.sendKeys(pass);
	}
	
	public WebDriver clickLoginbtn()
	{
		loginBtn.click();
		return driver;
		
	}
	public HomePage LoginFunction(String user, String pass){
		enterUsername(user);
		enterPassword(pass);
		clickLoginbtn();	
		return new HomePage(driver);
	}
	public String getErrorMsg(){
		Wait<WebDriver> wait = waitForPageToLoadExplicit(driver);
	    wait.until(ExpectedConditions.visibilityOf(errormsg));
		return errormsg.getText();
		
	}
	
	
	public String getPageTitle() {
		return driver.getTitle();
		
	}
	
	
}
