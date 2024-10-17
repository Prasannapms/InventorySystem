package Ecommerce;

public class EcommerceSystem {
	
	public static void main(String[] args) {
		
		//create Users
		User user1 = new User("U001", "Prasanna", "prs@example.com");
		User user2 = new User("U002", "Neela", "Neel@example.com");
		
		//create products
		Product product1 = new Product("P001", "Laptop",19999.99);
		Product product2 = new Product("P002", "Smartphone", 4999.99);
		Product product3 = new Product("P003","HeadPhone",199.99);
		
		//User1 creates an order
		user1.createOrder();
		Order order1 = user1.viewOrders().get(0);
		order1.addProduct(product1);
		order1.addProduct(product2);
		
		//user 1 processes payment
		Payment payment1 = new Payment("PAY001", 24999.98);
		payment1.processPayment();
		order1.setPayment(payment1);
		order1.setStatus("Completed");
		
		//Display order details
		displayOrderDetails(user1,order1);
		
		//User2 creates an order
		user2.createOrder();
		Order order2 = user2.viewOrders().get(0);
		order2.addProduct(product3);
		
		//User2 processes payment
		Payment payment2 = new Payment("PAY002" ,199.9);
		payment2.processPayment();
		order2.setPayment(payment2);
		order2.setStatus("completed");
		
		//Display order details for user2
		displayOrderDetails(user2,order2);
	}
	
        private static void displayOrderDetails(User user, Order order)
        {
        	System.out.println("User:" +user.getName());
    		System.out.println("Order Status:" +order.getStatus());
    		System.out.println("Ordered Products:");
    		for(Product product : order.getProducts()) {
    			System.out.println("-" +product.getDetails());
    		}
    		System.out.println();
        	
      
		
	}

}
