import java.sql.SQLException;


public class Application {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		DBInteraction dbInter = new DBInteraction();
		dbInter.RemoveProduct(25);
		
		
		
	}
	
	public static void RemoveProduct(int productID)
	{
		DBInteraction dbInter = new DBInteraction();
		try {
			dbInter.RemoveProduct(productID);
			System.out.println("Product removed successfully.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Product could not be removed.");
		}
	}
	
	public static void CreateProduct(int CategoryID, String productDescription, boolean IsTaxable, int priceSchemeID) throws SQLException
	{
		DBInteraction dbInter = new DBInteraction();
		dbInter.CreateProduct(CategoryID, productDescription, IsTaxable, priceSchemeID);
		
	}

}

