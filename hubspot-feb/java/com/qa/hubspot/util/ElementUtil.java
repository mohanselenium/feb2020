package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	WebDriver driver;

	public ElementUtil(WebDriver driver) {

		this.driver = driver;

	}

	/**
	 * This method is generic method used to create the webElement on the basis of
	 * locator
	 * 
	 * @param locator
	 * @return
	 */

	public WebElement getElement(By locator) {

		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {

			System.out.println("some exception occured while creating the web element");
			System.out.println(e.getMessage());
		}
		return element;

	}

	/**
	 * This method is used to click on elements
	 * 
	 * @param locator
	 */

	public void doClick(By locator) {
		try {
			
			getElement(locator).click();

		} catch (Exception e) {
			e.printStackTrace();

			System.out.println(" Some exception is coming while clciking on the web element");
		}

	}

	

	public String doGetText(By locator) {
		try {
			return getElement(locator).getText();

		} catch (Exception e) {

			System.out.println(" Some exception is coming while getting the text of the  element");
			System.out.println(e.getMessage());
			return null;
		}

	}
	/**
	 * This method is used to perform send keys
	 * 
	 * @param locator
	 * @param value
	 */

	public void sendkeys(By locator, String value) {
		try {
			getElement(locator).sendKeys(value);
		} catch (Exception e) {

			System.out.println(" Some exception is coming while sending values  on the web element");
		}

	}

	
	public void doActionssendkeys(By locator, String value) {
		try {
			
			Actions action = new Actions(driver);
			action.sendKeys(getElement(locator), value).build().perform();
			
		} catch (Exception e) {

			System.out.println(" Some exception is coming while sending values  on the web element");
		}

	}

	
	/**
	 * this is a generic method for explicit wait
	 * @param locator
	 */
	public void WaitForElementPresent(By locator ) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	
	public String WaitForTitlePresent(String title , int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();

	}





public boolean isElementdisplayed(By locator) {
try {
	getElement(locator).isDisplayed(); 
 return true;
}
catch (Exception e) {
	
	System.out.println(" Some exception occured while checking if the element is present or not ");
	System.out.println(e.getMessage());
	return false;
}

}

}



