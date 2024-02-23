package insuranceCalculator_Motorcycle;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import reuableComponents.ExcelOperations;
import testBase.TestBase;

public class EndToEndTests_motorcycle extends TestBase {

	ExcelOperations excel = new ExcelOperations("InsurancePremium");

	@Test(dataProvider="vehData")	
	public void insuranceCalculate_VolvoMotor(Object obj1) throws Exception {

		@SuppressWarnings("unchecked")
		HashMap<String,String> testData = (HashMap<String, String>) obj1;
		
		System.out.println("test data: "+testData);
		
//		homepage.clickOnMotorcycleLink();
//		vehdata.enterVechileData();
//		vehdata.clickOnNextButton();
//		insData.enterInsuranctData();
//		insData.clickNextButton();
//		prodData.enterProductData();
//		prodData.clickOnNextBtn();
//		String expectedSilverPlan ="259.00";
//		String actual = priceOptions.getPriceForSelectedOption("Silver");
//		Assert.assertEquals(actual,expectedSilverPlan);
//		priceOptions.selectPriceOption("Silver");
//		priceOptions.clickNextButton();
	}


	@DataProvider(name="vehData")
	public Object[][] testDataSupplier() throws IOException, Exception{

		Object[][] obj = new Object[excel.getRowCount()][1];

		for(int i=1;i<= excel.getRowCount();i++) {

			HashMap<String ,String> testData = excel.getDataInMap(i);
			obj[i-1][0] = testData;
		}
		return obj;
	}



}
