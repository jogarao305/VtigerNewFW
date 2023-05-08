package opportunitiesModule;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utilities.ExcelFileUtility;
import generic_utilities.JavaUtilities;
import generic_utilities.PropertyFileUtility;
import generic_utilities.WebDriverUtilities;
import objectRepository.CreateOpportunityPage;
import objectRepository.CreateOrganisationPage;
import objectRepository.HomePage;
import objectRepository.OpportunitiesPage;
import objectRepository.OpportunityInfoPage;
import objectRepository.OrganisationInfoPage;
import objectRepository.OrganisationPage;

public class Create_NewOpportunity {
	
	@Test
	public void createOpportunity() throws IOException {
		
		PropertyFileUtility putil = new PropertyFileUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		WebDriverUtilities wutil = new WebDriverUtilities();
		JavaUtilities jutil = new JavaUtilities();
		
	    String URL = putil.readDataFromProperties("url");
		String UserName = putil.readDataFromProperties("username");
	    String Password = putil.readDataFromProperties("password");
	    
	   String OppName = eutil.readDataFromExcelFile("Opportunity", 5, 0);
	   String Sales_Stage = eutil.readDataFromExcelFile("Opportunity", 5, 1);
	   String Amount = eutil.readDataFromExcelFile("Opportunity", 5, 2);
	   String Assign = eutil.readDataFromExcelFile("Opportunity", 5, 3);
	   String Desc = eutil.readDataFromExcelFile("Opportunity", 5, 4);
	  String OrgName = eutil.readDataFromExcelFile("Opportunity", 5, 5);
	   
	   System.setProperty("webdriver.chrome.driver", "H:\\selenium\\chromedriver.exe");
	   ChromeOptions option = new ChromeOptions();
	   option.addArguments("--remote-allow-origins=*");
	   WebDriver driver = new ChromeDriver(option);
	   
	   driver.get(URL);
	   wutil.maximizeWindow(driver);
	   wutil.waitforPage(driver);
	   driver.findElement(By.name("user_name")).sendKeys(UserName, Keys.TAB, Password, Keys.ENTER);
	   
	   HomePage hp = new HomePage(driver);
	   hp.getOrganisationlink().click();
	   
	   OrganisationPage op = new OrganisationPage(driver);
	   op.clickonOrg();
	   
	   CreateOrganisationPage cOp = new CreateOrganisationPage(driver);
	   cOp.creteOrg(OrgName+jutil.getRandomNumber());
	   
	   OrganisationInfoPage oinf = new OrganisationInfoPage(driver);
	    String headertag = oinf.orgHeader();
		Assert.assertTrue(headertag.contains(OrgName));
		System.out.println(OrgName+" ---Organisation created");
	   
	   hp.ClickOnOpportunitiesPage();
	   OpportunitiesPage op1 = new OpportunitiesPage(driver);
	   op1.createOpportunitiesPage();
	   
	   CreateOpportunityPage cop = new CreateOpportunityPage(driver);
	   cop.createOpportunity(OppName+jutil.getRandomNumber(), driver, OrgName, Sales_Stage, Amount, Assign);
	   
	   driver.findElement(By.xpath("//textarea[@class='detailedViewTextBox']")).sendKeys(Desc);
	   cop.getSaveBtn().click();
	   
	   OpportunityInfoPage oinf1 = new OpportunityInfoPage(driver);
	 String OppHeader = oinf1.opportunityHeader();
	   Assert.assertTrue(OppHeader.contains(OppName));
	   System.out.println(OppName + "----Opportunity created");
	   
	   hp.signOut(driver);
	   
	   driver.close();
	}

}
