package com.rameshsoft.automation.supporters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	private String filePath;
	private FileInputStream fip;
	private Workbook workbook;
	private File file;
	private Sheet sheet;;
	private Row row;
	private Cell cell;
	
	public ExcelReader(String filePath) throws EncryptedDocumentException, InvalidFormatException, IOException {
		super();
		this.filePath = filePath;
		fip = new FileInputStream(filePath);
		workbook = WorkbookFactory.create(fip);
	}
	
	public ExcelReader(String file,String fileType) throws EncryptedDocumentException, InvalidFormatException, IOException {
		super();
		this.file = new File(file);
		workbook = WorkbookFactory.create(this.file);
		if (workbook!=null) {
			System.out.println("Workbook is created");
		}
		else{
			//throw new Exception("WORKBOOK IS POINTING TO NULL");
		}
	}
	
	public Sheet getSheetObj(String sheetName){
			sheet = workbook.getSheet(sheetName);
			if (sheet!=null) {
				System.out.println("SHEET IS CREATED");
			}
			else{
				//throw new Exception("SHEET IS POINTING TO NULL");
			}
		    return sheet;
	}
	
	public Sheet getSheetObj(int sheetIndex){
			sheet = workbook.getSheetAt(sheetIndex);
			if (sheet!=null) {
				System.out.println("SHEET IS CREATED");
			}
			else{
				//throw new Exception("SHEET IS POINTING TO NULL");
			}
		    return sheet;
	}
	
	public Row getRowObj(String sheetName,int rowNum) {
		sheet = getSheetObj(sheetName);
		row = sheet.getRow(rowNum);
		return row;
	}
	
	public Cell getCellObj(String sheetName,int rowNum,int cellNum) {
		row = getRowObj(sheetName, rowNum);
		cell = row.getCell(cellNum);
		return cell;
	}
	public String getSingleCellData(String sheetName,int rowNum,int cellNum) {
		String value = "";
		cell = getCellObj(sheetName, rowNum, cellNum);
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			value = cell.getNumericCellValue()+"";
			System.out.println(value);
		}
		else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
			value = cell.getStringCellValue();
			System.out.println(value);
		}
		return value;
	}
		
	public List<String> getTotalSheetData(String sheetName) {
		List<String> sheetData = new ArrayList<String>();
		sheet = getSheetObj(sheetName);
		for(int i=0;i<sheet.getLastRowNum()+1;i++)
		{
			Row row = null;
			
			for(int j=0;j<row.getLastCellNum();j++)
			{
				Cell cell = row.getCell(j);
				if (cell.getCellType()==Cell.CELL_TYPE_STRING) {
				System.out.println(cell.getStringCellValue());	
				sheetData.add(cell.getStringCellValue());
				}
				else if (cell.getCellType()==Cell.CELL_TYPE_NUMERIC) {
					System.out.println(cell.getNumericCellValue());	
					sheetData.add(cell.getNumericCellValue()+"");
				}
			}
		}
		return sheetData;
	}	
}
