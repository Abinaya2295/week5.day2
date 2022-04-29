package week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelServiceNow {

	public static String[][] readExcel() throws IOException {
		// Set the path of the Excel workbook
		XSSFWorkbook wb = new XSSFWorkbook(".//data//ServiceNow.xlsx");
		//Get into the sheet
		XSSFSheet ws = wb.getSheet("ServiceNow");
		
		//Get number of rows(It automatically exclude the header)
		int rowCount = ws.getLastRowNum();
		System.out.println(rowCount);
		
		//Get Rows count with header
		int totalRows = ws.getPhysicalNumberOfRows();
		System.out.println(totalRows);
		
		//Get the number of cells in header
		short cellCount = ws.getRow(0).getLastCellNum();
		System.out.println(cellCount);
		
		//Declare 2D String array 
		String[][] data = new String[rowCount][cellCount];
		
		//If we want get the entire row
		for(int i=1; i<=rowCount; i++)
		{
		XSSFRow row = ws.getRow(i);
		for(int j=0; j<cellCount; j++)
		{			
		//Get into first cell
		XSSFCell cell = row.getCell(j);		
		//retrieve the data
		String stringCellValue = cell.getStringCellValue();
		System.out.println(stringCellValue);
		data[i-1][j] = stringCellValue;
		}
		}
		wb.close();
		return data;
	}
}
