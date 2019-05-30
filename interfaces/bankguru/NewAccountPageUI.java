package bankguru;

public class NewAccountPageUI {
	public static final String CUSTOMER_ID_TEXTBOX = "//input[@name = 'cusid']";
	public static final String ACCOUNT_TYPE_COMBOBOX = "//select[@name = 'selaccount']";
	public static final String INITIAL_DEPOSIT_TEXTBOX = "//input[@name = 'inideposit']";
	public static final String SUBMIT_BUTTON = "//input[@name = 'button2']";

	public static final String DYNAMIC_LOCATOR_NEW_ACCOUNT_SUCCESSFUL = "//td[text() = '%s']/following-sibling::td";
	
	public static final String NEW_ACCOUNT_CREATED_SUCCESS = "//p[text() = 'Account Generated Successfully!!!']";
}
