package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
	
	
	@Test(retryAnalyzer = vTiger.Practice.RetryAnalyzerImplementationClass.class)
	public void analysePracice()
	{
		Assert.fail();
		System.out.println("HI");
	}
}
