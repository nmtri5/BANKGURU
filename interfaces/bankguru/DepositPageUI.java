package bankguru;

public class DepositPageUI {

	public static final String DYNAMIC_LOCATOR_TRANSACTION_SUCCESSFUL_FORM = "//table[@id='deposit']//td[text()='%s']/following-sibling::td";
	public static final String SUCCESSFUL_FROM ="//p[@class = 'heading3' and text()='Transaction details of Deposit for Account %s']";
	
	public static final String DYNAMIC_LOCATOR_ACCOUNT_INFORMATION = "//table//td[text()='%s']/following-sibling::td//input";
	
	
	public static final String SUBMIT_BUTTON = "//input[@name = 'AccSubmit']";
}
