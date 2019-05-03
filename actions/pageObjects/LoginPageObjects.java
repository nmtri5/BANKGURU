package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import bankguru.LoginPageUI;
import commonFunctions.AbstractPage;

public class LoginPageObjects extends AbstractPage{
	private WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputUserName (String user) {
		sendKeyToElement(driver, LoginPageUI.USERID_TEXTBOX, user);
	}
	
	public void inputPassword (String password) {
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickLoginButton () {
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}
}
