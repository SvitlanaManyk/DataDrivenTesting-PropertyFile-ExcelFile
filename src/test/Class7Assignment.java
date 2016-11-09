package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.DataProvider;
import util.PropertiesLoader;

public class Class7Assignment {
	
	FirefoxDriver driver = null;
	PropertiesLoader props = new PropertiesLoader();
	
	@Before
	public void setup(){
		System.out.println("Test starting...");
		System.out.println("Starting driver...");
		driver = new FirefoxDriver();
	}
	
	@After
	public void byeByeBrowser(){
		System.out.println("Closing the driver...");
		driver.close();
		System.out.println("================================================");
	}
	@Test
	public void testBrowserLaunching(){
		PropertiesLoader props = new PropertiesLoader();
		DataProvider dataProvider = new DataProvider();
		
		String url = props.getProperty("website"); //using properties file
		System.out.println("Opening website "+url);
		System.out.println("Loading locators...");
		By searchBarLocator = new By.ByCssSelector(dataProvider.getData("searchBarLocator"));
		By searchButton = new By.ByCssSelector(dataProvider.getData("searchButton"));
		By resultsPageToolbar = new By.ByCssSelector(dataProvider.getData("resultsPageToolbar"));
		WebDriverWait wdWait = new WebDriverWait(driver, 5);
		
		
		driver.get(url);
		WebElement webSearchBar = driver.findElement(searchBarLocator);
		webSearchBar.sendKeys("cheese");
		WebElement webSearchButton = driver.findElement(searchButton);
		
		webSearchButton.click();
		
		wdWait.until(ExpectedConditions.visibilityOfElementLocated(resultsPageToolbar));
		System.out.println("Test OK!");

		
	}

}
