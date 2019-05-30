package com.bankguru.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import bankguru.EditCustomerPageUI;
import bankguru.HomePageUI;
import bankguru.NewCustomerPageUI;
import com.bankguru.commons.AbstractPage;
import com.bankguru.commons.PageFactoryManager;

public class EditCustomerPageObjects extends AbstractPage {
	private WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public EditCustomerPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fillCustomerID(String ID) {
		waitForElementPresence(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		clearTextInTextbox("customer id");
		sendKeyToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, ID);
	}

	public void editAddress(String address) {
		waitForElementPresence(driver, EditCustomerPageUI.ADDRESS_TEXTAREA);
		clearTextInTextbox("address");
		sendKeyToElement(driver, EditCustomerPageUI.ADDRESS_TEXTAREA, address);
	}
	
	public void editCity(String city) {
		waitForElementPresence(driver, EditCustomerPageUI.CITY_TEXTBOX);
		clearTextInTextbox("city");
		sendKeyToElement(driver, EditCustomerPageUI.CITY_TEXTBOX, city);
	}

	public void editState(String state) {
		waitForElementPresence(driver, EditCustomerPageUI.STATE_TEXTBOX);
		clearTextInTextbox("state");
		sendKeyToElement(driver, EditCustomerPageUI.STATE_TEXTBOX, state);
	}
	
	public void editPIN(String pin) {
		waitForElementPresence(driver, EditCustomerPageUI.PIN_TEXTBOX);
		clearTextInTextbox("pin");
		sendKeyToElement(driver, EditCustomerPageUI.PIN_TEXTBOX, pin);
	}

	public void editMobileNumber(String mobileNumber) {
		waitForElementPresence(driver, EditCustomerPageUI.MOBILE_TEXTBOX);
		clearTextInTextbox("mobile number");
		sendKeyToElement(driver, EditCustomerPageUI.MOBILE_TEXTBOX, mobileNumber);
	}

	public void editEmail(String email) {
		waitForElementPresence(driver, EditCustomerPageUI.EMAIL_TEXTBOX);
		clearTextInTextbox("email");
		sendKeyToElement(driver, EditCustomerPageUI.EMAIL_TEXTBOX, email);
	}

