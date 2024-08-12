package practice.assertionHomeTest;

import java.lang.reflect.Method;


import org.testng.annotations.Test;

import com.comcas.crm.objectrepository.HomePage;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.crm.comcast.baseUtility.BaseClass;





public class HomePageVerificationTest extends BaseClass {
	
@Test
public void homePageTest(Method mtd) {
	System.out.println(mtd.getName()+"Test Starts");
	WebDriverUtility wLib = new WebDriverUtility();
	HomePage hp = new HomePage(driver);
	wLib.waitForPageToLoad(driver, 10);
	hp.home();
	System.out.println(mtd.getName()+"Test Ends");
	
}
@Test
public void verifyHomePageLogoTest(Method mtd) {
	System.out.println(mtd.getName()+"Test Strats");
	WebDriverUtility wLib = new WebDriverUtility();
	HomePage hp = new HomePage(driver);
	wLib.waitForPageToLoad(driver, 10);
	hp.homeimg();
	System.out.println(mtd.getName()+"Test Ends");
}
}
