public class QRIS implements PaymentStrategy {
    @Override
    public void pay(double totalPrice) {
        System.out.println("\n--- QRIS ---");
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
        System.out.println("Pembayaran QRIS Berhasil!"); // Display Sesudah
        System.out.printf("Nominal: Rp. %.2f\nBayar : ", totalPrice);
    }
}
