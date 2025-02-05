package Ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private String orderID;
	private String status;
	private List<Product> products;
	private Payment payment;
	
	public Order() {
		this.products = new ArrayList<>();
		this.status = "pending";
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}
