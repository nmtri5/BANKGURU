package com.bankguru.pageobjects;

import org.openqa.selenium.WebDriver;

import com.bankguru.commons.AbstractPage;

import bankguru.BalanceEnquiryPageUI;

public class BalanceEnquiryPageObjects extends AbstractPage {
	private WebDriver driver;
	
	public BalanceEnquiryPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isBalanceEnquiryFormDisplayed() {
		return isElementDisplayed(driver, BalanceEnquiryPageUI.BALANCE_ENQUIRY_FORM_DISPLAYED);
	}
	
	public void inputAccountNumber(String accNum) {
		waitForElementVisible(driver, BalanceEnquiryPageUI.ACCOUNT_NUMBER_TEXTBOX);
		sendKeyToElement(driver,  BalanceEnquiryPageUI.ACCOUNT_NUMBER_TEXTBOX, accNum);
	}
	
	public void clickToSubmitButton() {
		waitForElementVisible(driver, BalanceEnquiryPageUI.SUBMIT_BUTTON);
		clickToElement(driver, BalanceEnquiryPageUI.SUBMIT_BUTTON);
	}
	
	public boolean isBalanceEnquiryFormSuccessDisplayed(String accountNumber)
	{
		return isElementDisplayed(driver, BalanceEnquiryPageUI.BALANCE_ENQUIRY_SUCCESS_FORM_DISPLAYED, accountNumber);
	}
	
	public boolean isAccountNumberCorrect(String accountNumber) {
		waitForElementVisible(driver, BalanceEnquiryPageUI.DYNAMIC_LOCATOR_BALANCE_ENQUIRY_SUCCESS, "Account No"); 
		if(getTextElement(driver, BalanceEnquiryPageUI.DYNAMIC_LOCATOR_BALANCE_ENQUIRY_SUCCESS, "Account No").equals(accountNumber)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isAccountTypeCorrect(String type) {
		waitForElementVisible(driver, BalanceEnquiryPageUI.DYNAMIC_LOCATOR_BALANCE_ENQUIRY_SUCCESS, "Type of Account"); 
		if(getTextElement(driver, BalanceEnquiryPageUI.DYNAMIC_LOCATOR_BALANCE_ENQUIRY_SUCCESS, "Type of Account").equals(type)) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isAccountBalanceCorrect(int balance) {
		waitForElementVisible(driver, BalanceEnquiryPageUI.DYNAMIC_LOCATOR_BALANCE_ENQUIRY_SUCCESS, "Balance"); 
		if(getTextElement(driver, BalanceEnquiryPageUI.DYNAMIC_LOCATOR_BALANCE_ENQUIRY_SUCCESS, "Balance").equals(String.valueOf(balance))) {
			return true;
		} else {
			return false;
		}
	}
}
