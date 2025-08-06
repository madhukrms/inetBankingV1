package com.inetBanking.utilities;

import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;

public class Reporting extends TestListenerAdapter {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	@Override
	public void onStart(ITestContext testContext) {
	    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // timestamp
	    String reportName = "Test-Report-" + timeStamp + ".html";

	    sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + reportName);
	    try {
			sparkReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    extent = new ExtentReports();
	    extent.attachReporter(sparkReporter);

	    extent.setSystemInfo("Host name", "localhost");
	    extent.setSystemInfo("Environment", "QA");
	    extent.setSystemInfo("User", "Madhusudan");
	}
	
	@Override
	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getName()); // creates a new entry in the report
		logger.pass("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.fail("Test Failed");
		// You can also log exceptions:
		logger.fail(tr.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.skip("Test Skipped");
	}

	@Override
	public void onFinish(ITestContext testContext) {
		extent.flush(); // Write everything to the report
	}
}
