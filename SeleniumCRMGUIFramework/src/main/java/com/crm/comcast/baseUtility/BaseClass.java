package com.crm.comcast.baseUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.comcas.crm.objectrepository.HomePage;
import com.comcas.crm.objectrepository.LoginPage1;
import com.comcast.crm.generic.databaseutility.dataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class BaseClass {
	/* Create Object */
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wu = new WebDriverUtility();
	public FileUtility fLib = new FileUtility();
	public dataBaseUtility dLib = new dataBaseUtility();
	public WebDriver driver;// keeping this globally because driver is also required inside before method to
							// login into the application
	public static WebDriver sdriver;// creating this to use in listner implementation class because if this is
									// static it will not
	// participate in parallael execution.

	public ExtentReports report;// making as public to make use in other class also
	public ExtentSparkReporter spark;

	@BeforeSuite(groups = { "smokeTest", "RegressionTest" })
	public void configBeforeSuite() throws SQLException {
		System.out.println("Connect DataBase, Report Config");
		

		dLib.getConnection();
	}

	@BeforeClass(groups = { "smokeTest", "RegressionTest" })

	public void configBeforeClass() throws IOException {
		System.out.println("Launch Browser");
		String BROWSER = fLib.getDataFromPropertiesFile("Browser");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;// temporary variable storing the session id to use the variable in listner
							// implementation class
	}

	@BeforeMethod(groups = { "smokeTest", "RegressionTest" })
	public void configBeforeMethod() throws IOException {
		System.out.println("Login To Application");
		String url = fLib.getDataFromPropertiesFile("url");
		String username = fLib.getDataFromPropertiesFile("username");
		String password = fLib.getDataFromPropertiesFile("password");
		driver.get(url);
		LoginPage1 lp = new LoginPage1(driver);
		lp.LoginToApp(username, password);
	}

	@AfterMethod(groups = { "smokeTest", "RegressionTest" })
	public void configAfterMethod() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.logoutApp();
		System.out.println("Logout from Application");
	}

	@AfterClass(groups = { "smokeTest", "RegressionTest" })
	public void configAfterClass() {
		System.out.println("Close the Browser");
		driver.quit();
	}

	@AfterSuite(groups = { "smokeTest", "RegressionTest" })
	public void configAfterSuite() throws SQLException {
		System.out.println("Disconnect DataBase ,Report Backup");
		dLib.closedbConnection();
		
	}

}
