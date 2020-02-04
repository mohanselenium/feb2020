package com.qa.hubspot.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	//read the data from excel file 
	
	/**
	 * Procedure 
	 * 1. Use the Apache POI API by adding it as a dependecy in Maven project
	 * 2. The Excel Util.java will give the path of the excel file  .
	 * 3. Create a method which will return the excel file data .
	 * 4. To hole the data which is in rows and columns , we need to use a 2D object
	 * array .
	 * 5. Inside the test class will will create a data provider component.
	 * 6. A mapping between data provider and  Test method should be performed
	 *  
	 *
     */
	
	public static String  TEST_DATA_SHEET_PATH= "C:\\Users\\MohanaKrishnanRajara\\eclipse-workspace\\Project1\\Jan2020\\src\\main\\java\\com\\qa\\huspot\\testdata\\Hubspotdata.xlsx";
	
	public static Workbook book;
	public static Sheet sheet;
	
	
	
	public static Object[][]  getTestdata( String sheetname) {
		
		try {
			
			FileInputStream file = new  FileInputStream(TEST_DATA_SHEET_PATH);
			
			book =	WorkbookFactory.create(file);
				
		sheet =	book.getSheet(sheetname);
		
		Object data [][]   = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; // intanziating 2-D object array and storying the number of 
		// rows and column
		
		for (int i = 0;i<sheet.getLastRowNum();i++) { // for iterating the rows 
			
			for (int k = 0;k<sheet.getRow(0).getLastCellNum();k++) { // for iterating the column 
				
				data [i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
			
			
		}
	
		 return data ; // try block return
		 
		} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						 // workbookfactory class
						
		e.printStackTrace();
		
				 
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   return null; // if we are unable to read the data , we return null
	}
	
}
     

