package practice.testng;


import org.testng.annotations.Test;

public class createContactWithdataProvidertest {
	
	@Test(dataProvider = "getData", dataProviderClass = dataProvider.class)
	public void createContactTest(String firstname, String lastname, long phoneNumber) {
		
		System.out.println("FirstName :"+ firstname +"LastName :"+ lastname+"phone :"+ phoneNumber);
	}
	
	

}
