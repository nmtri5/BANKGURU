package bankguru;

public class FundTransferPageUI {

	public static final String FUND_TRANSFER_FORM_DISPLAYED = "//p[@class ='heading3' and text() = 'Fund transfer']";
	public static final String DYNAMIC_LOCATOR_FUND_TRANSFER_FORM ="//table//td[text() = '%s']/following-sibling::td/input";

	public static final String SUBMIT_BUTTON = "//input[@name = 'AccSubmit']";
	
	public static final String DYNAMIC_LOCATOR_FUND_TRANSFER_SUCCESS = "//table//td[text() = '%s']/following-sibling::td";
	public static final String FUND_TRANSFER_SUCCESS_DISPLAYED = "//p[@class ='heading3' and text() = 'Fund Transfer Details']";
}
