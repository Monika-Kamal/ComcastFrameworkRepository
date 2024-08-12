package practice.assertionHomeTest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;




public class SampleHardassertionTest {
	@Test
	public void homePageTest(Method mtd) {
		
		SoftAssert assertObj = new SoftAssert();
		Reporter.log(mtd.getName()+"Test Starts",true);
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		Assert.assertEquals("Home", "Home");
		Reporter.log("step-3",true);
		assertObj.assertEquals("Home-CRM", "Home-CRM");
		Reporter.log("step-4",true);
		assertObj.assertAll();//collect the expection and print it and also it fails the test script
		Reporter.log(mtd.getName()+"Test Ends",true);
		
	}
	@Test
	public void verifyHomePageLogoTest(Method mtd) {
		Reporter.log(mtd.getName()+"Test Strats",true);
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		Assert.assertTrue(true);
		Reporter.log("step-3",true);
		Reporter.log("step-4",true);
		Reporter.log(mtd.getName()+"Test Ends",true);
	}
	

}

