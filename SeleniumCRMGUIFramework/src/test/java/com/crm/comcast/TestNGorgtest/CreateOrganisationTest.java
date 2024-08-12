package com.crm.comcast.TestNGorgtest;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcas.crm.objectrepository.CreateNewOrganizationPage;
import com.comcas.crm.objectrepository.HomePage;

import com.comcas.crm.objectrepository.OrganizationInfoPage;
import com.comcas.crm.objectrepository.OrganizationsPage;

import com.crm.comcast.baseUtility.BaseClass;

public class CreateOrganisationTest extends BaseClass {

	@Test(groups = "smokeTest")
					public void createNewOrg() throws EncryptedDocumentException, IOException, Throwable {
					
					//
		           String orgName=eLib.getdataFromExcel("organisation", 4, 2)+jLib.getRandomNumber();
				     
				     System.out.println(orgName);
				     

				   HomePage hp = new HomePage(driver);
				   hp.getOrganisationlink().click();
				   OrganizationsPage op = new OrganizationsPage(driver);
				   op.createOrganisation();
				   CreateNewOrganizationPage co = new CreateNewOrganizationPage(driver);
				   co.createNewOrganisation(orgName);
				   Thread.sleep(2000);
				   OrganizationInfoPage oip=new OrganizationInfoPage(driver);
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
					

	}
	@Test
	public void createOrgWithIndustry() throws EncryptedDocumentException, IOException {

		  String orgName=eLib.getdataFromExcel("Organisation", 4, 2)+jLib.getRandomNumber();
		
	     String IndustryName=eLib.getdataFromExcel("Organisation", 4, 3).toString();
	     String Type=eLib.getdataFromExcel("Organisation", 4, 4).toString();
	     //double data = cell.getNumericCellValue();
	     System.out.println(orgName);
		
		
		
		   HomePage hp = new HomePage(driver);
		   
		   OrganizationsPage op = new OrganizationsPage(driver);
		
		   CreateNewOrganizationPage co = new CreateNewOrganizationPage(driver);
		   OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		  
		  
			hp.getOrganisationlink().click();
			op.createOrganisation();
			
			
		WebElement wbselect = co.getIndustry();
		wu.handleDropdown(IndustryName, wbselect);

		WebElement wbselect1 = co.getType();
		wu.handleDropdown(Type, wbselect1);
		co.createNewOrganisationwithindustry(orgName,IndustryName, Type);
	
		String actIndustry = oip.getIndustryInfo().getText();
		if(actIndustry.equals(IndustryName)) {
			System.out.println(actIndustry + " information is vefrified");
		}
		else {
			System.out.println(actIndustry + " information is not vefrified");
		}
		
		//to verify type
		String actType = oip.getTypeInfo().getText();
		if(actType.equals(Type)) {
			System.out.println(actType + " information is vefrified");
		}
		else {
			System.out.println(actType + " information is not vefrified");
		}
	}

}
