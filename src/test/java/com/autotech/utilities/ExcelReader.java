package com.autotech.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.autotech.base.TestBase;

import sun.util.logging.resources.logging;

public class ExcelReader extends TestBase {

	public String path;
	public FileInputStream fis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;

	public ExcelReader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(this.path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			appLog.error("Exception occured while reading test data excel :" + e.getMessage());
		}
	}

	public int getRowCount(String sheetName) {
		this.sheet = this.workbook.getSheet(sheetName);
		return this.sheet.getLastRowNum();
	}

	public int getColumnCount(String sheetName) {
		this.sheet = this.workbook.getSheet(sheetName);
		return this.sheet.getRow(0).getLastCellNum();
	}
	
	public String getStringCellData(String sheetName, int rowNum, int colNum) {
		this.sheet = this.workbook.getSheet(sheetName);
		this.row = this.sheet.getRow(rowNum);
		return this.row.getCell(colNum-1).getStringCellValue();
				
	}
	
	public int getNumericCellData(String sheetName, int rowNum, int colNum) {
		this.sheet = this.workbook.getSheet(sheetName);
		this.row = this.sheet.getRow(rowNum);
		return (int)this.row.getCell(colNum-1).getNumericCellValue();
				
	}
}
