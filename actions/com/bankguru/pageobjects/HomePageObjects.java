package com.bankguru.pageobjects;

import org.openqa.selenium.WebDriver;

import com.bankguru.commons.AbstractPage;
import com.bankguru.commons.PageFactoryManager;

import bankguru.HomePageUI;
import bankguru.LoginPageUI;

public class HomePageObjects extends AbstractPage {

	private WebDriver driver;

	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public RegisterPageObjects openRegisterPage() {
		waitForElementVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return PageFactoryManager.getRegisterPage(driver);
	}
	
	public boolean isHomePageDisplayed() {
		return isElementDisplayed(driver, HomePageUI.HOME_PAGE_WELCOME_TEXT);
	}
	
}
