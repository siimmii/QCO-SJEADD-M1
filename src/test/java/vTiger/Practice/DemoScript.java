package vTiger.Practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.LoginPage;

public class DemoScript {

	public static void main(String[] args) {
		
		
		Random ran=new Random();
		int random=ran.nextInt(1000);
		//Step 1:Launch the browser
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
//		WebDriverManager.edgedriver().setup();
//		WebDriver driver=new EdgeDriver();
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		
		//Step 2: Login to App
//		driver.findElement(By.name("user_name")).sendKeys("admin");
//		driver.findElement(By.name("user_password")).sendKeys("admin");
//		driver.findElement(By.id("submitButton")).click();
//				
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp("admin","admin");
		
		
		
		//Step 3: Navigate to Organizations LInk
		driver.findElement(By.linkText("Organizations")).click();
				
		//Step 4: click on Create Organization Look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
		//Step 5: Create Organization with Mnadatory fields
		driver.findElement(By.name("accountname")).sendKeys("Dominos"+random);
				
		//Step 6: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
		//Step 7: Validate
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains("Dominos"))
		{
			System.out.println("=== PASS ===");
		}
		else
		{
			System.out.println("=== FAIL ===");
		}
				
		//Step 8: Logout
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Signout successfull");
	}

}
