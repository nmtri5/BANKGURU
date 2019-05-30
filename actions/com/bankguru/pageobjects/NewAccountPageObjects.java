package com.bankguru.pageobjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.bankguru.commons.AbstractPage;

import bankguru.NewAccountPageUI;

public class NewAccountPageObjects extends AbstractPage {
	WebDriver driver;

	public NewAccountPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void selectAccountType(String type) {
		waitForElementPresence(driver, NewAccountPageUI.ACCOUNT_TYPE_COMBOBOX);
		selectItemInHtmlDropdown(driver, NewAccountPageUI.ACCOUNT_TYPE_COMBOBOX, type);
	}

	public void inputCustomerID(String ID) {
		waitForElementPresence(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX, ID);
	}

	public void inputInitialDeposit(int amount) {
		waitForElementPresence(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
		sendKeyToElement(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX, String.valueOf(amount));
	}

	public void clickSubmitButton() {
		waitForElementPresence(driver, NewAccountPageUI.SUBMIT_BUTTON);
		clickToElement(driver, NewAccountPageUI.SUBMIT_BUTTON);
	}
	
	public boolean isAccountCreatedSuccess() {
		return isElementDisplayed(driver, NewAccountPageUI.NEW_ACCOUNT_CREATED_SUCCESS);
	}

	public boolean isCustomerIDMatch(String ID) {
		String locator = String.format(NewAccountPageUI.DYNAMIC_LOCATOR_NEW_ACCOUNT_SUCCESSFUL, "Customer ID");
		if (driver.findElement(By.xpath(locator)).getText().equals(ID)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isCustomerNameMatch(String name) {
		String locator = String.format(NewAccountPageUI.DYNAMIC_LOCATOR_NEW_ACCOUNT_SUCCESSFUL, "Customer Name");
		if (driver.findElement(By.xpath(locator)).getText().equals(name)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmailMatch(String email) {
		String locator = String.format(NewAccountPageUI.DYNAMIC_LOCATOR_NEW_ACCOUNT_SUCCESSFUL, "Email");
		if (driver.findElement(By.xpath(locator)).getText().equals(email)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isAccountTypeMatch(String type) {
		String locator = String.format(NewAccountPageUI.DYNAMIC_LOCATOR_NEW_ACCOUNT_SUCCESSFUL, "Account Type");
		if (driver.findElement(By.xpath(locator)).getText().equals(type)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isOpeningDateCorrect() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String locator = String.format(NewAccountPageUI.DYNAMIC_LOCATOR_NEW_ACCOUNT_SUCCESSFUL, "Date of Opening");
		if (driver.findElement(By.xpath(locator)).getText().equals(dateFormat.format(date))) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isCurrentAmountMatch(int amount) {
		String locator = String.format(NewAccountPageUI.DYNAMIC_LOCATOR_NEW_ACCOUNT_SUCCESSFUL, "Current Amount");
		if (driver.findElement(By.xpath(locator)).getText().equals(String.valueOf(amount))) {
			return true;
		} else {
			return false;
		}
	}

	public String getAccountNumber() {
		String locator = String.format(NewAccountPageUI.DYNAMIC_LOCATOR_NEW_ACCOUNT_SUCCESSFUL, "Account ID");
		return driver.findElement(By.xpath(locator)).getText();
	}

}
