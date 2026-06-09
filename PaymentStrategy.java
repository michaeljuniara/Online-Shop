public interface PaymentStrategy {
    void processPayment(AppContext context, double amount);
}