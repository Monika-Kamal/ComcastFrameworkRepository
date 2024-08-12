package com.comcas.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	WebElement contactlink;
	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactlink() {
		return contactlink;
	}
	public void clickNewContact() {
		contactlink.click();
	}

}
