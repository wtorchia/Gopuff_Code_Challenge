package tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pom.HomePage;
import pom.SearchPage;


public class SearchTests extends TestBase{


  @Test
  private void searchForProductLoggedOutNoLocation() throws InterruptedException {
	 
	  WebDriver driver = getChromeDriver(); 

	  boolean result = getURL(driver, SearchPage.PAGE_URL);    
	  
	  
	  if(result) { result = waitForElementByID(driver, SearchPage.SEARCH_BOX_ID); }

	
	  if(result) { result = sendkeysToElementByID(driver, SearchPage.SEARCH_BOX_ID, SearchPage.HOTDOG_SEARCH_TEXT); }
	  
	  if(result) {
		 
		  List<WebElement> elementList = getMultipleElementsByClass(driver, SearchPage.IMAGE_CLASS);
		  
		  validateSearResults(driver, elementList, SearchPage.HOTDOG_SEARCH_RESULTS);
	  }
	  
	  driver.quit();
	 
  }
  
  

  @Test
  private void searchForProductLoggedOutLocation() throws InterruptedException {
	 
	  WebDriver driver = getChromeDriver(); 

	  boolean result = getURL(driver, HomePage.PAGE_URL);   
	  
	  if(result) { result = sendkeysToElementByID(driver, HomePage.LOCATION_BOX_ID, HomePage.CALABASAS_LOCATION); }
	 
	  if(result) { 
		  
		  	WebElement listItem = findSubElementWithTextInListByClass(driver, HomePage.LOCATOIN_LIST_PARENT, HomePage.LOCATOIN_LIST_CHILD,  HomePage.CALABASAS_LOCATION); 
	
		  	result = clickElement(driver, listItem);
		  	
	  }
	  
	  if(result) { result = waitForElementByID(driver, SearchPage.SEARCH_BOX_ID); }
	
	  if(result) { result = sendkeysToElementByID(driver, SearchPage.SEARCH_BOX_ID, SearchPage.HOTDOG_SEARCH_TEXT); }
	  
	  if(result) {
		 
		  List<WebElement> elementList = getMultipleElementsByClass(driver, SearchPage.IMAGE_CLASS);
		  
		  validateSearResults(driver, elementList, SearchPage.HOTDOG_SEARCH_RESULTS);
	  }
	  
	  driver.quit();
	 
  }
  
  
  @Test
  private void searchForProductLoggedOutBadResult() throws InterruptedException {
	 
	  WebDriver driver = getChromeDriver(); 

	  boolean result = getURL(driver, SearchPage.PAGE_URL);    
	  
	  
	  if(result) { result = waitForElementByID(driver, SearchPage.SEARCH_BOX_ID); }

	
	  if(result) { result = sendkeysToElementByID(driver, SearchPage.SEARCH_BOX_ID, SearchPage.BAD_SEARCH_TEXT); }
	  
	  if(result) {
		 
		  WebElement element = getElementByClass(driver, SearchPage.SEARCH_NOT_FOUND_CLASS);
		  
		  Assert.assertTrue(element.getText().contains(SearchPage.BAD_SEARCH_TEXT));
	  }
	  
	  driver.quit();
	 
  }
  
  
  
}
