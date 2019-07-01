package com.bankguru.payment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.account.Global_CreateNewAccount;
import com.bankguru.commons.AbstractTest;
import com.bankguru.commons.PageFactoryManager;
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
import com.bankguru.pageobjects.WithdrawalPageObjects;

import bankguru.AbstractPageUI;

public class TransactionFlow extends AbstractTest {
	WebDriver driver;
	private HomePageObjects homePage;
	private LoginPageObjects loginPage;
	private NewCustomerPageObject newCustomer;
	private EditCustomerPageObjects editCustomer;
	private NewAccountPageObjects newAccount;
	private DepositPageObjects depositPage;
	private WithdrawalPageObjects withdrawalPage;
	private FundTransferPageObjects fundTransferPage;
	private BalanceEnquiryPageObjects balanceEnquiryPage;
	private DeleteAccountPageObjects deleteAccountPage;
	private DeleteCustomerPageObjects deleteCustomerPage;
	
	String customerID, accountType = "Current", accountNumber, depositTransactionID, withdrawalTransactionID, payeeAccount;
	int initialAmount = 50000, addedAmount = 20000, substractAmount = 5000, transferAmount = 15000, finalAmount;

	// data for new customer
	String customerName = "TriNguyen";
	String gender = "male";
	String dob = "1993-01-01";
	String address = "The White House";
	String city = "Saigon";
	String state = "Tan Binh";
	String pin = "123123";
	String mobile = "09811237812";
	String email = "tringuyen" + randomeNumber() + "@gmail.com";
	String password = "123123";

	// data for editing
	String editAddress = "The Pentagon";
	String editCity = "Houston";
	String editState = "Texas";
	String editPin = "119820";
	String editMobile = "6478067748";
	String editEmail = "testing@gmail.com";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		log.info("Pre-condtition: Create New Customer - Step 01: Open Browser");
		driver = openBrowser(browser);

		log.info("Pre-condtition: Create New Customer - Step 02: Logging in using valid User ID");
		loginPage = PageFactoryManager.getLoginPage(driver);
		System.out.println(Global_CreateNewAccount.user);
		System.out.println(Global_CreateNewAccount.password);
		homePage = loginWithValidUser(loginPage, Global_CreateNewAccount.user, Global_CreateNewAccount.password);

