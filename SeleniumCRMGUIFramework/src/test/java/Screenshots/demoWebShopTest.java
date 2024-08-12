package Screenshots;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class demoWebShopTest {
	@Test
	public void getScreenshotTest() throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[@href=\"/books\"]")).click();
		driver.findElement(By.xpath("//img[@alt='Picture of Health Book']")).click();
		driver.findElement(By.xpath("//input[@id='add-to-cart-button-22']")).click();
		WebElement price1 = driver.findElement(By.xpath("//div[@class=\"product-price\"]/span"));
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = price1.getScreenshotAs(OutputType.FILE);
		File dest = new File("./errorshots/price1.png");
		FileUtils.copyFile(src, dest);
		driver.navigate().back();
		driver.findElement(By.xpath("//img[@alt='Picture of Fiction']")).click();
		driver.findElement(By.id("add-to-cart-button-45")).click();
		WebElement price2 = driver.findElement(By.xpath("//div[@class=\"product-price\"]/span"));
		File src1 = price2.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("./errorshots/price2.png");
		FileUtils.copyFile(src1, dest1);

		WebElement cartPage = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
		cartPage.click();
		File src3 = ts.getScreenshotAs(OutputType.FILE);
		File dest3 = new File("./errorshots/cartPage.png");
		Thread.sleep(2000);
		FileUtils.copyFile(src3, dest3);
		driver.quit();

	}
}
