package practise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Tokyo_Olympics {
	
	
	public static void main(String[] args)
	{
		ChromeOptions option = new ChromeOptions();
		 option.addArguments("--remote-allow-origins=*");
		 WebDriver driver = new ChromeDriver(option);
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		 
		 String country = "India";
		 
	       WebElement element = driver.findElement(By.xpath("//div[@data-cy='table-content']/div[@class='styles__CountryWrapper-sc-fehzzg-4 LiGRO']/div/following-sibling::span[text()='"+country+"']"));
		 
	        System.out.println(element.getText());
		 driver.quit();
	}

}
