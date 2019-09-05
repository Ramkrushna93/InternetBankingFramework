package com.qa.interbanking.testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.qa.interbanking.pageobject.LoginPage;
import com.qa.interbanking.pageobject.newCustomerPage;

import junit.framework.Assert;

public class TC_NewCustomerTest_003 extends BaseClass {
	
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLoginBtn();
		logger.info("Login sucess");
		Thread.sleep(5000);
		
		newCustomerPage addcust=new newCustomerPage(driver);
		addcust.clickOnNewCustomer();
		logger.info("Clicked on newcustomer link ");
		
		addcust.regnfill("Raju", "Chennai", "Chennai", "Tamilnadu", "760001", "123456", "12345");
		logger.info("Entered Regn data sucessfully");
	    addcust.enterDob("18", "01", "1990");
	    logger.info("Entered Date of Birth ");
	    
	    String email=randomestring()+"@gmail.com";
	    addcust.emailId(email);
	    logger.info("Entered email id");
	    addcust.regnSubmit();
	    logger.info("Click on submit button");
	    
	    boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
	    
	    if(res==true) {
	    	
	    	Assert.assertTrue(true);
	    	logger.info("test case  passed------");
	    	
	    }else {
	    	
	    	logger.info("test case failed ");
	    	CapturescreenShot(driver,"addNewCustomer");
	    	Assert.assertFalse(false);
	    }
			
		
	}
	
	
}
