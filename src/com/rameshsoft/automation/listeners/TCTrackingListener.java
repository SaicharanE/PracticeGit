package com.rameshsoft.automation.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.rameshsoft.automation.utilities.ScreenshotUtility;

public class TCTrackingListener implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("SUITE EXECUTION IS ENDED");
	}
	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("SUITE EXECUTION IS STARTED");
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
	}
	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("TC FAILURE: " +arg0.getName());
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
		System.out.println("TC IS PASSED: " +arg0.getName());
	}
}
