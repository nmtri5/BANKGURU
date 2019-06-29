package com.bankguru.account;

import org.testng.annotations.Test;

import com.bankguru.commons.AbstractTest;
import com.bankguru.commons.PageFactoryManager;
import com.bankguru.pageobjects.LoginPageObjects;
import com.bankguru.pageobjects.RegisterPageObjects;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Global_CreateNewAccount extends AbstractTest{
	WebDriver driver;
	public static String user, password;
	String email = "juskoteh@gmail.com";
	LoginPageObjects loginPage;
	RegisterPageObjects registerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		log.info("Pre-condition: Register to System - Step 01: Verify if Login form is displayed");
		driver = openBrowser(browser);
		loginPage = PageFactoryManager.getLoginPage(driver);
	}

	@Test
	public void RegisterToSystem() {
		log.info("Register to System - Step 01: Verify if Login form is displayed");
		Assert.assertTrue(loginPage.isLoginFormDisplayed());

		log.info("Register to System - Step 02: Clic	k to Here Link");
		registerPage = loginPage.clickToHereLink();

		log.info("Register to System - Step 03: Verify if Register form is displayed");
		Assert.assertTrue(registerPage.isRegisterPageDisplayed());

		log.info("Register to System - Step 04: Input email to Email textbox");
		registerPage.inputToEmailIDTextbox(email);

		log.info("Register to System - Step 05: Click register button");
		registerPage.clickToRegisterButton();

		
		log.info("Register to System - Step 05: get UserID and Password info");
		user = registerPage.getUserIDInfo();
		password = registerPage.getPasswordInfo();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
