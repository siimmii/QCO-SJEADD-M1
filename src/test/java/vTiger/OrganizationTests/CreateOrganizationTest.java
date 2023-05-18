package vTiger.OrganizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilites.BaseClass;
import vTiger.GenericUtilites.ExcelFileUtility;
import vTiger.GenericUtilites.JavaUtility;
import vTiger.GenericUtilites.PropertyFileUtility;
import vTiger.GenericUtilites.WebDriverUtilites;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationPage;


@Listeners(vTiger.GenericUtilites.ListenerImplementationClass.class)
public class CreateOrganizationTest extends BaseClass {
	
	
	@Test(groups = "SmokeSuite")
	public void craeteOrganization() throws EncryptedDocumentException, IOException
	{
		
		
		String ORGNAME=eUtil.readDataFromExcelFile("OrganizationSheet", 1, 2);
		int RanNum=jUtil.getRandomNumber();

	
		
		HomePage hp=new HomePage(driver);
		hp.clickOrganizationLink();
		
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOrganizatoinLookUpImg();
		
		CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
		cnp.createNewOrganization(ORGNAME+RanNum);
		
		String OrgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgName.contains(ORGNAME))
		{
			System.out.println("====Pass====Organization created");
		}
		else
		{
			System.out.println("====Fail=====Organization creation Failed");
		}
		
		//Step 8:Logout
		
		
	}
	

}
