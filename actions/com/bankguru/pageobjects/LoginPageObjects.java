package com.bankguru.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bankguru.commons.AbstractPage;
import com.bankguru.commons.PageFactoryManager;

import bankguru.LoginPageUI;
import bankguru.RegisterPageUI;

public class LoginPageObjects extends AbstractPage{
	private WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputUserName (String user) {
		waitForElementPresence(driver, LoginPageUI.USERID_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USERID_TEXTBOX, user);
	}
	
	public void inputPassword (String password) {
		waitForElementPresence(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePageObjects clickLoginButton() {
		waitForElementPresence(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageFactoryManager.getHomePage(driver);
	}
	
	public RegisterPageObjects clickToHereLink() {
		waitForElementVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return PageFactoryManager.getRegisterPage(driver);
	}

	public boolean isLoginFormDisplayed() {
		return isElementDisplayed(driver, LoginPageUI.LOGIN_FORM);
	}

}
