package vTiger.ContactsTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationPage;

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
		
		String CONNAME=eUtil.readDataFromExcelFile("ContactSheet", 1, 2);
		String ORGNAME=eUtil.readDataFromExcelFile("ContactSheet", 4, 3);
		System.out.println(ORGNAME);
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
		
		//Step 3: Navigate to Create Organization link
		HomePage hp=new HomePage(driver);
		hp.clickOrganizationLink();
	
		//Step 4:Click on create organization Lookup image
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOrganizatoinLookUpImg();
		
		//Step 5:Create Organization with Mnadatory fields
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME+RanNum);
		
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println("=== PASS ===ORGANIZATION CREATED SUCESSFULLY");
		}
		else
		{
			System.out.println("=== FAIL ===FAILED TO CREATE ORGANIZATION");
		}
		
		
		//Step 6: Navigate to Create Contact link
				
		hp.clickConatctsLink();
			
		//Step 7:Click on create Contact Lookup image
		ContactPage cp=new ContactPage(driver);
		cp.clickContactLookUpimg();
				
		//Step 8:Create contact with Mnadatory fields
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(driver, CONNAME, ORGNAME+RanNum);
				
		String ContactName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ContactName.contains(CONNAME))
		{
				System.out.println("====Pass====CONTACT CREATED SUCESSFULLY");
		}
		else
		{
			System.out.println("====Fail=====FAILD TO CREATE CONTACT");
		}
				
		
		//Step 10:Logout
		hp.signOutApp(driver);
		
		System.out.println("==========Logout Sucessfully");
	
	}


}
