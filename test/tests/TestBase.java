package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import pom.POMBase;



public class TestBase extends TestListenerAdapter {
	
	protected int DEFAULT_WAIT = 10;
	protected boolean RUN_HEADLESS = true;

	
	public TestBase() {
		
	}
	
	
	protected WebDriver getChromeDriver() {
		
		log("Starting chrome driver");
		
		System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");       
  
		ChromeOptions options = new ChromeOptions();
		
		if(this.RUN_HEADLESS) { options.addArguments("--headless"); }
		
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
			
			logAndFail(driver, e);
			
			return false;
		}
	}
	
	
	protected boolean waitForElementByName(WebDriver driver, String elementName) {
		
		try {
			
			log("Waiting for element with name : " + elementName);
		
			WebElement element = driver.findElement(By.name(elementName));
			
			WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
			 
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			log("Found element with name : " + elementName);
			
			return true;
		}
		catch(Exception e) {
			
			logAndFail(driver, e);
			
			return false;
		}
		
	}
	
	protected boolean waitForElementByID(WebDriver driver, String ID) {
		
		try {
			
			log("Waiting for element with ID : " + ID);
		
			WebElement element = driver.findElement(By.id(ID));
			
			WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
			 
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			log("Found element with ID : " + ID);
			
			return true;
		}
		catch(Exception e) {
			
			logAndFail(driver, e);
			
			return false;
		}
		
	}
	
	
	protected boolean waitForElementByClass(WebDriver driver, String className) {
		
		try {
			
			log("Waiting for element with class name : " + className);
		
			WebElement element = driver.findElement(By.className(className));
			
			WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
			 
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			log("Found element with class name : " + className);
			
			return true;
		}
		catch(Exception e) {
			
			logAndFail(driver, e);
			
			return false;
		}
		
	}
	
	
	
	protected WebElement getElementByName(WebDriver driver, String elementName) {
		
		try {
			
			boolean result = waitForElementByName(driver, elementName );
			
			if(result) {
				
				log("Locating element : " + elementName + " by name" );
				
				WebElement element = driver.findElement(By.name(elementName));
				
				WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
				 
				wait.until(ExpectedConditions.elementToBeClickable(element));
				
				log("Elelment found");
				
				return element;
			}
			else {
				
				return null;
			
			}
			
		}
		catch(Exception e) {
			
			logAndFail(driver, e);
			
			return null;
		}
		
	}
	
	
	protected WebElement getElementByID(WebDriver driver, String ID) {
		
		try {
			
			boolean result = waitForElementByID(driver, ID );
			
			if(result) {
				
				log("Locating element : " + ID + " by ID" );
				
				WebElement element = driver.findElement(By.id(ID));
				
				WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
				 
				wait.until(ExpectedConditions.elementToBeClickable(element));
				
				log("Elelment found");
				
				return element;
			}
			else {
				
				return null;
			
			}
			
		}
		catch(Exception e) {
			
			logAndFail(driver, e);
			
			return null;
		}
		
	}
	
	
	protected boolean sendkeysToElementByName(WebDriver driver, String elementName, String text) {
		
		try {
			
			log("Sending text " + text + " to element : " + elementName + " by name" );
			
			WebElement element = getElementByName(driver, elementName );
			
			WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
			 
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.sendKeys(text);
			
			log("Text sent");
			
			return true;
		}
		catch(Exception e) {
			
			logAndFail(driver, e);
			
			return false;
		}
		
	}
	
	
	protected boolean sendkeysToElementByID(WebDriver driver, String ID, String text) {
		
		try {
			
			log("Sending text " + text + " to element : " + ID + " by ID" );
			
			WebElement element = getElementByID(driver, ID );
			
			WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
			 
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			clickElementByID(driver, ID);
			
			element.sendKeys(text);
			
			element.sendKeys(Keys.ENTER);
			
			log("Text sent");
			
			return true;
		}
		catch(Exception e) {
			
			logAndFail(driver, e);
			
			return false;
		}
		
	}
	
	
	protected boolean clickElementByID(WebDriver driver, String ID) {
		

		try {
			
			WebElement element = getElementByID(driver, ID );
			
			WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
			 
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			
			log("Clicking element by ID : " + ID);
			
			element.click();
			
			log("Element clicked");
			
			return true;
		}
		catch(Exception e) {
			
			logAndFail(driver, e);
			
			return false;
		}
		
	}
	
	
	protected boolean clickElement(WebDriver driver, WebElement element) {
		

		try {
			
			WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
			 
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			log("Clicking element ");
			
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
			Actions actions = new Actions(driver);
			
			actions.moveToElement(element).click().perform();
			
			log("Element clicked");
			
			return true;
		}
		catch(Exception e) {
			
			logAndFail(driver, e);
			
			return false;
		}
		
	}


	
	protected WebElement getElementByClass(WebDriver driver, String className) {

		try {
			
			log("Looking for element with class : " + className);
			
			WebElement element =  driver.findElement(By.className(className));
			
			WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
			 
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			log("Elements found");
			
			return element;
			
		}
		catch(Exception e) {
			
			logAndFail(driver, e);
			
			return null;
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
			
			logAndFail(driver, e);
			
			return null;
		}
		
	}
	
	
	protected List<WebElement> getMultipleSubElementsByClass(WebDriver driver, String parentClassName, String childClassName) {

		try {
			
			log("Looking for all chiled elements of " +  parentClassName + " with class : " + parentClassName);
			
			WebElement parentElement = getElementByClass(driver, parentClassName);
			
			List<WebElement> elementList =  parentElement.findElements(By.className(childClassName));
			
			log("Elements found");
			
			return elementList;
			
		}
		catch(Exception e) {
			
			logAndFail(driver, e);
			
			return null;
		}
		
	}
	
	protected WebElement selectSubElementByTag(WebDriver driver, WebElement element, String tagName) {
		
		try {
			
			log("Looking for sub elements with tag : " + tagName);
			
			WebElement subElement = element.findElement(By.tagName(tagName));
			
			WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
			 
			wait.until(ExpectedConditions.elementToBeClickable(subElement));
			
			return subElement;
			
		}
		catch(Exception e) {
			
			logAndFail(driver, e);
			
			return null;
		}		
		
	}
	
	
	protected WebElement findSubElementWithTextInListByClass(WebDriver driver, String parentClasstName, String childClassName, String text) {
		
		return findSubElementWithTextInListByClass(driver, parentClasstName, childClassName,  text, true);
	}
	
	
	protected WebElement findSubElementWithTextInListByClass(WebDriver driver, String parentClasstName, String childClassName, String text, boolean useMinListSize) {
		

		List<WebElement> elementList = getMultipleElementsByClass(driver, parentClasstName);
		
		if(useMinListSize) {
		
			while(elementList.size() < 2) {
				
				elementList = getMultipleElementsByClass(driver, parentClasstName);
				
			}
			
		}
		
		
		WebElement element = null; 
		
		for(WebElement listItem : elementList) {
			
				String childElementText = listItem.findElement(By.className(childClassName)).getText().strip().trim();
				
				if(childElementText.equals(text)) {
				
					element = listItem.findElement(By.className(childClassName));
					
					WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
					 
					wait.until(ExpectedConditions.elementToBeClickable(element));
					
					break;
				}
				
		}
		
		return element;
		
	}
	
	
	public void validateSearResults(WebDriver driver, List<WebElement> elementList, String[] resultsList  ) {
		
		  log("Checking search results");
		  
		  //Elements can be in different order. Walk the results page and check for expected items.
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
			  
			  Assert.assertTrue(textPresent); 	  
		  }
		
	}
	
	
	protected void logAndFail(WebDriver driver, Exception e) {
		
		log("ERROR : " + e.toString());
		
		log("Closing driver after error");
		
		driver.close();
		
		Assert.fail();
	}
	
	
	protected void log(String message) {
	  
		Reporter.log(message);
		
		Reporter.log("<br>");
      
   }
}
