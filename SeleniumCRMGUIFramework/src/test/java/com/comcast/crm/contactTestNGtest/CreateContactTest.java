package com.comcast.crm.contactTestNGtest;
/**
 * test class for contact module
 * @author Monika
 */
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcas.crm.objectrepository.ContactInfoPage;
import com.comcas.crm.objectrepository.ContactPage;
import com.comcas.crm.objectrepository.CreateNewOrganizationPage;
import com.comcas.crm.objectrepository.HomePage;

import com.comcas.crm.objectrepository.OrganizationInfoPage;
import com.comcas.crm.objectrepository.OrganizationsPage;
import com.comcas.crm.objectrepository.createContactPage;
import com.crm.comcast.baseUtility.BaseClass;

public class CreateContactTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createContactTest() throws EncryptedDocumentException, IOException {
		String Lastname = eLib.getdataFromExcel("Contacts", 4, 3) + jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.opencontactpage();
		ContactPage cp = new ContactPage(driver);
		cp.clickNewContact();
		createContactPage ccp = new createContactPage(driver);
		ccp.createNewContact(Lastname);
		ContactInfoPage cip = new ContactInfoPage(driver);

		String actlastName = cip.getLastnameInfo().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actlastName, Lastname);
		System.out.println(Lastname + "is created");
		
//		if (actlastName.equals(Lastname)) {
//			System.out.println(Lastname + "is created");
//		} else {
//			System.out.println(Lastname + "is not created");
//		}

	}
	
	@Test(groups = "RegressionTest")
	public void createContactwithSupportdateTest() throws EncryptedDocumentException, IOException {

		String Lastname =eLib.getdataFromExcel("Contacts", 4, 3)+jLib.getRandomNumber();
			 HomePage hp = new HomePage(driver);
			 hp.opencontactpage();
			 ContactPage cp = new ContactPage(driver);
			 cp.clickNewContact();
			 createContactPage ccp= new createContactPage(driver);
			 ContactInfoPage cip = new ContactInfoPage(driver);
			String startDate = jLib.getSystemdate();
			String endDate = jLib.getRequiredDate(30);
			ccp.createContactWithDate(Lastname, startDate, endDate);
			String expectStartDate = cip.getStartDateInfo().getText();
			Assert.assertEquals(expectStartDate,startDate );
			System.out.println(startDate + "is inserted==PASS");
//			if(expectStartDate.equals(startDate)) {
//				System.out.println(startDate + "is inserted==PASS");
//			}
//			else {
//				System.out.println(startDate + "is not inserted==FAIL");
//			}
			String expectEndDate =cip.getEndDateInfo().getText();
			Assert.assertEquals(expectEndDate,endDate );
			System.out.println(endDate + "is inserted==PASS");
//			if(expectEndDate.equals(endDate)) {
//				System.out.println(endDate + "is inserted==PASS");
//			}
//			else {
//				System.out.println(endDate + "is not inserted==FAIL");
//			}
			
	}

	@Test(groups = "RegressionTest")
	public void createContactwithOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {
		 String orgName=eLib.getdataFromExcel("organisation", 4, 2)+jLib.getRandomNumber();
	     String Lastname =eLib.getdataFromExcel("Contacts", 4, 3)+jLib.getRandomNumber();
	     System.out.println(orgName);
		
		
		
	   HomePage hp = new HomePage(driver);
	   
	   OrganizationsPage op = new OrganizationsPage(driver);
	
	   CreateNewOrganizationPage co = new CreateNewOrganizationPage(driver);
	  OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	  ContactInfoPage cip = new ContactInfoPage(driver);
	   ContactPage cp = new ContactPage(driver);	
	   createContactPage ccp= new createContactPage(driver);
		
		hp.getOrganisationlink().click();
		op.createOrganisation();
		co.createNewOrganisation(orgName);
		System.out.println(orgName);
//		WebElement ele = oip.getHeaderinfo();
//		wu.waitForElementPresent(driver, ele, 5);
		Thread.sleep(2000);
		
		String headerinfo = oip.getHeaderinfo().getText();
		String actOrgname = oip.getOrgNameinfo().getText();
		if(headerinfo.contains(orgName)) {
			System.out.println(orgName + "is created");
		}
		else {
			System.out.println(orgName + "is not created");
		}
		
		if(actOrgname.equals(orgName)) {
			System.out.println(orgName + "is created==PASS");
		}
		else {
			System.out.println(orgName + "is not created==FAIL");
		}
		
		
		hp.opencontactpage();
		 cp.clickNewContact();
		ccp.createContactWithOrg(Lastname, orgName);
		
		
		
		Thread.sleep(2000);
		String actlastName =cip.getLastnameInfo().getText();
		if(actlastName.equals(Lastname)) {
			System.out.println(Lastname + "is created");
		}
		else {
			System.out.println(Lastname + "is not created");
			Thread.sleep(2000);
		String actOrgname1= cip.getOrgnameInfo().getText();
		if(actOrgname1.trim().equals(orgName)) {
			System.out.println(orgName + "is created==PASS");
		}
		else {
			System.out.println(orgName + "is not created==FAIL");
		}
		



	}
	}
}




