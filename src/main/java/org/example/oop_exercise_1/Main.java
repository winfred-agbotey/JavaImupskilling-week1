package org.example.oop_exercise_1;

public class Main {
    public static void main(String[] args) {
        // Use CreditCardPayment strategy
        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9101-1121", "John Doe");
        PaymentProcessor processor1 = new PaymentProcessor(creditCard);
        processor1.processPayment(250.00);

        // Use PayPalPayment strategy
        PaymentStrategy payPal = new PayPalPayment("john@example.com");
        PaymentProcessor processor2 = new PaymentProcessor(payPal);
        processor2.processPayment(100.00);

        // Use BitcoinPayment strategy
        PaymentStrategy bitcoin = new BitcoinPayment("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa");
        PaymentProcessor processor3 = new PaymentProcessor(bitcoin);
        processor3.processPayment(500.00);
    }
}
