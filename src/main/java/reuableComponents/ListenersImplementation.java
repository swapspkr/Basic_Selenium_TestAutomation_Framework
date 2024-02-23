package reuableComponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import testBase.ObjectRepo;

public class ListenersImplementation extends ObjectRepo implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// before each Testcase
		test = extend.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Cases :"+result.getMethod().getMethodName()+" is Passed. ");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Cases :"+result.getMethod().getMethodName()+" is Failed. ");
		test.log(Status.FAIL, result.getThrowable());
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualdate = format.format(date);
		
		// Add screenshot for failed testcase
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir")+"/Report/Screenshots/"+actualdate+".jpeg";
		File dest = new File(screenshotPath);
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			test.addScreenCaptureFromPath(screenshotPath,"Test Case failure screenshot.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
	// setup method call 
		extend	= ExtentSetup.setupExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		// close extend
		
		extend.flush();
	}

	
}
