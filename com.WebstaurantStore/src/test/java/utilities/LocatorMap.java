package utilities;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;


public class LocatorMap {


	public static final Logger log = LogManager.getLogger(LocatorMap.class);
	Properties prop;

	public LocatorMap(String filePath) {
		prop = new Properties();
		try {

			FileInputStream file = new FileInputStream(filePath);
			prop.load(file);
			file.close();

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public By getLocator(String strElement) throws Exception {

		String locator = prop.getProperty(strElement);

		String locatorType = locator.split(";")[0];
		String locatorValue = locator.split(";")[1];


		if (locatorType.toLowerCase().equals("name"))
			return By.name(locatorValue);
		
		else if (locatorType.toLowerCase().equals("id"))
			return By.id(locatorValue);
		
		else if (locatorType.toLowerCase().equals("className") || locatorType.toLowerCase().equals("class"))
			return By.className(locatorValue);
		
		else if (locatorType.toLowerCase().equals("tagName") || locatorType.toLowerCase().equals("tag"))
			return By.tagName(locatorValue);
		
		else if (locatorType.toLowerCase().equals("cssSelector") || locatorType.toLowerCase().equals("css"))
			return By.cssSelector(locatorValue);
		
		else if (locatorType.toLowerCase().equals("xpath"))
			return By.xpath(locatorValue);
		
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return By.partialLinkText(locatorValue);
		
		else
			throw new Exception("Unknown Locator Type Passed " + locatorType);

	}

	public static void main(String[] args) {
		try {

			String filePath = "src/test/resources/locatorMap.properties";
			LocatorMap myLocators = new LocatorMap(filePath);
			By locator = myLocators.getLocator("searchBoxField");
			log.info(locator);

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	
}
