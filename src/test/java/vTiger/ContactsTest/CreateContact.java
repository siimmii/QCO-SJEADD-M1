package vTiger.ContactsTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilites.ExcelFileUtility;
import vTiger.GenericUtilites.JavaUtility;
import vTiger.GenericUtilites.PropertyFileUtility;
import vTiger.GenericUtilites.WebDriverUtilites;
import vTiger.ObjectRepository.ContactPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class CreateContact {
	
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
		
		String CONNAME=eUtil.readDataFromExcelFile("ContactSheet", 1, 2);
		int RanNum=jUtil.getRandomNumber();
	
		
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
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Step 3: Navigate to Create Contact link
		HomePage hp=new HomePage(driver);
		hp.clickConatctsLink();
	
		//Step 4:Click on create Contact Lookup image
		ContactPage cp=new ContactPage(driver);
		cp.clickContactLookUpimg();
		
		//Step 5:Create contact with Mnadatory fields
		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		cnp.createNewContact(CONNAME+RanNum);
		//driver.findElement(By.name("lastname")).sendKeys(CONNAME+RanNum);
		
		//Step 6:Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step 7: Validation
		String ContactName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ContactName.contains(CONNAME))
		{
			System.out.println("====Pass====");
		}
		else
		{
			System.out.println("====Fail=====");
		}
		
		//Step 8:Logout
		hp.signOutApp(driver);
		
		System.out.println("==========Logout Sucessfully");
	
	}


}
