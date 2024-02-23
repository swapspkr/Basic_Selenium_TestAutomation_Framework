package reuableComponents;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {

	public void selectDropDownOption(WebElement element,String valueToBeSelected) throws Exception {
		Select os = new Select(element);
		try {
			os.selectByVisibleText(valueToBeSelected);
		}
		catch(Exception e) {
			throw new Exception("Value is not present in the dropdown for WebElement "+element+"Value to be select is "+valueToBeSelected);
		}
		
	}
	

	public void selectRadioButtonValue(List<WebElement> element,String valueToBeSelected) {
		for(WebElement ref : element) {
			if(ref.getText().equalsIgnoreCase(valueToBeSelected)) {
				ref.click();
				break;
			}
		}
		
	}
	
	// Selecting checkbox
	public void selectCheckBoxes(List<WebElement> element,String checks) {
		String[] checkArray = checks.split(",");
		for(String str : checkArray) {
			
			for(WebElement ref : element) {
				if(ref.getText().equalsIgnoreCase(str)) {
					ref.click();
					break;
				}
			}
		}
		
		
	}
	
	// Get dropdown options as list of string for compare
	public ArrayList<String> getDropDownOptionsAsList(WebElement element) {

		Select os = new Select(element);
		List<WebElement> options = os.getOptions();
		ArrayList<String> actual_contents = new ArrayList<String>();

		for(WebElement ref :options) {
			actual_contents.add(ref.getText());
		}
		return actual_contents;
	}


}
