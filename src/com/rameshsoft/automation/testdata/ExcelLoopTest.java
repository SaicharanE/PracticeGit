package com.rameshsoft.automation.testdata;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLoopTest {
public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
	
	File file = new File("E:\\MyWorkspace\\frameworks830am\\src\\com\\rameshsoft\\automation\\testdata\\test.xls");
	Workbook workbook = WorkbookFactory.create(file);
	
	Sheet sheet1 = workbook.getSheet("Sheet1");
	
	
	for(int i=0;i<sheet1.getLastRowNum()+1;i++)
	{
		Row row = sheet1.getRow(i);
		
		for(int j=0;j<row.getLastCellNum();j++)
		{
			Cell cell = row.getCell(j);
			if (cell.getCellType()==cell.CELL_TYPE_STRING) {
			System.out.println(cell.getStringCellValue());	
			}
			else if (cell.getCellType()==cell.CELL_TYPE_NUMERIC) {
				System.out.println(cell.getNumericCellValue());	
				}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
