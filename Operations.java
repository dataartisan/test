import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Operations {
	
	DBInteraction dbInter = new DBInteraction();
	
	public boolean CreateProduct(int CategoryID, String productDescription, boolean IsTaxable, int priceSchemeID)
	{
		Connection conn = dbInter.getConnection();
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
			System.out.println("Error occurred while creating product. " + e.getMessage());
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
		Connection conn = dbInter.getConnection();
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
		
	}
	
	public void getProducts(int productID)
	{
		
		
		Connection conn = dbInter.getConnection();
            
		
		try {
			CallableStatement cStmt = conn.prepareCall("{CALL LoadProduct(?)}");
			 cStmt.setInt(1, productID);
	           cStmt.execute();
	           ResultSet rs1 = cStmt.getResultSet();
	           while (rs1.next()) {
	                System.out.println("Product Name: " + rs1.getString("ProductDesc") + " " + ", Product Category: " + rs1.getString("CategoryDesc"));
	           }
	           rs1.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
          

           
       }
	
	
	 
}

