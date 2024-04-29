package com.utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.reactivex.rxjava3.annotations.NonNull;

public class ExcelData {

	static FileInputStream fis;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static int priorityColumn;

	/* This method is used to read the file
	 * @Param FilePath
	 */
	public static void readFile(String excelPath){
		try {
			fis = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			System.out.println("File not found in the given location. Please ensure file is present in given location");
			e.printStackTrace();
		}
		try {
			workbook=new XSSFWorkbook(fis);
		} catch (IOException e) {
			System.out.println("Unable to read the workbook");
			e.printStackTrace();
		}
	}
	/*This method is used to get the number of rows in the sheet using sheet Name
	 * @Param sheetName
	 * returns number of rows
	 */
	public static int getRowCount(@NonNull String sheetName) {
		sheet = workbook.getSheet(sheetName);
		int rows=sheet.getLastRowNum(); // It returns number of rows-1
		//sheet.getPhysicalNumberOfRows(); // It returns actual number of rows.
		return rows;
	}
	/*This method is used to get the number of rows in the sheet using sheet Number
	 * @Param sheetNum
	 * returns number of rows
	 */
	public static int getRowCount(int sheetNum) {
		sheet=workbook.getSheetAt(sheetNum);
		int rows = sheet.getLastRowNum();  // It returns number of rows-1
		//sheet.getPhysicalNumberOfRows(); // It returns actual number of rows.
		return rows;
	}
	/*This method is used to get the number of columns in the sheet using sheet Name
	 * @Param sheetName
	 * returns number of columns
	 */
	public static int getColumnCount(@NonNull String sheetName) {
		sheet=workbook.getSheet(sheetName);
		int cols=sheet.getRow(0).getLastCellNum(); // It returns all the columns present in the sheet
		//or sheet.getPhysicalNumberOfRows(); // It returns all the columns present in the sheet
		return cols;
	}
	/*This method is used to get the number of columns in the sheet using sheet Number
	 * @Param sheetNum
	 * returns number of columns
	 */
	public static int getColumnCount(int sheetNum) {
		sheet =workbook.getSheetAt(sheetNum);
		int cols=sheet.getRow(0).getLastCellNum(); // It returns all the columns present in the sheet
		//or sheet.getPhysicalNumberOfRows(); // It returns all the columns present in the sheet
		return cols;
	}
	/*This method is used to fetch cell data from excel in String
	 * @Param Row number
	 * @Param Column number
	 * returns cell data
	 */
	public static String getCellData(int row, int col) {
		DataFormatter formatter = new DataFormatter();
		String data=formatter.formatCellValue(sheet.getRow(row).getCell(col));
		return data;
	}
	/*This method is used to read the data from excel using getCellData() and store in 2D array
	 * @Param noOfRows
	 * @Param noOfCols
	 * returns 2D array
	 */
	public static Object[][] readData(int rows, int cols){
		Object data[][] = new Object[rows][cols];
		for(int i=1; i<=rows; i++) {
			for(int j=0; j<cols; j++) {
				data[i-1][j]=getCellData(i, j);
			}
		}
		return data;
	}
	/*This method is used to get the excel data using the sheet name and returns the data in 2D array
	 * @Param ExcelPath
	 * @Param sheetName
	 * returns 2D array
	 */
	public static Object[][] getExcelData(String excelPath, String sheetName){
		readFile(excelPath);
		int rows=getRowCount(sheetName);
		int cols=getColumnCount(sheetName);
		Object[][] data= readData(rows, cols);
		return data;
	}
	/*This method is used to get the excel data using sheet number and returns the data in 2D array
	 * @Param ExcelPath
	 * @Param sheetNum
	 * returns 2D array
	 */
	public static Object[][] getExcelData(String excelPath, int sheetNum){
		readFile(excelPath);
		int rows= getRowCount(sheetNum);
		int cols=getColumnCount(sheetNum);
		Object[][] data = readData(rows, cols);
		return data;
	}
	/*This method is used to read excel data and put it in List<HashMap>
	 * @Param headingsRow (To be ignored in the result)
	 * @Param columns
	 * @Param headings Names
	 * @Param row
	 * @list
	 */
	public static List<HashMap<String,Object>> readExcelDataAndStoreInListOfHashMap(int headingsRow, 
			int cols, String[] headings, int row,  List<HashMap<String,Object>> list){
		HashMap<String,Object> map= new HashMap<String, Object>();
		for(int j=0; j<cols; j++) {
			map.put(headings[j], getCellData(row+headingsRow, j));	
		}
		list.add(map);
		return list;
	}
	/*This method is used to get data from excel as 2D array. First dimension is hashmap and second dimension object in 2D.
	 * @Param ExcelPath
	 * @Param sheetName
	 * @Param headingsRow
	 * @Param priority
	 * returns 2D array 1 as hashmap and 2nd as object
	 */
	public static Object[][] getData(String excelPath, String sheetName, int headingsRow, @NonNull String priority){
		readFile(excelPath);
		int rowsCount = getRowCount(sheetName);
		int colsCount = getColumnCount(sheetName);
		List<String> priorityList = Arrays.asList(priority.toUpperCase().split(","));
		String[] headings = new String[colsCount];
		List<HashMap<String, Object>> list = new ArrayList();
		int findPriorityColumn =0;
		for(int j=0; j<colsCount; j++) {
			headings[j]=getCellData(headingsRow-1, j);
			if(headings[j].equals("Priority")) {
				priorityColumn=j;
				findPriorityColumn++;
			}
		}
		if(!priority.equalsIgnoreCase("all")){
			if(findPriorityColumn>0) {
				for(int i=0; i<rowsCount-headingsRow;i++) {
					if(priorityList.contains(getCellData(i, priorityColumn).toUpperCase())) {
						list=readExcelDataAndStoreInListOfHashMap(headingsRow, colsCount, headings, i, list);
					}
				}
				if(list.isEmpty()) {
					System.out.println("No data is found with given priority");
				}
			}else {
				System.out.println("Priority column is not created in Excel");
			}
		}else {
			for(int i=0; i<rowsCount-headingsRow; i++) {
				list=readExcelDataAndStoreInListOfHashMap(headingsRow, colsCount, headings, i, list);
			}
		}

		Object hashMapObjdata[][] = new Object[list.size()][1];
		for(int i=0; i<list.size(); i++) {
			hashMapObjdata[i][0]=list.get(i);
		}
		return hashMapObjdata;
	}
	/*This method is used to get the data from the excel with specified number of rows
	 * It returns the data in 2D array 1st dimension is HashMap and 2nd is Object array
	 * @Param excelPath
	 * @Param sheetName
	 * @Param startRow
	 * @Param endRow
	 * @Param headingsRow -- Headings to be ignored in the result
	 * returns 2D array
	 */
	public static Object[][] getData(String excelPath, String sheetName, int startRow, int endRow, 
			int headingsRow, @NonNull String priority){
		readFile(excelPath);
		int colsCount=getColumnCount(sheetName);
		List<String> priorityList = Arrays.asList(priority.toUpperCase().split(","));
		String[] headings = new String[colsCount];
		List<HashMap<String,Object>> list = new ArrayList<>();
		int findPriorityColumn=0;
		for(int i=0; i<colsCount; i++) {
			headings[i]=getCellData(0, colsCount);
			if(headings[i].equals("Priority")) {
				priorityColumn=i;
				findPriorityColumn++;
			}
		}
		if(!priority.equalsIgnoreCase("all")) {
			if(findPriorityColumn>0) {
				for(int i=startRow-1; i<endRow; i++) {
					if(priorityList.contains(getCellData(i, priorityColumn).toUpperCase())){
						list=readExcelDataAndStoreInListOfHashMap(headingsRow, colsCount, headings, i , list);
					}
					if(list.isEmpty()) {
						System.out.println("Data not found with given priority");
					}

				}
			}else {
				System.out.println("Priority column is not created");
			}
		}else {
			for(int i=startRow-1; i<endRow;i++) {
				list=readExcelDataAndStoreInListOfHashMap(headingsRow, colsCount, headings, i, list);
			}
		}

		Object[][] hashMapObjdata = new Object[list.size()][1];
		for(int i=0; i<list.size(); i++) {
			hashMapObjdata[i][0]=list.get(i);
		}
		return hashMapObjdata;
	}

}
