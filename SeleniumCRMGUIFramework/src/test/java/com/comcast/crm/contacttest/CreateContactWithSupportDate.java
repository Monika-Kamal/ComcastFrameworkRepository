package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcas.crm.objectrepository.ContactInfoPage;
import com.comcas.crm.objectrepository.ContactPage;
import com.comcas.crm.objectrepository.HomePage;
import com.comcas.crm.objectrepository.LoginPage1;
import com.comcas.crm.objectrepository.createContactPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithSupportDate {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wu = new WebDriverUtility();
		//step3: get the value based on key
		String BROWSER = fLib.getDataFromPropertiesFile("Browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD =fLib.getDataFromPropertiesFile("password");
		
		
		String Lastname =eLib.getdataFromExcel("Contacts", 4, 3)+jLib.getRandomNumber();
		
	     WebDriver driver= null;
			if(BROWSER.equals("chrome")) {
				driver= new ChromeDriver();
			}
			else if(BROWSER.equals("firefox")){
				driver= new FirefoxDriver();
			}
			else if(BROWSER.equals("edge")){
				driver= new EdgeDriver();
			}
			else {
				driver= new ChromeDriver();
			}
			
			
			wu.maximiseThePage(driver);
			wu.waitForPageToLoad(driver, 10);
			

			driver.get(URL);
			LoginPage1 l = new LoginPage1(driver);
			
			 HomePage hp = new HomePage(driver);
			 ContactPage cp = new ContactPage(driver);
			 createContactPage ccp= new createContactPage(driver);
			 ContactInfoPage cip = new ContactInfoPage(driver);
			 
			 l.LoginToApp("admin", "admin");
			 hp.opencontactpage();
			 cp.clickNewContact();
			 
			
			String startDate = jLib.getSystemdate();
			String endDate = jLib.getRequiredDate(30);
			ccp.createContactWithDate(Lastname, startDate, endDate);
			
			
			
			String expectStartDate = cip.getStartDateInfo().getText();
			
			
			if(expectStartDate.equals(startDate)) {
				System.out.println(startDate + "is inserted==PASS");
			}
			else {
				System.out.println(startDate + "is not inserted==FAIL");
			}
			String expectEndDate =cip.getEndDateInfo().getText();
			
			if(expectEndDate.equals(endDate)) {
				System.out.println(endDate + "is inserted==PASS");
			}
			else {
				System.out.println(endDate + "is not inserted==FAIL");
			}
			
			
			WebElement Admin = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
			wu.mouseHover(driver, Admin);
			
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
			driver.quit();
			
	






	}
	}


