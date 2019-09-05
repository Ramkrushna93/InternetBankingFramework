package com.qa.interbanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class newCustomerPage {
	
	WebDriver ldriver;
	
	public newCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement clicknewcustomer;
	
	@FindBy(name="name")
	@CacheLookup
	WebElement custname;
	
	@FindBy(name="rad1")
	@CacheLookup
	WebElement gender;
	
	@FindBy(name="dob")
	@CacheLookup
	WebElement textdob;
	
	@FindBy(name="addr")
	@CacheLookup
	WebElement address;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement textcity;
	
	@FindBy(name="state")
	@CacheLookup
	WebElement textstate;
	
	@FindBy(name="pinno")
	@CacheLookup
	WebElement pincode;
	
	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement mobno;
	
	@FindBy(name="emailid")
	@CacheLookup
	WebElement emailid;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement textpassword;
	
	@FindBy(name="sub")
	@CacheLookup
	WebElement submit;
	
	
	public void clickOnNewCustomer() {
		clicknewcustomer.click();
	}
	
	public void regnfill(String customertname, String addres, String custcity,String custstate, String custpincode, String custmobno ,String custpassword) {
	
		custname.sendKeys(customertname);
		gender.click();
		address.sendKeys(addres);
		textcity.sendKeys(custcity);
		textstate.sendKeys(custstate);
		pincode.sendKeys(custpincode);
		mobno.sendKeys(custmobno);
		textpassword.sendKeys(custpassword);
		
	}
	
	public void enterDob(String dd,String mm,String yy) {
		textdob.sendKeys(dd);
		textdob.sendKeys(mm);
		textdob.sendKeys(yy);
	}
	
	public void emailId(String custemailid) {
		emailid.sendKeys(custemailid);
	}
	
	public void regnSubmit() {
		submit.click();
		
	}

}
