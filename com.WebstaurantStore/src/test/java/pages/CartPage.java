package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Base;
import utilities.LocatorMap;

public class CartPage extends Base {

	public static final Logger log = LogManager.getLogger(CartPage.class);
	
	String filePath = "src/test/resources/locatorMap.properties";
	LocatorMap myLocators = new LocatorMap(filePath);
	
	private WebDriver driver;
	
	public CartPage(WebDriver _driver) {
		try {
			driver = _driver;
			myLib.setDriver(driver);
			
			WebElement CartTitleElem = myLib.waitForElementVisibility(myLocators.getLocator("CartTitelTxt"));
			assertNotNull(CartTitleElem);
			
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
		
	}
	
	public void EmptyTheCart() {
		try {
			

			myLib.clickElementByJS(myLocators.getLocator("EmptyTheCartBtn"));
			//Thread.sleep(2000);
			myLib.customWait(2);
			myLib.clickElement(myLocators.getLocator("GreenEmptyTheCartBtn"));
			myLib.customWait(2);

			//Thread.sleep(2000);

			WebElement CartEmptyTxt= driver.findElement(myLocators.getLocator("CartEmptyTxt"));
			String ActualTxt =CartEmptyTxt.getText();
			String ExpectedTxt = "Your cart is empty";
			if (ActualTxt.contains(ExpectedTxt)) {
			log.info("********* Emptied The Cart ********* ");
			}else {
				log.info("******* Cart Is NOT Empty **********");
			}
			
		}catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

}
