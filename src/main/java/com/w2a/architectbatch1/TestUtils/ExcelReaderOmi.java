package com.w2a.architectbatch1.TestUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderOmi {
	
	public String path;
	public FileInputStream fis;
	public  FileOutputStream fileOut =null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row   =null;
	private XSSFCell cell = null;
	public static int currentTestCaseRowNum;
	public String currentTestCaseName;
	public int columnCount;
	public int rowCount;
	
	public ExcelReaderOmi(String path) {
		try {
		this.path=path;
		fis= new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		fis.close();
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	public void getCurrentTestCaseDetails(String testCaseId) {
		currentTestCaseName=testCaseId;
		//int currentTestCaseStarRow =0;
		sheet=workbook.getSheet("tc_01");
		
		
		//if the sheet exists then find the row where the current test case starts
		if(!sheet.equals(null)) {
			for(int i=0;i<sheet.getLastRowNum()+1;i++) {
				if(sheet.getRow(i).getCell(0).getStringCellValue().equals(testCaseId+"_starts")) {
					currentTestCaseRowNum=i+1;
					break;
				}
			}
			columnCount = sheet.getRow(currentTestCaseRowNum).getLastCellNum();
			//int rowCount=0;
			int j=currentTestCaseRowNum+1;
			while(!sheet.getRow(j).getCell(0).getStringCellValue().equals(currentTestCaseName+"_ends")) {
				j++;
				rowCount++;
			}
		
		}
		//return currentTestCaseRowNum;
		
	}
	public int getRowCount() {
		int rowCount=0;
		int j=currentTestCaseRowNum+1;
		while(!sheet.getRow(j).getCell(0).getStringCellValue().equals(currentTestCaseName+"_ends")) {
			j++;
			rowCount++;
		}
		return rowCount;
	}
	
	public int getColumnCount() {
		int columnCount=0;
		//sheet=workbook.getSheet(sheetName);
		columnCount=sheet.getRow(currentTestCaseRowNum).getLastCellNum();		
		return columnCount;
	}
	
	public String getCellData(int rowNum,String columnName) {
		//String columnName=null;
		int colNum=0;
		//int rowNum=0;
		
		int columnCount = sheet.getRow(currentTestCaseRowNum).getLastCellNum();
		
		for(int i=0;i<columnCount;i++) {
		
			if(sheet.getRow(currentTestCaseRowNum).getCell(i).getStringCellValue().equals(columnName)) {
			
				colNum=i;
				break;
			}
		}
		cell=sheet.getRow(rowNum+1).getCell(colNum);
		if(cell.getCellType()==Cell.CELL_TYPE_STRING)
			return cell.getStringCellValue();
		
		else
			return String.valueOf(cell.getNumericCellValue());
		}
	
	
	
	public String getCellData(int rowNum,int colNum) {
		//String columnName=null;
		//int colNum=0;
		//int rowNum=0;
		
		//int columnCount = sheet.getRow(currentTestCaseRowNum).getLastCellNum();
		
		cell=sheet.getRow(rowNum).getCell(colNum);
		if(cell.getCellType()==Cell.CELL_TYPE_STRING)
			return cell.getStringCellValue();
		
		else
			return String.valueOf(cell.getNumericCellValue());
		
	}
	
	
	
	
	public void setCellData(String columnName,int rowNum,String value) {
		
		try {
		int colNum=0;
		int columnCount = sheet.getRow(rowNum).getLastCellNum();
		
		for(int i=0;i<columnCount;i++) {
		
			if(sheet.getRow(currentTestCaseRowNum).getCell(i).getStringCellValue().equals(columnName)) {
			
				colNum=i;
				break;
			}
		}
		sheet.getRow(currentTestCaseRowNum+rowNum).getCell(colNum).setCellValue(value);
		fileOut = new FileOutputStream(path);

		workbook.write(fileOut);
	    fileOut.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

		
	}
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelReaderOmi read = new ExcelReaderOmi("C:\\Users\\omijoshi\\eclipse-oxygen-workspace\\PracticePackage\\simple.xlsx");
		//System.out.println(read.getRowCount("tc_01","tc_02"));
		read.getCurrentTestCaseDetails("tc_01");
		int testCaseRowStartNum=read.currentTestCaseRowNum;
		System.out.println(testCaseRowStartNum);
		int rowCount=read.rowCount;
		System.out.println(rowCount);
		int columnCount = read.columnCount;
		System.out.println(columnCount);

		Hashtable<String,String> tab =null;
		Object[][] obj= new Object[rowCount][1];
		
		for(int i=1;i<=rowCount;i++) {
			tab = new Hashtable<String,String>();
			for(int j=0;j<columnCount;j++) {
				tab.put(read.getCellData(currentTestCaseRowNum, j), read.getCellData(currentTestCaseRowNum+i,j));
				System.out.println(tab);
		}
			obj[i-1][0]=tab;
		}
		System.out.println(tab);
		if(Boolean.parseBoolean(tab.get("e"))) {
			System.out.println("yes it works");
		}
		
		//read.setCellData("Password", 1, "jhdsahdjadaaaaaaaaaaaaaaaajh");
	}
	
}
