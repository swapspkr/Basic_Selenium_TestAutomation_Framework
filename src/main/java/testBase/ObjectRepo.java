package testBase;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.EnterInsuranceDataPageObjects;
import pageObjects.EnterProductDataPageObjects;
import pageObjects.EnterVehicleDataPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.SelectPriceActionPageObjects;
import reuableComponents.CommonMethods;

public class ObjectRepo {
	public static WebDriver driver ;
	public static HomePageObjects homepage ;
	public static EnterVehicleDataPageObjects vehdata ;
	public static ExtentReports extend ;
	public static ExtentTest test;
	public static EnterInsuranceDataPageObjects  insData;
	public static EnterProductDataPageObjects prodData;
	public static CommonMethods cm = new CommonMethods();
	public static SelectPriceActionPageObjects priceOptions ;
}
