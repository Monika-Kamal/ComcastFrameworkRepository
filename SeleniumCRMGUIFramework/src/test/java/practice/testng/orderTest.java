package practice.testng;

import org.testng.annotations.Test;

public class orderTest {

	@Test(invocationCount = 3)
	public void createOrderTest() {
		System.out.println("execute OrderTest");
		
	}
	
	@Test(dependsOnMethods = "createOrderTest", enabled = false)
	public void billingAnOrder() {
		System.out.println("execute billingAnOrder");
	}
}
