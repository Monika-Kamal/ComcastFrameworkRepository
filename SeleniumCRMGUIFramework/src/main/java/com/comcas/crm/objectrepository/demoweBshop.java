package com.comcas.crm.objectrepository;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.PageFactory;

public class demoweBshop {
	@FindBy(xpath="//span[contains(text(),'Shopping cart')]")
	private WebElement cart;

	public WebElement getCart() {
		return cart;
	}
	public demoweBshop(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void cart() {
		cart.click();
	}
}
