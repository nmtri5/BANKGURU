package bankguru;

public class WithdrawalPageUI {
	public static final String WITHDRAWAL_FORM = "//p[@class='heading3' and text() = 'Amount Withdrawal Form']";
	public static final String DYNAMIC_LOCATOR_WITHDRAWAL_FORM = "//table//td[text() = '%s']/following-sibling::td//input";
	public static final String SUBMIT_BUTTON = "//input[@name = 'AccSubmit']";
	
	public static final String DYNAMIC_LOCATOR_WITHDRAWAL_SUCCESS = "//table[@id = 'withdraw']//td[text() = '%s']/following-sibling::td";
	public static final String WITHDRAWAL_SUCCESS = "//p[@class='heading3' and text() = 'Transaction details of Withdrawal for Account %s']";
}
