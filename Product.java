
public class Product {
	
	private int productId;
	private String productName;
	private String category;
	private boolean IsTaxable;
	
	public Product()
	{
		
	}
	
	public Product(int productID, String productName, String category, boolean IsTaxable)
	{
		this.productId = productID;
		this.productName = productName;
		this.category = category;
		this.IsTaxable = IsTaxable;
	}
	
	public int getProductID()
	{
		return this.productId;
	}
	
	public void setProductID(int ProductID)
	{
		this.productId = ProductID;
	}
	public String getProductName()
	{
		return this.productName;
	}
	
	public String getProductCategory()
	{
		return this.category;
	}
	
	public boolean getIsTaxable()
	{
		return this.IsTaxable;
	}
	
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	
	public void setCategory(String category)
	{
		this.category = category;
	}
	
	public void setIsTaxable(boolean IsTaxable)
	{
		this.IsTaxable = IsTaxable;
	}
}

