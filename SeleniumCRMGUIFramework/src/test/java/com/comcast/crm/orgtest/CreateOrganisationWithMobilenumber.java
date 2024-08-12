package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import org.openqa.selenium.support.ui.Select;

import com.comcas.crm.objectrepository.CreateNewOrganizationPage;
import com.comcas.crm.objectrepository.HomePage;
import com.comcas.crm.objectrepository.LoginPage1;
import com.comcas.crm.objectrepository.OrganizationInfoPage;
import com.comcas.crm.objectrepository.OrganizationsPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrganisationWithMobilenumber {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		// create object for utility class
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wu = new WebDriverUtility();
		//step3: get the value based on key
		String BROWSER = fLib.getDataFromPropertiesFile("Browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD =fLib.getDataFromPropertiesFile("password");
		
		
		
		
		  String orgName=eLib.getdataFromExcel("Organisation", 4, 2)+jLib.getRandomNumber();
		  String IndustryName=eLib.getdataFromExcel("Organisation", 4, 3).toString();
		  String Type=eLib.getdataFromExcel("Organisation", 4, 4).toString();
	     String mobile = eLib.getdataFromExcel("Organisation", 4, 5);
	     //double data = cell.getNumericCellValue();
	     System.out.println(orgName);
	     System.out.println(IndustryName);
	     System.out.println(Type);
	     System.out.println(mobile);
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
		   
		   OrganizationsPage op = new OrganizationsPage(driver);
		
		   CreateNewOrganizationPage co = new CreateNewOrganizationPage(driver);
		  
		   OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		   
		   l.LoginToApp("admin", "admin");
			hp.getOrganisationlink().click();
			op.createOrganisation();
			
			
		WebElement wbselect = co.getIndustry();
		wu.handleDropdown(IndustryName, wbselect);

		WebElement wbselect1 = co.getType();
		wu.handleDropdown(Type, wbselect1);
		
		co.createNewOrganisationwithmobile(orgName, IndustryName, Type, mobile);
		
		 
		
		// to verify mobile
		
		
		String actmobile1 =oip.getPhoneInfo().getText();
		if(actmobile1.equals(mobile)) {
			System.out.println(mobile + "is entered");
		}
		else {
			System.out.println(mobile + "is not entered");

		}
		
		
		
		driver.quit();
		

}

	


}

