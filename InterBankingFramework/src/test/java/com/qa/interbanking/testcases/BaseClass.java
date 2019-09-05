package com.qa.interbanking.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.interbanking.utils.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	public String baseUrl = readconfig.getUrl();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void SetUP(String brow) {

		logger = Logger.getLogger("InterBankingFramework");
		PropertyConfigurator.configure("log4j.properties");

		if (brow.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\USER\\eclipse-workspace\\InterBankingFramework\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (brow.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\USER\\eclipse-workspace\\InterBankingFramework\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(baseUrl);
		logger.info("Url Lunched");
		driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(90,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@AfterTest
	public void teardown() {

		driver.quit();
	}
	
	public void CapturescreenShot(WebDriver driver , String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File("C:\\Users\\USER\\eclipse-workspace\\InterBankingFramework\\ScreenShot"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("ScreenShot is taken");
		logger.info("ScreenShot is taken");
		
	}
	
	public static String randomestring() {
		String generatestring1=RandomStringUtils.randomAlphabetic(8);
		return generatestring1;
		
	}


}
