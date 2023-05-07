package vTiger.ContactsTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilites.BaseClass;
import vTiger.GenericUtilites.ExcelFileUtility;
import vTiger.GenericUtilites.JavaUtility;
import vTiger.GenericUtilites.PropertyFileUtility;
import vTiger.GenericUtilites.WebDriverUtilites;
import vTiger.ObjectRepository.CreateNewLeadSource;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LeadSourcePage;
import vTiger.ObjectRepository.LoginPage;

public class CreateContactWithLeadSourceTest extends BaseClass{
	
	@Test
	public void createContactWithLeadSource() throws EncryptedDocumentException, IOException
	{
	
				
				String LASTNAME = eUtil.readDataFromExcelFile("LeadSourceSheet", 1, 2);
				String COMPANY = eUtil.readDataFromExcelFile("LeadSourceSheet", 1, 3);
			
			int RanNum=jUtil.getRandomNumber();
			
			
			
				//Step 3: Navigate to Create Organization link
				HomePage hp=new HomePage(driver);
				hp.clickLeadLink();
				
				LeadSourcePage lsp=new LeadSourcePage(driver);
				lsp.clickLeadLookUpImg();
				
				CreateNewLeadSource cnl=new CreateNewLeadSource(driver);
				cnl.createNewLead(LASTNAME, COMPANY, driver);
				
				String LastName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(LastName.contains(LASTNAME))
				{
					System.out.println("=========Lead Created Sucessfully");
				}
				else
				{
					System.out.println("==========Lead FAiled to create");
				}
				
	}

}
