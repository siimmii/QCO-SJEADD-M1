package vTiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertyFilePractice {

	public static void main(String[] args) throws IOException {
		
		//Step 1:Load the file into Fileinputstream to make it java readable
		FileInputStream fis=new FileInputStream("src\\test\\resources\\CommonData.properties");
		
		//ste2:Ceate an object of properties class  from java.util package
		Properties pObj=new Properties();
		
		//Step 3:Load the file Input Stream into properties class
		pObj.load(fis);
		
		//Step 4:Fetch the data using key
		 String BROWSER = pObj.getProperty("browser");
		 String URL = pObj.getProperty("url");
		 String USERNAME = pObj.getProperty("username");
		 String PASSWORD=pObj.getProperty("password");
		 
		 //Step 5:Launch the browser
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.get(URL);
		 
		 //Step 6:Login to Application
		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("submitButton")).click();
		 
	}

}
