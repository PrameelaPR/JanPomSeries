package com.qa.hubspot.util;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.hubspot.constants.Constant;

public class TestUtil {

	public static Workbook book;
	public static Sheet sheet;
	


	public static void shortWait(){
		try {
			Thread.sleep(Constant.Short_Wait);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void longWait(){
		try {
			Thread.sleep(Constant.Long_wait);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void mediumWait(){
		try {
			Thread.sleep(Constant.Medium_wait);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	

	public static Object[][] getTestData(String sheetName){
		FileInputStream file=null;


		try {
			file=new FileInputStream(Constant.TESTDATA_SHEET_PATH);//connection to the file
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			book=WorkbookFactory.create(file);//create a copy of the file
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sheet=book.getSheet(sheetName);//get the sheet from the bookname
		System.out.println("Size "+sheet.getLastRowNum() + "   "+sheet.getRow(0).getLastCellNum());
		Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for(int i=0;i<sheet.getLastRowNum();i++){

			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++){

				data[i][k]=sheet.getRow(i+1).getCell(k).toString();

			}
		}
		return data;

	}






}
