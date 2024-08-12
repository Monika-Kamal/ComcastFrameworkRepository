package com.comcas.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewOrganizationPage {
	WebDriver driver;
	@FindBy(name="accountname")
	private WebElement orgName;
	
	@FindBy(name="industry")
	private WebElement industry;
	
	@FindBy(name="accounttype")
	private WebElement type;
	
	@FindBy(name="phone")
	private WebElement phone;


	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	 
	public WebElement getOrgName() {
		return orgName;
	}
	

	public WebElement getIndustry() {
		return industry;
	}


	public WebElement getType() {
		return type;
	}
	
	public WebElement getPhone() {
		return phone;
	}


	public WebElement getSavebtn() {
		return savebtn;
	}


	public void createNewOrganisation(String value) {
		orgName.sendKeys(value);
		
		savebtn.click();
	}
	public void createNewOrganisationwithindustry(String orgvalue,String indValue , String typeValue) {
		orgName.sendKeys(orgvalue);
		industry.click();
		type.click();
        savebtn.click();
	}
        public void createNewOrganisationwithmobile(String orgvalue,String indValue , String typeValue, String phn) {
    		orgName.sendKeys(orgvalue);
    		industry.click();
    		type.click();
    		phone.sendKeys(phn);
            savebtn.click();
	
}
}
