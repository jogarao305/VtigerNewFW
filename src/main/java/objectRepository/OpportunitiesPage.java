package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement OpportunitiesPagelink;

	public OpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpportunitiesPagelink() {
		return OpportunitiesPagelink;
	}
	
	
	public void createOpportunitiesPage()
	{
		OpportunitiesPagelink.click();
	}
	

}
