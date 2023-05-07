package vTiger.Practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine {
	
	@Test
	public void readData()
	{
		String Bvalue=System.getProperty("browser");
		System.out.println(Bvalue);
		
		String Uvalue=System.getProperty("url");
		System.out.println(Uvalue);
		
		String Pvalue=System.getProperty("password");
		System.out.println(Pvalue);
	}

}
