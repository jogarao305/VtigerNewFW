package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement NewOrgBtn;

	public OrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getNewOrgBtn() {
		return NewOrgBtn;
	}
	
	/**
	 * This method clicks on organization button and opens organization page
	 */
	public void clickonOrg() {
		NewOrgBtn.click();
	}

}
