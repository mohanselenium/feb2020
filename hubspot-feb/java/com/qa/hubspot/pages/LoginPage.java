package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class LoginPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	// 1. Page objects or object repository or By locators

	By emailid = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");

	By SignUpLink = By.linkText("Sign up");

	// 2 . constructor of the page class;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
		 elementUtil  = new ElementUtil(driver);
		 elementUtil.WaitForTitlePresent(Constants.Login_PAGE_Title, 15);
	}

	// 3. page actions or methods

	public String getPageTitle() {
		String title = elementUtil.WaitForTitlePresent(Constants.Login_PAGE_Title, 15);
		System.out.println("The login page title is " + title);

		return title;

	}

	public boolean VerifySignUpLink() {

	return	elementUtil.isElementdisplayed(SignUpLink);
      
	}
	
	public HomePage dologin(String username,String pwd) {
		
		System.out.println("username:"+ username + "password:" +pwd);
		elementUtil.sendkeys(emailid, username);
		elementUtil.sendkeys(password, pwd);
		elementUtil.doClick(loginButton);
			
		elementUtil.WaitForTitlePresent(Constants.Login_PAGE_Title, 15);	
			

			
			return new HomePage(driver);
		}

}
