package com.comcas.crm.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;




public class createContactPage {
	WebDriver driver;
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(name="support_start_date")
	private WebElement startdate;
	
	@FindBy(name="support_end_date")
	private WebElement enddate;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement addicon;
	
	@FindBy(name="button")
	private WebElement savebtn;

	@FindBy(name="search_text")
	private WebElement searchtext;
	@FindBy(name="search")
	private WebElement seachbtn;
	
	


	public createContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getLastname() {
		return lastname;
	}


	public WebElement getStartdate() {
		return startdate;
	}

	public WebElement getEndate() {
		return enddate;
	}
	public WebElement getAddicon() {
		return addicon;
	}
	public WebElement getEnddate() {
		return enddate;
	}


	public WebElement getSearchtext() {
		return searchtext;
	}


	public WebElement getSeachbtn() {
		return seachbtn;
	}


	

	public WebElement getSavebtn() {
		return savebtn;
	}
	public void createNewContact(String name) {
		lastname.sendKeys(name);
		
		savebtn.click();
		
	}
	public void createContactWithDate(String name, String startDate , String endDate) {
		lastname.sendKeys(name);
		startdate.clear();
		startdate.sendKeys(startDate);
		enddate.clear();
		enddate.sendKeys(endDate);
		savebtn.click();
	}
	WebDriverUtility wlib = new WebDriverUtility();
	public void createContactWithOrg(String name, String orgname) throws InterruptedException {
		lastname.sendKeys(name);
		addicon.click();
		wlib.switchToTabonUrl(driver, "module=Accounts");
		searchtext.sendKeys(orgname);
		seachbtn.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		wlib.switchToTabonUrl(driver,"module=Contacts" );
		savebtn.click();
		
		
	}
	
}
