package vTiger.Practice;

import org.testng.annotations.Test;

public class DebuggingPracticeTest {

	@Test
	public void test()
	{
		System.out.println("this is main");
		System.out.println("divide is called");
		int c=div(10,0);
		System.out.println(c);
		System.out.println("division performed");

	}
	public static int div(int a,int b)
	{
		int c=a/b;
		return c;
	}

}
