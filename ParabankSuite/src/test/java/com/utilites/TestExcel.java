package com.utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestExcel {

	public static void main(String[] args) {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(".//TestData//TestData.xlsx"));
			XSSFSheet sheet = workbook.getSheet("UserData");
			System.out.println(sheet.getLastRowNum());
			System.out.println(sheet.getPhysicalNumberOfRows());
			for(int i=0; i<=sheet.getLastRowNum(); i++) {
				System.out.print(sheet.getRow(i).getCell(0)+" ");
			}
			System.out.println();
			for(int i=0; i<sheet.getPhysicalNumberOfRows(); i++) {
				System.out.print(sheet.getRow(i).getCell(0)+" ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
