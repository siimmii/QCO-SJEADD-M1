package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Step 1:Open the document in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestDataCh.xlsx");
		
		//Step2:Create Workbook using workbook factory
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step3:Get the control of the sheet
		Sheet sheet = wb.getSheet("ContactSheet");
		
		//Step 4:Get the control of the row
		Row row = sheet.createRow(10);
		
		//Step 5:Get the Control of the cell
		Cell cell = row.createCell(7);
		
		//Step 6:Set the value into the cell
		cell.setCellValue("BatMan");;
		
		//stpe 7:open the file in writable format
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestDataCh.xlsx");
		
		//Step 8:write the data into the workbook
		wb.write(fos);
		
		//Step 9:Close the workbook
		wb.close();
		System.out.println("data added and work book closed");
	}

}
