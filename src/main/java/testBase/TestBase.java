package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.api.internal.Utils;
import pageObjects.EnterInsuranceDataPageObjects;
import pageObjects.EnterProductDataPageObjects;
import pageObjects.EnterVehicleDataPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.SelectPriceActionPageObjects;
import reuableComponents.PropertiesOperations;

public class TestBase extends ObjectRepo{


	
	
	public void LaunchBrowserAndNavigate() throws Exception {
		String url = PropertiesOperations.getPropertyValueByKey("url");
		String browser = PropertiesOperations.getPropertyValueByKey("browser");
		
		switch(browser) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get(url);
	}
	
	@BeforeMethod
	public void setUpMethod() throws Exception {
		LaunchBrowserAndNavigate();
		homepage = new HomePageObjects();
		vehdata = new EnterVehicleDataPageObjects();
		insData = new EnterInsuranceDataPageObjects();
		prodData = new EnterProductDataPageObjects();
		priceOptions = new SelectPriceActionPageObjects();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
