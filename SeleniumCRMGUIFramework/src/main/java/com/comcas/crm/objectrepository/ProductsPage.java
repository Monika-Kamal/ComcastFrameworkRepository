package com.comcas.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement createProductLink;
	
	@FindBy(name="searcBtn")
	private WebElement searchButton;
	
	@FindBy(name="searcBtn2")
	private WebElement searchButton2;
	
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void productPgaeTest() {
		createProductLink.click();
	}
}
