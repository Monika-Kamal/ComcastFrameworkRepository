package Screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;



public class SampleTestForScreenshot {

	@Test
	public void amazonTest() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://mvnrepository.com/");
	
		
		//create an object of eventFiring WebDriver
		EventFiringWebDriver edriver= new EventFiringWebDriver(driver);
		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		//step2: use getscreenshotAs method to get file type of screenshot
		//store screenshot in local drive
		FileUtils.copyFile(srcFile, new File("./errorshots/test.png"));
				driver.quit();
	}
	@Test
	public void amazonWebElementTest() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
	WebElement locationtext = driver.findElement(By.id("nav-global-location-popover-link"));
		
		//create an object of eventFiring WebDriver
		EventFiringWebDriver edriver= new EventFiringWebDriver(driver);
		File srcFile = locationtext.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./errorshots/LocationText.png");
		//step2: use getscreenshotAs method to get file type of screenshot
		//store screenshot in local driver
		FileUtils.copyFile(srcFile,destFile);
		driver.quit();
	}
	
	
}
