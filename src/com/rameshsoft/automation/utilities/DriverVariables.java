package com.rameshsoft.automation.utilities;

import com.rameshsoft.automation.base.BaseEngine;

public interface DriverVariables {
 
	String chromeKey = "webdriver.chrome.driver";
	String chromeValue = BaseEngine.getCurDir()+"\\Drivers\\chromedriver.exe";
	
	String ieKey = "webdriver.ie.driver";
	String ieValue = "";
	
	String firefoxKey = "webdriver.gecko.driver";
	String firefoxValue = "";
}
