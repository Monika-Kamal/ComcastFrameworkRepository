package com.comcas.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	@FindBy(id="dtlview_Last Name")
	private WebElement lastnameInfo;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement StartDateInfo;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement EndDateInfo;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgnameInfo;
	
	
	public ContactInfoPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastnameInfo() {
		return lastnameInfo;
	}

	public WebElement getStartDateInfo() {
		return StartDateInfo;
	}

	public WebElement getEndDateInfo() {
		return EndDateInfo;
	}

	public WebElement getOrgnameInfo() {
		return orgnameInfo;
	}
	
	

}
