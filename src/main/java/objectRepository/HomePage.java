package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(linkText = "Leads")
	private WebElement Leadslink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement Opportunitieslink;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getLeadslink() {
		return Leadslink;
	}

	public WebElement getOpportunitieslink() {
		return Opportunitieslink;
	}
	
	
	public void clickOnLeadsPage()
	{
		Leadslink.click();
	}
	
	public void ClickOnOpportunitiesPage()
	{
		Opportunitieslink.click();
	}

}
