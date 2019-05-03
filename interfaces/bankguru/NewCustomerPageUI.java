package bankguru;

public class NewCustomerPageUI {
	public static final String CUSTOMER_NAME_TEXTBOX = "//input[@name='name']";
	public static final String GENDER_RADIO_MALE = "//input[@name='rad1' and @value = 'm']";
	public static final String GENDER_RADIO_FEMALE = "//input[@name='rad1' and @value = 'f']";
	public static final String DOB_TEXTBOX = "//input[@name='dob']";
	public static final String ADDRESS_TEXTBOX = "//textarea[@name='addr']";
	public static final String CITY_TEXTBOX = "//input[@name='city']";
	public static final String STATE_TEXTBOX = "//input[@name='state']";
	public static final String PIN_TEXTBOX = "//input[@name='pinno']";
	public static final String MOBILE_TEXTBOX = "//input[@name='telephoneno']";
	public static final String EMAIL_TEXTBOX = "//input[@name='emailid']";
	public static final String PASSWORD_TEXTBOX = "//input[@name='password']";
	public static final String SUBMIT_BUTTON = "//input[@name='sub']";
	
	public static final String NAME_NULL_ERROR_MESSAGE = "//label[@id = 'message' and text()='Customer name must not be blank']";
	public static final String NAME_NUMBER_ERROR_MESSAGE = "//label[@id = 'message' and text()='Numbers are not allowed']";
	public static final String NAME_SPECIAL_CHAR_ERROR_MESSAGE = "//label[@id = 'message' and text()='Special characters are not allowed']";
	public static final String NAME_FIRST_BLANK_ERROR_MESSAGE = "//label[@id = 'message' and text()='First character can not have space']";
	
	public static final String ADDRESS_NULL_ERROR_MESSAGE = "//label[@id = 'message3' and text()='Address Field must not be blank']";
	public static final String ADDRESS_FIRST_BLANK_ERROR_MESSAGE = "//label[@id = 'message3' and text()='First character can not have space']";
	
	public static final String CITY_NULL_ERROR_MESSAGE = "//label[@id = 'message4' and text()='City Field must not be blank']";
	public static final String CITY_NUMBER_ERROR_MESSAGE = "//label[@id = 'message4' and text()='Numbers are not allowed']";
	public static final String CITY_SPECIAL_CHAR_ERROR_MESSAGE = "//label[@id = 'message4' and text()='Special characters are not allowed']";
	public static final String CITY_FIRST_BLANK_ERROR_MESSAGE = "//label[@id = 'message4' and text()='First character can not have space']";
	
	public static final String STATE_NULL_ERROR_MESSAGE = "//label[@id = 'message5' and text()='State must not be blank']";
	public static final String STATE_NUMBER_ERROR_MESSAGE = "//label[@id = 'message5' and text()='Numbers are not allowed']";
	public static final String STATE_SPECIAL_CHAR_ERROR_MESSAGE = "//label[@id = 'message5' and text()='Special characters are not allowed']";
	public static final String STATE_FIRST_BLANK_ERROR_MESSAGE = "//label[@id = 'message5' and text()='First character can not have space']";
	
	public static final String PIN_NULL_ERROR_MESSAGE = "//label[@id = 'message6' and text()='PIN Code must not be blank']";
	public static final String PIN_CHARACTER_ERROR_MESSAGE = "//label[@id = 'message6' and text()='Characters are not allowed']";
	public static final String PIN_SPECIAL_CHAR_ERROR_MESSAGE = "//label[@id = 'message6' and text()='Special characters are not allowed']";
	public static final String PIN_FIRST_BLANK_ERROR_MESSAGE = "//label[@id = 'message6' and text()='First character can not have space']";
	public static final String PIN_SIX_DEGIT_ERROR_MESSAGE = "//label[@id = 'message6' and text()='PIN Code must have 6 Digits']";
	
	public static final String MOBILE_NULL_ERROR_MESSAGE = "//label[@id = 'message7' and text()='Mobile no must not be blank']";
	public static final String MOBILE_CHARACTER_ERROR_MESSAGE = "//label[@id = 'message7' and text()='Characters are not allowed']";
	public static final String MOBILE_SPECIAL_CHAR_ERROR_MESSAGE = "//label[@id = 'message7' and text()='Special characters are not allowed']";
	public static final String MOBILE_FIRST_BLANK_ERROR_MESSAGE = "//label[@id = 'message7' and text()='First character can not have space']";

	public static final String EMAIL_NULL_ERROR_MESSAGE = "//label[@id = 'message9' and text()='Email-ID must not be blank']";
	public static final String EMAIL_NOT_VALID_ERROR_MESSAGE = "//label[@id = 'message9' and text()='Email-ID is not valid']";
	public static final String EMAIL_FIRST_BLANK_ERROR_MESSAGE = "//label[@id = 'message9' and text()='First character can not have space']";

}
