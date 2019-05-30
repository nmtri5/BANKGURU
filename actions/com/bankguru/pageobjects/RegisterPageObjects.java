package com.bankguru.pageobjects;

import org.openqa.selenium.WebDriver;

import com.bankguru.commons.AbstractPage;
import com.bankguru.commons.PageFactoryManager;

import bankguru.RegisterPageUI;

public class RegisterPageObjects extends AbstractPage{
	private WebDriver driver;
	

	public RegisterPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isRegisterPageDisplayed() {
		return isElementDisplayed(driver, RegisterPageUI.REGISTER_FORM);
	}

	public void clickToRegisterButton() {
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}

	public String getUserIDInfo() {
		return getTextElement(driver, RegisterPageUI.USER_INFO);
	}

	public String getPasswordInfo() {
		return getTextElement(driver, RegisterPageUI.PASSWORD_INFO);
	}

	public void inputToEmailIDTextbox(String email) {
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public LoginPageObjects openLoginPage(String loginURL) {
		openAnyUrl(driver, loginURL);
		return PageFactoryManager.getLoginPage(driver);
	}
}
