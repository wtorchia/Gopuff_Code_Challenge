package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pom.ShopPage;

import org.testng.annotations.Test;

public class ShopPageTests extends TestBase{


  @Test
  private void searchForProductLoggedOut() throws InterruptedException {
	 
	  WebDriver driver = getChromeDriver(); 

	  boolean result = getURL(driver, ShopPage.PAGE_URL);    
	  
	  
	  if(result) {
		  
		  result = waitForElementByID(driver, ShopPage.SEARCH_BOX_ID);
		  
	  }

	
	  
	  driver.quit();
	 
  }
  
  
}
