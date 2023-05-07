package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilites.WebDriverUtilites;

public class CreateNewOrganizationPage extends WebDriverUtilites{
	
	@FindBy(name = "accountname")
	private WebElement organizationEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveBtn;
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrganizationEdt() {
		return organizationEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	

	public void createNewOrganization(String ORGNAME)
	{
		organizationEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}
	/**
	 * This method will create Organization With industry dropdown
	 * @param OrgName
	 * @param IndustryType
	 */
	public void createNewOrganization(String ORGNAME,String IndustryType)
	{
		organizationEdt.sendKeys(ORGNAME);	
		//changed data type to int from string
		//handleDropDown(IndustryDropDown, IndustryType);
		//handleDropDown(IndustryDropDown, 2);
		//changed now ---------------
		
		//handleDropdown(industryDropDown, 2);
		handleDropdown(industryDropDown, IndustryType);
		SaveBtn.click();
	
}
	}


