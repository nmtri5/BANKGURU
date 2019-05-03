package com.bankguru.newcustomer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import bankguru.NewCustomerPageUI;
import commonFunctions.AbstractPage;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.NewCustomerPageObject;

public class NewCustomer_04_StateValidation extends AbstractPage {
	WebDriver driver;
	NewCustomerPageObject newCustomer;
	LoginPageObjects login;
	HomePageObjects homePage;

	@Parameters("browser")
	@BeforeClass
	public void preCondition(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\lib\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("headless")) {
			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("headless");
			option.addArguments("window-size=1280x768");
			driver = new ChromeDriver(option);
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/V4");

		login = new LoginPageObjects(driver);
		login.inputUserName("mngr191760");
		login.inputPassword("atudatu");
		login.clickLoginButton();

		homePage = new HomePageObjects(driver);
		homePage.clickToNewCustomerLink();
	}

	@Test
	public void TC_11_StateCanNotBeEmpty() {
		newCustomer = new NewCustomerPageObject(driver);
		newCustomer.fillState("");
		newCustomer.clickTabToElement();
		Assert.assertTrue(isElementDisplayed(driver, NewCustomerPageUI.STATE_NULL_ERROR_MESSAGE));
		newCustomer.clearTextInTextbox("state");
	}

	@Test
	public void TC_12_StateCanNotBeNumeric() {
		newCustomer = new NewCustomerPageObject(driver);
		newCustomer.fillState("State1234");
		newCustomer.clickTabToElement();
		Assert.assertTrue(isElementDisplayed(driver, NewCustomerPageUI.STATE_NUMBER_ERROR_MESSAGE));
		newCustomer.clearTextInTextbox("state");
	}

	@Test
	public void TC_13_StateCanNotHaveSpecialChar() {
		newCustomer = new NewCustomerPageObject(driver);
		newCustomer.fillState("@$!@");
		newCustomer.clickTabToElement();
		Assert.assertTrue(isElementDisplayed(driver, NewCustomerPageUI.STATE_SPECIAL_CHAR_ERROR_MESSAGE));
		newCustomer.clearTextInTextbox("state");
	}

	@Test
	public void TC_14_StateCanNotHaveFirstBlank() {
		newCustomer = new NewCustomerPageObject(driver);
		newCustomer.fillState(" Thu Duc");
		newCustomer.clickTabToElement();
		Assert.assertTrue(isElementDisplayed(driver, NewCustomerPageUI.STATE_FIRST_BLANK_ERROR_MESSAGE));
		newCustomer.clearTextInTextbox("state");
	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}
}
