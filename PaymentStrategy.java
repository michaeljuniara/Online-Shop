public interface PaymentStrategy {
    boolean pay (double totalPrice, double nominal);
    void showMetode(double totalPrice);
}