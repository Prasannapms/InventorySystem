package Ecommerce;

public class Payment {
	
	private String paymentID;
	private double amount;
	
	public Payment(String paymentID, double amount) {
		this.paymentID = paymentID;
		this.amount = amount;
	}
	
	public void processPayment() {
		System.out.println("Payment of $" +String.format("%.2f", amount)+"processed.");
	}

}
