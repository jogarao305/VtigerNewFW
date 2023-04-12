package practise;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import generic_utilities.PropertyFileUtility;
import generic_utilities.WebDriverUtilities;

public class CheckBoxes {
	
	@Test
	public void checkAll() throws IOException
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
		 
		List<WebElement> checkbox = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td/input[@type='checkbox']"));
		
		for(int i=1;i<=checkbox.size();i++)
		{
			checkbox.get(i).click();
		}
		
		driver.quit();
	}

}
