package vTiger.ContactsTest;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilites.BaseClass;
import vTiger.GenericUtilites.ExcelFileUtility;
import vTiger.GenericUtilites.JavaUtility;
import vTiger.GenericUtilites.PropertyFileUtility;
import vTiger.GenericUtilites.WebDriverUtilites;
import vTiger.ObjectRepository.ContactPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;


@Listeners(vTiger.GenericUtilites.ListenerImplementationClass.class)
public class CreateContactTest extends BaseClass {

@Test(groups = "regression")
	public void createContact() throws EncryptedDocumentException, IOException
	{

	
	String CONNAME=eUtil.readDataFromExcelFile("ContactSheet", 1, 2);
	int RanNum=jUtil.getRandomNumber();

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
	
	
	//Assert.fail();
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
	}
	//Step 8:Logout
	
	@Test(groups = "smoke")
	public void sample()
	{
		System.out.println("hello from smoke");
	}
	
}
