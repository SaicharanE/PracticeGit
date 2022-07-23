package com.rameshsoft.automation.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.rameshsoft.automation.base.BaseEngine;

public interface ScreenshotUtility {

	public static void screenShot(ITestResult result) throws IOException
	{
	TakesScreenshot ts = (TakesScreenshot) BaseEngine.getDriver();
	File file = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file, new File(BaseEngine.getCurDir()+""
			+ "\\Screenshots\\"+BaseEngine.getTcName()+".jpeg"));
	System.out.println("REASON for FAILURE: " +result.getThrowable());;
	}
	
	public static String screenShot() throws IOException
	{
	String screenshotLoc = BaseEngine.getCurDir()+"\\Screenshots\\"
	+BaseEngine.getTcName()+".jpeg";
	TakesScreenshot ts = (TakesScreenshot) BaseEngine.getDriver();
	File file = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file, new File(BaseEngine.getCurDir()+""
			+ "\\Screenshots\\"+BaseEngine.getTcName()+".jpeg"));
	return screenshotLoc;
	}	
	
}












