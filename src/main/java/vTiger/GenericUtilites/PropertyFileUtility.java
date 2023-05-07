package vTiger.GenericUtilites;
/**
 * This class consists of generic methods related to properties
 * @author akhil
 *
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	
	/**
	 * This method will read from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFormPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(ConstantUtility.propertyFilePath);
		Properties pObj=new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
}