		log.info("Pre-condtition: Create New Customer - Step 03: Open New Customer page");
		newCustomer = (NewCustomerPageObject) homePage.openAnySubPage(driver, "New Customer");
	}

	@Test
	public void TC_01_CreateNewCustomer() {
		log.info("Create New Customer - Step 01: Verify if Add New Customer form displayed");
		verifyTrue(newCustomer.isPageDisplayed(driver, "Add New Customer"));
		
		log.info("Create New Customer - Step 02: Fill in all information");
		newCustomer.fillInTextBox(driver, "Customer Name", customerName);
		newCustomer.checkToGenderRadioBox(gender);
		newCustomer.fillInTextBox(driver, "Date of Birth", dob);
		newCustomer.fillInTextBox(driver, "Address", address);
		newCustomer.fillInTextBox(driver, "City", city);
		newCustomer.fillInTextBox(driver, "State", state);
		newCustomer.fillInTextBox(driver, "PIN", pin);
		newCustomer.fillInTextBox(driver, "Mobile Number", mobile);
		newCustomer.fillInTextBox(driver, "E-mail", email);
		newCustomer.fillInTextBox(driver, "Password",password);
		
		log.info("Create New Customer - Step 03: Click the submit button");
		newCustomer.clickSubmitButton();
		customerID = newCustomer.getCustomerID();

		log.info("Create New Customer - Step 04: Check if the data is matched");
		verifyTrue(newCustomer.isPageDisplayed(driver, "Customer Registered Successfully!!!"));
		verifyTrue(newCustomer.isDataMatched(driver, customerName, AbstractPageUI.DYNAMIC_DATA_VALUE, "Customer Name"));
		verifyTrue(newCustomer.isDataMatched(driver, gender, AbstractPageUI.DYNAMIC_DATA_VALUE, "Gender"));
		verifyTrue(newCustomer.isDataMatched(driver, dob, AbstractPageUI.DYNAMIC_DATA_VALUE, "Birthdate"));
		verifyTrue(newCustomer.isDataMatched(driver, address, AbstractPageUI.DYNAMIC_DATA_VALUE, "Address"));
		verifyTrue(newCustomer.isDataMatched(driver, city, AbstractPageUI.DYNAMIC_DATA_VALUE, "City"));
		verifyTrue(newCustomer.isDataMatched(driver, state, AbstractPageUI.DYNAMIC_DATA_VALUE, "State"));
		verifyTrue(newCustomer.isDataMatched(driver, pin, AbstractPageUI.DYNAMIC_DATA_VALUE, "Pin"));
		verifyTrue(newCustomer.isDataMatched(driver, mobile, AbstractPageUI.DYNAMIC_DATA_VALUE, "Mobile No."));
		verifyTrue(newCustomer.isDataMatched(driver, email, AbstractPageUI.DYNAMIC_DATA_VALUE, "Email"));
	}

	@Test
	public void TC_02_EditCustomer() {
		log.info("Edit Customer - Step 01: Open Edit Customer page");
		editCustomer = (EditCustomerPageObjects) newCustomer.openAnySubPage(driver, "Edit Customer");
		
		log.info("Edit Customer - Step 02: Fill in Customer ID");
		editCustomer.fillInTextBox(driver, "Customer ID", customerID);
		
		log.info("Edit Customer - Step 03: Click Submit button");
		editCustomer.clickSubmitButton();
		
		log.info("Edit Customer - Step 04: Verify if data displayed correctly");
		verifyTrue(newCustomer.isDataMatched(driver, customerName, AbstractPageUI.DYNAMIC_TEXTBOX, "Customer Name"));
		verifyTrue(newCustomer.isDataMatched(driver, gender, AbstractPageUI.DYNAMIC_TEXTBOX, "Gender"));
		verifyTrue(newCustomer.isDataMatched(driver, dob, AbstractPageUI.DYNAMIC_TEXTBOX, "Date of Birth"));
		verifyTrue(newCustomer.isDataMatched(driver, address, AbstractPageUI.DYNAMIC_TEXTBOX, "Address"));
		verifyTrue(newCustomer.isDataMatched(driver, city, AbstractPageUI.DYNAMIC_TEXTBOX, "City"));
		verifyTrue(newCustomer.isDataMatched(driver, state, AbstractPageUI.DYNAMIC_TEXTBOX, "State"));
		verifyTrue(newCustomer.isDataMatched(driver, pin, AbstractPageUI.DYNAMIC_TEXTBOX, "PIN"));
		verifyTrue(newCustomer.isDataMatched(driver, mobile, AbstractPageUI.DYNAMIC_TEXTBOX, "Mobile Number"));
		verifyTrue(newCustomer.isDataMatched(driver, email, AbstractPageUI.DYNAMIC_TEXTBOX, "E-mail"));
		
		log.info("Edit Customer - Step 05: Edit all data");
		editCustomer.fillInTextBox(driver, "Address", editAddress);
		editCustomer.fillInTextBox(driver, "City", editCity);
		editCustomer.fillInTextBox(driver, "State", editState);
		editCustomer.fillInTextBox(driver, "PIN", editPin);
		editCustomer.fillInTextBox(driver, "Mobile Number", editMobile);
		editCustomer.fillInTextBox(driver, "E-mail", editEmail);

		log.info("Edit Customer - Step 06: Click Submit button");
		editCustomer.clickConfirmButton();

		log.info("Edit Customer - Step 07: Check if success form display");
		verifyTrue(editCustomer.isPageDisplayed(driver, "Customer details updated Successfully!!!"));
		
		log.info("Edit Customer - Step 08: Check if the data is updated");
		verifyTrue(editCustomer.isDataMatched(driver, customerName, AbstractPageUI.DYNAMIC_DATA_VALUE, "Customer Name"));
		verifyTrue(editCustomer.isDataMatched(driver, gender, AbstractPageUI.DYNAMIC_DATA_VALUE, "Gender"));
		verifyTrue(editCustomer.isDataMatched(driver, dob, AbstractPageUI.DYNAMIC_DATA_VALUE, "Birthdate"));
		verifyTrue(editCustomer.isDataMatched(driver, editAddress, AbstractPageUI.DYNAMIC_DATA_VALUE, "Address"));
		verifyTrue(editCustomer.isDataMatched(driver, editCity, AbstractPageUI.DYNAMIC_DATA_VALUE, "City"));
		verifyTrue(editCustomer.isDataMatched(driver, editState, AbstractPageUI.DYNAMIC_DATA_VALUE, "State"));
		verifyTrue(editCustomer.isDataMatched(driver, editPin, AbstractPageUI.DYNAMIC_DATA_VALUE, "Pin"));
		verifyTrue(editCustomer.isDataMatched(driver, editMobile, AbstractPageUI.DYNAMIC_DATA_VALUE, "Mobile No."));
		verifyTrue(editCustomer.isDataMatched(driver, editEmail, AbstractPageUI.DYNAMIC_DATA_VALUE, "Email"));
	}

	@Test
	public void TC_03_CreateNewAccount() {
		log.info("Create New Account - Step 01: Open New Account page");
		newAccount = (NewAccountPageObjects) editCustomer.openAnySubPage(driver, "New Account");

		log.info("Create New Account - Step 02: Input Customer ID");
		newAccount.fillInTextBox(driver, "Customer id", customerID);
		
		log.info("Create New Account - Step 03: Select Account Type");
		newAccount.selectAccountType(accountType);
		
		log.info("Create New Account - Step 04: Input Initial deposit");
		newAccount.fillInTextBox(driver, "Initial deposit", String.valueOf(initialAmount));
		finalAmount = initialAmount;

		log.info("Create New Account - Step 05: Click submit button");
		newAccount.clickSubmitButton();
		accountNumber = newAccount.getAccountNumber();
		
		log.info("Create New Account - Step 06: Check if account creation success form display");
		verifyTrue(newAccount.isPageDisplayed(driver, "Account Generated Successfully!!!"));
		
		log.info("Create New Account - Step 07: Check if new account data generated correctly");
		verifyTrue(newAccount.isDataMatched(driver, customerID, AbstractPageUI.DYNAMIC_DATA_VALUE, "Customer ID"));
		verifyTrue(newAccount.isDataMatched(driver, customerName, AbstractPageUI.DYNAMIC_DATA_VALUE, "Customer Name"));
		verifyTrue(newAccount.isDataMatched(driver, editEmail, AbstractPageUI.DYNAMIC_DATA_VALUE, "Email"));
		verifyTrue(newAccount.isDataMatched(driver, accountType, AbstractPageUI.DYNAMIC_DATA_VALUE, "Account Type"));
		verifyTrue(newAccount.isDataMatched(driver, getTodayDate(), AbstractPageUI.DYNAMIC_DATA_VALUE, "Date of Opening"));
		verifyTrue(newAccount.isDataMatched(driver, String.valueOf(initialAmount), AbstractPageUI.DYNAMIC_DATA_VALUE, "Current Amount"));
	}

	@Test
	public void TC_04_DepositMoney() {
		log.info("Deposit Money - Step 01: Open Deposit page");
		depositPage = (DepositPageObjects) newAccount.openAnySubPage(driver, "Deposit");

		log.info("Deposit Money - Step 02: Input Account Number");
		depositPage.fillInTextBox(driver, "Account No", accountNumber);
		
		log.info("Deposit Money - Step 03: Input Amount to Deposit");
		depositPage.fillInTextBox(driver, "Amount", String.valueOf(addedAmount));
		
		log.info("Deposit Money - Step 04: Input Description");
		depositPage.fillInTextBox(driver, "Description", "Deposit");

		log.info("Deposit Money - Step 05: Click submit button");
		depositPage.clickSubmitButton();
		finalAmount += addedAmount;
		depositTransactionID = depositPage.getTransactionID();

		log.info("Deposit Money - Step 06: Check if the confirmed transaction form display");
		verifyTrue(depositPage.isTransactionFormDisplayed(accountNumber));
		
		log.info("Deposit Money - Step 07: Check if the data matched correctly");
		verifyTrue(depositPage.isDataMatched(driver, accountNumber, AbstractPageUI.DYNAMIC_DATA_VALUE, "Account No"));
		verifyTrue(depositPage.isDataMatched(driver, String.valueOf(addedAmount), AbstractPageUI.DYNAMIC_DATA_VALUE, "Amount Credited"));
		verifyTrue(depositPage.isDataMatched(driver, "Deposit", AbstractPageUI.DYNAMIC_DATA_VALUE, "Type of Transaction"));
		verifyTrue(depositPage.isDataMatched(driver, "Deposit", AbstractPageUI.DYNAMIC_DATA_VALUE, "Description"));
		verifyTrue(depositPage.isDataMatched(driver, String.valueOf(finalAmount), AbstractPageUI.DYNAMIC_DATA_VALUE, "Current Balance"));
	}

	@Test
	public void TC_05_WithdrawMoney() {
		log.info("Withdraw Money - Step 01: Open Withdrawal page");
		withdrawalPage = (WithdrawalPageObjects) depositPage.openAnySubPage(driver, "Withdrawal");

		log.info("Withdraw Money - Step 02: Check if the withdrawal form display");
		verifyTrue(withdrawalPage.isPageDisplayed(driver, "Amount Withdrawal Form"));
		
		log.info("Withdraw Money - Step 03: Input the Account Number");
		withdrawalPage.fillInTextBox(driver, "Account No", accountNumber);
		
		log.info("Withdraw Money - Step 04: Input the Amount to withdraw");
		withdrawalPage.fillInTextBox(driver, "Amount", String.valueOf(substractAmount));
		
		log.info("Withdraw Money - Step 05: Input the Description");
		withdrawalPage.fillInTextBox(driver, "Description", "Withdrawal");

		log.info("Withdraw Money - Step 06: Click the submit button");
		withdrawalPage.clickSubmitButton();
		finalAmount -= substractAmount;
		withdrawalTransactionID = withdrawalPage.getTransactionID();

		log.info("Withdraw Money - Step 07: Check if the Transaction confirmation form display");
		verifyTrue(withdrawalPage.isTransactionFormDisplayed(accountNumber));
		
		log.info("Withdraw Money - Step 08: Check if the data matched correctly");
		verifyTrue(withdrawalPage.isDataMatched(driver, accountNumber, AbstractPageUI.DYNAMIC_DATA_VALUE, "Account No"));
		verifyTrue(withdrawalPage.isDataMatched(driver, String.valueOf(substractAmount), AbstractPageUI.DYNAMIC_DATA_VALUE, "Amount Debited"));
		verifyTrue(withdrawalPage.isDataMatched(driver, "Withdrawal", AbstractPageUI.DYNAMIC_DATA_VALUE, "Type of Transaction"));
		verifyTrue(withdrawalPage.isDataMatched(driver, "Withdrawal", AbstractPageUI.DYNAMIC_DATA_VALUE, "Description"));
		verifyTrue(withdrawalPage.isDataMatched(driver, String.valueOf(finalAmount), AbstractPageUI.DYNAMIC_DATA_VALUE, "Current Balance"));
	}

	@Test
	public void TC_06_TransferMoney() {
		log.info("Transfer Money - Step 01: Open Fund Transfer page");
		fundTransferPage = (FundTransferPageObjects) withdrawalPage.openAnySubPage(driver, "Fund Transfer");
		
		log.info("Transfer Money - Step 1.1: Create a payee account");
		payeeAccount = fundTransferPage.createNewAccount(newAccount, customerID, accountType, initialAmount);

		log.info("Transfer Money - Step 02: Check if the Fund Transfer form display");
		verifyTrue(fundTransferPage.isPageDisplayed(driver, "Fund transfer"));

		log.info("Transfer Money - Step 03: Input payer's account");
		fundTransferPage.fillInTextBox(driver, "Payers account no", accountNumber);
		
		log.info("Transfer Money - Step 04: Input Payee's account");
		fundTransferPage.fillInTextBox(driver, "Payees account no", payeeAccount);
		
		log.info("Transfer Money - Step 05: Input transfer amount");
		fundTransferPage.fillInTextBox(driver, "Amount", String.valueOf(transferAmount));
		
		log.info("Transfer Money - Step 06: Input Description");
		fundTransferPage.fillInTextBox(driver, "Description", "Transfer");
		
		log.info("Transfer Money - Step 07: Click submit button");
		fundTransferPage.clickToSubmitButton();
		finalAmount -= transferAmount;
		
		log.info("Transfer Money - Step 08: Check if the Fund Transfer detail page displayed correctly");
		verifyTrue(fundTransferPage.isPageDisplayed(driver, "Fund Transfer Details"));
		
		log.info("Transfer Money - Step 09: Check if the data matched correctly");
		verifyTrue(fundTransferPage.isDataMatched(driver, accountNumber, AbstractPageUI.DYNAMIC_DATA_VALUE, "From Account Number"));
		verifyTrue(fundTransferPage.isDataMatched(driver, payeeAccount, AbstractPageUI.DYNAMIC_DATA_VALUE, "To Account Number"));
		verifyTrue(fundTransferPage.isDataMatched(driver, String.valueOf(transferAmount), AbstractPageUI.DYNAMIC_DATA_VALUE, "Amount"));
		verifyTrue(fundTransferPage.isDataMatched(driver, "Transfer", AbstractPageUI.DYNAMIC_DATA_VALUE, "Description"));
	}

	@Test
	public void TC_07_CheckCurrentAmount() {
		log.info("Current Amount - Step 01: Open Balance Enquiry page");
		balanceEnquiryPage = (BalanceEnquiryPageObjects) fundTransferPage.openAnySubPage(driver, "Balance Enquiry");

		log.info("Current Amount - Step 02: Check if Balance Enquiry Forim display");
		verifyTrue(balanceEnquiryPage.isPageDisplayed(driver, "Balance Enquiry Form"));

		log.info("Current Amount - Step 03: Input account number");
		balanceEnquiryPage.fillInTextBox(driver, "Account No", accountNumber);
		
		log.info("Current Amount - Step 04: Click to submit button");
		balanceEnquiryPage.clickToSubmitButton();
		
		log.info("Current Amount - Step 05: Check if Balance Enquiry success form display");
		verifyTrue(balanceEnquiryPage.isBalanceEnquiryFormSuccessDisplayed(accountNumber));
		
		log.info("Current Amount - Step 06: Check if the data matched correctly");
		verifyTrue(balanceEnquiryPage.isDataMatched(driver, accountNumber, AbstractPageUI.DYNAMIC_DATA_VALUE, "Account No"));
		verifyTrue(balanceEnquiryPage.isDataMatched(driver, accountType, AbstractPageUI.DYNAMIC_DATA_VALUE, "Type of Account"));
		verifyTrue(balanceEnquiryPage.isDataMatched(driver, String.valueOf(finalAmount), AbstractPageUI.DYNAMIC_DATA_VALUE, "Balance"));
		
	}
	
	@Test
	public void TC_08_DeleteAccount() {
		log.info("Delete Account - Step 01: Open Delete Account page");
		deleteAccountPage = (DeleteAccountPageObjects) balanceEnquiryPage.openAnySubPage(driver, "Delete Account");
		
		log.info("Delete Account - Step 02: Check if Delete Account form display");
		verifyTrue(deleteAccountPage.isPageDisplayed(driver, "Delete Account Form"));
		
		log.info("Delete Account - Step 03: Input Account number");
		deleteAccountPage.fillInTextBox(driver, "Account No", accountNumber);
		
		log.info("Delete Account - Step 04: Click to Submit button");
		deleteAccountPage.clickToSubmitButton();
		
		log.info("Delete Account - Step 05: Click confirm on alert to delete and verify message delete successfully");
		deleteAccountPage.acceptAlert(driver);
		verifyTrue(deleteAccountPage.isAccountDeletedSuccessfully());
		
		log.info("Delete Account - Step 06: Check if homepage is display");
		homePage = PageFactoryManager.getHomePage(driver);
		verifyTrue(homePage.isHomePageDisplayed());
	}
	
	@Test
	public void TC_09_DeleteCustomer() {
		log.info("Delete Customer - Step 00: Delete payee account");
		homePage.deleteCustomerAccount(deleteAccountPage, payeeAccount);
		
		log.info("Delete Customer - Step 01: Open Delete Customer page");
		deleteCustomerPage = (DeleteCustomerPageObjects) homePage.openAnySubPage(driver, "Delete Customer");
	
		log.info("Delete Customer - Step 02: Check if Delete Customer form display");
		verifyTrue(deleteCustomerPage.isPageDisplayed(driver, "Delete Customer Form"));
		
		log.info("Delete Customer - Step 03: Input Customer ID");
		deleteCustomerPage.fillInTextBox(driver, "Customer ID", customerID);
		
		log.info("Delete Customer - Step 04: Click to Submit button");
		deleteCustomerPage.clickToSubmitButton();
		
		log.info("Delete Customer - Step 05: Click confirm on alert to delete and verify message delete successfully");
		deleteCustomerPage.acceptAlert(driver);
		verifyTrue(deleteCustomerPage.isCustomerDeletedSuccessfully());
		
		log.info("Delete Customer - Step 06: Check if homepage is display");
		homePage = PageFactoryManager.getHomePage(driver);
		verifyTrue(homePage.isHomePageDisplayed());
	}	

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

	private int randomeNumber() {
		Random ran = new Random();
		return ran.nextInt(999999);
	}

	public String getTodayDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
