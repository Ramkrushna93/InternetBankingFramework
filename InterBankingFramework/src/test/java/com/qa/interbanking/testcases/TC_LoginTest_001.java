package com.qa.interbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.interbanking.pageobject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException  {

		logger.info("Url Lunched");
		LoginPage ip = new LoginPage(driver);
		ip.setUserName(username);
		logger.info("Entered  Username");
		ip.setPassword(password);
		logger.info("Entered Password");
		ip.clickLoginBtn();
		logger.info("Click on Login Button");
       String title=driver.getTitle();
		if (title.equals("mGuru99 Bank Manager HomePage")) { 
			Assert.assertTrue(true);
			logger.info("login test passed");
			
		} else {
			
			Assert.assertFalse(false);
			logger.info("login test failed");
			CapturescreenShot(driver, "loginTest");
		}
		
	}

}
