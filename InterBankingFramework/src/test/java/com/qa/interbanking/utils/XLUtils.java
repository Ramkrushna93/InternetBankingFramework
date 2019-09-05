package com.qa.interbanking.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	 
	 public static XSSFWorkbook wb;
	 public static  XSSFSheet xs;
	 public static FileInputStream fi;
	 public static XSSFRow row;
	 public static XSSFCell cell;
	 public static FileOutputStream fo;
	
	public static void setExcelFiles(String xlfiles, String xlsheet) throws Exception {
		
		try {
			
			FileInputStream excelfile=new FileInputStream(xlfiles);
			wb=new XSSFWorkbook(excelfile);
			xs=wb.getSheet("xlsheet");
		}
		catch(Exception e) {
		throw (e);
		}
		
	}
		public static int getRowCount(String xlfiles, String xlsheet) throws IOException  {
			
			fi=new FileInputStream(xlfiles);
			wb=new XSSFWorkbook(fi);
			xs=wb.getSheet(xlsheet);
			int rowcont=xs.getLastRowNum();
			wb.close();
			fi.close();
			return rowcont;
				
		}
		
		public static int getCellCount(String xlfiles, String xlsheet, int rownum) throws IOException {
			
			fi=new FileInputStream(xlfiles);
			wb=new XSSFWorkbook(fi);
			xs=wb.getSheet(xlsheet);
			row=xs.getRow(rownum);
			int cellcount=row.getLastCellNum();
			wb.close();
			fi.close();
			return cellcount;
		}
		
			public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
			{
				fi=new FileInputStream(xlfile);
				wb=new XSSFWorkbook(fi);
				xs=wb.getSheet(xlsheet);
				row=xs.getRow(rownum);
				cell=row.getCell(colnum);
				String data;
				try 
				{
					DataFormatter formatter = new DataFormatter();
		            String cellData = formatter.formatCellValue(cell);
		            return cellData;
				}
				catch (Exception e) 
				{
					data="";
				}
				wb.close();
				fi.close();
				return data;
			}
			
			public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
			{
				fi=new FileInputStream(xlfile);
				wb=new XSSFWorkbook(fi);
				xs=wb.getSheet(xlsheet);
				row=xs.getRow(rownum);
				cell=row.createCell(colnum);
				cell.setCellValue(data);
				fo=new FileOutputStream(xlfile);
				wb.write(fo);		
				wb.close();
				fi.close();
				fo.close();
			}
		
	
	
	
	

}
