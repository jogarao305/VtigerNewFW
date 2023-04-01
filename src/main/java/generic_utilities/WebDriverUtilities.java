package generic_utilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtilities {
	
	/**
	 * This method maximizes the window 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method minimizes the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method waits for the page to load
	 * @param driver
	 */
	public void waitforPage(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	/**
	 * This method performs select operation with the help of text
	 * @param element
	 * @param text
	 */
	public void selectByValue(WebElement element, String text)
	{
		Select s = new Select(element);
		s.selectByValue(text);
	}
	
	/**
	 * This method performs select operation with the help of index value
	 * @param element
	 * @param id
	 */
	public void selectByIndex(WebElement element, int id)
	{
		Select s = new Select(element);
		s.selectByIndex(id);
	}
	
	/**
	 * This method performs select operation with the help of text
	 * @param text
	 * @param element
	 */
	public void selectByVisibleText(String text, WebElement element)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * with the help of this method we can perform mouse hover action on a webelement
	 * @param driver
	 * @param element
	 */
	public void moveToElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * with the help of this method we can perform right click on a webpage
	 * @param driver
	 */
	public void contextClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * with the help of this method we can perform right click action on single webelement
	 * @param driver
	 * @param element
	 */
	public void contextClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method performs double click operation on the webpage
	 * @param driver
	 */
	public void doubleClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method performs double click operation on single webelement
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	
	/**
	 * This method performs switching window operation from the child window to parent and vice versa
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		Set<String> winIds = driver.getWindowHandles();
		
		for(String win:winIds)
		{
			String winTitle = driver.switchTo().window(win).getTitle();
			
			if(winTitle.contains(partialWinTitle)) 
			{
				break;
			}
		}
	}
	
	
}
