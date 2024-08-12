package Screenshots;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InvoiceTest1 {
	@Test(retryAnalyzer =com.comcasrt.crm.listnerUtility.RetryListnerImp.class)
	public void createInvoiceTest() {
		System.out.println("execute createInvoiceTest");
		Assert.assertEquals(" ", "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
}
}

