package com.comcast.crm.generic.webdriverutility;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import  org.openqa.selenium.io.FileHandler;

public class WebDriverUtility {
	
	public void waitForPageToLoad(WebDriver driver,int seconds) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	public void minimiseThePage(WebDriver driver) {
		driver.manage().window().minimize();
		
	}
	public void maximiseThePage(WebDriver driver) {
		driver.manage().window().maximize();
		
	}
	public void waitForElementPresent(WebDriver driver,WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds (seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.elementToBeSelected(element));
		wait.until(ExpectedConditions.alertIsPresent());
		wait.until(ExpectedConditions.invisibilityOfAllElements(element));
	}
	
	public void switchToTabonUrl(WebDriver driver,String PartialUrl ) {// to child window
		Set<String> set=driver.getWindowHandles();
		Iterator<String> ite= set.iterator();
		
		while(ite.hasNext()) {
			
			String windowID = ite.next();
			driver.switchTo().window(windowID);
			
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(PartialUrl)) {
				break;
			}
		}
		
	}
	public void switchToTaTitle(WebDriver driver,String PartialTitle ) {// to child window
		Set<String> set=driver.getWindowHandles();
		Iterator<String> ite= set.iterator();
		
		while(ite.hasNext()) {
			
			String windowID = ite.next();
			driver.switchTo().window(windowID);
			
			String actUrl = driver.getTitle();
			if(actUrl.contains(PartialTitle)) {
				break;
			}
		}
		
	}
	public void switchToFrame(WebDriver driver, int Index) {
		driver.switchTo().frame(Index);
	}
	public void switchToFrame(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchBackToFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	public void switchBackToFrame1(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	public void switchToAlertandAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchToAlertandDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void switchToAlertandGetText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	public void switchToAlertandSendKeys(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	
	public Select dropdown(WebElement element) {
		
		Select select = new Select(element);
		
		return select;
		
	}
	public void handleDropdown(WebElement element, int index) {
		dropdown(element).selectByIndex(index);
	}
	public void handleDropdown(WebElement element, String value) {
		dropdown(element).selectByValue(value);
	}
	public void handleDropdown( String text,WebElement element) {
		dropdown(element).selectByVisibleText(text);
	}
	
	public Actions MouseActions(WebDriver driver) {
		
		Actions act = new Actions(driver);
		return act;
			
	}
	public void mouseHover(WebDriver driver, WebElement element) {
		
		MouseActions(driver).moveToElement(element).perform();
	}
	
	public void dragAndDrop(WebDriver driver, WebElement source , WebElement target) {
		MouseActions(driver).dragAndDrop(source, target).perform();
	}
	public void rightClick(WebDriver driver, WebElement element) {
		MouseActions(driver).contextClick(element).perform();
		
	}
	public void scrollToElement(WebDriver driver, WebElement element) {
		MouseActions(driver).scrollToElement(element).perform();
		
	}
	public void clickElement(WebDriver driver, WebElement element) {
		MouseActions(driver).click(element).perform();
		
	}
	
	public void scrollByAmount(WebDriver driver, int x, int y) {
		MouseActions(driver).scrollByAmount(x, y).perform();
		
	}
	public void keyDown(WebDriver driver) {
		MouseActions(driver).keyDown(Keys.ENTER).perform();
		
	}
	public void  clickAndHold(WebDriver driver, WebElement element) {
		MouseActions(driver).clickAndHold(element).perform();
		
	}
	
	public void scrollUntilTheElementisVisible(WebDriver driver, WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor)driver;
		int y = element.getLocation().getY(); // get the location from where it need to scroll
		je.executeScript("window.scrollBy(0,"+y+")");
			
		}
	public void scrollToElement1(WebDriver driver, WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView()",element);
			
		}
	public void toClick(WebDriver driver, WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].click()",element);
			
		}
	public void takeScreenshot(WebDriver driver, String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File src = new File("./errorshots"+filename+".png");
		FileHandler.copy(temp, src);
	}
	
	public void robotActions(WebDriver driver) throws AWTException {
		
		Robot rob = new Robot();
		rob.keyPress(0);
		
	}
	
	
	
	
	 
	
	
	
	
	
	

}
