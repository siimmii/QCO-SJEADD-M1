package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement OrganizationLookUpImg;
	
	//Rule 3
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	//rule 4 utlization
	
	public WebElement getOrganizationLookUpImg() {
		return OrganizationLookUpImg;
	}
	
	//rule 5 business logic
	
	public void clickOrganizatoinLookUpImg()
	{
		OrganizationLookUpImg.click();
	}
	

}
