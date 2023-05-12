package vTiger.Practice;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopUp {


	@Test
	public void SelectAnyDateInDOM() throws InterruptedException
	{
		//Set the web driver manager to chrome
		WebDriverManager.chromedriver().setup();
		
		//Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		Thread.sleep(1000);
		
//		Actions act = new Actions(driver);
//		act.moveByOffset(10, 10).click().perform();
//		
//		//driver.findElement(By.xpath("//a[@class='close']")).click();
//		
//		//driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
//		
//		//Navigate to From and To Elements
//		WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
//		WebElement dst = driver.findElement(By.xpath("//input[@id='toCity']"));
//		
//		
//		src.sendKeys("mumbai");
//		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
//		
//		Thread.sleep(2000);
//		
//		dst.sendKeys("chennai");
//		driver.findElement(By.xpath("//p[text()='Chennai, India']")).click();
//		
//		Thread.sleep(2000);
//		
//		//navigate to departure
//		driver.findElement(By.xpath("//label[@for='departure']")).click();
//		
		driver.findElement(By.xpath("//span[@class='chNavText darkGreyText']")).click();
		driver.findElement(By.id("fromCity")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();
		
		driver.findElement(By.id("toCity")).click();
	
		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		Thread.sleep(1000);
		//navigate to desired date in calender
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@aria-label='Thu May 11 2023']")).click();	}
	
	
	
	@Test
	public void SelectCurrentDate() throws InterruptedException
	{
		Date d = new Date();
		String dArr=d.toString();       //Sat Sep 24 2022
		System.out.println(dArr);
		String arr[]=dArr.split(" ");
		String day = arr[0];
		String month = arr[1];
		String date = arr[2];
		String year = arr[5];
		String travelDate = day+" "+month+" "+date+" "+year;
		System.out.println(travelDate);
		
		//Set the web driver manager to chrome
		WebDriverManager.chromedriver().setup();
		
		//Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		Thread.sleep(1000);
		
		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		
		//driver.findElement(By.xpath("//a[@class='close']")).click();
		
		//driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		//Navigate to From and To Elements
		WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
		WebElement dst = driver.findElement(By.xpath("//input[@id='toCity']"));
		
		
		src.sendKeys("mumbai");
		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		
		Thread.sleep(2000);
		
		dst.sendKeys("chennai");
		driver.findElement(By.xpath("//p[text()='Chennai, India']")).click();
		
		Thread.sleep(2000);
		
		//navigate to departure
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		
		//navigate to desired date in calender - Dynamic xpath
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@aria-label='"+travelDate+"']")).click();
		                             //div[@aria-label='wed sep 21 2022']
		                             //div[@aria-label='thu sep 22 2022']
		
	}
	
	@Test
	public void selectFutureDate() throws InterruptedException
	{
		//Set the web driver manager to chrome
		WebDriverManager.chromedriver().setup();
		
		//Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		Thread.sleep(1000);
		
		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		
		//driver.findElement(By.xpath("//a[@class='close']")).click();
		
		//driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
//		//Navigate to From and To Elements
//		WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
//		WebElement dst = driver.findElement(By.xpath("//input[@id='toCity']"));
//		
//		
//		src.sendKeys("mumbai");
//		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
//		
//		Thread.sleep(2000);
//		
//		dst.sendKeys("chennai");
//		driver.findElement(By.xpath("//p[text()='Chennai, India']")).click();
//		
//		Thread.sleep(2000);
//		
//		//navigate to departure
//		driver.findElement(By.xpath("//label[@for='departure']")).click();
//		
//		//navigate to desired date in calender -
		driver.findElement(By.id("fromCity")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();
		
		driver.findElement(By.id("toCity")).click();
	
		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[@aria-label='Thu May 11 2023']")).click();
	
		for(;;)
		{
			try
			{
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@aria-label='Thu Jan 04 2024']")).click();
				break;
			}
			catch (Exception e) 
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		
		                           
	}
	
		
}
