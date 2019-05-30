package com.bankguru.commons;

import org.openqa.selenium.WebDriver;

import com.bankguru.pageobjects.BalanceEnquiryPageObjects;
import com.bankguru.pageobjects.DeleteAccountPageObjects;
import com.bankguru.pageobjects.DeleteCustomerPageObjects;
import com.bankguru.pageobjects.DepositPageObjects;
import com.bankguru.pageobjects.EditCustomerPageObjects;
import com.bankguru.pageobjects.FundTransferPageObjects;
import com.bankguru.pageobjects.HomePageObjects;
import com.bankguru.pageobjects.LoginPageObjects;
import com.bankguru.pageobjects.NewAccountPageObjects;
import com.bankguru.pageobjects.NewCustomerPageObject;
import com.bankguru.pageobjects.RegisterPageObjects;
import com.bankguru.pageobjects.WithdrawalPageObjects;

public class PageFactoryManager {

	public static HomePageObjects getHomePage(WebDriver driver) {
		return new HomePageObjects(driver);
	}

	public static RegisterPageObjects getRegisterPage(WebDriver driver) {
		return new RegisterPageObjects(driver);
	}

	public static LoginPageObjects getLoginPage(WebDriver driver) {
		return new LoginPageObjects(driver);
	}
	
	public static EditCustomerPageObjects getEditCustomerPage(WebDriver driver) {
		return new EditCustomerPageObjects(driver);
	}

	public static NewCustomerPageObject getNewCustomerPage(WebDriver driver) {
		return new NewCustomerPageObject(driver);
	}
	
	public static NewAccountPageObjects getNewAccountPage(WebDriver driver) {
		return new NewAccountPageObjects(driver);
	}
	
	public static FundTransferPageObjects getFundTransferPage(WebDriver driver) {
		return new FundTransferPageObjects(driver);
	}

	public static WithdrawalPageObjects getWithdrawalPage(WebDriver driver) {
		return new WithdrawalPageObjects(driver);
	}

	public static DepositPageObjects getDepositPage(WebDriver driver) {
		return new DepositPageObjects(driver);
	}
	
	public static BalanceEnquiryPageObjects getBalanceEnquiryPage(WebDriver driver) {
		return new BalanceEnquiryPageObjects(driver);
	}
	
	public static DeleteAccountPageObjects getDeleteAccountPage(WebDriver driver) {
		return new DeleteAccountPageObjects(driver);
	}
	
	public static DeleteCustomerPageObjects getDeleteCustomerPage(WebDriver driver) {
		return new DeleteCustomerPageObjects(driver);
	}
}
