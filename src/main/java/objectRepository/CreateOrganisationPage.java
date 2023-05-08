package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganisationPage {
	
	@FindBy(name = "accountname")
	private WebElement OrgnameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	public CreateOrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgnameEdt() {
		return OrgnameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public void creteOrg(String orgname) {
		OrgnameEdt.sendKeys(orgname);
		SaveBtn.click();
	}

}
