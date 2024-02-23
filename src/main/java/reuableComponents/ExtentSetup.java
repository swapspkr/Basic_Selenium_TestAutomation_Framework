package reuableComponents;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.ObjectRepo;

public class ExtentSetup extends ObjectRepo  {
	
	public static ExtentReports setupExtentReport() {
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		
		Date date = new Date();
		String actualdate = format.format(date);
		String reportName = System.getProperty("user.dir")+"/Report/ExecutionReport_"+actualdate+".html";
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportName);
		ExtentReports extend = new ExtentReports();
		
		extend.attachReporter(sparkReport);
		sparkReport.config().setDocumentTitle("Document Titile");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("Extend Report");
		
		return extend ;
	}

	
}

