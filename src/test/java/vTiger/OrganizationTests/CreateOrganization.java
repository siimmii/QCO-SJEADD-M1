package vTiger.OrganizationTests;

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
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationPage;

public class CreateOrganization {

public static void main(String[] args) throws IOException {
	JavaUtility jUtil=new JavaUtility();
	PropertyFileUtility pUtil=new PropertyFileUtility();
	ExcelFileUtility eUtil=new ExcelFileUtility();
	WebDriverUtilites wUtil=new WebDriverUtilites();
	
	//Read all the required data
	String BROWSER=pUtil.readDataFormPropertyFile("browser");
	String USERNAME=pUtil.readDataFormPropertyFile("username");
	String PASSWORD=pUtil.readDataFormPropertyFile("password");
	String URL=pUtil.readDataFormPropertyFile("url");
	
	String ORGNAME=eUtil.readDataFromExcelFile("OrganizationSheet", 1, 2);
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
	
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	
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
	hp.signOutApp(driver);
			
}
}
