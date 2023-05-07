package vTiger.Practice;

import java.io.IOException;

import vTiger.GenericUtilites.ExcelFileUtility;
import vTiger.GenericUtilites.JavaUtility;
import vTiger.GenericUtilites.PropertyFileUtility;

public class GenericutilityPracctice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		JavaUtility jUtil=new JavaUtility();
		int value=jUtil.getRandomNumber();
		System.out.println(value);
		
		System.out.println(jUtil.getSystemDate());
		System.out.println(jUtil.getSystemDateinFormat());
		
		PropertyFileUtility pUtil=new PropertyFileUtility();
		System.out.println(pUtil.readDataFormPropertyFile("browser"));
		
		ExcelFileUtility eUtil=new ExcelFileUtility();
		System.out.println(eUtil.readDataFromExcelFile("OrganizationSheet", 1, 2));
		
		eUtil.writeDataInToExcel("OrganizationSheet", 15, 3, "simmi written from generic utility practice");
	}

}
