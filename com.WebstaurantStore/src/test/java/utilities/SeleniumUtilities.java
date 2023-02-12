package utilities;

import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SeleniumUtilities {

	public static final Logger log = LogManager.getLogger(SeleniumUtilities.class);

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver _driver) {
		this.driver = _driver;
	}

	public WebElement waitForElementVisibility(By by) {
		WebElement elem = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			elem = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
		return elem;
	}

	public void enterText(By by, String inputString) {
		try {
			WebElement element = driver.findElement(by);
			element.clear();
			element.sendKeys(inputString);

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void clickElement(By by) {

		try {
			WebElement element = driver.findElement(by);
			element.click();

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void customWait(double inSeconds) {
		try {
			long seconds = (long) (inSeconds * 1000);

			Thread.sleep(seconds);

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}
	
	public void clickElementByJS(By by) {
		JavascriptExecutor js =((JavascriptExecutor) driver );
		WebElement ele = driver.findElement(by);
		js.executeScript("arguments[0].click();", ele);
	}

}
