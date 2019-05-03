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

public class NewCustomer_02_AddressValidation extends AbstractPage {
	WebDriver driver;
	NewCustomerPageObject newCustomer;
	LoginPageObjects login;
	HomePageObjects homePage;
	
	@Parameters("browser")
	@BeforeClass
	public void preCondition(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\lib\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		} else if (browser.equalsIgnoreCase("headless")){
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
	public void TC_05_AddressCanNotBeEmpty() {
		newCustomer = new NewCustomerPageObject(driver);
		newCustomer.fillAddress("");
		newCustomer.clickTabToElement();
		Assert.assertTrue(isElementDisplayed(driver, NewCustomerPageUI.ADDRESS_NULL_ERROR_MESSAGE));
		newCustomer.clearTextInTextbox("address");
	}

	@Test
	public void TC_06_AddressCanNotHaveFirstBlank() {
		newCustomer = new NewCustomerPageObject(driver);
		newCustomer.fillAddress(" The White House");
		newCustomer.clickTabToElement();
		Assert.assertTrue(isElementDisplayed(driver, NewCustomerPageUI.ADDRESS_FIRST_BLANK_ERROR_MESSAGE));
		newCustomer.clearTextInTextbox("address");
	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}
}
