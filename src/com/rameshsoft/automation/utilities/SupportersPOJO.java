package com.rameshsoft.automation.utilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.rameshsoft.automation.supporters.ApplicationProperties;
import com.rameshsoft.automation.supporters.ExcelReader;

public class SupportersPOJO {

	private static ApplicationProperties applicationProperties;
	private static ExcelReader excelReader;
	
	public static ExcelReader getExcelReader() throws EncryptedDocumentException, InvalidFormatException, IOException {
		excelReader = new ExcelReader(AppFilePaths.excelFilePath);
		return excelReader;
	}

	public static ApplicationProperties getConfAppObj() throws IOException{
		applicationProperties = new ApplicationProperties(AppFilePaths.confFilePath);
		return applicationProperties;
	}
	
	public static ApplicationProperties getOrAppObj() throws IOException{
		applicationProperties = new ApplicationProperties(AppFilePaths.orFilePath);
		return applicationProperties;
	}
}
