package bankguru;

public class BalanceEnquiryPageUI {

	public static final String BALANCE_ENQUIRY_FORM_DISPLAYED = "//p[@class='heading3' and text() = 'Balance Enquiry Form']";
	public static final String ACCOUNT_NUMBER_TEXTBOX ="//input[@name = 'accountno']";
	public static final String SUBMIT_BUTTON = "//input[@name = 'AccSubmit']";
	
	public static final String BALANCE_ENQUIRY_SUCCESS_FORM_DISPLAYED = "//p[@class='heading3' and text() = 'Balance Details for Account %s']";
	public static final String DYNAMIC_LOCATOR_BALANCE_ENQUIRY_SUCCESS = "//table[@id='balenquiry']//td[text() = '%s']/following-sibling::td";
}
