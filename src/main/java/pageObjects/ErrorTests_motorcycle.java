package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class ErrorTests_motorcycle extends TestBase{
	
	
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
	
	
	@FindBy(id="nextenterproductdata")
	WebElement btn_Next;
	
	
	public ErrorTests_motorcycle() {
		
		PageFactory.initElements(driver, this);
	}
	
	
}
