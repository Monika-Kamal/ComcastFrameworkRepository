package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;

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

public class CreateContactTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		/* Create Object*/
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wu = new WebDriverUtility();
		
		//get the value based on key
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
			 ccp.createNewContact(Lastname);
			 

			String actlastName = cip.getLastnameInfo().getText();
			if(actlastName.equals(Lastname)) {
				System.out.println(Lastname + "is created");
			}
			else {
				System.out.println(Lastname + "is not created");
			}
			
			WebElement Admin = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
			wu.mouseHover(driver, Admin);
			
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
			driver.quit();
			

	}

}
