package vTiger.Practice;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilites.ExcelFileUtility;
import vTiger.GenericUtilites.JavaUtility;
import vTiger.GenericUtilites.PropertyFileUtility;
import vTiger.GenericUtilites.WebDriverUtilites;

public class CreateContactWithOrganization {

	public static void main(String[] args) throws IOException {
		
		
		//Create Object Of all Utilities
		
		JavaUtility jUtil=new JavaUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		WebDriverUtilites wUtil=new WebDriverUtilites();
				
	//Read all the required data
		String BROWSER=pUtil.readDataFormPropertyFile("browser");
		String USERNAME=pUtil.readDataFormPropertyFile("username");
		String PASSWORD=pUtil.readDataFormPropertyFile("password");
		String URL=pUtil.readDataFormPropertyFile("url");
		
	String ConNAME = eUtil.readDataFromExcelFile("ContactSheet", 2, 2);	
	String ORGNAME=eUtil.readDataFromExcelFile("OrganizationSheet", 1, 2);
	
	int RanNum=jUtil.getRandomNumber();
	//Launch the browser
	WebDriver driver=null;
	//Step 1:Launch the browser
	if(BROWSER.equalsIgnoreCase("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
				}
				else if(BROWSER.equalsIgnoreCase("edge"))
				{
					WebDriverManager.edgedriver().setup();
					driver=new EdgeDriver();
				}
				else if(BROWSER.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
				}
				else
				{
					System.out.println("Browser doesnt launched:Invalid browser name");
				}
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
					
				
	//Step 2:Login to Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	//Step 3:Navigate to create Organization Link
		driver.findElement(By.linkText("Organizations")).click();
	
	//Step 4: click on Create Organization Look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
						
	//Step 5: Create Organization with Mnadatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME+RanNum);
						
	//Step 6: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
	//Step 7: validate Organization
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println("=== PASS ===");
		}
		else
		{
			System.out.println("=== FAIL ===");
		}
		
	//Step 8:Navigate to Contact Link
		driver.findElement(By.linkText("Contacts")).click();
		
	//Step 9:Click on create Contact Lookup image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
	//Step 10:Create Organization with Mnadatory fields
		driver.findElement(By.name("lastname")).sendKeys(ConNAME+RanNum);
		
	//Step 11:Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	//step 12: Validation of contacts
		String ContactName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ContactName.contains(ConNAME))
		{
			System.out.println("====Pass====");
		}
		else
		{
			System.out.println("====Fail=====");
		}
		
	//Step 13:Logout
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, element);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("==========Logout Sucessfully");
	
	}

}