	public void clickSubmitButton() {
		waitForElementPresence(driver, EditCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(driver, EditCustomerPageUI.SUBMIT_BUTTON);
	}

	public boolean isAddressMatch(String addres) {
		if(driver.findElement(By.xpath(EditCustomerPageUI.VERIFY_ADDRESS)).getText().contains(addres)) {
			return true;
		} else {
			return false;
		} 
	}
	
	public boolean isCityMatch(String city) {
		if(driver.findElement(By.xpath(EditCustomerPageUI.VERIFY_CITY)).getText().contains(city)) {
			return true;
		} else {
			return false;
		} 
	}
	
	public boolean isStateMatch(String state) {
		if(driver.findElement(By.xpath(EditCustomerPageUI.VERIFY_STATE)).getText().contains(state)) {
			return true;
		} else {
			return false;
		} 
	}
	
	public boolean isPinMatch(String pin) {
		if(driver.findElement(By.xpath(EditCustomerPageUI.VERIFY_PIN)).getText().contains(pin)) {
			return true;
		} else {
			return false;
		} 
	}
	
	public boolean isMobileNumberMatch(String number) {
		if(driver.findElement(By.xpath(EditCustomerPageUI.VERIFY_MOBILE)).getText().contains(number)) {
			return true;
		} else {
			return false;
		} 
	}

	public boolean isEmailMatch(String email) {
		if(driver.findElement(By.xpath(EditCustomerPageUI.VERIFY_EMAIL)).getText().contains(email)) {
			return true;
		} else {
			return false;
		} 
	}
	
	public boolean isCustomerIDErrorMessageDisplayed(String option) {
		boolean a = false;
		switch(option) {
		case "blank" : a = driver.findElement(By.xpath(EditCustomerPageUI.ID_NULL_ERROR_MESSAGE)).isDisplayed(); break;
		case "character" : a = driver.findElement(By.xpath(EditCustomerPageUI.ID_CHARACTER_ERROR_MESSAGE)).isDisplayed(); break;
		case "special character" : a = driver.findElement(By.xpath(EditCustomerPageUI.ID_SPECIAL_CHAR_ERROR_MESSAGE)).isDisplayed(); break;
		case "first blank" : a = driver.findElement(By.xpath(EditCustomerPageUI.ID_FIRST_CHAR_BLANK_ERROR_MESSAGE)).isDisplayed(); break;		            
	}
		return a;
	}

	public boolean isEditCustomerFormLoadedSuccessful() {
		return isElementDisplayed(driver, EditCustomerPageUI.SUCCESS_FORM);
	}

	public boolean isAddressErrorMessageDisplayed(String option) {
		boolean a = false;
		switch(option) {
		case "blank" : a = driver.findElement(By.xpath(EditCustomerPageUI.ADDRESS_BLANK_ERROR)).isDisplayed(); break;
	}
		return a;
	}

	public boolean isCityErrorMessageDisplayed(String option) {
		boolean a = false;
		switch(option) {
		case "blank" : a = driver.findElement(By.xpath(EditCustomerPageUI.CITY_BLANK_ERROR)).isDisplayed(); break;
		case "character" : a = driver.findElement(By.xpath(EditCustomerPageUI.CITY_NUMERIC_ERROR)).isDisplayed(); break;
		case "special character" : a = driver.findElement(By.xpath(EditCustomerPageUI.CITY_SPECIAL_CHAR_ERROR)).isDisplayed(); break;
	}
		return a;
	}

	public boolean isStateErrorMessageDisplayed(String option) {
		boolean a = false;
		switch(option) {
		case "blank" : a = driver.findElement(By.xpath(EditCustomerPageUI.STATE_BLANK_ERROR)).isDisplayed(); break;
		case "character" : a = driver.findElement(By.xpath(EditCustomerPageUI.STATE_NUMERIC_ERROR)).isDisplayed(); break;
		case "special character" : a = driver.findElement(By.xpath(EditCustomerPageUI.STATE_SPECIAL_CHAR_ERROR)).isDisplayed(); break;
	}
		return a;
	}

	public boolean isPinErrorMessageDisplayed(String option) {
		boolean a = false;
		switch(option) {
		case "blank" : a = driver.findElement(By.xpath(EditCustomerPageUI.PIN_BLANK_ERROR)).isDisplayed(); break;
		case "numeric" : a = driver.findElement(By.xpath(EditCustomerPageUI.PIN_CHAR_ERROR)).isDisplayed(); break;
		case "special character" : a = driver.findElement(By.xpath(EditCustomerPageUI.PIN_SPECIAL_CHAR_ERROR)).isDisplayed(); break;
		case "6 digits" : a = driver.findElement(By.xpath(EditCustomerPageUI.PIN_SIX_DIGIT_ERROR)).isDisplayed(); break;
	}
		return a;
	}

	public boolean isPhoneErrorMessageDisplayed(String option) {
		boolean a = false;
		switch(option) {
		case "blank" : a = driver.findElement(By.xpath(EditCustomerPageUI.PHONE_BLANK_ERROR)).isDisplayed(); break;
		case "special character" : a = driver.findElement(By.xpath(EditCustomerPageUI.PHONE_SPECIAL_CHAR_ERROR)).isDisplayed(); break;
	}
		return a;
	}

	public boolean isEmailErrorMessageDisplayed(String option) {
		boolean a = false;
		switch(option) {
		case "blank" : a = driver.findElement(By.xpath(EditCustomerPageUI.EMAIL_BLANK_ERROR)).isDisplayed(); break;
		case "format" : a = driver.findElement(By.xpath(EditCustomerPageUI.EMAIL_FORMAT_ERROR)).isDisplayed(); break;
	}
		return a;
	}
	
	public void clickTab() {
		clickOnKeyBoard(driver, Keys.TAB);
	}

	public void clearTextInTextbox(String textbox) {
		switch(textbox) {
		case "customer id": clearText(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX); break; 
		case "address": clearText(driver, EditCustomerPageUI.ADDRESS_TEXTAREA); break; 
		case "city": clearText(driver, EditCustomerPageUI.CITY_TEXTBOX); break;
		case "state": clearText(driver, EditCustomerPageUI.STATE_TEXTBOX); break;
		case "pin": clearText(driver, EditCustomerPageUI.PIN_TEXTBOX); break;
		case "mobile number": clearText(driver, EditCustomerPageUI.MOBILE_TEXTBOX); break;
		case "email": clearText(driver, EditCustomerPageUI.EMAIL_TEXTBOX); break;
		}
	}

	public void clickConfirmButton() {
		waitForElementPresence(driver, EditCustomerPageUI.CONFIRM_BUTTON);
		clickToElement(driver, EditCustomerPageUI.CONFIRM_BUTTON);
	}
}
