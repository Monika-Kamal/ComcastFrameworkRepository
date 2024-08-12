package com.comcas.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerinfo;
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement OrgNameinfo;
	@FindBy(id="dtlview_Industry")
	private WebElement industryInfo;
	@FindBy(id="dtlview_Type")
	private WebElement typeInfo;
	@FindBy(id="dtlview_Phone")
	private WebElement phoneInfo;
	
	
	public OrganizationInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderinfo() {
		return headerinfo;
	}

	public WebElement getOrgNameinfo() {
		return OrgNameinfo;
	}
	public WebElement getIndustryInfo() {
		return industryInfo;
	}

	public WebElement getTypeInfo() {
		return typeInfo;
	}

	public WebElement getPhoneInfo() {
		return phoneInfo;
	}

	
	
	
	
	 
	


	
}


