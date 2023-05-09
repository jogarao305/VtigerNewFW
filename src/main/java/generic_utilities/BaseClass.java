package generic_utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	
	public WebDriverUtilities wutil = new WebDriverUtilities();
	public PropertyFileUtility putil = new PropertyFileUtility();
	public JavaUtilities jutil = new JavaUtilities();
	
	public WebDriver driver;
	
	@BeforeSuite
	public void bsConfig() {
		System.out.println("Database Connection esablished");
	}
	@BeforeClass
	public void bcConfig() throws IOException {
		String URL = putil.readDataFromProperties("url");
		String BROWSER = putil.readDataFromProperties("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "H:\\selenium\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);
			System.out.println(BROWSER + " Launched Successfully");
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "H:\\selenium\\msedgedriver.exe");
			driver = new EdgeDriver();
			System.out.println(BROWSER + " Launched Successfully");
		}
		else {
			System.out.println("Invalid Browser");
		}
		driver.get(URL);
		wutil.maximizeWindow(driver);
		wutil.waitforPage(driver);
	}
	
	@BeforeMethod
	public void bmConfig() throws IOException {
		String UserName = putil.readDataFromProperties("username");
		String PassWord = putil.readDataFromProperties("password");
		LoginPage lp = new LoginPage(driver);
		lp.login(UserName, PassWord);
		System.out.println("---Login successful---");
	}
	
	@AfterMethod
	public void amConfig() {
		HomePage hp = new HomePage(driver);
		hp.signOut(driver);
		System.out.println("---Logout Successful");
	}
	
	@AfterClass
	public void acConfig() {
		driver.quit();
		System.out.println("browser closed successfully");
	}
	
	@AfterSuite
	public void asConfig() {
		System.out.println("Database connection closed");
	}

}
