package vTiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaKeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//span[@class='chNavText darkGreyText']")).click();
		driver.findElement(By.id("fromCity")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();
		
		driver.findElement(By.id("toCity")).click();
	
		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@aria-label='Thu May 11 2023']")).click();
	}

}
