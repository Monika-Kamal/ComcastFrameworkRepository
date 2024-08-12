package com.comcas.crm.objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class OrganizationsPage {
	WebDriver driver;
	
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement Createorganisationlink;
	
	@FindBy(xpath="//a[@title='Organizations']")
	private List<WebElement> orglist;
	
	@FindBy(name="search_text")
	WebElement searchtxt;
	
	@FindBy(name="search_field")
	WebElement searchdrop;
	
	@FindBy(name="submit")
	WebElement searchbtn;
	
	
	public OrganizationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getCreateorganisationlink() {
		return Createorganisationlink;
	}
	
	public WebElement getSearchtxt() {
		return searchtxt;
	}
	public WebElement getSearchdrop() {
		return searchdrop;
	}
	public WebElement getSearchbtn() {
		return searchbtn;
	}
public void createOrganisation() {
		
		Createorganisationlink.click();
	}
	public void listOgOrg() {
		for(WebElement e : orglist) {
			
			String listorg = e.getText();
			System.out.println(listorg);
		}
	}

}
