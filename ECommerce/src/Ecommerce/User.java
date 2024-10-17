package Ecommerce;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String userID;
	private String name;
	private String email;
	private List<Order> orders;
	
	public User(String userID, String name, String email) {
		this.userID = userID;
		this.name = name;
		this.email = email;
		this.orders = new ArrayList<>();
		
	}
	
	public void createOrder() {
		Order newOrder = new Order();
		orders.add(newOrder);
		
	}
	
	public List<Order> viewOrders() {
		return orders;
	}
	
	public String getName() {
		return name;
	}
	

}
