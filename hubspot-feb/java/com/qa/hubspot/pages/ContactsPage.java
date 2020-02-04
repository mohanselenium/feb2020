package com.qa.hubspot.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class ContactsPage extends BasePage {
	
	WebDriver driver;
	
	ElementUtil elementUtil;
	
	By createContactButton  =By.xpath("//span[text()='Create contact']");
    
//	By createContactFormButton  =By.xpath("//li//span[text()='Create contact']");
	By createContactFormButton = By.cssSelector("[data-confirm-button]");
	By email = By.xpath("//input[@data-field= 'email']");
	By firstname = By.xpath("//input[@data-field= 'firstname']");
	
	By lastname = By.xpath("//input[@data-field= 'lastname']");
	
	By jobTitle = By.xpath("//input[@data-field= 'jobtitle']"); 
	
	public ContactsPage(WebDriver driver) {
		
		this .driver = driver;
		
		elementUtil = new ElementUtil(driver);
		
		
	}
	
	public String getContactsPageTitle() {
		
		
		
		return elementUtil.WaitForTitlePresent(Constants.CONTACTS_PAGE_TITLE, 15);
		
		
	}
	
public void createNewContact(String mail,String Fn,String LN,String jobtitle) throws InterruptedException {
	
	Thread.sleep(5000);
		
		elementUtil.WaitForElementPresent(createContactButton);
		
		elementUtil.doClick(createContactButton);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);				
		
		elementUtil.WaitForElementPresent(email);
		elementUtil.sendkeys(email, mail);
		
		
		elementUtil.WaitForElementPresent(firstname);
		elementUtil.sendkeys(firstname, Fn);
		
		elementUtil.WaitForElementPresent(lastname);
		elementUtil.sendkeys(lastname, LN);
		
		
		
		
		
		
		elementUtil.WaitForElementPresent(jobTitle);
		elementUtil.doActionssendkeys(jobTitle, jobtitle);
		
		elementUtil.WaitForElementPresent(createContactFormButton);
		
		elementUtil.doClick(createContactFormButton);
		
		
	}
}
