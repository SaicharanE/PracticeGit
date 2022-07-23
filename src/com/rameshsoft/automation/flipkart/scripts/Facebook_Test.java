package com.rameshsoft.automation.flipkart.scripts;

import org.testng.annotations.Test;

import com.rameshsoft.automation.base.BaseEngine;
import com.relevantcodes.extentreports.LogStatus;

public class Facebook_Test extends BaseEngine {

	@Test
	public void facebook_Test() {
		getDriver().get("https://www.facebook.com");
		getExtentTest().log(LogStatus.INFO, "URL is entered as: https://www.facebook.com");
	}
}




