package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utilities.WebDriverUtilities;

public class CreateLeadPage extends WebDriverUtilities{
	
	@FindBy(name = "lastname")
	private WebElement lastnameEdt;
	
	@FindBy(name = "company")
	private WebElement companyEdt;
	
	@FindBy(name = "leadsource")
	private WebElement leadsourcedropdwon;
	
	@FindBy(name = "industry")
	private WebElement industrydropdown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public CreateLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getCompanyEdt() {
		return companyEdt;
	}

	public WebElement getLeadsourcedropdwon() {
		return leadsourcedropdwon;
	}

	public WebElement getIndustrydropdown() {
		return industrydropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	/**
	 * This method will create a lead with with name and companyname
	 * @param name
	 * @param companyName
	 */
	public void createLeadPage(String name, String companyName)
	{
		lastnameEdt.sendKeys(name);
		companyEdt.sendKeys(companyName);
		saveBtn.click();
	}
	
	/**
	 * this method will help to create new lead with the industry and lead dropdown
	 * @param name
	 * @param companyName
	 * @param text
	 * @param industryName
	 */
	public void createLeadPage(String name, String companyName, String text, String industryName )
	{
		lastnameEdt.sendKeys(name);
		companyEdt.sendKeys(companyName);
        selectByVisibleText(text, leadsourcedropdwon);
        selectByVisibleText(industryName, industrydropdown);
		saveBtn.click();
	}
}
