package StrategyPatternExample;

public class StrategyPatternDemo {

    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();

        // Pay using Credit Card
        context.setPaymentStrategy(new CreditCardPayment());
        context.executePayment(2500);

        // Pay using PayPal
        context.setPaymentStrategy(new PayPalPayment());
        context.executePayment(1800);
    }
}