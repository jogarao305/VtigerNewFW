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

import generic_utilities.BaseClass;
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

public class Create_NewOpportunity extends BaseClass {
	
	@Test
	public void createOpportunity() throws IOException {
		
		ExcelFileUtility eutil = new ExcelFileUtility();
		JavaUtilities jutil = new JavaUtilities();
		 
	   String OppName = eutil.readDataFromExcelFile("Opportunity", 5, 0);
	   String Sales_Stage = eutil.readDataFromExcelFile("Opportunity", 5, 1);
	   String Amount = eutil.readDataFromExcelFile("Opportunity", 5, 2);
	   String Assign = eutil.readDataFromExcelFile("Opportunity", 5, 3);
	   String Desc = eutil.readDataFromExcelFile("Opportunity", 5, 4);
	   String OrgName = eutil.readDataFromExcelFile("Opportunity", 5, 5);
	  //Home page and clicking on organization link  
	   HomePage hp = new HomePage(driver);
	   hp.getOrganisationlink().click();   
      //Organization page and clicking on create new organization button   
	   OrganisationPage op = new OrganisationPage(driver);
	   op.clickonOrg();
      //creating a new Organization   
	   CreateOrganisationPage cOp = new CreateOrganisationPage(driver);
	   cOp.creteOrg(OrgName+jutil.getRandomNumber());
	  //Verifying the organization page 
	   OrganisationInfoPage oinf = new OrganisationInfoPage(driver);
	    String headertag = oinf.orgHeader();
		Assert.assertTrue(headertag.contains(OrgName));
		System.out.println(OrgName+" ---Organisation created");
	  //clicking on opportunity link and clicking on new opportunity button 
	   hp.ClickOnOpportunitiesPage();
	   OpportunitiesPage op1 = new OpportunitiesPage(driver);
	   op1.createOpportunitiesPage();
	  //Creating new Opportunity with description and saving it 
	   CreateOpportunityPage cop = new CreateOpportunityPage(driver);
	   cop.createOpportunity(OppName+jutil.getRandomNumber(), driver, OrgName, Sales_Stage, Amount, Assign);
	   
	   driver.findElement(By.xpath("//textarea[@class='detailedViewTextBox']")).sendKeys(Desc);
	   cop.getSaveBtn().click();
	   //Verifying the opportunity name
	   OpportunityInfoPage oinf1 = new OpportunityInfoPage(driver);
	 String OppHeader = oinf1.opportunityHeader();
	   Assert.assertTrue(OppHeader.contains(OppName));
	   System.out.println(OppName + "----Opportunity created");
	   
	}
}
