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
import vTiger.ObjectRepository.CreateNewLeadSource;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LeadSourcePage;
import vTiger.ObjectRepository.LoginPage;

public class CreateNewContactWithLeadSource {

	public static void main(String[] args) throws IOException {
		
		//create Object for all utilities
		JavaUtility jUtil=new JavaUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		WebDriverUtilites wUtil=new WebDriverUtilites();
		
		//read all the required data
		String BROWSER=pUtil.readDataFormPropertyFile("browser");
		String USERNAME=pUtil.readDataFormPropertyFile("username");
		String PASSWORD=pUtil.readDataFormPropertyFile("password");
		String URL=pUtil.readDataFormPropertyFile("url");
		
		String LASTNAME = eUtil.readDataFromExcelFile("LeadSourceSheet", 1, 2);
		String COMPANY = eUtil.readDataFromExcelFile("LeadSourceSheet", 1, 3);
	
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
			System.out.println("==========Lead FAiled to createa");
		}
		hp.signOutApp(driver);
		
	}
}
