package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilites.WebDriverUtilites;

public class CreateNewContactPage extends WebDriverUtilites {
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "(//img[@alt='Select'])[1]")
	private WebElement organizationLookUpImg;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
	
	
	@FindBy(name = "search_text")
	private WebElement searchText;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrganizationLookUpImg() {
		return organizationLookUpImg;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}
	
	
	
	public void createNewContact(String LASTNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
	}
	
	public void createNewContact(WebDriver driver, String LASTNAME,String ORGNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		organizationLookUpImg.click();
		switchToWindow(driver,"Accounts");
		searchText.sendKeys(ORGNAME);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		switchToWindow(driver,"Contacts");
		saveBtn.click();
		
		
	}
	public void createNewContact(String LASTNAME,String LEADSOURCE)
	{
		lastNameEdt.sendKeys(LASTNAME);
		handleDropdown(leadSourceDropDown, 3);
		
	}

}
