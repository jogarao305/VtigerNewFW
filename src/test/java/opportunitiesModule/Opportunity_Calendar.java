package opportunitiesModule;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utilities.BaseClass;
import generic_utilities.ExcelFileUtility;
import generic_utilities.JavaUtilities;
import objectRepository.CreateOpportunityPage;
import objectRepository.CreateOrganisationPage;
import objectRepository.HomePage;
import objectRepository.OpportunitiesPage;
import objectRepository.OpportunityInfoPage;
import objectRepository.OrganisationInfoPage;
import objectRepository.OrganisationPage;

public class Opportunity_Calendar extends BaseClass {
	
	@Test
	public void calendar_Opportunity() throws EncryptedDocumentException, IOException {
		ExcelFileUtility eutil = new ExcelFileUtility();
		JavaUtilities jutil = new JavaUtilities();
		
		String OppName = eutil.readDataFromExcelFile("Opportunity", 5, 0);
		String SalesStage = eutil.readDataFromExcelFile("Opportunity", 5, 1);
		String Orgname = eutil.readDataFromExcelFile("Opportunity", 5, 5);
		
		HomePage hp = new HomePage(driver);
		hp.getOrganisationlink().click();
		
		OrganisationPage op = new OrganisationPage(driver);
		op.clickonOrg();
		
		CreateOrganisationPage cop = new CreateOrganisationPage(driver);
		cop.creteOrg(Orgname+jutil.getRandomNumber());
		
		OrganisationInfoPage oinf = new OrganisationInfoPage(driver);
		String header = oinf.orgHeader();
		Assert.assertTrue(header.contains(Orgname));
		System.out.println(Orgname + "--created successfully");
		
		hp.ClickOnOpportunitiesPage();
		
		OpportunitiesPage oP = new OpportunitiesPage(driver);
		oP.createOpportunitiesPage();
		
		CreateOpportunityPage cOp = new CreateOpportunityPage(driver);
		cOp.createOpporunities(OppName+jutil.getRandomNumber(), driver, Orgname, SalesStage);
		cOp.getSaveBtn().click();
		 
		 OpportunityInfoPage opinf = new OpportunityInfoPage(driver);
		 String oppHeader = opinf.opportunityHeader();
		 Assert.assertTrue(oppHeader.contains(OppName));
		 
		 hp.signOut(driver);
		 
		 driver.close();
	}

}
