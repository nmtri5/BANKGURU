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

public class NewCustomer_05_PINValidation extends AbstractPage {
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
	public void TC_15_PinMustBeNumeric() {
		newCustomer = new NewCustomerPageObject(driver);
		newCustomer.fillPIN("PIN34");
		newCustomer.clickTabToElement();
		Assert.assertTrue(isElementDisplayed(driver, NewCustomerPageUI.PIN_CHARACTER_ERROR_MESSAGE));
		newCustomer.clearTextInTextbox("pin");
	}

	@Test
	public void TC_16_PinCanNotBeEmpty() {
		newCustomer = new NewCustomerPageObject(driver);
		newCustomer.fillPIN("");
		newCustomer.clickTabToElement();
		Assert.assertTrue(isElementDisplayed(driver, NewCustomerPageUI.PIN_NULL_ERROR_MESSAGE));
		newCustomer.clearTextInTextbox("pin");
	}

	@Test
	public void TC_17_PinMustHaveSixDigits() {
		newCustomer = new NewCustomerPageObject(driver);
		newCustomer.fillPIN("12345");
		newCustomer.clickTabToElement();
		Assert.assertTrue(isElementDisplayed(driver, NewCustomerPageUI.PIN_SIX_DEGIT_ERROR_MESSAGE));
		newCustomer.clearTextInTextbox("pin");
	}

	@Test
	public void TC_18_PinCanNotHaveSpecialChar() {
		newCustomer = new NewCustomerPageObject(driver);
		newCustomer.fillPIN("!@#$");
		newCustomer.clickTabToElement();
		Assert.assertTrue(isElementDisplayed(driver, NewCustomerPageUI.PIN_SPECIAL_CHAR_ERROR_MESSAGE));
		newCustomer.clearTextInTextbox("pin");
	}

	@Test
	public void TC_19_PinCanNotHaveFirstBlank() {
		newCustomer = new NewCustomerPageObject(driver);
		newCustomer.fillPIN(" 1234");
		newCustomer.clickTabToElement();
		Assert.assertTrue(isElementDisplayed(driver, NewCustomerPageUI.PIN_FIRST_BLANK_ERROR_MESSAGE));
		newCustomer.clearTextInTextbox("pin");
	}

	@Test
	public void TC_20_PinCanNotHaveBlank() {
		newCustomer = new NewCustomerPageObject(driver);
		newCustomer.fillPIN("12 4221");
		newCustomer.clickTabToElement();
		Assert.assertTrue(isElementDisplayed(driver, NewCustomerPageUI.PIN_CHARACTER_ERROR_MESSAGE));
		newCustomer.clearTextInTextbox("pin");
	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}
}
