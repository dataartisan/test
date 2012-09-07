
import java.sql.SQLException;


public class Application {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException  {
		
		//loadPriceScheme(90001);
		//CreatePriceScheme(90006, 1, 10, "test1");
		//storePriceScheme(90006, 1, 30, "test3");
		//removePriceScheme(90006);
		//LoadProduct(1);
		//CreateProduct(1, 90002, "Intro to History", false);
		//storeProduct(1, 1, 90001, "TSPi", 0);
		//RemoveProduct(6);
		//LoadProductPriceScheme(2);
		//LoadCategories();
		
	}
	
	//Update Product
	public static void storeProduct(int ProductID, int CategoryID, int PricingSchemeID, String ProductDesc, int IsTaxable) throws SQLException
	{
		Operations op = new Operations();
		op.storeProduct(ProductID, CategoryID, PricingSchemeID, ProductDesc, IsTaxable);
	}
	//Loads the product
	public static void LoadProduct(int productID)
	{
		Operations operation = new Operations();
		operation.getProducts(productID);
	}
	
	//Removes the product
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
	//removes the pricing scheme
	public static void removePriceScheme(int priceSchemeID) throws SQLException
	{
		Operations operation = new Operations();
		operation.removePriceScheme(priceSchemeID);
				
	}
	
	//creates a product
	public static void CreateProduct(int CategoryID, int PricingSchemeID, String productDescription, boolean IsTaxable) throws SQLException
	{
		Operations operation = new Operations();
		operation.CreateProduct(CategoryID, PricingSchemeID, productDescription, IsTaxable);
		System.out.println("Product: " + productDescription + " with pricing scheme: " + PricingSchemeID + " created successfully.");
		
	}
	
	//creates a pricing scheme
	public static void CreatePriceScheme(int PriceSchemePricesID, int Quantity, float Price, String PricingSchemeDesc) throws SQLException
	{
		Operations operation = new Operations();
		operation.CreatePriceScheme(PriceSchemePricesID, Quantity, Price, PricingSchemeDesc);
		System.out.println("Price Scheme: " + PriceSchemePricesID + " for quantity: " + Quantity + " Price: " + Price
				+ " and Price Scheme Description: " + PricingSchemeDesc + " was created.");
		
	}
	
	//loads the pricing scheme associated with a given product
	public static void LoadProductPriceScheme(int ProductID)
	{
		Operations op = new Operations();
		op.getProductPricingScheme(ProductID);
	}
	
	//loads a pricing scheme
	public static void loadPriceScheme(int PriceSchemePricesID)
	{
		Operations op = new Operations();
		op.loadPriceScheme(PriceSchemePricesID);
	}
	
	//updates the existing pricing scheme
	public static void storePriceScheme(int priceSchemeID, int Quantity, float Price, String PricingSchemeDesc) throws SQLException
	{
		Operations op = new Operations();
		op.storePriceScheme(priceSchemeID, Quantity, Price, PricingSchemeDesc);
	}
	
	//loads all the categories available
	public static void LoadCategories()
	{
		Operations op = new Operations();
		op.getCategory();
	}
}
