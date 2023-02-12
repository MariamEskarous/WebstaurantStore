package tests;

import utilities.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.MainPage;
import pages.ProductPage;
public class smokeTest extends Base {

	public static final Logger log = LogManager.getLogger(smokeTest.class);
	
	
	@Test
	public void Test_001() {
		
		MainPage mainPage = new MainPage(driver);
		ProductPage productPage;
		CartPage cartPage;
		
		mainPage.GoToWebstaurantStoreWebsite(driver);
		productPage = mainPage.EnterProductNameInSearchBox("stainless work table");
		productPage.CheckProductTitle("Table");
		productPage.AddLastProductIntoTheCart();
		cartPage = productPage.ViewTheCart();
		cartPage.EmptyTheCart();
		
	}

	
	
}
