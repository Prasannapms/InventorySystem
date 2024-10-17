package Ecommerce;

public class Product {
	
	private String productID;
	private String name;
	private double price;
	
	public Product(String productID, String name, double price) {
		this.productID = productID;
		this.name = name;
		this.price = price;
		
	}
	
	public String getDetails() {
		return name+ "-$" +String.format("%.2f", price); //formatting to 2 decimal places
	}
		
	
	}
