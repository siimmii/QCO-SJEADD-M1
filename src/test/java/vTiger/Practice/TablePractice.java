package vTiger.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TablePractice {
	
	@ Test
	public void login()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		
		//selecitng all
		//driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td/input[@name='selectall']")).click();
		
		
		//selelctting one by one
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[5]/td[1]/input[@name='selected_id']")).click();
	}

}
