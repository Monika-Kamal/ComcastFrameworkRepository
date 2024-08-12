package practice.testng;

import org.testng.annotations.DataProvider;

public class dataProvider {
	@DataProvider
	public Object[][] getData() {
		
		Object[][] objArr = new Object[3][3];
		
		objArr[0][0]="Deepak";
		objArr[0][1]="HR";
		objArr[0][2]=8778789098l;
		
		objArr[1][0]="Moni";
		objArr[1][1]="Kamal";
		objArr[1][2]=8778780725l;
		
		objArr[2][0]="John";
		objArr[2][1]="Mathew";
		objArr[2][2]=7708817471l;
		
		
		return objArr;
	}
}
