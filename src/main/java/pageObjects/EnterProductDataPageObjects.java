package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterProductDataPageObjects extends TestBase {

	@FindBy(id="startdate")
	WebElement txt_startdate;
	
	@FindBy(id="insurancesum")
	WebElement dd_insurancesum;
		
	@FindBy(xpath="//input[@name='Optional Products[]']/parent::label")
	List<WebElement> chbx_optionalProducts;
	
	@FindBy(id="damageinsurance")
	WebElement dd_damageinsurance;
	
	@FindBy(id="nextselectpriceoption")
	WebElement nbtn_extselectpriceoption;
	

	
	
	public EnterProductDataPageObjects() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void enterProductData() throws Exception {
	
		txt_startdate.sendKeys("03/28/2024");
		cm.selectDropDownOption(dd_insurancesum, "3.000.000,00");
		cm.selectDropDownOption(dd_damageinsurance, "Partial Coverage");
		cm.selectCheckBoxes(chbx_optionalProducts,"Legal Defense Insurance" );
	}

	public void clickOnNextBtn() {
		nbtn_extselectpriceoption.click();
	}
}
