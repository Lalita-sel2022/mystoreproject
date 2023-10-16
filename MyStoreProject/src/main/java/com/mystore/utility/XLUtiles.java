package com.mystore.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtiles {
	
	public static FileInputStream file;
	public static FileOutputStream fileWri;
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	
	public static int getRowCount(String filePath, String sheetName) throws IOException
	{
		file = new FileInputStream(filePath);
		book= new XSSFWorkbook(file);
		sheet=book.getSheet(sheetName);
		int rowCout = sheet.getLastRowNum();
		book.close();
		file.close();
		return rowCout;
		
	}
	
	public static int getCellCount(String filePath, String sheetName, int rowNo) throws IOException
	{
		file = new FileInputStream(filePath);
		book= new XSSFWorkbook(file);
		sheet=book.getSheet(sheetName);
		row = sheet.getRow(rowNo);
		int cellCount = row.getLastCellNum();
		book.close();
		file.close();
		return cellCount;
		
	}
	
	public static String getData(String filePath, String sheetName, int rowNo, int cellNo) throws IOException
	{
		file = new FileInputStream(filePath);
		book= new XSSFWorkbook(file);
		sheet=book.getSheet(sheetName);
		row = sheet.getRow(rowNo);
		cell = row.getCell(cellNo);
		String data;
		try {
			DataFormatter format= new DataFormatter();
			String cellData = format.formatCellValue(cell);
			return cellData;
		}
		catch (Exception e) {
			
			data="";
		}
		book.close();
		file.close();
		return data;
		
	}
	
	public static void setCellData(String filePath, String sheetName, int rowNo, int cellNo,String data) throws IOException
	{
		file = new FileInputStream(filePath);
		book= new XSSFWorkbook(file);
		sheet=book.getSheet(sheetName);
		row = sheet.getRow(rowNo);
		cell = row.createCell(cellNo);
		cell.setCellValue(data);
		fileWri= new FileOutputStream(filePath);
		book.write(fileWri);
		book.close();
		file.close();
		fileWri.close();
		
		
	}

}
