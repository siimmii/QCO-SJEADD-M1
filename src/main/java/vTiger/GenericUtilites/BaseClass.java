package vTiger.GenericUtilites;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

/**
 * This class consists of all basic configuration annotations
 * @author akhil
 *
 */
public class BaseClass {

	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public JavaUtility jUtil=new JavaUtility();
	public WebDriverUtilites wUtil=new WebDriverUtilites();
	
	public WebDriver driver;
	public static WebDriver sDriver;
	
	
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("====Database Connection Sucessful");
	}
	
	//@Parameters("BROWSER")
	//@BeforeTest
	@BeforeClass
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String BROWSER = pUtil.readDataFormPropertyFile("browser");
		String URL=pUtil.readDataFormPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("======="+BROWSER+"Launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("======="+BROWSER+"Launched");
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println("======="+BROWSER+"Launched");
		}
		else
		{
			System.out.println("Invalid Browsername");
		}
		sDriver=driver;
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
	}
	
	@BeforeMethod
	
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFormPropertyFile("username");
		String PASSWORD = pUtil.readDataFormPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("=====Login Sucessful====");
	}
	
	@AfterMethod
	public void amConfig()
	{
		
		HomePage hp=new HomePage(driver);
		hp.signOutApp(driver);
		System.out.println("=====Logout Sucessful====");
	}
	//@AfterTest
	@AfterClass
	public void acConfig()
	{
		driver.quit();
		System.out.println("=====Browser Closed sucessfully=====");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("======Database closed  sucessfully====");
	}
	
	
	
}
