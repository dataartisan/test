import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.CommunicationsException;

public class DBInteraction{

	protected Connection conn = null;
	protected Statement smt = null;
	static final String url = "jdbc:mysql://localhost:3306/";
	static final String user = "root";
	static final String password = "hello";
	static final String dbName = "softwareengineering";	
	

	/**
	 * Sets Connection
	 */
	public Connection getConnection()
	{
		try
		{
			conn = DriverManager.getConnection(url+dbName, user, password);

		}		
		catch(CommunicationsException e)
		{
			System.out.println(e.getMessage());
		}
		catch(SQLException ex)
		{
			System.out.println("Connection could not be established " + ex.toString());

		}
		return conn;
	}
	
	
	}	   


	
		

