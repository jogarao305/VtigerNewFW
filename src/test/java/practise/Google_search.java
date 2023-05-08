package practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Google_search {
	@Test
	public void search()
	{
		System.setProperty("webdriver.chrome.driver", "H:\\selenium\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		 option.addArguments("--remote-allow-origins=*");
		 WebDriver driver = new ChromeDriver(option);
		 
		 driver.get("https://www.google.com/");
	}

}
