package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement contactLookUpImg;

	
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getCreateContactLookUpImg() {
		return contactLookUpImg;
	}
	
	public void clickContactLookUpimg()
	{
		contactLookUpImg.click();;
	}

}
