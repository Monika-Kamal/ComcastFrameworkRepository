package com.comcast.crm.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;


import com.comcas.crm.objectrepository.CreateNewOrganizationPage;
import com.comcas.crm.objectrepository.HomePage;

import com.comcas.crm.objectrepository.OrganizationInfoPage;
import com.comcas.crm.objectrepository.OrganizationsPage;

import com.crm.comcast.baseUtility.BaseClass;
//@Listeners(com.comcasrt.crm.listnerUtility.ListnerImplementationClass.class)
public class CreateOrganisationTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createNewOrg() throws EncryptedDocumentException, IOException, Throwable {

		// Inorder to having the low level report we need to add logs for each teststep
		//UtilityClassObject.getTest().log(Status.INFO, "read data from excel file");
		String orgName = eLib.getdataFromExcel("organisation", 4, 2) + jLib.getRandomNumber();

		System.out.println(orgName);
		//UtilityClassObject.getTest().log(Status.INFO, "navigate to home page");
		HomePage hp = new HomePage(driver);
		hp.getOrganisationlink().click();
		//UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
		OrganizationsPage op = new OrganizationsPage(driver);
		op.createOrganisation();
		//UtilityClassObject.getTest().log(Status.INFO, "create org page");
		CreateNewOrganizationPage co = new CreateNewOrganizationPage(driver);
		co.createNewOrganisation(orgName);

		Thread.sleep(2000);
		//UtilityClassObject.getTest().log(Status.INFO, "org created");
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String headerinfo = oip.getHeaderinfo().getText();

		String actOrgname = oip.getOrgNameinfo().getText();

		if (headerinfo.contains(orgName)) {
			System.out.println(orgName + "is created");
		} else {
			System.out.println(orgName + "is not created");
		}

		if (actOrgname.equals(orgName)) {
			System.out.println(orgName + "is created==PASS");
		} else {
			System.out.println(orgName + "is not created==FAIL");
		}
		

	}

	@Test(groups = "RegressionTest")
	public void createOrgWithIndustry() throws EncryptedDocumentException, IOException, InterruptedException {

		String orgName = eLib.getdataFromExcel("Organisation", 4, 2) + jLib.getRandomNumber();

		String IndustryName = eLib.getdataFromExcel("Organisation", 4, 3).toString();
		String Type = eLib.getdataFromExcel("Organisation", 4, 4).toString();
		// double data = cell.getNumericCellValue();
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
		co.createNewOrganisationwithindustry(orgName, IndustryName, Type);
		Thread.sleep(2000);
		String actIndustry = oip.getIndustryInfo().getText();
		if (actIndustry.equals(IndustryName)) {
			System.out.println(actIndustry + " information is vefrified");
		} else {
			System.out.println(actIndustry + " information is not vefrified");
		}
		Thread.sleep(2000);
		// to verify type
		String actType = oip.getTypeInfo().getText();
		if (actType.equals(Type)) {
			System.out.println(actType + " information is vefrified");
		} else {
			System.out.println(actType + " information is not vefrified");
		}
	}

	@Test(groups = "RegressionTest")
	public void createOrgWithPhone() throws EncryptedDocumentException, IOException, InterruptedException {
		String orgName = eLib.getdataFromExcel("Organisation", 4, 2) + jLib.getRandomNumber();
		String mobile = eLib.getdataFromExcel("Organisation", 4, 5);
		String IndustryName = eLib.getdataFromExcel("Organisation", 4, 3).toString();
		String Type = eLib.getdataFromExcel("Organisation", 4, 4).toString();

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

		co.createNewOrganisationwithmobile(orgName, IndustryName, Type, mobile);
		Thread.sleep(2000);
		String actmobile1 = oip.getPhoneInfo().getText();
		if (actmobile1.equals(mobile)) {
			System.out.println(mobile + "is entered");
		} else {
			System.out.println(mobile + "is not entered");

		}

	}

}
