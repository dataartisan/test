import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Application {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args)  {
		
		//LoadProduct(6);
		//RemoveProduct(6);
		
	}
	public static void LoadProduct(int productID)
	{
		Operations operation = new Operations();
		operation.getProducts(productID);
	}
	public static void RemoveProduct(int productID)
	{
		Operations operation = new Operations();
		try {
			operation.RemoveProduct(productID);
			System.out.println("Product removed successfully.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Product could not be removed.");
		}
	}
	
	public static void CreateProduct(int CategoryID, String productDescription, boolean IsTaxable, int priceSchemeID) throws SQLException
	{
		Operations operation = new Operations();
		operation.CreateProduct(CategoryID, productDescription, IsTaxable, priceSchemeID);
		
	}
	
	

}

