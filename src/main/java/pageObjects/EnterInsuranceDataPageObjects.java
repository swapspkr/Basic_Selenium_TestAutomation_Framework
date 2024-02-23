package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterInsuranceDataPageObjects extends TestBase {
	
	
	@FindBy(id="firstname")
	WebElement txt_firstname;
	
	@FindBy(id="lastname")
	WebElement txt_lastname;
	
	@FindBy(xpath="//input[@name='Gender']/parent::label")
	List<WebElement> rbtn_gender;
	
	@FindBy(xpath="//input[@name='Hobbies']/parent::label")
	List<WebElement> chbx_hobbies;
	
	@FindBy(id="birthdate")
	WebElement txt_dob;
	
	@FindBy(id="streetaddress")
	WebElement txt_streetaddress;
	
	@FindBy(id="country")
	WebElement dd_country;
	
	@FindBy(id="city")
	WebElement txt_city;
	
	@FindBy(id="zipcode")
	WebElement txt_zipcode;
	
	@FindBy(id="occupation")
	WebElement dd_occupation;
	
	@FindBy(id="nextenterproductdata")
	WebElement btn_Next;
	
	@FindBy(id="website")
	WebElement txt_website;
	
	@FindBy(id="nextenterproductdata")
	WebElement btn_next;
	
	public EnterInsuranceDataPageObjects() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void enterInsuranctData() throws Exception {
		txt_firstname.sendKeys("Swapnil");
		txt_lastname.sendKeys("Supekar");
		txt_dob.sendKeys("12/12/1989");
		cm.selectRadioButtonValue(rbtn_gender, "Male");
		txt_streetaddress.sendKeys("JM Street");
		cm.selectDropDownOption(dd_country, "India");
		txt_city.sendKeys("Pune");
		txt_zipcode.sendKeys("411015");
		cm.selectDropDownOption(dd_occupation, "Employee");
		cm.selectCheckBoxes(chbx_hobbies, "Speeding,Other");
	}
	
	public void clickNextButton() {
		btn_next.click();
	}
}
