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
		return ran.nextInt(999);
	}

	@Test
	public void TC_01_CreateNewCustomer() {
		newCustomer.fillCustomerName(customerName);
		newCustomer.checkToGenderRadioBox(gender);
		newCustomer.fillDOB(dob);
		newCustomer.fillAddress(address);
		newCustomer.fillCity(city);
		newCustomer.fillState(state);
		newCustomer.fillPIN(pin);
		newCustomer.fillMobileNumber(mobile);
		newCustomer.fillEmail(email);
		newCustomer.fillPassword(password);

		newCustomer.clickSubmitButton();

		customerID = newCustomer.getCustomerID();

		Assert.assertTrue(newCustomer.isNewCustomerFormInformationDisplayed());
		Assert.assertTrue(newCustomer.isUsernameMatch(customerName));
		Assert.assertTrue(newCustomer.isGenderMatch(gender));
		Assert.assertTrue(newCustomer.isDOBMatch(dob));
		Assert.assertTrue(newCustomer.isAddressMatch(address));
		Assert.assertTrue(newCustomer.isCityMatch(city));
		Assert.assertTrue(newCustomer.isStateMatch(state));
		Assert.assertTrue(newCustomer.isPinMatch(pin));
		Assert.assertTrue(newCustomer.isMobileNumberMatch(mobile));
		Assert.assertTrue(newCustomer.isEmailMatch(email));
	}

	@Test
	public void TC_02_EditCustomer() {
		editCustomer = (EditCustomerPageObjects) newCustomer.openAnySubPage(driver, "Edit Customer");
		editCustomer.fillCustomerID(customerID);
		editCustomer.clickSubmitButton();

		editCustomer.editAddress(editAddress);
		editCustomer.editCity(editCity);
		editCustomer.editState(editState);
		editCustomer.editPIN(editPin);
		editCustomer.editMobileNumber(editMobile);
		editCustomer.editEmail(editEmail);

		editCustomer.clickConfirmButton();

		Assert.assertTrue(editCustomer.isEditCustomerFormLoadedSuccessful());
		Assert.assertTrue(editCustomer.isAddressMatch(editAddress));
		Assert.assertTrue(editCustomer.isCityMatch(editCity));
		Assert.assertTrue(editCustomer.isStateMatch(editState));
		Assert.assertTrue(editCustomer.isPinMatch(editPin));
		Assert.assertTrue(editCustomer.isMobileNumberMatch(editMobile));
		Assert.assertTrue(editCustomer.isEmailMatch(editEmail));
	}

	@Test
	public void TC_03_CreateNewAccount() {
		newAccount = (NewAccountPageObjects) editCustomer.openAnySubPage(driver, "New Account");

		newAccount.inputCustomerID(customerID);
		newAccount.selectAccountType(type);
		newAccount.inputInitialDeposit(initialAmount);
		finalAmount = initialAmount;

		newAccount.clickSubmitButton();

		accountNumber = newAccount.getAccountNumber();
		Assert.assertTrue(newAccount.isAccountCreatedSuccess());
		Assert.assertTrue(newAccount.isCustomerIDMatch(customerID));
		Assert.assertTrue(newAccount.isCustomerNameMatch(customerName));
		Assert.assertTrue(newAccount.isEmailMatch(editEmail));
		Assert.assertTrue(newAccount.isAccountTypeMatch(type));
		Assert.assertTrue(newAccount.isOpeningDateCorrect());
		Assert.assertTrue(newAccount.isCurrentAmountMatch(initialAmount));
	}

	@Test
	public void TC_04_TransferMoney() {
		depositPage = (DepositPageObjects) newAccount.openAnySubPage(driver, "Deposit");

		depositPage.inputAccountNo(accountNumber);
		depositPage.inputAmount(addedAmount);
		depositPage.inputDescription("Deposit");

		depositPage.clickSubmitButton();
		finalAmount += addedAmount;

		depositTransactionID = depositPage.getTransactionID();

		Assert.assertTrue(depositPage.isTransactionFormDisplayed(accountNumber));
		Assert.assertTrue(depositPage.isAccountNumberCorrect(accountNumber));
		Assert.assertTrue(depositPage.isAmountCreditedCorrect(addedAmount));
		Assert.assertTrue(depositPage.isTypeOfTransactionCorrect("Deposit"));
		Assert.assertTrue(depositPage.isDescriptionCorrect("Deposit"));
		Assert.assertTrue(depositPage.isCurrentBalanceCorrect(finalAmount));
	}

	@Test
	public void TC_05_WithdrawMoney() {
		withdrawalPage = (WithdrawalPageObjects) depositPage.openAnySubPage(driver, "Withdrawal");

		Assert.assertTrue(withdrawalPage.isWithdrawalFormDisplayed());
		withdrawalPage.inputAccountNo(accountNumber);
		withdrawalPage.inputAmount(substractAmount);
		withdrawalPage.inputDescription("Withdrawal");

		withdrawalPage.clickSubmitButton();
		finalAmount -= substractAmount;

		withdrawalTransactionID = withdrawalPage.getTransactionID();

		Assert.assertTrue(withdrawalPage.isTransactionFormDisplayed(accountNumber));
		Assert.assertTrue(withdrawalPage.isAccountNumberCorrect(accountNumber));
		Assert.assertTrue(withdrawalPage.isAmountDebitedCorrect(substractAmount));
		Assert.assertTrue(withdrawalPage.isTypeOfTransactionCorrect("Withdrawal"));
		Assert.assertTrue(withdrawalPage.isDescriptionCorrect("Withdrawal"));
		Assert.assertTrue(withdrawalPage.isCurrentBalanceCorrect(finalAmount));
	}

	@Test
	public void TC_06_TransferMoney() {
		fundTransferPage = (FundTransferPageObjects) withdrawalPage.openAnySubPage(driver, "Fund Transfer");

		Assert.assertTrue(fundTransferPage.isFundTransferFormDisplayed());

		fundTransferPage.inputPayersAccount(accountNumber);
		fundTransferPage.inputPayeeAccount("60722");
		fundTransferPage.inputAmount(transferAmount);
		fundTransferPage.inputDescription("Transfer");
		fundTransferPage.clickToSubmitButton();
		
		finalAmount -= transferAmount;
		
		Assert.assertTrue(fundTransferPage.isPayerAccountCorrect(accountNumber));
		Assert.assertTrue(fundTransferPage.isPayeeAccountCorrect("60722"));
		Assert.assertTrue(fundTransferPage.isAmountCorrect(transferAmount));
		Assert.assertTrue(fundTransferPage.isDescriptionCorrect("Transfer"));

	}

	@Test
	public void TC_07_CheckCurrentAmount() {
		balanceEnquiryPage = (BalanceEnquiryPageObjects) fundTransferPage.openAnySubPage(driver, "Balance Enquiry");

		Assert.assertTrue(balanceEnquiryPage.isBalanceEnquiryFormDisplayed());

		balanceEnquiryPage.inputAccountNumber(accountNumber);
		balanceEnquiryPage.clickToSubmitButton();
		
		Assert.assertTrue(balanceEnquiryPage.isBalanceEnquiryFormSuccessDisplayed(accountNumber));
		Assert.assertTrue(balanceEnquiryPage.isAccountNumberCorrect(accountNumber));
		Assert.assertTrue(balanceEnquiryPage.isAccountTypeCorrect(type));
		Assert.assertTrue(balanceEnquiryPage.isAccountBalanceCorrect(finalAmount));
		
	}
	
	@Test
	public void TC_08_DeleteAccount() {
		deleteAccountPage = (DeleteAccountPageObjects) balanceEnquiryPage.openAnySubPage(driver, "Delete Account");
		
		Assert.assertTrue(deleteAccountPage.isDeleteAccountFormDisplayed());
		
		deleteAccountPage.inputAccountNumber(accountNumber);
		deleteAccountPage.clickToSubmitButton();
		
		deleteAccountPage.confirmDeleteAlert();
		Assert.assertTrue(deleteAccountPage.isAccountDeletedSuccessfully());
		
		homePage = PageFactoryManager.getHomePage(driver);
		Assert.assertTrue(homePage.isHomePageDisplayed());
	}
	
	@Test
	public void TC_09_DeleteCustomer() {
		deleteCustomerPage = (DeleteCustomerPageObjects) homePage.openAnySubPage(driver, "Delete Customer");
	
		Assert.assertTrue(deleteCustomerPage.isDeleteAccountFormDisplayed());
		
		deleteCustomerPage.inputCustomerID(customerID);
		deleteCustomerPage.clickToSubmitButton();
		
		deleteCustomerPage.confirmDeleteAlert();
		Assert.assertTrue(deleteCustomerPage.isCustomerDeletedSuccessfully());
		
		homePage = PageFactoryManager.getHomePage(driver);
		Assert.assertTrue(homePage.isHomePageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
