package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInfoPage {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OpportunityHeader;
	
	public OpportunityInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpportunityHeader() {
		return OpportunityHeader;
	}
	
	public String opportunityHeader() {
		return OpportunityHeader.getText();
	}

}
