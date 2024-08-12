package Screenshots;

import org.testng.Assert;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.baseUtility.BaseClass;
//@Listeners(com.comcasrt.crm.listnerUtility.ListnerImplementationClass.class)
public class InvoiceTest extends BaseClass{

	@Test
	public void createInvoiceTest() {
		System.out.println("execute createInvoiceTest");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	@Test
	public void createInvoicsTestWithContactTest() {
		System.out.println("execute createInvoicewithContactTest");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
}
