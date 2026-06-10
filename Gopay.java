public class Gopay implements PaymentStrategy{
    
    @Override
    public void showMetode(double totalPrice) {
        System.out.println("\n[GoPay]");
        System.out.println("Silakan transfer ke nomor : 081234567890");
        System.out.printf("Total tagihan: Rp. %.2f\nBayar : ", totalPrice);
    }

    @Override
    public boolean pay(double totalPrice, double nominal) {
        if (totalPrice == nominal){
            System.out.println("\n--- [GOPAY] ---");
            System.out.println("Pembayaran Gopay Berhasil!"); // Display Sesudah
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
