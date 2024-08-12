package practice.testng;

import org.testng.annotations.Test;

public class contactTest {
//	
//	@Test(priority = -1)
//	 public void createConatctTest() {
//		System.out.println("execute createConatctTest");
//	}
//	
//	@Test(priority = 0)
//	public void modifyContactTest() {
//		System.out.println("execute modifyContactTest");
//	}
//	
//	@Test(priority = 1)
//	public void deleteContactTest() {
//		System.out.println("execute deleteCpntactatest");
//	}
	

	@Test
	 public void createConatctTest() {
		System.out.println("execute createConatctTest");
	}
	
	@Test(dependsOnMethods = "createConatctTest")
	public void modifyContactTest() {
		System.out.println("execute modifyContactTest");
	}
	
	@Test(dependsOnMethods = "modifyContactTest")
	public void deleteContactTest() {
		System.out.println("execute deleteCpntactatest");
	}

}
