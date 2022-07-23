package com.rameshsoft.automation.testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelWriteTest {
public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
FileInputStream fip = new FileInputStream("E:\\MyWorkspace\\frameworks830am\\src\\com\\rameshsoft\\automation\\testdata\\test.xls");
	Workbook wb = WorkbookFactory.create(fip);
	Sheet sheet1 = wb.getSheet("Sheet1");
	//Sheet sheet = wb.getSheetAt(0);
	
	
	sheet1.getRow(0).createCell(4).setCellValue("PRACTICE");
	/*Row row0 = sheet1.getRow(0);
	Cell cell04 = row0.createCell(4);
	cell04.setCellValue("PRACTICE");
	*/
	
	Row row4 = sheet1.createRow(4);
	
	row4.createCell(0).setCellValue("HELLO");
	row4.createCell(1).setCellValue("HI");
	
	wb.write(new FileOutputStream("E:\\MyWorkspace\\frameworks830am\\src\\com\\rameshsoft\\automation\\testdata\\test.xls"));
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
