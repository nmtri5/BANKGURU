package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.HomePageUI;
import commonFunctions.AbstractPage;

public class HomePageObjects extends AbstractPage {

	private WebDriver driver;
	
	public HomePageObjects(WebDriver driver) { this.driver = driver; }
	
	public void clickToNewCustomerLink() { clickToElement(driver, HomePageUI.NEW_CUSTOMER_LINK); }
	
}
