package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bankguru.EditCustomerPageUI;
import bankguru.NewCustomerPageUI;
import commonFunctions.AbstractPage;

public class EditCustomerPageObjects extends AbstractPage {
	private WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public EditCustomerPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fillAddress(String address) {
		sendKeyToElement(driver, EditCustomerPageUI.ADDRESS_TEXTAREA, address);
	}

	public void fillCity(String city) {
		sendKeyToElement(driver, EditCustomerPageUI.CITY_TEXTBOX, city);
	}

	public void fillPIN(String pin) {
		sendKeyToElement(driver, EditCustomerPageUI.PIN_TEXTBOX, pin);
	}

	public void fillState(String state) {
		sendKeyToElement(driver, EditCustomerPageUI.STATE_TEXTBOX, state);
	}

	public void fillMobileNumber(String mobileNumber) {
		sendKeyToElement(driver, EditCustomerPageUI.MOBILE_TEXTBOX, mobileNumber);
	}

	public void fillEmail(String email) {
		sendKeyToElement(driver, EditCustomerPageUI.EMAIL_TEXTBOX, email);
	}

	public void clickSubmitButton() {
		clickToElement(driver, EditCustomerPageUI.SUBMIT_BUTTON);
	}
	
	public void clickConfirmButton() {
		clickToElement(driver, EditCustomerPageUI.CONFIRM_BUTTON);
	}

	public boolean isCustomerNameErrorMessageDisplayed(String option) {
		boolean a = false;
		switch(option) {
		case "blank" : a = driver.findElement(By.xpath(NewCustomerPageUI.NAME_NULL_ERROR_MESSAGE)).isDisplayed(); break;
		case "numeric" : a = driver.findElement(By.xpath(NewCustomerPageUI.NAME_NUMBER_ERROR_MESSAGE)).isDisplayed(); break;
		case "special character" : a = driver.findElement(By.xpath(NewCustomerPageUI.NAME_SPECIAL_CHAR_ERROR_MESSAGE)).isDisplayed(); break;
		case "first blank" : a = driver.findElement(By.xpath(NewCustomerPageUI.NAME_FIRST_BLANK_ERROR_MESSAGE)).isDisplayed(); break;		            
	}
		return a;
	}

	public void clickTabToElement() {
		sendKeyboardToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, Keys.TAB);
		
	}

	public void clearTextInTextbox(String textbox) {
		switch(textbox) {
		case "customer name": clearText(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX); break;
		case "address": clearText(driver, NewCustomerPageUI.ADDRESS_TEXTBOX); break; 
		case "city": clearText(driver, NewCustomerPageUI.CITY_TEXTBOX); break;
		case "state": clearText(driver, NewCustomerPageUI.STATE_TEXTBOX); break;
		case "pin": clearText(driver, NewCustomerPageUI.PIN_TEXTBOX); break;
		case "mobile number": clearText(driver, NewCustomerPageUI.MOBILE_TEXTBOX); break;
		case "email": clearText(driver, NewCustomerPageUI.EMAIL_TEXTBOX); break;
		case "password": clearText(driver, NewCustomerPageUI.PASSWORD_TEXTBOX); break;
		}
	}
}
