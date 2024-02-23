package insuranceCalculator_Motorcycle;


import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testBase.TestBase;

public class ErrorTests_motorcycle extends TestBase{


	@Test(enabled=false)
	public void error_Message_PayLoadField() throws Exception {
		homepage.clickOnMotorcycleLink();
		vehdata.enterCyclinderCapacity("33333");
		test.log(Status.PASS, "Cyclinder capacity fill with data : 33333");
		String actualErrorMsg = vehdata.getErrorMessageOnCyclinderCapacity();
		String expectedErrorMsg = "Must be a number between 1 and 2000";
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg,"Error message is not as expected on cyclinder capacity field");
	}
	
	@Test(enabled=false)
	public void error_Message_PayLoadField1() throws Exception {
		homepage.clickOnMotorcycleLink();
		vehdata.enterCyclinderCapacity("33333");
		test.log(Status.PASS, "Cyclinder capacity fill with data : 33333");
		String actualErrorMsg = vehdata.getErrorMessageOnCyclinderCapacity();
		String expectedErrorMsg = "dump";
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg,"Error message is not as expected on cyclinder capacity field");
	}
	
	@Test
	public void verify_ModelDropdownOptions() {
		homepage.clickOnMotorcycleLink();
		
		//get dropdown modelOptions
		List<String> actual_Values = vehdata.getDropDownOptions_model();
		test.log(Status.INFO, "Actual downdown content for Model is:"+actual_Values);
		//Expected options
		List<String> expected_Values = Arrays.asList("– please select –","Scooter","Three-Wheeler","Moped","Motorcycle");
		test.log(Status.INFO, "Expected downdown content for Model is:"+expected_Values);
		//Assert
		Assert.assertEquals(actual_Values, expected_Values,"Error in dropdown options compare");
	}
}
