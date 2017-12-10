package com.w2a.architectbatch1.TestUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;


import com.w2a.architectbatch1.baseSetup.TestSetUp;

public class TestUtils extends TestSetUp{
	

	public static String screenshotPath;
	public static String screenshotName;

	/*
	 * @description: Method to take capture screenshot
	 */
	public static void captureScreenshot() throws IOException {
		
		screenshotPath = "./Screenshots/";
		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";

		
		
		FileUtils.copyFile(scrFile,
				new File(screenshotPath + screenshotName));


	}
	/*@DataProvider(name = "dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		//String sheetName = "tc_01";
		int rows = excel.getRowCount(sheetName);//2
		int cols = excel.getColumnCount(sheetName);//2

		Object[][] data = new Object[rows - 1][1];//2 1

		Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			table = new Hashtable<String, String>();

			for (int colNum = 0; colNum <cols; colNum++) {

				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}
	
		return data;

	}*/
	
	@DataProvider(name = "dm")
	public Object[][] getData1(Method m) {
		
		//ExcelReaderOmi excel = tlExcel.get();

		String methodName = m.getName();
		//String sheetName = "tc_01";
		excel.getCurrentTestCaseDetails(methodName);
		int currentTestCaseRow = excel.currentTestCaseRowNum;
		int rowCount= excel.rowCount;
		int colCount =excel.columnCount;
		
		

		Object[][] data = new Object[rowCount][1];//2 1

		Hashtable<String, String> table = null;

		for (int rowNum = 1; rowNum <= rowCount; rowNum++) {

			table = new Hashtable<String, String>();

			for (int colNum = 0; colNum <colCount; colNum++) {

				table.put(excel.getCellData(currentTestCaseRow, colNum),excel.getCellData(currentTestCaseRow+rowNum, colNum));
			}
			
			data[rowNum-1][0]=table;

		}
	
		return data;

	}
}
