package com.rameshsoft.automation.utilities;

import com.rameshsoft.automation.base.BaseEngine;

public interface AppFilePaths {

	String confFilePath = BaseEngine.getCurDir()+"\\config.properties";
	String orFilePath = BaseEngine.getCurDir()+"\\src\\com\\rameshsoft\\automation\\objectrepository\\OR.properties";
	String excelFilePath = BaseEngine.getCurDir()+"\\src\\com\\rameshsoft\\automation\\testdata\\test.xls";
	String txtFilePath = "";
	String csvFilePath = "";
	
}
