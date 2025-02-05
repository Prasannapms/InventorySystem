package inventorySystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryManagementSystem {
	
	public static void processOrders(List<Product> inventory, List<Map<String, Integer>> salesOrders) {
		for(Map<String, Integer> order: salesOrders) {
			for(Map.Entry<String, Integer> entry : order.entrySet()) {
				String productId = entry.getKey();
				int quantityOrdered = entry.getValue();
				
				//Find the product in the inventory
				Product product = findproductById(inventory, productId);
				if(product != null) {
					if(product.getstockLevel() >= quantityOrdered) {
						product.reduceStock(quantityOrdered);
						System.out.println("Processed order for" +quantityOrdered+ "units of" +product.getName());
					} else {
						System.out.println("Error: Not enough stock for" +product.getName()+ ".Available:" +product.getstockLevel());
					}
					
					//check if restocking is needed
					if(product.getstockLevel()<10) {
						System.out.println("Alert: Low stock for" +product.getName()+".Consider restocking.");
					}
					
				} else {
					System.out.println("Error: product ID" + productId + "not found in inventory.");
				}
			}
		}
	}
	
	//Function to restock items in the inventory
	public static void restockItems(List<Product> inventory, Map<String, Integer> restockOrders) {
		for (Map.Entry<String, Integer> entry: restockOrders.entrySet()) {
			String productid = entry.getKey();
			int quantityRestock = entry.getValue();
			
			//Find the product in the inventory
			Product product = findproductById(inventory, productid);
			if(product != null) {
				product.restock(quantityRestock);
				System.out.println("Restocked" +quantityRestock+ "units of" +product.getName());
			}else {
				System.out.println("Error: product ID " + productid+ "not found in Inventory.");
			}
		}
	}
	
	//Helper method to find a product by its ID
	private static Product findproductById(List<Product> inventory,String productId) {
		for(Product product : inventory) {
			if(product.getProductId().equals(productId)) {
				return product;
			}
		}
		return null; //product not found
	}



public static void main(String[] args) {
	//sample inventory
	List<Product> inventory = new ArrayList<>();
	inventory.add(new Product("P001", "Laptop", 15));
	inventory.add(new Product("P002" , "Smartphone",8));
	inventory.add(new Product("P003" , "Headphones" , 20));
	
	//sample sales orders
	List<Map<String, Integer>> salesOrders = new ArrayList<>();
	Map<String, Integer> order1 = new HashMap<>();
	order1.put("P001", 2);
	order1.put("P002", 5);
	salesOrders.add(order1);
	
	Map<String, Integer> order2= new HashMap<>();
	order2.put("P002", 4);
	order2.put("P003", 1);
	salesOrders.add(order2);
	
	//process order
	processOrders(inventory, salesOrders);
	
	//sample restock orders
	Map<String, Integer> restockOrders = new HashMap<>();
	restockOrders.put("P002", 10);  //Restock 10 units of smartphone
	restockOrders.put("P001", 5);   //Restock 5 units of Laptop
	
	//Restock items
	restockItems(inventory,restockOrders);
}
}