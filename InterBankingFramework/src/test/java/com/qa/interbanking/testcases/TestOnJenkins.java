package com.qa.interbanking.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestOnJenkins {
	
	@Parameters("browser")
	@Test(priority=1)
	public void test()
	{
		String k=System.getProperty("url");
		System.out.println("k is "+k);
	}

}
