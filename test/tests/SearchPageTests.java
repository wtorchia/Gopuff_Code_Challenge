package tests;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pom.SearchPage;


public class SearchPageTests extends TestBase{


  @Test
  private void searchForProductLoggedOut() throws InterruptedException {
	 
	  WebDriver driver = getChromeDriver(); 

	  boolean result = getURL(driver, SearchPage.PAGE_URL);    
	  
	  
	  if(result) { result = waitForElementByID(driver, SearchPage.SEARCH_BOX_ID); }

	
	  if(result) { result = sendkeysToElementByID(driver, SearchPage.SEARCH_BOX_ID, SearchPage.HOTDOG_SEARCH_TEXT); }
	  
	  if(result) {
		 
		  List<WebElement> elementList = getMultipleElementsByClass(driver, "gp-product-tile__image");
		  
		  validateSearResults(driver, elementList, SearchPage.HOTDOG_SEARCH_RESULTS);
	  }
	  
	  driver.quit();
	 
  }
  
  
}
