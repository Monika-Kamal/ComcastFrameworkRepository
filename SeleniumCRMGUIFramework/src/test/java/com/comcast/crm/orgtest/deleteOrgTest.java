package com.comcast.crm.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcas.crm.objectrepository.CreateNewOrganizationPage;
import com.comcas.crm.objectrepository.HomePage;
import com.comcas.crm.objectrepository.LoginPage1;
import com.comcas.crm.objectrepository.OrganizationInfoPage;
import com.comcas.crm.objectrepository.OrganizationsPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class deleteOrgTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		
					// read common data from property file
					FileUtility fLib = new FileUtility();
					ExcelUtility eLib = new ExcelUtility();
					JavaUtility jLib = new JavaUtility();
					WebDriverUtility wu = new WebDriverUtility();
					//step3: get the value based on key
					String BROWSER = fLib.getDataFromPropertiesFile("Browser");
					String URL = fLib.getDataFromPropertiesFile("url");
					String USERNAME = fLib.getDataFromPropertiesFile("username");
					String PASSWORD =fLib.getDataFromPropertiesFile("password");
					
					
					
					//step5: get the control of the "2nd" cell and read the string data
				     //String cell=row.getCell(3).getStringCellValue();//Cell cell=row.getCell(1).getStringValue();
					  String orgName=eLib.getdataFromExcel("Organisation", 10, 2)+jLib.getRandomNumber();
				     //double data = cell.getNumericCellValue();
				     System.out.println(orgName);
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
					wu.waitForPageToLoad(driver, 20);
					
					driver.get(URL);
//					LoginPage1 l = PageFactory.initElements(driver, LoginPage1.class);
					//calling the constructor
					LoginPage1 l = new LoginPage1(driver);
					
				   HomePage hp = new HomePage(driver);
				   
				   OrganizationsPage op = new OrganizationsPage(driver);
				
				   CreateNewOrganizationPage co = new CreateNewOrganizationPage(driver);
				   OrganizationInfoPage oip=new OrganizationInfoPage(driver);
				  
					//object utilization using getters
//					l.getUsernameEdit().sendKeys("admin");
//					l.getPasswordEdit().sendKeys("admin");
//					l.getLoginBtn().click();
					l.LoginToApp("admin", "admin");
					hp.getOrganisationlink().click();
					op.listOgOrg(); 
					op.createOrganisation();
					co.createNewOrganisation(orgName);
					String headerinfo = oip.getHeaderinfo().getText();
					String actOrgname = oip.getOrgNameinfo().getText();
					
					//verify header message expected result
					
					if(headerinfo.contains(orgName)) {
						System.out.println(orgName + "is created");
					}
					else {
						System.out.println(orgName + "is not created");
					}
					//verify orgname info expected result
					
					if(actOrgname.equals(orgName)) {
						System.out.println(orgName + "is created==PASS");
					}
					else {
						System.out.println(orgName + "is not created==FAIL");
					}
					
					//go back to org page
					hp.getOrganisationlink().click();
					//search for organisation
					op.getSearchtxt().sendKeys(orgName);
					wu.handleDropdown("Organization Name",op.getSearchdrop());
					op.getSearchbtn().click();
					
					driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
					//delete the organisation
					
					Thread.sleep(2000);
					driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
					driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				
					driver.quit();
					

	}

}
