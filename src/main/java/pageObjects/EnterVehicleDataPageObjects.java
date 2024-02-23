package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;

public class EnterVehicleDataPageObjects extends TestBase {

	WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(5));	// WebDriver driver = new ChromeDriver();
	
	@FindBy(id="make")
	WebElement dd_make;
	
	@FindBy(id="model")
	WebElement dd_model;
	
	@FindBy(xpath="//select[@id='model']")
	WebElement btn_Next;
	
	@FindBy(xpath="//input[@id='cylindercapacity']/following-sibling::span[@class='error']")
	WebElement error_cyclinderCapacity;
	
	@FindBy(id="cylindercapacity")
	WebElement txt_CyCapacity;
	
	@FindBy(id="engineperformance")
	WebElement txt_enginePerformance;
	
	@FindBy(id="dateofmanufacture")
	WebElement txt_dateofmanufacture;
	
	@FindBy(id="numberofseatsmotorcycle")
	WebElement dd_numberofseats;
	
	@FindBy(id="listprice")
	WebElement txt_listprice;
	
	@FindBy(id="annualmileage")
	WebElement txt_annualmileage;
	
	@FindBy(id="nextenterinsurantdata")
	WebElement btn_nextenterinsurantdata;
	
	public EnterVehicleDataPageObjects() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void enterCyclinderCapacity(String cyclinderCap) throws InterruptedException {
	
		txt_CyCapacity.sendKeys(cyclinderCap);
		//wait.wait(5);
	}
	
	public String getErrorMessageOnCyclinderCapacity() {
		System.out.println(error_cyclinderCapacity.getText());
		return error_cyclinderCapacity.getText();
	}

	public List<String> getDropDownOptions_model() {
		return cm.getDropDownOptionsAsList(dd_model);
	}
	
	public List<String> getDropDownOptions_make(){
		return cm.getDropDownOptionsAsList(dd_make);
	}
	
	public void enterVechileData() throws Exception {
		cm.selectDropDownOption(dd_make, "BMW");
		cm.selectDropDownOption(dd_model, "Moped");
		enterCyclinderCapacity("333");
		txt_enginePerformance.sendKeys("555");
		txt_dateofmanufacture.sendKeys("12/12/2006");
		cm.selectDropDownOption(dd_numberofseats,"2");
		txt_listprice.sendKeys("555");
		txt_annualmileage.sendKeys("555");
	}
	
	public void clickOnNextButton() {
		btn_nextenterinsurantdata.click();
	}
}
