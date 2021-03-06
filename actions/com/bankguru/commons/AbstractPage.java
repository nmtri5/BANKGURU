package com.bankguru.commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import bankguru.AbstractPageUI;
import bankguru.EditCustomerPageUI;
import bankguru.NewCustomerPageUI;

public class AbstractPage {
	JavascriptExecutor js;
	WebDriverWait waitExplicit;
	List<WebElement> elements;
	Actions action;
	By locator;
	long shortTimeout = 5;
	long longTimeout = 30;

	public void openAnyUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public boolean isPageDisplayed(WebDriver driver, String pageName) {
		return isElementDisplayed(driver, AbstractPageUI.DYNAMIC_PAGE_TITLE, pageName);
	}

	public boolean isDataMatched(WebDriver driver, String content, String locator, String... options) {
		waitExplicit = new WebDriverWait(driver, 30);
		String dynamicLocator = String.format(locator, (Object[]) options);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicLocator)));
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		String test = element.getText();
		if (element.getText().length() > 0) {
			if (element.getText().equals(content)) {
				return true;
			} else {
				return false;
			}
		} else {
			if (element.getAttribute("value").equals(content)) {
				return true;
			} else {
				return false;
			}
		}
	}

	public void fillInTextBox(WebDriver driver, String textbox, String content) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, textbox);
		clearText(driver, AbstractPageUI.DYNAMIC_TEXTBOX, textbox);
		if (driver.toString().contains("chrome") && textbox == "Date of Birth") {
			removeAttributeInDOM(driver, "type", AbstractPageUI.DYNAMIC_TEXTBOX, textbox);
		}
		sendKeyToElement(driver, content, AbstractPageUI.DYNAMIC_TEXTBOX, textbox);
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void forwardToNextPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver);
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver);
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		waitForAlertPresence(driver);
		return driver.switchTo().alert().getText();
	}

	public void sendKeyToAlert(WebDriver driver, String key) {
		waitForAlertPresence(driver);
		driver.switchTo().alert().sendKeys(key);
	}

	public void clickToElement(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void clickToElement(WebDriver driver, String locator, String... options) {
		waitExplicit = new WebDriverWait(driver, 30);
		String dynamicLocator = String.format(locator, (Object[]) options);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicLocator)));
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		element.click();
	}

	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	public void sendKeyToElement(WebDriver driver, String locator, String content) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(content);
	}

	public void sendKeyToElement(WebDriver driver, String content, String locator, String... options) {
		waitExplicit = new WebDriverWait(driver, 30);
		String dynamicLocator = String.format(locator, (Object[]) options);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicLocator)));
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		element.sendKeys(content);
	}

	public void clearText(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
	}
	
	public void clearText(WebDriver driver, String locator, String...options) {
		waitExplicit = new WebDriverWait(driver, 30);
		String dynamicLocator = String.format(locator, (Object[]) options);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicLocator)));
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		element.clear();
	}

	public void selectItemInHtmlDropdown(WebDriver driver, String locator, String value) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		WebElement element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public String getSelectedItemInHtmlDropdown(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		WebElement element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public void selectDropdownListCustom(WebDriver driver, String xpathParent, String listItems, String chosenItem)
			throws Exception {
		// locate the custom dropdown
		WebElement dropdown = driver.findElement(By.xpath(xpathParent));
		js.executeScript("arguments[0].click();", dropdown);

		// wait until all option are loaded
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(listItems)));

		List<WebElement> listOptions = driver.findElements(By.xpath(listItems));

		// find the desired element
		for (WebElement a : listOptions) {
			if (a.getText().equals(chosenItem)) {
				js.executeScript("arguments[0].scrollIntoView(true);", a);

				Thread.sleep(1500);
				if (a.isDisplayed()) {
					a.click();
				} else {
					js.executeScript("arguments[0].click();", a);
				}
				break;
			}

		}

	}

	public String getAttributeValue(WebDriver driver, String locator, String attribute) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attribute);
	}

	public String getTextElement(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public String getTextElement(WebDriver driver, String locator, String... options) {
		waitExplicit = new WebDriverWait(driver, 30);
		String dynamicLocator = String.format(locator, (Object[]) options);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicLocator)));
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		return element.getText();
	}

	public int countElementNumber(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}

	public int countElementNumber(WebDriver driver, String locator, String... options) {
		waitExplicit = new WebDriverWait(driver, 30);
		String dynamicLocator = String.format(locator, (Object[]) options);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicLocator)));
		elements = driver.findElements(By.xpath(dynamicLocator));
		return elements.size();
	}

	public void checkToCheckBox(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		WebElement element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToCheckBox(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isElementDisplayed(WebDriver driver, String locator, String... options) {
		waitExplicit = new WebDriverWait(driver, 10);
		String dynamicLocator = String.format(locator, (Object[]) options);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicLocator)));
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		return element.isDisplayed();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public void switchToChildWindow(WebDriver driver, String parent) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parent)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public boolean closeAllExceptParentWindows(WebDriver driver, String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentWindow)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	public void switchToIframe(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		WebElement element = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(element);
	}

	public void backToParentTab(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(locator));
		action.doubleClick(element).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		WebElement element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void dragAndDropElement(WebDriver driver, String locatorFrom, String locatorTo) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorFrom)));
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorTo)));
		WebElement element = driver.findElement(By.xpath(locatorFrom));
		WebElement moveToElement = driver.findElement(By.xpath(locatorTo));
		action = new Actions(driver);
		action.dragAndDrop(element, moveToElement).perform();
	}

	public void dragAndDropToLocation(WebDriver driver, String locatorFrom, int x, int y) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorFrom)));
		WebElement element = driver.findElement(By.xpath(locatorFrom));
		action = new Actions(driver);
		action.dragAndDropBy(element, x, x).perform();
	}

	public void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		WebElement element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.sendKeys(element, key).perform();
	}

	public void holdKey(WebDriver driver, Keys key) {
		action = new Actions(driver);
		action.keyDown(key).perform();
	}

	public void releaseKey(WebDriver driver, Keys key) {
		action = new Actions(driver);
		action.keyUp(key).perform();
	}

	public void clickOnKeyBoard(WebDriver driver, Keys key) {
		if (driver.toString().contains("firefox") || driver.toString().contains("internet explorer")) {
			sendKeyboardToElement(driver, EditCustomerPageUI.BARONE, key);
		} else {
			Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
			keyboard.pressKey(Keys.TAB);
		}
	}

	public void highlightElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		String originalStyle = element.getAttribute("style");
		js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style",
				"border: 3px solid red; border-style: dashed;");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style", originalStyle);

	}

	public Object executeForBrowser(WebDriver driver, String javaSript) {
		return js.executeScript(javaSript);
	}

	public Object clickToElementByJS(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return js.executeScript("arguments[0].click();", element);
	}

	public Object sendkeyToElementByJS(WebDriver driver, WebElement element, String value) {
		return js.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public Object removeAttributeInDOM(WebDriver driver, String locator, String attribute) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		WebElement element = driver.findElement(By.xpath(locator));
		js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
	}

	public Object removeAttributeInDOM(WebDriver driver, String attribute, String locator, String... options) {
		waitExplicit = new WebDriverWait(driver, 30);
		String dynamicLocator = String.format(locator, (Object[]) options);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicLocator)));
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
	}

	public Object scrollToBottomPage(WebDriver driver) {
		return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public Object scrollToElement(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		WebElement element = driver.findElement(By.xpath(locator));
		return js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public Object navigateToUrlByJS(WebDriver driver, String url) {
		js = (JavascriptExecutor) driver;
		return js.executeScript("window.location = '" + url + "'");
	}

	public Object checkAnyImageLoaded(WebDriver driver, WebElement image) {
		js = (JavascriptExecutor) driver;
		return (Boolean) js.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				image);

	}

	public AbstractPage openAnySubPage(WebDriver driver, String pageName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_LINK_SIDE_MENU, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK_SIDE_MENU, pageName);

		switch (pageName) {
		case "Homepage":
			return PageFactoryManager.getHomePage(driver);
		case "New Customer":
			return PageFactoryManager.getNewCustomerPage(driver);
		case "New Account":
			return PageFactoryManager.getNewAccountPage(driver);
		case "Withdrawal":
			return PageFactoryManager.getWithdrawalPage(driver);
		case "Fund Transfer":
			return PageFactoryManager.getFundTransferPage(driver);
		case "Edit Customer":
			return PageFactoryManager.getEditCustomerPage(driver);
		case "Deposit":
			return PageFactoryManager.getDepositPage(driver);
		case "Balance Enquiry":
			return PageFactoryManager.getBalanceEnquiryPage(driver);
		case "Delete Account":
			return PageFactoryManager.getDeleteAccountPage(driver);
		case "Delete Customer":
			return PageFactoryManager.getDeleteCustomerPage(driver);
		default:
			return PageFactoryManager.getHomePage(driver);
		}
	}

	public void waitForElementPresence(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		this.locator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(this.locator));

	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		this.locator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(this.locator));

	}

	public void waitForElementVisible(WebDriver driver, String locator, String... options) {
		waitExplicit = new WebDriverWait(driver, 10);
		locator = String.format(locator, (Object[]) options);
		this.locator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(this.locator));

	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		this.locator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(this.locator));

	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		this.locator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(this.locator));

	}

	public void waitForAlertPresence(WebDriver driver) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.alertIsPresent());

	}

}
