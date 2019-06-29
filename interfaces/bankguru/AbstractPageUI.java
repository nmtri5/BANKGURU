package bankguru;

public class AbstractPageUI {

	public static final String DYNAMIC_LINK_SIDE_MENU = "//ul[@class='menusubnav']//a[text() = '%s']";

	public static final String DYNAMIC_PAGE_TITLE = "//p[@class = 'heading3' and text()='%s']";
	
	public static final String DYNAMIC_TEXTBOX = "//td[contains(text(),'%s')]/following-sibling::td/*[self::input or self::textarea]";
	
	public static final String DYNAMIC_DATA_VALUE = "//table//td[text() = '%s']/following-sibling::td";

}
