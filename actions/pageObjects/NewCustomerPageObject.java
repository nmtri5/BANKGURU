package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bankguru.NewCustomerPageUI;
import commonFunctions.AbstractPage;

public class NewCustomerPageObject extends AbstractPage {
	private WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public NewCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void fillCustomerName(String customerName) {
		sendKeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, customerName);
	}

	public void checkToGenderRadioBox(String gender) {
		switch (gender) {
		case "male":
			checkToRadioBox(NewCustomerPageUI.GENDER_RADIO_MALE);
			break;
		case "female":
			checkToRadioBox(NewCustomerPageUI.GENDER_RADIO_FEMALE);
			break;
		}
	}

	public void fillDOB(String dob) {
		removeAttributeInDOM(driver, NewCustomerPageUI.DOB_TEXTBOX, "type");
		sendKeyToElement(driver, NewCustomerPageUI.DOB_TEXTBOX, dob);
	}

	public void fillAddress(String address) {
		sendKeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXTBOX, address);
	}

	public void fillCity(String city) {
		sendKeyToElement(driver, NewCustomerPageUI.CITY_TEXTBOX, city);
	}

	public void fillPIN(String pin) {
		sendKeyToElement(driver, NewCustomerPageUI.PIN_TEXTBOX, pin);
	}

	public void fillState(String state) {
		sendKeyToElement(driver, NewCustomerPageUI.STATE_TEXTBOX, state);
	}

	public void fillMobileNumber(String mobileNumber) {
		sendKeyToElement(driver, NewCustomerPageUI.MOBILE_TEXTBOX, mobileNumber);
	}

	public void fillEmail(String email) {
		sendKeyToElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX, email);
	}

	public void fillPassword(String password) {
		sendKeyToElement(driver, NewCustomerPageUI.PASSWORD_TEXTBOX, password);
	}

	public void checkToRadioBox(String option) {
		WebElement gender = driver.findElement(By.xpath(option));
		if (gender.isDisplayed()) {
			gender.click();
		} else {
			js.executeScript("arguments[0].click();", gender);
		}
	}

	public void clickSubmitButton() {
		clickToElement(driver, NewCustomerPageUI.SUBMIT_BUTTON);
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
