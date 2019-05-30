package com.bankguru.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bankguru.commons.AbstractPage;

import bankguru.DepositPageUI;

public class DepositPageObjects extends AbstractPage{
	private WebDriver driver;

	public DepositPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isAccountNumberCorrect(String accountNo) {
		waitForElementVisible(driver, DepositPageUI.DYNAMIC_LOCATOR_TRANSACTION_SUCCESSFUL_FORM, "Account No");
		String locator = String.format(DepositPageUI.DYNAMIC_LOCATOR_TRANSACTION_SUCCESSFUL_FORM, "Account No");
		if (driver.findElement(By.xpath(locator)).getText().equals(accountNo)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isAmountCreditedCorrect(int amount) {
		waitForElementVisible(driver, DepositPageUI.DYNAMIC_LOCATOR_TRANSACTION_SUCCESSFUL_FORM, "Amount Credited");
		String locator = String.format(DepositPageUI.DYNAMIC_LOCATOR_TRANSACTION_SUCCESSFUL_FORM, "Amount Credited");
		if (driver.findElement(By.xpath(locator)).getText().equals(String.valueOf(amount))) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isTypeOfTransactionCorrect(String type) {
		waitForElementVisible(driver, DepositPageUI.DYNAMIC_LOCATOR_TRANSACTION_SUCCESSFUL_FORM, "Type of Transaction");
		String locator = String.format(DepositPageUI.DYNAMIC_LOCATOR_TRANSACTION_SUCCESSFUL_FORM, "Type of Transaction");
		if (driver.findElement(By.xpath(locator)).getText().equals(type)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isDescriptionCorrect(String description) {
		waitForElementVisible(driver, DepositPageUI.DYNAMIC_LOCATOR_TRANSACTION_SUCCESSFUL_FORM, "Description");
		String locator = String.format(DepositPageUI.DYNAMIC_LOCATOR_TRANSACTION_SUCCESSFUL_FORM, "Description");
		if (driver.findElement(By.xpath(locator)).getText().equals(description)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isCurrentBalanceCorrect(int amount) {
		waitForElementVisible(driver, DepositPageUI.DYNAMIC_LOCATOR_TRANSACTION_SUCCESSFUL_FORM, "Current Balance");
		String locator = String.format(DepositPageUI.DYNAMIC_LOCATOR_TRANSACTION_SUCCESSFUL_FORM, "Current Balance");
		if (driver.findElement(By.xpath(locator)).getText().equals(String.valueOf(amount))) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isTransactionFormDisplayed(String accountNumber) {
		waitForElementVisible(driver, DepositPageUI.SUCCESSFUL_FROM, accountNumber);
		return isElementDisplayed(driver, DepositPageUI.SUCCESSFUL_FROM, accountNumber);
	}

	public void inputAccountNo(String accountNumber) {
		waitForElementVisible(driver, DepositPageUI.DYNAMIC_LOCATOR_ACCOUNT_INFORMATION, "Account No");
		sendKeyToElement(driver, accountNumber, DepositPageUI.DYNAMIC_LOCATOR_ACCOUNT_INFORMATION, "Account No");
	}

	public void inputAmount(int amount) {
		waitForElementVisible(driver, DepositPageUI.DYNAMIC_LOCATOR_ACCOUNT_INFORMATION, "Amount");
		sendKeyToElement(driver, String.valueOf(amount), DepositPageUI.DYNAMIC_LOCATOR_ACCOUNT_INFORMATION, "Amount");		
	}
	
	public void inputDescription(String description) {
		waitForElementVisible(driver, DepositPageUI.DYNAMIC_LOCATOR_ACCOUNT_INFORMATION, "Description");
		sendKeyToElement(driver, description, DepositPageUI.DYNAMIC_LOCATOR_ACCOUNT_INFORMATION, "Description");		
	}

	public void clickSubmitButton() {
		waitForElementVisible(driver, DepositPageUI.SUBMIT_BUTTON);
		clickToElement(driver, DepositPageUI.SUBMIT_BUTTON);
	}

	public String getTransactionID() {
		return getTextElement(driver, DepositPageUI.DYNAMIC_LOCATOR_TRANSACTION_SUCCESSFUL_FORM, "Transaction ID");
	}

	public boolean isAccountCreatedSuccess() {
		// TODO Auto-generated method stub
		return false;
	}

}
