package practise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Flipkart {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "H:\\selenium\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		 option.addArguments("--remote-allow-origins=*");
		 WebDriver driver = new ChromeDriver(option);
		 
		 driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		WebElement ele = driver.findElement(By.xpath("//input[@class='_3704LK']"));
		ele.sendKeys("allen solly watch");
		ele.submit();
		
		List<WebElement> results = driver.findElements(By.xpath("//a[@class='IRpwTa']"));
		
		for(WebElement watches:results)
		{
			
			String values = watches.getText();
			System.out.println(values);
		}
		
		driver.close();
	}
}
