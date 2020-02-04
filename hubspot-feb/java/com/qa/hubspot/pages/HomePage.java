package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class HomePage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	
	 
	By header = By.className("private-page__title");
	
	By accountname = By.className("navAccount-accountName");
	
	By id =  By.id("add-report");
	
	By menu = By.id("account-menu");
	
	By mainContactsLink  = By.id("nav-primary-contacts-branch");
	
	By childContactsLink  = By.xpath("(//a[@id ='nav-secondary-contacts'])[1]");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		

		 elementUtil  = new ElementUtil(driver);

	}
	
	public String getHomePageTitle() {
		
		elementUtil.WaitForTitlePresent(Constants.Login_PAGE_Title, 15);
		
		return elementUtil.WaitForTitlePresent(Constants.HOME_PAGE_Title, 15);
		
		
	}
	
public boolean isHeaderPresent() {
		
	return	elementUtil.isElementdisplayed(header);
		
		
	}

public String getHomepageHeadrervalue() {
	
	return	elementUtil.doGetText(header);
		
	
		
	}

public boolean isAccountNamePresent() {
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
elementUtil.doClick(accountname);	

elementUtil.isElementdisplayed(accountname);
	boolean isPresent = false;
	try {
	
		System.out.println(driver.findElement(accountname).isDisplayed());
		if(driver.findElement(accountname).isDisplayed())
			isPresent = true;
	
	}
	
	catch(Exception e) {
		System.out.println("element is not present");
		
	}
	return isPresent;
	}

public String getAccountNamevalue() {
	
	return	elementUtil.doGetText(accountname);
		
		
	}

public void clickOnContacts() {
	
	elementUtil.WaitForElementPresent(mainContactsLink);
	
	elementUtil.WaitForElementPresent(childContactsLink);
	
	elementUtil.doClick(mainContactsLink);
	elementUtil.doClick(childContactsLink);	
		
	}

public ContactsPage goTOContactsPage() {
	
	
	clickOnContacts();
	
	return new ContactsPage(driver);
		
	}

}
