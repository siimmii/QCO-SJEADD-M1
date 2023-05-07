package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilites.WebDriverUtilites;

public class CreateNewLeadSource  extends WebDriverUtilites{

	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name = "company")
	private WebElement companyNameEdt;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBTn;
	
	
	public CreateNewLeadSource(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	public WebElement getSaveBTn() {
		return saveBTn;
	}


	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getCompanyNameEdt() {
		return companyNameEdt;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}
	
	
	public void createNewLead(String LASTNAME,String COMPANY)
	{
		lastNameEdt.sendKeys(LASTNAME);
		companyNameEdt.sendKeys(COMPANY);
		saveBTn.click();
		
	}
	public void createNewLead(String LASTNAME,String COMPANY,WebDriver driver)
	{
		lastNameEdt.sendKeys(LASTNAME);
		companyNameEdt.sendKeys(COMPANY);
		handleDropdown(industryDropDown, 2);
		handleDropdown(leadSourceDropDown, 2);
		saveBTn.click();
	}
}
