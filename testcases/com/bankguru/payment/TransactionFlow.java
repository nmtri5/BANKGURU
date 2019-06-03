package com.bankguru.payment;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
	String customerID, type = "Current", accountNumber, depositTransactionID, withdrawalTransactionID;
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
		driver = openBrowser(browser);

		loginPage = PageFactoryManager.getLoginPage(driver);
		homePage = loginWithValidUser(loginPage);

		newCustomer = (NewCustomerPageObject) homePage.openAnySubPage(driver, "New Customer");
	}

	private int randomeNumber() {
		Random ran = new Random();
		return ran.nextInt(999999);
	}

	@Test
	public void TC_01_CreateNewCustomer() {
		log.info("Create New Customer - Step 01: Fill in Customer Name");
		newCustomer.fillCustomerName(customerName);
		
		log.info("Create New Customer - Step 02: Fill in Gender radio box");
		newCustomer.checkToGenderRadioBox(gender);
		
		log.info("Create New Customer - Step 03: Fill in Date of Birth");
		newCustomer.fillDOB(dob);
		
		log.info("Create New Customer - Step 04: Fill in Address");
		newCustomer.fillAddress(address);
		
		log.info("Create New Customer - Step 05: Fill in City");
		newCustomer.fillCity(city);
		
		log.info("Create New Customer - Step 06: Fill in State");
		newCustomer.fillState(state);
		
		log.info("Create New Customer - Step 07: Fill in Pin");
		newCustomer.fillPIN(pin);
		
		log.info("Create New Customer - Step 08: Fill in Mobile");
		newCustomer.fillMobileNumber(mobile);
		
		log.info("Create New Customer - Step 09: Fill in Email");
		newCustomer.fillEmail(email);
		
		log.info("Create New Customer - Step 10: Fill in Password");
		newCustomer.fillPassword(password);

		log.info("Create New Customer - Step 11: Click the submit button");
		newCustomer.clickSubmitButton();

		customerID = newCustomer.getCustomerID();

		log.info("Create New Customer - Step 12: Check if the customer information form display");
		verifyTrue(newCustomer.isNewCustomerFormInformationDisplayed());
		
		log.info("Create New Customer - Step 13: Check if the customer name match");
		verifyTrue(newCustomer.isUsernameMatch(customerName));
		
		log.info("Create New Customer - Step 14: Check if the gender match");
		verifyTrue(newCustomer.isGenderMatch(gender));
		
		log.info("Create New Customer - Step 15: Check if the date of birth match");
		verifyTrue(newCustomer.isDOBMatch(dob));
		
		log.info("Create New Customer - Step 16: Check if the address match");
		verifyTrue(newCustomer.isAddressMatch(address));
		
		log.info("Create New Customer - Step 17: Check if the city match");
		verifyTrue(newCustomer.isCityMatch(city));
		
		log.info("Create New Customer - Step 18: Check if the state match");
		verifyTrue(newCustomer.isStateMatch(state));
		
		log.info("Create New Customer - Step 19: Check if the pin match");
		verifyTrue(newCustomer.isPinMatch(pin));
		
		log.info("Create New Customer - Step 20: Check if the mobile number match");
		verifyTrue(newCustomer.isMobileNumberMatch(mobile));
		
		log.info("Create New Customer - Step 21: Check if the email match");
		verifyTrue(newCustomer.isEmailMatch(email));
	}

	@Test
	public void TC_02_EditCustomer() {
		log.info("Edit Customer - Step 01: Open Edit Customer page");
		editCustomer = (EditCustomerPageObjects) newCustomer.openAnySubPage(driver, "Edit Customer");
		
		log.info("Edit Customer - Step 02: Fill in Customer ID");
		editCustomer.fillCustomerID(customerID);
		
		log.info("Edit Customer - Step 03: Click Submit button");
		editCustomer.clickSubmitButton();

		log.info("Edit Customer - Step 04: Edit Address");
		editCustomer.editAddress(editAddress);
		
		log.info("Edit Customer - Step 05: Edit City");
		editCustomer.editCity(editCity);
		
		log.info("Edit Customer - Step 06: Edit State");
		editCustomer.editState(editState);
		
		log.info("Edit Customer - Step 07: Edit Pin");
		editCustomer.editPIN(editPin);
		
		log.info("Edit Customer - Step 08: Edit Mobile");
		editCustomer.editMobileNumber(editMobile);
		
		log.info("Edit Customer - Step 09: Edit Email");
		editCustomer.editEmail(editEmail);

		log.info("Edit Customer - Step 10: Click Submit button");
		editCustomer.clickConfirmButton();

		log.info("Edit Customer - Step 11: Check if success form display");
		verifyTrue(editCustomer.isEditCustomerSuccessfully());
		
		log.info("Edit Customer - Step 12: Check if the address match");
		verifyTrue(editCustomer.isAddressMatch(editAddress));
		
		log.info("Edit Customer - Step 13: Check if the city match");
		verifyTrue(editCustomer.isCityMatch(editCity));
		
		log.info("Edit Customer - Step 14: Check if the state match");
		verifyTrue(editCustomer.isStateMatch(editState));
		
		log.info("Edit Customer - Step 15: Check if the pin match");
		verifyTrue(editCustomer.isPinMatch(editPin));
		
		log.info("Edit Customer - Step 16: Check if the mobile number match");
		verifyTrue(editCustomer.isMobileNumberMatch(editMobile));
		
		log.info("Edit Customer - Step 17: Check if the email match");
		verifyTrue(editCustomer.isEmailMatch(editEmail));
	}

	@Test
	public void TC_03_CreateNewAccount() {
		log.info("Create New Account - Step 01: Open New Account page");
		newAccount = (NewAccountPageObjects) editCustomer.openAnySubPage(driver, "New Account");

		log.info("Create New Account - Step 02: Input Customer ID");
		newAccount.inputCustomerID(customerID);
		
		log.info("Create New Account - Step 03: Select Account Type");
		newAccount.selectAccountType(type);
		
		log.info("Create New Account - Step 04: Input Initial deposit");
		newAccount.inputInitialDeposit(initialAmount);
		
		finalAmount = initialAmount;

		log.info("Create New Account - Step 05: Click submit button");
		newAccount.clickSubmitButton();

		accountNumber = newAccount.getAccountNumber();
		
		log.info("Create New Account - Step 06: Check if account creation success form display");
		verifyTrue(newAccount.isAccountCreatedSuccess());
		
		log.info("Create New Account - Step 07: Check if Customer ID match");
		verifyTrue(newAccount.isCustomerIDMatch(customerID));
		
		log.info("Create New Account - Step 08: Check if Customer Name match");
		verifyTrue(newAccount.isCustomerNameMatch(customerName));
		
		log.info("Create New Account - Step 09: Check if Email match");
		verifyTrue(newAccount.isEmailMatch(editEmail));
		
		log.info("Create New Account - Step 10: Check if Account Type match");
		verifyTrue(newAccount.isAccountTypeMatch(type));
		
		log.info("Create New Account - Step 11: Check if Opening date match");
		verifyTrue(newAccount.isOpeningDateCorrect());
		
		log.info("Create New Account - Step 12: Check if Current Amount match");
		verifyTrue(newAccount.isCurrentAmountMatch(initialAmount));
	}

	@Test
	public void TC_04_DepositMoney() {
		log.info("Deposit Money - Step 01: Open Deposit page");
		depositPage = (DepositPageObjects) newAccount.openAnySubPage(driver, "Deposit");

		log.info("Deposit Money - Step 02: Input Account Number");
		depositPage.inputAccountNo(accountNumber);
		
		log.info("Deposit Money - Step 03: Input Amount to Deposit");
		depositPage.inputAmount(addedAmount);
		
		log.info("Deposit Money - Step 04: Input Description");
		depositPage.inputDescription("Deposit");

		log.info("Deposit Money - Step 05: Click submit button");
		depositPage.clickSubmitButton();
		finalAmount += addedAmount;

		depositTransactionID = depositPage.getTransactionID();

		log.info("Deposit Money - Step 06: Check if the confirmed transaction form display");
		verifyTrue(depositPage.isTransactionFormDisplayed(accountNumber));
		
		log.info("Deposit Money - Step 07: Check if the Account Number match");
		verifyTrue(depositPage.isAccountNumberCorrect(accountNumber));
		
		log.info("Deposit Money - Step 08: Check if the Amount Credited correct");
		verifyTrue(depositPage.isAmountCreditedCorrect(addedAmount));
		
		log.info("Deposit Money - Step 09: Check if the Type of Transaction correct");
		verifyTrue(depositPage.isTypeOfTransactionCorrect("Deposit"));
		
		log.info("Deposit Money - Step 10: Check if the Description correct");
		verifyTrue(depositPage.isDescriptionCorrect("Deposit"));
		
		log.info("Deposit Money - Step 11: Check if the Current Balance correct");
		verifyTrue(depositPage.isCurrentBalanceCorrect(finalAmount));
	}

	@Test
	public void TC_05_WithdrawMoney() {
		log.info("Withdraw Money - Step 01: Open Withdrawal page");
		withdrawalPage = (WithdrawalPageObjects) depositPage.openAnySubPage(driver, "Withdrawal");

		log.info("Withdraw Money - Step 02: Check if the withdrawal form display");
		verifyTrue(withdrawalPage.isWithdrawalFormDisplayed());
		
		log.info("Withdraw Money - Step 03: Input the Account Number");
		withdrawalPage.inputAccountNo(accountNumber);
		
		log.info("Withdraw Money - Step 04: Input the Amount to withdraw");
		withdrawalPage.inputAmount(substractAmount);
		
		log.info("Withdraw Money - Step 05: Input the Description");
		withdrawalPage.inputDescription("Withdrawal");

		log.info("Withdraw Money - Step 06: Click the submit button");
		withdrawalPage.clickSubmitButton();
		
		finalAmount -= substractAmount;

		withdrawalTransactionID = withdrawalPage.getTransactionID();

		log.info("Withdraw Money - Step 07: Check if the Transaction confirmation form display");
		verifyTrue(withdrawalPage.isTransactionFormDisplayed(accountNumber));
		
		log.info("Withdraw Money - Step 08: Check if the Account Number correct");
		verifyTrue(withdrawalPage.isAccountNumberCorrect(accountNumber));
		
		log.info("Withdraw Money - Step 09: Check if the withdrawal amount correct");
		verifyTrue(withdrawalPage.isAmountDebitedCorrect(substractAmount));
		
		log.info("Withdraw Money - Step 10: Check if the Type of Transaction correct");
		verifyTrue(withdrawalPage.isTypeOfTransactionCorrect("Withdrawal"));
		
		log.info("Withdraw Money - Step 11: Check if the Description correct");
		verifyTrue(withdrawalPage.isDescriptionCorrect("Withdrawal"));
		
		log.info("Withdraw Money - Step 12: Check if the Current Balance correct");
		verifyTrue(withdrawalPage.isCurrentBalanceCorrect(finalAmount));
	}

	@Test
	public void TC_06_TransferMoney() {
		log.info("Transfer Money - Step 01: Open Fund Transfer page");
		fundTransferPage = (FundTransferPageObjects) withdrawalPage.openAnySubPage(driver, "Fund Transfer");

		log.info("Transfer Money - Step 02: Check if the Fund Transfer form display");
		verifyTrue(fundTransferPage.isFundTransferFormDisplayed());

		log.info("Transfer Money - Step 03: Input payer's account");
		fundTransferPage.inputPayersAccount(accountNumber);
		
		log.info("Transfer Money - Step 04: Input Payee's account");
		fundTransferPage.inputPayeeAccount("60722");
		
		log.info("Transfer Money - Step 05: Input transfer amount");
		fundTransferPage.inputAmount(transferAmount);
		
		log.info("Transfer Money - Step 06: Input Description");
		fundTransferPage.inputDescription("Transfer");
		
		log.info("Transfer Money - Step 07: Click submit button");
		fundTransferPage.clickToSubmitButton();
		
		finalAmount -= transferAmount;
		
		log.info("Transfer Money - Step 08: Check if the balance in Payer Account correct");
		verifyTrue(fundTransferPage.isPayerAccountCorrect(accountNumber));
		
		log.info("Transfer Money - Step 09: Check if the balance in Payee Account correct");
		verifyTrue(fundTransferPage.isPayeeAccountCorrect("60722"));
		
		log.info("Transfer Money - Step 10: Check if the transfer amount correct");
		verifyTrue(fundTransferPage.isAmountCorrect(transferAmount));
		
		log.info("Transfer Money - Step 11: Check if the description correct");
		verifyTrue(fundTransferPage.isDescriptionCorrect("Transfer"));

	}

	@Test
	public void TC_07_CheckCurrentAmount() {
		log.info("Current Amount - Step 01: Open Balance Enquiry page");
		balanceEnquiryPage = (BalanceEnquiryPageObjects) fundTransferPage.openAnySubPage(driver, "Balance Enquiry");

		log.info("Current Amount - Step 02: Check if Balance Enquiry Forim display");
		verifyTrue(balanceEnquiryPage.isBalanceEnquiryFormDisplayed());

		log.info("Current Amount - Step 03: Input account number");
		balanceEnquiryPage.inputAccountNumber(accountNumber);
		
		log.info("Current Amount - Step 04: Click to submit button");
		balanceEnquiryPage.clickToSubmitButton();
		
		log.info("Current Amount - Step 05: Check if Balance Enquiry success form display");
		verifyTrue(balanceEnquiryPage.isBalanceEnquiryFormSuccessDisplayed(accountNumber));
		
		log.info("Current Amount - Step 06: Check if Account Number match");
		verifyTrue(balanceEnquiryPage.isAccountNumberCorrect(accountNumber));
		
		log.info("Current Amount - Step 04: Check if Account Type is correct");
		verifyTrue(balanceEnquiryPage.isAccountTypeCorrect(type));
		
		log.info("Current Amount - Step 04: Check if Account Balance correct");
		verifyTrue(balanceEnquiryPage.isAccountBalanceCorrect(finalAmount));
		
	}
	
	@Test
	public void TC_08_DeleteAccount() {
		log.info("Delete Account - Step 01: Open Delete Account page");
		deleteAccountPage = (DeleteAccountPageObjects) balanceEnquiryPage.openAnySubPage(driver, "Delete Account");
		
		log.info("Delete Account - Step 02: Check if Delete Account form display");
		verifyTrue(deleteAccountPage.isDeleteAccountFormDisplayed());
		
		log.info("Delete Account - Step 03: Input Account number");
		deleteAccountPage.inputAccountNumber(accountNumber);
		
		log.info("Delete Account - Step 04: Click to Submit button");
		deleteAccountPage.clickToSubmitButton();
		
		log.info("Delete Account - Step 05: Click confirm on alert to delete and verify message delete successfully");
		deleteAccountPage.confirmDeleteAlert();
		verifyTrue(deleteAccountPage.isAccountDeletedSuccessfully());
		
		log.info("Delete Account - Step 06: Check if homepage is display");
		homePage = PageFactoryManager.getHomePage(driver);
		verifyTrue(homePage.isHomePageDisplayed());
	}
	
	@Test
	public void TC_09_DeleteCustomer() {
		log.info("Delete Customer - Step 01: Open Delete Customer page");
		deleteCustomerPage = (DeleteCustomerPageObjects) homePage.openAnySubPage(driver, "Delete Customer");
	
		log.info("Delete Customer - Step 02: Check if Delete Customer form display");
		verifyTrue(deleteCustomerPage.isDeleteAccountFormDisplayed());
		
		log.info("Delete Customer - Step 03: Input Customer ID");
		deleteCustomerPage.inputCustomerID(customerID);
		
		log.info("Delete Customer - Step 04: Click to Submit button");
		deleteCustomerPage.clickToSubmitButton();
		
		log.info("Delete Customer - Step 05: Click confirm on alert to delete and verify message delete successfully");
		deleteCustomerPage.confirmDeleteAlert();
		verifyTrue(deleteCustomerPage.isCustomerDeletedSuccessfully());
		
		log.info("Delete Customer - Step 06: Check if homepage is display");
		homePage = PageFactoryManager.getHomePage(driver);
		verifyTrue(homePage.isHomePageDisplayed());
	}	

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
