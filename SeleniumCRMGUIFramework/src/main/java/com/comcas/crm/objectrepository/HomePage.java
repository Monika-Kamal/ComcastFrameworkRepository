package com.comcas.crm.objectrepository;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage {
	
	WebDriver driver;
	@FindBy(xpath="//a[contains(text(),'Home')]")
	private WebElement home;
	
	@FindBy(xpath = "//img[@alt=\"vtiger-crm-logo.gif\"]")
	private WebElement homeimg;

	@FindBy(linkText="Organizations")
	private WebElement organisationlink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactslink;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement administratorIcon;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutLink;
	@FindBy(xpath = "//a[@href=\"/books\"]")
	private WebElement BooksLink;
	@FindBy(xpath="//input[@onclick=\"AjaxCart.addproducttocart_catalog('/addproducttocart/catalog/13/1/1    ');return false;\"]")
	private WebElement AddtoCart1;
	@FindBy(xpath="//a[text()='Health Book']/../../div[3]/div/span[2]")
	private WebElement price;

	

	
	public WebElement getAddtoCart1() {
		return AddtoCart1;
	}

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganisationlink() {
		return organisationlink;
	}

	
	public WebElement getContactslink() {
		return contactslink;
	}
	public void opencontactpage() {
    	contactslink.click();
    }

    public WebElement getAdministratorIcon() {
		return administratorIcon;
	}
    public WebElement getSignOutlink() {
		return signOutLink;
	}
   
    
	public WebElement getHome() {
		return home;
	}
	public WebElement getHomeimg() {
		return homeimg;
	}
	public WebElement getBooksLink() {
		return BooksLink;
	}


	public void logoutApp() throws InterruptedException {
		WebDriverUtility wLib = new WebDriverUtility();
		Thread.sleep(2000);
		administratorIcon.click();
		wLib.mouseHover(driver, signOutLink);
		wLib.clickElement(driver, signOutLink);
		
	}
	public void home() {
		String expectedHome = "Home page";
		String acthome = home.getText();
//		if(acthome.trim().equals(expectedHome)) {
//			System.out.println(expectedHome + "is verified");
//		}
//		else {
//			System.out.println(expectedHome + "is not verified");
//		}
		//Hard assert
		Assert.assertEquals(acthome, expectedHome);
			
	}
	public void homeimg() {
		boolean status = homeimg.isEnabled();
//		if(status) {
//			System.out.println("logo is verified");
//		}
//		else {
//			System.out.println("logo is not verified");
//		}
		//Hard Assert
		//Assert.assertEquals(true, status);
		//or
		Assert.assertTrue(status);
	}
	public void homelinkTest() throws IOException {
		BooksLink.click();
		AddtoCart1.click();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./errorshots/price1.png");
		FileUtils.copyFile(src, dest);
		
		
	}
}
