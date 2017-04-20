package com.leap.cafetown.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.leap.cafetown.common.SeleniumUtil;


//Create Employee Page object repository.
public class CreateNewEmployeePage {

	private WebDriver driver;
	SeleniumUtil util = new SeleniumUtil();
	
	//FirstName Textbox
	@FindBy(xpath="//*/input[@ng-model='selectedEmployee.firstName']")
	private WebElement firstNameTB;
	
	//LastName Textbox
	@FindBy(xpath="//*/input[@ng-model='selectedEmployee.lastName']")
	private WebElement lastNameTB;
	
	//StartDate Textbox
	@FindBy(xpath="//*/input[@ng-model='selectedEmployee.startDate']")
	private WebElement startDateTB;
	
	//Email Textbox
	@FindBy(xpath="//*/input[@ng-model='selectedEmployee.email']")
	private WebElement emailTB;
	
	//Cancel Button
	@FindBy(xpath="//*[@class='subButton bCancel']")
	private WebElement cancelBtn;
	
	//Add Button
	@FindBy(xpath="/html/body/div/div/div/form/fieldset/div/button[2]")
	private WebElement AddBtn;
	
	
	//Constructor to initialize the WebDriver object and PageFactory initElements method.
	public CreateNewEmployeePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getFirstNameTB() {
		return firstNameTB;
	}

	public WebElement getLastNameTB() {
		return lastNameTB;
	}
	
	public WebElement getStartDateTB() {
		return startDateTB;
	}
	
	public WebElement getEmailTB() {
		return emailTB;
	}
	
	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public WebElement getAddBtn() {
		return AddBtn;
	}

	
	public void EnterFirstNameTB(String firstName) {
		firstNameTB.sendKeys(firstName);
	}
	
	public void EnterLastNameTB(String lastName) {
		lastNameTB.sendKeys(lastName);
	}

	public void EnterStartDateTB(String startDate) {
		startDateTB.sendKeys(startDate);
	}

	public void EnterEmailTB(String email) {
		emailTB.sendKeys(email);
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
