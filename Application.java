
import java.sql.SQLException;


public class Application {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException  {
		
		LoadProduct(1);
		//getPriceSchemeDesc(2);
		//CreateProduct(1, 90002, "Intro to History", false);
		//RemoveProduct(6);
		LoadCategories();
		//CreatePriceScheme(90006, 1, 10, "test1");
		
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
	
	public static void CreateProduct(int CategoryID, int PricingSchemeID, String productDescription, boolean IsTaxable) throws SQLException
	{
		Operations operation = new Operations();
		operation.CreateProduct(CategoryID, PricingSchemeID, productDescription, IsTaxable);
		System.out.println("Product: " + productDescription + " with pricing scheme: " + PricingSchemeID + " created successfully.");
		
	}
	
	
	public static void CreatePriceScheme(int PriceSchemePricesID, int Quantity, float Price, String PricingSchemeDesc) throws SQLException
	{
		Operations operation = new Operations();
		operation.CreatePriceScheme(PriceSchemePricesID, Quantity, Price, PricingSchemeDesc);
		System.out.println("Price Scheme: " + PriceSchemePricesID + " for quantity: " + Quantity + " Price: " + Price
				+ " and Price Scheme Description: " + PricingSchemeDesc + " was created.");
		
	}
	
	public static void getPriceSchemeDesc(int ProductID)
	{
		Operations op = new Operations();
		op.getProductPricingScheme(ProductID);
	}
	
	public static void LoadCategories()
	{
		Operations op = new Operations();
		op.getCategory();
	}
	
	

}
