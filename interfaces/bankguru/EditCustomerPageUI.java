package bankguru;

public class EditCustomerPageUI {
	public static final String BARONE = "//h2[@class='barone']";
	
	public static final String CUSTOMER_ID_TEXTBOX = "//input[@name='cusid']";
	public static final String SUBMIT_BUTTON = "//input[@name='AccSubmit']";
	
	public static final String ID_NULL_ERROR_MESSAGE = "//label[@id='message14' and text()='Customer ID is required']";
	public static final String ID_CHARACTER_ERROR_MESSAGE = "//label[@id='message14' and text()='Characters are not allowed']";
	public static final String ID_SPECIAL_CHAR_ERROR_MESSAGE = "//label[@id='message14' and text()='Special characters are not allowed']";
	public static final String ID_FIRST_CHAR_BLANK_ERROR_MESSAGE = "//label[@id='message14' and text()='First character can not have space']";
	
	public static final String ADDRESS_TEXTAREA = "//textarea[@name='addr']";
	public static final String CITY_TEXTBOX = "//input[@name='city']";
	public static final String STATE_TEXTBOX = "//input[@name='state']";
	public static final String PIN_TEXTBOX = "//input[@name='pinno']";
	public static final String MOBILE_TEXTBOX = "//input[@name='telephoneno']";
	public static final String EMAIL_TEXTBOX = "//input[@name='emailid']";

	public static final String CONFIRM_BUTTON = "//input[@name ='sub']";
	
	public static final String ADDRESS_BLANK_ERROR = "//label[@id ='message3' and text() = 'Address Field must not be blank']";
	
	public static final String CITY_BLANK_ERROR = "//label[@id ='message4' and text() = 'City Field must not be blank']";
	public static final String CITY_NUMERIC_ERROR = "//label[@id ='message4' and text() = 'Numbers are not allowed']";
	public static final String CITY_SPECIAL_CHAR_ERROR = "//label[@id ='message4' and text() = 'Special characters are not allowed']";
	
	public static final String STATE_BLANK_ERROR = "//label[@id ='message5' and text() = 'State must not be blank']";
	public static final String STATE_NUMERIC_ERROR = "//label[@id ='message5' and text() = 'Numbers are not allowed']";
	public static final String STATE_SPECIAL_CHAR_ERROR = "//label[@id ='message5' and text() = 'Special characters are not allowed']";
	
	public static final String PIN_CHAR_ERROR = "//label[@id ='message6' and text() = 'Characters are not allowed']";	
	public static final String PIN_BLANK_ERROR = "//label[@id ='message6' and text() = 'PIN Code must not be blank']";
	public static final String PIN_SIX_DIGIT_ERROR = "//label[@id ='message6' and text() = 'PIN Code must have 6 Digits']";
	public static final String PIN_SPECIAL_CHAR_ERROR = "//label[@id ='message6' and text() = 'Special characters are not allowed']";
		
	public static final String PHONE_BLANK_ERROR = "//label[@id ='message7' and text() = 'Mobile no must not be blank']";
	public static final String PHONE_SPECIAL_CHAR_ERROR = "//label[@id ='message7' and text() = 'Special characters are not allowed']";
	
	public static final String EMAIL_BLANK_ERROR = "//label[@id ='message9' and text() = 'Email-ID must not be blank']";
	public static final String EMAIL_FORMAT_ERROR = "//label[@id ='message9' and text() = 'Email-ID is not valid']";

	public static final String EDIT_FORM = "//p[@class='heading3' and text() = 'Edit Customer']";
	public static final String SUCCESS_FORM = "//p[@class='heading3' and text() = 'Customer details updated Successfully!!!']";
	public static final String CUSTOMER_ID = "//td[text() = 'Customer ID']/following-sibling::td";
	public static final String VERIFY_USERNAME = "//td[text() = 'Customer Name']/following-sibling::td";
	public static final String VERIFY_GENDER = "//td[text() = 'Gender']/following-sibling::td";
	public static final String VERIFY_DOB = "//td[text() = 'Birthdate']/following-sibling::td";
	public static final String VERIFY_ADDRESS = "//td[text() = 'Address']/following-sibling::td";
	public static final String VERIFY_CITY = "//td[text() = 'City']/following-sibling::td";
	public static final String VERIFY_STATE = "//td[text() = 'State']/following-sibling::td";
	public static final String VERIFY_PIN = "//td[text() = 'Pin']/following-sibling::td";
	public static final String VERIFY_MOBILE = "//td[text() = 'Mobile No.']/following-sibling::td";
	public static final String VERIFY_EMAIL = "//td[text() = 'Email']/following-sibling::td";

}
