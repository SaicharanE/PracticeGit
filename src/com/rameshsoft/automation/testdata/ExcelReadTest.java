package com.rameshsoft.automation.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReadTest {
public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
	
	FileInputStream fip = new FileInputStream("E:\\MyWorkspace\\frameworks830am\\src\\com\\rameshsoft\\automation\\testdata\\test.xls");
	
	Workbook wb = WorkbookFactory.create(fip);
	//WorkbookFactory.create(new File(""));
	
	Sheet sheet1 = wb.getSheet("Sheet1");
	//Sheet sheet = wb.getSheetAt(0);
	
	Row row0 = sheet1.getRow(0);
	
	Cell cell00 = row0.getCell(0);
	String cell00Value = cell00.getStringCellValue();
	System.out.println("0R 0C Data is : " +cell00Value);
	
	Cell cell01 = row0.getCell(1);
	String cell01Value = cell01.getStringCellValue();
	System.out.println("0R 1C Data is : " +cell01Value);
	
	Row row1 = sheet1.getRow(1);
	Cell cell10 = row1.getCell(0);
	String cell10Value = cell10.getStringCellValue();
	System.out.println("1R 0C Data is: " +cell10Value);
	
	Cell cell11 = row1.getCell(1);
	
	if (cell11.getCellType()==cell11.CELL_TYPE_STRING) {
		String cell11Value = cell11.getStringCellValue();
		System.out.println("1R 1C Data is: " +cell11Value);
		
	}
	
	else if (cell11.getCellType()==cell11.CELL_TYPE_NUMERIC) {
		System.out.println(cell11.getNumericCellValue());
	}
}
}
