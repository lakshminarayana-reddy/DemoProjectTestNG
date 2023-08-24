package com.utilites;

import java.io.File;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.driverscript.TestBase;

public class TestUtil extends TestBase {
	public static void captureScreenshot() {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file =ts.getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		String sc = d.toString().replace(':', '_').replace(' ','_')+".jpg";
		try {
			FileUtils.copyFile(file, new File(".\\Screenshots"+ sc));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider(name="registerParaUser")
	public Object[][] getData() {
		String excelPath=System.getProperty("user.dir")+".\\TestData\\ParaBankTestData.xlsx";
		String sheetName="RegisterUser";
		ExcelUtility excel = new ExcelUtility(excelPath, sheetName);
		int row = excel.getRowCount();
		int col= excel.getColCount();
		Object data[][] = new Object[row-1][1];
		
		Hashtable<String, String> table = null;
		for(int rowNum=1; rowNum<row; rowNum++) {
			table= new Hashtable<String, String>();
			for(int colNum=0; colNum<col; colNum++) {
				table.put(excel.cellData(0, colNum), excel.cellData(rowNum, colNum));
				data[rowNum-1][0] = table;
			}
			
		}
		return data;

	}

}
