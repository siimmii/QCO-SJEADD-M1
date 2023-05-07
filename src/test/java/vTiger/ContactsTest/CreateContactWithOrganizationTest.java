package vTiger.ContactsTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilites.BaseClass;
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

public class CreateContactWithOrganizationTest extends BaseClass {

	@Test
	public void createContactWithOrg() throws EncryptedDocumentException, IOException
	{
		
		
		String CONNAME=eUtil.readDataFromExcelFile("ContactSheet", 1, 2);
		String ORGNAME=eUtil.readDataFromExcelFile("ContactSheet", 4, 3);
		System.out.println(ORGNAME);
		int RanNum=jUtil.getRandomNumber();
		
		//Step 3: Navigate to Create Organization link
		HomePage hp=new HomePage(driver);
		hp.clickOrganizationLink();
	
		//Step 4:Click on create organization Lookup image
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOrganizatoinLookUpImg();
		
		//Step 5:Create Organization with Mnadatory fields
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME+RanNum);
		
		//failing to test screenshot
		//Assert.fail();
		wUtil.takeScreenShot(driver,"createContact");
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
				
		//logout
	}
	
}
