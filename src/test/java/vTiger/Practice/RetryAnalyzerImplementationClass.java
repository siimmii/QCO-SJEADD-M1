package vTiger.Practice;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class isa an implementatio class for IRetryAnalyzer of testng
 * 
 * @author akhil
 *
 */
public class RetryAnalyzerImplementationClass  implements IRetryAnalyzer {
	int count=0;
	int retryCount=3;
	public boolean retry(ITestResult result)
	{
		while(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
