package practise;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import generic_utilities.PropertyFileUtility;
import generic_utilities.WebDriverUtilities;

public class Check10 {
	
	@Test
	public void checkOne() throws IOException
	{
		PropertyFileUtility putil = new PropertyFileUtility();
		WebDriverUtilities wutil = new WebDriverUtilities();
		String URL = putil.readDataFromProperties("url");
		String UserName = putil.readDataFromProperties("username");
		String Password = putil.readDataFromProperties("password");
		ChromeOptions option = new ChromeOptions();
		 option.addArguments("--remote-allow-origins=*");
		 WebDriver driver = new ChromeDriver(option);
		 
		 wutil.maximizeWindow(driver);
		 wutil.waitforPage(driver);
		 
		 driver.get(URL);
		 driver.findElement(By.name("user_name")).sendKeys(UserName, Keys.TAB, Password, Keys.ENTER);
		 
		 driver.findElement(By.linkText("Organizations")).click();
		 
		WebElement checkbox = driver.findElement(By.xpath("(//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id'])[10]"));
		checkbox.click();
		
		
	}

}
