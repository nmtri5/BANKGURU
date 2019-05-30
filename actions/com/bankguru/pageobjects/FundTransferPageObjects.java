package com.bankguru.pageobjects;

import org.openqa.selenium.WebDriver;

import com.bankguru.commons.AbstractPage;

import bankguru.FundTransferPageUI;

public class FundTransferPageObjects extends AbstractPage {
	private WebDriver driver;

	public FundTransferPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFundTransferFormDisplayed() {
		return isElementDisplayed(driver, FundTransferPageUI.FUND_TRANSFER_FORM_DISPLAYED);
	}

	public void inputPayersAccount(String payerAccount) {
		waitForElementVisible(driver, FundTransferPageUI.DYNAMIC_LOCATOR_FUND_TRANSFER_FORM, "Payers account no");
		sendKeyToElement(driver, payerAccount, FundTransferPageUI.DYNAMIC_LOCATOR_FUND_TRANSFER_FORM,
				"Payers account no");
	}

	public void inputPayeeAccount(String payeeAccount) {
		waitForElementVisible(driver, FundTransferPageUI.DYNAMIC_LOCATOR_FUND_TRANSFER_FORM, "Payees account no");
		sendKeyToElement(driver, payeeAccount, FundTransferPageUI.DYNAMIC_LOCATOR_FUND_TRANSFER_FORM,
				"Payees account no");
	}

	public void inputAmount(int transferAmount) {
		waitForElementVisible(driver, FundTransferPageUI.DYNAMIC_LOCATOR_FUND_TRANSFER_FORM, "Amount");
		sendKeyToElement(driver, String.valueOf(transferAmount), FundTransferPageUI.DYNAMIC_LOCATOR_FUND_TRANSFER_FORM,
				"Amount");
	}

	public void inputDescription(String description) {
		waitForElementVisible(driver, FundTransferPageUI.DYNAMIC_LOCATOR_FUND_TRANSFER_FORM, "Description");
		sendKeyToElement(driver, description, FundTransferPageUI.DYNAMIC_LOCATOR_FUND_TRANSFER_FORM, "Description");
	}

	public boolean isPayerAccountCorrect(String payerAccount) {
		waitForElementVisible(driver, FundTransferPageUI.DYNAMIC_LOCATOR_FUND_TRANSFER_SUCCESS, "From Account Number");
		if (getTextElement(driver, FundTransferPageUI.DYNAMIC_LOCATOR_FUND_TRANSFER_SUCCESS, "From Account Number")
				.equals(payerAccount)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isPayeeAccountCorrect(String payeeAccount) {
		waitForElementVisible(driver, FundTransferPageUI.DYNAMIC_LOCATOR_FUND_TRANSFER_SUCCESS, "To Account Number");
		if (getTextElement(driver, FundTransferPageUI.DYNAMIC_LOCATOR_FUND_TRANSFER_SUCCESS, "To Account Number")
				.equals(payeeAccount)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isAmountCorrect(int amount) {
		waitForElementVisible(driver, FundTransferPageUI.DYNAMIC_LOCATOR_FUND_TRANSFER_SUCCESS, "Amount");
		if (getTextElement(driver, FundTransferPageUI.DYNAMIC_LOCATOR_FUND_TRANSFER_SUCCESS, "Amount")
				.equals(String.valueOf(amount))) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isDescriptionCorrect(String description) {
		waitForElementVisible(driver, FundTransferPageUI.DYNAMIC_LOCATOR_FUND_TRANSFER_SUCCESS, "Description");
		if (getTextElement(driver, FundTransferPageUI.DYNAMIC_LOCATOR_FUND_TRANSFER_SUCCESS, "Description")
				.equals(description)) {
			return true;
		} else {
			return false;
		}
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, FundTransferPageUI.SUBMIT_BUTTON);
		clickToElement(driver, FundTransferPageUI.SUBMIT_BUTTON);
	}

}
