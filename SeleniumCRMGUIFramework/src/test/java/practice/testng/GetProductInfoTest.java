package practice.testng;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class GetProductInfoTest {

	@Test(dataProvider = "getData")
	public void getProductInfotest(String brandName , String productName) {
		WebDriverUtility wb = new WebDriverUtility();
		
		WebDriver driver = new ChromeDriver();
		wb.maximiseThePage(driver);
		wb.waitForPageToLoad(driver, 10);
		
		driver.get("https://www.amazon.in/");
		
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName, Keys.ENTER);
		
		//capture product info
		String x = "//span[text()='"+productName+"']/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		String price =driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		
	}
	
	
	@DataProvider
    public Object[][] getData() throws EncryptedDocumentException, IOException {
		
		ExcelUtility elib = new ExcelUtility();
		int rowCount =elib.rowCOunt("product");
		
		Object[][] objArr = new Object[rowCount][2];
		
		for(int i=0;i<rowCount;i++) {
		objArr[i][0]=elib.getdataFromExcel("product", i+1, 0);
	    objArr[i][1]=elib.getdataFromExcel("product", i+1, 1);

		
		}
		
		return objArr;
}
}


