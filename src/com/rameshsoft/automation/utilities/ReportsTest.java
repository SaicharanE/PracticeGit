package com.rameshsoft.automation.utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportsTest {
public static void main(String[] args) {
	
	ExtentReports extentReports = new ExtentReports("E:\\MyWorkspace\\frameworks830am\\Reports\\report.html");
	
	ExtentTest extentTest = extentReports.startTest("practice");
	
	extentTest.log(LogStatus.INFO, "Browser is opened");
	extentTest.log(LogStatus.INFO, "URL is entered as : https://www.gmail.com");
	extentTest.log(LogStatus.INFO, "DTA isdone on UN with testdata: practice");
	extentTest.log(LogStatus.INFO, "clicked on next buton");
	
	
	extentReports.endTest(extentTest);
	extentReports.flush();
	extentReports.close();
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
