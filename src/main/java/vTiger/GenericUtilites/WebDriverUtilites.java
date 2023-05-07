package vTiger.GenericUtilites;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;


/*
 * 
 * This class contains all the generic method related to WebDriver Actions
 */
public class WebDriverUtilites {

	/**
	 * This method will maximize window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	
	/**
	 * This method will wait for 20 seconds foe the page get loaded
	 * 
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	/**
	 * This method will wait until an element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementTobeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	/**
	 * this method will wait until an element clickable
	 * @param drievr
	 * @param element
	 */
	public void elementToBeClickable(WebDriver drievr,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(drievr, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will handle the drop down with the index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	
	/**
	 * This method will handle dropdown with the help of value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	
	
	/**
	 * This method will handle drop down by visible text
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text,WebElement element)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	
	/**
	 * This method will perform mose hover action on a webelement
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	
	/**
	 * This method will perform mouse hover action based on offset
	 * @param driver
	 * @param element
	 * @param x
	 * @param y
	 */
	
	public void mouseHoverAction(WebDriver driver,WebElement element,int x,int y)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element, x, y);
	}
	
	
	/**
	 * This method will perform right click action anywhere on the page
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform right click action on particular element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	
	/**
	 * this method will double click anywhere on the screen
	 * @param driver
	 */
	
	public void doubleClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will double click on a web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param srcEle
	 * @param dstEle
	 */
	public void dragAndDropAction(WebDriver driver,WebElement srcEle,WebElement dstEle)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(srcEle, dstEle).perform();
	}
	
	/**
	 * This method will press and release enter key
	 * @throws AWTException
	 */
	public void pressEnter() throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * this method will handle frame based on index
	 * @param driver
	 * @param index
	 */
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame based on name or id
	 * @param driver
	 * @param nameOrId
	 */
	
	public void switchToFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method will handle frame based on web element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**This method will switch the control to immediate parent frame
	 * 
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch the control to the default frame
	 * @param driver
	 */
	public void switcToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	
	/**
	 * This method will acceptAlert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will get the alert text
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * THIs method will take screenShot and return the path of destination
	 * @param driver
	 * @param ScreenShotName
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver,String ScreenShotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		 File src=ts.getScreenshotAs(OutputType.FILE);
		 File dest=new File(".\\ScreenShots\\"+ScreenShotName+".png");// here double slash to store inside the folder
		 Files.copy(src, dest);
		 return dest.getAbsolutePath();//get absolute path will return complete workspace path
		 //D:/MavenProjects/AutomationfframeWork.qco../ScreeShots/Name.png
		 //get absolute path used in extent report
		 
	}
	
	
	/**
	 * This method will perform random scroll Action
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)"," ");
		//0---->horozontal +ve right -ve left
		//500--->vertical +down -ve upwards
	
	}
	
	/**
	 * This method will switch to window based on Window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle) 
	{
		//Step 1: Capture all the window IDs
		Set<String> allWinId = driver.getWindowHandles();
		
		//Step 2:Naviagte to each window
		for(String  winID:allWinId)
		{
			//Step 3:switch to each window capture the title
			 String actTitle = driver.switchTo().window(winID).getTitle();
			 
			 
			 //Step 4:Compare the title with required title
			if(actTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
