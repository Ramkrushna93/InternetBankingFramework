package com.qa.interbanking.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	Properties prop;

	public  ReadConfig() {

		File scr = new File(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
		try {
			FileInputStream fis = new FileInputStream(scr);
			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {
			System.out.println("The exception is" + e.getMessage());
		}
		
	}

	public String getUrl() {
		String url = prop.getProperty("baseUrl");
		return url;

	}

	public String getUserName() {
		String username = prop.getProperty("username");
		return username;
	}

	public String getPassword() {
		String password = prop.getProperty("password");
		return password;
	}

	public String getChromeDriver() {
		String chrome = prop.getProperty("Chrome");
		return chrome;
	}

	public String getFirefoxDriver() {
		String firefox = prop.getProperty(" Firefox");
		return firefox;

	}

	public String getIEDriver() {
		String ie = prop.getProperty("Internetexplore");
		return ie;
	}

}
