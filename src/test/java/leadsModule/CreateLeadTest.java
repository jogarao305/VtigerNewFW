package leadsModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateLeadTest {
	
	@Test
	public void leadcreation() throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String UserName = pobj.getProperty("username");
		String Password = pobj.getProperty("password");
		String URL = pobj.getProperty("url");
//		System.setProperty("webdriver.edge.driver", "D:\\selenium folder\\msedgedriver.exe");

		ChromeOptions option = new ChromeOptions();
		   option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(URL);	
		driver.findElement(By.name("user_name")).sendKeys(UserName, Keys.TAB, Password, Keys.ENTER);
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		WebElement element = driver.findElement(By.name("salutationtype"));
		element.click();
		Select s = new Select(element);
		s.selectByVisibleText("Ms.");
		driver.findElement(By.className("detailedViewTextBox")).sendKeys("G");
		driver.findElement(By.name("lastname")).sendKeys("pradeep");
		driver.findElement(By.name("company")).sendKeys("CGI");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement element1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(element1).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
		
	}
}
