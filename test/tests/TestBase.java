package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import pom.POMBase;



public class TestBase extends TestListenerAdapter {
	
	protected int DEFAULT_WAIT = 10;
	

	
	public TestBase() {
		
	}
	
	protected WebDriver getChromeDriver() {
		
		log("Starting chrome driver");
		
		System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");       
  
		ChromeOptions options = new ChromeOptions();
		  
		options.addArguments("--headless");
		
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
			
			Assert.fail();
			
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
			
			Assert.fail();
			
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
			
			Assert.fail();
			
			return false;
		}
		
	}
	
	
	protected WebElement getElementByName(WebDriver driver, String elementName) {
		
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
	
			Assert.fail();
			
			return null;
		}
		
	}
	
	
	protected WebElement getElementByID(WebDriver driver, String ID) {
		
		try {
			
			boolean result = waitForElementByID(driver, ID );
			
			if(result) {
				
				log("Locating element : " + ID + " by ID" );
				
				WebElement element = driver.findElement(By.id(ID));
				
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
		
			Assert.fail();
			
			return null;
		}
		
	}
	
	
	protected boolean sendkeysToElementByName(WebDriver driver, String elementName, String text) {
		
		try {
			
			log("Sending text " + text + " to element : " + elementName + " by name" );
			
			WebElement element = getElementByName(driver, elementName );
			
			element.sendKeys(text);
			
			log("Text sent");
			
			return true;
		}
		catch(Exception e) {
			
			log("ERROR : " + e.toString());
			
			log("Closing driver after error");
			
			driver.close();
			
			Assert.fail();
			
			return false;
		}
		
	}
	
	
	protected boolean sendkeysToElementByID(WebDriver driver, String ID, String text) {
		
		try {
			
			log("Sending text " + text + " to element : " + ID + " by ID" );
			
			WebElement element = getElementByID(driver, ID );
			
			clickElementByID(driver, ID);
			
			element.sendKeys(text);
			
			element.sendKeys(Keys.ENTER);
			
			log("Text sent");
			
			return true;
		}
		catch(Exception e) {
			
			log("ERROR : " + e.toString());
			
			log("Closing driver after error");
			
			driver.close();
			
			Assert.fail();
			
			return false;
		}
		
	}
	
	
	protected boolean clickElementByID(WebDriver driver, String ID) {
		

		try {
			
			WebElement element = getElementByID(driver, ID );
			
			log("Clicking element by ID : " + ID);
			
			element.click();
			
			log("Element clicked");
			
			return true;
		}
		catch(Exception e) {
			
			log("ERROR : " + e.toString());
			
			log("Closing driver after error");
			
			driver.close();
			
			Assert.fail();
			
			return false;
		}
		
		
		
	}
	
	protected List<WebElement> getMultipleElementsByClass(WebDriver driver, String className) {

		try {
			
			log("Looking for all elements with class : " + className);
			
			List<WebElement> elementList =  driver.findElements(By.className(className));
			
			log("Elements found");
			
			return elementList;
			
		}
		catch(Exception e) {
			
			log("ERROR : " + e.toString());
			
			log("Closing driver after error");
			
			driver.close();
			
			Assert.fail();
			
			return null;
		}
		
	}
	
	protected WebElement selectSubElementByTag(WebDriver driver, WebElement element, String tagName) {
		
		try {
			
			log("Looking for sub elements with tag : " + tagName);
			
			WebElement subElement = element.findElement(By.tagName(tagName));
			
			return subElement;
			
		}
		catch(Exception e) {
			
			log("ERROR : " + e.toString());
			
			log("Closing driver after error");
			
			driver.close();
			
			Assert.fail();
			
			return null;
		}
		
		
	}
	
	
	public void validateSearResults(WebDriver driver, List<WebElement> elementList, String[] resultsList  ) {
		
		  log("Checking search results");
		  
		  //Elements can be in different order. Walk the results page and check expected items.
		  for(WebElement element : elementList) {
			  
			  boolean textPresent = false;
			  
			  String elementText = selectSubElementByTag(driver, element, POMBase.IMAGE_TAG).getAttribute(POMBase.ALT_ATRIBUTE);
			  
			  log("Looing for : " + elementText );
			  
			  for(int i = 0; i < resultsList.length; i++) {
				    
				  if(elementText.contains(resultsList[i])) {
					  
					  textPresent = true;
					  break;
					  
				  }
				  
			  }
			  
			  if(textPresent) {
		
				  log("Text found in list"); 
				 
			  }
			  else {
				  
				  Assert.fail("Expected text not present");
			  
			  }
			  
		  }
		
	}
	
	
	protected void log(String string) {
	  
		Reporter.log(string);
		Reporter.log("<br>");
      
   }
}
