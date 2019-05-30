package com.bankguru.editcustomer;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.commons.AbstractTest;
import com.bankguru.commons.PageFactoryManager;
import com.bankguru.pageobjects.EditCustomerPageObjects;
import com.bankguru.pageobjects.HomePageObjects;
import com.bankguru.pageobjects.LoginPageObjects;

public class EditCustomerFormValidation extends AbstractTest {
	WebDriver driver;
	private EditCustomerPageObjects editCustomerPage;
	private LoginPageObjects loginPage;
	private HomePageObjects homePage;

	@Parameters("browser")
	@BeforeClass
	public void preCondition(String browser) {
		driver = openBrowser(browser);

		loginPage = PageFactoryManager.getLoginPage(driver);
		homePage = loginWithValidUser(loginPage);
		
		editCustomerPage = (EditCustomerPageObjects) homePage.openAnySubPage(driver, "Edit Customer");
	}

	@Test
	public void TC_01_CustomerIDCanNotBeNull() {
		editCustomerPage.fillCustomerID("");
		editCustomerPage.clickTab();
		Assert.assertTrue(editCustomerPage.isCustomerIDErrorMessageDisplayed("blank"));

	}

	@Test
	public void TC_02_CustomerIDMustBeNumeric() {
		editCustomerPage.fillCustomerID("Acc123");
		editCustomerPage.clickTab();
		Assert.assertTrue(editCustomerPage.isCustomerIDErrorMessageDisplayed("character"));

	}

	@Test
	public void TC_03_CustomerIDCanNotHaveSpecialCharacter() {
		editCustomerPage.fillCustomerID("123!@#");
		editCustomerPage.clickTab();
		Assert.assertTrue(editCustomerPage.isCustomerIDErrorMessageDisplayed("special character"));

	}

	@Test
	public void TC_04_CustomerIDCanNotHaveFirstBlank() {
		editCustomerPage.fillCustomerID(" 12412");
		editCustomerPage.clickTab();
		Assert.assertTrue(editCustomerPage.isCustomerIDErrorMessageDisplayed("first blank"));

	}

	@Test
	public void TC_05_ValidCustomerID() {
		editCustomerPage.fillCustomerID("56599");
		editCustomerPage.clickSubmitButton();
		Assert.assertTrue(editCustomerPage.isEditCustomerFormDisplayed());

	}

	@Test
	public void TC_08_AddressCanNotBeEmpty() {
		editCustomerPage.editAddress("");
		editCustomerPage.clickTab();
		Assert.assertTrue(editCustomerPage.isAddressErrorMessageDisplayed("blank"));
	}

	@Test
	public void TC_09_CityCanNotBeNull() {
		editCustomerPage.editCity("");
		editCustomerPage.clickTab();
		Assert.assertTrue(editCustomerPage.isCityErrorMessageDisplayed("blank"));

	}

	@Test
	public void TC_10_CityCanNotBeNumeric() {
		editCustomerPage.editCity("Acc123");
		editCustomerPage.clickTab();
		Assert.assertTrue(editCustomerPage.isCityErrorMessageDisplayed("character"));

	}

	@Test
	public void TC_11_CityCanNotHaveSpecialCharacter() {
		editCustomerPage.editCity("123!@#");
		editCustomerPage.clickTab();
		Assert.assertTrue(editCustomerPage.isCityErrorMessageDisplayed("special character"));

	}

	@Test
	public void TC_12_StateCanNotBeNull() {
		editCustomerPage.editState("");
		editCustomerPage.clickTab();
		Assert.assertTrue(editCustomerPage.isStateErrorMessageDisplayed("blank"));

	}

	@Test
	public void TC_13_StateCanNotBeNumeric() {
		editCustomerPage.editState("Acc123");
		editCustomerPage.clickTab();
		Assert.assertTrue(editCustomerPage.isStateErrorMessageDisplayed("character"));

	}

	@Test
	public void TC_14_StateCanNotHaveSpecialCharacter() {
		editCustomerPage.editState("123!@#");
		editCustomerPage.clickTab();
		Assert.assertTrue(editCustomerPage.isStateErrorMessageDisplayed("special character"));

	}

	@Test
	public void TC_15_PINMustBeNumeric() {
		editCustomerPage.editPIN("Acc123");
		editCustomerPage.clickTab();
		Assert.assertTrue(editCustomerPage.isPinErrorMessageDisplayed("numeric"));
	}

	@Test
	public void TC_16_PINCanNotBeNull() {
		editCustomerPage.editPIN("");
		editCustomerPage.clickTab();
		Assert.assertTrue(editCustomerPage.isPinErrorMessageDisplayed("blank"));
	}

	@Test
	public void TC_17_PINMustHaveSixDigit() {
		editCustomerPage.editPIN("123");
		editCustomerPage.clickTab();
		Assert.assertTrue(editCustomerPage.isPinErrorMessageDisplayed("6 digits"));
	}

	@Test
	public void TC_18_PINCanNotHaveSpecialChar() {
		editCustomerPage.editPIN("!@#");
		editCustomerPage.clickTab();
		Assert.assertTrue(editCustomerPage.isPinErrorMessageDisplayed("special character"));
	}

	@Test
	public void TC_19_PhoneCanNotBeNull() {
		editCustomerPage.editMobileNumber("");
		editCustomerPage.clickTab();
		Assert.assertTrue(editCustomerPage.isPhoneErrorMessageDisplayed("blank"));
	}

	@Test
	public void TC_20_PhoneCanNotHaveSpecialChar() {
		editCustomerPage.editMobileNumber("!@#");
		editCustomerPage.clickTab();
		Assert.assertTrue(editCustomerPage.isPhoneErrorMessageDisplayed("special character"));
	}

	@Test
	public void TC_21_EmailCanNotBeNull() {
		editCustomerPage.editEmail("");
		editCustomerPage.clickTab();
		Assert.assertTrue(editCustomerPage.isEmailErrorMessageDisplayed("blank"));
	}

	@Test
	public void TC_22_EmailFormat() {
		editCustomerPage.editEmail("guru99gmail.com");
		editCustomerPage.clickTab();
		Assert.assertTrue(editCustomerPage.isEmailErrorMessageDisplayed("format"));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
