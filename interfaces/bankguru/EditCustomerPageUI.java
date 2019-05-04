package bankguru;

public class EditCustomerPageUI {
	public static final String CUSTOMER_ID_TEXTBOX = "//input[@name='cusid']";
	public static final String SUBMIT_BUTTON = "//input[@name='AccSubmit']";
	
	public static final String ID_NULL_ERROR_MESSAGE = "//label[@id='message14' and text()='Customer ID is required']";
	public static final String ID_CHARACTER_ERROR_MESSAGE = "//label[@id='message14' and text()='Characters are not allowed']";
	public static final String ID_SPECIAL_CHAR_ERROR_MESSAGE = "//label[@id='message14' and text()='Special characters are not allowed']";
	
	public static final String ADDRESS_TEXTAREA = "//textarea[@name='addr']";
	public static final String CITY_TEXTBOX = "//input[@name='city']";
	public static final String STATE_TEXTBOX = "//input[@name='state']";
	public static final String PIN_TEXTBOX = "//input[@name='pinno']";
	public static final String MOBILE_TEXTBOX = "//input[@name='telephoneno']";
	public static final String EMAIL_TEXTBOX = "//input[@name='emailid']";

	public static final String CONFIRM_BUTTON = "//input[@name ='sub']";
}
