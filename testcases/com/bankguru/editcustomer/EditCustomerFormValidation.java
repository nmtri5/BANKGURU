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

		log.info("Pre-condition - Step 01: Login with a valid username");
		homePage = loginWithValidUser(loginPage);

		log.info("Pre-condition - Step 02: Open Edit Customer page");
		editCustomerPage = (EditCustomerPageObjects) homePage.openAnySubPage(driver, "Edit Customer");
	}

	@Test
	public void TC_01_CustomerIDCanNotBeNull() {
		log.info("Customer ID Can Not Be Null - Step 01: Fill in Customer ID with null value");
		editCustomerPage.fillCustomerID("");

		log.info("Customer ID Can Not Be Null - Step 02: Click Tab");
		editCustomerPage.clickTab();

		log.info("Customer ID Can Not Be Null - Step 03: Check if the blank error message displayed");
		verifyTrue(editCustomerPage.isCustomerIDErrorMessageDisplayed("blank"));
	}

	@Test
	public void TC_02_CustomerIDMustBeNumeric() {
		log.info("Customer ID Must be numeric - Step 01: Fill in Customer ID with numeric value");
		editCustomerPage.fillCustomerID("Acc123");

		log.info("Customer ID Must be numeric - Step 02: Click Tab");
		editCustomerPage.clickTab();

		log.info("Customer ID Must be numeric - Step 03: Check if the character error message displayed");
		verifyTrue(editCustomerPage.isCustomerIDErrorMessageDisplayed("character"));
	}

	@Test
	public void TC_03_CustomerIDCanNotHaveSpecialCharacter() {
		log.info("Customer ID Can Not have special character - Step 01: Fill in Customer ID with special characters");
		editCustomerPage.fillCustomerID("123!@#");

		log.info("Customer ID Can Not have special character - Step 02: Click Tab");
		editCustomerPage.clickTab();

		log.info(
				"Customer ID Can Not have special character - Step 03: Check if the special character error message displayed");
		verifyTrue(editCustomerPage.isCustomerIDErrorMessageDisplayed("special character"));

	}

	@Test
	public void TC_04_CustomerIDCanNotHaveFirstBlank() {
		log.info("Customer ID Can Not have first blank - Step 01: Fill in Customer ID with first blank");
		editCustomerPage.fillCustomerID(" 12412");

		log.info("Customer ID Can Not have first blank - Step 02: Click Tab");
		editCustomerPage.clickTab();

		log.info("Customer ID Can Not have first blank - Step 03: Check if the first blank error message displayed");
		verifyTrue(editCustomerPage.isCustomerIDErrorMessageDisplayed("first blank"));

	}

	@Test
	public void TC_05_ValidCustomerID() {
		log.info("Valid Customer ID - Step 01: Fill in valid Customer ID");
		editCustomerPage.fillCustomerID("56599");

		log.info("Valid Customer ID - Step 02: Click Submit button");
		editCustomerPage.clickSubmitButton();

		log.info("Valid Customer ID - Step 03: Check if the Edit Customer form display");
		verifyTrue(editCustomerPage.isEditCustomerFormDisplayed());
	}

	@Test
	public void TC_08_AddressCanNotBeEmpty() {
		log.info("Address can not be empty - Step 01: Fill in empty address");
		editCustomerPage.editAddress("");

		log.info("Address can not be empty - Step 02: Click Tab");
		editCustomerPage.clickTab();

		log.info("Address can not be empty - Step 03: Check if the blank error message display");
		verifyTrue(editCustomerPage.isAddressErrorMessageDisplayed("blank"));
	}

	@Test
	public void TC_09_CityCanNotBeNull() {
		log.info("City can not be empty - Step 01: Fill in empty city");
		editCustomerPage.editCity("");

		log.info("City can not be empty - Step 02: Click Tab");
		editCustomerPage.clickTab();

		log.info("City can not be empty - Step 03: Check if the blank error message display");
		verifyTrue(editCustomerPage.isCityErrorMessageDisplayed("blank"));

	}

	@Test
	public void TC_10_CityCanNotBeNumeric() {
		log.info("City can not be numberic - Step 01: Fill in city with numeric value");
		editCustomerPage.editCity("Acc123");

		log.info("City can not be numberic - Step 02: Click Tab");
		editCustomerPage.clickTab();

		log.info("City can not be numberic - Step 03: Check if the character error message display");
		verifyTrue(editCustomerPage.isCityErrorMessageDisplayed("character"));

	}

	@Test
	public void TC_11_CityCanNotHaveSpecialCharacter() {
		log.info("City can not have special characters - Step 01: Fill in city with special characters");
		editCustomerPage.editCity("123!@#");

		log.info("City can not have special characters - Step 02: Click Tab");
		editCustomerPage.clickTab();

		log.info(
				"City can not have special characters - Step 03: Check if the special character error message display");
		verifyTrue(editCustomerPage.isCityErrorMessageDisplayed("special character"));
	}

	@Test
	public void TC_12_StateCanNotBeNull() {
		log.info("State can not be null - Step 01: Fill in empty state");
		editCustomerPage.editState("");

		log.info("State can not be null - Step 02: Click Tab");
		editCustomerPage.clickTab();

		log.info("State can not be null - Step 03: Check if the blank error message display");
		verifyTrue(editCustomerPage.isStateErrorMessageDisplayed("blank"));
	}

	@Test
	public void TC_13_StateCanNotBeNumeric() {
		log.info("State can not be numeric - Step 01: Fill in state with numeric value");
		editCustomerPage.editState("Acc123");

		log.info("State can not be null - Step 02: Click Tab");
		editCustomerPage.clickTab();

		log.info("State can not be null - Step 03: Check if the numeric error message display");
		verifyTrue(editCustomerPage.isStateErrorMessageDisplayed("numeric"));
	}

	@Test
	public void TC_14_StateCanNotHaveSpecialCharacter() {
		log.info("State can not have special characters - Step 01: Fill in state with special characters");
		editCustomerPage.editState("123!@#");

		log.info("State can not have special characters - Step 02: Click Tab");
		editCustomerPage.clickTab();

		log.info(
				"State can not have special characters - Step 03: Check if the special character error message display");
		verifyTrue(editCustomerPage.isStateErrorMessageDisplayed("special character"));

	}

	@Test
	public void TC_15_PINMustBeNumeric() {
		log.info("PIN can not be numeric - Step 01: Fill in PIN with character");
		editCustomerPage.editPIN("Acc123");

		log.info("PIN can not be numeric - Step 02: Click Tab");
		editCustomerPage.clickTab();

		log.info("PIN can not be numeric - Step 03: Check if the character error message display");
		verifyTrue(editCustomerPage.isPinErrorMessageDisplayed("character"));
	}

	@Test
	public void TC_16_PINCanNotBeNull() {
		log.info("PIN can not be null - Step 01: Fill in empty PIN");
		editCustomerPage.editPIN("");

		log.info("PIN can not be null - Step 02: Click Tab");
		editCustomerPage.clickTab();

		log.info("PIN can not be null - Step 03: Check if the blank error message display");
		verifyTrue(editCustomerPage.isPinErrorMessageDisplayed("blank"));
	}

	@Test
	public void TC_17_PINMustHaveSixDigit() {
		log.info("PIN must have 6 digits - Step 01: Fill in PIN with less than 6 digits");
		editCustomerPage.editPIN("123");

		log.info("PIN must have 6 digits - Step 02: Click Tab");
		editCustomerPage.clickTab();

		log.info("PIN must have 6 digits - Step 03: Check if the 6 digits error message display");
		verifyTrue(editCustomerPage.isPinErrorMessageDisplayed("6 digits"));
	}

	@Test
	public void TC_18_PINCanNotHaveSpecialChar() {
		log.info("PIN can not have special characters - Step 01: Fill in PIN with special characters");
		editCustomerPage.editPIN("!@#");

		log.info("PIN can not have special characters - Step 02: Click Tab");
		editCustomerPage.clickTab();

		log.info("PIN can not have special characters - Step 03: Check if the special character error message display");
		verifyTrue(editCustomerPage.isPinErrorMessageDisplayed("special character"));
	}

	@Test
	public void TC_19_PhoneCanNotBeNull() {
		log.info("Phone can not be null - Step 01: Fill in empty phone");
		editCustomerPage.editMobileNumber("");

		log.info("Phone can not be null - Step 02: Click Tab");
		editCustomerPage.clickTab();

		log.info("Phone can not be null - Step 03: Check if the blank error message display");
		verifyTrue(editCustomerPage.isPhoneErrorMessageDisplayed("blank"));
	}

	@Test
	public void TC_20_PhoneCanNotHaveSpecialChar() {
		log.info("Phone can have special characters - Step 01: Fill in Phone with special characters");
		editCustomerPage.editMobileNumber("!@#");

		log.info("Phone can have special characters - Step 02: Click Tab");
		editCustomerPage.clickTab();

		log.info("Phone can have special characters - Step 03: Check if the special character error message display");
		verifyTrue(editCustomerPage.isPhoneErrorMessageDisplayed("special character"));
	}

	@Test
	public void TC_21_EmailCanNotBeNull() {
		log.info("Email can not be null - Step 01: Fill in empty Email");
		editCustomerPage.editEmail("");

		log.info("Email can not be null - Step 02: Click Tab");
		editCustomerPage.clickTab();

		log.info("Email can not be null - Step 03: Check if the blank error message display");
		verifyTrue(editCustomerPage.isEmailErrorMessageDisplayed("blank"));
	}

	@Test
	public void TC_22_EmailFormat() {
		log.info("Email format - Step 01: Fill in wrong formatted Email");
		editCustomerPage.editEmail("guru99gmail.com");

		log.info("Email format - Step 02: Click Tab");
		editCustomerPage.clickTab();

		log.info("Email format - Step 03: Check if the format error message display");
		verifyTrue(editCustomerPage.isEmailErrorMessageDisplayed("format"));
		System.out.println("Check");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowserAndDriver(driver);
	}
}
