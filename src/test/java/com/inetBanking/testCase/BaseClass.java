package com.inetBanking.testCase;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BaseClass {

	ReadConfig rc = new ReadConfig();

	public String baseUrl = rc.getApplicationURL();
	public String userName = rc.getUserName();
	public String password = rc.getPasswaord();
	public static WebDriver driver;

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", rc.getChromrPath());
			driver = new ChromeDriver();
		} else if (br.equals("firepath")) {
			System.setProperty("webdriver.chrome.driver", rc.getFirepath());
			driver = new FirefoxDriver();
		}
		driver.get(baseUrl);
		driver.manage().window().maximize();

		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");

	}
	
	public void captureScreenshot(WebDriver driver, String tName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") +"/Screenshot/"+ tName+".png");
		FileUtils.copyFile(Source, target);
		System.out.println("ScreenShot Taken");
		
	}
	
	
	

//	@AfterClass
//	public void tearDown() {
//		driver.quit();
//	}

}
