package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utilities.WebDriverUtilities;

public class HomePage extends WebDriverUtilities {
	
	@FindBy(linkText = "Leads")
	private WebElement Leadslink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement Opportunitieslink;
	
	@FindBy(xpath = "(//a[text()='Organizations'])[1]")
	private WebElement Organisationlink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignoutBtn;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getLeadslink() {
		return Leadslink;
	}

	public WebElement getOpportunitieslink() {
		return Opportunitieslink;
	}
	
	public WebElement getOrganisationlink() {
		return Organisationlink;
	}

	public void clickOnLeadsPage()
	{
		Leadslink.click();
	}
	
	public void ClickOnOpportunitiesPage()
	{
		Opportunitieslink.click();
	}

	public WebElement getAdminImg() {
		return AdminImg;
	}

	public WebElement getSignoutBtn() {
		return SignoutBtn;
	}
	
	public void signOut(WebDriver driver) {
		moveToElement(driver, AdminImg);
		SignoutBtn.click();
	}

}
