package commonUtility;
/**
 * 
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * @author SATISH
 *
 */
public class FileUtility {

	/**
	 * this data will read the data from property file
	 * @author SATISH
	 * @return
	 * @throws Throwable 
	 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstantsUtility.propertyFilePath);
				Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
}
