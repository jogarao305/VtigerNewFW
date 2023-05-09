package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInfoPage {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OpportunityHeader;
	
	@FindBy(id = "dtlview_Opportunity Name")
	private WebElement OppNameHeader;
	
	@FindBy(id = "dtlview_Amount")
	private WebElement AmountHeader;
	
	@FindBy(id = "dtlview_Description")
	private WebElement descHeader;
	
	public OpportunityInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpportunityHeader() {
		return OpportunityHeader;
	}
	
	public WebElement getOppNameHeader() {
		return OppNameHeader;
	}

	public WebElement getAmountHeader() {
		return AmountHeader;
	}

	public WebElement getDescHeader() {
		return descHeader;
	}

	public String opportunityHeader() {
		return OpportunityHeader.getText();
	}
	
	public String oppName_Header() {
		return OppNameHeader.getText();
	}
	
	public String amountHeader() {
		return AmountHeader.getText();
	}
	
	public String descHeader() {
		return descHeader.getText();
	}
}
