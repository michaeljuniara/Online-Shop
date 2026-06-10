public class BCA implements PaymentStrategy {

    @Override
    public void showMetode(double price) {
        System.out.println("\n[BCA Virtual Account]");
        System.out.println("Silakan transfer ke nomor : 88099 081234567890");
        System.out.printf("Total tagihan: Rp. %.2f\nBayar : ", price);
    }

    @Override
    public boolean pay(double totalPrice, double nominal) {
        if (totalPrice == nominal){
            System.out.println("\n--- [BCA VIRTUAL ACCOUNT] ---");
            System.out.println("\nPembayaran BCA Berhasil!"); // Display Sesudah 
            return true;
        }
        else if (totalPrice < nominal){
            System.out.println("\nNominal yang ditransfer lebih");
        }
        else{
            System.out.println("\nNominal yang ditransfer kurang");
        }
        return false;
    }
}
