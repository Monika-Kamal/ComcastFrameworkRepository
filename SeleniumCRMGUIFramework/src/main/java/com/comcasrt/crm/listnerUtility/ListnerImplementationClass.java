package com.comcasrt.crm.listnerUtility;


import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.comcast.baseUtility.BaseClass;

public class ListnerImplementationClass implements ITestListener, ISuiteListener {

	public ExtentReports report;
	public static ExtentTest test;// to use this in another package// if public means we can use within the
									// package only
	// WebDriver driver;

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report Configuration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_" + time + ".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("CRM-Report");

		// add env information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("BROWSER", "Chrome-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {// this will start before the testcase starts executed
		// TODO Auto-generated method stub
		System.out.println("=========>" + result.getMethod().getMethodName() + "=====START======");
		// it will go insert one testcase in extent report
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName() + "====STARTED======");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("=========>" + result.getMethod().getMethodName() + "=====END======");
		test.log(Status.PASS, result.getMethod().getMethodName() + "====COMPLETED======");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testName = result.getMethod().getMethodName();
		// EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		TakesScreenshot edriver = (TakesScreenshot) BaseClass.sdriver;
		String src = edriver.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		/**
		 File dest = new File("./errorshots/"+testName+"+"+time+".png");// everytime
		 we need to give the screenshot name, instead of hard coding it, can give the
		 method name directly
		 the use of concating the method name is whenever we take the screenshot, the
		 screenshot name is same as failed testscript name
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		test.addScreenCaptureFromBase64String(src, testName + " " + time);
		test.log(Status.FAIL, result.getMethod().getMethodName() + "=====FAILED=====");
		test.log(Status.FAIL, result.getThrowable());// it will give the exception

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, result.getMethod().getMethodName() + "=====SKIPPED=====");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

}
