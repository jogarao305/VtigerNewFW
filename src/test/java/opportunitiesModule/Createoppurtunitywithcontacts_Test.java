package opportunitiesModule;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic_utilities.ExcelFileUtility;
import generic_utilities.JavaUtilities;
import generic_utilities.PropertyFileUtility;
import generic_utilities.WebDriverUtilities;

public class Createoppurtunitywithcontacts_Test {
	
	@Test
	public void opportunityWithContacts() throws IOException
	{
		PropertyFileUtility putil = new PropertyFileUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		WebDriverUtilities wutil = new WebDriverUtilities();
		JavaUtilities jutil = new JavaUtilities();
		
		String URL=putil.readDataFromProperties("url");
		String UserName=putil.readDataFromProperties("username");
		String Password=putil.readDataFromProperties("password");
		
		String OpportunityName = eutil.readDataFromExcelFile("Opportunity", 2, 0);
		String SalesStage = eutil.readDataFromExcelFile("Opportunity", 2, 1);
		
		
		WebDriver driver = new EdgeDriver();
		driver.get(URL);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys(UserName, Keys.TAB, Password, Keys.ENTER);
		
		driver.findElement(By.linkText("Opportunities")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		driver.findElement(By.name("potentialname")).sendKeys(OpportunityName+jutil.getRandomNumber());
		
		driver.findElement(By.xpath("//input[@name='related_to_display']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
		wutil.switchToWindow(driver, "Accounts");
		driver.findElement(By.linkText("Origin")).click();
		wutil.switchToWindow(driver, "Potentials");
		
		WebElement date = driver.findElement(By.name("closingdate"));
		date.sendKeys("2023-05-20");
		
		WebElement element = driver.findElement(By.name("sales_stage"));
		element.click();
		wutil.selectByValue(element, SalesStage);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement element2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wutil.moveToElement(driver, element2);
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
		
	}

}
