package com.inetBanking.testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass {

	LoginPage lp = new LoginPage(driver);
	
	@Test
	public void loginTest() throws IOException {
		
		driver.get(baseUrl);
		logger.info("Application is launched");

		LoginPage lp = new LoginPage(driver);
		logger.info("Enter Username");
		lp.setUserName(userName);
		logger.info("Enter Password");
		lp.setPassword(password);
		logger.info("Click Submit");
		lp.clickLogin();
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Testcase passed");
		}
		
		else {
			System.out.println(driver.getTitle());
			captureScreenshot(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("Test case failed");			
		}
		

		

	}

}
