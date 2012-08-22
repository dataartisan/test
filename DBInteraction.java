import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
	
	public Product[] getProducts(int productID)
	{
		DBInteraction d = new DBInteraction();
		Product[] p = new Product[productID];
		int counter = 0;
		
		
		Connection conn = getConnection();
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("{CALL LoadProduct(?)}");
			while (rs.next() && counter < productID)
			{	

					p[counter] = new Product();
					p[counter].setProductName(rs.getString("ProductDesc"));
					p[counter].setIsTaxable(rs.getBoolean("IsTaxable"));
					p[counter].setCategory(rs.getString("wins"));
					//p[counter].setNumberOfPlays(rs.getInt("plays"));
					counter++;			

			}
			
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		
		catch (SQLException e) {
			System.out.println("Error occured while registering." + e.getMessage());
		}
		
		
		return p;
		
	}
	public boolean CreateProduct(int CategoryID, String productDescription, boolean IsTaxable, int priceSchemeID)
	{
		Connection conn = getConnection();
		try {
			CallableStatement cs = conn.prepareCall("{CALL CreateProduct(?, ?, ?, ?)}");
			cs.setInt(1, CategoryID);
			cs.setString(2, productDescription);
			cs.setBoolean(3, IsTaxable);
			cs.setInt(4, priceSchemeID);
			cs.executeQuery();	

		} 
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		
		catch (SQLException e) {
			System.out.println("Error occurred while registering." + e.getMessage());
		}	
		return true;
	}
	
	
	/**
	 * 
	 * @return 
	 * @throws SQLException 
	*/
	public void RemoveProduct(int productID) throws SQLException
	{
		Connection conn = getConnection();
		try {
			CallableStatement cs = conn.prepareCall("{CALL removeProduct(?)}");			
			cs.setInt(1, productID);
			cs.executeQuery();
			System.out.println("ProductID: " + productID + " removed successfully.");

		} 
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		
		catch (SQLException e) {
			System.out.println("Error occurred while removing product: " + e.getMessage());
		}	
		//return true;
	}
	 
		

}

