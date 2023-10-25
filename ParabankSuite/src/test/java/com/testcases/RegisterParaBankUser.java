package com.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.driverscript.TestBase;
import com.pages.RegisterPage;

public class RegisterParaBankUser extends TestBase{
  @Test(dataProviderClass=com.utilites.TestUtil.class, dataProvider="registerParaUser", groups= {"Regression"})
  public void registerParaBankUser(Hashtable<String, String> data) {
	  RegisterPage register = PageFactory.initElements(driver, RegisterPage.class);
	  register.clickRegisterButton();
	  register.setFirstName(data.get("FirstName"));
	  register.setLastName(data.get("LastName"));
	  register.setAddress(data.get("Address"));
	  register.setCityName(data.get("City"));
	  register.setStateName(data.get("State"));
	  register.setZipcode(data.get("ZipCode"));
	  register.setPhoneNumber(data.get("Phone"));
	  register.setSSN(data.get("SSN"));
	  register.setUserName(data.get("UserName"));
	  register.setPassword(data.get("Password"));
	  register.confirmPassword(data.get("Confirm"));
	  register.clickRegisterUserButton();
	  register.loginUserName(data.get("UserName"));
	  register.loginPassword(data.get("Password"));
	  register.clickLogin();
  }
  @Test(groups= {"Smoke"})
  public void testGroups() {
	  System.out.println("Testing groups");
  }
}
