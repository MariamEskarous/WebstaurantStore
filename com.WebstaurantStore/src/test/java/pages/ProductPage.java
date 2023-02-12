package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import utilities.Base;
import utilities.LocatorMap;

public class ProductPage extends Base {

	public static final Logger log = LogManager.getLogger(ProductPage.class);
	
	String filePath = "src/test/resources/locatorMap.properties";
	LocatorMap myLocators = new LocatorMap(filePath);
	
	private WebDriver driver;

	public ProductPage(WebDriver _driver) {

		try {
			driver = _driver;
			myLib.setDriver(driver);

			WebElement filterToggle = myLib.waitForElementVisibility(myLocators.getLocator("filterToggle"));
			assertNotNull(filterToggle);

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}

	}

	public void CheckProductTitle(String productName) {
		try {

			
			List<WebElement> regencyelems = driver.findElements(myLocators.getLocator("ListOfregencyelems"));
			int size=regencyelems.size();
			log.info("******** Total Number of Products shown in the Page Is "+ size +" ***********");

			for (WebElement reg : regencyelems) {
				String TXT = reg.getText();
				// log.info(TXT);
				if (TXT.contains(productName)) {
					log.info( "******** This Product contains " + productName + "**********" + TXT);
				} else {
					log.info("******** This Product Does NOT contain " + productName + "**********" + TXT);

				}
			}

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}
	
	public void AddLastProductIntoTheCart() {
		try {
			
			myLib.clickElement(myLocators.getLocator("LastProduct"));
			log.info("******** Added Last Item Into The Cart ***********");
		}catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}
	
	public CartPage ViewTheCart() {
		try {
			myLib.clickElement(myLocators.getLocator("ViewTheCartBtn"));
		}catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
}//close
