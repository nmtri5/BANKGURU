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
		
		log.info("Pre-condition - Step 01: Login with a valid username");
		homePage = loginWithValidUser(loginPage);
		
		log.info("Pre-condition - Step 02: Open New Customer page");
		newCustomer = (NewCustomerPageObject) homePage.openAnySubPage(driver, "New Customer");
	}

	@Test
	public void TC_01_NameCanNotBeEmpty() {
		log.info("Customer Name Can Not Be Null - Step 01: Fill in Customer Name with null value");
		newCustomer.fillCustomerName("");
		
		log.info("Customer Name Can Not Be Null - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("Customer Name Can Not Be Null - Step 03: Check if the blank error message displayed");
		verifyTrue(newCustomer.isCustomerNameErrorMessageDisplayed("blank"));
	}

	@Test
	public void TC_02_NameCanNotBeNumeric() {
		log.info("Customer Name Can Not Be Numeric - Step 01: Fill in Customer Name with numeric value");
		newCustomer.fillCustomerName("1231");
		
		log.info("Customer Name Can Not Be Numeric - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("Customer Name Can Not Be Numeric - Step 03: Check if the numeric error message displayed");
		verifyTrue(newCustomer.isCustomerNameErrorMessageDisplayed("numeric"));
		
		log.info("Customer Name Can Not Be Numeric - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("customer name");
	}

	@Test
	public void TC_03_NameCanNotBeSpecialCharacter() {
		log.info("Customer Name Can Not Be Special characters - Step 01: Fill in Customer Name with special characters");
		newCustomer.fillCustomerName("!@#");
		
		log.info("Customer Name Can Not Be Special characters - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("Customer Name Can Not Be Special characters - Step 03: Check if the special character error message displayed");
		verifyTrue(newCustomer.isCustomerNameErrorMessageDisplayed("special character"));
		
		log.info("Customer Name Can Not Be Special characters - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("customer name");

	}

	@Test
	public void TC_04_NameCanNotBeFirstBlank() {
		log.info("Customer Name Can Not have first blank - Step 01: Fill in Customer Name with first blank");
		newCustomer.fillCustomerName(" test");
		
		log.info("Customer Name Can Not have first blank - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("Customer Name Can Not have first blank - Step 03: Check if the first blank error message displayed");
		verifyTrue(newCustomer.isCustomerNameErrorMessageDisplayed("first blank"));
		
		log.info("Customer Name Can Not have first blank - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("customer name");
	}
	
	@Test
	public void TC_05_AddressCanNotBeEmpty() {
		log.info("Address Can Not have be empty - Step 01: Fill in Address with null value");
		newCustomer.fillAddress("");
		
		log.info("Address Can Not have be empty - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("Address Can Not have be empty - Step 03: Check if the blank error message displayed");
		verifyTrue(newCustomer.isAddressErrorMessageDisplayed("blank"));
		
		log.info("Address Can Not have be empty - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("address");
	}

	@Test
	public void TC_06_AddressCanNotHaveFirstBlank() {
		log.info("Address Can Not have first blank - Step 01: Fill in Address with first blank value");
		newCustomer.fillAddress(" The White House");
		
		log.info("Address Can Not have first blank - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("Address Can Not have first blank - Step 03: Check if the first blank error message displayed");
		verifyTrue(newCustomer.isAddressErrorMessageDisplayed("first blank"));
		
		log.info("Address Can Not have first blank - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("address");
	}
	
	@Test
	public void TC_07_CityCanNotBeEmpty() {
		log.info("City Can Not be empty - Step 01: Fill in City with null value");
		newCustomer.fillCity("");
		
		log.info("City Can Not be empty - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("City Can Not be empty- Step 03: Check if the blank error message displayed");
		verifyTrue(newCustomer.isCityMessageErrorDisplayed("blank"));
		
		log.info("City Can Not Be empty - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("city");
	}

	@Test
	public void TC_08_CityCanNotBeNumeric() {
		log.info("City Can Not Be Numeric - Step 01: Fill in City with numeric value");
		newCustomer.fillCity("12314");
		
		log.info("City Can Not Be Numeric - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("City Can Not Be Numeric - Step 03: Check if the numeric error message displayed");
		verifyTrue(newCustomer.isCityMessageErrorDisplayed("numeric"));
		
		log.info("City Can Not Be Numeric - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("city");
	}

	@Test
	public void TC_09_CityCanNotHaveSpecialChar() {
		log.info("City Can Not Have Special Characters - Step 01: Fill in City with special character");
		newCustomer.fillCity("@$!@");
		
		log.info("City Can Not Have Special Characters - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("City Can Not Have Special Characters - Step 03: Check if the special character error message displayed");
		verifyTrue(newCustomer.isCityMessageErrorDisplayed("special character"));
		
		log.info("City Can Not Have Special Characters - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("city");
	}

	@Test
	public void TC_10_CityCanNotHaveFirstBlank() {
		log.info("City Can Not Have first blank - Step 01: Fill in City with first blank value");
		newCustomer.fillCity(" Saigon");
		
		log.info("City Can Not Have first blank - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("City Can Not Have first blank - Step 03: Check if the first blank error message displayed");
		verifyTrue(newCustomer.isCityMessageErrorDisplayed("first blank"));
		
		log.info("City Can Not Have first blank - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("city");
	}
	
	@Test
	public void TC_11_StateCanNotBeEmpty() {
		log.info("State Can Not Have first blank - Step 01: Fill in State with null value");
		newCustomer.fillState("");
		
		log.info("State Can Not Have first blank - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("State Can Not Have first blank - Step 03: Check if the blank error message displayed");
		verifyTrue(newCustomer.isStateErrorMessageDisplayed("blank"));
		
		log.info("State Can Not Have first blank - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("state");
	}
	
	@Test
	public void TC_12_StateCanNotBeNumeric() {
		log.info("State Can Not Be numeric - Step 01: Fill in State with numeric value");
		newCustomer.fillState("State1234");
		
		log.info("State Can Not Be numeric- Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("State Can Not Be numeric - Step 03: Check if the numeric error message displayed");
		verifyTrue(newCustomer.isStateErrorMessageDisplayed("numeric"));
		
		log.info("State Can Not Be numeric - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("state");
	}

	@Test
	public void TC_13_StateCanNotHaveSpecialChar() {
		log.info("State Can Not Have special characters - Step 01: Fill in State with special character value");
		newCustomer.fillState("@$!@");
		
		log.info("State Can Not Have special characters- Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("State Can Not Have special characters - Step 03: Check if the special character error message displayed");
		verifyTrue(newCustomer.isStateErrorMessageDisplayed("special character"));
		
		log.info("State Can Not Have special characters - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("state");
	}

	@Test
	public void TC_14_StateCanNotHaveFirstBlank() {
		log.info("State Can Not Have first blank - Step 01: Fill in State with first blank value");
		newCustomer.fillState(" Thu Duc");
		
		log.info("State Can Not Have first blank - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("State Can Not Have first blank - Step 03: Check if the first blank error message displayed");
		verifyTrue(newCustomer.isStateErrorMessageDisplayed("first blank"));
		
		log.info("State Can Not Have first blank - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("state");
	}
	
	@Test
	public void TC_15_PinMustBeNumeric() {
		log.info("Pin Can Not Be numeric - Step 01: Fill in Pin with numeric value");
		newCustomer.fillPIN("PIN34");
		
		log.info("Pin Can Not Be numeric - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("Pin Can Not Be numeric - Step 03: Check if the numeric error message displayed");
		verifyTrue(newCustomer.isPinErrorMessageDisplayed("numeric"));
		
		log.info("Pin Can Not Be numeric - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("pin");
	}

	@Test
	public void TC_16_PinCanNotBeEmpty() {
		log.info("Pin Can Not Be Empty - Step 01: Fill in Pin with null value");
		newCustomer.fillPIN("");
		
		log.info("Pin Can Not Be Empty - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("Pin Can Not Be Empty - Step 03: Check if the blank error message displayed");
		verifyTrue(newCustomer.isPinErrorMessageDisplayed("blank"));
		
		log.info("Pin Can Not Be Empty - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("pin");
	}

	@Test
	public void TC_17_PinMustHaveSixDigits() {
		log.info("Pin Must have 6 digits - Step 01: Fill in Pin with less than 6 digits value");
		newCustomer.fillPIN("12345");
		
		log.info("Pin Must have 6 digit - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("Pin Must have 6 digit - Step 03: Check if the 6 digits error message displayed");
		verifyTrue(newCustomer.isPinErrorMessageDisplayed("6 digits"));
		
		log.info("Pin Must have 6 digit - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("pin");
	}

	@Test
	public void TC_18_PinCanNotHaveSpecialChar() {
		log.info("Pin Can Not Have Special Characters - Step 01: Fill in Pin with special characters");
		newCustomer.fillPIN("!@#$");
		
		log.info("Pin Can Not Have Special Characters - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("Pin Can Not Have Special Characters - Step 03: Check if the special character error message displayed");
		verifyTrue(newCustomer.isPinErrorMessageDisplayed("special character"));
		
		log.info("Pin Can Not Have Special Characters - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("pin");
	}

	@Test
	public void TC_19_PinCanNotHaveFirstBlank() {
		log.info("Pin Can Not Have First Blank - Step 01: Fill in Pin with first blank value");
		newCustomer.fillPIN(" 1234");
		
		log.info("Pin Can Not Have First Blank - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("Pin Can Not Have First Blank - Step 03: Check if the first blank error message displayed");
		verifyTrue(newCustomer.isPinErrorMessageDisplayed("first blank"));
		
		log.info("Pin Can Not Have First Blank - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("pin");
	}

	@Test
	public void TC_20_PinCanNotHaveBlank() {
		log.info("Pin Can Not Have Blank - Step 01: Fill in Pin with blank value");
		newCustomer.fillPIN("12 4221");
		
		log.info("Pin Can Not Have Blank - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("Pin Can Not Have Blank - Step 03: Check if the blank error message displayed");
		verifyTrue(newCustomer.isPinErrorMessageDisplayed("numeric"));
		
		log.info("Pin Can Not Have Blank - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("pin");
	}

	@Test
	public void TC_21_PhoneCanNotBeEmpty() {
		log.info("Phone Can Not Have Blank - Step 01: Fill in Phone with null value");
		newCustomer.fillMobileNumber("");
		
		log.info("Phone Can Not Have Blank - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("Phone Can Not Have Blank - Step 03: Check if the null error message displayed");
		verifyTrue(newCustomer.isPhoneErrorMessageDisplayed("blank"));
		
		log.info("Phone Can Not Have Blank - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("mobile number");
	}
	
	@Test
	public void TC_22_PhoneCanNotHaveFirstBlank() {
		log.info("Phone Can Not Have First Blank - Step 01: Fill in Phone with first blank value");
		newCustomer.fillMobileNumber(" 0983119820");
		
		log.info("Phone Can Not Have First Blank - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("Phone Can Not Have First Blank - Step 03: Check if the first blank error message displayed");
		verifyTrue(newCustomer.isPhoneErrorMessageDisplayed("first blank"));
		
		log.info("Phone Can Not Have First Blank - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("mobile number");
	}
	
	@Test
	public void TC_23_PhoneCanNotHaveSpace() {
		log.info("Phone Can Not Have Space - Step 01: Fill in Phone with space value");
		newCustomer.fillMobileNumber("0983 11982");
		
		log.info("Phone Can Not Have Space - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("Phone Can Not Have Space - Step 03: Check if the space error message displayed");
		verifyTrue(newCustomer.isPhoneErrorMessageDisplayed("numeric"));
		
		log.info("Phone Can Not Have Space - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("mobile number");
	}
	
	@Test
	public void TC_24_PhoneCanNotHaveSpecialChar() {
		log.info("Phone Can Not Have special character - Step 01: Fill in Phone with special character");
		newCustomer.fillMobileNumber("@$!@");
		
		log.info("Phone Can Not Have special character - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("Phone Can Not Have special character - Step 03: Check if the special character error message displayed");
		verifyTrue(newCustomer.isPhoneErrorMessageDisplayed("special character"));
		
		log.info("Phone Can Not Have special character - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("mobile number");
	}

	@Test
	public void TC_25_EmailCanNotBeEmpty() {
		log.info("Email Can Not Be Empty - Step 01: Fill in Email with null value");
		newCustomer.fillEmail("");
		
		log.info("Email Can Not Be Empty - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("Email Can Not Be Empty - Step 03: Check if the blank error message displayed");
		verifyTrue(newCustomer.isEmailErrorMessageDisplayed("blank"));
		
		log.info("Email Can Not Be Empty - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("email");
	}

	@Test
	public void TC_26_EmailCorretFormat() {
		log.info("Email Must Be in Correct format - Step 01: Fill in Email with incorrect format value");
		newCustomer.fillEmail("guru99@gmail");
		
		log.info("Email Must Be in Correct format - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("Email Must Be in Correct format - Step 03: Check if the format error message displayed");
		verifyTrue(newCustomer.isEmailErrorMessageDisplayed("format"));
		
		log.info("Email Must Be in Correct format - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("email");
	}

	@Test
	public void TC_27_EmailCanNotHaveSpace() {
		log.info("Email Can not have space - Step 01: Fill in Email with space value");
		newCustomer.fillEmail(" guru99@gmail.com");
		
		log.info("Email Can not have space - Step 02: Click Tab");
		newCustomer.clickTab();
		
		log.info("Email Can not have space - Step 03: Check if the space error message displayed");
		verifyTrue(newCustomer.isEmailErrorMessageDisplayed("format"));
		
		log.info("Email Can not have space - Step 04: Clearing text in textbox");
		newCustomer.clearTextInTextbox("email");
	}
	
	@AfterClass
	public void afterTest() {
		driver.quit();
	}

}
