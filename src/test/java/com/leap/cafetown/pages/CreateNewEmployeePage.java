package com.leap.cafetown.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.leap.cafetown.common.SeleniumUtil;

public class CreateNewEmployeePage {

	private WebDriver driver;
	SeleniumUtil util = new SeleniumUtil();
	
	@FindBy(xpath="//*/input[@ng-model='selectedEmployee.firstName']")
	private WebElement firstNameTB;
	
	@FindBy(xpath="//*/input[@ng-model='selectedEmployee.lastName']")
	private WebElement lastNameTB;
	
	@FindBy(xpath="//*/input[@ng-model='selectedEmployee.startDate']")
	private WebElement startDateTB;
	
	@FindBy(xpath="//*/input[@ng-model='selectedEmployee.email']")
	private WebElement emailTB;
	
	@FindBy(xpath="//*[@class='subButton bCancel']")
	private WebElement cancelBtn;
	
	@FindBy(xpath="/html/body/div/div/div/form/fieldset/div/button[2]")
	private WebElement AddBtn;
	
	public CreateNewEmployeePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getFirstNameTB() {
		return firstNameTB;
	}

	public void EnterFirstNameTB(String firstName) {
		firstNameTB.sendKeys(firstName);
	}

	public WebElement getLastNameTB() {
		return lastNameTB;
	}

	public void EnterLastNameTB(String lastName) {
		lastNameTB.sendKeys(lastName);
	}

	public WebElement getStartDateTB() {
		return startDateTB;
	}

	public void EnterStartDateTB(String startDate) {
		startDateTB.sendKeys(startDate);
	}

	public WebElement getEmailTB() {
		return emailTB;
	}

	public void EnterEmailTB(String email) {
		emailTB.sendKeys(email);
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public WebElement getAddBtn() {
		return AddBtn;
	}
	
	public HomePage clickCancelBtn(){
		cancelBtn.click();
		return new HomePage(driver);
	}
	
	public HomePage clickAddBtn(){
		AddBtn.click();
		return new HomePage(driver);
		
	}
	
	
}
