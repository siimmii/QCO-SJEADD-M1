package vTiger.GenericUtilites;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



/**
 * This class will contains methods related to Excel file Utility
 * 
 * @author akhil
 *
 */
public class ExcelFileUtility {
	
	/**
	 * This method will read data from property file
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String sheetName,int rowNum,int celNum) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream(ConstantUtility.excelFilePath);
		Workbook wBook=WorkbookFactory.create(fis);
		Sheet sh= wBook.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.getCell(celNum);
		String value=cel.getStringCellValue();
		wBook.close();
		return value;
		
	}
	
	/**
	 * This method will write the data into excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param value
	 * @throws IOException
	 */
	public void writeDataInToExcel(String sheetName,int rowNum,int celNum,String value) throws IOException
	{
		FileInputStream fis=new FileInputStream(ConstantUtility.excelFilePath);
		Workbook wBook=WorkbookFactory.create(fis);
		Sheet sh= wBook.getSheet(sheetName);
		Row row = sh.createRow(rowNum);
		Cell cel = row.createCell(celNum);
		cel.setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(ConstantUtility.excelFilePath);
		wBook.write(fos);
		wBook.close();
	}
	
	/**
	 * This method will capture all the data inside a sheet for dataProvider
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDataFromExcel(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(ConstantUtility.excelFilePath);
//		Workbook book=WorkbookFactory.create(fis);
//		Sheet sh=book.getSheet(SheetName);
//		
//		int lastRow=sh.getLastRowNum();
//		int lastCel=sh.getRow(0).getLastCellNum();
//		
//		Object[][] data=new Object[lastRow][lastCel];
//		
//		for(int i=0;i<lastRow;i++)
//		{
//			for(int j=0;j<lastCel;j++)
//			{
//				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
//			}
//		}
//		return data;
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		Object[][] data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
				return data;
	}
}
