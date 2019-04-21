package com.velproj.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
public static FileInputStream fi;
public static FileOutputStream fo;
public static XSSFWorkbook wb;
public static XSSFSheet ws;
public static XSSFRow row;
public static XSSFCell cell;

public static int getRowCount(String xlPath, String xlName) throws IOException{
	fi=new FileInputStream(xlPath);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlName);
	int rowCount=ws.getLastRowNum();
	wb.close();
	fi.close();
	return rowCount;
}
public static int getColCount(String xlPath, String xlName) throws IOException{
	fi=new FileInputStream(xlPath);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlName);
	row=ws.getRow(1);
	int colCount=row.getLastCellNum();
	wb.close();
	fi.close();
	return colCount;
}

public static String getExcelData(String xlPath,String xlName,int row,int col) throws IOException{
	fi=new FileInputStream(xlPath);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlName);
	String cellData=ws.getRow(row).getCell(col).getStringCellValue();
	wb.close();
	fi.close();
	return cellData;
}
}
