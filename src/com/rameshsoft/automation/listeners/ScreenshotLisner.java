package com.rameshsoft.automation.listeners;

import java.io.IOException;

import org.testng.ITestResult;
import com.rameshsoft.automation.utilities.ScreenshotUtility;

public class ScreenshotLisner extends CustomTestListenerAdapter {

	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("TC IS FAILURE: " +arg0.getName());
		try {
			ScreenshotUtility.screenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("TC IS SKIPPED: " +arg0.getName());
		try {
			ScreenshotUtility.screenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("CURRENT TC EXECUTION IS : " +arg0.getName());
	}
	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("TC IS PASSED : " +arg0.getName());
	}
}


