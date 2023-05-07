package vTiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFilePractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Step 1: Open the document in java readable format using file Input stream
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestDataCh.xlsx");
		
		//Step2:Create a Workbook using workbookFactory
		Workbook workBook = WorkbookFactory.create(fis);
		
		//Step 3:get the control of the sheet
		Sheet sheet = workBook.getSheet("OrganizationSheet");
		
		//step4 :get the control of row
		Row row = sheet.getRow(1);
		
		//Step 5:get the control of cell
		Cell cell = row.getCell(2);
		
		//step6:read the data inside the cell
		String OrgName = cell.getStringCellValue();
		
		
		System.out.println(OrgName);
		
		//Step7:Close the workbook
		workBook.close();
		
	}

}
