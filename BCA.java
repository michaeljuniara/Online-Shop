public class BCA implements PaymentStrategy {
    @Override
    public void pay(double totalPrice) {
        System.out.println("\n--- [BCA VIRTUAL ACCOUNT] ---");
        System.out.println("Pembayaran BCA Berhasil!"); // Display Sesudah 
        System.out.printf("Total tagihan: Rp. %.2f\n", totalPrice);
    }
}
