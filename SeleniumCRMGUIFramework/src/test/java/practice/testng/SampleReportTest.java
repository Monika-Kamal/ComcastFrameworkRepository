package practice.testng;

//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.comcast.baseUtility.BaseClass;

public class SampleReportTest extends BaseClass {
//	ExtentReports report;
//	@BeforeSuite
//	public void configBS() {
//        // if we have multiple testcases, we can't go and create for evry testcase,instead we are creating in the config annotation
//		//spark report config
//		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
//		spark.config().setDocumentTitle("CRM Test Suite Results");
//		spark.config().setTheme(Theme.DARK);
//		spark.config().setReportName("CRM-Report");
//		
//		//add env information and create test
//		report = new ExtentReports();
//		report.attachReporter(spark);
//		report.setSystemInfo("OS", "Windows-11");
//		report.setSystemInfo("BROWSER", "Chrome-100");
//		
//	}
//	@AfterSuite
//	public void configAS() {
//		report.flush();//to take backup of report
//	}
	
@Test
public void createContactTest() {
	
	ExtentTest test = report.createTest("createContactTest");// it will go insert one testcase in extent report
	
	test.log(Status.INFO, "login to app");
	test.log(Status.INFO, "Navigate to contact page");
	test.log(Status.INFO, "create contact");
	if("HDFC".equals("HDFC")) {
		test.log(Status.PASS, "Contact is created");
	}else {
		test.log(Status.FAIL, "Contact is not created");
	}
	
	
}
@Test
public void createContactWithOrgTest() {
	
	ExtentTest test = report.createTest("createContactTest");
	
	test.log(Status.INFO, "login to app");
	test.log(Status.INFO, "Navigate to contact page");
	test.log(Status.INFO, "createContactwithOrgTest");
	if("HDFC".equals("HDFC")) {
		test.log(Status.PASS, "Contact is created");
	}else {
		test.log(Status.FAIL, "Contact is not created");
	}
	
	
}
@Test
public void createContactwithPhoneNumberTest() {
	
	
	ExtentTest test = report.createTest("createContactTest");
	test.log(Status.INFO, "login to app");
	test.log(Status.INFO, "Navigate to contact page");
	test.log(Status.INFO, "createContactwithPhoneNumberTest");
	if("HDFCee".equals("HDFC")) {
		test.log(Status.PASS, "Contact is created");
	}else {
		test.log(Status.FAIL, "Contact is not created");
	}
	
	
}
}
