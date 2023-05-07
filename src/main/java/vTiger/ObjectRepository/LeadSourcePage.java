package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadSourcePage {
	
	@FindBy(xpath = "//img[@title='Create Lead...']")
	private WebElement leadSourceLookUpImg;
	
	public LeadSourcePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLeadSourceLookUpImg() {
		return leadSourceLookUpImg;
	}
	
	public void clickLeadLookUpImg()
	{
		leadSourceLookUpImg.click();
	}
}
