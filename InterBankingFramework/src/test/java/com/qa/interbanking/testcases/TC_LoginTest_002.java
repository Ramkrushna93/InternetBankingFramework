package com.qa.interbanking.testcases;

import java.io.IOException;

import org.apache.log4j.lf5.viewer.categoryexplorer.TreeModelAdapter;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.interbanking.pageobject.LoginPage;
import com.qa.interbanking.utils.XLUtils;

import junit.framework.Assert;

public class TC_LoginTest_002 extends BaseClass {
	
	@Test(dataProvider="testdata")
	
	public void loginTest2(String user, String pwd) throws  InterruptedException {
	LoginPage lp=new LoginPage(driver);
	lp.setUserName(user);
	logger.info("Username provided");
	lp.setPassword(pwd);
	logger.info("Password provided");
	lp.clickLoginBtn();
	logger.info("Click on login btn");
	Thread.sleep(3000);
	
	// failure case
	if(isAlertPresent()==true) {
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertFalse(false);
		logger.info("Login failed");
		Thread.sleep(3000);
	}
	else
	{
		// passed case
		Assert.assertTrue(true);
		logger.info("Login Sucess");
		lp.clickLogoutBtn();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
	}
}
	
	public boolean isAlertPresent() {
		try {
			
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
		
	}
	
	@DataProvider(name="testdata")
	 String [][] getData() throws IOException{
		
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\qa\\interbanking\\testdata\\testdata.xlsx";
		
		int rowcon=XLUtils.getRowCount(path,"sheet1");
		int colcont=XLUtils.getCellCount(path, "sheet1", 1);
		
		String logindata[][]=new String[rowcon][colcont];
		
		for(int i=1; i<=rowcon; i++) {
			
			for(int j=0; j<colcont; j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
				
				
			}
		}
		return logindata;
		
		
		
		
	}
}