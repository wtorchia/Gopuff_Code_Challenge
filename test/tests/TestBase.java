package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;


public class TestBase extends TestListenerAdapter {
	
	protected int DEFAULT_WAIT = 10;
	

	
	public TestBase() {
		
	}
	
	protected WebDriver getChromeDriver() {
		
		log("Starting chrome driver");
		
		System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");       
  
		ChromeOptions options = new ChromeOptions();
		  
		//options.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT, TimeUnit.SECONDS);
		  
		return driver; 
	}

	
	protected boolean getURL(WebDriver driver, String URL) {
		
		try {
			
			log("Getting URL : " + URL);
			
			driver.get(URL);
			
			return true;
			
		} 
		catch(Exception e) {
			
			log("ERROR : " + e.toString());
			
			log("Closing driver after error");
			
			driver.close();
			
			return false;
		}
	}
	
	
	protected boolean waitForElementByName(WebDriver driver, String elementName) {
		
		try {
			
			log("Waiting for element with name : " + elementName);
		
			driver.findElement(By.name(elementName));
			
			log("Found element with name : " + elementName);
			
			return true;
		}
		catch(Exception e) {
			
			log("ERROR : " + e.toString());
			
			log("Closing driver after error");
			
			driver.close();
			
			return false;
		}
		
	}
	
	protected boolean waitForElementByID(WebDriver driver, String ID) {
		
		try {
			
			log("Waiting for element with ID : " + ID);
		
			driver.findElement(By.id(ID));
			
			log("Found element with ID : " + ID);
			
			return true;
		}
		catch(Exception e) {
			
			log("ERROR : " + e.toString());
			
			log("Closing driver after error");
			
			driver.close();
			
			return false;
		}
		
	}
	
	
	protected WebElement GetElementByName(WebDriver driver, String elementName) {
		
		try {
			
			boolean result = waitForElementByName(driver, elementName );
			
			if(result) {
				
				log("Locating element : " + elementName + " by name" );
				
				WebElement element = driver.findElement(By.name(elementName));
				
				log("Elelment found");
				
				return element;
			}
			else {
				
				return null;
			
			}
			
		}
		catch(Exception e) {
			
			log("ERROR : " + e.toString());
			
			log("Closing driver after error");
			
			driver.close();
			
			return null;
		}
		
	}
	
	protected boolean sendkeysToElementByName(WebDriver driver, String elementName, String text) {
		
		try {
			
			log("Sending text " + text + " to element : " + elementName + " by name" );
			
			WebElement element = GetElementByName(driver, elementName );
			
			element.sendKeys(text);
			
			log("Text sent");
			
			return true;
		}
		catch(Exception e) {
			
			log("ERROR : " + e.toString());
			
			log("Closing driver after error");
			
			driver.close();
			
			return false;
		}
		
	}
	
	
	protected void log(String string) {
	  
		Reporter.log(string);
		Reporter.log("<br>");
      
   }
}
