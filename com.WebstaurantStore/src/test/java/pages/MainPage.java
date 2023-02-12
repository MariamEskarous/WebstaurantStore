package pages;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import utilities.Base;
import utilities.LocatorMap;

public class MainPage extends Base {

	
	public static final Logger log = LogManager.getLogger(MainPage.class);
	
	String filePath = "src/test/resources/locatorMap.properties";
	LocatorMap myLocators = new LocatorMap(filePath);

	private WebDriver driver;
	
	
	public MainPage(WebDriver _driver) {
		driver = _driver;
		myLib.setDriver(driver);
	}
	
	public void GoToWebstaurantStoreWebsite (WebDriver _driver) {
		
		try {
			String URL = "https://www.webstaurantstore.com/";
			driver.get(URL);
			log.info("******** Went To WebstaurantStore Website *********");
			
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
		
	}
	
	public ProductPage EnterProductNameInSearchBox(String ProductName) {
		try {
			
			myLib.enterText(myLocators.getLocator("searchBoxField"), ProductName);
			log.info("********* Entered The Product Name In The SearchBox *******");
			
			myLib.clickElement(myLocators.getLocator("clickSearchBtn"));
			log.info("******* Clicked Search Button *******");
			
			
		}catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
		
		ProductPage productPage = new ProductPage(driver);
		return productPage;
	}
	
	
}
