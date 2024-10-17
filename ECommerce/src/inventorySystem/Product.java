package inventorySystem;

//product class to represent products in the inventory
public class Product {
	private String productId;
	private String name;
	private int stockLevel;
	
	public Product(String productId, String name, int stockLevel) {
		this.productId = productId;
		this.name = name;
		this.stockLevel = stockLevel;
	}
	
	public String getProductId() {
		return productId;
	}
	
	public String getName() {
		return name;
	}
	
	public int getstockLevel() {
		return stockLevel;
	}
	
	public void reduceStock(int quantity) {
		this.stockLevel -= quantity;
	}
	
	public void restock(int quantity) {
		this.stockLevel += quantity;
	}

}
