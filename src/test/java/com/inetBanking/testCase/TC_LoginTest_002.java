package com.inetBanking.testCase;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.ExcelUtils;

public class TC_LoginTest_002 extends BaseClass {

	LoginPage lp = new LoginPage(driver);

	@Test(dataProvider= "LoginData")
	public void LoginTestDifferentData(String user, String pwd) {

		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.clickLogin();
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\inetBanking\\testData\\LoginData.xlsx";
		ExcelUtils eu = new ExcelUtils(filePath, "sheet1");

		int rowNum = eu.getRowCount();
		int colCount = eu.getColCount();

		String loginData[][] = new String[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {

			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = eu.getCellData(i, j);

			}
		}
		
		
		for (int i = 0; i < rowNum; i++) {

			for (int j = 0; j < colCount; j++) {
				
				System.out.println(loginData[i][j]);

			}
		}
		

		return loginData;

	}

}
