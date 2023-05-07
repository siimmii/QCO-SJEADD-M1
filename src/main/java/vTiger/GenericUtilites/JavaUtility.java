package vTiger.GenericUtilites;

import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic method related to java
 * @author akhil
 *
 */
public class JavaUtility {
	
	/**
	 * This method will generate random number for every run
	 * @return
	 */
    public int getRandomNumber()
    {
    	Random r=new Random();
    	 return r.nextInt(1000);
    }
    
    /*
     * This method will generate system Date
     */
     public String getSystemDate()
     {
    	 Date d=new Date();//from java util package
    	 return d.toString();//op---->Thu Apr 06 11:41:38 IST 2023
     }
    
   
     /**
      * This methd will generte system date in specific format
      * @return
      */
    public String getSystemDateinFormat()
    {
    	Date d=new Date();
    	String[] dArr=d.toString().split(" ");
    	String day=dArr[2];
    	String month=dArr[1];
    	String year=dArr[5];
    	String time=dArr[3].replace(":", "-");
    	
    	String date=day+"-"+month+"-"+year+"-"+time;//op---->06-Apr-2023-11-55-09
    	return date;
    	
    }
    
    
    
    
}
