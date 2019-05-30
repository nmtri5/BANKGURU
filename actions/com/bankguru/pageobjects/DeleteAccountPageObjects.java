package com.bankguru.pageobjects;

import org.openqa.selenium.WebDriver;

import com.bankguru.commons.AbstractPage;

import bankguru.DeleteAccountPageUI;

public class DeleteAccountPageObjects extends AbstractPage{
	private WebDriver driver;
	
	public DeleteAccountPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void confirmDeleteAlert() {
		acceptAlert(driver);
	}
	
	public boolean isAccountDeletedSuccessfully() {
		if(getTextAlert(driver).equals("Account Deleted Sucessfully")) {
			acceptAlert(driver);
			return true;
		} else {
			return false;
		}
	}
	
	public void inputAccountNumber(String accNum) {
		waitForElementVisible(driver, DeleteAccountPageUI.ACCOUNT_NUMBER_TEXTBOX);
		sendKeyToElement(driver, DeleteAccountPageUI.ACCOUNT_NUMBER_TEXTBOX, accNum);
	}
	
	public void clickToSubmitButton() {
		waitForElementVisible(driver, DeleteAccountPageUI.SUBMIT_BUTTON);
		clickToElement(driver, DeleteAccountPageUI.SUBMIT_BUTTON);
	}

	public boolean isDeleteAccountFormDisplayed() {
		return isElementDisplayed(driver, DeleteAccountPageUI.DELETE_ACCOUNT_FORM_DISPLAYED);
	}
}
