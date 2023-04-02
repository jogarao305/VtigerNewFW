package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utilities.WebDriverUtilities;

public class CreateOpportunityPage extends WebDriverUtilities {
	
	@FindBy(name = "potentialname")
	private WebElement opportunityNameEdt;
	
	@FindBy(xpath = "//input[@id='related_to_display']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement organisationEdt;
	
	@FindBy(name = "sales_stage")
	private WebElement sales_stageDropdwon;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "search_text")
	private WebElement searchbox;
	
	@FindBy(name = "search")
	private WebElement searchBtn;

	public CreateOpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getOpportunityNameEdt() {
		return opportunityNameEdt;
	}

	public WebElement getOrganisationEdt() {
		return organisationEdt;
	}

	public WebElement getSales_stageDropdwon() {
		return sales_stageDropdwon;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	/**
	 * This method create the new opportunity 
	 * @param oppName
	 * @param driver
	 * @param orgName
	 * @param salesstage
	 */
	public void createOpporunities(String oppName, WebDriver driver,String orgName, String salesstage)
	{
		opportunityNameEdt.sendKeys(oppName);
		switchToWindow(driver, "Accounts");
		searchbox.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Potentials");
		selectByVisibleText(salesstage, sales_stageDropdwon);
		saveBtn.click();
	}

}