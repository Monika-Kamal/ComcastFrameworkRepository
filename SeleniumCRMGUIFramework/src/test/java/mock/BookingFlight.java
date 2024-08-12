package mock;

import java.io.File;

import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BookingFlight {

	public static void main(String[] args) throws Throwable {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://in.via.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
/*	//Register	
 		driver.findElement(By.xpath("//span[text()=\"SIGN UP\"]")).click();	
		driver.findElement(By.id("emailIdSignUp")).sendKeys("xyz2000@gmail.com");
		driver.findElement(By.id("passwordSignUp")).sendKeys("Supriya@24");
		driver.findElement(By.id("nameSignUp")).sendKeys("Supriya");
		driver.findElement(By.id("mobileNoSignUp")).sendKeys("8778792689");
		driver.findElement(By.id("signUpValidate")).click();
*/		
	//login
		driver.findElement(By.id("loginIdText")).sendKeys("xyz2000@gmail.com");
		driver.findElement(By.id("passwordText")).sendKeys("Supriya@24");
		driver.findElement(By.id("loginValidate")).click();	
		
	//webpage screenshot
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/webpage_via.png");
		FileUtils.copyFile(src,dest);
	
	//booking
		driver.findElement(By.xpath("//input[@id=\"source\"]")).sendKeys("chennai");
		driver.findElement(By.xpath("//span[text()=\"Chennai,Chennai - India\"]")).click();
		
		driver.findElement(By.name("destination")).sendKeys("Bangal");
		driver.findElement(By.xpath("//span[text()=\"[BLR]\"]"));
		
		driver.findElement(By.xpath("//span[text()=\"Bangalore,Bangalore - India\"]")).click();
		driver.findElement(By.xpath("//div[@data-date=\"10\"]")).click();
		
		driver.findElement(By.id("search-flight-btn")).click();
		
/*		Thread.sleep(10);
		
		WebElement ele = driver.findElement(By.xpath("//input[@placeholder=\"Select Return Date\"]"));
		ele.click();
		
/*		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
*/
		driver.findElement(By.xpath("//div[contains(text(),\"AI-583\")]/ancestor::div[@class=\"fltDet\"]/following-sibling::div/div[2]/button")).click();
		driver.findElement(By.xpath("//div[text()=\"Book Flights\"]")).click();
	}
}
