package com.bankguru.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bankguru.commons.AbstractPage;

import bankguru.DepositPageUI;
import bankguru.WithdrawalPageUI;

public class WithdrawalPageObjects extends AbstractPage {
	private WebDriver driver;
	
	public WithdrawalPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isWithdrawalFormDisplayed() {
		return isElementDisplayed(driver, WithdrawalPageUI.WITHDRAWAL_FORM);
	}

	public void inputAccountNo(String accountNumber) {
		waitForElementVisible(driver, WithdrawalPageUI.DYNAMIC_LOCATOR_WITHDRAWAL_FORM, "Account No");
		sendKeyToElement(driver, accountNumber, WithdrawalPageUI.DYNAMIC_LOCATOR_WITHDRAWAL_FORM, "Account No");
	}

	public void inputAmount(int addedAmount) {
		waitForElementVisible(driver, WithdrawalPageUI.DYNAMIC_LOCATOR_WITHDRAWAL_FORM, "Amount");
		sendKeyToElement(driver, String.valueOf(addedAmount), WithdrawalPageUI.DYNAMIC_LOCATOR_WITHDRAWAL_FORM, "Amount");
	}

	public void inputDescription(String description) {
		waitForElementVisible(driver, WithdrawalPageUI.DYNAMIC_LOCATOR_WITHDRAWAL_FORM, "Description");
		sendKeyToElement(driver, description, WithdrawalPageUI.DYNAMIC_LOCATOR_WITHDRAWAL_FORM, "Description");
	}

	public void clickSubmitButton() {
		waitForElementVisible(driver, WithdrawalPageUI.SUBMIT_BUTTON);
		clickToElement(driver, WithdrawalPageUI.SUBMIT_BUTTON);
	}

	public String getTransactionID() {
		return getTextElement(driver, WithdrawalPageUI.DYNAMIC_LOCATOR_WITHDRAWAL_SUCCESS, "Transaction ID");
	}
	
	public boolean isAccountNumberCorrect(String accountNo) {
		waitForElementVisible(driver, WithdrawalPageUI.DYNAMIC_LOCATOR_WITHDRAWAL_SUCCESS, "Account No");
		String locator = String.format(WithdrawalPageUI.DYNAMIC_LOCATOR_WITHDRAWAL_SUCCESS, "Account No");
		if (driver.findElement(By.xpath(locator)).getText().equals(accountNo)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isAmountDebitedCorrect(int amount) {
		waitForElementVisible(driver, WithdrawalPageUI.DYNAMIC_LOCATOR_WITHDRAWAL_SUCCESS, "Amount Debited");
		String locator = String.format(WithdrawalPageUI.DYNAMIC_LOCATOR_WITHDRAWAL_SUCCESS, "Amount Debited");
		if (driver.findElement(By.xpath(locator)).getText().equals(String.valueOf(amount))) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isTypeOfTransactionCorrect(String type) {
		waitForElementVisible(driver, WithdrawalPageUI.DYNAMIC_LOCATOR_WITHDRAWAL_SUCCESS, "Type of Transaction");
		String locator = String.format(WithdrawalPageUI.DYNAMIC_LOCATOR_WITHDRAWAL_SUCCESS, "Type of Transaction");
		if (driver.findElement(By.xpath(locator)).getText().equals(type)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isDescriptionCorrect(String description) {
		waitForElementVisible(driver, WithdrawalPageUI.DYNAMIC_LOCATOR_WITHDRAWAL_SUCCESS, "Description");
		String locator = String.format(WithdrawalPageUI.DYNAMIC_LOCATOR_WITHDRAWAL_SUCCESS, "Description");
		if (driver.findElement(By.xpath(locator)).getText().equals(description)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isCurrentBalanceCorrect(int amount) {
		waitForElementVisible(driver, WithdrawalPageUI.DYNAMIC_LOCATOR_WITHDRAWAL_SUCCESS, "Current Balance");
		String locator = String.format(WithdrawalPageUI.DYNAMIC_LOCATOR_WITHDRAWAL_SUCCESS, "Current Balance");
		if (driver.findElement(By.xpath(locator)).getText().equals(String.valueOf(amount))) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isTransactionFormDisplayed(String accountNumber) {
		waitForElementVisible(driver, WithdrawalPageUI.WITHDRAWAL_SUCCESS, accountNumber);
		return isElementDisplayed(driver, WithdrawalPageUI.WITHDRAWAL_SUCCESS, accountNumber);
	}

	
}
