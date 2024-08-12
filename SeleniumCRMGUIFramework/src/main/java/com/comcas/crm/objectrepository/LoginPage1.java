package com.comcas.crm.objectrepository;

/**
 * class contains login page elements and business library like login
 * @author Monika
 * 
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {
	// created seperate java class for login page
	// object creation
	WebDriver driver; // initializing globaaly to make use of it in another method

	public LoginPage1(WebDriver driver) { // take care of initializing the object
		this.driver = driver; // in order to avoid the confusion as we are passing the same name in
								// constructor and other methods
		PageFactory.initElements(driver, this); // this refers current class object
	}

	@FindBy(name = "user_name")
	private WebElement usernameEdit;

	@FindBy(name = "user_password")
	private WebElement passwordEdit;

	@FindBy(id = "submitButton")
	private WebElement LoginBtn;

	// object initialization
	// object encapsulation

	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}

	/**
	 * Login to application with username and password
	 * 
	 * @param username
	 * @param password
	 */
	// provide Action--> Business libraries--> cannot used for any other application
	public void LoginToApp(String username, String password) {
		driver.manage().window().maximize();
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		LoginBtn.click();
	}

}
