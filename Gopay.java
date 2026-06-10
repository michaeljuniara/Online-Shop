public class Gopay implements PaymentStrategy{
    @Override
    public void pay(double totalPrice) {
        System.out.println("\n--- [GOPAY] ---");
        System.out.println("Pembayaran Gopay Berhasil!"); // Display Sesudah
        System.out.printf("Total tagihan: Rp. %.2f\n", totalPrice);
    }
}
