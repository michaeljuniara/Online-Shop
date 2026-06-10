public class QRIS implements PaymentStrategy {
    @Override
    public void showMetode(double totalPrice) {
        String[] qrPattern = {
            "█████████████████████",
            "█   █   █     █ █   █",
            "█ █ █ █ █ ███ █ █ █ █",
            "█ █ █ █ █ ███ █ █ █ █",
            "█   █   █     █ █   █",
            "█████████████████████",
            "█     █   █   █     █",
            "█ ███ █ ███ █ █ ███ █",
            "█ ███ █ █ █ █ █ ███ █",
            "█     █ ███ █ █     █",
            "█████████████████████"
        };
        for (String row : qrPattern) {
            System.out.println("  " + row);
        }   
        System.out.println("\nID Merchant: ID1234567890");
        System.out.printf("Nominal: Rp. %.2f\nBayar : ", totalPrice);
        
    }
    @Override
    public boolean pay(double totalPrice, double nominal) {
        if (totalPrice == nominal){
            System.out.println("\n--- QRIS ---");
            System.out.println("Pembayaran QRIS Berhasil!"); // Display Sesudah
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
