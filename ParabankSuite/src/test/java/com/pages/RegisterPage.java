package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.objectrepository.ObjectRepository;

public class RegisterPage {
	public WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(xpath=ObjectRepository.registerBtnXpath)
	@CacheLookup
	WebElement registerButton;
	
	@FindBy(xpath=ObjectRepository.firstNameXpath)
	@CacheLookup
	WebElement firstName;
	
	@FindBy(xpath=ObjectRepository.lastNameXpath)
	@CacheLookup
	WebElement lastName;
	
	@FindBy(xpath=ObjectRepository.addressXpath)
	@CacheLookup
	WebElement address;
	
	@FindBy(xpath=ObjectRepository.zipCodeXpath)
	@CacheLookup
	WebElement zipCode;
	
	@FindBy(xpath=ObjectRepository.cityXpath)
	@CacheLookup
	WebElement city;
	
	@FindBy(xpath=ObjectRepository.stateXpath)
	@CacheLookup
	WebElement state;
	
	@FindBy(xpath=ObjectRepository.phoneXpath)
	@CacheLookup
	WebElement phone;
	
	@FindBy(xpath=ObjectRepository.ssnXpath)
	@CacheLookup
	WebElement ssn;
	
	@FindBy(xpath=ObjectRepository.userNameXpath)
	@CacheLookup
	WebElement userName;
	
	@FindBy(xpath=ObjectRepository.passwordXpath)
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath=ObjectRepository.confirmPWDXpath)
	@CacheLookup
	WebElement confirmPassword;
	
	@FindBy(xpath=ObjectRepository.registerUserBtnXpath)
	@CacheLookup
	WebElement registerUser;
	
	@FindBy(xpath=ObjectRepository.usernameLoginXpath)
	@CacheLookup
	WebElement userNameLogin;
	
	@FindBy(xpath=ObjectRepository.passwordLoginXpath)
	@CacheLookup
	WebElement passwordLogin;
	
	@FindBy(xpath=ObjectRepository.loginBtnXpath)
	@CacheLookup
	WebElement loginButton;
	
	public void clickRegisterButton() {
		registerButton.click();
	}
	public void setFirstName(String fname) {
		firstName.sendKeys(fname);
		Reporter.log(fname);
	}
	public void setLastName(String lname) {
		lastName.sendKeys(lname);
		Reporter.log(lname);
	}
	public void setAddress(String adrs) {
		address.sendKeys(adrs);
		Reporter.log(adrs);
	}
	public void setCityName(String cityValue) {
		city.sendKeys(cityValue);
		Reporter.log(cityValue);
	}
	public void setStateName(String stateValue) {
		state.sendKeys(stateValue);
		Reporter.log(stateValue);
	}
	public void setZipcode(String zipCodeValue) {
		zipCode.sendKeys(zipCodeValue);
		Reporter.log(zipCodeValue);
	}
	public void setPhoneNumber(String phoneNumber) {
		phone.sendKeys(phoneNumber);
		Reporter.log(phoneNumber);
	}
	public void setSSN(String ssnNumber) {
		ssn.sendKeys(ssnNumber);
		Reporter.log(ssnNumber);
	}
	public void setUserName(String userNameValue) {
		userName.sendKeys(userNameValue);
		Reporter.log(userNameValue);
	}
	public void setPassword(String passwordValue) {
		password.sendKeys(passwordValue);
		Reporter.log(passwordValue);
	}
	public void confirmPassword(String confirmPwdValue) {
		confirmPassword.sendKeys(confirmPwdValue);
		Reporter.log(confirmPwdValue);
	}
	public void clickRegisterUserButton() {
		registerUser.click();
		driver.navigate().back();
	}
	public void loginUserName(String loginUname) {
		userNameLogin.sendKeys(loginUname);
		Reporter.log(loginUname);
	}
	public void loginPassword(String loginPassword) {
		passwordLogin.sendKeys(loginPassword);
		Reporter.log(loginPassword);
	}
	public void clickLogin() {
		loginButton.click();;
	}
}
