package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Base {
	public static final Logger log = LogManager.getLogger(Base.class);

	public WebDriver driver;
	public SeleniumUtilities myLib = new SeleniumUtilities();

	@BeforeMethod
	public void setUp() {

		WebDriverManager.chromedriver().setup();
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		myLib.customWait(5);
		driver.close();
		driver.quit();
	}

}
