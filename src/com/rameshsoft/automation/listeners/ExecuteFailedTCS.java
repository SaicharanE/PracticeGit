package com.rameshsoft.automation.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ExecuteFailedTCS implements IRetryAnalyzer
{
	@Override
	public boolean retry(ITestResult arg0) {
		
		return false;
	}
}
