package com.bankguru.pageobjects;

import org.openqa.selenium.WebDriver;
import com.bankguru.commons.AbstractPage;
import bankguru.DeleteAccountPageUI;
import bankguru.DeleteCustomerPageUI;

public class DeleteCustomerPageObjects extends AbstractPage {

		private WebDriver driver;
		
		public DeleteCustomerPageObjects(WebDriver driver) {
			this.driver = driver;
		}

		public void confirmDeleteAlert() {
			acceptAlert(driver);
		}
		
		public boolean isCustomerDeletedSuccessfully() {
			if(getTextAlert(driver).equals("Customer deleted Successfully")) {
				acceptAlert(driver);
				return true;
			} else {
				return false;
			}
		}
		
		public void inputCustomerID(String cusID) {
			waitForElementVisible(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX);
			sendKeyToElement(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX, cusID);
		}
		
		public void clickToSubmitButton() {
			waitForElementVisible(driver, DeleteCustomerPageUI.SUBMIT_BUTTON);
			clickToElement(driver, DeleteCustomerPageUI.SUBMIT_BUTTON);
		}

		public boolean isDeleteAccountFormDisplayed() {
			return isElementDisplayed(driver, DeleteCustomerPageUI.DELETE_CUSTOMER_FORM_DISPLAYED);
		}
	}
