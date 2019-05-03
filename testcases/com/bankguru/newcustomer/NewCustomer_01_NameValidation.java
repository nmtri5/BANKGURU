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

import commonFunctions.AbstractPage;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.NewCustomerPageObject;

public class NewCustomer_01_NameValidation extends AbstractPage {
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
	public void TC_01_NameCanNotBeEmpty() {
		newCustomer = new NewCustomerPageObject(driver);

		newCustomer.fillCustomerName("");
		newCustomer.clickTabToElement();
		Assert.assertTrue(newCustomer.isCustomerNameErrorMessageDisplayed("blank"));
	}

	@Test
	public void TC_02_NameCanNotBeNumeric() {
		newCustomer.fillCustomerName("1231");
		newCustomer.clickTabToElement();
		Assert.assertTrue(newCustomer.isCustomerNameErrorMessageDisplayed("numeric"));
		newCustomer.clearTextInTextbox("customer name");
	}

	@Test
	public void TC_03_NameCanNotBeSpecialCharacter() {
		newCustomer.fillCustomerName("!@#");
		newCustomer.clickTabToElement();
		Assert.assertTrue(newCustomer.isCustomerNameErrorMessageDisplayed("special character"));
		newCustomer.clearTextInTextbox("customer name");

	}

	@Test
	public void TC_04_NameCanNotBeFirstBlank() {
		newCustomer.fillCustomerName(" test");
		newCustomer.clickTabToElement();
		Assert.assertTrue(newCustomer.isCustomerNameErrorMessageDisplayed("first blank"));
		newCustomer.clearTextInTextbox("customer name");
	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}

}
