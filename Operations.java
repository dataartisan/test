import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Operations {
	
	DBInteraction dbInter = new DBInteraction();
	
	/**
	 * Adds a product into the products table.
	 * Required fields are: CategoryID, PriceSchemeID, ProductName(description),
	 * and whether or not the product is taxable.
	 * @return 
	 * @throws SQLException 
	*/
	public boolean CreateProduct(int CategoryID, int PricingSchemeID, String productDescription, boolean IsTaxable)
	{
		Connection conn = dbInter.getConnection();
		try {
			CallableStatement cs = conn.prepareCall("{CALL CreateProduct(?, ?, ?, ?)}");
			cs.setInt(1, CategoryID);
			cs.setInt(2, PricingSchemeID);
			cs.setString(3, productDescription);
			cs.setBoolean(4, IsTaxable);
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
	 * Adds a new pricing scheme
	 * @return 
	 * @throws SQLException 
	*/
	public boolean CreatePriceScheme(int PriceSchemePricesID, int Quantity, float Price, String PricingSchemeDesc)
	{
		Connection conn = dbInter.getConnection();
		try {
			CallableStatement cs = conn.prepareCall("{CALL CreatePriceScheme(?, ?, ?, ?)}");
			cs.setInt(1, PriceSchemePricesID);
			cs.setInt(2, Quantity);
			cs.setFloat(3, Price);
			cs.setString(4, PricingSchemeDesc);
			cs.executeQuery();	
			//System.out.println("New Pricing Scheme created.");
		} 
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		
		catch (SQLException e) {
			System.out.println("Error occurred while creating pricing Scheme. " + e.getMessage());
		}	
		return true;
	}
	
	/**
	 * Removed a product by ProductID
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
	/**
	 * Returns the product with Name and Category name
	 * @param productID
	 */
	public void getProducts(int productID)
	{
		
		
		Connection conn = ((DBInteraction) dbInter).getConnection();
            
		
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
	/**
	 * Returns the product and all the pricing scheme attached to the product
	 * @param productID
	 */
	public void getProductPricingScheme(int productID)
	{
		
		
		Connection conn = ((DBInteraction) dbInter).getConnection();
            
		
		try {
			CallableStatement cStmt = conn.prepareCall("{CALL LoadPriceScheme(?)}");
			 cStmt.setInt(1, productID);
	         cStmt.execute();
	           ResultSet rs1 = cStmt.getResultSet();
	           while (rs1.next()) {
	                System.out.println("Product Name: " + rs1.getString("ProductDesc") + " " + ", Number of Items: " + rs1.getInt("Quantity")
	                		+ ", Price: " + rs1.getInt("Price") + ", Price Scheme description: " + rs1.getString("PricingSchemeDesc") );
	           }
	           rs1.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
          

           
   }
	
	/**
	 * Returns the product and all the pricing scheme attached to the product
	 * @param productID
	 */
	public void getCategory()
	{
		
		
		Connection conn = ((DBInteraction) dbInter).getConnection();
            
		
		try {
			CallableStatement cStmt = conn.prepareCall("{CALL LoadCategory}");
			 
	         cStmt.execute();
	           ResultSet rs1 = cStmt.getResultSet();
	           while (rs1.next()) {
	                System.out.println("CategoryID: " + rs1.getInt("CategoryID") + ", Category Description " + rs1.getString("CategoryDesc") );
	           }
	           rs1.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
          

           
   }
	
	
	
	
	
	 
}
