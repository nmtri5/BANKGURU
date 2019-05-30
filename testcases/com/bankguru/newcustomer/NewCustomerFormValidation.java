package com.bankguru.newcustomer;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.commons.AbstractTest;
import com.bankguru.commons.PageFactoryManager;
import com.bankguru.pageobjects.HomePageObjects;
import com.bankguru.pageobjects.LoginPageObjects;
import com.bankguru.pageobjects.NewCustomerPageObject;

public class NewCustomerFormValidation extends AbstractTest {
	WebDriver driver;
	NewCustomerPageObject newCustomer;
	LoginPageObjects loginPage;
	HomePageObjects homePage;

	@Parameters("browser")
	@BeforeClass
	public void preCondition(String browser) {
		driver = openBrowser(browser);
		
		loginPage = PageFactoryManager.getLoginPage(driver);
		homePage = loginWithValidUser(loginPage);
		
		newCustomer = (NewCustomerPageObject) homePage.openAnySubPage(driver, "New Customer");
	}

	@Test
	public void TC_01_NameCanNotBeEmpty() {
		newCustomer.fillCustomerName("");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isCustomerNameErrorMessageDisplayed("blank"));
	}

	@Test
	public void TC_02_NameCanNotBeNumeric() {
		newCustomer.fillCustomerName("1231");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isCustomerNameErrorMessageDisplayed("numeric"));
		newCustomer.clearTextInTextbox("customer name");
	}

	@Test
	public void TC_03_NameCanNotBeSpecialCharacter() {
		newCustomer.fillCustomerName("!@#");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isCustomerNameErrorMessageDisplayed("special character"));
		newCustomer.clearTextInTextbox("customer name");

	}

	@Test
	public void TC_04_NameCanNotBeFirstBlank() {
		newCustomer.fillCustomerName(" test");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isCustomerNameErrorMessageDisplayed("first blank"));
		newCustomer.clearTextInTextbox("customer name");
	}
	@Test
	public void TC_05_AddressCanNotBeEmpty() {
		newCustomer.fillAddress("");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isAddressErrorMessageDisplayed("blank"));
		newCustomer.clearTextInTextbox("address");
	}

	@Test
	public void TC_06_AddressCanNotHaveFirstBlank() {
		newCustomer.fillAddress(" The White House");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isAddressErrorMessageDisplayed("first blank"));
		newCustomer.clearTextInTextbox("address");
	}
	
	@Test
	public void TC_07_CityCanNotBeEmpty() {
		newCustomer.fillCity("");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isCityMessageErrorDisplayed("blank"));
		newCustomer.clearTextInTextbox("city");
	}

	@Test
	public void TC_08_CityCanNotBeNumeric() {
		newCustomer.fillCity("12314");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isCityMessageErrorDisplayed("numeric"));
		newCustomer.clearTextInTextbox("city");
	}

	@Test
	public void TC_09_CityCanNotHaveSpecialChar() {
		newCustomer.fillCity("@$!@");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isCityMessageErrorDisplayed("special character"));
		newCustomer.clearTextInTextbox("city");
	}

	@Test
	public void TC_10_CityCanNotHaveFirstBlank() {
		newCustomer.fillCity(" Saigon");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isCityMessageErrorDisplayed("first blank"));
		newCustomer.clearTextInTextbox("city");
	}
	
	@Test
	public void TC_11_StateCanNotBeEmpty() {
		newCustomer.fillState("");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isStateErrorMessageDisplayed("blank"));
		newCustomer.clearTextInTextbox("state");
	}
	
	@Test
	public void TC_12_StateCanNotBeNumeric() {
		newCustomer.fillState("State1234");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isStateErrorMessageDisplayed("numeric"));
		newCustomer.clearTextInTextbox("state");
	}

	@Test
	public void TC_13_StateCanNotHaveSpecialChar() {
		newCustomer.fillState("@$!@");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isStateErrorMessageDisplayed("special character"));
		newCustomer.clearTextInTextbox("state");
	}

	@Test
	public void TC_14_StateCanNotHaveFirstBlank() {
		newCustomer.fillState(" Thu Duc");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isStateErrorMessageDisplayed("first blank"));
		newCustomer.clearTextInTextbox("state");
	}
	
	@Test
	public void TC_15_PinMustBeNumeric() {
		newCustomer.fillPIN("PIN34");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isPinErrorMessageDisplayed("numeric"));
		newCustomer.clearTextInTextbox("pin");
	}

	@Test
	public void TC_16_PinCanNotBeEmpty() {
		newCustomer.fillPIN("");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isPinErrorMessageDisplayed("blank"));
		newCustomer.clearTextInTextbox("pin");
	}

	@Test
	public void TC_17_PinMustHaveSixDigits() {
		newCustomer.fillPIN("12345");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isPinErrorMessageDisplayed("6 digits"));
		newCustomer.clearTextInTextbox("pin");
	}

	@Test
	public void TC_18_PinCanNotHaveSpecialChar() {
		newCustomer.fillPIN("!@#$");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isPinErrorMessageDisplayed("special character"));
		newCustomer.clearTextInTextbox("pin");
	}

	@Test
	public void TC_19_PinCanNotHaveFirstBlank() {
		newCustomer.fillPIN(" 1234");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isPinErrorMessageDisplayed("first blank"));
		newCustomer.clearTextInTextbox("pin");
	}

	@Test
	public void TC_20_PinCanNotHaveBlank() {
		newCustomer.fillPIN("12 4221");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isPinErrorMessageDisplayed("numeric"));
		newCustomer.clearTextInTextbox("pin");
	}

	@Test
	public void TC_21_PhoneCanNotBeEmpty() {
		newCustomer.fillMobileNumber("");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isPhoneErrorMessageDisplayed("blank"));
		newCustomer.clearTextInTextbox("mobile number");
	}
	
	@Test
	public void TC_22_PhoneCanNotHaveFirstBlank() {
		newCustomer.fillMobileNumber(" 0983119820");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isPhoneErrorMessageDisplayed("first blank"));
		newCustomer.clearTextInTextbox("mobile number");
	}
	
	@Test
	public void TC_23_PhoneCanNotHaveSpace() {
		newCustomer.fillMobileNumber("0983 11982");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isPhoneErrorMessageDisplayed("numeric"));
		newCustomer.clearTextInTextbox("mobile number");
	}
	
	@Test
	public void TC_24_PhoneCanNotHaveSpecialChar() {
		newCustomer.fillMobileNumber("@$!@");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isPhoneErrorMessageDisplayed("special character"));
		newCustomer.clearTextInTextbox("mobile number");
	}

	@Test
	public void TC_25_EmailCanNotBeEmpty() {
		newCustomer.fillEmail("");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isEmailErrorMessageDisplayed("blank"));
		newCustomer.clearTextInTextbox("email");
	}

	@Test
	public void TC_26_EmailCorretFormat() {
		newCustomer.fillEmail("guru99@gmail");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isEmailErrorMessageDisplayed("format"));
		newCustomer.clearTextInTextbox("email");
	}

	@Test
	public void TC_27_EmailCanNotHaveSpace() {
		newCustomer.fillEmail(" guru99@gmail.com");
		newCustomer.clickTab();
		Assert.assertTrue(newCustomer.isEmailErrorMessageDisplayed("format"));
		newCustomer.clearTextInTextbox("email");
	}
	
	@AfterClass
	public void afterTest() {
		driver.quit();
	}

}
