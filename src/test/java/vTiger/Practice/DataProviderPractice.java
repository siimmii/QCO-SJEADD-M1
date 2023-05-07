package vTiger.Practice;


import org.testng.annotations.DataProvider;

public class DataProviderPractice {

	
	
	
	@org.testng.annotations.Test(dataProvider = "getData")
	public void sampleTest(String Phonename,int price)
	{
		System.out.println(Phonename+"----->"+price);
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[3][2];
		
		data[0][0]="Samsung";
		data[0][1]=12000;
		
		data[1][0]="Nokia";
		data[1][1]=12000;
		
		data[2][0]="Iphone";
		data[2][1]=12000;
		
		
		return data;
	}
	
}
