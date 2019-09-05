package com.qa.interbanking.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext testcontext) {
		
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());  //time Stamp
		String repname="Test-Report-"+timestamp+".html";
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output"+repname);
		htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Host name", "Localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("user","Raju");
		
		htmlreporter.config().setDocumentTitle("InterBankingFramework");
		htmlreporter.config().setReportName("Functional Test Automation Report");
		htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlreporter.config().setTheme(Theme.DARK);
		
	}
	
	public void onTestSucess(ITestContext tr) {
		
		test=extent.createTest(tr.getName()); // Create a new entry in a report
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // Send the pass report 
		
	}
		
		public void onTestFailure(ITestContext tr) {
			test=extent.createTest(tr.getName());
			test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String screenshotpath=System.getProperty("user.dir")+"\\ScreenShot"+tr.getName()+".png";
		
		File f=new File(screenshotpath);
		
		if(f.exists())
		{
			try {
				test.fail("ScreenShot is below:"+test.addScreenCaptureFromPath(screenshotpath));
				
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
		public void onTestSkipped(ITestContext tr) {
			test=extent.createTest(tr.getName()); //Create new entey in report
			test.log(Status.INFO, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
			
		}
		
		public void onFinish(ITestContext textcontext) {
			extent.flush();
		}

}
