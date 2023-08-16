package commonUtility;
/**
 * 
 */


import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @author SATISH
 *
 */
public class JavaUtlity {

	/**
	 * this method generate the random number
	 */
	public int randamNumberGeneration()
	{
		Random ran = new Random();
		int random = ran.nextInt(500);
		return random;
		}
	/**
	 * this method returns system data
	 */
	public String systemDate()
	{
		Date d = new Date();
		String dateInStringFormat = d.toString();
		return dateInStringFormat;
		}
	/**
	 * this method returns system data in simple date format
	 * 
	 */
	public String systemDateInFormat()
	{
		SimpleDateFormat sdf= new SimpleDateFormat("dd/mm/yyy hh-MM-ss");
		Date d = new Date();
		String finalDate = sdf.format(d);
		return finalDate;
	}

}
