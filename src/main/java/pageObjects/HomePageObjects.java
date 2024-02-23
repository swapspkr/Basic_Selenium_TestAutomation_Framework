package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.TestBase;


public class HomePageObjects extends TestBase{

	 //public WebDriver driver = new ChromeDriver();
	
	@FindBy(id="nav_automobile")
	WebElement link_automobile;
	
	@FindBy(id="nav_truck")
	WebElement link_truck;
	
	@FindBy(id="nav_motorcycle")
	WebElement link_motorcycle;
	
	@FindBy(id="nav_camper")
	WebElement link_camper;
	
	// Constructor : to use initElements method to initialize page objects 
	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAutomobileLink() {
		link_automobile.click();
	}
	
	public void clickOnTruckLink() {
		link_truck.click();
	}
	
	public void clickOnMotorcycleLink() {
		link_motorcycle.click();
	}
	
	public void clickonCamperLink() {
		link_camper.click();
	}
}
