package com.utilites;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public ExcelUtility(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet=workbook.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//To find the number of rows in excel sheet
	public int getRowCount() {
		int rows=0;
		try {
			rows = sheet.getPhysicalNumberOfRows();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows;
	}

	//To find the number of columns in excel sheet
	public int getColCount() {
		int cols=0;
		try {
			cols = sheet.getRow(0).getPhysicalNumberOfCells();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cols;
	}
	//To retrieve the data from the cell
	public String cellData(int rowNum, int colNum) {
		try {
			row=sheet.getRow(rowNum);
			cell=row.getCell(colNum);
			switch(cell.getCellType()) {
			case STRING:
				return cell.getStringCellValue();
			case NUMERIC:
				String cellText = String.valueOf((long)cell.getNumericCellValue());
				return cellText;
			case BOOLEAN:
				String boolValue = String.valueOf(cell.getBooleanCellValue());
				return boolValue;
			case BLANK:
				return " ";
			default:
				return " ";
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "row" + rowNum + "col" + colNum + "Does not exist";
		}

	}

}
