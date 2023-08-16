package commonUtility;
/**
 * 
 */
/**
 * @author SATISH
 *
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

class DatabaseUtility{
	Connection con=null;
	Statement state=null;
	ResultSet result =null;
	boolean flag;	
	/**
	 * This methods establish database connection
	 * 
	 * @throws SQLException 
	 */
	public void connectToDB() throws SQLException
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IPathConstantsUtility.dbURL,IPathConstantsUtility.dbUsername,IPathConstantsUtility.dbPassword);
	
	}
	
	/**
	 * This method executes quary and get data
	 * @throws Throwable 
	 */
	public void executeQuaryAndGetData(String quary,int column, String expectedData) throws Throwable
	{
	
		state=con.createStatement();
		 result=state.executeQuery(quary);	
		while(result.next())
		{
			String actualData = result.getString(column);
			if(actualData.equalsIgnoreCase(expectedData))
			{
				flag=true;
				System.out.println("Data is verified"+actualData);
				break;
			}
			else
			{
				System.out.println("Data is not matched");
			}
		}
	}
}