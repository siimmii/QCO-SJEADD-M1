package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilites.WebDriverUtilites;

public class HomePage extends WebDriverUtilites{
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImage;
	
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;
	
	
	@FindBy(linkText = "Leads")
	private WebElement leadslink;
	
	
	public WebElement getOrganizationLink() {
		return organizationLink;
	}



	public WebElement getContactsLink() {
		return contactsLink;
	}



	public WebElement getMoreLink() {
		return moreLink;
	}



	public WebElement getAdminImage() {
		return adminImage;
	}



	public WebElement getProductLink() {
		return productLink;
	}



	public WebElement getSignoutLink() {
		return signoutLink;
	}



	public WebElement getLeadslink() {
		return leadslink;
	}



	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	
	//businee Libraries
	
	public void clickConatctsLink()
	{
		contactsLink.click();
	}
	public void clickProductsLink()
	{
		productLink.click();
	}
	public void clickOrganizationLink()
	{
		organizationLink.click();
	}
	public void clickMoreLink()
	{
		moreLink.click();
	}
	
	public void clickLeadLink()
	{
		leadslink.click();
	}
	public void signOutApp(WebDriver driver)
	{
		mouseHoverAction(driver, adminImage);
		signoutLink.click();
	}
}
