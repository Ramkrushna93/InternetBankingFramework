package com.qa.interbanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver rdriver;

	@FindBy(name = "uid")
	@CacheLookup
	WebElement loginusername;

	@FindBy(name = "password")
	@CacheLookup
	WebElement loginpassword;

	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement loginbtn;

	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	@CacheLookup
	WebElement logoutbtn;

	public LoginPage(WebDriver idriver) {

		rdriver = idriver;
		PageFactory.initElements(rdriver, this);
	}

	public void setUserName(String uname) {

		loginusername.sendKeys(uname);

	}

	public void setPassword(String pwd) {

		loginpassword.sendKeys(pwd);
	}

	public void clickLoginBtn() {
		loginbtn.click();
	}

	public void clickLogoutBtn() {
		logoutbtn.click();
		
	}
}
